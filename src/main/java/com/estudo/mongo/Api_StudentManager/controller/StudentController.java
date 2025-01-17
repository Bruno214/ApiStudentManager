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

    @GetMapping("user/{id}")
    public ResponseEntity<StudentResponseVo> getStudentById(@PathVariable String id) {
        StudentResponseVo  student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentRequestDto studentDto) {
        Student student = studentService.addStudent(studentDto);
        return new ResponseEntity<>(student.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody StudentRequestDto studentDto, @PathVariable String id) {
        Student student = studentService.updateStudent(studentDto, id);
        return new ResponseEntity<>(student.getId(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletetudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

