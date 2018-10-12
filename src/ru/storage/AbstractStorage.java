package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void saveEntity(Object sequence, Resume resume);

    protected abstract Object getIdentifier(String uuid);

    protected abstract void deleteEntity(Integer sequence, String uuid);

    protected abstract void doUpdate(Integer sequence, Resume resume);

    protected abstract Resume doGet(Object sequence, String uuid);

    public abstract void clear();


    @Override
    public void save(Resume resume) {
        Object sequence = getIdentifier(resume.getUuid());
        checkForExist(resume, sequence);
        checkForStorageLimit(resume);
        saveEntity(sequence, resume);
    }

    @Override
    public void delete(String uuid) {
        int sequence = (int) getIdentifier(uuid);
        checkForNotExist(uuid, sequence);
        deleteEntity(sequence, uuid);
    }

    @Override
    public void update(Resume resume) {
        int sequence = (int) getIdentifier(resume.getUuid());
        checkForNotExist(resume.getUuid(), sequence);
        doUpdate(sequence, resume);
    }

    @Override
    public Resume get(String uuid) {
        Object sequence = getIdentifier(uuid);
        checkForNotExist(uuid, sequence);
        return doGet(sequence, uuid);
    }

    protected void checkForStorageLimit(Resume resume) {
    }

    private void checkForExist(Resume resume, Object sequence) {
        if ((Integer) sequence >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    private void checkForNotExist(String uuid, Object sequence) {
        if ((Integer) sequence < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
}
