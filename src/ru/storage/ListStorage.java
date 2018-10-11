package ru.storage;

import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.ArrayList;
import java.util.Collection;

public class ListStorage extends AbstractStorage {
    protected Collection<Resume> resumeArrayList = new ArrayList<>();
    @Override
    public void clear() {
        resumeArrayList.clear();
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return null;
        }

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected void doSave(Resume resume, int index) {
        resumeArrayList.add(resume);
    }

    @Override
    protected void doDelete(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        int index;
    }
}
