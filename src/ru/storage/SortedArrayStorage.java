package ru.storage;

import ru.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume, int index) {
        index = (index * (-1) - 1);
        if (storage[index].compareTo(resume) > 0) {
            arraycopy(storage, index, storage, index + 1, sizeOfResume + 1 - index);
            storage[index] = resume;
        } else {
            storage[index] = resume;
        }
    }

    @Override
    protected void doDelete(String uuid, int index) {
        storage[index] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, sizeOfResume, searchKey);
    }
}
