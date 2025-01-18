package com.estudo.mongo.Api_StudentManager.service;

import com.estudo.mongo.Api_StudentManager.repository.StudentRepository;
import com.estudo.mongo.Api_StudentManager.vo.StudentResponseVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseVo> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentResponseVo(student.getName(),
                        student.getRegistration(), student.getCpf())).toList();
    }

}
