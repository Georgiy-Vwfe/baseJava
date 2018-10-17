package ru.storage;

import ru.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapStorage extends AbstractStorage {
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
    public List<Resume> getAllSorted() {
        List<Resume> resumeMapAsSortedList = (List<Resume>) resumeMap.values();
        resumeMapAsSortedList.sort(RESUME_COMPARATOR);
        return resumeMapAsSortedList;
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
