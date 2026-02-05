import styles from "./DataCard.module.css";

const labelMap = {
    charityName: "Charity Name",
    shelterName: "Shelter Name",
    city: "City",
    state: "State",
    zip: "Zip Code"
};

export default function DataCard({ data }) {
    if (!data) return null;

    const excludedFields = ["shelterID", "charityId"];

    return (
        <div className={styles.card}>
            {Object.entries(data)
                .filter(([key]) => !excludedFields.includes(key))
                .map(([key, value]) => (
                    <span key={key} className={styles.pill}>
                         <strong className={styles.label}>
                              {labelMap[key] || key}:&nbsp;
                         </strong>
                         {value}
                    </span>
                ))}
        </div>
    );
}