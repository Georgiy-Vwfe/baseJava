package ru.storage;

import ru.model.Resume;

import java.util.Comparator;

public class FullNameMapStorage extends AbstractMapStorage {

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
        resumeMap.put(resume.getFullName(), resume);
    }
}