package com.student.repository;

import com.student.domain.StudentEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<StudentEntity> {

    @Override
    public StudentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(resultSet.getInt("id"));
        studentEntity.setFirst_name(resultSet.getString("first_name"));
        studentEntity.setLast_name(resultSet.getString("last_name"));
        studentEntity.setEmail(resultSet.getString("email"));
        studentEntity.setGender(resultSet.getString("gender"));
        studentEntity.setDate_of_birth(resultSet.getDate("date_of_birth"));
        studentEntity.setFIO(resultSet.getString("first_name")+" "+resultSet.getString("last_name"));


        return studentEntity;
    }
}
