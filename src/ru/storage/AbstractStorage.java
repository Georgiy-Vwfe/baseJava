package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = (r1, r2) -> Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid).compare(r1, r2);

    protected abstract void saveEntity(Object identifier, Resume resume);

    protected abstract Object getIdentifier(String uuid);

    protected abstract void deleteEntity(Object identifier);

    protected abstract void doUpdate(Object identifier, Resume resume);

    protected abstract Resume doGet(Object identifier);

    protected abstract Boolean isExist(Object identifier);

    protected abstract List<Resume> getResumeList();

    @Override
    public void save(Resume resume) {
        saveEntity(checkForExist(resume.getUuid()), resume);
    }

    @Override
    public void delete(String uuid) {
        deleteEntity(checkForNotExist(uuid));
    }

    @Override
    public void update(Resume resume) {
        doUpdate(checkForNotExist(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return doGet(checkForNotExist(uuid));
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeAsSortedList = getResumeList();
        resumeAsSortedList.sort(RESUME_COMPARATOR);
        return resumeAsSortedList;
    }

    private Object checkForExist(String uuid) {
        Object identifier = getIdentifier(uuid);
        if (isExist(identifier)) {
            throw new ExistStorageException(uuid);
        }
        return identifier;
    }

    private Object checkForNotExist(String uuid) {
        Object identifier = getIdentifier(uuid);
        if (!isExist(identifier)) {
            throw new NotExistStorageException(uuid);
        }
        return identifier;
    }
}
