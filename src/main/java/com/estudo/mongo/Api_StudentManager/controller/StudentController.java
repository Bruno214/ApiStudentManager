package com.estudo.mongo.Api_StudentManager.controller;

import com.estudo.mongo.Api_StudentManager.domain.Student;
import com.estudo.mongo.Api_StudentManager.dto.StudentRequestDto;
import com.estudo.mongo.Api_StudentManager.service.StudentService;
import com.estudo.mongo.Api_StudentManager.vo.StudentResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseVo>> getAllStudents() {
        List<StudentResponseVo> students  = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentRequestDto studentDto) {
        Student student = studentService.addStudent(studentDto);
        return new ResponseEntity<>(student.getId(), HttpStatus.CREATED);
    }
}

