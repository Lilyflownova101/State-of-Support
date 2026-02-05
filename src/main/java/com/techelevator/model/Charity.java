package com.techelevator.model;

public class Charity {

    //Instance Variables -------------------------------------------

    private int charityId;
    private String charityName;
    private String city;
    private String state;
    private String zip;

    //Getters ------------------------------------------------------

    public int getCharityId() {
        return charityId;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCharityName() {
        return charityName;
    }


    //Setters ------------------------------------------------------

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }


    // Constructors ------------------------------------------------

    public Charity() {

    }

    public Charity(int charityId, String charityName, String city, String state, String zip) {
        this.charityId=charityId;
        this.charityName=charityName;
        this.city=city;
        this.state=state;
    }

    //Methods ------------------------------------------------------


}
