package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.exception.StorageException;
import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeOfResume = 0;

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(int index);

    protected abstract int getIndex(String uuid);

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
            throw new ExistStorageException(resume.getUuid());
        } else if (sizeOfResume >= STORAGE_LIMIT) {
            throw new StorageException("Массив полон", resume.getUuid());
        } else {
            doSave(resume, index);
            sizeOfResume++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            doDelete(index);
            sizeOfResume--;
            storage[sizeOfResume] = null;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return storage[index];
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
}
