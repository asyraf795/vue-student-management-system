package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void deleteById(int id);

    Map<Integer, String> findStudentsById(int id);

    Course update(Course course);
}
