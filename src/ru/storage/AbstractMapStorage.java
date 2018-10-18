package ru.storage;

import ru.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage {
    protected Map<String, Resume> resumeMap = new HashMap<>();

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected void deleteEntity(Object identifier) {
        resumeMap.remove(identifier);
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeMap.replace((String) identifier, resume);
    }

    @Override
    protected Resume doGet(Object identifier) {
        return resumeMap.get(identifier);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected Boolean isExist(Object identifier) {
        return identifier != null;
    }

    @Override
    protected List<Resume> getResumeList() {
        return (List<Resume>) resumeMap.values();
    }
}
