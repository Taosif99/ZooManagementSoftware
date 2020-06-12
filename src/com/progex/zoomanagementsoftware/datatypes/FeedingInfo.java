package com.progex.zoomanagementsoftware.datatypes;
import java.sql.Date;
/**
 * @(#) FeedingInfo.java
 */

public class FeedingInfo
{
	private String animalName;
        
        private int ID;
	
	private String animalBirthday;
	
	private String animalSex;
	
	private String compundName;
	
	private Date startFeedingTime; //WAHRSCHEINLICH IST HIER SQL TIMESTAMP ANGEBRACHT
	
	private String foodName;
	
	private Date endFeedingTime;

    public FeedingInfo(String animalName, String animalBirthDay, String animalSex, String compundName, Date startFeedingTime, String foodName, Date endFeedingTime) {
        
        this.animalName = animalName;
        this.animalBirthday = animalBirthDay;
        this.animalSex = animalSex;
        this.compundName = compundName;
        this.startFeedingTime = startFeedingTime;
        this.foodName = foodName;
        this.endFeedingTime = endFeedingTime;
    }
    
    public FeedingInfo(int ID){
        
        this.ID = ID;
        
    }
    
    public int getID() {
        return ID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalBithDay() {
        return animalBirthday;
    }

    public void setAnimalBithDay(String animalBithDay) {
        this.animalBirthday = animalBithDay;
    }

    public String getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(String animalSex) {
        this.animalSex = animalSex;
    }

    public String getCompundName() {
        return compundName;
    }

    public void setCompundName(String compundName) {
        this.compundName = compundName;
    }

    public Date getStartFeedingTime() {
        return startFeedingTime;
    }

    public void setStartFeedingTime(Date startFeedingTime) {
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
