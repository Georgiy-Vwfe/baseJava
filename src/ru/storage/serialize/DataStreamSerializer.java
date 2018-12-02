package ru.storage.serialize;

import com.google.gson.Gson;
import ru.model.AbstractSection;
import ru.model.ContactType;
import ru.model.Resume;
import ru.model.SectionType;

import java.io.*;
import java.util.Map;


public class DataStreamSerializer implements StreamSerializer {
    private Gson gson = new Gson();

    @Override
    public void doWrite(Resume resume, OutputStream outputStream) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(outputStream)) {
            Map<ContactType, String> contacts = resume.getContacts();
            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());

            if (contacts != null) {
                dos.writeBoolean(true);
                dos.writeInt(contacts.size());
                for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                    dos.writeUTF(entry.getKey().name());
                    dos.writeUTF(gson.toJson(entry.getValue()));
                }
            } else {
                dos.writeBoolean(false);
            }
            if (sections != null) {
                dos.writeBoolean(true);
                dos.writeInt(sections.size());
                for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                    dos.writeUTF(entry.getKey().name());
                    dos.writeUTF(gson.toJson(entry.getValue()));
                }
            } else {
                dos.writeBoolean(false);
            }
        }
    }

    @Override
    public Resume doRead(InputStream inputStream) throws IOException {
        try (DataInputStream dis = new DataInputStream(inputStream)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            boolean isNotEmpty = dis.readBoolean();
            if (isNotEmpty) {
                int contactSize = dis.readInt();
                for (int i = 0; i < contactSize; i++) {
                    resume.addContact(ContactType.valueOf(dis.readUTF()), gson.fromJson(dis.readUTF(), String.class));
                }
            }
            isNotEmpty = dis.readBoolean();
            if (isNotEmpty) {
                int sectionSize = dis.readInt();
                for (int i = 0; i < sectionSize; i++) {
                    resume.addSection(SectionType.valueOf(dis.readUTF()), gson.fromJson(dis.readUTF(), AbstractSection.class));
                }
            }

            return resume;
        }
    }


}