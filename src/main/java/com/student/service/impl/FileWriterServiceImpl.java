package com.student.service.impl;

import com.student.dto.StudentDto;
import com.student.service.FileWriterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
@Slf4j
@Service
public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void write(List<StudentDto> list) throws IOException {
        log.info("начинаю запись в файл");
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

    public void readableRecord(List<StudentDto> list) {
        log.info("начинаю запись в файл в читабемом виде ");
        File myFile = new File("writingStudent");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println(list);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
