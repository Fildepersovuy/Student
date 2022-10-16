package com.student.mapper;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;

public class StudentMapper {

    private StudentMapper() {
    }

    public static StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(studentEntity.getFirstName());
        studentDto.setLastName(studentEntity.getLastName());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setGender(studentEntity.getGender());
        studentDto.setDateOfBirth(studentEntity.getDateOfBirth());
        studentDto.setCountryOfBirth(studentEntity.getCountryOfBirth());
        return studentDto;
    }

    public static StudentEntity mapToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDto.getFirstName());
        studentEntity.setLastName(studentDto.getLastName());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setDateOfBirth(studentDto.getDateOfBirth());
        studentEntity.setCountryOfBirth(studentDto.getCountryOfBirth());
        return studentEntity;
    }
}
