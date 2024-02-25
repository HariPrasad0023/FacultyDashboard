package com.iiitb.academia.bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeID;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column
    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "photograph_path")
    private String photographPath;

    @Column(name = "department_id")
    private int departmentId;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Course> courses = new ArrayList<>();

}
