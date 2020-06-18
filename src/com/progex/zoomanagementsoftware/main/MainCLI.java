 
package com.progex.zoomanagementsoftware.main;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;


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
        
        /*Testing a sql statement on the console*/
        
         String url ="jdbc:mysql://localhost/";
         String username = "root";
         String password = "0000";
         String dbName = "zoo";
        
        ConnectionHandler connectionHandler = new ConnectionHandler(url,dbName,username,password);
        connectionHandler.test();
    
    
    }
    
}
