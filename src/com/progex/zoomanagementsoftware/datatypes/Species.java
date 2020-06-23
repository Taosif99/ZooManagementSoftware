package com.progex.zoomanagementsoftware.datatypes;

/**
 * Class which is used to model the species of an animal in our zoo management software.
 */
public class Species {

    private int id;

    //Habitat vllt weg bei der Implementation
    private String habitat;

    private Description description;

    public Species(int id, String habitat, Description description) {
        this.id = id;
        this.habitat = habitat;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    
    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
