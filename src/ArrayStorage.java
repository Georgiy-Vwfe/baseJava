import java.util.Arrays;

public class ArrayStorage {
    /**
     * Array based storage for Resumes
     */
    private Resume[] storage = new Resume[10000];
    private int sizeOfResume = 0;

    void clear() {
        for (int i = 0; i < sizeOfResume; i++) {
            storage[i] = null;
        }
        sizeOfResume = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Резюме " + r.uuid + " уже введено");
                return;
            }
        }
        if (sizeOfResume < storage.length) {
            storage[sizeOfResume] = r;
            sizeOfResume++;
            return;
        }
        if (sizeOfResume == storage.length) {
            System.out.println("Массив полон");
            return;
        }
    }

    void update(String uuid, Resume r) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = r;
                System.out.println("Резюме " + uuid + " заменилось на " + r.uuid);
                return;
            }
        }
        System.out.println("Резюме " + r.uuid + " не существует");
    }

    Resume get(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме " + uuid + " не существует");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[sizeOfResume - 1];
                storage[sizeOfResume - 1] = null;
                sizeOfResume--;
                return;
            }
        }
        System.out.println("Резюме " + uuid + " не существует");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, sizeOfResume);
    }

    int size() {
        return sizeOfResume;
    }
}
