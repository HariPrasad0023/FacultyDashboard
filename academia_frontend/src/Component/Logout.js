import React from 'react'
import {
    Button,
} from "antd";
import { ToastContainer, toast } from 'react-toastify';
const Logout = ({ user, setUser }) => {

    const logout = () => {

        window.localStorage.removeItem('loggedInUser')
        setUser(null)
        toast.success(`Logged Out Successfully!`);
    }

    if (!user)
        return null

    return (
        <div>
            <div className='inline my-2 my-lg-3' style={{ marginTop: '15px' }}><Button className='btn-btn-primary' onClick={logout}>Logout</Button></div>
            <ToastContainer />
        </div>
    )
}
export default Logout