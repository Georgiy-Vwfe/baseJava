package ru.model;

import java.time.LocalDate;
import java.util.Objects;

public class ExperienceSection extends AbstractSection {
    private String company;
    private String link;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String title;
    private String description;

    public ExperienceSection(String company, String link, LocalDate dateFrom, LocalDate dateTo, String title, String description) {
        this.company = company;
        this.link = link;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.title = title;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSection that = (ExperienceSection) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(link, that.link) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, link, dateFrom, dateTo, title, description);
    }

    @Override
    public String toString() {
        return company + "\n" + link + "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n" + "\n" + description;
    }
}
