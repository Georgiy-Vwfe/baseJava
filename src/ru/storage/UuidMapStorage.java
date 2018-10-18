package ru.storage;

import ru.model.Resume;

public class UuidMapStorage extends AbstractMapStorage {

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
}