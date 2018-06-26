package com.kt3.omos.controllers;

import com.kt3.omos.domain.Student;
import com.kt3.omos.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

}
