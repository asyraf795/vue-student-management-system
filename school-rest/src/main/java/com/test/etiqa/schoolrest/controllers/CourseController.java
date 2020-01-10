package com.test.etiqa.schoolrest.controllers;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.CourseDTO;
import com.test.etiqa.schoolrest.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(CourseController.BASE_URL)
public class CourseController {

    public static final String BASE_URL = "/api/v1/courses";

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok(courseService.transferAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable int id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        CourseDTO courseDTO = courseService.transfer(course);
        return ResponseEntity.ok(courseDTO);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> addCourse(@RequestBody Course course) {
        if (course.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        courseService.save(course);
        return ResponseEntity.ok(courseService.transfer(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody Course course, @PathVariable int id) {
        if (course.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        Course existingCourse = courseService.findById(id);
        if (existingCourse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseService.transfer(courseService.update(course)));
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

}
