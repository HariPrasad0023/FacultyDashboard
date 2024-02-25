package com.iiitb.academia.dto;

import com.iiitb.academia.bean.CourseSchedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseScheduleDTO {
    private String building;
    private String time;
    private String day;
    private String room;

    public CourseScheduleDTO(CourseSchedule courseSchedule){
        this.building = courseSchedule.getBuilding();
        this.day = courseSchedule.getDay();
        this.room = courseSchedule.getRoom();
        this.time = courseSchedule.getTime();
    }
}
