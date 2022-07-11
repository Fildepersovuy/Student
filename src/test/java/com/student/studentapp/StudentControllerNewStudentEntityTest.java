package com.student.studentapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.controllers.StudentController;
import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerNewStudentEntityTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentServiceImpl service;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void newStudentEntity() throws Exception {

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(getStudentDto()))
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals("", contentAsString);
        verify(service).addStudentEntity(getStudentDto());
    }

    @SneakyThrows
    private List<StudentDto> getStudentDto() {
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        studentDto.setFirstName("Sanya");
        studentDto.setLastName("Esip");
        studentDto.setEmail("se@gmail.ru");
        studentDto.setGender("male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");

        List<StudentDto> studentDtoList = new ArrayList<>();
        studentDtoList.add(studentDto); // List.of(studentDto)
        return studentDtoList;
    }
}