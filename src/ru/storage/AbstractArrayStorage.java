package ru.storage;

import ru.exception.NotExistStorageException;
import ru.exception.StorageException;
import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

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

    @Override
    protected void checkForStorageLimit(Resume resume) {
        if (sizeOfResume >= STORAGE_LIMIT) {
            throw new StorageException("Массив полон", resume.getUuid());
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
