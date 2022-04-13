package com.student.repository;

import com.student.UniversityMapper.UniversityMapper;
import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;
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
    public void addUniversityEntity(List<UniversityDto> universityDtoList){
        //todo: написать цикл чтобы для каждого ДТО создавалась вставка, чтобы все вставки скрепить в одну query и записать в базу
        String allQuery = "";
        UniversityMapper universityMapper = new UniversityMapper();
        for(UniversityDto x: universityDtoList){
            UniversityEntity universityEntity = universityMapper.mapToEntity(x);
            String query = "INSERT INTO universities (abbreviation, full_title, founding_date, creation_date ) VALUES('"
                    +universityEntity.getAbbreviation()+"','"+universityEntity.getFull_title()+"','"+universityEntity.getFounding_date()+"','"+universityEntity.getCreation_date()+"');\n";
            allQuery+= query;
        }
        jdbcTemplate.execute(allQuery);

    }
}
