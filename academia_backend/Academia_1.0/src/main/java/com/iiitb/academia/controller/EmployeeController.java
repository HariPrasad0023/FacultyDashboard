package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Employee;
import com.iiitb.academia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:9191")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee employee) {
        Employee loggedInEmployee = employeeService.login(employee);

        if (loggedInEmployee == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        else
            return ResponseEntity.ok().body(loggedInEmployee);
    }

}
