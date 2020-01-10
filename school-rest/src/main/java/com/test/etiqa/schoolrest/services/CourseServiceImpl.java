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
    private final StudentService studentService;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
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
        removeReference(findById(id), new ArrayList<>());
        courseRepository.deleteById(id);
    }

    @Override
    public void assign(StudentDTO studentDTO) {
        Course course = findById(studentDTO.getCourseId());
        List<Student> students = new ArrayList<>();
        Student student = new Student(studentDTO.getId(), studentDTO.getIc(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getGender(), studentDTO.getPhoneNumber(), studentDTO.getEmail(), studentDTO.getDateOfBirth(), studentDTO.getAddress(), studentDTO.getPostcode(), studentDTO.getState(), studentDTO.getCountry(), course);
        students.add(student);
        course.setStudents(students);
        save(course);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public void setCourseAll(List<Student> students, Course course) {
        for (Student student:students) {
            student.setCourse(course);
        }
    }

    @Override
    public void removeReference(Course course, List<Integer> exceptionStudentIds) {
        List<Student> existingStudents = course.getStudents();
        List<Integer> existingStudentIds = new ArrayList<>();
        for(Student student:existingStudents) {
            existingStudentIds.add(student.getId());
        }
        existingStudentIds.removeAll(exceptionStudentIds);
        List<Student> students = studentService.findAllByIds(existingStudentIds);
        setCourseAll(students, null);

        studentService.saveAll(students);
    }

    @Override
    public void assign(CourseDTO courseDTO) {
        Course course;
        if(courseDTO.getId() != 0) {
            course = findById(courseDTO.getId());
            removeReference(course, courseDTO.getStudentIds());
        } else {
            course = new Course(courseDTO.getTitle(), courseDTO.getAbbreviation());
        }

        List<Student> students = studentService.findAllByIds(courseDTO.getStudentIds());
        setCourseAll(students, course);
        course.setStudents(students);
        save(course);
    }

    @Override
    public CourseDTO transfer(Course course) {
        List<Student> students = course.getStudents();
        List<Integer> studentIds = new ArrayList<>();
        for(Student student:students) {
            studentIds.add(student.getId());
        }
        CourseDTO courseDTO = new CourseDTO(course.getId(), course.getTitle(), course.getAbbreviation());
        courseDTO.setStudentIds(studentIds);
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
