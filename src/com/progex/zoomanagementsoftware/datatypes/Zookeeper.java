package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;
import java.sql.Timestamp;
/**
 * Class which is used to model a zookeeper in our zoo management software.
 */

public class Zookeeper extends User
{
    //TODO find adequate data structure
	//private Animal animalList; //FALLS NICHT GEBRAUCHT ENTFERNEN !!!
	
	private Shift shift;

    public Zookeeper(Shift shift, String username, String firstname, String lastname, String email, String phoneNumber, int id, Salutation salutation, Date birthday, String hashedPassword, Address address, Timestamp lastLogDate) {
        
        super(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
        //this.animalList = animalList;
        this.shift = shift;
    }

<<<<<<< HEAD
    
    public Zookeeper(String username, String firstname, Timestamp lastLogDate) {
        super(username, firstname, lastLogDate);
    }    

=======
    /*
>>>>>>> 80b78885264eed94bfba8a6ca0bff436ca89d610
    public Animal getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Animal animalList) {
        this.animalList = animalList;
    }*/

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }   
}
