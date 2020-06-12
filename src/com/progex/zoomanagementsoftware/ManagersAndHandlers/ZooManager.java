/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;

/**
 *
 * @author Ouchen
 */
public class ZooManager {

    private UserManager userManager;
    private GuestModeManager guestModeManager;
    private ConnectionHandler connectionHandler;

    /**
     * Method to initalize our ZooManagement Interface, requires the MySql
     * database information for initalizing connection
     *
     * @param url
     * @param username
     * @param password
     * @param dbName
     */
    public ZooManager(String url, String dbName, String username, String password) {

        /*
         String url ="jdbc:mysql://localhost/";
         String username = "root";
         String password = "0000";
         String dbName = "zoo";
         
         */
        connectionHandler = new ConnectionHandler(url, dbName, username, password);

        userManager = new UserManager(connectionHandler);
        guestModeManager = new GuestModeManager(connectionHandler);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public GuestModeManager getGuestModeManager() {
        return guestModeManager;
    }

    /*Methods concerning Compound*/
    /**
     *
     * @return A LinkedList of of Compound objects
     */
    public LinkedList<Compound> getCompounds() {

        LinkedList<Compound> compounds = new LinkedList<Compound>();
        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);

        if (resultSet != null) {

            /*TODO CALCULATE CURRENT CAPPACITY,currently set to 0*/
            try {
                while (resultSet.next()) {

                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    double area = resultSet.getDouble("Area");
                    int year = resultSet.getInt("ConstructionYear");
                    int maxCapacity = resultSet.getInt("MaxCapacity");

                    Compound newCompound = new Compound(ID, area, new Date(year, 0, 0), maxCapacity, 0, name);
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }

        }

        return compounds;
    }

    public boolean checkFoodExists(String name) throws SQLException {
        
        String query = "SELECT name FROM food WHERE name LIKE \"" + name + "\";";
        System.out.println(query);
        ResultSet resultSet = connectionHandler.performQuery(query);
      
        if (resultSet != null){
            resultSet.next();
            System.out.println(resultSet.getString("Name") + "<tempname");
            return true;
        }else     
            return false;
    }

    public boolean addFood(int storageRoomNumber, double stock, String name) {
        
        String query = "INSERT INTO Food(StorageRoomNumber,Stock,Name) VALUES(" + storageRoomNumber + "," + stock + ",\"" + name + "\");";
        //String query = "INSERT INTO food(StorageRoomNumber,Stock,Name) VALUES(1,1,\"Test99\");";
        System.out.println(query);
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }
    
    public boolean updateFood(int storageRoomNumber, double stock, String name, int id){
        
        String query = "UPDATE food SET storageRoomNumber = " + storageRoomNumber + ", stock = " + stock + 
                ", name = \"" + name + "\" WHERE id = " + id;
        
        System.out.println(query);
        
        boolean retVal = connectionHandler.manipulateDB(query);
     
        return retVal;
    }
    
    public boolean deleteFood(int id){
        
        String query = "DELETE FROM food WHERE id = " + id + ";";
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }
            

}
