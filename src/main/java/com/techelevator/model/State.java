package com.techelevator.model;

import java.time.LocalDate;

public class State {

    // Instance Variables ---------------------------------------------------- 36 Total

    // State Info --- 3 Variables
    private String stateCode;
    private String stateName;
    private LocalDate lastUpdated;

    //Relationship Definitions --- 7 Variables

    private boolean coversSpouses;
    private boolean coversCohabitants;
    private boolean coversDatingPartners;
    private boolean coversFormerPartners;
    private boolean coversFamilyMembers;
    private boolean coversRoommates;
    private String relationshipDefinition;

    // Criminal Classifications --- 5 Variables

    private String firstOffense;
    private String repeatOffense;
    private boolean hasMandatoryMinimum;
    private int minimumSentenceDays;
    private double maximumSentenceYears;

    //Arrest Policies --- 3 Variables

    private boolean mandatoryArrestPolicy;
    private boolean dominantAggressorRule;
    private String arrestPolicyNotes;


    // Protective Orders --- 5 Variables

    private boolean protectiveOrderAvailable;
    private boolean emergencyOrderAvailable;
    private int standardOrderDurationDays;
    private int maxOrderDurationDays;
    private boolean exParteOrdersAllowed;

    //Weapons Restriction --- 3 Variables

    private boolean firearmProhibition;
    private String firearmProhibitionDuration;
    private boolean firearmSurrenderRequired;

    // Reporting Requirements --- 3 Variables

    private boolean mandatoryReportingHealthcare;
    private boolean mandatoryCounselors;
    private String mandatoryReporterCategories;

    //Victim Protections --- 3 Variables

    private boolean victimNotificationRequired;
    private boolean victimImpactStatementAllowed;
    private boolean addressConfidentialityProgram;


    // Legal References --- 2 Variables

    private String primaryStatuteCitation;
    private String statuteUrl;

    // Additional Context --- 2 Variables

    private String notableProvisions;
    private String recentChanges;

    //Getters ----------------------------------------------------------------

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    //Relationship definitions


    public boolean isCoversSpouses() {
        return coversSpouses;
    }

    public boolean isCoversCohabitants() {
        return coversCohabitants;
    }

    public boolean isCoversDatingPartners() {
        return coversDatingPartners;
    }

    public boolean isCoversFormerPartners() {
        return coversFormerPartners;
    }

    public boolean isCoversFamilyMembers() {
        return coversFamilyMembers;
    }

    public boolean isCoversRoommates() {
        return coversRoommates;
    }

    public String getRelationshipDefinition() {
        return relationshipDefinition;
    }

    // Criminal Classifications


    public String getFirstOffense() {
        return firstOffense;
    }

    public String getRepeatOffense() {
        return repeatOffense;
    }

    public boolean HasMandatoryMinimum() {
        return hasMandatoryMinimum;
    }

    public int getMinimumSentenceDays() {
        return minimumSentenceDays;
    }

    public double getMaximumSentenceYears() {
        return maximumSentenceYears;
    }

    //Arrest Policies


    public boolean isMandatoryArrestPolicy() {
        return mandatoryArrestPolicy;
    }

    public boolean isDominantAggressorRule() {
        return dominantAggressorRule;
    }

    public String getArrestPolicyNotes() {
        return arrestPolicyNotes;
    }


    // Protective Orders


    public boolean isProtectiveOrderAvailable() {
        return protectiveOrderAvailable;
    }

    public boolean isEmergencyOrderAvailable() {
        return emergencyOrderAvailable;
    }

    public int getStandardOrderDurationDays() {
        return standardOrderDurationDays;
    }

    public int getMaxOrderDurationDays() {
        return maxOrderDurationDays;
    }

    public boolean isExParteOrdersAllowed() {
        return exParteOrdersAllowed;
    }

    //Weapons Restriction


    public boolean isFirearmProhibition() {
        return firearmProhibition;
    }

    public String getFirearmProhibitionDuration() {
        return firearmProhibitionDuration;
    }

    public boolean isFirearmSurrenderRequired() {
        return firearmSurrenderRequired;
    }

    // Reporting requirements


    public boolean isMandatoryReportingHealthcare() {
        return mandatoryReportingHealthcare;
    }

    public boolean isMandatoryCounselors() {
        return mandatoryCounselors;
    }

    public String getMandatoryReporterCategories() {
        return mandatoryReporterCategories;
    }

    public boolean isVictimNotificationRequired() {
        return victimNotificationRequired;
    }

    public boolean isVictimImpactStatementAllowed() {
        return victimImpactStatementAllowed;
    }

    public boolean isAddressConfidentialityProgram() {
        return addressConfidentialityProgram;
    }

    // Legal References


    public String getPrimaryStatuteCitation() {
        return primaryStatuteCitation;
    }

    public String getStatuteUrl() {
        return statuteUrl;
    }

    public String getNotableProvisions() {
        return notableProvisions;
    }

    public String getRecentChanges() {
        return recentChanges;
    }

    //Setters ----------------------------------------------------------------

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    //Relationship definitions


    public void setCoversSpouses(boolean coversSpouses) {
        this.coversSpouses = coversSpouses;
    }

    public void setCoversCohabitants(boolean coversCohabitants) {
        this.coversCohabitants = coversCohabitants;
    }

    public void setCoversDatingPartners(boolean coversDatingPartners) {
        this.coversDatingPartners = coversDatingPartners;
    }

    public void setCoversFormerPartners(boolean coversFormerPartners) {
        this.coversFormerPartners = coversFormerPartners;
    }

    public void setCoversFamilyMembers(boolean coversFamilyMembers) {
        this.coversFamilyMembers = coversFamilyMembers;
    }

    public void setCoversRoommates(boolean coversRoommates) {
        this.coversRoommates = coversRoommates;
    }

    public void setRelationshipDefinition(String relationshipDefinition) {
        this.relationshipDefinition = relationshipDefinition;
    }


    // Criminal Classifications

    public void setFirstOffense(String firstOffense) {
        this.firstOffense = firstOffense;
    }

    public void setRepeatOffense(String repeatOffense) {
        this.repeatOffense = repeatOffense;
    }

    public void setHasMandatoryMinimum(boolean hasMandatoryMinimum) {
        this.hasMandatoryMinimum = hasMandatoryMinimum;
    }

    public void setMinimumSentenceDays(int minimumSentenceDays) {
        this.minimumSentenceDays = minimumSentenceDays;
    }

    public void setMaximumSentenceYears (double maximumSentenceYears) {
        this.maximumSentenceYears = maximumSentenceYears;
    }


    //Arrest Policies


    public void setMandatoryArrestPolicy(boolean mandatoryArrestPolicy) {
        this.mandatoryArrestPolicy = mandatoryArrestPolicy;
    }

    public void setDominantAggressorRule(boolean dominantAggressorRule) {
        this.dominantAggressorRule = dominantAggressorRule;
    }

    public void setArrestPolicyNotes(String arrestPolicyNotes) {
        this.arrestPolicyNotes = arrestPolicyNotes;
    }

    // Protective Orders


    public void setProtectiveOrderAvailable(boolean protectiveOrderAvailable) {
        this.protectiveOrderAvailable = protectiveOrderAvailable;
    }

    public void setEmergencyOrderAvailable(boolean emergencyOrderAvailable) {
        this.emergencyOrderAvailable = emergencyOrderAvailable;
    }

    public void setStandardOrderDurationDays(int standardOrderDurationDays) {
        this.standardOrderDurationDays = standardOrderDurationDays;
    }

    public void setMaxOrderDurationDays(int maxOrderDurationDays) {
        this.maxOrderDurationDays = maxOrderDurationDays;
    }

    public void setExParteOrdersAllowed(boolean exParteOrdersAllowed) {
        this.exParteOrdersAllowed = exParteOrdersAllowed;
    }

    //Weapons Restriction


    public void setFirearmProhibition(boolean firearmProhibition) {
        this.firearmProhibition = firearmProhibition;
    }

    public void setFirearmProhibitionDuration(String firearmProhibitionDuration) {
        this.firearmProhibitionDuration = firearmProhibitionDuration;
    }

    public void setFirearmSurrenderRequired(boolean firearmSurrenderRequired) {
        this.firearmSurrenderRequired = firearmSurrenderRequired;
    }

    // Reporting requirements


    public void setMandatoryReportingHealthcare(boolean mandatoryReportingHealthcare) {
        this.mandatoryReportingHealthcare = mandatoryReportingHealthcare;
    }

    public void setMandatoryCounselors(boolean mandatoryCounselors) {
        this.mandatoryCounselors = mandatoryCounselors;
    }

    public void setMandatoryReporterCategories(String mandatoryReporterCategories) {
        this.mandatoryReporterCategories = mandatoryReporterCategories;
    }

    //Victim Protections


    public void setVictimNotificationRequired(boolean victimNotificationRequired) {
        this.victimNotificationRequired = victimNotificationRequired;
    }

    public void setVictimImpactStatementAllowed(boolean victimImpactStatementAllowed) {
        this.victimImpactStatementAllowed = victimImpactStatementAllowed;
    }

    public void setAddressConfidentialityProgram(boolean addressConfidentialityProgram) {
        this.addressConfidentialityProgram = addressConfidentialityProgram;
    }

    // Legal References


    public void setPrimaryStatuteCitation(String primaryStatuteCitation) {
        this.primaryStatuteCitation = primaryStatuteCitation;
    }

    public void setStatuteUrl(String statuteUrl) {
        this.statuteUrl = statuteUrl;
    }

    public void setNotableProvisions(String notableProvisions) {
        this.notableProvisions = notableProvisions;
    }

    public void setRecentChanges(String recentChanges) {
        this.recentChanges = recentChanges;
    }


    // Constructors ----------------------------------------------------------

    public State() {

    }

    public State(String stateCode, String stateName, LocalDate lastUpdated, boolean coversSpouses, boolean coversCohabitants, boolean coversDatingPartners, boolean coversFormerPartners, boolean coversFamilyMembers, boolean coversRoommates, String relationshipDefinition, String firstOffense, String repeatOffense, boolean hasMandatoryMinimum, int minimumSentenceDays, boolean mandatoryArrestPolicy, boolean dominantAggressorRule, String arrestPolicyNotes, boolean protectiveOrderAvailable, boolean emergencyOrderAvailable, int standardOrderDurationDays, int maxOrderDurationDays, boolean exParteOrdersAllowed, boolean firearmProhibition, String firearmProhibitionDuration, boolean firearmSurrenderRequired, boolean mandatoryReportingHealthcare, boolean mandatoryCounselors, String mandatoryReporterCategories, boolean victimNotificationRequired, boolean victimImpactStatementAllowed, boolean addressConfidentialityProgram, String primaryStatuteCitation, String statuteUrl, String notableProvisions, String recentChanges) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.lastUpdated = lastUpdated;
        this.coversSpouses = coversSpouses;
        this.coversCohabitants = coversCohabitants;
        this.coversDatingPartners = coversDatingPartners;
        this.coversFormerPartners = coversFormerPartners;
        this.coversFamilyMembers = coversFamilyMembers;
        this.coversRoommates = coversRoommates;
        this.relationshipDefinition = relationshipDefinition;
        this.firstOffense = firstOffense;
        this.repeatOffense = repeatOffense;
        this.hasMandatoryMinimum = hasMandatoryMinimum;
        this.minimumSentenceDays = minimumSentenceDays;
        this.mandatoryArrestPolicy = mandatoryArrestPolicy;
        this.dominantAggressorRule = dominantAggressorRule;
        this.arrestPolicyNotes = arrestPolicyNotes;
        this.protectiveOrderAvailable = protectiveOrderAvailable;
        this.emergencyOrderAvailable = emergencyOrderAvailable;
        this.standardOrderDurationDays = standardOrderDurationDays;
        this.maxOrderDurationDays = maxOrderDurationDays;
        this.exParteOrdersAllowed = exParteOrdersAllowed;
        this.firearmProhibition = firearmProhibition;
        this.firearmProhibitionDuration = firearmProhibitionDuration;
        this.firearmSurrenderRequired = firearmSurrenderRequired;
        this.mandatoryReportingHealthcare = mandatoryReportingHealthcare;
        this.mandatoryCounselors = mandatoryCounselors;
        this.mandatoryReporterCategories = mandatoryReporterCategories;
        this.victimNotificationRequired = victimNotificationRequired;
        this.victimImpactStatementAllowed = victimImpactStatementAllowed;
        this.addressConfidentialityProgram = addressConfidentialityProgram;
        this.primaryStatuteCitation = primaryStatuteCitation;
        this.statuteUrl = statuteUrl;
        this.notableProvisions = notableProvisions;
        this.recentChanges = recentChanges;
    }



}
