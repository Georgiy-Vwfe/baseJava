package ru.storage;

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
        for (Resume resume : resumeList) {
            if (resume.getUuid().equals(uuid)) {
                return resumeList.indexOf(resume);
            }
        }
        return -1;
    }

    @Override
    protected void saveEntity(Object index, Resume resume) {
        resumeList.add(resume);
    }

    @Override
    protected void deleteEntity(Object index) {
        resumeList.remove((int)index);
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeList.set((Integer) identifier, resume);
    }

    @Override
    protected Resume doGet(Object identifier) {
        return resumeList.get((Integer) identifier);
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    protected Boolean isExist(Object identifier) {
        return (Integer) identifier > -1;
    }

    @Override
    protected List<Resume> getResumeList() {
        return new ArrayList<>(resumeList);
    }

}
