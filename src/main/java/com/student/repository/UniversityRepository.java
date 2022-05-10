package com.student.repository;

import com.student.Mapper.UniversityMapper;
import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniversityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UniversityEntity> findByAbbreviation(String abbrev) {
        String query = String.format("SELECT * FROM universities WHERE universities.abbreviation = '%s';\n", abbrev);
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UniversityEntity.class));
    }

    public void addUniversityEntity(List<UniversityDto> universityDtoList) {
        String allQuery = "";
        UniversityMapper universityMapper = new UniversityMapper();
        for (UniversityDto x : universityDtoList) {
            UniversityEntity universityEntity = universityMapper.mapToEntity(x);
            String query = String.format("INSERT INTO universities (abbreviation, full_title, founding_date, creation_date ) VALUES('%s', '%s', '%s', '%s');\n", universityEntity.getAbbreviation(), universityEntity.getFullTitle(), universityEntity.getFoundingDate(), universityEntity.getCreationDate());
            allQuery += query;
        }
        jdbcTemplate.execute(allQuery);

    }
}
