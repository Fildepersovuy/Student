package com.student.repository;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;

import java.util.List;

public interface StudentRepository {

    List<StudentEntity> findAll();

    List<StudentEntity> findByName(String name);

    void addStudentEntity(List<StudentDto> studentDtoList);

    void updateStudentEntity(StudentDto studentDto, int id);
}
