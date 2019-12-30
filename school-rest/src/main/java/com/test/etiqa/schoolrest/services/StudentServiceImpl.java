package com.test.etiqa.schoolrest.services;

import com.test.etiqa.schoolrest.domains.Student;
import com.test.etiqa.schoolrest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

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
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        Student updateStudent = findById(student.getId());

        if (student.getFirstName() != null) {
            updateStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            updateStudent.setLastName(student.getLastName());
        }
        if (student.getIc() != null) {
            updateStudent.setIc(student.getIc());
        }
        if (student.getGender() != null) {
            updateStudent.setGender(student.getGender());
        }
        if (student.getEmail() != null) {
            updateStudent.setEmail(student.getEmail());
        }
        if (student.getPhoneNumber() != null) {
            updateStudent.setPhoneNumber(student.getPhoneNumber());
        }
        if (student.getAddress() != null) {
            updateStudent.setAddress(student.getAddress());
        }
        if (student.getPostcode() != null) {
            updateStudent.setPostcode(student.getPostcode());
        }
        if (student.getState() != null) {
            updateStudent.setState(student.getState());
        }
        if (student.getCountry() != null) {
            updateStudent.setCountry(student.getCountry());
        }
        if (student.getDateOfBirth() != null) {
            updateStudent.setDateOfBirth(student.getDateOfBirth());
        }
        if (student.getCourses() != null) {
            updateStudent.setCourses(student.getCourses());
        }

        studentRepository.save(updateStudent);
        return updateStudent;
    }
}
