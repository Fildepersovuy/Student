package com.student.controllers;


import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.dto.UniversityDto;
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
        logger.info("trying to get the entity student = "+name);
        return studentService.findByName(name);
    }

//    POST http://localhost:8081/addStudentEntity
//    Content-Type: application/json
//    {"first_name": "Sanya", "last_name": "Esip", "gender": "Male",
//            "email": "se@mail.com", "date_of_birth": "1991-02-30", "country_of_birth": "Russia"}
    @PostMapping("/addStudentEntity")
    public void newStudentEntity(@RequestBody List<StudentDto> studentDtoList){
        String allFirstNameAndLastName = "";
        for (StudentDto x: studentDtoList){
            allFirstNameAndLastName += x.getFirst_name()+" "+x.getLast_name()+" ";
        }
        logger.info("attempt to add entity student = "+allFirstNameAndLastName);
         studentService.addStudentEntity(studentDtoList);
    }
    //http://localhost:8081/findByAbbreviation?abbrev=VGU
    @GetMapping("/findByAbbreviation")
    public List<UniversityDto> findByAbbreviation(@RequestParam("abbrev") String abbrev){
        // todo: создать класс маппер который преобразует ентити в дто
        logger.info("trying to get the essence of the university = "+abbrev);
        return universityService.findByAbbreviation(abbrev);
    }
//    POST http://localhost:8081/addUniversityEntity
//    Content-Type: application/json
//
//    [
//  {
//    "abbreviation": "AP",
//    "full_title": "im.Aleksandra Pivoglotova",
//    "founding_date": "2020-03-15"
//  },
//  {
//    "abbreviation": "DEM",
//    "full_title": "im.Dmitriya Etilovogo monstra",
//    "founding_date": "2000-12-19"
//  }
//]
    @PostMapping("/addUniversityEntity")
    public void addUniversityEntity(@RequestBody List<UniversityDto> listUniversityDto){
        //todo: склеить все Full_title и записать в логи одной строкой через запятую
        String allFullTitle = "";
        for(UniversityDto x: listUniversityDto){
            allFullTitle+=x.getFull_title()+" ";
        }
        logger.info("trying to add entity university = "+allFullTitle);
        universityService.addUniversityEntity(listUniversityDto);
    }
    @PutMapping("/updateStudentEntity")
    public void updateStudentEntity(@RequestBody StudentDto studentDto, @RequestParam("id") int id){
        logger.info("attempt to update student data = "+studentDto.getLast_name());
        studentService.updateStudentEntity(studentDto, id);
    }
}




