package ru.storage;

import ru.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> resumeArrayList = new ArrayList<>();

    @Override
    public void clear() {
        resumeArrayList.clear();
    }

    @Override
    protected void doSave(int index, Resume resume) {
        resumeArrayList.add(resume);
    }

    @Override
    protected void doDelete(int index, String uuid) {
        resumeArrayList.remove(index);
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        resumeArrayList.set(index, resume);
    }

    @Override
    protected Resume doGet(int index, String uuid) {
        return resumeArrayList.get(index);
    }

    @Override
    protected void checkForStorageLimit(Resume resume) {
    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        return resumeArrayList.indexOf(resume);
    }

    @Override
    public Resume[] getAll() {
        return resumeArrayList.toArray(new Resume[resumeArrayList.size()]);
    }
}
