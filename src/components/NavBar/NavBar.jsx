import { useState } from 'react';
import { NavLink } from 'react-router-dom';
import styles from './NavBar.module.css'; 
import QuickExitButton from '../QuickExit/QuickExitButton';

export default function NavBar() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => setIsOpen(!isOpen);
  const closeMenu = () => setIsOpen(false);

  return (
    <nav className={styles.navbar}>
      <button 
        className={styles.hamburger} 
        onClick={toggleMenu}
        aria-label="Toggle menu"
      >
        <span className={`${styles.bar} ${isOpen ? styles.open : ''}`}></span>
        <span className={`${styles.bar} ${isOpen ? styles.open : ''}`}></span>
        <span className={`${styles.bar} ${isOpen ? styles.open : ''}`}></span>
      </button>

      <div className={`${styles.navbarLinks} ${isOpen ? styles.showMenu : ''}`}>
        <NavLink to="/" onClick={closeMenu}>Home</NavLink>
        <NavLink to="/state" onClick={closeMenu}>State Laws</NavLink>
        <NavLink to="/shelter" onClick={closeMenu}>Find Resources</NavLink>
        <NavLink to="/charity" onClick={closeMenu}>Donate</NavLink>
        <NavLink to="/login" onClick={closeMenu}>Admin Login</NavLink>
        <NavLink to="/logout" onClick={closeMenu}>Logout</NavLink>
      </div>

      <div className={styles.quickExit}>
        <QuickExitButton />
      </div>
    </nav>
  );
}