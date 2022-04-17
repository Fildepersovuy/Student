package com.student.repository;


import com.student.Mapper.StudentMapper;
import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
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
import java.util.Date;
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
    public void addStudentEntity (List<StudentDto> studentDtoList){
        String allQuery = "";
        StudentMapper studentMapper = new StudentMapper();
        for (StudentDto x: studentDtoList){
            StudentEntity studentEntity = studentMapper.mapToEntity(x);
            String query = "INSERT INTO students (first_name, last_name, gender, email, date_of_birth, country_of_birth) VALUES('"
                    +studentEntity.getFirst_name()+"','"+studentEntity.getLast_name()+"','"+studentEntity.getEmail()+"','"+studentEntity.getGender()+"','"+studentEntity.getDate_of_birth()+"','"+studentEntity.getCountry_of_birth()+"');\n";
            allQuery += query;
        }
        jdbcTemplate.execute(allQuery);
    }
    public void updateStudentEntity(List<StudentDto> studentDtoList, String firstName, String lastName ) {
        String allQuery = "";
        StudentMapper studentMapper = new StudentMapper();
        for (StudentDto x : studentDtoList) {
            StudentEntity studentEntity = studentMapper.mapToEntity(x);
            String query = "UPDATE students SET first_name = " + studentEntity.getFirst_name() + "', 'last_name = " + studentEntity.getLast_name() + "', 'gender = " + studentEntity.getGender() + "', 'email = " + studentEntity.getEmail() + "', 'date_of_birth = " + studentEntity.getDate_of_birth() + "', 'country_of_birth = " + studentEntity.getCountry_of_birth()+" WHERE first_name = "+firstName+" AND last_name = "+lastName;
            allQuery += query;
        }
        jdbcTemplate.execute(allQuery);
    }
}

