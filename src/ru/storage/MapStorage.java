package ru.storage;

import ru.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected Object getIdentifier(String uuid) {
        if (resumeMap.get(uuid) == null) {
            return null;
        } else {
            return uuid;
        }
    }

    @Override
    protected void saveEntity(Object identifier, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteEntity(Object identifier) {
        resumeMap.remove((String) identifier);
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeMap.replace((String) identifier, resume);
    }

    @Override
    protected Resume doGet(Object identifier) {
        return resumeMap.get((String) identifier);
    }

    @Override
    public Resume[] getAll() {
        return resumeMap.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected Boolean isExist(Object identifier) {
        return identifier != null;
    }
}