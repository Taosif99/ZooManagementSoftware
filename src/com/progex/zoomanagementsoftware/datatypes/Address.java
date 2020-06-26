package com.progex.zoomanagementsoftware.datatypes;

/**
 * Class which is used to model an address in our zoo management software.
 */
public class Address {

    private int id;

    private String street;

    private String country;

    private String zip;

    private String city;

    public Address(int id, String street, String country, String zip, String city) {
          
        this.id = id;
        this.street = street;
        this.country = country;
        this.zip = zip;
        this.city = city;
    }

    public Address(String street, String country, String zip, String city){
        this.street = street;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
