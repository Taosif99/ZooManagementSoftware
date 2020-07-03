package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;
/**
 * Class which is used to model a zookeeper in our zoo management software.
 */

public class Zookeeper extends User
{
 
	
	private Shift shift;

    public Zookeeper(Shift shift, String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {
        
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
        this.shift = shift;
    }

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
