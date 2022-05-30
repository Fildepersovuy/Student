package com.student.Interfaces.Impl;

import com.student.Interfaces.StudentService;
import com.student.Mapper.StudentMapper;
import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.Interfaces.Impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepositoryImpl studentRepository;

    public List<StudentDto> findByName(String name) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("writingStudent"));
            oos.writeObject(StudentDto.class);
            oos.close();
        } catch (IOException e) {
            System.out.println("неверное имя файла "+e);
        }
        return studentRepository.findByName(name)
                .stream()
                .map(StudentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void addStudentEntity(List<StudentDto> studentDtoList) {
        studentRepository.addStudentEntity(studentDtoList);
    }

    public void updateStudentEntity(StudentDto studentDto, int id) {
        studentRepository.updateStudentEntity(studentDto, id);
    }
}
