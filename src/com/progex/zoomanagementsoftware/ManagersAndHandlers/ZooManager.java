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
import java.time.LocalDate;


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
     * Method which access the compounds which are stored in the database
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
                   
                    //Know get the current cappacity of an compound
                    String compoundID = Integer.toString(ID);
                    String queryToGetCurrentCapacity = "SELECT COUNT(CompoundID) as CurrentCapacity FROM Animal WHERE CompoundID = " + compoundID;
                    
                    
                    ResultSet currentCapacityResult = connectionHandler.performQuery(queryToGetCurrentCapacity);
                    currentCapacityResult.next();
                    int currentCapacity = currentCapacityResult.getInt("CurrentCapacity"); 
                    //System.out.println("Gehegename:" + name + "ConstrYear" + year);
                    
                 
                    
                    Compound newCompound = new Compound(ID, area,year,maxCapacity,currentCapacity, name);
             
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
              
            }
        
        }
        
        return compounds;
    }
    
    /**
     * Method to add a compound to the database
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successfull, else false
     */
    public boolean addCompound(String name,double area, int constructionYear,int maxCapacity){
    
        
        String query = "INSERT INTO Compound(Name,Area,ConstructionYear,MaxCapacity) VALUES('"+name+"',"+area+","+constructionYear+","+maxCapacity+")";
       
        //String query = "INSERT INTO Compound(Name,Area,ConstructionYear,MaxCapacity) VALUES('Eisbärengehege',500,2002,23);";
        boolean retVal = connectionHandler.manipulateDB(query);
     
        /*
        if (retVal){
        System.out.println("Einfügen erfolgreich") ;
        }else System.out.println("Einfügen misslungen");
        */
     return retVal;
    }
    
    /**
     * Method to update the values of a compund
     * @param ID
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successful, else false
     */
    public boolean updateCompound(int ID,String name,double area, int constructionYear,int maxCapacity){
    
        
        
        
        StringBuilder querySB = new StringBuilder();
        querySB.append("UPDATE Compound")
                .append(" SET Name = ").append("'").append(name).append("',")
                .append("Area = ").append(area).append(", ")
                .append("ConstructionYear = ").append(constructionYear).append(", ")
                .append("MaxCapacity = ").append(maxCapacity)
                .append(" WHERE ID = ").append(ID);
        
      
        String query = querySB.toString();
        System.out.println(query);
        
        boolean retVal = connectionHandler.manipulateDB(query);
        
        
        return retVal;
    }
    
    /**
     * Method to delete a compound from the database
     * @param ID
     * @return true if successful,else false
     */
    public boolean deleteCompound(int ID){
    
      String query = "DELETE FROM Compound WHERE ID = " + ID;
    
    
      boolean retVal = connectionHandler.manipulateDB(query);
    
      return retVal;
    }
    
    
    
    /**
     * TODO
     * @return 
     */
    public LinkedList<Compound> searchCompounds(){
    
     LinkedList<Compound> compounds = new LinkedList<Compound>();
    
    
    
    
    return null;
    }
    
    
}
