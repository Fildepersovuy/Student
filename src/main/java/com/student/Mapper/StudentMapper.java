package com.student.Mapper;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;

public class StudentMapper {
    public StudentDto mapToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirst_name(studentEntity.getFirstName());
        studentDto.setLast_name(studentEntity.getLastName());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setGender(studentEntity.getGender());
        studentDto.setDate_of_birth(studentEntity.getDateOfBirth());
        studentDto.setCountry_of_birth(studentEntity.getCountryOfBirth());
        return studentDto;
    }

    public StudentEntity mapToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentDto.getFirst_name());
        studentEntity.setLastName(studentDto.getLast_name());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setDateOfBirth(studentDto.getDate_of_birth());
        studentEntity.setCountryOfBirth(studentDto.getCountry_of_birth());
        return studentEntity;
    }
}
