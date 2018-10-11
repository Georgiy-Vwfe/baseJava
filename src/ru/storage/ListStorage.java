package ru.storage;

import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> resumeArrayList = new ArrayList<>();

    @Override
    public void clear() {
        resumeArrayList.clear();

    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
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
    protected void checkForExist(Resume resume) {
        int index = resumeArrayList.indexOf(resume);
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    protected void checkForStorageLimit(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        return resumeArrayList.indexOf(resume);
    }
}
