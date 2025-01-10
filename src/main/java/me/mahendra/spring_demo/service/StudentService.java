package me.mahendra.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import me.mahendra.spring_demo.entities.Student;
import me.mahendra.spring_demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        validateStudentData(student);
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        validateStudentData(student);
        return studentRepository.findById(id)
                   .map(existingStudent -> {
                       existingStudent.setName(student.getName());
                       existingStudent.setEmail(student.getEmail());
                       existingStudent.setPhone(student.getPhone());
                       return studentRepository.save(existingStudent);
                   })
                   .orElse(null); // Or throw an exception here.
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String name, String email, String phone, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sort.split(",")[0])));
        Page<Student> studentPage = studentRepository.findByNameContainingOrEmailContainingOrPhoneContaining(name, email, phone, pageable);
        return studentPage.getContent();
    }

    private void validateStudentData(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (student.getEmail() == null || !student.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (student.getPhone() == null || !student.getPhone().matches("^\\+?[0-9. ()-]{7,25}$")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
