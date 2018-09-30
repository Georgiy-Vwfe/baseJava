package ru.storage;

import ru.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        super.save(resume);
        if (sizeOfResume >= STORAGE_LIMIT) {
            System.out.println("Массив полон");
        } else {
            storage[sizeOfResume] = resume;
            sizeOfResume++;
        }
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);
        {
            storage[getIndex(uuid)] = storage[sizeOfResume - 1];
            storage[sizeOfResume - 1] = null;
            sizeOfResume--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    protected int getIndex(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
