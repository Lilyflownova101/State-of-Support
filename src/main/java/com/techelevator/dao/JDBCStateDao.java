package com.techelevator.dao;

import com.techelevator.model.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;

@Repository
public class JDBCStateDao implements StateDao{

    private final JdbcTemplate jdbcTemplate;

    // Constructors -----------------------------------------------------------------------

    public JDBCStateDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CRUD Methods ------------------------------------------------------------------------------

    @Override
    public State createState(State state) {
        String sql = "INSERT INTO state_laws (state_code, state_name, last_updated, " +
                // Relationship Definitions
                "covers_spouses, covers_cohabitants, covers_dating_partners, " +
                "covers_former_partners, covers_family_members, covers_roommates, relationship_definition," +
                // Criminal Classifications
                "first_offense, repeat_offense, has_mandatory_minimum, minimum_sentence_days, maximum_sentence_years,"+
                // Arrest Policies
                "mandatory_arrest_policy,dominant_aggressor_rule, arrest_policy_notes," +
                // Protective Orders
                "protective_order_available, emergency_order_available, standard_order_duration_days,"+
                "max_order_duration_days, ex_parte_orders_allowed, " +
                // Weapons Restrictions
                "firearm_prohibition, firearm_prohibition_duration, firearm_surrender_required, " +
                // Reporting requirements
                "mandatory_reporting_healthcare, mandatory_counselors, mandatory_reporter_categories, " +
                // Victim Protections
                " victim_notification_required, victim_impact_statement_allowed, address_confidentiality_program, " +
                // Legal references
                "primary_statute_citation, statute_url," +
                // Additional Context
                " notable_provisions, recent_changes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        jdbcTemplate.update(sql,

                // 36 Variables Total
                // State info --- 3 Variables
                state.getStateCode(),
                state.getStateName(),
                state.getLastUpdated(),

                // Relationship Definitions --- 7 Variables
                state.isCoversSpouses(),
                state.isCoversCohabitants(),
                state.isCoversDatingPartners(),
                state.isCoversFormerPartners(),
                state.isCoversFamilyMembers(),
                state.isCoversRoommates(),
                state.getRelationshipDefinition(),

                // Criminal Classifications --- 5 Variables
                state.getFirstOffense(),
                state.getRepeatOffense(),
                state.HasMandatoryMinimum(),
                state.getMinimumSentenceDays(),
                state.getMaximumSentenceYears(),

                // Arrest Policies --- 3 Variables
                state.isMandatoryArrestPolicy(),
                state.isDominantAggressorRule(),
                state.getArrestPolicyNotes(),

                //Protective Orders --- 5 Variables
                state.isProtectiveOrderAvailable(),
                state.isEmergencyOrderAvailable(),
                state.getStandardOrderDurationDays(),
                state.getMaxOrderDurationDays(),
                state.isExParteOrdersAllowed(),

                //Weapons Restrictions --- 3 Variables
                state.isFirearmProhibition(),
                state.getFirearmProhibitionDuration(),
                state.isFirearmSurrenderRequired(),

                // Reporting Requirements --- 3 Variables
                state.isMandatoryReportingHealthcare(),
                state.isMandatoryCounselors(),
                state.getMandatoryReporterCategories(),

                // Victim Protections --- 3 Variables
                state.isVictimNotificationRequired(),
                state.isVictimImpactStatementAllowed(),
                state.isAddressConfidentialityProgram(),

                // Legal references --- 2 Variables
                state.getPrimaryStatuteCitation(),
                state.getStatuteUrl(),

                // Additional Context --- 2 Variables
                state.getNotableProvisions(),
                state.getRecentChanges());

        return state;
    }

    @Override
    public State updateState(State state) {
        String sql = "UPDATE state_laws " +
                // State Info
                "SET state_name = ?, last_updated = ?, " +
                // Relationship Definitions
                "covers_spouses = ?, covers_cohabitants = ?, covers_dating_partners = ?, " +
                "covers_former_partners = ?, covers_family_members = ?, covers_roommates = ?, relationship_definition = ?,"  +
                // Criminal Classifications
                "first_offense = ?, " +
                "repeat_offense = ?, has_mandatory_minimum = ?, " +
                "minimum_sentence_days = ?, maximum_sentence_years = ?, " +
                // Arrest Policies
                "mandatory_arrest_policy = ?, dominant_aggressor_rule = ?, " +
                "arrest_policy_notes = ?, "  +
                // Protective Orders
                " protective_order_available = ?, emergency_order_available = ?, standard_order_duration_days = ?, " +
                "max_order_duration_days = ?, ex_parte_orders_allowed = ?, " +
                // Weapons Restrictions
                "firearm_prohibition = ?, firearm_prohibition_duration = ?, firearm_surrender_required = ?,"  +
                // Reporting Requirements
                "mandatory_reporting_healthcare = ?, " +
                "mandatory_counselors = ?, mandatory_reporter_categories = ?, " +
                // Victim Protections
                "victim_notification_required = ?, victim_impact_statement_allowed = ?, " +
                "address_confidentiality_program = ?," +
                // Legal References
                " primary_statute_citation = ?, statute_url = ?," +
                // Additional Context
                " notable_provisions = ?, recent_changes = ? " +
                // Where Statement
                "WHERE state_code = ?";

        int rowsAffected = jdbcTemplate.update(sql,
                // 36 Variables Total
                // State Info --- 3 Variables

                state.getStateName(),
                state.getLastUpdated(),

                // Relationship Definitions --- 7 Variables
                state.isCoversSpouses(),
                state.isCoversCohabitants(),
                state.isCoversDatingPartners(),
                state.isCoversFormerPartners(),
                state.isCoversFamilyMembers(),
                state.isCoversRoommates(),
                state.getRelationshipDefinition(),

                // Criminal Classifications --- 5 Variables
                state.getFirstOffense(),
                state.getRepeatOffense(),
                state.HasMandatoryMinimum(),
                state.getMinimumSentenceDays(),
                state.getMaximumSentenceYears(),

                // Arrest Policies --- 3 Variables
                state.isMandatoryArrestPolicy(),
                state.isDominantAggressorRule(),
                state.getArrestPolicyNotes(),


                // Protective Orders --- 5 Variables
                state.isProtectiveOrderAvailable(),
                state.isEmergencyOrderAvailable(),
                state.getStandardOrderDurationDays(),
                state.getMaxOrderDurationDays(),
                state.isExParteOrdersAllowed(),

                // Weapons Restrictions --- 3 Variables
                state.isFirearmProhibition(),
                state.getFirearmProhibitionDuration(),
                state.isFirearmSurrenderRequired(),


                // Reporting Requirements --- 3 Variables
                state.isMandatoryReportingHealthcare(),
                state.isMandatoryCounselors(),
                state.getMandatoryReporterCategories(),

                // Victim protections --- 3 Variables
                state.isVictimNotificationRequired(),
                state.isVictimImpactStatementAllowed(),
                state.isAddressConfidentialityProgram(),

                // Legal References --- 2 Variables
                state.getPrimaryStatuteCitation(),
                state.getStatuteUrl(),

                // Additional Context --- 2 Variables
                state.getNotableProvisions(),
                state.getRecentChanges(),

                // Where clause
                state.getStateCode());

        return state;
    }



    @Override
    public boolean deleteState(String stateCode) {
        String sql = "DELETE FROM state_laws WHERE state_code = ?;";

        int rowsAffected = jdbcTemplate.update(sql, stateCode);

        return (rowsAffected > 0);
    }

    // Search Return Methods --------------------------------------------------------------------

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<>();

        String sql = "SELECT * FROM state_laws ORDER BY state_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            State state = mapRowToState(results);
            states.add(state);
        }

        return states;
    }

    @Override
    public State getStatesByCode(String stateCode) {
        State state = null;

        String sql = "SELECT * FROM state_laws WHERE state_code = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateCode);

        if (results.next()) {
            state = mapRowToState(results);
        }

        return state;
    }



    private State mapRowToState(SqlRowSet rowSet) {
        State state = new State();

        // Primary identification
        state.setStateCode(rowSet.getString("state_code"));
        state.setStateName(rowSet.getString("state_name"));
        state.setLastUpdated(rowSet.getDate("last_updated").toLocalDate());

        // Relationship definitions
        state.setCoversSpouses(rowSet.getBoolean("covers_spouses"));
        state.setCoversCohabitants(rowSet.getBoolean("covers_cohabitants"));
        state.setCoversDatingPartners(rowSet.getBoolean("covers_dating_partners"));
        state.setCoversFormerPartners(rowSet.getBoolean("covers_former_partners"));
        state.setCoversFamilyMembers(rowSet.getBoolean("covers_family_members"));
        state.setCoversRoommates(rowSet.getBoolean("covers_roommates"));
        state.setRelationshipDefinition(rowSet.getString("relationship_definition"));

        // Criminal classifications
        state.setFirstOffense(rowSet.getString("first_offense"));
        state.setRepeatOffense(rowSet.getString("repeat_offense"));
        state.setHasMandatoryMinimum(rowSet.getBoolean("has_mandatory_minimum"));
        state.setMinimumSentenceDays(rowSet.getInt("minimum_sentence_days"));
        state.setMaximumSentenceYears(rowSet.getDouble("maximum_sentence_years"));

        // Arrest policies
        state.setMandatoryArrestPolicy(rowSet.getBoolean("mandatory_arrest_policy"));
        state.setDominantAggressorRule(rowSet.getBoolean("dominant_aggressor_rule"));
        state.setArrestPolicyNotes(rowSet.getString("arrest_policy_notes"));

        // Protective orders
        state.setProtectiveOrderAvailable(rowSet.getBoolean("protective_order_available"));
        state.setEmergencyOrderAvailable(rowSet.getBoolean("emergency_order_available"));
        state.setStandardOrderDurationDays(rowSet.getInt("standard_order_duration_days"));
        state.setMaxOrderDurationDays(rowSet.getInt("max_order_duration_days"));
        state.setExParteOrdersAllowed(rowSet.getBoolean("ex_parte_orders_allowed"));

        // Weapons restrictions
        state.setFirearmProhibition(rowSet.getBoolean("firearm_prohibition"));
        state.setFirearmProhibitionDuration(rowSet.getString("firearm_prohibition_duration"));
        state.setFirearmSurrenderRequired(rowSet.getBoolean("firearm_surrender_required"));

        // Reporting requirements
        state.setMandatoryReportingHealthcare(rowSet.getBoolean("mandatory_reporting_healthcare"));
        state.setMandatoryCounselors(rowSet.getBoolean("mandatory_counselors"));
        state.setMandatoryReporterCategories(rowSet.getString("mandatory_reporter_categories"));

        // Victim protections
        state.setVictimNotificationRequired(rowSet.getBoolean("victim_notification_required"));
        state.setVictimImpactStatementAllowed(rowSet.getBoolean("victim_impact_statement_allowed"));
        state.setAddressConfidentialityProgram(rowSet.getBoolean("address_confidentiality_program"));

        // Legal references
        state.setPrimaryStatuteCitation(rowSet.getString("primary_statute_citation"));
        state.setStatuteUrl(rowSet.getString("statute_url"));

        // Additional context
        state.setNotableProvisions(rowSet.getString("notable_provisions"));
        state.setRecentChanges(rowSet.getString("recent_changes"));

        return state;
    }
}
