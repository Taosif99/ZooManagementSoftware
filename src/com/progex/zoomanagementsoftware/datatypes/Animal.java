package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;

/**
 *  Class which is used to model an animal in our zoo management software.
 */
public class Animal {

    private int id;

    private String name;

    private Date birthday;

    private String sex;

    private Compound compound;

    private Species species;
    
    private String visibleForGuest;

    
    /**
     * Constructor to create an animal object which models a complete animal dataset.
     * @param id
     * @param name
     * @param birthday
     * @param sex
     * @param compound
     * @param species
     * @param visibleForGuest 
     */
    public Animal(int id, String name, Date birthday, String sex, Compound compound, Species species, String visibleForGuest) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.compound = compound;
        this.species = species;
        this.visibleForGuest = visibleForGuest;
    }

    
    




    
    
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Compound getCompound() {
        return compound;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getVisibleForGuest() {
        return visibleForGuest;
    }

    public void setVisibleForGuest(String visibleForGuest) {
        this.visibleForGuest = visibleForGuest;
    }    
}
