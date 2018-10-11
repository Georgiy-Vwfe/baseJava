package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected int sizeOfResume = 0;

    protected abstract void doSave(int index, Resume resume);

    protected abstract void doDelete(int index, String uuid);

    protected abstract void doUpdate(int index, Resume resume);

    protected abstract Resume doGet(int index, String uuid);

    protected abstract int getIndex(String uuid, Resume resume);

    public abstract void clear();

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid(), resume);
        checkForExist(resume, index);
        checkForStorageLimit(resume);
        doSave(index, resume);
        sizeOfResume++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid, new Resume());
        checkForNotExist(uuid, index);
        doDelete(index, uuid);
        sizeOfResume--;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid(), resume);
        checkForNotExist(resume.getUuid(), index);
        doUpdate(index, resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid, new Resume());
        checkForNotExist(uuid, index);
        return doGet(index, uuid);
    }

    protected void checkForExist(Resume resume, int index) {
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    protected void checkForNotExist(String uuid, int index) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void checkForStorageLimit(Resume resume);

    @Override
    public int size() {
        return sizeOfResume;
    }
}
