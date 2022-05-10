package com.student.dto;

import java.util.Date;

public class UniversityDto {
    private String abbreviation;
    private String fullTitle;
    private Date foundingDate;

    public UniversityDto(String abbreviation, String fullTitle, Date foundingDate) {
        this.abbreviation = abbreviation;
        this.fullTitle = fullTitle;
        this.foundingDate = foundingDate;
    }

    public UniversityDto() {
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }
}
