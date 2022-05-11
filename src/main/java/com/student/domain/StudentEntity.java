package com.student.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "country_of_birth")
    private String countryOfBirth;
    private String FIO;

//    public StudentEntity(int id, String firstName, String lastName, String email, String gender, Date dateOfBirth, String countryOfBirth) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//        this.dateOfBirth = dateOfBirth;
//        this.countryOfBirth = countryOfBirth;
//    }
//
//    public StudentEntity() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String first_name) {
//        this.firstName = first_name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String last_name) {
//        this.lastName = last_name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date date_of_birth) {
//        this.dateOfBirth = date_of_birth;
//    }
//
//    public String getCountryOfBirth() {
//        return countryOfBirth;
//    }
//
//    public void setCountryOfBirth(String country_of_birth) {
//        this.countryOfBirth = country_of_birth;
//    }
//
//    public void setFIO(String FIO) {
//        this.FIO = FIO;
//    }
//
//    public String getFIO() {
//        return FIO;
//    }
//
//    public String toString() {
//        return firstName + " " + lastName + " " + email;
//    }

}


