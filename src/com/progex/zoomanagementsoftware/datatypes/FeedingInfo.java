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
	
	private String compoundName;
	
	private String startFeedingTime; //WAHRSCHEINLICH IST HIER SQL TIMESTAMP ANGEBRACHT
	
	private String foodName;
	
	private String endFeedingTime;

    
    
    
    public FeedingInfo(String compoundName,String startFeedingTime, String endFeedingTime, String foodName) {
   
        
        this.compoundName = compoundName;
        this.startFeedingTime = startFeedingTime;
        this.foodName = foodName;
        this.endFeedingTime = endFeedingTime;
    }
    
    public FeedingInfo(String animal,String compoundName, String foodName) {
   
        this.animalName =animal;
        this.compoundName = compoundName;
        this.foodName = foodName;
        
    }
    
    public FeedingInfo(String compoundName, String foodName) {
   
        this.compoundName = compoundName;
        this.foodName = foodName;
        
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
        return compoundName;
    }

    public void setCompundName(String compundName) {
        this.compoundName = compundName;
    }

    public String getStartFeedingTime() {
        return startFeedingTime;
    }

    public void setStartFeedingTime(String startFeedingTime) {
        this.startFeedingTime = startFeedingTime;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getEndFeedingTime() {
        return endFeedingTime;
    }

    public void setEndFeedingTime(String endFeedingTime) {
        this.endFeedingTime = endFeedingTime;
    }

}
