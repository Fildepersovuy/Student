package com.student.domain;

public class StudentEntity {
    private int id;
    private String firstname;

    public StudentEntity() {
    }

    public StudentEntity(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
