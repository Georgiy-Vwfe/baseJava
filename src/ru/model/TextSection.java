package ru.model;

public class TextSection extends AbstractLabelSection {
    private String text;

    public TextSection(String label, String text) {
        super(label);
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
