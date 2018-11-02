package ru.model;

import java.util.ArrayList;

public class ListSection extends AbstractLabelSection {
    private ArrayList listElement;

    public ListSection(String label, ArrayList listElement) {
        super(label);
        this.listElement = listElement;
    }

    public ArrayList getListElement() {
        return listElement;
    }

    public void setListElement(ArrayList listElement) {
        this.listElement = listElement;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "listElement=" + listElement +
                "} " + super.toString();
    }
}
