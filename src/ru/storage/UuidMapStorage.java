package ru.storage;

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
    protected String putResumeUuid(Object identifier) {
        return (String)identifier;
    }
}