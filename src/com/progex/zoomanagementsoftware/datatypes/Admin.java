package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *  Class which is used to model an admin in our zoo management software.
 */
public class Admin extends User {

    /**
     * Standard constructor to model an admin dataset.
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
    public Admin(String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
    }
    
    /**
     * This constructor is used for login.
     * @param username
     * @param firstname
     * @param lastLogDate 
     */
    public Admin(String username, String firstname, Timestamp lastLogDate) {
        super(username, firstname, lastLogDate);
    }
}
