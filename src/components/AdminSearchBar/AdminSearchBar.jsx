import { useState } from 'react';
import styles from './AdminSearchBar.module.css';

export default function AdminSearchBar({ searchType = "shelter", onResultFound }) {
  const [searchId, setSearchId] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const config = {
    shelter: {
      endpoint: '/shelter',
      placeholder: 'Search by Shelter ID...',
      label: 'Shelter'
    },
    charity: {
      endpoint: '/charity',
      placeholder: 'Search by Charity ID...',
      label: 'Charity'
    }
  };

  const currentConfig = config[searchType];

  const handleSearch = async (e) => {
    e.preventDefault();
    
    if (!searchId.trim()) {
      setError('Please enter an ID');
      return;
    }

    setLoading(true);
    setError(null);

    try {
      const response = await fetch(
        `${import.meta.env.VITE_REMOTE_API}${currentConfig.endpoint}/${searchId}`
      );

      if (!response.ok) {
        if (response.status === 404) {
          throw new Error(`${currentConfig.label} not found`);
        }
        throw new Error('Search failed');
      }

      const data = await response.json();
      
      if (onResultFound) {
        onResultFound(data);
      }
      
      setSearchId('');
    } catch (err) {
      setError(err.message);
      console.error('Search error:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleClear = () => {
    setSearchId('');
    setError(null);
  };

  return (
    <div className={styles.searchContainer}>
      <form onSubmit={handleSearch} className={styles.searchForm}>
        <input
          type="number"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
          placeholder={currentConfig.placeholder}
          className={styles.searchInput}
          min="1"
        />
        <button type="submit" className={styles.searchButton} disabled={loading}>
          {loading ? 'Searching...' : 'Search'}
        </button>
        {searchId && (
          <button type="button" onClick={handleClear} className={styles.clearButton}>
            Clear
          </button>
        )}
      </form>
      {error && <p className={styles.error}>{error}</p>}
    </div>
  );
}