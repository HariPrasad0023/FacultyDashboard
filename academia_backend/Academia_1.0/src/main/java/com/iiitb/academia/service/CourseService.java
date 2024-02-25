package com.iiitb.academia.service;


import com.iiitb.academia.bean.Course;
import com.iiitb.academia.bean.CourseSchedule;
import com.iiitb.academia.bean.Employee;
import com.iiitb.academia.dto.CourseDTO;
import com.iiitb.academia.repository.CourseRepository;
import com.iiitb.academia.repository.EmployeeRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByFaculty(Integer facultyId) {
        Employee faculty = employeeRepository.findById(facultyId).orElse(null);
        if (faculty != null) {
            return faculty.getCourses();
        }
        return null;
    }

    public List<CourseDTO> getCourseWithSchedule(Integer empId) {
        List<Course> courses = employeeRepository.findCoursesByFaculty(empId);
        List<CourseDTO> courseDTOS = courses.stream().map(CourseDTO::new).toList();
        courseDTOS.forEach(co -> {
            co.setSpecialization(courseRepository.getSpecializationByCourseId(co.getCourseId()).get());
        });
        return courseDTOS;
    }

}
