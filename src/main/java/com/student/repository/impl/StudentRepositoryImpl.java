package com.student.repository.impl;


import com.student.mapper.StudentMapper;
import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository, Serializable {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentEntity> findAll() {
        return jdbcTemplate.queryForList("select * from students", StudentEntity.class);
    }

    public List<StudentEntity> findByName(String name) {
        String query = String.format("select * from students where students.first_name = '%s'\n;", name);
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(StudentEntity.class));
    }

    public void updateName(int id, String newFirstname) {
        jdbcTemplate.update("select * from students set firstname = ? where id = ?", new Object[]{id});
    }

    public List<StudentEntity> newFindByName(String firstName) {
        return jdbcTemplate.query("select * from students where firstname = ?",
                new BeanPropertyRowMapper<>(StudentEntity.class), firstName);
    }

    public void addStudentEntity(List<StudentDto> studentDtoList) {
        String allQuery = "";
        StudentMapper studentMapper = new StudentMapper();
        for (StudentDto x : studentDtoList) {
            StudentEntity studentEntity = studentMapper.mapToEntity(x);
            String query = String.format("INSERT INTO students (first_name, last_name, gender, email, date_of_birth, country_of_birth) VALUES('%s', '%s', '%s', '%s', '%s', '%s');\n", studentEntity.getFirstName(), studentEntity.getLastName(), studentEntity.getGender(), studentEntity.getEmail(), studentEntity.getDateOfBirth(), studentEntity.getCountryOfBirth());
            allQuery += query;
        }
        jdbcTemplate.execute(allQuery);
    }

    public void updateStudentEntity(StudentDto studentDto, int id) {
        StudentMapper studentMapper = new StudentMapper();
        StudentEntity studentEntity = studentMapper.mapToEntity(studentDto);
        String query = String.format("UPDATE students SET first_name = '%s', last_name = '%s', gender = '%s', email = '%s', date_of_birth = '%s', country_of_birth = '%s' WHERE id = '%s';\n", studentEntity.getFirstName(), studentEntity.getLastName(), studentEntity.getGender(), studentEntity.getEmail(), studentEntity.getDateOfBirth(), studentEntity.getCountryOfBirth(), id);
        //String query = "UPDATE students SET first_name = '" + studentEntity.getFirst_name() + "', last_name = '" + studentEntity.getLast_name() + "', gender = '" + studentEntity.getGender() + "', email = '" + studentEntity.getEmail() + "', date_of_birth = '" + studentEntity.getDate_of_birth() + "', country_of_birth = '" + studentEntity.getCountry_of_birth()+"' WHERE id = '"+id+"'";
        jdbcTemplate.execute(query);
    }
}

