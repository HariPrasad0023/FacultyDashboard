package com.iiitb.academia.service;

import com.iiitb.academia.bean.Employee;
import com.iiitb.academia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee login(Employee employee) {
        return employeeRepository.findByEmailAndPassword(employee.getEmail(), employee.getPassword());
    }
}
