package ru.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.exception.ExistStorageException;
import ru.exception.NotExistStorageException;
import ru.model.Resume;

import java.util.List;

import static java.util.Arrays.asList;
import static ru.storage.AbstractStorage.RESUME_COMPARATOR;

public abstract class AbstractStorageTest {

    protected Storage storage;
    private static final String UUID_1 = "0";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Mark Gess", sectionTypes);

    private static final String UUID_2 = "1";
    private static final Resume RESUME_2 = new Resume(UUID_2, "Daniel Watson", sectionTypes);

    private static final String UUID_3 = "2";
    private static final Resume RESUME_3 = new Resume(UUID_3, "Henry Ford", sectionTypes);

    private static final String UUID_4 = "3";
    private static final Resume RESUME_4 = new Resume(UUID_4, "Frans Ferdinand", sectionTypes);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(RESUME_4, storage.get(RESUME_4.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_1, "Peter Jackson", sectionTypes);
        storage.update(resume);
        Assert.assertSame(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("Kungoro", sectionTypes));
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
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
    public void getAllSorted() {
        List<Resume> list = asList(RESUME_1, RESUME_2, RESUME_3);
        list.sort(RESUME_COMPARATOR);
        Assert.assertEquals(list, storage.getAllSorted());
    }
}