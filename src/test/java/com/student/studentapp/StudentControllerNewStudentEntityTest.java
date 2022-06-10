package com.student.studentapp;

import com.student.controllers.StudentController;
import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;

import org.hibernate.mapping.Set;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerNewStudentEntityTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = (Validator) validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    @Test
    void newStudentEntityShouldValid(){
    StudentController studentController = new StudentController();
    List<StudentDto> studentDtoList = new ArrayList<>();
    studentController.newStudentEntity(studentDtoList);

//  Set<ConstraintViolation<StudentController>> violations = validator.validate(studentController);

    assertFalse(validator.validate(studentController).isEmpty());
    }
}
