package com.student.repository;


import com.student.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String firstname;
    private String newFirstname;
    private int id;

    public void findAll1(){
         jdbcTemplate.execute("select * from info");
    }
    public List<StudentEntity> findAll2(){
        return jdbcTemplate.queryForList("select * from info",StudentEntity.class);
    }
    public void findByName1(String firstname){
        jdbcTemplate.execute("select firstname from info");
        this.firstname=firstname;
    }
    public List<StudentEntity> findByName2(String firstname){
        String query = String.format("select * from info where firstname = %s",firstname);
        return jdbcTemplate.queryForList(query,StudentEntity.class);
    }
    public void updateName(int id, String newFirstname){
        jdbcTemplate.update("select info set firstname = ? where id = ?",new Object[]{firstname,id});
    }
    public List<StudentEntity> newFindByName(String firstname){
        return jdbcTemplate.query("select * from info where firstname = ?",
                new BeanPropertyRowMapper<>(StudentEntity.class),firstname);
    }


}
