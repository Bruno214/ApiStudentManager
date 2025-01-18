package com.estudo.mongo.Api_StudentManager.controller;

import com.estudo.mongo.Api_StudentManager.service.StudentService;
import com.estudo.mongo.Api_StudentManager.vo.StudentResponseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

