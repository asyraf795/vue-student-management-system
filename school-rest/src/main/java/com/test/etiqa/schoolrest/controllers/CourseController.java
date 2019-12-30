package com.test.etiqa.schoolrest.controllers;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(CourseController.BASE_URL)
public class CourseController {

    public static final String BASE_URL = "/api/v1/courses";

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        if (course.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        courseService.save(course);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id) {
        if (course.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseService.update(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable int id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<Map<Integer, String>> getStudentsByCourse(@PathVariable int id) {
        return ResponseEntity.ok(courseService.findStudentsById(id));
    }

}