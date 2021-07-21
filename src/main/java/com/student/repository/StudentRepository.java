package com.student.repository;

import com.student.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentEntity> findAll() {
         return jdbcTemplate.queryForList("Select * from student", StudentEntity.class);
    }

    public List<StudentEntity> findByName(String firstname) {
        String query = String.format("select * from student where firstname = %s", firstname);
        return jdbcTemplate.queryForList(query, StudentEntity.class);
    }

    public void updateName(int id, String firstname){
        jdbcTemplate.update("update info set firstname = ? where id = ?", new Object[] {firstname, id});
    }

    public List<StudentEntity> newFindByName(String firstname) {
        return jdbcTemplate.query(
                "select * from student where firstname = ?",
                new BeanPropertyRowMapper<>(StudentEntity.class),
                firstname
        );
    }
}
