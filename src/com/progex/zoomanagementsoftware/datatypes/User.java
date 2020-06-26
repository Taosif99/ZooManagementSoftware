package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Class which is used to model a generic user in our zoo management software.
 */
public class User {

    private String username;

    private String firstname;

    private String lastname;

    private String email;

    private String phoneNumber;

    private int id;

    private Salutation salutation;

    private Date birthday;

    private String hashedPassword;

    private Address address;

    private Timestamp lastLogDate;

    public User(String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {

        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.salutation = salutation;
        this.birthday = birthday;
        this.hashedPassword = hashedPassword;
        this.address = address;
        this.lastLogDate = lastLogDate;
    }
    
    public User(String username, String firstname, Timestamp lastlogdate){
        
        this.username = username;
        this.firstname = firstname;
        this.lastLogDate = lastlogdate;
        
    }

    public User(String username, String firstname, String lastname, String email, String phoneNumber, Salutation salutation, Date birthday, String hashedPassword, Address address) {

        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salutation = salutation;
        this.birthday = birthday;
        this.hashedPassword = hashedPassword;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getLastLogDate() {
        return lastLogDate;
    }

    public void setLastLogDate(Timestamp lastLogDate) {
        this.lastLogDate = lastLogDate;
    }
}
