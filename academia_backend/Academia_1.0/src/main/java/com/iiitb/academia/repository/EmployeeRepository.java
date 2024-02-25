package com.iiitb.academia.repository;

import com.iiitb.academia.bean.Course;
import com.iiitb.academia.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmailAndPassword(String email, String password);

    Employee findByEmployeeID(Integer employeeId);

    @Query("SELECT e.courses FROM Employee e WHERE e.employeeID = :facultyId")
    List<Course> findCoursesByFaculty(Integer facultyId);
}