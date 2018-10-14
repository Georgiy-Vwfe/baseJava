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
            return resumeMap.get(uuid).getUuid();
        }
    }

    @Override
    protected void saveEntity(Object identifier, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteEntity(Object identifier, String uuid) {
        resumeMap.remove(uuid);
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object identifier, String uuid) {
        return resumeMap.get(uuid);
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
    protected Boolean doExist(String uuid, Object identifier) {
        return identifier != null;
    }
}