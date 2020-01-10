package com.test.etiqa.schoolrest.controllers;

import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.domains.StudentDTO;
import com.test.etiqa.schoolrest.services.CourseService;
import com.test.etiqa.schoolrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(StudentController.BASE_URL)
public class StudentController {

    public static final String BASE_URL = "/api/v1/students";

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.transferAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<StudentDTO> getStudent(@PathVariable int id) {

        Student student = studentService.findById(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        StudentDTO studentDTO = studentService.transfer(student);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        try {
            Student student = studentService.findByIc(studentDTO.getIc()).get(0);
            return ResponseEntity.badRequest().build();
        }
        catch(IndexOutOfBoundsException ex) {
            courseService.assign(studentDTO);
            Student student = studentService.findByIc(studentDTO.getIc()).get(0);
            return ResponseEntity.ok(studentService.transfer(student));
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable int id) {
        if (studentDTO.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        Student existingStudent = studentService.findById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        courseService.assign(studentDTO);
        return ResponseEntity.ok(studentService.transfer(studentService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

