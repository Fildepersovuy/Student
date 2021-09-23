package com.student.controllers;


import com.student.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OurController {
    @Autowired
    private StudentService studentService;

    //http://localhost:8081/findByName?name=Bob
    @GetMapping("/findByName")
    public StudentEntity findByName(@RequestParam("name") String name){
        return studentService findByName(name);
    }
    //http://localhost:8081/findByName/Bob
    @GetMapping("findByName/{name}")
    public StudentEntity findByName(@PathVariable("name") String name){
        return studentService.findByName(name);
    }
}


