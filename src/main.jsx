import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';

import axios from 'axios';

import App from './App.jsx';
import { UserProvider } from './context/UserContext';

import { library } from '@fortawesome/fontawesome-svg-core';
import { faCartPlus, faGrip, faMagnifyingGlass, faRotate, faTable, faTrashCan, faXmark } from '@fortawesome/free-solid-svg-icons';

library.add(faCartPlus);
library.add(faGrip);
library.add(faMagnifyingGlass);
library.add(faRotate);
library.add(faTable);
library.add(faTrashCan);
library.add(faXmark);

axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <UserProvider>
      <App />
    </UserProvider>
  </StrictMode>,
);