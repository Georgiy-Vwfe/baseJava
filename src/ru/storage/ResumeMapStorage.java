package ru.storage;

import ru.model.Resume;

public class ResumeMapStorage extends AbstractMapStorage {

    @Override
    protected Resume getIdentifier(String uuid) {
        Resume resume = resumeMap.get(uuid);
        if (resume == null) {
            return null;
        } else {
            return resume;
        }
    }

    @Override
    protected String putResumeUuid(Object identifier) {
        Resume findEntity = (Resume)identifier;
        return findEntity.getUuid();
    }
}