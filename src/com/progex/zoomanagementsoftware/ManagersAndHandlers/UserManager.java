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
                    String hashedPassword = resultSetAdmin.getString("HashedPassword");
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

                    Admin tempAdmin = new Admin(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, (java.sql.Date) lastLogDate);
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
}
