package com.progex.zoomanagementsoftware.datatypes;

/**
 * This class is used to represent a record of the relation between zookeeper
 * and animal in an object oriented way.
 */
public class ZookeeperToAnimalR {

    int userId;
    String firstname;
    String lastname;
    int animalId;
    String animalName;

    /**
     * Standard constructor to model the relation zookeeper to animal dataset.
     * @param userId
     * @param firstname
     * @param lastname
     * @param animalId
     * @param animalName 
     */
    public ZookeeperToAnimalR(int userId, String firstname, String lastname, int animalId, String animalName) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.animalId = animalId;
        this.animalName = animalName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
