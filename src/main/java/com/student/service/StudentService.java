package com.student.service;

import com.student.domain.StudentEntity;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findByName(String name){
        return studentRepository.findByName(name);
    }

}
