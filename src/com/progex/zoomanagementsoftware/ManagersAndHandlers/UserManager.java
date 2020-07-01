package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.progex.zoomanagementsoftware.datatypes.*;
import com.progex.zoomanagementsoftware.hashing.MD5Hash;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * Class is used to manage all related functions regarding the user. Beneath the
 * functionalites are the Login/Logout, Show all feeding times information, show
 * next feeding time information, update the lastlogdate of a user. Moreover
 * this manager class provides functions to add, delete update from the DB and
 * for getting users of the DB.
 *
 *
 *
 *
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    private ZooManager zooManager; //Knows the reference to its owner, probably todo: rethink structcure

    private Thread updateLastLogThread;

    /**
     * Creates an UserManager manager with corresponding reference to connection
     * and main interface.
     *
     * @param connectionHandler
     * @param zooManager
     */
    public UserManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.loggedInUser = null;
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
        this.updateLastLogThread = null;
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

                        Zookeeper zookeeper = new Zookeeper(shift, username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
                        users.add(zookeeper);

                        break;
                }
            }

        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in createUsers()");
            System.out.print(sqlException.getMessage());
        }
        return users;
    }

    //TODO MAKE SMALLER METHOD (one which takes a user as parameter for example)!!!
    /**
     * Method to add an user in the database.
     *
     * @param shift
     * @param user
     * @param userType
     * @return true if operation was successful, else false
     */
    public boolean addUser(User user, String shift, String userType) {
        //Get the address with street,zip,city --> I guess country not requird
        int addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());

        boolean retVal;

        MD5Hash hasher = new MD5Hash();

        String hashedPassword = hasher.hashString(user.getHashedPassword());
        if (addressId == -1) {
            retVal = addAddress(user.getAddress().getZip(), user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getStreet());
            addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());
            //Falls die Adresse nicht eingefügt werden konnte
            if (retVal == false) {
                return retVal;
            }
        }
        Methods methods = new Methods();
        String salutation = methods.salutationToString(user.getSalutation());
        //Know the user can be added 
        String insertUserQuery = "INSERT INTO User (UserName,FirstName,LastName,PhoneNumber,"
                + "Birthday,Email,Salutation,HashedPassword,"
                + "AddressID,Type,Shift,LastLogDate)\n"
                + "VALUES ('" + user.getUsername() + "',"
                + "'" + user.getFirstname() + "',"
                + "'" + user.getLastname() + "',"
                + "'" + user.getPhoneNumber() + "',"
                + "'" + user.getBirthday().toString() + "',"
                + "'" + user.getEmail() + "',"
                + "'" + salutation + "',"
                + "'" + hashedPassword + "',"
                + addressId + ","
                + "'" + userType + "',"
                + "'" + shift + "',"
                + "'1998-01-01 00:00:00')"; //Using zeros as initial log date 

        retVal = connectionHandler.manipulateDB(insertUserQuery);
        return retVal;
    }

    /**
     * Method to add an address in the database.
     *
     * @param zip
     * @param city
     * @param country
     * @param street
     * @return true if operation was successful, else false
     */
    public boolean addAddress(String zip, String city, String country, String street) {

        String insertAddressQuery = "INSERT INTO Address (Zip, Street, Country, City)"
                + "VALUES ('" + zip + "','" + street + "','" + country + "','" + city + "')";
        System.out.println(insertAddressQuery);
        boolean retVal = connectionHandler.manipulateDB(insertAddressQuery);
        return retVal;
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
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in searchAddressId()");
            System.out.println(sqlException.getMessage());
            return -1;
        }
        return addressId;
    }


    /**
     * Method to update an user in the database.
     *
     * @param id
     * @param changePassword
     * @param shift
     * @param user
     * @param userType
     * @return true if operation is sucessful, else false
     */
    public boolean updateUser(int id, User user, String shift, String userType, boolean changePassword) {

        MD5Hash hasher = new MD5Hash();
        String hashedPassword = hasher.hashString(user.getHashedPassword());

        int addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());
        //Check if username changed and if yes, check if new username already used     
        String oldUsername = " ";
        String userNameQuery = "SELECT UserName FROM USER WHERE ID = " + id;
        ResultSet resultSet = connectionHandler.performQuery(userNameQuery);
        boolean retVal;

        if (resultSet != null) {

            try {
                if (resultSet.next()) {
                    oldUsername = resultSet.getString("UserName");
                }

            } catch (SQLException sqlException) {
                System.err.println("SQL Exception in updateUser()");
                System.out.println(sqlException.getMessage());
            }
        }

        if (!oldUsername.equals(user.getUsername())) {
            if (this.usernameExists(user.getUsername())) {
                return false;
            }
        }

        if (addressId == -1) {
            retVal = addAddress(user.getAddress().getZip(), user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getStreet());
            addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());
            if (retVal == false) {
                return retVal;
            }
        }

        Methods methods = new Methods();
        String salutation = methods.salutationToString(user.getSalutation());

        String query = "UPDATE User\n"
                + "SET UserName = '" + user.getUsername() + "',\n"
                + "FirstName = '" + user.getFirstname() + "',\n"
                + "LastName = '" + user.getLastname() + "',\n"
                + "PhoneNumber = '" + user.getPhoneNumber() + "',\n"
                + "Birthday = '" + user.getBirthday().toString() + "',\n"
                + "Email = '" + user.getEmail() + "',\n"
                + "Salutation = '" + salutation + "',\n"
                //+ "HashedPassword = '" + hashedPassword + "',\n"
                + "AddressID = " + addressId + ",\n";

        if (userType.equals("Admin")) {
            query = query
                    + "Type = 'Admin',\n"
                    + "Shift = 'None'\n";
        } else {

            query = query
                    + "Type = 'Zookeeper',\n"
                    + "Shift = '" + shift + "'\n";
        }

        if (changePassword) {

            query = query + " ,HashedPassword = '" + hashedPassword + "'\n"
                    + " WHERE ID = " + id;
        } else {
            query = query + " WHERE ID = " + id;
        }

        System.out.println(query);
        return connectionHandler.manipulateDB(query);
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
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
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

        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in usernameExists()");
            System.out.println(sqlException.getMessage());
        }

        return retVal;
    }

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

            connectionHandler.connect();
         
            //Set query
            String query = "SELECT username, firstname, user.Type, lastlogdate,hashedPassword FROM USER WHERE username = ? ";
            
            
            //Get connection
            Connection connection = connectionHandler.getConnection();
            
            //Use prepared statement to avoid a possible sql injection attack 
            PreparedStatement login = connection.prepareStatement(query);
            login.setString(1, username);
            ResultSet resultSet = login.executeQuery();
            
            
            
            // set variable to catch result from query
            String firstName = "";
            String userName = "";
            Timestamp lastLogDate = null;
            String type = "";
            String hashedPass = "";

            // catch results from query and save in variables
            if (resultSet.next()) {

                userName = resultSet.getString(1);
                firstName = resultSet.getString(2);
                type = resultSet.getString(3);
                lastLogDate = resultSet.getTimestamp(4);
                hashedPass = resultSet.getString(5);

                if (userName.equals(username) && hashedPass.equals(hashedPassword)) {

                    if (type.equals("Admin")) {
                        Admin admin = new Admin(userName, firstName, lastLogDate);

                        startUpdateThread();

                        return admin;
                    }
                    if (type.equals("Zookeeper")) {
                        Zookeeper zookeeper = new Zookeeper(userName, firstName, lastLogDate);

                        startUpdateThread();
                        return zookeeper;
                    }

                }

            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in login()");
            System.out.print(sqlException.getMessage());
        }

        connectionHandler.disconnect(); //Disconnect if it was not successfull
        return null;

    }

    //Start a thread that keeps updating the lastlogdate every 30 seconds.
    private void startUpdateThread() {

        updateLastLogThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true && loggedInUser != null) {
                    System.out.println("THREAD COUNT: " + java.lang.Thread.activeCount());

                    try {
                        updateLastLogDateFromUser();
                        Thread.sleep(30000);

                        System.out.println("" + loggedInUser.getUsername());
                        System.out.println("UPDATE LASTLOGDATE SUCCESSFULLY");
                        System.out.println(Thread.currentThread().getId());
                    } catch (InterruptedException ex) {
                        System.err.println("Thread Interuppted - InterruptException in method startUpdateThread()");
                        System.out.println(ex.getMessage());
                        Thread.currentThread().interrupt(); // restore interrupted status
                    }
                }

            }
        });

        updateLastLogThread.start();

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
     * logging out.
     *
     *
     */
    public void logout() {
        updateLastLogDateFromUser();
        updateLastLogThread.interrupt();
        System.out.println("THREAD STOPPED");
        loggedInUser = null;
        connectionHandler.disconnect(); //Disconnect after logout
    }

    /**
     * TODO RETURN COMMENT WAS FALLS ES WELCHE GIBT DIE ZU GLEICHEN ZEIT HABEN
     * Get NextFeedingInfo Object to display a zookeepers next feeding time.
     *
     * @return ZookeeperInfo that shows all important information for the next
     * feeding info for the zookeeper.
     *
     */
    public ZookeeperInfo getNextFeedingInfo() {

        try {
            // set query
            String query
                    = "SELECT case when diffMin<0 then 'Abgelaufen' else diffMin end as InMinuten,Tier,Futter,MengeGR as MengeinGramm,Abstellraumnummer,Gehege  "
                    + "FROM "
                    + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGR, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                    + "FROM eats "
                    + "INNER JOIN food ON eats.FoodID = food.ID "
                    + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                    + "INNER JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                    + "INNER JOIN user ON takescare.UserID = user.ID "
                    + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                    + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and CONVERT(Fütterungszeit, date) = current_date() "
                    + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin "
                    + "LIMIT 2";

            ResultSet resultSet = connectionHandler.performQuery(query);

            // init variables to catch from resultset
            ArrayList<ZookeeperInfo> zookeeperInfolist = new ArrayList<>();
            String animalName = "";
            String food = "";
            double amount = 0;
            String storageRoom = "";
            String compound = "";
            Timestamp feedingTimeInMinutes = null;
            ZookeeperInfo zookeeperInfo = null;

            // set variables from resultset
            if (resultSet.next()) {
                animalName = resultSet.getString(2);
                food = resultSet.getString(3);
                amount = Double.parseDouble(resultSet.getString(4));
                storageRoom = resultSet.getString(5);
                compound = resultSet.getString(6);
                feedingTimeInMinutes = resultSet.getTimestamp(1);
                zookeeperInfo = new ZookeeperInfo(feedingTimeInMinutes, compound, animalName, food, storageRoom, amount);
                zookeeperInfolist.add(zookeeperInfo);

            }

            for (int i = 0; i < zookeeperInfolist.size(); i++) {
                System.out.println("TIME:" + zookeeperInfolist.get(i).getFeedingTime());
            }

            if (zookeeperInfo != null && resultSet.next()) {
                if (checkIfSameTime(resultSet)) {
                    zookeeperInfo.setIsMultipleFeeding(true);
                } else {
                    zookeeperInfo.setIsMultipleFeeding(false);
                }
            }
            System.out.println("COUNT" + checkIfSameTime(resultSet));

            // create FeedingInfo based on Database Information and return it
            return zookeeperInfo;
        } catch (SQLException ex) {
            System.err.println("SQL Exception in method getNextFeedingInfo() ");
            System.out.println(ex.getMessage());
     
        }

        return null;
    }

    /**
     * Method compares the time of the two first rows and checks if they are
     * identical.
     *
     * @param rs1
     * @return a boolean that indicates the result of this method. The result
     * indicates wether the ResultSet contains multiple feeding (true) or not
     * (false) - depending on this the result is returned.
     */
    public boolean checkIfSameTime(ResultSet rs1) {


        try {
            rs1.first();
            if (rs1.next()) {
                rs1.beforeFirst();
                rs1.next();
                ResultSet temp = rs1;

                System.out.println("-----");
                System.out.println("Compare:");
                System.out.println("Row" + temp.getRow() + ": " + temp.getString("InMinuten"));
                String timee1 = temp.getString("InMinuten");

                System.out.println("With");
                temp.last();
                System.out.println("Row" + temp.getRow() + ": " + temp.getString("InMinuten"));
                System.out.println("-----");
                String timee2 = temp.getString("InMinuten");

                if (timee1.equals(timee2)) {
                    System.out.println("IS SAME");
                    return true;
                    //return true;
                } else {
                    System.out.println("NOT SAME");
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            System.err.println("SQL Error in method checkIfSameTime()");
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Kilogramm, resultset is later used to populate the jtable
     *
     * @return ResultSet witth allfeedingtimes to populate the resultset in
     * another method
     */
    public ResultSet getAllFeedingTimeInKG() {

        String query
                = "SELECT Uhrzeit, case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\", Tier,Futter,MengeKG as \"Menge in Kilogramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and CONVERT(Fütterungszeit, date) = current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";

        return connectionHandler.performQuery(query);

    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Gramm resultset is later used to populate the jtable.
     *
     * @return ResultSet with allfeedingtimes to populate the resultset in
     * another method.
     */
    public ResultSet getAllFeedingTimeInGramm() {

        String query
                = "SELECT Uhrzeit,case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\",Tier,Futter,MengeGR as \"Menge in Gramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGR, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and CONVERT(Fütterungszeit, date) = current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";

        return connectionHandler.performQuery(query);

    }

    /**
     * Return minutes until next feeding time for zookeeper.
     *
     * @return the next feeding time in minutes
     */
    public String getNextFeedingInfoInProperFormat() {

        Methods methods = new Methods();

        String unformattedTime = getNextFeedingInfo().getFeedingTime().toString();

        String formattedTime = methods.cutTimeNextFeeding(unformattedTime);

        return formattedTime;

    }
}
