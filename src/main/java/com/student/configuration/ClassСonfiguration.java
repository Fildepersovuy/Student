package com.student.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
public class ClassСonfiguration {
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private int password;
    @Value("${datasource.url}")
    private String url;
    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.postgres.jdbc.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/student");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0992964446");
        return dataSource;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public int getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }
}

