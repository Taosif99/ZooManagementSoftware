/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.*;
import java.security.Timestamp;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author Ouchen
 */
public class ZooManager {

    private UserManager userManager;
    private GuestModeManager guestModeManager;
    private ConnectionHandler connectionHandler;
    
    // Save username to work with it
    private String username = "";

    /**
     * Method to initalize our ZooManagement Interface, requires the MySql
     * database information for initalizing connection
     *
     * @param url
     * @param username
     * @param password
     * @param dbName
     */
    public ZooManager(String url, String dbName, String username, String password) {

        connectionHandler = new ConnectionHandler(url, dbName, username, password);

        userManager = new UserManager(connectionHandler);
        guestModeManager = new GuestModeManager(connectionHandler);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public GuestModeManager getGuestModeManager() {
        return guestModeManager;
    }

    /*Methods concerning Compound*/
    /**
     *
     * @return A LinkedList of of Compound objects
     */
    public LinkedList<Compound> getCompounds() {

        LinkedList<Compound> compounds = new LinkedList<Compound>();
        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);

        if (resultSet != null) {

            /*TODO CALCULATE CURRENT CAPPACITY,currently set to 0*/
            try {
                while (resultSet.next()) {

                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    double area = resultSet.getDouble("Area");
                    int year = resultSet.getInt("ConstructionYear");
                    int maxCapacity = resultSet.getInt("MaxCapacity");

                    Compound newCompound = new Compound(ID, area, new Date(year, 0, 0), maxCapacity, 0, name);
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }

        }

        return compounds;
    }

    // Get the firstname of the logged in user
    public String getNameOfUser() throws SQLException {

        // Set query
        String query = "SELECT firstname FROM USER WHERE username = \"" + this.username + "\"";

        // perform query to get first name of user
        ResultSet resultSet = connectionHandler.performQuery(query);
        String firstName = "";
        while (resultSet.next()) {
            firstName = resultSet.getString(1);
        }

        // return first name of user
        return firstName;

    }

    
    // Get NextFeedingInfo Object to display a zookeepers next feeding time
    public FeedingInfo getNextFeedingInfo() throws SQLException, ParseException {

        // set query
        String query = "SELECT Fütterungszeit,Tier,Futter,MengeInKG,Abstellraumnummer,Gehege,diff_min "
                + "FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeInKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName as UserName, timestampdiff(MINUTE,current_timestamp(),eats.StartFeedingTime) as diff_min "
                + "FROM eats "
                + "INNER JOIN "
                + "food "
                + "ON eats.FoodID = food.ID "
                + "INNER JOIN "
                + "animal "
                + "ON eats.AnimalID = animal.ID "
                + "INNER JOIN "
                + "takescare "
                + "ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN "
                + "user "
                + "ON takescare.UserID = user.ID "
                + "INNER JOIN "
                + "compound "
                + "ON compound.ID = animal.CompoundID) AS joinedTable "
                + "WHERE joinedTable.UserName = \"" + username + "\""
                + "ORDER BY joinedTable.Fütterungszeit DESC "
                + "LIMIT 1";

        
        ResultSet resultSet = connectionHandler.performQuery(query);

        // init variables to catch from resultset
        String tiername = "";
        String futter = "";
        double menge = 0;
        String abstellRaum = "";
        String gehege = "";
        String nextFeedingTime = "";
        int feedingTimeInMinutes = -1;

        // set variables from resultset
        while (resultSet.next()) {
            tiername = resultSet.getString(2);
            futter = resultSet.getString(3);
            menge = Double.parseDouble(resultSet.getString(4));
            abstellRaum = resultSet.getString(5);
            gehege = resultSet.getString(6);
            feedingTimeInMinutes = resultSet.getInt(7);

        }

        // create FeedingInfo based on Database Information and return it
        FeedingInfo x = new FeedingInfo(tiername, gehege, null,feedingTimeInMinutes, futter, null, abstellRaum, menge);
        return x;

    }

    
    // This methods updates the lastlogdate from a user
    public void updateLastLogDateFromUser() throws SQLException {

        // set query        
        String query = "UPDATE user "
                + "SET LastLogDate = current_timestamp() WHERE username = \"" + this.username + "\"";

        // perform query
        connectionHandler.manipulateDB(query);

    }

    
    // This method returns the lastlogdate from a user
    public String getLastLoginDateFromUser() throws SQLException {
        // set query        
        String query = "SELECT LastLogDate FROM USER WHERE username = \"" + this.username + "\"";

        // perform query
        ResultSet resultSet = connectionHandler.performQuery(query);
        String lastLogDate = "";
        while (resultSet.next()) {
            lastLogDate = resultSet.getString(1);
        }

        // return lastLogDate
        System.out.println("LAST LOG DATE:" + lastLogDate);
        return lastLogDate;

    }

    
    // This Methods returns a resultset of all Feeding Informations for a user -> amount is in Kilogramm
    // resultset is later used to populate the jtable
    public ResultSet getAllFeedingTimeInKG() {

        String query = "SELECT Fütterungszeit,Tier,Futter,MengeInKG,Abstellraumnummer,Gehege FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeInKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
                + "FROM eats "
                + "INNER JOIN "
                + "food "
                + "ON eats.FoodID = food.ID "
                + "INNER JOIN "
                + "animal "
                + "ON eats.AnimalID = animal.ID "
                + "INNER JOIN "
                + "takescare "
                + "ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN "
                + "user "
                + "ON takescare.UserID = user.ID "
                + "INNER JOIN "
                + "compound "
                + "ON animal.CompoundID = compound.ID) "
                + "AS joinedTable WHERE joinedTable.UserName = \"" + username + "\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY fütterungszeit desc";

        return connectionHandler.performQuery(query);

    }

    
    // This Methods returns a resultset of all Feeding Informations for a user -> amount is in Gramm
    // resultset is later used to populate the jtable
    public ResultSet getAllFeedingTimeInGramm() {

        String query = "SELECT Fütterungszeit,Tier,Futter,MengeInGramm,Abstellraumnummer,Gehege FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeInGramm, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
                + "FROM eats "
                + "INNER JOIN "
                + "food "
                + "ON eats.FoodID = food.ID "
                + "INNER JOIN "
                + "animal "
                + "ON eats.AnimalID = animal.ID "
                + "INNER JOIN "
                + "takescare "
                + "ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN "
                + "user "
                + "ON takescare.UserID = user.ID "
                + "INNER JOIN "
                + "compound "
                + "ON animal.CompoundID = compound.ID) "
                + "AS joinedTable WHERE joinedTable.UserName = \"" + username + "\" "
                + "ORDER BY fütterungszeit desc";

        return connectionHandler.performQuery(query);

    }

    
    // this method is used to verify if a user has permission to access ZookeeperHomePage
    public String isUserAccepted(String username, String password) throws SQLException {

        // set query
        String query = "SELECT username, HashedPassword, Type FROM USER WHERE username = \"" + username + "\"";
        // perform query
        ResultSet resultSet = connectionHandler.performQuery(query);

        // set variable to catch result from query
        String usernameInDB = "";
        String hashedPwInDB = "";
        String userType = "";

        // catch results from query and save in variables
        while (resultSet.next()) {
            usernameInDB = resultSet.getString(1);
            hashedPwInDB = resultSet.getString(2);
            userType = resultSet.getString(3);

        }

        // check if data matches with data in database and return certain result for each usertype
        if (username.equals(usernameInDB) && password.equals(hashedPwInDB) && userType.equals("Admin")) {
            System.out.println("ACCEPTED - ADMIN");
            this.username = username;
            return "ADMIN";

        } else if (username.equals(usernameInDB) && password.equals(hashedPwInDB) && userType.equals("Zookeeper")) {
            System.out.println("ACCEPTED - ZOOKEEPER");
            this.username = username;
            return "ZOOKEEPER";
        } else {
            return "ERROR";
        }
    }

}
