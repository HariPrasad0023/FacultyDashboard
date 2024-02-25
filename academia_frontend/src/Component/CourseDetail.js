import React from 'react';
import { Button } from 'antd';

const CourseDetail = ({ course }) => {
    if (!course || course.length === 0)
        return null;

    const getStudent = (courseID) => {
        window.location.replace(`/courses/student/${courseID}`);
    };

    return (
        <div className='m-5 p-2 rounded regular-shadow'>
            <h2 className='ml-2'>Your Schedule</h2>
            <table className='table table-bordered table-striped mt-3'>
                <thead className='bg-primary text-light'>
                    <tr>
                        <th>Course Name</th>
                        <th>Course Year</th>
                        <th>Course Code</th>
                        <th>Building</th>
                        <th>Time</th>
                        <th>Day</th>
                        <th>Room</th>
                        <th>Specialization Name</th>
                    </tr>
                </thead>
                <tbody>
                    {course.map((cs) => (
                        cs.courseScheduleList.map((schedule, index) => (
                            <tr key={`${cs.courseId}-${index}`}>
                                <td>
                                    <Button className='btn btn-primary' onClick={() => getStudent(cs.courseId)}>
                                        {cs.name}
                                    </Button>
                                </td>
                                <td>{cs.year}</td>
                                <td>{cs.courseCode}</td>
                                <td>{schedule.building}</td>
                                <td>{schedule.time}</td>
                                <td>{schedule.day}</td>
                                <td>{schedule.room}</td>
                                <td>{cs.specialization}</td>
                            </tr>
                        ))
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default CourseDetail;


