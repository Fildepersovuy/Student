package com.student.Mapper;

import com.student.domain.StudentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<StudentEntity> {

    @Override
    public StudentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(resultSet.getInt("id"));
        studentEntity.setFirstName(resultSet.getString("first_name"));
        studentEntity.setLastName(resultSet.getString("last_name"));
        studentEntity.setEmail(resultSet.getString("email"));
        studentEntity.setGender(resultSet.getString("gender"));
        studentEntity.setDateOfBirth(resultSet.getDate("date_of_birth"));
        studentEntity.setCountryOfBirth(resultSet.getString("country_of_birth"));
        studentEntity.setFIO(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        return studentEntity;
    }
}
