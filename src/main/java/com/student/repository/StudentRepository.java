package com.student.repository;


import com.student.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentEntity> findAll(){
        return jdbcTemplate.queryForList("select * from info",StudentEntity.class);
    }

    public List<StudentEntity> findByName(String name) {
        String query = "select * from info where info.first_name = "+"'"+name+"'";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(StudentEntity.class));
    }
    public void updateName(int id, String newFirstname){
        jdbcTemplate.update("select info set firstname = ? where id = ?",new Object[]{id});
    }
    public List<StudentEntity> newFindByName(String firstname){
        return jdbcTemplate.query("select * from info where firstname = ?",
                new BeanPropertyRowMapper<>(StudentEntity.class),firstname);
    }


}
