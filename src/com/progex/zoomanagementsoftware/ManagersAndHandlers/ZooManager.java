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

    /*Start compound methods*/
    /**
     * Method which access the compounds which are stored in the database
     *
     * @return A LinkedList of of Compound objects
     */
    public LinkedList<Compound> getCompounds() {

        LinkedList<Compound> compounds = new LinkedList<Compound>();
        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);

        if (resultSet != null) {

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

                    Compound newCompound = new Compound(ID, area, year, maxCapacity, currentCapacity, name);

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
     *
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successfull, else false
     */
    public boolean addCompound(String name, double area, int constructionYear, int maxCapacity) {

        String query = "INSERT INTO Compound(Name,Area,ConstructionYear,MaxCapacity) VALUES('" + name + "'," + area + "," + constructionYear + "," + maxCapacity + ")";

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
     *
     * @param ID
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successful, else false
     */
    public boolean updateCompound(int ID, String name, double area, int constructionYear, int maxCapacity) {

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
     *
     * @param ID
     * @return true if successful,else false
     */
    public boolean deleteCompound(int ID) {

        String query = "DELETE FROM Compound WHERE ID = " + ID;

        boolean retVal = connectionHandler.manipulateDB(query);

        return retVal;
    }

    /**
     * TODO
     *
     * @return
     */
    public LinkedList<Compound> searchCompounds() {

        LinkedList<Compound> compounds = new LinkedList<Compound>();

        return null;
    }

    /*End Compund Methods*/
 /*Methods concerning Managing Animal start here*/
    /**
     * Method to get the required values of the admin view
     * @return 
     */
    public LinkedList<Animal> getAnimals() {

        LinkedList<Animal> animals = new LinkedList<Animal>();

        String query = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName\n"
                + "FROM Animal,Compound,Species\n"
                + "WHERE Animal.CompoundID = Compound.ID AND\n"
                + "Animal.SpeciesID = Species.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        if (resultSet != null) {

            try {
                while (resultSet.next()) {

                    int animalID = resultSet.getInt("ID");
                    String animalName = resultSet.getString("animalName");
                    String sex = resultSet.getString("Sex");
                    Date birthday = resultSet.getDate("Birthday");
                    String descriptionStr = resultSet.getString("Description");
                    String compoundName = resultSet.getString("CompoundName");

                    Methods methods = new Methods();
                    Description description = methods.stringToDescription(descriptionStr);

                    Species species = new Species(-1, null, description);
                    //Creating corresponding object,-1 used as undefined value
                    Compound compound = new Compound(-1, -1, -1, -1, -1, compoundName);
                    Animal animal = new Animal(animalID, animalName, birthday, sex, compound, species, null);

                    animals.add(animal);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());

            }

        }

        return animals;
    }

    /**
     * Method to add an Animal to the database.
     *
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @return true if successfull, else false
     */
    public boolean addAnimal(String animalName, String compoundName, String birthday, String sex, String species) {

        try {
            /*Getting the CompoundID*/
            String compoundIDQuery = "SELECT ID from Compound where name =" + "\"" + compoundName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(compoundIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist
            }
            resultSet.next();
            int compoundID = resultSet.getInt("ID");

            /*Getting the speciesID*/
            String speciesIDQuery = "SELECT ID from Species where Description = " + "\"" + species + "\"";
            resultSet = connectionHandler.performQuery(speciesIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist  
            }
            resultSet.next();
            int speciesID = resultSet.getInt("ID");

            //Know the animal can be added to the database
            StringBuilder querySB = new StringBuilder();
            querySB.append("INSERT INTO Animal(CompoundID,SpeciesID,AnimalName,Birthday,Sex) ")
                    .append("VALUES (").append(compoundID).append(",").append(speciesID)
                    .append(",").append("'").append(animalName).append("'").append(",")
                    .append("'").append(birthday).append("'").append(",").append("'").append(sex).append("'").append(")");
            String query = querySB.toString();
            System.out.println(query);

            boolean retVal = connectionHandler.manipulateDB(query);

            /*
        if (retVal){
        System.out.println("Einfügen erfolgreich") ;
        }else System.out.println("Einfügen misslungen");*/
            return retVal;
        } catch (SQLException ex) {

            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Method to update an Animal in the database.
     *
     * @param ID
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @return
     */
    public boolean updateAnimal(int ID, String animalName, String compoundName, String birthday, String sex, String species) {

        /*Get compoundID and species ID TODO method to shorten code*/
        try {
            /*Getting the CompoundID*/
            String compoundIDQuery = "SELECT ID from Compound where name =" + "\"" + compoundName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(compoundIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist
            }
            resultSet.next();
            int compoundID = resultSet.getInt("ID");

            /*Getting the speciesID*/
            String speciesIDQuery = "SELECT ID from Species where Description = " + "\"" + species + "\"";
            resultSet = connectionHandler.performQuery(speciesIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist  
            }
            resultSet.next();
            int speciesID = resultSet.getInt("ID");

            //Know the animal can be updated
            StringBuilder querySB = new StringBuilder();
            querySB.append("UPDATE Animal")
                    .append(" SET CompoundID = ").append(compoundID).append(",")
                    .append("SpeciesID = ").append(speciesID).append(", ")
                    .append("AnimalName = ").append("'").append(animalName).append("'").append(", ")
                    .append("Birthday = ").append("'").append(birthday).append("'").append(",")
                    .append("Sex = ").append("'").append(sex).append("' ")
                    .append(" WHERE ID = ").append(ID);

            String query = querySB.toString();
            System.out.println(query);

            boolean retVal = connectionHandler.manipulateDB(query);

            return retVal;

        } catch (SQLException ex) {

            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Method which has been implemented to delete an Animal from the database.
     * @param ID
     * @return 
     */
    public boolean deleteAnimal(int ID) {

        String query = "DELETE From Animal WHERE ID =" + ID;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }
    
    
}
