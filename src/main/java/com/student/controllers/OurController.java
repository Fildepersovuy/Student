package com.student.controllers;


import com.student.domain.StudentEntity;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OurController {
    @Autowired
    private StudentService studentService;

    //http://localhost:8081/findByName?name=Bob
    @GetMapping("/findByName")
    public List<StudentEntity> findByName(@RequestParam("name") String name){
        return studentService.findByName(name);
    }

//    @PostMapping("/addStudentEntity")
//    public StudentEntity newStudentEntity(@RequestBody StudentEntity newStudentEntity){
//        return studentService.addStudentEntity(newStudentEntity);
//    }
}




