import React, { useState } from 'react';
import '../App.css';

const LoginForm = ({ showLogin }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = (event) => {
        event.preventDefault();
        const loginCredentials = { email, password };
        showLogin(loginCredentials);
        setEmail('');
        setPassword('');
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <form onSubmit={handleLogin} className="card p-4">
                        <h3 className="text-center">Faculty Sign In</h3>
                        <div className="form-group">
                            <label htmlFor="email">Login Id</label>
                            <input
                                type="email"
                                className="form-control"
                                placeholder="Email"
                                value={email}
                                onChange={(event) => setEmail(event.target.value)}
                                id="email"
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input
                                type="password"
                                className="form-control"
                                placeholder="Password"
                                value={password}
                                onChange={(event) => setPassword(event.target.value)}
                                id="password"
                                required
                            />
                        </div>
                        <div className="text-center">
                            <button className="btn btn-primary" type="submit" id="login-submit" style={{ marginTop: '10px' }}>
                                LOGIN
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default LoginForm;
