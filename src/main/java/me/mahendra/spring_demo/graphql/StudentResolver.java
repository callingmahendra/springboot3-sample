package me.mahendra.spring_demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.mahendra.spring_demo.entities.Student;
import me.mahendra.spring_demo.service.StudentService;

import java.util.List;

@Component
public class StudentResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private StudentService studentService;

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    public Student createStudent(String name, String email, String phone) {
        Student student = new Student(name, email, phone);
        return studentService.createStudent(student);
    }

    public Student updateStudent(Long id, String name, String email, String phone) {
        Student student = new Student(name, email, phone);
        student.setId(id);
        return studentService.updateStudent(id, student);
    }

    public boolean deleteStudent(Long id) {
        studentService.deleteStudent(id);
        return true;
    }
}
