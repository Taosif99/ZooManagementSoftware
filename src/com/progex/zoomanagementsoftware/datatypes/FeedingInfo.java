package com.progex.zoomanagementsoftware.datatypes;
import java.sql.Date;
/**
 * @(#) FeedingInfo.java
 */

public class FeedingInfo
{
	private String animalName;
		
	private String compundName;
        
        private String abstellraum;
        
        private double amountOfFood;
	
	private java.sql.Timestamp startFeedingTime; //WAHRSCHEINLICH IST HIER SQL TIMESTAMP ANGEBRACHT
	
        private int nextFeedingInMinutes;
        
	private String foodName;
        
        private Date endFeedingTime;
	
    public FeedingInfo(String animalName, String compundName, java.sql.Timestamp startFeedingTime,int nextFeedingInMinutes, String foodName, Date endFeedingTime, String abstellraum, double amountOfFood) {
        
        this.abstellraum = abstellraum;
        this.animalName = animalName;
        this.compundName = compundName;
        this.startFeedingTime = startFeedingTime;
        this.foodName = foodName;
        this.endFeedingTime = endFeedingTime;
        this.amountOfFood = amountOfFood;
        this.nextFeedingInMinutes = nextFeedingInMinutes;
    }

    public int getNextFeedingInMinutes() {
        return nextFeedingInMinutes;
    }

    public void setNextFeedingInMinutes(int nextFeedingInMinutes) {
        this.nextFeedingInMinutes = nextFeedingInMinutes;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    
    
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAbstellraum() {
        return abstellraum;
    }

    public void setAbstellraum(String abstellraum) {
        this.abstellraum = abstellraum;
    }
    
    

    public String getCompundName() {
        return compundName;
    }

    public void setCompundName(String compundName) {
        this.compundName = compundName;
    }

    public java.sql.Timestamp getStartFeedingTime() {
        return startFeedingTime;
    }

    public void setStartFeedingTime(java.sql.Timestamp startFeedingTime) {
        this.startFeedingTime = startFeedingTime;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Date getEndFeedingTime() {
        return endFeedingTime;
    }

    public void setEndFeedingTime(Date endFeedingTime) {
        this.endFeedingTime = endFeedingTime;
    }

}
