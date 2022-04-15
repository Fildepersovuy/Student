package com.student.Mapper;

import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;

import java.util.Date;

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
        universityEntity.setCreation_date(new Date());                     // записываев дату в бд
        return universityEntity;
    }

}
