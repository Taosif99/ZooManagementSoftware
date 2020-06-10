package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import java.sql.Date;

/**
 * @(#) GuestModeManager.java
 */
public class GuestModeManager {

    private ConnectionHandler connectionHandler;

    public GuestModeManager(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public FeedingInfo getAnimalFeedingInfo(String animalName) {
        return null;
    }

    public FeedingInfo getAnimalFeedingInfo(Date feedingTime) {
        return null;
    }

    public FeedingInfo getAnimalFeedingInfo(Date feedingTime, String animalName) {
        return null;
    }

}
