package com.student.service;

import com.student.domain.UniversityEntity;
import com.student.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<UniversityEntity> findByAbbreviation(String abbrev){
        return universityRepository.findByAbbreviation(abbrev);
    }

    public void addTwoUniversityEntity(List<UniversityEntity> university){
        // todo: написать код который вызывает университирепозиторий для каждого элемента из листа
        universityRepository.addUniversityEntity(university.getAbbreviation(), university.getFull_title(), university.getFounding_date());
    }

}
