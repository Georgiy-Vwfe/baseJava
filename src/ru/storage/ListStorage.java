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
        return resumeList.indexOf(uuid);
    }

    @Override
    protected Object prepareSave(Resume resume) {
        Object identifier = getIdentifier(resume.getUuid());
        checkForExist(resume, identifier);
        return identifier;
    }

    @Override
    protected void saveEntity(Object sequence, Resume resume) {
        resumeList.add(resume);
    }

    @Override
    protected void deleteEntity(Integer sequence, String uuid) {
        resumeList.remove(sequence);
    }

    @Override
    protected void doUpdate(Integer sequence, Resume resume) {
        resumeList.set(sequence, resume);
    }

    @Override
    protected Resume doGet(Object sequence, String uuid) {
        return resumeList.get((Integer) sequence);
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[resumeList.size()]);
    }

    @Override
    public int size() {
        return resumeList.size();
    }
}
