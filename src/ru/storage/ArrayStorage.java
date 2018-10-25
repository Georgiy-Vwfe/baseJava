package ru.storage;

import ru.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Integer index, Resume resume) {
        storage[sizeOfResume] = resume;
    }

    @Override
    protected void doDelete(Integer index) {
        storage[index] = storage[sizeOfResume - 1];
    }

    @Override
    protected Integer getIdentifier(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
