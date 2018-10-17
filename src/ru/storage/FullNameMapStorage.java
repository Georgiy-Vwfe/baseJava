package ru.storage;

import ru.model.Resume;

import java.util.Comparator;

public class FullNameMapStorage extends MapStorage {

    private final Comparator<Resume> RESUME_COMPARATOR = (r1, r2) -> {
        int compareResult = r1.getFullName().compareTo(r2.getFullName());
        if (compareResult == 0) {
            return r1.getUuid().compareTo(r2.getUuid());
        } else {
            return compareResult;
        }
    };


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