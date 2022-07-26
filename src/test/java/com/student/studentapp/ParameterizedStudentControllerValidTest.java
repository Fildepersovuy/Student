package com.student.studentapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
//@WebMvcTest(StudentController.class)
@SpringBootTest
public class ParameterizedStudentControllerValidTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentServiceImpl service;
    private ObjectMapper objectMapper = new ObjectMapper();

    @ParameterizedTest
    @MethodSource("getParams")
    void newStudentEntityValid(List<StudentDto> list, String response) throws Exception {

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(list))
                )
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(response, contentAsString);
    }

    private static Stream<Arguments> getParams() throws ParseException {
       return Stream.of(invalidFirstName());
    }

    private static Arguments invalidFirstName() throws ParseException {

        StudentDto studentDto = new StudentDto();

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("");
        studentDto.setLastName("Esip");
        studentDto.setEmail("se@mail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");

        String response = "{\"message\":\"newStudentEntity.studentDtoList[0].firstName: must not be empty, newStudentEntity.studentDtoList[0].firstName: firstName should be between 1 and 50 characters\",\"code\":\"BAD_REQUEST\"}";

        List<StudentDto> list = new ArrayList<>();
        list.add(studentDto);

        return Arguments.of(list,response);
    }


}
