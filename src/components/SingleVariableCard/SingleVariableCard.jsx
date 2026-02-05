import styles from "./SingleVariableCard.module.css"; 

const displayNames = {
    stateCode: "State Code",
    stateName: "State Name",
    lastUpdated: "Last Updated",
    coversSpouses: "Covers Spouses",
    coversCohabitants: "Covers Cohabitants",
    coversDatingPartners: "Covers Dating Partners",
    coversFormerPartners: "Covers Former Partners",
    coversFamilyMembers: "Covers Family Members",
    coversRoommates: "Covers Roommates",
    relationshipDefinition: "Relationship Definition",
    firstOffense: "First Offense",
    repeatOffense: "Repeat Offense",
    hasMandatoryMinimum: "Has Mandatory Minimum",
    minimumSentenceDays: "Minimum Sentence (Days)",
    maximumSentenceYears: "Maximum Sentence (Years)",
    mandatoryArrestPolicy: "Mandatory Arrest Policy",
    dominantAggressorRule: "Dominant Aggressor Rule",
    arrestPolicyNotes: "Arrest Policy Notes",
    protectiveOrderAvailable: "Protective Order Available",
    emergencyOrderAvailable: "Emergency Order Available",
    standardOrderDurationDays: "Standard Order Duration (Days)",
    maxOrderDurationDays: "Max Order Duration (Days)",
    exParteOrdersAllowed: "Ex Parte Orders Allowed",
    firearmProhibition: "Firearm Prohibition",
    firearmProhibitionDuration: "Firearm Prohibition Duration",
    firearmSurrenderRequired: "Firearm Surrender Required",
    mandatoryReportingHealthcare: "Mandatory Reporting (Healthcare)",
    mandatoryCounselors: "Mandatory Counselors",
    mandatoryReporterCategories: "Mandatory Reporter Categories",
    victimNotificationRequired: "Victim Notification Required",
    victimImpactStatementAllowed: "Victim Impact Statement Allowed",
    addressConfidentialityProgram: "Address Confidentiality Program",
    primaryStatuteCitation: "Primary Statute Citation",
    statuteUrl: "Statute URL",
    notableProvisions: "Notable Provisions",
    recentChanges: "Recent Changes"
  };

const stateTest = 
    {
      // State Info
      stateCode: "NC",
      stateName: "North Carolina",
      lastUpdated: "2024-05-15",
  
      // Relationship Definitions
      coversSpouses: true,
      coversCohabitants: true,
      coversDatingPartners: true,
      coversFormerPartners: true,
      coversFamilyMembers: true,
      coversRoommates: false,
      relationshipDefinition: "Covers current or former spouses, cohabitants, and persons in a dating relationship.",
  
      // Criminal Classifications
      firstOffense: "Misdemeanor",
      repeatOffense: "Felony",
      hasMandatoryMinimum: true,
      minimumSentenceDays: 48,
      maximumSentenceYears: 4.0,
  
      // Arrest Policies
      mandatoryArrestPolicy: true,
      dominantAggressorRule: true,
      arrestPolicyNotes: "Officers must determine the dominant aggressor rather than arresting both parties.",
  
      // Protective Orders
      protectiveOrderAvailable: true,
      emergencyOrderAvailable: true,
      standardOrderDurationDays: 365,
      maxOrderDurationDays: 1825,
      exParteOrdersAllowed: true,
  
      // Weapons Restriction
      firearmProhibition: true,
      firearmProhibitionDuration: "Duration of protective order",
      firearmSurrenderRequired: true,
  
      // Reporting Requirements
      mandatoryReportingHealthcare: true,
      mandatoryCounselors: false,
      mandatoryReporterCategories: "Medical professionals and law enforcement.",
  
      // Victim Protections
      victimNotificationRequired: true,
      victimImpactStatementAllowed: true,
      addressConfidentialityProgram: true,
  
      // Legal References
      primaryStatuteCitation: "Cal. Penal Code § 273.5",
      statuteUrl: "https://leginfo.legislature.ca.gov/",
  
      // Additional Context
      notableProvisions: "Includes strong digital privacy protections for victims.",
      recentChanges: "Expanded definition of 'cohabitant' in 2023."
    }; 



  export default function SingleVariableCard({ data = stateTest }) {
    if (!data || Array.isArray(data)) {
      console.error("SingleVariableCard expects a single object, not an array");
      return null;
    }
  
    const formatValue = (val) => {
      if (typeof val === "boolean") return val ? "Yes" : "No";
      if (val === null || val === undefined || val === "") return "N/A";
      return String(val);
    };
  
    return (
      <div className={styles.purpleVariableCard}>
        <div className={styles.pillContainer}>
          {Object.entries(data).map(([key, value]) => (
            <div key={key} className={styles.pill}>
              <span className={styles.label}>
                {displayNames[key] || key}:
              </span>
              <span className={styles.value}>
                {formatValue(value)}
              </span>
            </div>
          ))}
        </div>
      </div>
    );
  }