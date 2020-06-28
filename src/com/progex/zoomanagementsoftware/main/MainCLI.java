 
package com.progex.zoomanagementsoftware.main;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 *
 * @author TODO
 */
public class MainCLI { //Main command line interface

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Here everything begins !");
      
        String url ="jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";
        //Testing GSON API to get network parameters from file
        
         Path fileName = Path.of("NetworkParameters.json");
         
 
        try {
               
               String jsonString = Files.readString(fileName);
               System.out.println(jsonString);
               JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
            
     
               url = jsonObject.getAsJsonObject("parameters").get("url").getAsString();
               username = jsonObject.getAsJsonObject("parameters").get("username").getAsString();
               password = jsonObject.getAsJsonObject("parameters").get("password").getAsString();
               dbName = jsonObject.getAsJsonObject("parameters").get("dbName").getAsString();
               
            
               System.out.println("Using following parameters:");
               System.out.println("url: " + url + " username: " + username + 
                       " password: " + password + " dbname " + dbName);
               
        } catch (IOException ex) {
            
            
            System.out.println("Using hardcoded standard instead of json file...");
            
        }
          
         ConnectionHandler connectionHandler = new ConnectionHandler(url,dbName,username,password);
    } 
}
