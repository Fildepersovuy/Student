package com.student.Mapper;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;

public class StudentMapper {
    public StudentDto mapToDto(StudentEntity studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setFirst_name(studentEntity.getFirst_name());
        studentDto.setLast_name(studentEntity.getLast_name());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setGender(studentEntity.getGender());
        studentDto.setDate_of_birth(studentEntity.getDate_of_birth());
        studentDto.setCountry_of_birth(studentEntity.getCountry_of_birth());
        return studentDto;
    }
    public StudentEntity mapToEntity(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirst_name(studentDto.getFirst_name());
        studentEntity.setLast_name(studentDto.getLast_name());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setDate_of_birth(studentDto.getDate_of_birth());
        studentEntity.setCountry_of_birth(studentDto.getCountry_of_birth());
        return studentEntity;
    }
}
