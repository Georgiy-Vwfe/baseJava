package ru.storage;

import ru.storage.serialize.ObjectStreamSerializer;

import java.io.File;

public class ObjectFileStorageTest extends AbstractStorageTest {
    public ObjectFileStorageTest() {
        super(new ObjectFileStorage(new File(STORAGE_DIR), new ObjectStreamSerializer()));
    }
}
