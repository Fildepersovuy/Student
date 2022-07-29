package com.student.studentapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.controllers.StudentController;
import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@AutoConfigureMockMvc
@WebMvcTest(StudentController.class)
//@SpringBootTest
public class StudentControllerValidTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentServiceImpl service;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void newStudentEntityNoValidFirstName() throws Exception {
        List<StudentDto> list = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("");
        studentDto.setLastName("Esip");
        studentDto.setEmail("se@mail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");
        list.add(studentDto);

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(list))
                )
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String response = "{\"message\":\"newStudentEntity.studentDtoList[0].firstName: must not be empty, newStudentEntity.studentDtoList[0].firstName: firstName should be between 1 and 50 characters\",\"code\":\"BAD_REQUEST\"}";
        assertEquals(response,contentAsString);
    }

    @Test
    void newStudentEntityNoValidLastName() throws Exception {
        List<StudentDto> list = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("Sanya");
        studentDto.setLastName("");
        studentDto.setEmail("se@mail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");
        list.add(studentDto);

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(list))
                )
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String response = "{\"message\":\"newStudentEntity.studentDtoList[0].lastName: must not be blank, newStudentEntity.studentDtoList[0].lastName: lastName should be between 1 and 50 characters\",\"code\":\"BAD_REQUEST\"}";
        assertEquals(response,contentAsString);
    }

    @Test
    void newStudentEntityNoValidEmil() throws Exception {
        List<StudentDto> list = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("Sanya");
        studentDto.setLastName("Esip");
        studentDto.setEmail("semail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");
        list.add(studentDto);

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(list))
                )
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String response = "{\"message\":\"newStudentEntity.studentDtoList[0].email: Email should be valid\",\"code\":\"BAD_REQUEST\"}";
        assertEquals(response,contentAsString);
    }
}
