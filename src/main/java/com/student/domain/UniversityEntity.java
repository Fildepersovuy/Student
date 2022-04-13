package com.student.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "universities")
public class UniversityEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "full_title")
    private String full_title;
    @Column(name = "founding_date")
    private Date founding_date;
    @Column(name = "creation_date")
    private Date creation_date;

    public UniversityEntity(int id, String abbreviation, String full_title, Date founding_date, Date creation_date){
        this.id = id;
        this.abbreviation = abbreviation;
        this.full_title = full_title;
        this.founding_date = founding_date;
        this.creation_date = creation_date;
    }
    public UniversityEntity(){}

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    public void setFull_title(String full_title){
        this.full_title = full_title;
    }
    public String getFull_title(){
        return full_title;
    }
    public void setFounding_date(Date founding_date){
        this.founding_date = founding_date;
    }
    public Date getFounding_date(){
        return founding_date;
    }
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    public Date getCreation_date() {
        return creation_date;
    }

}

