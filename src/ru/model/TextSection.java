package ru.model;

public class TextSection extends AbstractSection {
    private String text;

    public TextSection(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextSection{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}
