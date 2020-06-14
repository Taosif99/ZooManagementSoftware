package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setConnectionHandler(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }
    

       /**
     * Method which access the users which are stored in the database
     *
     * @return A LinkedList of User objects
     */
    public LinkedList<User> getUsers(){
    
    
        String query =  "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n" +
                        "PhoneNumber,Birthday,Email,Zip,Street,City,\n" +
                        "Country,LastLogDate,HashedPassword\n" +
                        "FROM User\n" +
                        "INNER JOIN Address ON User.AddressID = Address.ID";
    
        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<User> users = createUsers(resultSet);
        
        return users;
    }
    
        /**
     * Method which has been implemented to create a user datastructure from
     * a resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all users depending on the result set
     */
    private LinkedList<User> createUsers(ResultSet resultSet){
        
        LinkedList<User> users = new LinkedList<User>();
        Methods methods = new Methods();
        
        try{
        
            while(resultSet.next()){
            
            
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
            
            Address address = new Address(id,street,country,zip,city);
            Salutation salutation = methods.stringToSalutation(salutationStr);
            Shift shift = methods.stringToShift(shiftStr);
            
            //Creating a user depending of the type
            switch(type){
            
                case "Admin":
                    Admin admin = new Admin(username,firstname,lastname, email, phoneNumber,id, salutation,birthday,hashedPassword, address, lastLogDate);
                    users.add(admin);
                    break;
                case "Zookeeper":
           
                   Zookeeper zookeeper = new Zookeeper(null,shift,username,firstname,lastname, email, phoneNumber,id, salutation,birthday,hashedPassword, address, lastLogDate);
                   users.add(zookeeper);
                    
                    break;
            }    
            }
        
        }catch (SQLException e) {
            System.err.println("SQL exception");
            System.out.println(e.getMessage());

        }
        return users;
    }
    
    //TODO MAKE SMALLER METHOD !!1
    
    public boolean addUser(String salutation,String firstname,
            String lastname,String street,String zip,String city,
            String Country,String phoneNumber,String birthday,String shift,
            String username,String email,String password){
    
    
        //TODO METHOD TO CHECK IF USER ALREADY EXISTS
        
        
        //Get the address with street,zip,city --> I guess country not requird
        String addressQuery = "SELECT ID FROM Address \n" +
                              "WHERE Zip = '"+zip +"'" +
                              " AND Street = '" + street + " " +
                              " AND City = '" + city + "'";
        
        ResultSet addressResultSet = connectionHandler.performQuery(addressQuery);
        if (addressResultSet == null) return false;
        
        
        return false;
    }
    
    
    
    
    
    //////////////////////////////////////////////////
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

}