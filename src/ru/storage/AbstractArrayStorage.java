package ru.storage;

import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage implements Storage{

    protected static final int STORAGE_LIMIT = 100_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int sizeOfResume = 0;


    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            System.out.println("Резюме " + uuid + " не существует");
            return null;
        } else {
            return storage[i];
        }
    }

    public int size() {
        return sizeOfResume;
    }

    protected abstract int getIndex(String uuid);
}
