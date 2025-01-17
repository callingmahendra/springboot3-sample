package me.mahendra.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.mahendra.spring_demo.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
