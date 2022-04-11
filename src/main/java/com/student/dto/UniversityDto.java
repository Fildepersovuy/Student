package com.student.dto;

import java.util.Date;

public class UniversityDto {
    private String abbreviation;
    private String full_title;
    private Date founding_date;

    public UniversityDto( String abbreviation, String full_title, Date founding_date){
        this.abbreviation = abbreviation;
        this.full_title = full_title;
        this.founding_date = founding_date;
    }
    public UniversityDto(){}


    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    public void setFull_title(String full_title){
        this.full_title = full_title;
    }
    public String getFull_title(){return full_title;}
    public void setFounding_date(Date founding_date){
        this.founding_date = founding_date;
    }
    public Date getFounding_date(){
        return founding_date;
    }
}
