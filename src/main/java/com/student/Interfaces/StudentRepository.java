package com.student.Interfaces;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;

import java.util.List;

public interface StudentRepository {

    List<StudentEntity> findAll();

    List<StudentEntity> findByName(String name);

    void updateName(int id, String newFirstname);

    List<StudentEntity> newFindByName(String firstName);

    void addStudentEntity(List<StudentDto> studentDtoList);

    void updateStudentEntity(StudentDto studentDto, int id);
}
