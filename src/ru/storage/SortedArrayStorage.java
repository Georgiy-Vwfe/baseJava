package ru.storage;

import ru.model.Resume;

import static java.lang.System.arraycopy;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return binarySearch(storage, 0, sizeOfResume, searchKey);
    }

    public void save(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i > -1) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
        } else if (sizeOfResume >= STORAGE_LIMIT) {
            System.out.println("Массив полон");
        } else {
            //copyOf
            addResumeInArray(i, resume);
            sizeOfResume++;
        }
    }

    private void addResumeInArray(int index, Resume resume) {
        if (storage[index].compareTo(resume) > 0) {
            arraycopy(storage, index, storage, index + 1, sizeOfResume + 1 - index);
            storage[index] = resume;
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
}
