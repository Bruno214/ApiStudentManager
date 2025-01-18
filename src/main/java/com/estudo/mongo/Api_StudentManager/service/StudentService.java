package com.estudo.mongo.Api_StudentManager.service;

import com.estudo.mongo.Api_StudentManager.converter.StudentConverter;
import com.estudo.mongo.Api_StudentManager.domain.Student;
import com.estudo.mongo.Api_StudentManager.dto.StudentRequestDto;
import com.estudo.mongo.Api_StudentManager.repository.StudentRepository;
import com.estudo.mongo.Api_StudentManager.vo.StudentResponseVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    public StudentService(StudentRepository studentRepository, StudentConverter studentConverter) {
        this.studentRepository = studentRepository;
        this.studentConverter = studentConverter;
    }

    public List<StudentResponseVo> getAll() {
        return studentRepository.findAll().stream()
                .map(studentConverter::convertStudent).toList();
    }

    public Student addStudent(StudentRequestDto studentDto) {
        String registration = UUID.randomUUID().toString();
        Student student = new Student(null, studentDto.name(), registration, studentDto.cpf());
        return this.studentRepository.save(student);
    }

}
