package com.student.controllers;

import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public List<StudentDto> findByName(@RequestParam("name") String name,
                                       @RequestParam(value = "saveInFile", required = false) boolean saveInFile,
                                       @RequestParam(value = "saveInFileReadable", required = false) boolean saveInFileReadable) throws IOException {
        logger.info("trying to get the entity student = " + name);
        return studentService.findByName(name, saveInFile, saveInFileReadable);
    }

    @PostMapping
    public void newStudentEntity(@RequestBody List<@Valid StudentDto> studentDtoList) {
        String studDto = studentDtoList
                .stream()
                .map(studentDto ->
                        new StringBuilder(studentDto.getFirstName())
                                .append(" ")
                                .append(studentDto.getLastName())
                )
                .collect(Collectors.joining(","));
        logger.info("attempt to add entity student = " + studDto);
        studentService.addStudentEntity(studentDtoList);
    }

    @PutMapping
    public void updateStudentEntity(@RequestBody @Valid StudentDto studentDto, @RequestParam("id") int id) {
        logger.info("attempt to update student data = " + studentDto.getLastName());
        studentService.updateStudentEntity(studentDto, id);
    }
}




