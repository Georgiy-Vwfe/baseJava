package ru.storage;

import ru.model.Resume;
import static java.util.Arrays.binarySearch;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        sort(storage,sizeOfResume);
        return binarySearch(storage, 0, sizeOfResume, searchKey);
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) < 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже введено");
        } else if (sizeOfResume >= STORAGE_LIMIT) {
            System.out.println("Массив полон");
        } else {
            storage[sizeOfResume] = resume;
            sizeOfResume++;
        }
    }

    private void sort(Resume storage[], int size){
        Resume key;
        for (int i = 1; i < size; i++) {
            key = storage[i];
            int j = i - 1;
            int compare = storage[j].compareTo(key);
            while (j >= 0 && compare < 0) {
                storage[j + 1] = storage[j];
                j = j - 1;
            }
            storage[j + 1] = key;
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
