package ru.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.exception.NotExistStorageException;
import ru.exception.StorageException;
import ru.model.Resume;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "0";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "1";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "2";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "3";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(4,storage.size());
        Assert.assertEquals(RESUME_4, storage.get(RESUME_4.getUuid()));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 3; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1);
        storage.update(resume);
        Assert.assertSame(resume, storage.get(UUID_1));
    }

    @Test
    public void get() {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(RESUME_1, array[0]);
        Assert.assertEquals(RESUME_2, array[1]);
        Assert.assertEquals(RESUME_3, array[2]);
    }
}