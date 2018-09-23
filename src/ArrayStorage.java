import java.util.Arrays;

public class ArrayStorage {
    /**
     * Array based storage for Resumes
     */
    private Resume[] storage = new Resume[10_000];
    private int sizeOfResume = 0;

    void clear() {
        body(null, null,"clear");
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

    Resume update(Resume resume) {
        //bugs in update
        body(null,resume,"update");
        return null;
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
        if (!body(uuid, null, "delete")) {
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

    boolean body(String uuid, Resume resume, String nameOfFunction) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                switch (nameOfFunction) {
                    case "delete": {
                        storage[i] = storage[sizeOfResume - 1];
                        storage[sizeOfResume - 1] = null;
                        sizeOfResume--;
                        return true;
                    }
                    case "update": {
                        storage[i] = resume;
                        System.out.println("Резюме " + resume.uuid + " заменилось на " + resume.uuid);
                        return true;
                    }
                    default:
                        break;
                }
            }
        }
        switch (nameOfFunction) {
            case "delete": {
                return false;
            }
            case "clear": {
                for (int i = 0; i < sizeOfResume; i++) {
                    storage[i] = null;
                }
                sizeOfResume = 0;
                return true;
            }
            case "update":{
                System.out.println("Резюме " + resume.uuid + " не существует");
            }
        }
        return true;
    }
}
