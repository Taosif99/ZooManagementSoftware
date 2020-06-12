package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import java.sql.Date;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @(#) GuestModeManager.java
 */
public class GuestModeManager {

    private ConnectionHandler connectionHandler;

    public GuestModeManager(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public LinkedList<FeedingInfo> getAnimalFeedingInfo() {
        
        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "SELECT animal.ID FROM animal";
        ResultSet resultSet = connectionHandler.performQuery(query);
        
        if(resultSet != null){
            
            try{
                while(resultSet.next()){
                    
                    int ID = resultSet.getInt("ID");
                    
                    FeedingInfo newFeedingInfo = new FeedingInfo(ID);
                    feedingInfos.add(newFeedingInfo);
                }
                
                
            }catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        
        return feedingInfos;
        
       
    }
        

    public FeedingInfo getAnimalFeedingInfo(Date feedingTime) {
        return null;
    }

    public FeedingInfo getAnimalFeedingInfo(Date feedingTime, String animalName) {
        return null;
    }

}
