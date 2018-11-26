package ru.storage;

public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new ObjectPathStorage(STORAGE_DIR));
    }
}
