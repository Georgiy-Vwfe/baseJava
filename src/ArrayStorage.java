import java.util.Arrays;

public class ArrayStorage {
    /**
     * Array based storage for Resumes
     */
    private Resume[] storage = new Resume[10_000];
    private int sizeOfResume = 0;

    void clear() {
        for (int i = 0; i < sizeOfResume; i++) {
            storage[i] = null;
        }
        sizeOfResume = 0;
    }

    void save(Resume resume) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                System.out.println("Резюме " + resume.uuid + " уже введено");
                return;
            }
        }
        if (sizeOfResume < storage.length) {
            storage[sizeOfResume] = resume;
            sizeOfResume++;
        } else if (sizeOfResume == storage.length) {
            System.out.println("Массив полон");
        }
    }

    void update(Resume resume) {
        get() = resume;
        System.out.println("Резюме " + resume.uuid + " заменилось на " + resume.uuid);
    }

    int getForUpdate(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
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
        storage[forAndIf(uuid)] = storage[sizeOfResume - 1];
        storage[sizeOfResume - 1] = null;
        sizeOfResume--;
        if (forAndIf(uuid) == -1) {
            System.out.println("Резюме " + uuid + " не существует");
        }
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

    int forAndIf(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

//    Runnable r1 = new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    };
//
//    public void loop(Runnable runnable, String uuid) {
//        for (int i = 0; i < sizeOfResume; i++) {
//            if (storage[i].uuid.equals(uuid)) {
//                runnable.run();
//            }
//        }
//    }

}
