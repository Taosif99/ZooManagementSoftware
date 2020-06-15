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

    public void setConnectionHandler(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
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
                Date lastLogDate = resultSet.getDate("LastLogDate");
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
     * @param Country
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
            String Country, String phoneNumber, String birthday, String shift,
            String username, String email, String password) {

     
        boolean retVal = false;
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
     * @return true if operation is sucessful, else false
     */
    public boolean updateUser(int id, String type, String salutation, String firstname,
            String lastname, String street, String zip, String city,
            String country, String phoneNumber, String birthday, String shift,
            String username, String email, String password) {

        MD5Hash hasher = new MD5Hash();
        String hashedPassword = hasher.hashString(password);

        int addressId = searchAddressId(zip, street, city);
        if (addressId != -1) {

            String query = "UPDATE User\n"
                    + "SET UserName = '" + username + "',\n"
                    + "FirstName = '" + firstname + "',\n"
                    + "LastName = '" + lastname + "',\n"
                    + "PhoneNumber = '" + phoneNumber + "',\n"
                    + "Birthday = '" + birthday + "',\n"
                    + "Email = '" + email + "',\n"
                    + "Salutation= '" + salutation + "',\n"
                    + "HashedPassword = '" + hashedPassword + "',\n"
                    + "AddressID = " + addressId + ",\n"
                    + "Type = 'Admin',\n"
                    + "Shift = 'None'\n"
                    + "WHERE ID = " + id;

            //DEBUG
            //System.out.println(query);
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

        String query = "SELECT UserName FROM User WHERE UserName = '" + username +"'";
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

    //////////////////////////////////////////////////
    public void addAdmin(Admin admin) {

    }

    public void addZookeeper(Zookeeper zookeeper) {

    }

    public void performQuery(String query, String message) {

    }

    public boolean loginAdmin(String userName, String password) {
        return false;
    }

    public boolean loginZookeeper(String userName, String password) {
        return false;
    }

    public void logout() {

    }

    public ZookeeperInfo createZookeeperInfo() {
        return null;
    }

}
