package ru.model;

public class LabelTextSection {
    private String label;
    private String text;

    public LabelTextSection(String label, String text) {
        this.label = label;
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "LabelTextSection{" +
                "label='" + label + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
