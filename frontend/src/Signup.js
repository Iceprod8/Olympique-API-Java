import React, { useState } from 'react';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [passwordConfirm, setPasswordConfirm] = useState('')

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/users/signup', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    email,
                    password,
                    passwordConfirm
                })
            });
            console.log(response);
        } catch (error) {
            console.error('Login failed:', error);
        }
    };

    return (
        <div className="w-80 h-100 bg-gray-800 p-12 text-white rounded-lg font-semibold font-sans text-lg mx-auto my-20 animate-bounce">
            <h1 className="relative top-[-2rem] mb-0 text-lg">Signup</h1>
            <form className="flex flex-col">
                <input 
                    pattern="^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$" 
                    placeholder="Email" 
                    type="text"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    className="mt-5 py-3 px-4 rounded-full bg-gray-700 focus:outline-none animate-bounce"
                />
                <input 
                    placeholder="Password" 
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    className="mt-5 py-3 px-4 rounded-full bg-gray-700 focus:outline-none animate-bounce1"
                />
                <input 
                    placeholder="Confirm Password" 
                    type="password"
                    value={passwordConfirm}
                    onChange={(e) => setPasswordConfirm(e.target.value)}
                    className="mt-5 py-3 px-4 rounded-full bg-gray-700 focus:outline-none animate-bounce1"
                />
                <button 
                    onClick={handleSubmit}
                    type="submit" 
                    className="mt-10 py-4 bg-gradient-to-r from-purple-500 to-blue-500 hover:bg-gray-900 rounded-full transition duration-300 ease-in-out"
                >
                    Signup
                </button>
            </form>
        </div>
    );
}

export default Login;
