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
    /*If User choose a animal, this is the function for the table(compound,start/end feedingtime, food*/
    public LinkedList<FeedingInfo> getAnimalFeedingInfo(String animal) throws ParseException {
        
        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "Select compound.name as Gehege ,eats.StartFeedingTime, eats.EndFeedingTime,food.name as Essen " +
        "FROM animal,eats,food,compound " +
        "WHERE eats.AnimalID = animal.ID AND animal.animalname = '"+ animal + "'AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID Order by StartFeedingTime ASC";
        ResultSet resultFeeding = connectionHandler.performQuery(query);
        
        if(resultFeeding != null){
            
            try{
                while(resultFeeding.next()){
                    
                    
                    //Date von Datenbank in String umwandeln
                    //Date erstellen mit Spalte startfeedingtime von Datenbank
                    java.util.Date datestart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("StartFeedingTime"));
                    //in Timestamp umwandeln
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(datestart.getTime());
                   
                    //als String um Datum zu vergleichen
                    String times = timestampstart.toString();
                    String tmp = times.substring(0, 10);
                    //Datum von heute in compStamp bzw tmpTwo speichern
                    System.out.println(tmp);
                    java.sql.Timestamp compStamp = new java.sql.Timestamp(System.currentTimeMillis());
                    String tmpTwo = compStamp.toString().substring(0, 10);
                    
                    //wenn Datum gleich heute dann erst adden
                    if(tmpTwo.equals(tmp)){
                    
                    
                        String timeStart = times.substring(11, 16);
                    
                    
                        String com = resultFeeding.getString("Gehege");
                        System.out.println(com);
                    
                    
                        java.util.Date dateend = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("EndFeedingTime"));
                        java.sql.Timestamp timestampend = new java.sql.Timestamp(dateend.getTime());
                        String timee = timestampend.toString();
                        String timeEnd = timee.substring(11, 16);
                    
                        String food = resultFeeding.getString("Essen");
                        System.out.println(food);
                        FeedingInfo newFeedingInfo = new FeedingInfo(com,timeStart,timeEnd,food);
                        feedingInfos.add(newFeedingInfo);
                    }    
                }
                
                
            }catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        
        return feedingInfos;
        
       
    }
    /*get all available animals*/
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
    /*get all available feedingtimes*/
    public LinkedList<String> getTimes() throws ParseException{
        LinkedList<String> times = new LinkedList<String>();
        String query = "Select distinct startFeedingTime from eats order by startFeedingTime ASC";
        ResultSet resultTimes = connectionHandler.performQuery(query);
        
        //java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-05-18 16:29:31");
        
        

        
        if(resultTimes != null){
            
            try{
                while(resultTimes.next()){
                    
                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultTimes.getString("startFeedingTime"));
                    //in Timestamp umwandeln
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(date.getTime());
                   
                    //als String um Datum zu vergleichen
                    String time = timestampstart.toString();
                    String tmp = time.substring(0, 10);
                    //Datum von heute in compStamp bzw tmpTwo speichern
                    System.out.println(tmp);
                    java.sql.Timestamp compStamp = new java.sql.Timestamp(System.currentTimeMillis());
                    String tmpTwo = compStamp.toString().substring(0, 10);
                    
                    if(tmpTwo.equals(tmp)){
                        String timeStart = time.substring(11, 16);
                        times.add(timeStart);
                    
                    }
                    
                }
            }catch(SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }    
        }
       return times; 
        
        
    }
        
/*If User choose a time, this is the function for the table(animalName,compund and food*/
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
    
    /*If User choose a animal and time, this is the function for the labels food and compound*/
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
