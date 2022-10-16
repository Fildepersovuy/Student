package com.student.service.impl;

import com.student.service.UniversityService;
import com.student.mapper.UniversityMapper;
import com.student.dto.UniversityDto;
import com.student.repository.impl.UniversityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityRepositoryImpl universityRepository;

    public List<UniversityDto> findByAbbreviation(String abbrev) {
        return universityRepository.findByAbbreviation(abbrev)
                .stream()
                .map(UniversityMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void addUniversityEntity(List<UniversityDto> universityDtoList) {
        universityRepository.addUniversityEntity(universityDtoList);
    }
}
