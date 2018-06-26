package com.kt3.omos.services;

import com.kt3.omos.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getStudentsByName(String name);
    Student getStudentById(String id);
    Student saveStudent(Student student);
    List<Student> saveAllStudent(List<Student> studentList);
    boolean deleteStudent(Student student);
    boolean deleteStudentById(String id);
}
