package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Class which is used to model a zookeeper in our zoo management software.
 */
public class Zookeeper extends User {

    private Shift shift;

    /**
     * Standard constructor to model a zookeeper dataset.
     * @param shift
     * @param username
     * @param firstname
     * @param lastname
     * @param email
     * @param phoneNumber
     * @param id
     * @param salutation
     * @param birthday
     * @param hashedPassword
     * @param address
     * @param lastLogDate 
     */
    public Zookeeper(Shift shift, String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {

        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
        this.shift = shift;
    }

    /**
     * This constructor is used to model a zookeeper with the attrbutes username,
     * lastname and lastLogDate.
     * @param username
     * @param firstname
     * @param lastLogDate 
     */
    public Zookeeper(String username, String firstname, Timestamp lastLogDate) {
        super(username, firstname, lastLogDate);
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}