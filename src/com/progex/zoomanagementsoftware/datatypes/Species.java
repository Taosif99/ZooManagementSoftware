package com.progex.zoomanagementsoftware.datatypes;

/**
 * Class which is used to model the species of an animal in our zoo management software.
 */
public class Species {

    private int id;



    private Description description;

    public Species(int id, Description description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
