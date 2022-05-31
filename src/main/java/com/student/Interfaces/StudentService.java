package com.student.Interfaces;

import com.student.dto.StudentDto;

import java.net.MalformedURLException;
import java.util.List;

public interface StudentService {

    List<StudentDto> findByName(String name, String param) throws MalformedURLException;

    void addStudentEntity(List<StudentDto> studentDtoList);

    void updateStudentEntity(StudentDto studentDto, int id);
}
