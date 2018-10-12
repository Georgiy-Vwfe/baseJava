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
    protected int prepareSave(Resume resume) {
        return resumeList.indexOf(resume);
    }

    @Override
    protected int prepareSave(String uuid) {
        return resumeList.indexOf(uuid);
    }

    @Override
    protected void saveEntity(int sequence, Resume resume) {
        resumeList.add(resume);
    }

    @Override
    protected void deleteEntity(int sequence, String uuid) {
        resumeList.remove(sequence);
    }

    @Override
    protected void doUpdate(int sequence, Resume resume) {
        resumeList.set(sequence, resume);
    }

    @Override
    protected Resume doGet(int sequence, String uuid) {
        return resumeList.get(sequence);
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
