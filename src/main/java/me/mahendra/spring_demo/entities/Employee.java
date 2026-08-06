package me.mahendra.spring_demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPNO")
    private String empNo;

    @Column(name = "FIRSTNME")
    private String firstName;

    @Column(name = "MIDINIT")
    private String midInit;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "WORKDEPT")
    private String workDept;

    @Column(name = "PHONENO")
    private String phoneNo;

    @Column(name = "HIREDATE")
    private LocalDate hireDate;

    @Column(name = "JOB")
    private String job;

    @Column(name = "EDLEVEL")
    private int edLevel;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BIRTHDATE")
    private LocalDate birthDate;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "BONUS")
    private BigDecimal bonus;

    @Column(name = "COMM")
    private BigDecimal comm;

    // Getters and Setters

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidInit() {
        return midInit;
    }

    public void setMidInit(String midInit) {
        this.midInit = midInit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkDept() {
        return workDept;
    }

    public void setWorkDept(String workDept) {
        this.workDept = workDept;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getEdLevel() {
        return edLevel;
    }

    public void setEdLevel(int edLevel) {
        this.edLevel = edLevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }
}
