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
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerFindByNameTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentServiceImpl service;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void updateStudentEntity() throws Exception {

        given(service.findByName("Sanya", false, true))
                .willReturn(getStudentDto());

        String contentAsString = mvc.perform(
                        get("/student?name=Sanya&saveInFileReadable=true")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals("[{\"firstName\":\"Sanya\",\"lastName\":\"Esip\",\"email\":\"se@mail.ru\",\"gender\":\"Male\",\"dateOfBirth\":\"1991-03-01T21:00:00.000+00:00\",\"countryOfBirth\":\"Russia\"}]",
                contentAsString);
    }

    @SneakyThrows
    private List<StudentDto> getStudentDto() {
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("Sanya");
        studentDto.setLastName("Esip");
        studentDto.setEmail("se@mail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");

        return List.of(studentDto);
    }

}
