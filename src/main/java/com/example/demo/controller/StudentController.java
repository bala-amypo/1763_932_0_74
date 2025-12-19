package com.example.demo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
    this.service = service;
}

@PostMapping("/addStudents")
public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
    return new ResponseEntity<>(service.saveStudent(student),HttpStatus.CREATED);
}

@GetMapping
public List<Student> getAllStudents() {
    return service.getAllStudents();
}

@GetMapping("/getStudents/{id}")
public Student getStudent(@PathVariable Long id) {
    return service.getStudentById(id);
}

@PutMapping("/students/{id}")
public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student student){
    return service.updateStudent(id, student);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(id);
    return ResponseEntity.ok("Student deleted successfully");}
}