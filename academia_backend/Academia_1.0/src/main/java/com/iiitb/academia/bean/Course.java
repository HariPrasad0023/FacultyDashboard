package com.iiitb.academia.bean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_code",nullable = false,unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private float credits;

    @Column(nullable = false)
    private Integer capacity;

    @Column()
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<CourseSchedule> courseScheduleList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "specialization", referencedColumnName = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private Set<Student> students = new HashSet<>();
}
