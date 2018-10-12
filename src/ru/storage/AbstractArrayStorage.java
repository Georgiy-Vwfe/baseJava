package ru.storage;

import ru.exception.StorageException;
import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final Integer STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected Integer sizeOfResume = 0;

    protected abstract void doSave(Integer sequence, Resume resume);

    protected abstract void doDelete(Integer index);

    @Override
    public void clear() {
        fill(storage, 0, sizeOfResume, null);
        sizeOfResume = 0;
    }

    @Override
    protected void saveEntity(Object index, Resume resume) {
        doSave((Integer) index, resume);
        sizeOfResume++;
    }

    @Override
    protected void deleteEntity(Integer index, String uuid) {
        doDelete(index);
        storage[sizeOfResume + 1] = null;
        sizeOfResume--;
    }

    @Override
    protected void doUpdate(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void checkForStorageLimit(Resume resume) {
        if (sizeOfResume >= STORAGE_LIMIT) {
            throw new StorageException("Массив полон", resume.getUuid());
        }
    }

    @Override
    protected Resume doGet(Object index, String uuid) {
        return storage[(Integer) index];
    }

    @Override
    public Resume[] getAll() {
        return copyOfRange(storage, 0, sizeOfResume);
    }

    @Override
    public int size() {
        return sizeOfResume;
    }
}
