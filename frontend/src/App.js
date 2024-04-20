import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
import './App.css';

function App() {
  return (
    <div className="App bg-gray-900 h-full w-full">
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/" element={<h1>Welcome to the Olympic Games Ticketing System</h1>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;