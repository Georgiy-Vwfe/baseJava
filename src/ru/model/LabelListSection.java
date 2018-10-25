package ru.model;

public class LabelListSection {
    private String label;
    private String listElement;

    public LabelListSection(String label, String listElement) {
        this.label = label;
        this.listElement = listElement;
    }

    public String getLabel() {
        return label;
    }

    public String getListElement() {
        return listElement;
    }

    public void setListElement(String listElement) {
        this.listElement = listElement;
    }
}
