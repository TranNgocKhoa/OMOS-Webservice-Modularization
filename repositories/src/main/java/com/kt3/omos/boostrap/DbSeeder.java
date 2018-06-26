package com.kt3.omos.boostrap;

import com.kt3.omos.domain.Student;
import com.kt3.omos.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    StudentRepository studentRepository;

    public DbSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student khoa = new Student("Tran Ngoc Khoa", "18/11/1996");
        Student toan = new Student("Cao Nguyen Vu Toan", "20/08/1997");

        List<Student> listStudent = new ArrayList<>();

        listStudent.add(khoa);
        listStudent.add(toan);
        studentRepository.saveAll(listStudent);
    }
}
