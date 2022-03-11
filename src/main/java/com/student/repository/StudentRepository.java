package com.student.repository;


import com.student.domain.StudentEntity;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentEntity> findAll(){
        return jdbcTemplate.queryForList("select * from students",StudentEntity.class);
    }

    public List<StudentEntity> findByName(String name) {
        String query = "select * from students where students.first_name = "+"'"+name+"'";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(StudentEntity.class));
    }
    public void updateName(int id, String newFirstname){
        jdbcTemplate.update("select * from students set firstname = ? where id = ?",new Object[]{id});
    }
    public List<StudentEntity> newFindByName(String firstname){
        return jdbcTemplate.query("select * from students where firstname = ?",
                new BeanPropertyRowMapper<>(StudentEntity.class),firstname);
    }
    public void addStudentEntity (String first_name, String last_name, String gender, String email, Data date_of_birth, String coutry_of_birth){
        String query = "INSERT INTO students (first_name, last_name, gender, email, date_of_birth, country_of_birth) VALUES('"
                +first_name+"'"+",'"+last_name+"'"+",'"+gender+"'"+",'"+email+"'"+",'"+date_of_birth+"'"+",'"+coutry_of_birth+"');";

    }


}
