package ru.model;

import ru.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    private Link homePage;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateFrom;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateTo;
    private String title;
    private String description;

    public Organization() {
    }

    public Organization(String company, String link, LocalDate dateFrom, LocalDate dateTo, String title, String description) {
        Objects.requireNonNull(dateFrom, "dateFrom must not be null");
        Objects.requireNonNull(dateTo, "dateTo must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(company, link);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.title = title;
        this.description = description;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Link getHomePage() {
        return homePage;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, dateFrom, dateTo, title, description);
    }

    @Override
    public String toString() {
        if (homePage.getCompany() == null) {
            if (description == null) {
                return "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n";
            } else {
                return "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n" + description + "\n";
            }
        } else if (description == null) {
            return "\n" + homePage + "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n";
        } else {
            return "\n" + homePage + "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n" + description + "\n";
        }
    }
}
