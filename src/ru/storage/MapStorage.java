package ru.storage;

import ru.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> resumeHashMap = new HashMap<>();

    @Override
    public void clear() {
        resumeHashMap.clear();
    }

    @Override
    protected void doSave(int index, Resume resume) {
        resumeHashMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(int index, String uuid) {
        resumeHashMap.remove(uuid);
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        resumeHashMap.replace(resume.getUuid(),resume);
    }

    @Override
    protected Resume doGet(int index, String uuid) {
        return resumeHashMap.get(uuid);
    }

    @Override
    protected void checkForStorageLimit(Resume resume) {

    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        return 0;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }
}
