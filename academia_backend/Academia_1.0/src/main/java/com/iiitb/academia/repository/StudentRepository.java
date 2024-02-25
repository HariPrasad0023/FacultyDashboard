package com.iiitb.academia.repository;

import com.iiitb.academia.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student s WHERE s.student_id IN "
            + "(SELECT sc.student_id FROM student_course sc WHERE sc.course_id = :courseId)",
            nativeQuery = true)
    List<Student> getStudentsByCourseId(Integer courseId);
}