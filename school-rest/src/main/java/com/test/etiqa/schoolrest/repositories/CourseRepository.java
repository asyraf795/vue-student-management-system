package com.test.etiqa.schoolrest.repositories;

import com.test.etiqa.schoolrest.domains.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTitle(String title);
}
