package ru.storage;

import ru.model.Resume;

public class ArrayStorage extends AbstractArrayStorage{
    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
        } else if (sizeOfResume >= STORAGE_LIMIT) {
            System.out.println("Массив полон");
        } else {
            storage[sizeOfResume] = resume;
            sizeOfResume++;
        }
    }
    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме " + uuid + " не существует");
        } else {
            storage[i] = storage[sizeOfResume - 1];
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
