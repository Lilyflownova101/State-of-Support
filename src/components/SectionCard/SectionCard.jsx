import { useState } from "react";
import styles from "./SectionCard.module.css"; 
import SingleVariableCard from "../SingleVariableCard/SingleVariableCard";



const Sections = [
    {name: "Relationship Definitions", definition: "Explains how state law defines domestic relationships, to determine if a case qualifies for domestic violence protections."}, 
    {name: "Criminal Classifications", definition: "Outlines the specific charges and degrees of domestic violence crimes."}, 
    {name: "Arrest Policies", definition: "Details the state's rules for law enforcement when responding to a call."}, 
    {name: "Protective Orders", definition: "Information on how to obtain legal restraining orders (temporary or permanent) that prohibit an abuser from contacting or approaching the victim."}, 
    {name: "Weapons Restrictions", definition: "Summarizes laws regarding the seizure or surrender of firearms and ammunition from individuals subject to domestic violence protective orders or convictions."}, 
    {name: "Victim protections", definition: "Covers essential rights such as workplace leave for legal/medical needs, address confidentiality programs."},
    {name: "Reporting Requirements", definition: "Specifies the duties of medical professionals, teachers, and law enforcement to report suspected domestic abuse to state authorities."}, 
    {name: "Legal References", definition: "Provides the specific state statute numbers and direct links to the official legislative code for further legal research."}, 
    {name: "Additional Context", definition: "Offers supplemental information on local court procedures, unique state programs, or recent changes in safety legislation."}
]; 

const sectionKeyMap = {
  "Relationship Definitions": [
    "coversSpouses", "coversCohabitants", "coversDatingPartners", 
    "coversFormerPartners", "coversFamilyMembers", "coversRoommates", 
    "relationshipDefinition"
  ],
  "Criminal Classifications": [
    "firstOffense", "repeatOffense", "hasMandatoryMinimum", 
    "minimumSentenceDays", "maximumSentenceYears"
  ],
  "Arrest Policies": [
    "mandatoryArrestPolicy", "dominantAggressorRule", "arrestPolicyNotes"
  ],
  "Protective Orders": [
    "protectiveOrderAvailable", "emergencyOrderAvailable", 
    "standardOrderDurationDays", "maxOrderDurationDays", "exParteOrdersAllowed"
  ],
  "Weapons Restrictions": [
    "firearmProhibition", "firearmProhibitionDuration", "firearmSurrenderRequired"
  ],
  "Victim protections": [
    "victimNotificationRequired", "victimImpactStatementAllowed", 
    "addressConfidentialityProgram"
  ],
  "Reporting Requirements": [
    "mandatoryReportingHealthcare", "mandatoryCounselors", 
    "mandatoryReporterCategories"
  ],
  "Legal References": [
    "primaryStatuteCitation", "statuteUrl"
  ],
  "Additional Context": [
    "notableProvisions", "recentChanges"
  ]
};



const stateTest = 
    {
      
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




const getDataForSection = (sectionName, stateData = stateTest) => {
  const keys = sectionKeyMap[sectionName] || [];
  const filteredData = {};
  
  keys.forEach(key => {
    if (stateData && stateData[key] !== undefined) {
      filteredData[key] = stateData[key];
    }
  });
  
  return filteredData;
};

export default function SectionCard({ stateData }) {
  const [expandedIndex, setExpandedIndex] = useState(null);

  const handleToggle = (index) => {
    setExpandedIndex(expandedIndex === index ? null : index);
  };

  return (
    <div className={styles.columnContainer}>
      {Sections.map((section, index) => {
        const sectionData = getDataForSection(section.name, stateData);
        
        return (
          <div key={index} className={styles.card}>
            <div 
              className={styles.cardHeader} 
              onClick={() => handleToggle(index)}
            >
              <h3 className={styles.cardTitle}>{section.name}</h3>
              <span className={styles.arrow}>
                {expandedIndex === index ? "▲" : "▼"}
              </span>
            </div>

            {expandedIndex === index && (
              <div className={styles.cardContent}>
                <p className={styles.cardDefinition}>{section.definition}</p>
                <SingleVariableCard data={sectionData} />
              </div>
            )}
          </div>
        );
      })}
    </div>
  );
}