import React from 'react'

const Students = ({ students }) => {
    if (students.length === 0)
        return null;
    return (
        <div className='m-5 p-2 rounded regular-shadow'>
            <h2 className='ml-2'>Students Enrolled</h2>
            <table className='table' cellPadding={10}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Roll Number</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        students.map((s) => (
                            <tr>
                                <td>{s.first_name}</td>
                                <td>{s.roll_number}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}


export default Students