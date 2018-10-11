package ru.storage;

import ru.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(int index, Resume resume) {
        storage[sizeOfResume] = resume;
    }

    @Override
    protected void doDelete(int index) {
        storage[index] = storage[sizeOfResume - 1];
    }

    @Override
    protected int getIndex(String uuid, Resume resume) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
