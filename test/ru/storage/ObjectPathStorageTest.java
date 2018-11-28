package ru.storage;

import ru.storage.serialize.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new ObjectPathStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}
