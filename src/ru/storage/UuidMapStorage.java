package ru.storage;

public class UuidMapStorage extends AbstractMapStorage {

    @Override
    protected String getIdentifier(String uuid) {
        return uuid;
    }

    @Override
    protected String putResumeIdentifier(Object identifier) {
        return (String) identifier;
    }
}