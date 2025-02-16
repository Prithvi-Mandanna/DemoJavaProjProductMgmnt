package com.mandu.productManagement.service;

import com.mandu.productManagement.entity.Employee;
import com.mandu.productManagement.repo.EmployeeDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDb employeeDb;

    List<Employee> employees = new ArrayList<>();
    public void getAllEmployees(){
        employees = employeeDb.findAll();
        for (Employee employee : employees){
            System.out.println(employee);
        }

    }

}
