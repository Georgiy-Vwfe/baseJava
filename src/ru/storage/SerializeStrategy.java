package ru.storage;

import ru.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

interface SerializeStrategy {
    void doWrite(Resume resume, OutputStream outputStream) throws IOException;

    Resume doRead(InputStream inputStream) throws IOException;
}
