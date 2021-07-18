package com.student.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class StudentRepository {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgres.driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/student");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0992964446");
        return dataSource;
    }
@Autowired
public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(dataSource());
}
}
