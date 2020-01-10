package com.test.etiqa.schoolrest.repositories;

import com.test.etiqa.schoolrest.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByIc(String ic);
}
