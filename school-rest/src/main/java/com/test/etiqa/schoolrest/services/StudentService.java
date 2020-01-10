package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.domains.StudentDTO;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void deleteById(int id);

    void saveAll(List<Student> students);

    List<Student> findByIc(String ic);

    StudentDTO transfer(Student student);

    List<StudentDTO> transferAll();

    List<Student> findAllByIds(List<Integer> studentIds);
}