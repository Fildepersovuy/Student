package com.student.service;

import com.student.domain.UniversityEntity;
import com.student.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

class University {
    int id;
    String abbreviation;
    String full_title;
    Date founding_date;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    public void setFull_title(String full_title){
        this.full_title = full_title;
    }
    public String getFull_title(){
        return full_title;
    }
    public void setFounding_date(Date founding_date){
        this.founding_date = founding_date;
    }
    public Date getFounding_date(){
        return founding_date;
    }
}
@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<UniversityEntity> findByAbbreviation(String abbrev){
        return universityRepository.findByAbbreviation(abbrev);
    }

    public void addTwoUniversityEntity(UniversityEntity university){
        universityRepository.addTwoUniversityEntity(university.getAbbreviation(), university.getFull_title(), university.getFounding_date());
    }
public University getUniversity() {
        University university = new University();
        university.setAbbreviation("AP");
        return university;
}
}
