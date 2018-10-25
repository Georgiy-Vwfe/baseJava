package ru.storage;

import ru.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage {
    protected Map<String, Resume> resumeMap = new HashMap<>();

    protected abstract String putResumeUuid(Object identifier);

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
        resumeMap.remove(putResumeUuid(identifier));
    }

    @Override
    protected void doUpdate(Object identifier, Resume resume) {
        resumeMap.replace(putResumeUuid(identifier), resume);
    }

    @Override
    protected Resume doGet(Object identifier) {
        return resumeMap.get(putResumeUuid(identifier));
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
        return new ArrayList<>(resumeMap.values());
    }
}
