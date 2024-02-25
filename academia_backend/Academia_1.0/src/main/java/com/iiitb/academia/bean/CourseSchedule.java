package com.iiitb.academia.bean;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "CourseSchedule")
public class CourseSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer schedule_id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @Column
    private String building;
}
