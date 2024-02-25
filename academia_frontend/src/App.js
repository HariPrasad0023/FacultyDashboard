import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import StudentPage from './Component/StudentPage';
import LoginPage from './Component/LoginPage';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route exact path="/courses/student/:uid" element={<StudentPage />} />
          <Route exact path="/login" element={<LoginPage />} />
          <Route exact path="/" element={<LoginPage />} />
        </Routes>
      </Router>
    </div>

  );
}

export default App;