package com.student.studentapp;

import com.student.dto.StudentDto;
import com.student.repository.StudentRepository;
import com.student.service.FileWriterService;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;


public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private FileWriterService fileWriterService;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findByNameShouldCallRepositoryTest() throws IOException {
        List<StudentDto> studentDtoList = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        studentRepository.findByName("Sanya");

        List<StudentDto> actual = studentService.findByName("Sanya",false,true);

        assertNotNull(actual);
        assertEquals(studentDto,actual);
        verify(studentRepository).findByName("Sanya");
        verify(fileWriterService).write(studentDtoList);
        verify(fileWriterService).readableRecord(studentDtoList);
    }
}
