package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {
    private static String abbreviation;
    private static String fullTitle;
    private static Date foundingDate;

//    public UniversityDto(String abbreviation, String fullTitle, Date foundingDate) {
//        this.abbreviation = abbreviation;
//        this.fullTitle = fullTitle;
//        this.foundingDate = foundingDate;
//    }
//
//    public UniversityDto() {
//    }

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
