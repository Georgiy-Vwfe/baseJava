package ru.storage;

import ru.exception.StorageException;
import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void doDelete(int index);

    @Override
    public void clear() {
        fill(storage, 0, sizeOfResume, null);
        sizeOfResume = 0;
    }

    @Override
    protected void doDelete(int index, String uuid) {
        doDelete(index);
        storage[sizeOfResume + 1] = null;
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void checkForStorageLimit(Resume resume) {
        if (sizeOfResume >= STORAGE_LIMIT) {
            throw new StorageException("Массив полон", resume.getUuid());
        }
    }

    @Override
    protected Resume doGet(int index, String uuid) {
        return storage[index];
    }

    @Override
    public Resume[] getAll() {
        return copyOfRange(storage, 0, sizeOfResume);
    }
}
