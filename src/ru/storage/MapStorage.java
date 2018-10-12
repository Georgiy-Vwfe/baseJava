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
        return resumeMap.get(uuid);
    }

    @Override
    protected void saveEntity(Object sequence, Resume resume) {
        resumeMap.put((String) sequence, resume);
    }

    @Override
    protected void deleteEntity(Integer sequence, String uuid) {
        resumeMap.remove(uuid);
    }

    @Override
    protected void doUpdate(Integer sequence, Resume resume) {
        resumeMap.replace(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object sequence, String uuid) {
        return resumeMap.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return resumeMap.size();
    }
}
