package com.student.controllers;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    //todo: изменить аозвращаемое значение на студент дто
    @GetMapping
    public List<StudentDto> findByName(@RequestParam("name") String name) {
        logger.info("trying to get the entity student = " + name);
        return studentService.findByName(name);
    }

    @PostMapping
    public void newStudentEntity(@RequestBody List<StudentDto> studentDtoList) {
        //todo: переписать через stream
        StringBuilder stringBuilder = new StringBuilder();
        for (StudentDto x : studentDtoList) {
            stringBuilder.append(x.getFirst_name()).append(" ").append(x.getLast_name());
        }
        logger.info("attempt to add entity student = " + stringBuilder);
        studentService.addStudentEntity(studentDtoList);
    }
    @PutMapping
    public void updateStudentEntity(@RequestBody StudentDto studentDto, @RequestParam("id") int id) {
        logger.info("attempt to update student data = " + studentDto.getLast_name());
        studentService.updateStudentEntity(studentDto, id);
    }
}




