package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import com.techelevator.model.Charity;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class JDBCCharityDao  implements CharityDao{

    // Instance Variables ----------------------------------------------------------------------

    private final JdbcTemplate jdbcTemplate;

    // Constructors -----------------------------------------------------------------------

    public JDBCCharityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CRUD Methods ------------------------------------------------------------------------------

    @Override
    public Charity createCharity(Charity charity) {
        String sql = "INSERT INTO charity (charity_name, city, state, zip) " +
                "VALUES (?, ?, ?, ?) RETURNING charity_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,
                charity.getCharityName(),
                charity.getCity(),
                charity.getState(),
                charity.getZip());

        if (results.next()) {
            charity.setCharityId(results.getInt("charity_id"));
        }

        return charity;
    }


    public Charity updateCharity(Charity charity) {
        String sql = "UPDATE charity " +
                "SET charity_name = ?, city = ?, state = ?, zip = ? " +
                "WHERE charity_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql,
                charity.getCharityName(),
                charity.getCity(),
                charity.getState(),
                charity.getZip(),
                charity.getCharityId());

        return charity;
    }

    @Override
    public boolean deleteCharity(int charityId) {
        String sql = "DELETE FROM charity WHERE charity_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, charityId);

        return (rowsAffected > 0);
    }

    // Search Return Methods --------------------------------------------------------------------

    @Override
    public List<Charity> getCharities() {
        List<Charity> charities = new ArrayList<>();

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity " +
                "ORDER BY charity_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Charity charity = mapRowToCharity(results);
            charities.add(charity);
        }

        return charities;
    }

    @Override
    public Charity getCharityById(int charityId) {
        Charity charity = null;

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity " +
                "WHERE charity_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, charityId);

        if (results.next()) {
            charity = mapRowToCharity(results);
        }

        return charity;
    }


    @Override
    public List<Charity> getCharityByState(String stateCode) {
        List<Charity> charities = new ArrayList<>();

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity " +
                "WHERE state = ? " +
                "ORDER BY charity_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateCode);

        while (results.next()) {
            Charity charity = mapRowToCharity(results);
            charities.add(charity);
        }

        return charities;
    }

    @Override
    public List<Charity> getCharityByStateAndCity(String stateCode, String city) {
        List<Charity> charities = new ArrayList<>();

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity " +
                "WHERE state = ? AND city = ? " +
                "ORDER BY charity_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateCode, city);

        while (results.next()) {
            Charity charity = mapRowToCharity(results);
            charities.add(charity);
        }

        return charities;
    }

    @Override
    public List<Charity> getCharitybyZip(String zipcode) {
        List<Charity> charities = new ArrayList<>();

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity " +
                "WHERE zip = ? " +
                "ORDER BY charity_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, zipcode);

        while (results.next()) {
            Charity charity = mapRowToCharity(results);
            charities.add(charity);
        }

        return charities;
    }

    @Override
    public List<Charity> getCharityByCity(String city) {
        List<Charity> charities = new ArrayList<>();

        String sql = "SELECT charity_id, charity_name, city, state, zip " +
                "FROM charity WHERE city ILIKE ? " +
                "ORDER BY charity_name LIMIT 20;";

        String wildcardCity = "%" + city + "%";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, wildcardCity);

        while (results.next()) {
            Charity charity = mapRowToCharity(results);
            charities.add(charity);
        }
        return charities;
    }

    private Charity mapRowToCharity(SqlRowSet rowSet) {
        Charity charity = new Charity();
        charity.setCharityId(rowSet.getInt("charity_id"));
        charity.setCharityName(rowSet.getString("charity_name"));
        charity.setCity(rowSet.getString("city"));
        charity.setState(rowSet.getString("state"));
        charity.setZip(rowSet.getString("zip"));
        return charity;
    }
}
