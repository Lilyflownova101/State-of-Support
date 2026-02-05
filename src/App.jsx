import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NavBar from './components/NavBar/NavBar';
import HomeView from './views/HomeView/HomeView';
import CharitySearchView from './views/CharitySearchView/CharitySearchView'; 
import ShelterSearchView from './views/ShelterSearchView/ShelterSearch'; 
import StateLawsView from './views/StateLawsView/StateLawsView'; 
import LoginView from './views/LoginView/LoginView';
import LogoutView from './views/LogoutView';
import RegisterView from './views/RegisterView/RegisterView';
import Title from './components/Title/Title';
import ProtectedRoute from './components/ProtectedRoute';
import AdminDashboard from './views/AdminDashboard/AdminDashboard';
import ManageStates from './views/ManageStates/ManageStates'; 
import ManageShelters from './views/ManageShelters/ManageShelters';
import ManageCharities from './views/ManageCharities/ManageCharities';

export default function App() {

  return (
    <div id="cart-app" className="min-h-screen bg-white">
      <BrowserRouter>
        <Title/>
        <NavBar />
        <main>
          <Routes>
            <Route path="/" element={<HomeView />} />
            <Route path="/state" element={<StateLawsView />} />
            <Route path="/charity" element={<CharitySearchView />} /> 
            <Route path="/shelter" element={<ShelterSearchView />} />
            <Route path="/login" element={<LoginView />} />
            <Route path="/logout" element={<LogoutView />} />
            <Route path="/register" element={<RegisterView />} />

            <Route path="/admin" element={
              <ProtectedRoute>
                <AdminDashboard />
              </ProtectedRoute>
            } />
            <Route path="/admin/states" element={
              <ProtectedRoute>
                <ManageStates />
              </ProtectedRoute>
            } />
            <Route path="/admin/shelters" element={
              <ProtectedRoute>
                <ManageShelters />
              </ProtectedRoute>
            } />
            <Route path="/admin/charities" element={
              <ProtectedRoute>
                <ManageCharities />
              </ProtectedRoute>
            } />
          </Routes>
        </main>
      </BrowserRouter>
    </div>
  );
}