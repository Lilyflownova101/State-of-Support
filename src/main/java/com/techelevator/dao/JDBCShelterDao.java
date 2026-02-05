package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import com.techelevator.model.Shelter;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCShelterDao  implements ShelterDao{

    // Instance Variables --------------------------------------------------------------------


    private final JdbcTemplate jdbcTemplate;

    // Constructors -----------------------------------------------------------------------

    public JDBCShelterDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // CRUD Methods ------------------------------------------------------------------------------

    @Override
    public Shelter createShelter(Shelter shelter) {
        String sql = "INSERT INTO shelter (shelter_name, city, state, zip) " +
                "VALUES (?, ?, ?, ?) RETURNING shelter_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,
                shelter.getShelterName(),
                shelter.getCity(),
                shelter.getState(),
                shelter.getZip());

        if (results.next()) {
            shelter.setShelterId(results.getInt("shelter_id"));
        }

        return shelter;
    }

    @Override
    public Shelter updateShelter(Shelter shelter) {
        String sql = "UPDATE shelter " +
                "SET shelter_name = ?, city = ?, state = ?, zip = ? " +
                "WHERE shelter_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql,
                shelter.getShelterName(),
                shelter.getCity(),
                shelter.getState(),
                shelter.getZip(),
                shelter.getShelterId());

        return shelter;
    }

    @Override
    public boolean deleteShelter(int shelterId) {
        String sql = "DELETE FROM shelter WHERE shelter_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql, shelterId);

        return (rowsAffected > 0);
    }

    // Search Return Methods --------------------------------------------------------------------

    @Override
    public List<Shelter> getShelters() {
        List<Shelter> shelters = new ArrayList<>();

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter " +
                "ORDER BY shelter_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }

        return shelters;
    }

    @Override
    public List<Shelter> getSheltersByState(String stateCode) {
        List<Shelter> shelters = new ArrayList<>();

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter " +
                "WHERE state = ? " +
                "ORDER BY shelter_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateCode);

        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }

        return shelters;
    }

    @Override
    public List<Shelter> getShelterByCity(String city) {
        List<Shelter> shelters = new ArrayList<>();

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter WHERE city ILIKE ? " +
                "ORDER BY shelter_name;";

        String wildcardCity = "%" + city + "%";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, wildcardCity);

        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }
        return shelters;
    }

    @Override
    public List<Shelter> getShelterByStateAndCity(String stateCode, String city) {
        List<Shelter> shelters = new ArrayList<>();

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter " +
                "WHERE state = ? AND city = ? " +
                "ORDER BY shelter_name;";



        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateCode, city);

        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }

        return shelters;
    }

    @Override
    public List<Shelter> getShelterByName(String name) {
        List<Shelter> shelters = new ArrayList<>();

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter " +
                "WHERE shelter_name ILIKE ? " +
                "ORDER BY shelter_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");

        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }

        return shelters;
    }

    public Shelter getShelterById(int shelterId) {
        Shelter shelter = null;

        String sql = "SELECT shelter_id, shelter_name, city, state, zip " +
                "FROM shelter " +
                "WHERE shelter_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, shelterId);

        if (results.next()) {
            shelter = mapRowToShelter(results);
        }

        return shelter;
    }

    private Shelter mapRowToShelter(SqlRowSet rowSet) {
        Shelter shelter = new Shelter();
        shelter.setShelterId(rowSet.getInt("shelter_id"));
        shelter.setShelterName(rowSet.getString("shelter_name"));
        shelter.setCity(rowSet.getString("city"));
        shelter.setState(rowSet.getString("state"));
        shelter.setZip(rowSet.getString("zip"));
        return shelter;
    }
}
