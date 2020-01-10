package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.CourseDTO;
import com.test.etiqa.schoolrest.domains.StudentDTO;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void deleteById(int id);

    Course update(Course course);

    void assign(StudentDTO studentDTO);

    CourseDTO transfer(Course course);

    List<CourseDTO> transferAll();
}
