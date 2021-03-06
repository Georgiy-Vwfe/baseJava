package ru.model;

public enum ContactType {
    PHONE_NUMBER("Номер телефона"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN_PROFILE("Профиль LinkedIn"),
    GITHUB_PROFILE("Профиль GitHub"),
    STACKOVERFLOW_PROFILE("Профиль Stackoverflow");

    private String title;

    ContactType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
