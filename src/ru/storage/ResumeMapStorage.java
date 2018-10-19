package ru.storage;

import ru.model.Resume;

import java.util.Comparator;

public class ResumeMapStorage extends AbstractMapStorage {

    @Override
    protected Object getIdentifier(String uuid) {
        Resume resume = resumeMap.get(uuid);
        if (resume == null) {
            return null;
        } else {
            return resume;
        }
    }

    @Override
    protected void saveEntity(Object identifier, Resume resume) {
        resumeMap.put(resume.getUuid(), resume);
    }
}