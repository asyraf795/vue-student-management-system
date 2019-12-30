package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Map<Integer, String> findStudentsById(int id) {
        Course course = findById(id);
        List<Student> students = course.getStudents();
        Map<Integer, String> studentsNames = new HashMap<>();
        for (Student student : students) {
            studentsNames.put(student.getId(), student.getFirstName() + " " + student.getLastName());
        }
        return studentsNames;
    }

    @Override
    public Course update(Course course) {
        Course updateCourse = findById(course.getId());
        if (course.getTitle() != null) {
            updateCourse.setTitle(course.getTitle());
        }
        if (course.getAbbreviation() != null) {
            updateCourse.setAbbreviation(course.getAbbreviation());
        }
        if (course.getStudents().isEmpty()) {
            updateCourse.setStudents(course.getStudents());
        }
        courseRepository.save(updateCourse);

        return updateCourse;
    }
}
