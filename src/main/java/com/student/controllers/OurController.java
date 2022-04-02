package com.student.controllers;


import com.student.domain.StudentEntity;
import com.student.domain.UniversityEntity;
import com.student.service.StudentService;
import com.student.service.UniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OurController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;
    private static final Logger logger = LoggerFactory.getLogger(OurController.class);

    //http://localhost:8081/findByName?name=Sanya
    @GetMapping("/findByName")
    public List<StudentEntity> findByName(@RequestParam("name") String name){
        logger.info("trying to get the entity student = Sanya");
        return studentService.findByName(name);
    }

//    POST http://localhost:8081/addStudentEntity
//    Content-Type: application/json
//    {"first_name": "Sanya", "last_name": "Esip", "gender": "Male",
//            "email": "se@mail.com", "date_of_birth": "1991-02-30", "country_of_birth": "Russia"}
    @PostMapping("/addStudentEntity")
    public void newStudentEntity(@RequestBody StudentEntity newStudentEntity){
        logger.info("attempt to add entity student = Sanya");
         studentService.addStudent(newStudentEntity);
    }

    //http://localhost:8081/findByAbbreviation?abbrev=VGU
    @GetMapping("/findByAbbreviation")
    public List<UniversityEntity> findByAbbreviation(@RequestParam("abbrev") String abbrev){
        logger.info("trying to get the essence of the university = VGU");
        return universityService.findByAbbreviation(abbrev);
    }

//    POST http://localhost:8081/addUniversityEntity
//    Content-Type: application/json
//
//    {"abbreviation": "AP", "full_title": "im.Aleksandra Pivoglotova", "founding_date": "2020-03-15",
//            "abbreviation": "DEM", "full_title": "im.Dmitriya Etilovogo monstra", "founding_date": "2000-12-19"}
    @PostMapping("/addUniversityEntity")
    public void newTwoUniversityEntity(@RequestBody UniversityEntity newUniversityEntity){
        logger.info("trying to add entity university = AP, DEM");
        universityService.addTwoUniversityEntity(newUniversityEntity);
    }
}




