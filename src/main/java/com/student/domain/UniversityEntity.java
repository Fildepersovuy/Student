package com.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "universities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "full_title")
    private String fullTitle;
    @Column(name = "founding_date")
    private Date foundingDate;
    @Column(name = "creation_date")
    private Date creationDate;
}

