package ru.storage;

import ru.exception.StorageException;
import ru.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        if (!directory.delete()) {
            throw new StorageException("Delete error", directory.getName());
        }
    }

    @Override
    public long size() {
        return directory.length();
    }

    @Override
    protected File getIdentifier(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(File file, Resume r) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void saveEntity(File file, Resume r) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract void doDelete(File file) throws IOException;

    @Override
    protected Resume doGet(File file) {
        return file.canRead();
    }

    @Override
    protected void deleteEntity(File file) {
        try {
            doDelete(file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList(Arrays.asList(directory.listFiles()));
    }
}