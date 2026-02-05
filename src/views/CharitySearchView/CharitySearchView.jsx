import { useState } from "react";
import { getCharityInfo } from "../../services/CharityService";
import Header from "../../components/Header/Header";
import styles from "./CharitySearchView.module.css"; 
import DataCard from "../../components/DataCard/DataCard";
import SearchBar from "../../components/SearchBar/SearchBar";

export default function CharitySearchView() {
    const [charities, setCharities] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const title = "Strengthen Your Community: Donate & Give Back"; 
    const description = "Empowering survivors and advocates through community connection. Locate local charities by state and category to discover available services or learn how you can contribute to domestic violence support networks near you."; 

    const handleStateChange = (stateKey) => {
        if (!stateKey) {
            setCharities(null);
            return;
        }

        setLoading(true);
        setError(null);

        getCharityInfo(stateKey)
            .then((response) => {
                setCharities(response.data);
            })
            .catch((err) => {
                console.error("Error fetching charities:", err);
                setError("Failed to load charities. Please try again.");
                setCharities(null);
            })
            .finally(() => {
                setLoading(false);
            });
    };

    const handleSearchResults = (results) => {
        setCharities(results);
    };

    return (
        <div>
            <Header title={title} description={description}/> 
            <SearchBar 
                searchType="charity" 
                onStateChange={handleStateChange} 
                onSearchResults={handleSearchResults}
            />
            <main className={styles.main}>
                {loading && (
                    <p className={styles.loading}>Loading charities...</p>
                )}

                {error && (
                    <p className={styles.error}>{error}</p>
                )}

                {!loading && !error && charities && (
                    charities.length > 0 ? (
                        <div className={styles.dataList}>
                            {charities.map(({ charityId, ...charityData }) => (
                                <DataCard key={charityId} data={charityData} />
                            ))}
                        </div>
                    ) : (
                        <p>No charities found.</p>
                    )
                )}

                {!loading && !error && !charities && (
                    <p className={styles.placeholder}>
                        Search by city or select a state to find charities.
                    </p>
                )}
            </main>
        </div>
    );
}