package ru.storage;

import ru.model.Resume;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;

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
    protected Object getIdentifier(String uuid) {
        for (int i = 0; i < sizeOfResume; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumesAsSortedList = asList(copyOfRange(storage, 0, sizeOfResume));
        resumesAsSortedList.sort(RESUME_COMPARATOR);
        return resumesAsSortedList;
    }
}
