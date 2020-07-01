package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which is used to handle the connection and basic database operations in
 * our database.
 */
public class ConnectionHandler {

    private Connection connection;

    private String url;

    private String dbName;

    private String username;

    private String password;

    /**
     * Create a connection handler with corresponding network parameters.
     *
     * @param url
     * @param dbName
     * @param username
     * @param password
     */
    public ConnectionHandler(String url, String dbName, String username, String password) {
        this.url = url;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
       // connect();
       this.connection = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    
    
    
    
    
    
    //TODO BOOLEAN
    /**
     * Method which will connect to a given database depennding on the
     * attributes of the connection handler.
     *
     * 
     */
   public void connect() {

        try {

            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Successfully connected!");
            //connection = DriverManager.getConnection(url + dbName + "?characterEncoding=latin1", username, password); //Connector 5...
            //connection = DriverManager.getConnection(url +  dbName+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , username, password); //Connector 8...
            //For utf 8 
            connection = DriverManager.getConnection(url + dbName + "?characterEncoding=utf-8", username, password);
            System.out.println("Connected to Database!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("Connection failed");
        }
    }

   
   /**
    * Method which can be used to close the connection when it is not used.
    */
    public void disconnect(){
   
        try {
            connection.close();
            System.out.println("Disconnected from database !");
        } catch (SQLException ex) {
           System.err.println("SQL Exception in disconnect()");
           System.out.println(ex.getMessage());
        }
    
    }
   
    
   
   
   
    public Connection getConnection() {

        return connection;
    }

    /**
     * Method to get the result set of a database querry.
     *
     * @param query
     * @return The result set, null if something goes wrong
     */
    public ResultSet performQuery(String query) {

        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException ex) {

            System.err.println("SQL Exception in performQuery()");
            System.out.println(ex.getMessage());

        }

        return resultSet;
    }

    /**
     * Method to fulfill insert,update and delete operations.
     *
     * @param query
     * @return true if manipulation successful, else false
     */
    public boolean manipulateDB(String query) {

        Statement statement;
        try {
            statement = connection.createStatement();
            if ((statement.executeUpdate(query)) == 1) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("SQL Exception in manipulateDB()");
            System.out.println(ex.getMessage());
        }

        return false;
    }
}