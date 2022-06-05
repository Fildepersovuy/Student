package com.student.studentapp;

import com.student.dto.StudentDto;
import com.student.repository.StudentRepository;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findByNameShouldCallRepositoryTest() throws IOException {
        StudentDto studentDto =  Mockito.mock(StudentDto.class);
        studentRepository.findByName("Sanya");

        List<StudentDto> actual = studentService.findByName("Sanya",false,true);

        assertNotNull(actual);
        assertEquals(studentDto,actual);
        verify(studentRepository).findByName("Sanya");
    }
}
