package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {
    @NotNull
    private String abbreviation;
    @NotNull
    private String fullTitle;
    @Past
    private Date foundingDate;
}
