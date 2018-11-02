package ru.model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    private final String uuid;
    private String fullName;

    private Map<SectionContacts, String> contacts;
    private Map<SectionType, AbstractLabelSection> sectionTypes;

    public Resume(String fullName, Map<SectionContacts, String> contacts, Map<SectionType, AbstractLabelSection> sectionTypes) {
        this(UUID.randomUUID().toString(), fullName, contacts, sectionTypes);
    }

    public Resume(String uuid, String fullName, Map<SectionContacts, String> contacts, Map<SectionType, AbstractLabelSection> sectionTypes) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.contacts = contacts;
        this.sectionTypes = sectionTypes;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Map<SectionContacts, String> getContacts() {
        return contacts;
    }

    public Map<SectionType, AbstractLabelSection> getSectionTypes() {
        return sectionTypes;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setContacts(Map<SectionContacts, String> contacts) {
        this.contacts = contacts;
    }

    public void setSectionTypes(Map<SectionType, AbstractLabelSection> sectionTypes) {
        this.sectionTypes = sectionTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Resume r) {
        return uuid.compareTo(r.uuid);
    }
}
