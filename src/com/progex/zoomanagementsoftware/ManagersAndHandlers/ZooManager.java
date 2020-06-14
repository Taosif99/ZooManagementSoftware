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


/**
 *
 * @author Ouchen
 */
public class ZooManager {


    private UserManager userManager;
    private GuestModeManager guestModeManager;
    private ConnectionHandler connectionHandler;
        
    /**
     * Method to initalize our ZooManagement Interface,
     * requires the MySql database information for initalizing connection
     * 
     * @param url
     * @param username
     * @param password
     * @param dbName 
     */
    public ZooManager(String url,String dbName,String username,String password) {
    
        /*
         String url ="jdbc:mysql://localhost/";
         String username = "root";
         String password = "0000";
         String dbName = "zoo";
         
         */
        connectionHandler = new ConnectionHandler(url,dbName,username,password);
         
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
    public LinkedList<Compound> getCompounds(){
    
     
     
        LinkedList<Compound> compounds = new LinkedList<Compound>();
        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);
    
      
        if (resultSet != null){
        
        /*TODO CALCULATE CURRENT CAPPACITY,currently set to 0*/
            
            try {
                while (resultSet.next()) {
                
                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    double area = resultSet.getDouble("Area");
                    int year = resultSet.getInt("ConstructionYear");
                    int maxCapacity = resultSet.getInt("MaxCapacity");
                   
                    
                    Compound newCompound = new Compound(ID, area, new Date(year,0,0),maxCapacity,0, name);
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        
        }
        
        return compounds;
    }
    
}
