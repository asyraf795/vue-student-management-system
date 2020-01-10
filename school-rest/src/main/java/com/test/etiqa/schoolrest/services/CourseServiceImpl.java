package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.CourseDTO;
import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.domains.StudentDTO;
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

    @Override
    public void assign(StudentDTO studentDTO) {
        Course course = findById(studentDTO.getCourseId());
        List<Student> students = course.getStudents();
        Student student = new Student(studentDTO.getId(), studentDTO.getIc(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getGender(), studentDTO.getPhoneNumber(), studentDTO.getEmail(), studentDTO.getDateOfBirth(), studentDTO.getAddress(), studentDTO.getPostcode(), studentDTO.getState(), studentDTO.getCountry(), course);
        students.add(student);
        course.setStudents(students);
        save(course);
    }

    @Override
    public CourseDTO transfer(Course course) {
        List<Student> students = course.getStudents();
        List<Integer> studentIDs = new ArrayList<>();
        for(Student student:students) {
            studentIDs.add(student.getId());
        }
        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getTitle(), course.getAbbreviation());
        courseDTO.setStudentIDs(studentIDs);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> transferAll() {
        List<Course> courses = findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course:courses) {
            CourseDTO courseDTO = transfer(course);
            courseDTOs.add(courseDTO);
        }

        return courseDTOs;
    }
}
