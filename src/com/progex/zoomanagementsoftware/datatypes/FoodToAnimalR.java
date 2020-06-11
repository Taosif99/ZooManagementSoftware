
package com.progex.zoomanagementsoftware.datatypes;

//import java.sql.Timestamp; TODO USE TIMESTAMP EVENTUALLY BETTER APPROACH

/**
 *This class has been implemented to represent a record of
 * the relation between food and animal in an object oriented way.
 * @author Ouchen
 */
public class FoodToAnimalR {
    
    String foodName;
    int foodID;
    int animalID;
    String startFeedingTime;
    String endFeedingTime;
    double amount;
    
    
    
    
    public FoodToAnimalR(String foodName, int foodID, int animalID, String startFeedingTime, String endFeedingTime, double amount) {
        this.foodName = foodName;
        this.foodID = foodID;
        this.animalID = animalID;
        this.startFeedingTime = startFeedingTime;
        this.endFeedingTime = endFeedingTime;
        this.amount = amount;
    }

    public String getFoodName() {
        return foodName;
    }
    
    public int getFoodID() {
        return foodID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public String getStartFeedingTime() {
        return startFeedingTime;
    }

    public void setStartFeedingTime(String startFeedingTime) {
        this.startFeedingTime = startFeedingTime;
    }

    public String getEndFeedingTime() {
        return endFeedingTime;
    }

    public void setEndFeedingTime(String endFeedingTime) {
        this.endFeedingTime = endFeedingTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
 
    
}
