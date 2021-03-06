package ru.storage;

import ru.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage {
    protected Map<String, Resume> resumeMap = new HashMap<>();

    protected abstract String takeUuid(Object identifier);

    @Override
    public void clear() {
        resumeMap.clear();
    }

    @Override
    protected void saveEntity(Object identifier, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteEntity(Object identifier) {
        resumeMap.remove(takeUuid(identifier));
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeMap.replace(takeUuid(identifier), resume);
    }

    @Override
    protected Resume doGet(Object identifier) {
        return resumeMap.get(takeUuid(identifier));
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    protected Boolean isExist(Object identifier) {
        try {
            return resumeMap.containsKey(takeUuid(identifier));
        } catch (NullPointerException e){
            return false;
        }
    }

    @Override
    protected List<Resume> getResumeList() {
        return new ArrayList<>(resumeMap.values());
    }
}
