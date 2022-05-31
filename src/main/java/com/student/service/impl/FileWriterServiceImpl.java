package com.student.service.impl;

import com.student.controllers.StudentController;
import com.student.dto.StudentDto;
import com.student.service.FileWriterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
@Service
public class FileWriterServiceImpl implements FileWriterService {

    private static final Logger logger = LoggerFactory.getLogger(FileWriterServiceImpl.class);
    @Override
    public void write(List<StudentDto> list) throws IOException {
        logger.info("начинаю запись в файл");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("writingStudent"));
            oos.writeObject(list);
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            oos.close();
        }


    }
}
