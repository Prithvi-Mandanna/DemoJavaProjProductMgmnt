package com.mandu.productManagement.repo;

import com.mandu.productManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDb extends JpaRepository<Employee, Integer> {



}
