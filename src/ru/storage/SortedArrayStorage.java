package ru.storage;

import ru.model.Resume;

import java.util.Arrays;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume, int index) {
        index = (index * (-1) - 1);
        arraycopy(storage, index, storage, index + 1, sizeOfResume - index);
        storage[index] = resume;
    }

    @Override
    protected void doDelete(int index) {
        storage[index] = null;
        Resume tempStorage[] = Arrays.copyOfRange(storage, 0, sizeOfResume + 1);
        arraycopy(tempStorage, index, tempStorage, index, sizeOfResume - 1);
        storage = Arrays.copyOfRange(tempStorage,0,sizeOfResume);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, sizeOfResume, searchKey);
    }
}