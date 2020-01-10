package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.CourseDTO;
import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.domains.StudentDTO;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void deleteById(int id);

    void assign(StudentDTO studentDTO);

    void assign(CourseDTO courseDTO);

    CourseDTO transfer(Course course);

    List<CourseDTO> transferAll();

    List<Course> findByTitle(String title);

    void setCourseAll(List<Student> students, Course course);

    void removeReference(Course course, List<Integer> exceptionStudentIds);
}
