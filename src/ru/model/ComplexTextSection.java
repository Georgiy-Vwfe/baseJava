package ru.model;

import java.time.LocalDate;
import java.util.Objects;

public class ComplexTextSection extends AbstractSection {
    private String subLabel;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String title;
    private String titleDescription;

    public ComplexTextSection(String subLabel, LocalDate dateFrom, LocalDate dateTo, String title, String titleDescription) {
        this.subLabel = subLabel;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.title = title;
        this.titleDescription = titleDescription;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
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

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    @Override
    public String toString() {
        return " " + subLabel + "\n" + dateFrom + "\n" + dateTo + "\n" + title + "\n" + titleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexTextSection that = (ComplexTextSection) o;
        return Objects.equals(subLabel, that.subLabel) &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(title, that.title) &&
                Objects.equals(titleDescription, that.titleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subLabel, dateFrom, dateTo, title, titleDescription);
    }
}
