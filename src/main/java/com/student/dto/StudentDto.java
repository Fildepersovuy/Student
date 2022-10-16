package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
    @NotEmpty
    @Size(min = 1, max = 50, message = "firstName should be between 1 and 50 characters")
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 50, message = "lastName should be between 1 and 50 characters")
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    private String gender;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String countryOfBirth;
}
