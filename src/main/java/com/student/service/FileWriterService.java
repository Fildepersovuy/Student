package com.student.service;

import com.student.dto.StudentDto;

import java.io.IOException;
import java.util.List;

public interface FileWriterService {

    void write(List<StudentDto> list) throws IOException;
}
