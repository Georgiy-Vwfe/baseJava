package ru.model;

public class AbstractLabelSection {
    private String label;

    public AbstractLabelSection(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    @Override
    public String toString() {
        return "AbstractLabelSection{" +
                "label='" + label + '\'' +
                '}';
    }
}
