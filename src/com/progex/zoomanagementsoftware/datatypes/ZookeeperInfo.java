package com.progex.zoomanagementsoftware.datatypes;
import java.sql.Date;
/**
 * @(#) ZookeeperInfo.java
 */

public class ZookeeperInfo
{
	private Date feedingTime;
	
	private String compoundName;
	
	private String animalName;
	
	private String foodName;
	
	private int storageRoomNumber;
	
	private double amountFood;

    public ZookeeperInfo(Date feedingTime, String compoundName, String animalName, String foodName, int storageRoomNumber, double amountFood) {
        
        this.feedingTime = feedingTime;
        this.compoundName = compoundName;
        this.animalName = animalName;
        this.foodName = foodName;
        this.storageRoomNumber = storageRoomNumber;
        this.amountFood = amountFood;
    }

    public Date getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(Date feedingTime) {
        this.feedingTime = feedingTime;
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

    public int getStorageRoomNumber() {
        return storageRoomNumber;
    }

    public void setStorageRoomNumber(int storageRoomNumber) {
        this.storageRoomNumber = storageRoomNumber;
    }

    public double getAmountFood() {
        return amountFood;
    }

    public void setAmountFood(double amountFood) {
        this.amountFood = amountFood;
    }       
}
