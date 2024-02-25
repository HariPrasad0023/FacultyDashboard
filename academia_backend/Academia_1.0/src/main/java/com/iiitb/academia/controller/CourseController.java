package com.iiitb.academia.controller;

import com.iiitb.academia.bean.Course;
import com.iiitb.academia.dto.CourseDTO;
import com.iiitb.academia.service.CourseService;
import org.json.JSONObject;
import com.iiitb.academia.bean.Student;
import com.iiitb.academia.repository.CourseRepository;
import com.iiitb.academia.repository.EmployeeRepository;
import com.iiitb.academia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin("http://localhost:9191")
public class CourseController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping("/student/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable("courseId") Integer courseId) {
        List<Student> students = courseRepository.findStudentsByCourse(courseId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{facultyId}")
    public List<CourseDTO> getCourseWithSchedule(@PathVariable Integer facultyId) {
        return courseService.getCourseWithSchedule(facultyId);
    }

}

