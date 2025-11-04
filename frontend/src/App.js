import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Manager from './pages/Manager';
import Coach from './pages/Coach';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/manager">Manager</Link>
            </li>
            <li>
              <Link to="/coach">Coach</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/manager" element={<Manager />} />
          <Route path="/coach" element={<Coach />} />
          <Route path="/" element={<h1>Welcome to Brazukas Project!</h1>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
