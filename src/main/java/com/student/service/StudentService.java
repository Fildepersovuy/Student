package com.student.service;

import com.student.dto.StudentDto;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    List<StudentDto> findByName(String name, boolean saveInFile) throws IOException;

    void addStudentEntity(List<StudentDto> studentDtoList);

    void updateStudentEntity(StudentDto studentDto, int id);
}
