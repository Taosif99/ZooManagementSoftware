/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.ManagersAndHandlers;
import com.mysql.jdbc.ResultSetMetaData;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.SwingConstants;


/**
 *
 * @author Ouchen
 */
public class ZooManager {


    private UserManager userManager;
    private GuestModeManager guestModeManager;
    private ConnectionHandler connectionHandler;
    private String username = "";
        
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
    
    public String getNameOfUser() throws SQLException{
        
        
        String query = "SELECT firstname FROM USER WHERE username = \""+this.username+"\"";


        ResultSet resultSet = connectionHandler.performQuery(query);
        String firstName = "";
        while(resultSet.next()){
            firstName = resultSet.getString(1);           
        }        
        return firstName;
        
        
        
    }
    
    
    public FeedingInfo getNextFeedingInfo() throws SQLException, ParseException{
    
     String query = "SELECT * "
             + "FROM (SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeInKG , food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName "
             + "FROM eats "
             + "INNER JOIN "
             + "food "
             + "ON eats.FoodID = food.ID "
             + "INNER JOIN "
             + "animal "
             + "ON eats.AnimalID = animal.ID "
             + "INNER JOIN "
             + "takescare "
             + "ON eats.AnimalID = takescare.AnimalID "
             + "INNER JOIN "
             + "user "
             + "ON takescare.UserID = user.ID "
             + "INNER JOIN "
             + "compound "
             + "ON compound.ID = animal.CompoundID) AS joinedTable "
             + "WHERE joinedTable.UserName = \""+username+"\" AND joinedTable.Fütterungszeit < current_date()"
             + "ORDER BY joinedTable.Fütterungszeit DESC "
             + "LIMIT 1";
     
     ResultSet resultSet = connectionHandler.performQuery(query);
     
     String fütterungsZeitAsString = "";
     String tiername = "";
     String futter = "";
     double menge = 0;
     String abstellRaum = "";
     String gehege = "";
     
     
     
        while(resultSet.next()){
            fütterungsZeitAsString =  resultSet.getString(1);
            tiername =  resultSet.getString(2);
            futter =  resultSet.getString(3);
            menge =  Double.parseDouble(resultSet.getString(4));
            abstellRaum =  resultSet.getString(5);
            gehege =  resultSet.getString(6);
        } 
        
        System.out.println("FROM DATABASE: "
                + "fütterungszeit: "+fütterungsZeitAsString
                + " tiername: "+tiername
                + " futter: "+futter
                + " abstellraum: "+abstellRaum
                + " menge: "+menge
                + " gehege: "+gehege);
        
//        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.GERMANY);
//        Date fütteungsZeit = (Date) format.parse(fütterungsZeitAsString); 2020-05-05 21:32:12
            SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss.SSS");  
            Date date1=(Date) formatter6.parse(fütterungsZeitAsString);  
    
    
        if(tiername.equals("")){
            return null;
        }
        else{
            
        FeedingInfo x = new FeedingInfo(tiername, gehege, date1, futter,null,abstellRaum,menge);
        return x;            
            
        }




    }
    
    public String getLastLoginDateFromUser() throws SQLException{
        
        
        String query = "SELECT LastLogDate FROM USER WHERE username = \""+this.username+"\"";


        ResultSet resultSet = connectionHandler.performQuery(query);
        String lastLogDate = "";
        while(resultSet.next()){
            lastLogDate =  resultSet.getString(1);           
        }        
        return lastLogDate;        
        
        
    }
    
    
    
    
    public String isUserAccepted(String username, String password) throws SQLException{
        
        
        String query = "SELECT username, HashedPassword, Type FROM USER WHERE username = \""+username+"\"";
        ResultSet resultSet = connectionHandler.performQuery(query);
        
        String usernameInDB = "";
        String hashedPwInDB = "";
        String userType = "";
        while(resultSet.next()){
            usernameInDB = resultSet.getString(1);
            hashedPwInDB = resultSet.getString(2); 
            userType = resultSet.getString(3);
           
        }
        System.out.println("FOUND IN DATABASE "+usernameInDB+" "+hashedPwInDB);
        System.out.println(":");
        System.out.println("Typed username : "+username);
        System.out.println("Datab username : "+usernameInDB);
        System.out.println("Typed passwort : "+password);
        System.out.println("Datab passwort : "+hashedPwInDB);
        System.out.println("Datab Type :"+userType);
        
        
        
        if(username.equals(usernameInDB) && password.equals(hashedPwInDB) && userType.equals("Admin")){
            System.out.println("ACCEPTED - ADMIN");
            this.username = username;
            return "ADMIN";
            
        }
        else if(username.equals(usernameInDB) && password.equals(hashedPwInDB) && userType.equals("Zookeeper")){
            System.out.println("ACCEPTED - ZOOKEEPER");
            this.username = username;            
            return "ZOOKEEPER";        
        }
        else{
            return "ERROR";
        }
        }


    

    
    
}
