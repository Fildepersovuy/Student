package com.student.UniversityMapper;

import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;

public class UniversityMapper {


    public UniversityDto mapToDto(UniversityEntity univ){

        UniversityDto universityDto = new UniversityDto();
        universityDto.setAbbreviation(univ.getAbbreviation());
        universityDto.setFull_title(univ.getFull_title());
        universityDto.setFounding_date(univ.getFounding_date());
        return universityDto;
    }

    public UniversityEntity mapToEntity(UniversityDto univ){
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setAbbreviation(univ.getAbbreviation());
        universityEntity.setFull_title(univ.getFull_title());
        universityEntity.setFounding_date(univ.getFounding_date());
        return universityEntity;
    }

}
