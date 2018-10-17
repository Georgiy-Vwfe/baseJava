package ru.storage;

import ru.model.Resume;

import java.util.List;

import static java.lang.System.arraycopy;
import static java.util.Arrays.asList;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.copyOfRange;


public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Integer index, Resume resume) {
        index = (index * (-1) - 1);
        arraycopy(storage, index, storage, index + 1, sizeOfResume - index);
        storage[index] = resume;
    }

    @Override
    protected void doDelete(Integer index) {
        System.arraycopy(storage, index + 1, storage, index, sizeOfResume - index - 1);
    }

    @Override
    protected Object getIdentifier(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, sizeOfResume, searchKey, RESUME_COMPARATOR);
    }

    @Override
    public List<Resume> getAllSorted() {
        return asList(copyOfRange(storage, 0, sizeOfResume));
    }
}