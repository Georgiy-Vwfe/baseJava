package ru.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private List<String> listElements;

    public ListSection() {
    }

    public ListSection(String... items) {
        this(Arrays.asList(items));
    }

    public ListSection(List<String> listElements) {
        Objects.requireNonNull(listElements, "list elements must not be null");
        this.listElements = listElements;
    }

    public List<String> getListElements() {
        return listElements;
    }

    public void setListElements(List<String> listElements) {
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
