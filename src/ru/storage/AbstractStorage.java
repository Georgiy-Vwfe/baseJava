package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void saveEntity(int sequence, Resume resume);

    protected int prepareSave(Resume resume) {
        return getIndex(resume.getUuid());
    }
    protected int prepareSave(String uuid){
        return getIndex(uuid);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void deleteEntity(int sequence, String uuid);

    protected abstract void doUpdate(int sequence, Resume resume);

    protected abstract Resume doGet(int sequence, String uuid);

    protected void checkForStorageLimit(Resume resume) {}

    public abstract void clear();



    @Override
    public void save(Resume resume) {
        int sequence = prepareSave(resume);
        checkForExist(resume, sequence);
        checkForStorageLimit(resume);
        saveEntity(sequence, resume);
    }

    @Override
    public void delete(String uuid) {
        int sequence = prepareSave(uuid);
        checkForNotExist(uuid, sequence);
        deleteEntity(sequence, uuid);
    }

    @Override
    public void update(Resume resume) {
        int sequence = prepareSave(resume);
        checkForNotExist(resume.getUuid(), sequence);
        doUpdate(sequence, resume);
    }

    @Override
    public Resume get(String uuid) {
        int sequence = prepareSave(uuid);
        checkForNotExist(uuid, sequence);
        return doGet(sequence, uuid);
    }

    protected void checkForExist(Resume resume, int sequence) {
        if (sequence >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    private void checkForNotExist(String uuid, int sequence) {
        if (sequence < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
}
