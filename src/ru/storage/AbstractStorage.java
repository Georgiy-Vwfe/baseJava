package ru.storage;

import ru.exception.ExistStorageException;
import ru.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected int sizeOfResume = 0;

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(int index);

    protected abstract int getIndex(String uuid, Resume resume);
    @Override
    public void save(Resume resume) {
        int index = 0;
        checkForExist(resume);
        checkForStorageLimit(resume);
        doSave(resume, index);
        sizeOfResume++;
    }

    protected void checkForExist(Resume resume){
        int index = getIndex(resume.getUuid(), resume);
        if (index >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
            throw new ExistStorageException(resume.getUuid());
        }
    }

    protected void checkForNotExist(Resume resume){
        int index = getIndex(resume.getUuid(), resume);
        if (index < 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
            throw new ExistStorageException(resume.getUuid());
        }
    }

    protected abstract void checkForStorageLimit(Resume resume);

    @Override
    public void delete(String uuid) {

    }

    public int size() {
        return sizeOfResume;
    }

}
