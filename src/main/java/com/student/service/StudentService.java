package com.student.service;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findByName(String name){
        return studentRepository.findByName(name);
    }

    public void addStudentEntity(List<StudentDto> studentDtoList){
      studentRepository.addStudentEntity(studentDtoList);
    }
    public void updateStudentEntity(StudentDto studentDto, int id){
        studentRepository.updateStudentEntity(studentDto,id );
    }
}
