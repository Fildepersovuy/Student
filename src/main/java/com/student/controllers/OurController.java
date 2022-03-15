package com.student.controllers;


import com.student.domain.StudentEntity;
import com.student.domain.UniversityEntity;
import com.student.service.StudentService;
import com.student.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OurController {
    @Autowired
    private StudentService studentService;
    private UniversityService universityService;

    //http://localhost:8081/findByName?name=Bob
    @GetMapping("/findByName")
    public List<StudentEntity> findByName(@RequestParam("name") String name){
        return studentService.findByName(name);
    }

//    POST http://localhost:8081/addStudentEntity
//    Content-Type: application/json
//    {"first_name": "Sanya", "last_name": "Esip", "gender": "Male",
//            "email": "se@mail.com", "date_of_birth": "1991-02-30", "country_of_birth": "Russia"}
    @PostMapping("/addStudentEntity")
    public void newStudentEntity(@RequestBody StudentEntity newStudentEntity){
         studentService.addStudent(newStudentEntity);
    }

    //http://localhost:8081/findByAbbreviation?abbrev=ВГУ
    @GetMapping("/findByAbbreviation")
    public List<StudentEntity> findByAbbreviation(@RequestParam("abbrev") String abbrev){
        return universityService.findByAbbreviation(abbrev);
    }

    //    POST http://localhost:8081/addUniversityEntity
//    Content-Type: application/json
//    {"abbreviation": "ИАП", "full_title": "им.Александра Пивоглотова",
//      "founding_date": "2022-03-15"}
    @PostMapping("/addUniversityEntity")
    public void newUniversityEntity(@RequestBody UniversityEntity newUniversityEntity){
        universityService.addUniversityEntity(newUniversityEntity);
    }
}




