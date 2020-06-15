package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;
    //private ZooManager zooManager;
    private ConnectionHandler connectionHandler;

    /*Removed loggedInUser TODO DIAGRAM*/
    public UserManager(ConnectionHandler connectionHandler) {
        this.loggedInUser = null;
        this.connectionHandler = connectionHandler;
        
    }

    public UserManager(String url, String dbName, String username, String password) {

        //loggedUser ????
        connectionHandler = new ConnectionHandler(url, dbName, username, password);
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

    public void logout() {

    }

    public ZookeeperInfo createZookeeperInfo() {
        return null;
    }
    
    /**
     * This method is implemented for AdminHomepage. It will be removed
     * @param limit
     * @return 
     */
    public LinkedList<Admin> getAdmins(int limit) {

        LinkedList<Admin> admins = new LinkedList<Admin>();
        String adminQuery = "SELECT * FROM user WHERE Type = 'Admin' ORDER BY lastLogDate DESC LIMIT " + limit;
        System.out.println(adminQuery);
        ResultSet resultSetAdmin = connectionHandler.performQuery(adminQuery);
        Salutation salutation;

        if (resultSetAdmin != null) {
            try {
                while (resultSetAdmin.next()) {
                    int id = resultSetAdmin.getInt("ID");
                    String username = resultSetAdmin.getString("Username");
                    String firstname = resultSetAdmin.getString("FirstName");
                    String lastname = resultSetAdmin.getString("LastName");
                    String phoneNumber = resultSetAdmin.getString("PhoneNumber");
                    java.sql.Date birthday = resultSetAdmin.getDate("Birthday");
                    String email = resultSetAdmin.getString("Email");
                    String tempSalutation = resultSetAdmin.getString("Salutation");
                    //String hashedPassword = resultSetAdmin.getString("HashedPassword");
                    int addressId = resultSetAdmin.getInt("AddressId");
                    Date lastLogDate = resultSetAdmin.getDate("LastLogDate");

                    String addressQuery = "SELECT * FROM address WHERE id = " + addressId;
                    ResultSet resultSetAddress = connectionHandler.performQuery(addressQuery);
                    resultSetAddress.next();
                    String zip = resultSetAddress.getString("Zip");
                    String street = resultSetAddress.getString("Street");
                    String country = resultSetAddress.getString("Country");
                    String city = resultSetAddress.getString("City");
                    Address address = new Address(addressId, zip, street, country, city);

                    System.out.println(tempSalutation);
                    if (tempSalutation.equals("Herr")) {
                        salutation = Salutation.mr;
                    } else if (tempSalutation.equals("Frau")) {
                        salutation = Salutation.mrs;
                    } else {
                        salutation = Salutation.diverse;
                    }

                    Admin tempAdmin = new Admin(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, null, address, (java.sql.Date) lastLogDate);
                    admins.add(tempAdmin);
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return admins;
    }

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
                        Admin admin = new Admin(username, firstname, lastname, email, phoneNumber, id, salutation, (java.sql.Date) birthday, hashedPassword, address,(java.sql.Date) lastLogDate);
                        users.add(admin);
                        break;
                    case "Zookeeper":

                        Zookeeper zookeeper = new Zookeeper(null, shift, username, firstname, lastname, email, phoneNumber, id, salutation,(java.sql.Date) birthday, hashedPassword, address, (java.sql.Date)lastLogDate);
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
        String query = generateSearchQuery(columnValueMap, begin);

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
            ex.printStackTrace();
        }
        
        return retVal;
    }


       /**
     * https://www.geeksforgeeks.org/mysql-regular-expressions-regexp/ zum
     * Nachgucken Method which constructs a search query using the parameters
     * and regular expressions.
     *
     * @param columnValueMap
     * @param queryBegin
     * @return The query as String, null if no String can be built
     */
    public String generateSearchQuery(LinkedHashMap<String, String> columnValueMap, String queryBegin) {

        LinkedHashMap<String, String> nonEmptyColumnValueMap = new LinkedHashMap<String, String>();

        try {

            //Remove empty or null textFields
            for (Map.Entry<String, String> entry : columnValueMap.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                if (!value.isEmpty()) {
                    //textFieldMap.remove(key);
                    nonEmptyColumnValueMap.put(key, value);
                }
            }

            StringBuilder querySb = new StringBuilder();
            querySb.append(queryBegin).append(" ");
            Set<Map.Entry<String, String>> entries = nonEmptyColumnValueMap.entrySet();

            //get the iterator for entries
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();

            //Adding first entry
            Map.Entry<String, String> firstEntry = iterator.next();

            String columnName = firstEntry.getKey();
            String value = firstEntry.getValue();
            querySb.append(columnName).append(" REGEXP '").append(value).append("'");

            //Removing first entry
            nonEmptyColumnValueMap.remove(columnName);

            for (Map.Entry<String, String> entry : nonEmptyColumnValueMap.entrySet()) {

                columnName = entry.getKey();
                value = entry.getValue();
                querySb.append(" AND ").append(columnName).append(" REGEXP '").append(value).append("'");
            }

            System.out.println(querySb.toString());
            return querySb.toString();

        } catch (NoSuchElementException noSuchElementException) {

            System.err.println("LinkHashMap value empty or null");
            System.out.println(noSuchElementException.getMessage());
            return null;
        }
    }
}
