package me.mahendra.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
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
                       existingStudent.setStandard(student.getStandard());
                       existingStudent.setAge(student.getAge());
                       return studentRepository.save(existingStudent);
                   })
                   .orElse(null); // Or throw an exception here.
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private void validateStudentData(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (student.getEmail() == null || !student.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (student.getStandard() == null || student.getStandard().isEmpty()) {
            throw new IllegalArgumentException("Standard cannot be null or empty");
        }
        if (student.getAge() < 5 || student.getAge() > 100) {
            throw new IllegalArgumentException("Age must be between 5 and 100");
        }
    }
}
