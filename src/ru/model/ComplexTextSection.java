package ru.model;

public class ComplexTextSection extends AbstractLabelSection {
    private String subLabel;
    private String date;
    private String title;
    private String titleDescription;

    public ComplexTextSection(String label, String subLabel, String date, String title, String titleDescription) {
        super(label);
        this.subLabel = subLabel;
        this.date = date;
        this.title = title;
        this.titleDescription = titleDescription;
    }

    public String getSubLabel() {
        return subLabel;
    }

    public void setSubLabel(String subLabel) {
        this.subLabel = subLabel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return "ComplexTextSection{" +
                "subLabel='" + subLabel + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", titleDescription='" + titleDescription + '\'' +
                "} " + super.toString();
    }
}
