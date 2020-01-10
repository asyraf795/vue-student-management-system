package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Course;
import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.domains.StudentDTO;
import com.test.etiqa.schoolrest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        return result.orElse(null);

    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByIc(String ic) {
        return studentRepository.findByIc(ic);
    }

    @Override
    public StudentDTO transfer(Student student) {
        Course course = student.getCourse();
        return new StudentDTO(student.getId(),
                student.getIc(),
                student.getFirstName(),
                student.getLastName(),
                student.getGender(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getAddress(),
                student.getPostcode(),
                student.getState(),
                student.getCountry(),
                student.getDateOfBirth(),
                course.getId());
    }

    @Override
    public List<StudentDTO> transferAll() {
        List<Student> students = findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student:students) {
            StudentDTO studentDTO = transfer(student);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }
}
