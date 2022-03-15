package com.student.repository;

import com.student.domain.StudentEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UniversityRepository {

    private JdbcTemplate jdbcTemplate;

    public List<StudentEntity> findByAbbreviation(String abbrev) {
        String query = "select * from universities where universities.abbreviation = "+"'"+abbrev+"'";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(StudentEntity.class));
    }
    public void addUniversityEntity (String abbreviation, String full_title, Date founding_date ){
        String query = "INSERT INTO universities (abbreviation, full_title, founding_date ) VALUES('"
                +abbreviation+"'"+",'"+full_title+"'"+",'"+founding_date+"');";
        jdbcTemplate.execute(query);
    }
}
