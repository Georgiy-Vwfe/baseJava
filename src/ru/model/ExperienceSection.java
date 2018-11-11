package ru.model;

import java.time.LocalDate;
import java.util.Objects;

public class ExperienceSection extends AbstractSection {
    private String subLabel;
    private String link;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String title;
    private String description;

    public ExperienceSection(String subLabel, String link, LocalDate dateFrom, LocalDate dateTo, String title, String description) {
        this.subLabel = subLabel;
        this.link = link;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.title = title;
        this.description = description;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
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
        return Objects.equals(subLabel, that.subLabel) &&
                Objects.equals(link, that.link) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subLabel, link, dateFrom, dateTo, title, description);
    }

    @Override
    public String toString() {
        if (subLabel == null && description == null) {
            return "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n";
        } else if (subLabel == null) {
            return "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n" + description + "\n";
        } else if (description == null) {
            return "\n" + subLabel + "\n" + link + "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n";
        } else {
            return "\n" + subLabel + "\n" + link + "\n" + dateFrom + " - " + dateTo + "\n" + title + "\n" + description;
        }
    }
}

