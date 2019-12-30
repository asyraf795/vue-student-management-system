package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

    Student update(Student student);
}