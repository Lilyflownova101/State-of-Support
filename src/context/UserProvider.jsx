import { useState } from 'react';
import { UserContext } from './UserContext';
import axios from 'axios';

export default function UserProvider({ children }) {
  const [user, setUser] = useState(() => getUserAndTokenFromStorage());

 
  function getUserAndTokenFromStorage() {

    
    const user = JSON.parse(localStorage.getItem('user')); 
    const token = localStorage.getItem('token');

    
    if (user && token) {
      
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;

      
      return user;
    }

   
    return null;
  }

  return (
    <UserContext.Provider value={{ user, setUser }}>
      {children}
    </UserContext.Provider>
  );
}
