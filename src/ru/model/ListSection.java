package ru.model;

import java.util.ArrayList;

public class ListSection extends AbstractSection {
    private ArrayList listElement;

    public ListSection(ArrayList listElement) {
        super();
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
