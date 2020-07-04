package com.progex.zoomanagementsoftware.datatypes;

/**
 * Class which is used to model an address in our zoo management software.
 */
public class Address {

    private int id;

    private String street;

    private int countryID;

    private String zip;

    private String city;

    /**
     * Standard constructor to model a compound dataset.
     * @param id
     * @param street
     * @param countryID
     * @param zip
     * @param city 
     */
    public Address(int id, String street, int countryID, String zip, String city) {
          
        this.id = id;
        this.street = street;
        this.countryID = countryID;
        this.zip = zip;
        this.city = city;
    }

    /**
     * This constructor is used to create an Address object without the id.
     * @param street
     * @param countryID
     * @param zip
     * @param city 
     */
    public Address(String street, int countryID, String zip, String city){
        
        this.street = street;
        this.countryID = countryID;
        this.zip = zip;
        this.city = city;
    }
    
    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}