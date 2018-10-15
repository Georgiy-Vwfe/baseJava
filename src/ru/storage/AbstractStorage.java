package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void saveEntity(Object identifier, Resume resume);

    protected abstract Object getIdentifier(String uuid);

    protected abstract void deleteEntity(Object identifier);

    protected abstract void doUpdate(Object identifier, Resume resume);

    protected abstract Resume doGet(Object identifier);

    protected abstract Boolean isExist(Object identifier);


    @Override
    public void save(Resume resume) {
        Object identifier = getIdentifier(resume.getUuid());
        checkForExist(resume.getUuid(), identifier);
        saveEntity(identifier, resume);
    }

    @Override
    public void delete(String uuid) {
        Object identifier = getIdentifier(uuid);
        checkForNotExist(uuid, identifier);
        deleteEntity(identifier);
    }

    @Override
    public void update(Resume resume) {
        Object identifier = getIdentifier(resume.getUuid());
        checkForNotExist(resume.getUuid(), identifier);
        doUpdate(identifier, resume);
    }

    @Override
    public Resume get(String uuid) {
        Object identifier = getIdentifier(uuid);
        checkForNotExist(uuid, identifier);
        return doGet(identifier);
    }

    private void checkForExist(String uuid, Object identifier) {
        if (isExist(identifier)) {
            throw new ExistStorageException(uuid);
        }
    }

    private void checkForNotExist(String uuid, Object identifier) {
        if (!isExist(identifier)) {
            throw new NotExistStorageException(uuid);
        }
    }
}
