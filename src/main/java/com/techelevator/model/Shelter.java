package com.techelevator.model;

public class Shelter {

    // Instance Variables -------------------------------------------------

    private int shelterId;
    private String shelterName;

    private String city;
    private String state;
    private String zip;



    // Getters -------------------------------------------------------------

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }



    public String getShelterName() {
        return shelterName;
    }

    public int getShelterId() {
        return shelterId;
    }


    // Setters -------------------------------------------------------------

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
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


    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }


    // Constructors --------------------------------------------------------

    public Shelter() {

    }

    public Shelter(int shelterId, String shelterName, String city, String state, String zip) {
        this.shelterId=shelterId;
        this.shelterName=shelterName;

        this.city=city;
        this.state=state;
        this.zip=zip;
    }



    // Methods --------------------------------------------------------------


}
