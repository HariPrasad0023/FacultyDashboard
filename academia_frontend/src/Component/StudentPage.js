import React from 'react'
import studentService from '../services/studentlist'
import { useParams } from "react-router-dom";
import Student from "./Student"
import { useState, useEffect } from 'react'

import {
    Button,
} from "antd";
import Nav from '../Util/Nav';

function StudentPage() {
    const { uid } = useParams();
    console.log(uid)
    const [student, setStudent] = useState([])

    const goBack = () => {
        window.location.replace(`/login`)
    }

    useEffect(() => {
        async function fetchData() {
            const studentData = await studentService.getStudentByCourseId(uid)
            setStudent(studentData)
        }
        fetchData()
    }, [uid])
    return (
        <>
            <Nav />
            <Student students={student} />
            <div className='inline my-2 my-lg-3'><Button className='btn-btn-primary' onClick={goBack}>Back</Button></div>
        </>

    );
}

export default StudentPage