import axios from 'axios'

const loginBaseUrl = `http://localhost:9191/employee/login`

const login = async (logincredentials) => {
    // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
    // Note the async-await
    const response = await axios.post(loginBaseUrl, logincredentials)

    // Return .data field of the response object which would contain the logged in user object
    // And the user state would now be updated by the handleLogin() method
    return response.data
}

const exportObject = { login }
export default exportObject