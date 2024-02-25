import axios from 'axios'

const courseUrl = `http://localhost:9191/courses`

const getCourseByFaculty = async (faculty) => {

    const response = await axios.get(`${courseUrl}/${faculty.employeeID}`)
    console.log(response.data)
    // The .data field would now contain the course details taken up by the faculty
    return response.data
}
const exportObject = { getCourseByFaculty }
export default exportObject