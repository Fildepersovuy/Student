package com.student.mapper;

import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;

import java.util.Date;

public class UniversityMapper {


    public static UniversityDto mapToDto(UniversityEntity univ) {
        UniversityDto universityDto = new UniversityDto();
        universityDto.setAbbreviation(univ.getAbbreviation());
        universityDto.setFullTitle(univ.getFullTitle());
        universityDto.setFoundingDate(univ.getFoundingDate());
        return universityDto;
    }

    public static UniversityEntity mapToEntity(UniversityDto univ) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setAbbreviation(univ.getAbbreviation());
        universityEntity.setFullTitle(univ.getFullTitle());
        universityEntity.setFoundingDate(univ.getFoundingDate());
        universityEntity.setCreationDate(new Date());                     // записываев дату в бд
        return universityEntity;
    }

}
