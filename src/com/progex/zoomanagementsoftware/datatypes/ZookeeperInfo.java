package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Timestamp;

/**
 * Class which is used to mode zookeeper information in our zoo management
 * software.
 */
public class ZookeeperInfo {

    private Timestamp nextFeedingTimeInMinutes;

    private String compoundName;

    private String animalName;

    private String foodName;

    private String storageRoomNumber;

    private double amountFood;

    private boolean isMultipleFeeding;

    /**
     * Standard constructor to model feeding info for the zookeeper.
     * @param feedingTime
     * @param compoundName
     * @param animalName
     * @param foodName
     * @param storageRoomNumber
     * @param amountFood 
     */
    public ZookeeperInfo(Timestamp feedingTime, String compoundName, String animalName, String foodName, String storageRoomNumber, double amountFood) {

        this.nextFeedingTimeInMinutes = feedingTime;
        this.compoundName = compoundName;
        this.animalName = animalName;
        this.foodName = foodName;
        this.storageRoomNumber = storageRoomNumber;
        this.amountFood = amountFood;
    }

    public Timestamp getFeedingTime() {
        return nextFeedingTimeInMinutes;
    }

    public boolean isIsMultipleFeeding() {
        return isMultipleFeeding;
    }

    public void setIsMultipleFeeding(boolean isMultipleFeeding) {
        this.isMultipleFeeding = isMultipleFeeding;
    }

    public void setFeedingTime(Timestamp feedingTime) {
        this.nextFeedingTimeInMinutes = feedingTime;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getStorageRoomNumber() {
        return storageRoomNumber;
    }

    public void setStorageRoomNumber(String storageRoomNumber) {
        this.storageRoomNumber = storageRoomNumber;
    }

    public double getAmountFood() {
        return amountFood;
    }

    public void setAmountFood(double amountFood) {
        this.amountFood = amountFood;
    }
}
