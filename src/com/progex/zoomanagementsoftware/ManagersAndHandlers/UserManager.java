package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.Date;
import java.util.LinkedList;

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

    public UserManager(String url, String dbName, String username, String password) {
        
       //loggedUser ????
        connectionHandler = new ConnectionHandler(url,dbName,username,password);
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

    public LinkedList<Admin> getAdmins(int limit) {

        LinkedList<Admin> admins = new LinkedList<Admin>();
        String query = "SELECT * FROM user WHERE Type LIKE (\"Admin\") ORDER BY lastLogDate DESC LIMIT " + limit + ";";
        ResultSet resultSet = connectionHandler.performQuery(query);
        Salutation salutation;
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("Username");
                String firstname = resultSet.getString("UserName");
                String lastname = resultSet.getString("LastName");
                String phoneNumber = resultSet.getString("PhoneNumber");
                java.sql.Date birthday = resultSet.getDate("Birthday");
                String email = resultSet.getString("Email");
                String tempSalutation = resultSet.getString("Salutation");
                String hashedPassword = resultSet.getString("HashedPassword");
                int addressId = resultSet.getInt("AddressId");
                Date lastLogDate = resultSet.getDate("LastLogDate");

                query = "SELECT * FROM address WHERE id = " + addressId + ";";
                resultSet = connectionHandler.performQuery(query);
                
                String zip = resultSet.getString("Zip");
                String street = resultSet.getString("Street");
                String country = resultSet.getString("Country");
                String city = resultSet.getString("City");            
                Address address = new Address(addressId, zip, street, country, city);
                           
                if(tempSalutation == "Herr")
                    salutation = Salutation.mr;
               
                else if(tempSalutation == "Frau")
                    salutation = Salutation.mrs;
                else
                    salutation = Salutation.diverse;
                            
                Admin tempAdmin = new Admin(username, firstname, lastname, email, phoneNumber, id,salutation, birthday, hashedPassword, address, (java.sql.Date) lastLogDate);
                admins.add(tempAdmin);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception");
            System.out.println(e.getMessage());
        }
        return admins;
    }
}
