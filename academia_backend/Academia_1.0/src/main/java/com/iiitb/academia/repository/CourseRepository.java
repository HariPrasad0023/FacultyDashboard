package com.iiitb.academia.repository;

import com.iiitb.academia.bean.Course;
import com.iiitb.academia.bean.Employee;
import com.iiitb.academia.bean.Specialization;
import com.iiitb.academia.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Method in your CourseRepository interface
    @Query("SELECT c, cs FROM Course c " +
            "LEFT JOIN c.courseScheduleList cs " +
            "WHERE c.courseId = :courseId")
    List<Object[]> findCourseWithScheduleById(@Param("courseId") int courseId);

    @Query("SELECT c.students FROM Course c WHERE c.courseId = :courseId")
    List<Student> findStudentsByCourse(Integer courseId);

    @Query("SELECT c.specialization.name FROM Course c WHERE c.courseId = :courseId")
    Optional<String> getSpecializationByCourseId(Integer courseId);

}
