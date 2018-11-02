package ru.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.exception.StorageException;
import ru.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("", sectionTypes));
            }
        } catch (StorageException e) {
            Assert.fail("Ошибка во время заполнения массива");
        }
        storage.save(new Resume("Jacob Richter", sectionTypes));
    }
}