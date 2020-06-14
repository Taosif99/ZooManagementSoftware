package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
/**
 * @(#) Zookeeper.java
 */

public class Zookeeper extends User
{
    //TODO find adequate data structure
	private Animal animalList; //FALLS NICHT GEBRAUCHT ENTFERNEN !!!
	
	private Shift shift;

    public Zookeeper(Animal animalList, Shift shift, String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Date lastLogDate) {
        
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
        this.animalList = animalList;
        this.shift = shift;
    }

    public Animal getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Animal animalList) {
        this.animalList = animalList;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }   
}
