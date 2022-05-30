package com.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "universities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "full_title")
    private String fullTitle;
    @Column(name = "founding_date")
    private Date foundingDate;
    @Column(name = "creation_date")
    private Date creationDate;

//    public UniversityEntity(int id, String abbreviation, String fullTitle, Date foundingDate, Date creationDate) {
//        this.id = id;
//        this.abbreviation = abbreviation;
//        this.fullTitle = fullTitle;
//        this.foundingDate = foundingDate;
//        this.creationDate = creationDate;
//    }
//
//    public UniversityEntity() {
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setAbbreviation(String abbreviation) {
//        this.abbreviation = abbreviation;
//    }
//
//    public String getAbbreviation() {
//        return abbreviation;
//    }
//
//    public void setFullTitle(String full_title) {
//        this.fullTitle = full_title;
//    }
//
//    public String getFullTitle() {
//        return fullTitle;
//    }
//
//    public void setFoundingDate(Date founding_date) {
//        this.foundingDate = founding_date;
//    }
//
//    public Date getFoundingDate() {
//        return foundingDate;
//    }
//
//    public void setCreationDate(Date creation_date) {
//        this.creationDate = creation_date;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }

}

