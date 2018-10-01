package ru.storage;

import ru.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume, int index) {
        index = (index * (-1) - 1);
//        for (int i = sizeOfResume; i >= index; i--) {
//            storage[i + 1] = storage[i];
//            storage[i] = null;
//        }
        arraycopy(storage, index, storage, index + 1, sizeOfResume - index);
        storage[index] = resume;
    }

    @Override
    protected void doDelete(int index) {
        storage[index] = null;
//        for (int i = index; i <= sizeOfResume; i++) {
//            storage[i] = storage[i + 1];
//            storage[i + 1] = null;
//        }
        arraycopy(storage, index + 1, storage, index, sizeOfResume - 1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, sizeOfResume, searchKey);
    }
}
