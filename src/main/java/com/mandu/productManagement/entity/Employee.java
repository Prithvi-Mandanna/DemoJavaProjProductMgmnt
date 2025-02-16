package com.mandu.productManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String name;
    private String email;
    private String department;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Employee(Integer id, String name, String email, String department,  LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.employee_id = id;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.department = department;
        this.email = email;
        this.name = name;
    }

    public Employee() {
    }

    public Integer getId() {
        return employee_id;
    }

    public void setId(Integer id) {
        this.employee_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employee_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
