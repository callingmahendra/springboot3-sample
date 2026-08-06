package me.mahendra.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.mahendra.spring_demo.entities.Employee;
import me.mahendra.spring_demo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee employee) {
        return employeeRepository.findById(id)
                   .map(existingEmployee -> {
                       existingEmployee.setFirstName(employee.getFirstName());
                       existingEmployee.setMidInit(employee.getMidInit());
                       existingEmployee.setLastName(employee.getLastName());
                       existingEmployee.setWorkDept(employee.getWorkDept());
                       existingEmployee.setPhoneNo(employee.getPhoneNo());
                       existingEmployee.setHireDate(employee.getHireDate());
                       existingEmployee.setJob(employee.getJob());
                       existingEmployee.setEdLevel(employee.getEdLevel());
                       existingEmployee.setSex(employee.getSex());
                       existingEmployee.setBirthDate(employee.getBirthDate());
                       existingEmployee.setSalary(employee.getSalary());
                       existingEmployee.setBonus(employee.getBonus());
                       existingEmployee.setComm(employee.getComm());
                       return employeeRepository.save(existingEmployee);
                   })
                   .orElse(null); // Or throw an exception here.
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
