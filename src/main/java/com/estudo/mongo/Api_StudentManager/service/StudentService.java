package com.estudo.mongo.Api_StudentManager.service;

import com.estudo.mongo.Api_StudentManager.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

}
