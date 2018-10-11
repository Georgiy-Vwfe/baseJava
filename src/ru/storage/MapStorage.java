package ru.storage;

import ru.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> mapStorage = new HashMap<>();
    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public void save(Resume resume) {

    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected void doSave(Resume resume, int index) {

    }

    @Override
    protected void doDelete(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
