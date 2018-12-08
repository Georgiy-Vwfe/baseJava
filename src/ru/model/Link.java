package ru.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {
    private static final long serialVersionUID = 1L;

    private String company;
    private String link;

    Link() {
    }

    Link(String company, String link) {
        this.company = company;
        this.link = link;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
