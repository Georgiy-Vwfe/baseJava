package ru.storage;

import ru.exception.ExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected int sizeOfResume = 0;

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(int index);

    protected abstract int getIndex(String uuid);

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
            throw new ExistStorageException(resume.getUuid());
        }
        checkForStorageLimit(resume);
        doSave(resume, index);
        sizeOfResume++;
    }

    protected void checkForStorageLimit(Resume resume){
    }

    @Override
    public void delete(String uuid) {

    }
}
