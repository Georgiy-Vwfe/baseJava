package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    protected Object getIdentifier(String uuid) {
        return resumeList.indexOf(uuid);
    }

    @Override
    protected void saveEntity(Object identifier, Resume resume) {
        resumeList.add(resume);
    }

    @Override
    protected void deleteEntity(Object identifier, String uuid) {
        resumeList.remove(identifier);
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeList.set((Integer) identifier, resume);
    }

    @Override
    protected Resume doGet(Object identifier, String uuid) {
        return resumeList.get((Integer) identifier);
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[resumeList.size()]);
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    protected void checkForExist(String uuid, Object identifier) {
        if ((Integer) identifier >= 0) {
            throw new ExistStorageException(uuid);
        }
    }

    @Override
    protected void checkForNotExist(String uuid, Object identifier) {
        if ((Integer) identifier < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
}
