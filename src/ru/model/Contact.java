package ru.model;

public class Contact {
    private String contact;

    public Contact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contact='" + contact + '\'' +
                '}';
    }
}
