package com.student.service;

import com.student.domain.StudentEntity;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findByName(String name){
        return studentRepository.findByName(name);
    }

    public void addStudent(StudentEntity student){
      studentRepository.addStudentEntity(student.getFirst_name(),student.getLast_name(),student.getGender(),student.getEmail(),student.getDate_of_birth(),student.getCountry_of_birth());
    }
}
