package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<ID> implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = (r1, r2) -> Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid).compare(r1, r2);

    protected abstract void saveEntity(ID identifier, Resume resume);

    protected abstract ID getIdentifier(String uuid);

    protected abstract void deleteEntity(ID identifier);

    protected abstract void doUpdate(ID identifier, Resume resume);

    protected abstract Resume doGet(ID identifier);

    protected abstract Boolean isExist(ID identifier);

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

    private ID checkForExist(String uuid) {
        ID identifier = getIdentifier(uuid);
        if (isExist(identifier)) {
            throw new ExistStorageException(uuid);
        }
        return identifier;
    }

    private ID checkForNotExist(String uuid) {
        ID identifier = getIdentifier(uuid);
        if (!isExist(identifier)) {
            throw new NotExistStorageException(uuid);
        }
        return identifier;
    }
}
