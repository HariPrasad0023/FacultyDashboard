import axios from 'axios'

const studentUrl = `http://localhost:9191/courses/student`

const getStudentByCourseId = async (courseID) => {

    const response = await axios.get(`${studentUrl}/${courseID}`)
    console.log(response.data)
    return response.data
}
const exportObject = { getStudentByCourseId }
export default exportObject