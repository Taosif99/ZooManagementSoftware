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
 * Class is used to manage all related functions regarding the user. Beneath the
 * functionalites are the Login/Logout, Show all feeding times information, show
 * next feeding time information, update the lastlogdate of a user. Moreover
 * this manager class provides functions to add, delete update from the DB and
 * for getting users of the DB.
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    private ZooManager zooManager;

    private Thread updateLastLogThread;

    /**
     * Creates an UserManager with corresponding reference to connection and
     * main interface.
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

    public ArrayList<String> loadCountryCodes() {

        ArrayList<String> countryCodes = new ArrayList<>();

        String query = "SELECT code FROM Country ORDER BY code";

        ResultSet resultSet = connectionHandler.performQuery(query);

        try {
            String countryCode;
            while (resultSet.next()) {
                countryCode = resultSet.getString("code");
                countryCodes.add(countryCode);
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in loadCountryCodes()");
            System.out.print(sqlException.getMessage());
        }
        return countryCodes;
    }

    /**
     * Method which access the users which are stored in the database.
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
     * Method which has been implemented to create a user data structure from a
     * result set which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all users depending on the result set
     */
    private LinkedList<User> createUsers(ResultSet resultSet) {

        LinkedList<User> users = new LinkedList<>();
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
                int countryID = resultSet.getInt("CountryID");
                Timestamp lastLogDate = resultSet.getTimestamp("LastLogDate");
                String hashedPassword = resultSet.getString("hashedPassword");

                Address address = new Address(id, street, countryID, zip, city);
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

    /**
     * Method to add an user in the database.
     *
     * @param shift
     * @param user
     * @param userType
     * @return True if operation was successful, else false
     */
    public boolean addUser(User user, String shift, String userType) {

        String zip = user.getAddress().getZip();
        String street = user.getAddress().getStreet();
        String city = user.getAddress().getCity();
        int countryId = user.getAddress().getCountryID();
        int addressId = searchAddressId(zip, street, city, countryId);

        boolean retVal;

        MD5Hash hasher = new MD5Hash();

        String hashedPassword = hasher.hashString(user.getHashedPassword());
        if (addressId == -1) {
            retVal = addAddress(zip, city, countryId, street);
            addressId = searchAddressId(zip, street, city, countryId);
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
     * This method is used to get the country code.
     *
     * @param countryId
     * @return Country code or null if it doesnt exist
     */
    public String getCountryCode(int countryId) {

        String query = "SELECT code FROM country WHERE id = " + countryId;
        System.out.println(query);

        ResultSet resultSet = connectionHandler.performQuery(query);
        try {
            resultSet.next();
            String countryCode = resultSet.getString("Code");
            return countryCode;
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in getCountryCode()");
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    /**
     * This method is used to return the id of a country code.
     *
     * @param countryCode
     * @return Country id or 0 if it does not exist
     */
    public int getCountryId(String countryCode) {

        String query = "SELECT id FROM country WHERE code = '" + countryCode + "'";
        System.out.println(query);

        ResultSet resultSet = connectionHandler.performQuery(query);
        int countryId;
        try {
            resultSet.next();
            countryId = resultSet.getInt("ID");
            return countryId;
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in getCountryId()");
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    /**
     * Method to add an address in the database.
     *
     * @param zip
     * @param city
     * @param countryId
     * @param street
     * @return True if operation was successful, else false
     */
    public boolean addAddress(String zip, String city, int countryId, String street) {

        String insertAddressQuery = "INSERT INTO Address (Zip, Street, CountryId, City)"
                + "VALUES ('" + zip + "','" + street + "'," + countryId + ",'" + city + "')";
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
     * @param countryId
     * @return The addressId if its found, else -1
     */
    public int searchAddressId(String zip, String street, String city, int countryId) {

        int addressId = -1; //-1 as initial error value

        String addressQuery = "SELECT ID FROM Address "
                + "WHERE Zip = '" + zip + "'"
                + " AND Street = '" + street + "'"
                + " AND City = '" + city + "'"
                + " AND CountryId = " + countryId;

        ResultSet addressResultSet = connectionHandler.performQuery(addressQuery);
        if (addressResultSet == null) {
            return addressId;
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
     * @return True if operation is sucessful, else false
     */
    public boolean updateUser(int id, User user, String shift, String userType, boolean changePassword) {

        MD5Hash hasher = new MD5Hash();
        String hashedPassword = hasher.hashString(user.getHashedPassword());

        String zip = user.getAddress().getZip();
        String street = user.getAddress().getStreet();
        String city = user.getAddress().getCity();
        int countryId = user.getAddress().getCountryID();

        int addressId = searchAddressId(zip, street, city, countryId);
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
            retVal = addAddress(zip, city, countryId, user.getAddress().getStreet());
            addressId = searchAddressId(zip, street, city, countryId);
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
     * @return True if operation is successful, else false
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
                + "CountryID,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
        String query = zooManager.generateSearchQuery(columnValueMap, begin, "LastLogDate DESC LIMIT " + limit);

        // query = query + " ORDER BY LastLogDate DESC LIMIT " + limit;
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
                + "CountryID,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
        String query = zooManager.generateSearchQuery(columnValueMap, begin, "User.ID");

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
     * @return True if it exists, else false
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
                    try {
                        updateLastLogDateFromUser();
                        Thread.sleep(30000);
                    } catch (InterruptedException ex) {

                        System.err.println("Thread Interuppted - InterruptException in startUpdateThread()");
                        System.out.println(ex.getMessage());
                        Thread.currentThread().interrupt(); // restore interrupted status
                    }
                }
            }
        });
        updateLastLogThread.start();
    }

    /**
     * Updates the lastlogdate from the logged in user.
     */
    public void updateLastLogDateFromUser() {

        // set query        
        String query = "UPDATE user "
                + "SET LastLogDate = current_timestamp() WHERE username = \"" + loggedInUser.getUsername() + "\"";

        // perform query
        connectionHandler.manipulateDB(query);
    }

    /**
     * Logout the user and resets the user, also updates the lastlogdate when
     * logging out.
     */
    public void logout() {
        
        updateLastLogDateFromUser();
        updateLastLogThread.interrupt();
        System.out.println("THREAD STOPPED");
        loggedInUser = null;
        connectionHandler.disconnect(); //Disconnect after logout
    }

    /**
     * Get NextFeedingInfo Object to display a zookeepers next feeding time.
     *
     * @return ZookeeperInfo that shows all important information for the next
     * feeding info for the zookeeper
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
                    + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and CONVERT(Fütterungszeit, date) = current_date() and diffMin > 0 "
                    + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin "
                    + "LIMIT 2";

            ResultSet resultSet = connectionHandler.performQuery(query);

            ZookeeperInfo zookeeperInfo = null;

            // set variables from resultset
            if (resultSet.next()) {

                String animalName = resultSet.getString(2);
                String food = resultSet.getString(3);
                double amount = Double.parseDouble(resultSet.getString(4));
                String storageRoomNumber = resultSet.getString(5);
                String compound = resultSet.getString(6);
                Timestamp feedingTimeInMinutes = resultSet.getTimestamp(1);
                zookeeperInfo = new ZookeeperInfo(feedingTimeInMinutes, compound, animalName, food, storageRoomNumber, amount);
            }

            if (zookeeperInfo != null && resultSet.next()) {
                if (checkIfSameTime(resultSet)) {
                    zookeeperInfo.setIsMultipleFeeding(true);
                } else {
                    zookeeperInfo.setIsMultipleFeeding(false);
                }
            }

            // create FeedingInfo based on Database Information and return it
            return zookeeperInfo;
        } catch (SQLException ex) {
            System.err.println("SQL Exception in getNextFeedingInfo()");
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /**
     * Method compares the time of the two first rows and checks if they are
     * identical.
     *
     * @param multipleFeedingTimeResultSet
     * @return A boolean that indicates the result of this method. The result
     * indicates wether the ResultSet contains multiple feeding (true) or not
     * (false) - depending on this the result is returned.
     */
    public boolean checkIfSameTime(ResultSet multipleFeedingTimeResultSet) {

        try {
            multipleFeedingTimeResultSet.first();
            if (multipleFeedingTimeResultSet.next()) {
                multipleFeedingTimeResultSet.beforeFirst();
                multipleFeedingTimeResultSet.next();
                ResultSet temp = multipleFeedingTimeResultSet;
                String time1 = temp.getString("InMinuten");

                temp.last();
                String time2 = temp.getString("InMinuten");

                return time1.equals(time2);
            }
            return false;
        } catch (SQLException ex) {
            System.err.println("SQL Exception in checkIfSameTime()");
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * This Methods returns a resultset of all Feeding Information for a user
     * -> amount is in Kilogram, resultset is later used to populate the jtable.
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
     * -> amount is in gram resultset is later used to populate the jtable.
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
     * @return The next feeding time in minutes
     */
    public String getNextFeedingInfoInProperFormat() {

        Methods methods = new Methods();

        String unformattedTime = getNextFeedingInfo().getFeedingTime().toString();
        String formattedTime = methods.cutTimeNextFeeding(unformattedTime);

        return formattedTime;
    }
}