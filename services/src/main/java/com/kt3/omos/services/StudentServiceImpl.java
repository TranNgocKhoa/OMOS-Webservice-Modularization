package com.kt3.omos.services;

import com.kt3.omos.domain.Student;
import com.kt3.omos.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public Student getStudentById(String id) {
        //return studentRepository.findById(Long.valueOf(id)).get();
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> saveAllStudent(List<Student> studentList) {
        //return studentRepository.saveAll(studentList);
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudentById(String id) {
        return false;
    }
}
