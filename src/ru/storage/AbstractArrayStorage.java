package ru.storage;

import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeOfResume = 0;

    public void save(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i > -1) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
        }
    }

    public void delete(String uuid) {
        if (getIndex(uuid) < 0) {
            System.out.println("Резюме " + uuid + " не существует");
            return;
        }
    }

    public void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i < 0) {
            System.out.println("Резюме " + resume.getUuid() + " не существует");
        } else {
            storage[i] = resume;
        }
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i < 0) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        } else {
            return storage[i];
        }
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

    protected abstract int getIndex(String uuid);
}
