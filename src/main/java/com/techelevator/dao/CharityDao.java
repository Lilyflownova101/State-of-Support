package com.techelevator.dao;

import com.techelevator.model.Charity;

import java.util.List;
import java.util.ArrayList;

public interface CharityDao {

    // CRUD Operations -------------------------------------------------------------

    Charity createCharity(Charity charity);
    Charity updateCharity(Charity charity);
    boolean deleteCharity(int charityId);



    // Search Rreturn Methods ------------------------------------------------------


    public List<Charity> getCharities();
    public Charity getCharityById(int charityId);
    public List<Charity> getCharityByState(String stateCode);
    public List<Charity> getCharityByStateAndCity(String stateCode, String city);
    public List<Charity> getCharitybyZip(String zipcode);
    public List<Charity> getCharityByCity(String city);
}
