package com.student.repository;

import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;

import java.util.List;

public interface UniversityRepository {

    List<UniversityEntity> findByAbbreviation(String abbrev);

    void addUniversityEntity(List<UniversityDto> universityDtoList);


}
