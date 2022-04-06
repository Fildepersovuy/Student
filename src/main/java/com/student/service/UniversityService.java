package com.student.service;

import com.student.domain.UniversityEntity;
import com.student.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<UniversityEntity> findByAbbreviation(String abbrev){
        return universityRepository.findByAbbreviation(abbrev);
    }

    public void addUniversityEntity(List<UniversityEntity> university){
        // todo: написать код который вызывает университирепозиторий для каждого элемента из листа
        for(UniversityEntity x: university)
        universityRepository.addUniversityEntity(x.getAbbreviation(), x.getFull_title(), x.getFounding_date());
    }

}
