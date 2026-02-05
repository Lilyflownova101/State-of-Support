package com.techelevator.dao;

import com.techelevator.model.Shelter;

import java.util.List;
import java.util.ArrayList;

public interface ShelterDao {

    // CRUD Methods ------------------------------------------------------------------------------

    Shelter createShelter(Shelter shelter);

    Shelter updateShelter(Shelter shelter);

    boolean deleteShelter(int shelterId);


// Search Return Methods --------------------------------------------------------------------

    public List<Shelter> getShelters();

    public List<Shelter> getSheltersByState(String stateCode);

    public List<Shelter> getShelterByCity(String city);

    public List<Shelter> getShelterByStateAndCity(String stateCode, String city);

    public List<Shelter> getShelterByName(String name);

    public Shelter getShelterById(int shelterId);


}
