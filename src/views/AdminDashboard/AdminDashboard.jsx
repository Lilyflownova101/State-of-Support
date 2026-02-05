import { useContext } from 'react';
import { Link } from 'react-router-dom';
import { UserContext } from '../../context/UserContext';
import styles from './AdminDashboard.module.css';

export default function AdminDashboard() {
  const { user } = useContext(UserContext);

  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <h1 className={styles.title}>Admin Dashboard</h1>
        <p className={styles.welcome}>Welcome back, {user?.username}!</p>
      </div>

      <div className={styles.cardGrid}>
        <Link to="/admin/states" className={styles.card}>
          <div className={styles.cardIcon}>📜</div>
          <h2 className={styles.cardTitle}>State Laws</h2>
          <p className={styles.cardDescription}>Create, update, or delete state law entries</p>
        </Link>

        <Link to="/admin/shelters" className={styles.card}>
          <div className={styles.cardIcon}>🏠</div>
          <h2 className={styles.cardTitle}>Shelters</h2>
          <p className={styles.cardDescription}>Manage shelter listings</p>
        </Link>

        <Link to="/admin/charities" className={styles.card}>
          <div className={styles.cardIcon}>💜</div>
          <h2 className={styles.cardTitle}>Charities</h2>
          <p className={styles.cardDescription}>Manage charity organizations</p>
        </Link>
      </div>
    </div>
  );
}