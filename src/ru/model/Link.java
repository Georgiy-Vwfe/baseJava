package ru.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    private final String company;
    private final String link;

    Link(String company, String link) {
        this.company = company;
        this.link = link;
    }

    public String getCompany() {
        return company;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "\n" + company + "\n" + link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return Objects.equals(company, link1.company) &&
                Objects.equals(link, link1.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, link);
    }
}
