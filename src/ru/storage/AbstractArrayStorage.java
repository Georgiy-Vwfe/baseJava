package ru.storage;

import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeOfResume = 0;

    public abstract void save(Resume resume);

    public abstract void delete(String uuid);

    public void update(Resume resume) {
        int i = checkError(resume.getUuid());
        if (i >= 0) {
            storage[i] = resume;
        }
    }

    public Resume get(String uuid) {
        int i = checkError(uuid);
        if (i >= 0) {
            return storage[i];
        }
        return null;
    }

    public void clear() {
        fill(storage, 0, sizeOfResume, null);
        sizeOfResume = 0;
    }

    public int size() {
        return sizeOfResume;
    }

    public Resume[] getAll() {
        return copyOfRange(storage, 0, sizeOfResume);
    }

    protected int checkError(String uuid) {
        int i = getIndex(uuid);
        if (i < 0) {
            System.out.println("Резюме " + uuid + " не существует или не может быть записано");
            return -1;
        }
        return i;
    }

    protected abstract int getIndex(String uuid);
}
