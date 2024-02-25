package com.iiitb.academia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.academia.bean.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int courseId;
    private String courseCode;
    private String name;
    private String year;
    private List<CourseScheduleDTO> courseScheduleList = new ArrayList<>();
    private String specialization;

    public CourseDTO(Course course){
        this.courseId = course.getCourseId();
        this.courseCode = course.getCourseCode();
        this.name = course.getName();
        this.year = course.getYear();
        this.courseScheduleList = course.getCourseScheduleList().stream().map(CourseScheduleDTO::new).toList();
    }
}
