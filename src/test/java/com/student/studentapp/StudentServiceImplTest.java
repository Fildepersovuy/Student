package com.student.studentapp;

import com.student.domain.StudentEntity;
import com.student.dto.StudentDto;
import com.student.repository.StudentRepository;
import com.student.repository.impl.StudentRepositoryImpl;
import com.student.service.FileWriterService;
import com.student.service.impl.FileWriterServiceImpl;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private FileWriterServiceImpl fileWriterService;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findByNameShouldCallRepositoryTest() throws IOException, ParseException {
        Mockito.when(studentRepository.findByName(anyString())).thenReturn(getStudentEntity());

        List<StudentDto> actual = studentService.findByName("Sanya",false,true);

        assertNotNull(actual);
        assertEquals(1,actual.size());
        verify(studentRepository).findByName("Sanya");
        verify(fileWriterService).write(actual);
        verify(fileWriterService).readableRecord(actual);
    }
    private List<StudentEntity> getStudentEntity() throws ParseException {
        StudentEntity studentEntity = new StudentEntity();                                    // дано:
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        studentEntity.setFirstName("Sanya");
        studentEntity.setLastName("Esip");
        studentEntity.setEmail("se@gmail.ru");
        studentEntity.setGender("male");
        studentEntity.setDateOfBirth(date);
        studentEntity.setCountryOfBirth("Russia");
        return List.of(studentEntity);
    }
}
