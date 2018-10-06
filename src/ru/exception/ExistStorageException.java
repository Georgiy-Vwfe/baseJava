package ru.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Резюме " + uuid + " уже введено", uuid);
    }
}