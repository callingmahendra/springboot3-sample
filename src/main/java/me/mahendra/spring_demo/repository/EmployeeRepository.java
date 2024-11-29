package me.mahendra.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.mahendra.spring_demo.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
