package com.student.service;

import com.student.UniversityMapper.UniversityMapper;
import com.student.domain.UniversityEntity;
import com.student.dto.UniversityDto;
import com.student.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<UniversityDto> findByAbbreviation(String abbrev){
        UniversityMapper universityMapper = new UniversityMapper();
        List<UniversityEntity> list = universityRepository.findByAbbreviation(abbrev);
        List<UniversityDto> list1 = new ArrayList<>();
        for(UniversityEntity x: list) {
            UniversityDto universityDto = universityMapper.mapToDto(x);
            list1.add(universityDto);
        }
        return list1;

    }

    public void addUniversityEntity(List<UniversityDto> universityDtoList){
            universityRepository.addUniversityEntity(universityDtoList);
    }

}
