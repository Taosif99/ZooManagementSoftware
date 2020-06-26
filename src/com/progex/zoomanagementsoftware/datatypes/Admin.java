package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;


/**
 *  Class which is used to model an Admin user in our zoo management software.
 */
public class Admin extends User {

    public Admin(String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
    }
    
    public Admin(String username, String firstname, Timestamp lastLogDate) {
        super(username, firstname, lastLogDate);
    }
}
