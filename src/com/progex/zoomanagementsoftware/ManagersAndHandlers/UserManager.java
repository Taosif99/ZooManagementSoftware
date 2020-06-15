package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.datatypes.Address;
import com.progex.zoomanagementsoftware.datatypes.Admin;
import com.progex.zoomanagementsoftware.datatypes.Animal;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import com.progex.zoomanagementsoftware.datatypes.User;
import com.progex.zoomanagementsoftware.datatypes.Zookeeper;
import com.progex.zoomanagementsoftware.datatypes.ZookeeperInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;


/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    /*Removed loggedInUser TODO DIAGRAM*/
    public UserManager(ConnectionHandler connectionHandler) {
        this.loggedInUser = null;
        this.connectionHandler = connectionHandler;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setConnectionHandler(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public void addAdmin(Admin admin) {

    }

    public void addZookeeper(Zookeeper zookeeper) {

    }

    public void deleteUser(int id) {

    }

    public void performQuery(String query, String message) {

    }

    public boolean loginAdmin(String userName, String password) {
        return false;
    }

    public boolean loginZookeeper(String userName, String password) {
        return false;
    }
    /**
     * Method returns a user after checking if the given username and hashed password match.
     * @param username
     * @param hashedPassword
     * @return 
     */
    public User login(String username, String hashedPassword) {

        try {
            // set query
            String query = "SELECT username, firstname, user.Type, lastlogdate FROM USER WHERE username = \"" + username + "\"";
            // perform query
            ResultSet resultSet = connectionHandler.performQuery(query);

            // set variable to catch result from query
            String firstName = "";
            String userName = "";
            Timestamp lastLogDate = null;
            String type = "";

            // catch results from query and save in variables
            while (resultSet.next()) {

                userName = resultSet.getString(1);
                firstName = resultSet.getString(2);
                type = resultSet.getString(3);
                lastLogDate = resultSet.getTimestamp(4);

                if (type.equals("Admin")) {

                    Admin admin = new Admin(userName, firstName, null, null, null, 0, null, null, null, null, lastLogDate);
                    return admin;
                }
                if (type.equals("Zookeeper")) {
                    Zookeeper zookeeper = new Zookeeper(null, null, userName, firstName, null, null, null, 0, null, null, null, null, lastLogDate);

                    System.out.println("--------USERMANAGER-----"
                            + "username" + username
                            + "firstName" + firstName
                            + "" + type
                            + "" + lastLogDate);
                    return zookeeper;

                } else {
                    return null;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    /**
     * Updates the lastlogdate from the logged in user
     * @throws SQLException 
     */
    public void updateLastLogDateFromUser() throws SQLException {

        // set query        
        String query = "UPDATE user "
                + "SET LastLogDate = current_timestamp() WHERE username = \"" + loggedInUser.getUsername() + "\"";

        // perform query
        connectionHandler.manipulateDB(query);

    }

    

    /**
     * Logsout the user and resets the user, also updates the lastlogdate when logging out
     * @throws SQLException 
     */
    public void logout() throws SQLException {
        
        updateLastLogDateFromUser();
        loggedInUser = null;
    }

    public ZookeeperInfo createZookeeperInfo() {
        return null;
    }


    /**
     * Get NextFeedingInfo Object to display a zookeepers next feeding time
     * @return
     * @throws SQLException
     * @throws ParseException 
     */
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
                + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" "
                + "ORDER BY joinedTable.Fütterungszeit DESC "
                + "LIMIT 1";

        ResultSet resultSet = connectionHandler.performQuery(query);

        // init variables to catch from resultset
        String tiername = "";
        String futter = "";
        double menge = 0;
        String abstellRaum = "";
        String gehege = "";
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

        System.out.println("------------DEBUG----------- \n"
                + "Username: " + loggedInUser.getUsername()
                + "Tiername: " + tiername
                + "Futter: " + futter
                + "Menge: " + menge
                + "Abstellraum: " + abstellRaum
                + "Gehege: " + gehege
                + "FeedingTimeInMinutes: " + feedingTimeInMinutes);

        // create FeedingInfo based on Database Information and return it
        FeedingInfo x = new FeedingInfo(tiername, gehege, null, feedingTimeInMinutes, futter, null, abstellRaum, menge);
        return x;

    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user -> amount is in Kilogramm,
     * resultset is later used to populate the jtable
     * @return 
     */
    // This Methods returns a resultset of all Feeding Informations for a user -> amount is in Kilogramm
    // resultset is later used to populate the jtable
    public ResultSet getAllFeedingTimeInKG() {

        String query = "SELECT CONVERT(Fütterungszeit, time) as Uhrzeit,Tier,Futter,MengeKG,Abstellraumnummer,Gehege FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
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
                + "AS joinedTable WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY fütterungszeit desc";

        return connectionHandler.performQuery(query);

    }

    


    /**
     * This Methods returns a resultset of all Feeding Informations for a user -> amount is in Gramm
     * resultset is later used to populate the jtable
     * @return 
     */
    public ResultSet getAllFeedingTimeInGramm() {

        String query = "SELECT CONVERT(Fütterungszeit, time) as Uhrzeit,Tier,Futter,MengeGramm,Abstellraumnummer,Gehege FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGramm, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
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
                + "AS joinedTable WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" "
                + "ORDER BY fütterungszeit desc";

        return connectionHandler.performQuery(query);

    }

    
    /**
     * Return minutes until next feeding time for zookeeper
     * @return 
     */
    public int getNextFeedingInfoInMinutes() {

        try {
            if (getNextFeedingInfo().getNextFeedingInMinutes() >= 0) {
                return getNextFeedingInfo().getNextFeedingInMinutes();
            } else {
                return -1;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

}
