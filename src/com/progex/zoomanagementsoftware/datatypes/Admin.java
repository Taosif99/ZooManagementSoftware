package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;

/**
 * @(#) Admin.java
 */
public class Admin extends User {

    public Admin(String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Date lastLogDate) {
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
    }   
}
