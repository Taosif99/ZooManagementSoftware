package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;

/**
 * @(#) Animal.java
 */
public class Animal {

    private int id;

    private String name;

    private Date birthday;

    private String sex;

    private Compound compound;

    private Species species;

    private Meal meals;

   // private String animalName;

    public Animal(int id, String name, Date birthday, String sex, Compound compound, Species species, Meal meals) {

        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.compound = compound;
        this.species = species;
        this.meals = meals;
       // this.animalName = animalName;
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

    public Meal getMeals() {
        return meals;
    }

    public void setMeals(Meal meals) {
        this.meals = meals;
    }

    /*
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }*/
}
