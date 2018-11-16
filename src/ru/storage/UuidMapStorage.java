package ru.storage;

public class UuidMapStorage extends AbstractMapStorage {

    @Override
    protected String getIdentifier(String uuid) {
        try {
            return resumeMap.get(uuid).getUuid();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    protected String putResumeIdentifier(Object identifier) {
        return (String) identifier;
    }
}