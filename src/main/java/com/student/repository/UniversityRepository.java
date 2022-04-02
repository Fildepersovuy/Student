package com.student.repository;

import com.student.domain.UniversityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UniversityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UniversityEntity> findByAbbreviation(String abbrev) {
        String query = "SELECT * FROM universities WHERE universities.abbreviation = "+"'"+abbrev+"'";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(UniversityEntity.class));
    }
    public void addTwoUniversityEntity(String abbreviation, String full_title, Date founding_date ){
        String query = "INSERT INTO universities (abbreviation, full_title, founding_date ) VALUES('"
                +abbreviation+"'"+",'"+full_title+"'"+",'"+founding_date+"')," +
                "('"+abbreviation+"'"+",'"+full_title+"'"+",'"+founding_date+"');";
        jdbcTemplate.execute(query);
    }
}
