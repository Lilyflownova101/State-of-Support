import { useState, useEffect } from "react";
import styles from "./SearchBar.module.css";
import FilterPanel from "../FilterPanel/FilterPanel";

export default function SearchBar({ onSearchResults, onStateChange, searchType = "shelter" }) {
  const [query, setQuery] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const config = {
    shelter: {
      endpoint: "/shelter/city",
      placeholder: "Search by city...",
    },
    charity: {
      endpoint: "/charity/city",
      placeholder: "Search by city...",
    },
  };

  const currentConfig = config[searchType];

  useEffect(() => {
    if (query.length < 2) {
      onSearchResults && onSearchResults(null); 
      return;
    }

    const debounceTimer = setTimeout(() => {
      searchItems(query);
    }, 300);

    return () => clearTimeout(debounceTimer);
  }, [query]);

  const searchItems = async (searchTerm) => {
    try {
      setLoading(true);
      setError(null);
      
      const response = await fetch(
        `${import.meta.env.VITE_REMOTE_API}${currentConfig.endpoint}?city=${encodeURIComponent(searchTerm)}`
      );

      if (!response.ok) {
        throw new Error("Search failed");
      }

      const data = await response.json();
      
      if (onSearchResults) {
        onSearchResults(data);
      }
    } catch (err) {
      setError(err.message);
      console.error("Search error:", err);
    } finally {
      setLoading(false);
    }
  };

  const handleInputChange = (e) => {
    setQuery(e.target.value);
  };

  return (
    <div className={styles.wrapper}>
      <div className={styles.searchContainer}>
        <input
          type="text"
          value={query}
          onChange={handleInputChange}
          placeholder={currentConfig.placeholder}
          className={styles.searchInput}
        />
        
        {loading && <span className={styles.loadingIndicator}>Searching...</span>}
        {error && <span className={styles.errorMessage}>{error}</span>}
      </div>

      <div className={styles.filterContainer}>
        <FilterPanel onSelectionChange={onStateChange} />
      </div>
    </div>
  );
}