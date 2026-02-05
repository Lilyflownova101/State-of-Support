import { useState, useEffect } from "react";
import styles from "./FilterPanel.module.css";

export default function FilterPanel({ onSelectionChange, className }) {
  const [selectedValue, setSelectedValue] = useState("");
  const [states, setStates] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchStates = async () => {
      try {
        setLoading(true);
        const response = await fetch(`${import.meta.env.VITE_REMOTE_API}/state`);
        
        if (!response.ok) {
          throw new Error("Failed to fetch states");
        }
        
        const data = await response.json();
        
        const uniqueStates = data
          .map((item) => ({
            key: item.stateCode,
            value: item.stateName,
          }))
          .sort((a, b) => a.value.localeCompare(b.value));
        
        setStates(uniqueStates);
      } catch (err) {
        setError(err.message);
        console.error("Error fetching states:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchStates();
  }, []);

  const handleChange = (event) => {
    const newValue = event.target.value;
    setSelectedValue(newValue);

    if (onSelectionChange) {
      onSelectionChange(newValue);
    }
  };

  if (error) {
    return <div className={`${styles.filterContainer} ${className || ""}`}>Error loading states</div>;
  }

  return (
    <div className={`${styles.filterContainer} ${className || ""}`}>
      <select
        value={selectedValue}
        onChange={handleChange}
        className={styles.filterSelect}
        disabled={loading}
      >
        <option value="">{loading ? "Loading..." : "Select a State"}</option>
        {states.map((state) => (
          <option key={state.key} value={state.key}>
            {state.value}
          </option>
        ))}
      </select>
    </div>
  );
}