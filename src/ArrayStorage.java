import java.util.Arrays;

public class ArrayStorage {

    private Resume[] storage = new Resume[10_000];
    private int sizeOfResume = 0;

    void clear() {
        Arrays.fill(storage, null);
        sizeOfResume = 0;
    }

    void save(Resume resume) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                System.out.println("Резюме " + resume.getUuid() + " уже введено");
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
        int i = getIndex(resume.getUuid());
        if (i == -1) {
            System.out.println("Резюме " + resume.getUuid() + " не существует");
        } else {
            storage[i] = resume;
        }
    }

    Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        } else return storage[i];
    }

    void delete(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме " + uuid + " не существует");
        } else {
            storage[i] = storage[sizeOfResume - 1];
            storage[sizeOfResume - 1] = null;
            sizeOfResume--;
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

    private int getIndex(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
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
