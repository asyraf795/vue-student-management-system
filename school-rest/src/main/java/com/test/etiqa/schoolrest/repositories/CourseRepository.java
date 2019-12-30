package com.test.etiqa.schoolrest.repositories;

import com.test.etiqa.schoolrest.domains.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
