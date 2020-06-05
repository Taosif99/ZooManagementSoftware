package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.SQLException;
/**
 * @(#) ConnectionHandler.java
 */

public class ConnectionHandler
{
	private Connection connection;
	
	private String url; 
	
	private String dbName; 
	
	private String username; 
	
	private String password; 
	
	public ConnectionHandler( String url, String dbName, String username, String password )
	{
		this.url = url;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
                connect();
        }
	
	
	/**
         * Method which will connect to a given database depennding on the attributes of
         * the connection handler.
         * @return The connection to the database
         */
	private void connect( )
	{
	  
       try {
           //con = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root","0000");
            Class.forName("com.mysql.jdbc.Driver"); 
            System.out.println("Successfully connected !");
            //Bei mir klappt nur das, probiert mal beide versionen
            connection = DriverManager.getConnection(url+dbName+ "?characterEncoding=latin1", username, password);
           //connection = DriverManager.getConnection(url+dbName, username, password);
       } catch (Exception e) {
           
           
           System.out.println(e.getMessage());
           System.err.println("Connection failed");
       }
       
       
	}
	
	
	/**
	 Simple method to perfrom a querry and print results on the console
	 Method imlemented for debug purposes and will be removed !!!
         * 
         * 
         * Die Manager Klassen werden die connection von dieser Klasse erhalten und
         * je nach dem was gesucht ist passende Objekte erstellen mit code, der wie unten sein
         * kann. Die referenzen zu den Objekten werden der Fenter/Frame Klasse zurückgegeben
         * 
	*/
        public void test(){
		
		
       
       
	   /*For example print all datasets from animal*/
       String query = "SELECT * FROM  animal ";
       Statement statement;
       ResultSet resultSet;
       
       try {
           statement = connection.createStatement();
           resultSet = statement.executeQuery(query);
           
           while(resultSet.next())
           {
               
				
				int animalID = resultSet.getInt("ID");
				int compoundID = resultSet.getInt("CompoundID");
				int speciesID = resultSet.getInt("SpeciesID");
				String animalName = resultSet.getString("AnimalName");
				Date birthday = resultSet.getDate("Birthday");
				String sex = resultSet.getString("Sex");
				/**
                                 * In den Manager klassen kann dann hier ein Objekt (wie eine Liste)
                                 * erstellt werden, die dann zurückgegeben wird
                                 */
                                
				System.out.println("AnimalID: " + animalID +" CompoundID: "+compoundID + " SpeciesID: "+ speciesID+" AnimalName: " + animalName +" Birthday: " + birthday.toString()+ " Sex: " + sex);
				
				
           }
       } catch (SQLException e) {
     
           System.err.println("SQL ERROR");
           System.out.println(e.getMessage());
       }
      
       
    }

    public Connection getConnection() {
        
        return connection;
    }
	
}
