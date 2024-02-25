package com.iiitb.academia.bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;

    @Column(unique = true,nullable = false)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column
    private String photograph_path;

    @Column(nullable = false)
    private float cgpa;

    @Column(nullable = false)
    private Integer total_credits;

    @Column
    private String graduation_year;

    @Column
    private Integer specialization;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Course> coursesTaken = new HashSet<>();

}
