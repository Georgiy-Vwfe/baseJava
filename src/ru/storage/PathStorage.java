package ru.storage;

import ru.exception.StorageException;
import ru.model.Resume;
import ru.storage.serialize.StreamSerializer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private StreamSerializer streamSerializer;

    public PathStorage(String dir, StreamSerializer streamSerializer) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
        this.streamSerializer = streamSerializer;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteEntity);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("Path read error", null);
        }
    }

    @Override
    protected Path getIdentifier(String uuid) {
        return Paths.get(directory.toString() + File.separator + uuid);
    }

    @Override
    protected void doUpdate(Path path, Resume resume) {
        try {
            streamSerializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path write error", resume.getUuid(), e);
        }
    }

    @Override
    protected Boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void saveEntity(Path path, Resume resume) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create path " + path.toString(), resume.getUuid(), e);
        }
        doUpdate(path, resume);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("path read error", path.toString(), e);
        }
    }

    @Override
    protected void deleteEntity(Path path) {
        try {
            if (!Files.deleteIfExists(path)) {
                throw new StorageException("file is not exist", path.toString());
            }
        } catch (IOException e) {
            throw new StorageException("path delete error", path.toString());
        }
    }

    @Override
    public List<Resume> getResumeList() {
        try {
            return Files.list(directory)
                    .map(this::doGet)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new StorageException("path read error", null);
        }
    }
}
