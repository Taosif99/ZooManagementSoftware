package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.*;
import com.progex.zoomanagementsoftware.hashing.MD5Hash;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    private ZooManager zooManager; //Knows the reference to its owner, probably todo: rethink structcure

    /*Removed loggedInUser TODO DIAGRAM*/
    public UserManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.loggedInUser = null;
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //TODO Überlegen ob es Sinn macht addressen auch hier zu verwalten,wäre
    //praktisch machbar...
    /**
     * Method which access the users which are stored in the database
     *
     * @return A LinkedList of User objects
     */
    public LinkedList<User> getUsers() {

        String query = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<User> users = createUsers(resultSet);

        return users;
    }

    /**
     * Method which has been implemented to create a user datastructure from a
     * resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all users depending on the result set
     */
    private LinkedList<User> createUsers(ResultSet resultSet) {

        LinkedList<User> users = new LinkedList<User>();
        Methods methods = new Methods();

        try {

            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String type = resultSet.getString("Type");
                String shiftStr = resultSet.getString("Shift");
                String salutationStr = resultSet.getString("Salutation");
                String username = resultSet.getString("UserName");
                String firstname = resultSet.getString("FirstName");
                String lastname = resultSet.getString("LastName");
                String phoneNumber = resultSet.getString("PhoneNumber");
                Date birthday = resultSet.getDate("Birthday");
                String email = resultSet.getString("Email");
                String zip = resultSet.getString("Zip");
                String street = resultSet.getString("Street");
                String city = resultSet.getString("City");
                String country = resultSet.getString("Country");
                Timestamp lastLogDate = resultSet.getTimestamp("LastLogDate");
                String hashedPassword = resultSet.getString("hashedPassword");

                Address address = new Address(id, street, country, zip, city);
                Salutation salutation = methods.stringToSalutation(salutationStr);
                Shift shift = methods.stringToShift(shiftStr);

                //Creating a user depending of the type
                switch (type) {

                    case "Admin":
                        Admin admin = new Admin(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
                        users.add(admin);
                        break;
                    case "Zookeeper":

                        Zookeeper zookeeper = new Zookeeper(null, shift, username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
                        users.add(zookeeper);

                        break;
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL exception");
            System.out.println(e.getMessage());

        }
        return users;
    }

    //TODO MAKE SMALLER METHOD (one which takes a user as parameter for example)!!!
    /**
     * Method to add an user in the database.
     *
     * @param type
     * @param salutation
     * @param firstname
     * @param lastname
     * @param street
     * @param zip
     * @param city
     * @param country
     * @param phoneNumber
     * @param birthday
     * @param shift
     * @param username
     * @param email
     * @param password
     * @return true if operation was successful, else false
     */
    public boolean addUser(String type, String salutation, String firstname,
            String lastname, String street, String zip, String city,
            String country, String phoneNumber, String birthday, String shift,
            String username, String email, String password) {

        //boolean retVal = false;
        boolean retVal = addAddress(zip, city, country, street);
        if (retVal) {
            //Get the address with street,zip,city --> I guess country not requird
            int addressId = searchAddressId(zip, street, city);
            if (addressId == -1) {
                return retVal;
            }

            MD5Hash hasher = new MD5Hash();

            String hashedPassword = hasher.hashString(password);
            //Know the user can be added 
            String insertUserQuery = "INSERT INTO User (UserName,FirstName,LastName,PhoneNumber,"
                    + "Birthday,Email,Salutation,HashedPassword,"
                    + "AddressID,Type,Shift,LastLogDate) \n"
                    + "VALUES ('" + username + "',"
                    + "'" + firstname + "',"
                    + "'" + lastname + "',"
                    + "'" + phoneNumber + "',"
                    + "'" + birthday + "',"
                    + "'" + email + "',"
                    + "'" + salutation + "',"
                    + "'" + hashedPassword + "',"
                    + addressId + ","
                    + "'" + type + "',"
                    + "'" + shift + "',"
                    + "'1998-01-01 00:00:00')"; //Using zeros as initial log date -> does not work

            retVal = connectionHandler.manipulateDB(insertUserQuery);

            return retVal;
        } else {
            return retVal;
        }
    }

    private boolean addAddress(String zip, String city, String country, String street) {

        String insertAddressQuery = "INSERT INTO Address (Zip, Street, Country, City)"
                + "VALUES ('" + zip + "','" + street + "','" + country + "','" + city + "')";
        System.out.println(insertAddressQuery);
        return connectionHandler.manipulateDB(insertAddressQuery);
    }

    /**
     * Method which has been implemented to search an addressId depending on the
     * given parameters.
     *
     * @param zip
     * @param street
     * @param city
     * @return the addressId if its found, else -1
     */
    public int searchAddressId(String zip, String street, String city) {

        int addressId = -1; //-1 as initial error value

        String addressQuery = "SELECT ID FROM Address "
                + "WHERE Zip = '" + zip + "'"
                + " AND Street = '" + street + "'"
                + " AND City = '" + city + "'";

        ResultSet addressResultSet = connectionHandler.performQuery(addressQuery);
        if (addressResultSet == null) {
            return addressId; //Message ? 
        }
        try {
            addressResultSet.next();
            addressId = addressResultSet.getInt("ID");
        } catch (SQLException ex) {
            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
            return -1;
        }
        return addressId;
    }

    //TODO COUNTRY WIRD GAR NICHT GEBRAUCHT ???
    /**
     * Method to update an user in the database.
     *
     * @param id
     * @param type
     * @param salutation
     * @param firstname
     * @param lastname
     * @param street
     * @param zip
     * @param city
     * @param country
     * @param phoneNumber
     * @param birthday
     * @param shift
     * @param username
     * @param email
     * @param password
     * @param changePassword
     * @return true if operation is sucessful, else false
     */
    public boolean updateUser(int id, String type, String salutation, String firstname,
            String lastname, String street, String zip, String city,
            String country, String phoneNumber, String birthday, String shift,
            String username, String email, String password, boolean changePassword) {

        MD5Hash hasher = new MD5Hash();
        String hashedPassword = hasher.hashString(password);

        int addressId = searchAddressId(zip, street, city);
        if (addressId != -1) {
            //Check if username changed and if yes, check if new username already used     
            String oldUsername = " ";
            String userNameQuery = "SELECT UserName FROM USER WHERE ID = " + id;
            ResultSet resultSet = connectionHandler.performQuery(userNameQuery);
            if (resultSet != null) {

                try {
                    if (resultSet.next()) {
                        oldUsername = resultSet.getString("UserName");
                    }

                } catch (SQLException ex) {
                    System.err.println("SQL Exception");
                    System.out.println(ex.getMessage());
                }
            }

            if (!oldUsername.equals(username)) {
                if (this.usernameExists(username)) {
                    return false;
                }
            }

            String query;

            query = "UPDATE User\n"
                    + "SET UserName = '" + username + "',\n"
                    + "FirstName = '" + firstname + "',\n"
                    + "LastName = '" + lastname + "',\n"
                    + "PhoneNumber = '" + phoneNumber + "',\n"
                    + "Birthday = '" + birthday + "',\n"
                    + "Email = '" + email + "',\n"
                    + "Salutation= '" + salutation + "',\n"
                    //+ "HashedPassword = '" + hashedPassword + "',\n"
                    + "AddressID = " + addressId + ",\n"
                    + "Type = 'Admin',\n"
                    + "Shift = 'None'\n";
            // + "WHERE ID = " + id;

            if (changePassword) {

                query = query + " ,HashedPassword = '" + hashedPassword + "'\n"
                        + " WHERE ID = " + id;
            } else {
                query = query + " WHERE ID = " + id;
            }

            //DEBUG
            System.out.println(query);
            return connectionHandler.manipulateDB(query);

        }
        return false;
    }

    /**
     * Method which deletes a user from the database.
     *
     * @param id
     * @return true if operation is successful, else false
     */
    public boolean deleteUser(int id) {

        String query = "DELETE FROM User WHERE ID = " + id;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to search for users in the database with limit, ordered by the
     * last log date
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * @param limit An amount of users we want to have
     * @return A LinkedList which contains the searched users
     */
    public LinkedList<User> searchUsers(LinkedHashMap<String, String> columnValueMap, String limit) {

        String begin = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
        String query = zooManager.generateSearchQuery(columnValueMap, begin);

        query = query + " ORDER BY LastLogDate DESC LIMIT " + limit;
        System.out.println(query);

        LinkedList<User> users = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            users = createUsers(resultSet);
        } else {
            return this.getUsers(); //Case if we have no attributes
        }
        return users;
    }

    /**
     * Method to search for users in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * values
     * @return A LinkedList which contains the searched users
     */
    public LinkedList<User> searchUsers(LinkedHashMap<String, String> columnValueMap) {

        String begin = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";;
        String query = zooManager.generateSearchQuery(columnValueMap, begin);

        System.out.println(query);

        LinkedList<User> users = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            users = createUsers(resultSet);
        } else {
            return this.getUsers(); //Case if we have no attributes
        }
        return users;
    }

    /**
     * Method to check if a username already exists in the database.
     *
     * @param username
     * @return true if it exists, else false
     */
    public boolean usernameExists(String username) {

        boolean retVal = false;

        String query = "SELECT UserName FROM User WHERE UserName = '" + username + "'";
        ResultSet resultSet = connectionHandler.performQuery(query);
        try {

            if (resultSet.next()) {
                retVal = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retVal;
    }

    //Khalid start TODO, case if nothing returns
    //
    /**
     * Method returns a user after checking if the given username and hashed
     * password match.
     *
     * @param username
     * @param hashedPassword
     * @return User that has been successfully logged in, else null
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
            if (resultSet.next()) {

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
            System.err.println("SQL EXCEPTION");
            System.out.println(ex.getMessage());
        }

        return null;

    }

    /**
     * Updates the lastlogdate from the logged in user
     *
     *
     */
    public void updateLastLogDateFromUser() {

        // set query        
        String query = "UPDATE user "
                + "SET LastLogDate = current_timestamp() WHERE username = \"" + loggedInUser.getUsername() + "\"";

        // perform query
        connectionHandler.manipulateDB(query);

    }

    /**
     * Logsout the user and resets the user, also updates the lastlogdate when
     * logging out
     *
     *
     */
    public void logout() {

        updateLastLogDateFromUser();
        loggedInUser = null;
    }

    /**
     * TODO RETURN COMMENT WAS FALLS ES WELCHE GIBT DIE ZU GLEICHEN ZEIT HABEN
     * Get NextFeedingInfo Object to display a zookeepers next feeding time
     *
     * @return ZookeeperInfo that shows all important information for the next
     * feeding info for the zookeeper
     *
     */
    public ZookeeperInfo getNextFeedingInfo() {

        try {
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
            if (resultSet.next()) {
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
            ZookeeperInfo zookeeperInfo = new ZookeeperInfo(feedingTimeInMinutes, gehege, tiername, futter, abstellRaum, menge);
            return zookeeperInfo;
        } catch (SQLException ex) {
            System.err.println("SQL EXCEPTION");
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Kilogramm, resultset is later used to populate the jtable
     *
     * @return ResultSet witth allfeedingtimes to populate the resultset in
     * another method
     */
    public ResultSet getAllFeedingTimeInKG() {

//        String query = "SELECT Tier,Futter,MengeKG,Abstellraumnummer,Gehege,Uhrzeit,\n" +
//"case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\"\n" +
//"FROM \n" +
//"	(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit \n" +
//"	FROM eats \n" +
//"		INNER JOIN food ON eats.FoodID = food.ID \n" +
//"        INNER JOIN animal ON eats.AnimalID = animal.ID \n" +
//"        INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID \n" +
//"        INNER JOIN user ON takescare.UserID = user.ID \n" +
//"        INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable \n" +
//"	WHERE joinedTable.UserName = \"schäfernooa\" and joinedTable.FütterungsZeit > current_date() \n" +
//"    ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";


        String query = 
                
                "SELECT Uhrzeit, case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\", Tier,Futter,MengeKG as \"Menge in Kilogramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \""+loggedInUser.getUsername()+"\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";
        
        
        return connectionHandler.performQuery(query);

    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Gramm resultset is later used to populate the jtable
     *
     * @return ResultSet witth allfeedingtimes to populate the resultset in
     * another method
     */
    public ResultSet getAllFeedingTimeInGramm() {

//        String query = "SELECT CONVERT(Fütterungszeit, time) as Uhrzeit,Tier,Futter,MengeGramm,Abstellraumnummer,Gehege FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGramm, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
//                + "FROM eats "
//                + "INNER JOIN "
//                + "food "
//                + "ON eats.FoodID = food.ID "
//                + "INNER JOIN "
//                + "animal "
//                + "ON eats.AnimalID = animal.ID "
//                + "INNER JOIN "
//                + "takescare "
//                + "ON eats.AnimalID = takescare.AnimalID "
//                + "INNER JOIN "
//                + "user "
//                + "ON takescare.UserID = user.ID "
//                + "INNER JOIN "
//                + "compound "
//                + "ON animal.CompoundID = compound.ID) "
//                + "AS joinedTable WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and joinedTable.FütterungsZeit > current_date() "
//                + "ORDER BY fütterungszeit desc";

        

        String query = 
                "SELECT Uhrzeit,case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\",Tier,Futter,MengeGR as \"Menge in Gramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGR, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \""+loggedInUser.getUsername()+"\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";
        
        
        return connectionHandler.performQuery(query);

    }

    /**
     * Return minutes until next feeding time for zookeeper
     *
     * @return the next feeding time in minutes
     */
    public int getNextFeedingInfoInMinutes() {

        if (getNextFeedingInfo().getFeedingTime() >= 0) {
            return getNextFeedingInfo().getFeedingTime();
        } else {
            return -1;

        }

    }

    //Khalid end
}
