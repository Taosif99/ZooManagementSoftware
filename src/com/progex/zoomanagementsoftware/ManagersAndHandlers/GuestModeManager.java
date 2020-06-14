package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import java.sql.Date;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @(#) GuestModeManager.java
 */
public class GuestModeManager {

    private ConnectionHandler connectionHandler;

    public GuestModeManager(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
        
    }

    public LinkedList<FeedingInfo> getAnimalFeedingInfo(String animal) throws ParseException {
        
        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "Select compound.name as Gehege ,eats.StartFeedingTime, eats.EndFeedingTime,food.name as Essen " +
        "FROM animal,eats,food,compound " +
        "WHERE eats.AnimalID = animal.ID AND animal.animalname = '"+ animal + "'AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID Order by StartFeedingTime ASC";
        ResultSet resultFeeding = connectionHandler.performQuery(query);
        
        if(resultFeeding != null){
            
            try{
                while(resultFeeding.next()){
                    
                    String com = resultFeeding.getString("Gehege");
                    System.out.println(com);
                    
                    java.util.Date datestart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("StartFeedingTime"));
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(datestart.getTime());
                    String times = timestampstart.toString();
                    String timeStart = times.substring(11, 16);
                    
                    java.util.Date dateend = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("EndFeedingTime"));
                    java.sql.Timestamp timestampend = new java.sql.Timestamp(dateend.getTime());
                    String timee = timestampend.toString();
                    String timeEnd = timee.substring(11, 16);
                    
                    String food = resultFeeding.getString("Essen");
                    System.out.println(food);
                    FeedingInfo newFeedingInfo = new FeedingInfo(com,timeStart,timeEnd,food);
                    feedingInfos.add(newFeedingInfo);
                }
                
                
            }catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        
        return feedingInfos;
        
       
    }
    
    public LinkedList<String> getAnimals() {
        
        LinkedList<String> animals = new LinkedList<String>();
        String query = "Select Distinct animalName from animal";
        ResultSet resultAnimals = connectionHandler.performQuery(query);
        
        if(resultAnimals != null){
            
            try{
                while(resultAnimals.next()){
                    String animalName = resultAnimals.getString("animalName");
                    animals.add(animalName);
                    
                }
            }catch(SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }    
        }
        return animals;
        
    }
    
    public LinkedList<String> getTimes() throws ParseException{
        LinkedList<String> times = new LinkedList<String>();
        String query = "Select distinct startFeedingTime from eats order by startFeedingTime ASC";
        ResultSet resultTimes = connectionHandler.performQuery(query);
        
        //java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-05-18 16:29:31");

        
        if(resultTimes != null){
            
            try{
                while(resultTimes.next()){
                    
                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultTimes.getString("startFeedingTime"));
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
                    String time = timestamp.toString();
                    String timeOnly = time.substring(11, 16);
                    
                    times.add(timeOnly);
                    
                 
                    
                }
            }catch(SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }    
        }
       return times; 
        
        
    }
        
//casten geht net
    public LinkedList<FeedingInfo> getTimeFeedingInfo(String feedingTime) {
        
       
       LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        System.out.println(feedingTime);
       String query = "Select distinct animalName, compound.name as gehege,food.name as essen From animal,compound,food,eats WHERE eats.AnimalID = animal.ID AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID AND eats.StartFeedingTime = '" + feedingTime + "'";//TODO
       ResultSet resultFeeding = connectionHandler.performQuery(query);  
       
            if(resultFeeding != null){
         try{
                while(resultFeeding.next()){
                    
                    String animal = resultFeeding.getString("animalName"); 
                    System.out.println(animal);
                    
                    String com = resultFeeding.getString("gehege");
                    System.out.println(com);
                    
                    
                    String food = resultFeeding.getString("essen");
                    System.out.println(food);
                    FeedingInfo newFeedingInfo = new FeedingInfo(animal,com,food);
                    feedingInfos.add(newFeedingInfo);
                }
                
                
            }catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        
        return feedingInfos;
    }    
    public LinkedList<FeedingInfo> getAnimalTimeFeedingInfo(String feedingTime, String animalName) {
        
        
     
        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "Select distinct compound.name as gehege,food.name as essen FROM compound,food,eats,animal WHERE eats.AnimalID = animal.ID AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID AND eats.StartFeedingTime = '" + feedingTime + " 'AND AnimalName = '"+animalName+"'";
        ResultSet resultFeeding = connectionHandler.performQuery(query);  
       
            if(resultFeeding != null){
         try{
                while(resultFeeding.next()){
                    
                    
                    String com = resultFeeding.getString("gehege");
                    System.out.println(com);
                    
                    
                    String food = resultFeeding.getString("essen");
                    System.out.println(food);
                    FeedingInfo newFeedingInfo = new FeedingInfo(com,food);
                    System.out.println(newFeedingInfo.getCompundName());
                    feedingInfos.add(newFeedingInfo);
                }
                
                
            }catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        
        return feedingInfos;
    }
    
    
    
  

}
