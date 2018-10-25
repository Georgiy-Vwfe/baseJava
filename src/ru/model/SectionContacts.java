package ru.model;

public enum SectionContacts {
    PHONE_NUMBER("Номер телефона"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN_PROFILE("Профиль LinkedIn"),
    GITHUB_PROFILE("Профиль GitHub"),
    STACKOVERFLOW_PROFILE("Профиль Stackoverflow");

    private String title;

    SectionContacts(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
