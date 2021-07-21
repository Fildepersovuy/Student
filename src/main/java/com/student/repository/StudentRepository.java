package com.student.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String firstname;
    private String newFirstname;
    private int id;

    public void findAll(){
         jdbcTemplate.execute("Select * from info");
    }
    public void findByName(String firstname){
        jdbcTemplate.execute("select firstname from info");
        this.firstname=firstname;
    }
    public void updateName(int id,String newFirstname){
        jdbcTemplate.update("update info set firstname = newFirstname where id = ?");
        this.id=id;
        firstname=newFirstname;
    }

}
