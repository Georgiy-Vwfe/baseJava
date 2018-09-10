import java.util.Arrays;

public class ArrayStorage {
    /**
     * Array based storage for Resumes
     */
    private Resume[] storage = new Resume[10000];
    private int sizeOfArray = 0;

    void clear() {
        for (int i = 0; i < sizeOfArray; i++) {
            storage[i] = null;
        }
        sizeOfArray = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Резюме " + r.uuid + " уже введено");
                return;
            }
        }
        if (sizeOfArray < storage.length) {
            storage[sizeOfArray] = r;
            sizeOfArray++;
            return;
        }
        if (sizeOfArray == storage.length) {
            System.out.println("Массив полон");
            return;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            } else break;
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[sizeOfArray - 1];
                storage[sizeOfArray - 1] = null;
                sizeOfArray--;
                return;
            } else {
                System.out.println("Резюме не существует");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, sizeOfArray);
    }

    int size() {
        return sizeOfArray;
    }
}
