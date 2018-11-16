package ru.model;

import java.util.ArrayList;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private ArrayList<AbstractSection> listElements;

    public ListSection(ArrayList listElements) {
        Objects.requireNonNull(listElements, "listElements must not be null");
        this.listElements = listElements;
    }

    public ArrayList getListElements() {
        return listElements;
    }

    public void setListElements(ArrayList listElements) {
        this.listElements = listElements;
    }

    @Override
    public String toString() {
        return " " + listElements + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(listElements, that.listElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listElements);
    }
}
