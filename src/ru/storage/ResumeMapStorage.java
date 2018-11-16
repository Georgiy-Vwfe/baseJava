package ru.storage;

import ru.model.Resume;

public class ResumeMapStorage extends AbstractMapStorage {

    @Override
    protected Resume getIdentifier(String uuid) {
        return resumeMap.get(uuid);
    }

    @Override
    protected String putResumeIdentifier(Object identifier) {
        return ((Resume) identifier).getUuid();
    }
}