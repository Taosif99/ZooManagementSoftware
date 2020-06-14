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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

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

        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Compound> compounds = createCompounds(resultSet);
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
     * Method to update the values of a compound.
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
     * Method to delete a compound from the database.
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
     * Method to search for compounds in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding values
     * @return A LinkedList which contains the searched compounds
     */
    public LinkedList<Compound> searchCompounds(LinkedHashMap<String, String> columnValueMap) {

        String query = generateSearchQuery(columnValueMap, "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound WHERE ");
        LinkedList<Compound> compounds = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            compounds = createCompounds(resultSet);
        } else return this.getCompounds(); //Case if we have no attributes
        return compounds;
    }

    /**
     * Method which has been implemented to create a compound datastructure from
     * a resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all compounds depending on the result set
     */
    private LinkedList<Compound> createCompounds(ResultSet resultSet) {

        LinkedList<Compound> compounds = new LinkedList<Compound>();

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

    /*End Compund Methods*/
 /*Methods concerning Managing Animal start here*/
    /**
     * Method to get the required values of the admin view.
     *
     * @return A LinkedList of Animal objects which contains all animals which are stored in the database
     */
    public LinkedList<Animal> getAnimals() {

        String query = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName\n"
                + "FROM Animal,Compound,Species\n"
                + "WHERE Animal.CompoundID = Compound.ID AND\n"
                + "Animal.SpeciesID = Species.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Animal> animals = createAnimals(resultSet);

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
     * @return true if update operation successful,else false
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
     *
     * @param ID
     * @return true if delete operation is successful, else false
     */
    public boolean deleteAnimal(int ID) {

        String query = "DELETE From Animal WHERE ID =" + ID;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to search for animals in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * values
     * @return A LinkedList which contains the searhed animal objects
     */
    public LinkedList<Animal> searchAnimals(LinkedHashMap<String, String> columnValueMap) {

        LinkedList<Animal> animals = null;

        String begin = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName\n"
                + "FROM Animal\n"
                + "INNER JOIN  Compound ON Animal.CompoundID = Compound.ID \n"
                + "INNER JOIN Species ON Animal.speciesID = Species.ID WHERE";
        String query = generateSearchQuery(columnValueMap, begin);

        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            animals = createAnimals(resultSet);

        } else return this.getAnimals(); 
        return animals;

    }

    /**
     * *
     * Method which has been implemented to create an Animal datastructure from
     * a resultSet which has all requiered attributes.
     * @param resultSet
     * @return A LinkedList of Animal objects depending of the result set
     */
    private LinkedList<Animal> createAnimals(ResultSet resultSet) {

        LinkedList<Animal> animals = new LinkedList<Animal>();

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

    /*Methods concerning animal end here*/
    
 /*Methods concerning Food to Animal relation start here*/
    /**
     * Method which has been implemented to get all requiered information for
     * the food to animal admin view.
     *
     * @param animalID
     * @return The corresponding records saved in a LinkedList
     */
    public LinkedList<FoodToAnimalR> getFoodToAnimalRecords(int animalID) {

        String query = "SELECT Food.Name as FoodName, Food.ID as \n"
                + "FoodID,Eats.StartFeedingTime,Eats.EndFeedingTime,Eats.Amount\n"
                + "FROM Eats\n"
                + "INNER JOIN Food ON  Food.ID = Eats.FoodID\n"
                + "WHERE AnimalID = " + animalID;

        System.out.println(query);
        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<FoodToAnimalR> records = createFoodToAnimal(resultSet, animalID);
        return records;
    }

    /**
     * Method which adds an FoodToAnimal relation to the database
     *
     * @param animalID
     * @param foodName
     * @param startFeedingTime
     * @param endFeedingTime
     * @param amount
     * @return true if operation is successful, else false
     */
    public boolean addFoodToAnimal(String animalID, String foodName, String startFeedingTime, String endFeedingTime, double amount) {

        try {
            /*Getting the FoodID*/
            String foodIDQuery = "SELECT ID from Food where Name =" + "\"" + foodName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(foodIDQuery);
            if (resultSet == null) {
                return false; //case if food does not exist
            }
            resultSet.next();
            int foodID = resultSet.getInt("ID");

            //Know the animal food relation can be added to the database
            StringBuilder querySB = new StringBuilder();
            querySB.append("INSERT INTO Eats(FoodID,AnimalID,StartFeedingTime,EndFeedingTime,Amount) ")
                    .append("VALUES (").append(foodID).append(",").append(animalID)
                    .append(",").append("'").append(startFeedingTime).append("'").append(",")
                    .append("'").append(endFeedingTime).append("'").append(",").append(amount).append(")");
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
     * Method which has been implemented to update the food to animal relation 
     * in the database.
     * @param animalID
     * @param foodName
     * @param startFeedingTime
     * @param endFeedingTime
     * @param amount
     * @param keys
     * @return true if operation is successful, else false
     */
    public boolean updateFoodToAnimal(String animalID, String foodName, String startFeedingTime, String endFeedingTime, double amount, HashMap<String, String> keys) {

        /*Get compoundID and species ID TODO method to shorten code*/
        try {

            /*Getting old keys*/
            String startFeedingTimeKey = keys.get("StartFeedingTime");
            String foodIDKey = keys.get("FoodID");

            /*Getting the FoodID of the new food*/
            String foodIDQuery = "SELECT ID from Food where Name =" + "\"" + foodName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(foodIDQuery);
            if (resultSet == null) {
                return false; //case if food does not exist
            }
            resultSet.next();
            int foodID = resultSet.getInt("ID");

            //Know the relation can be updated
            StringBuilder querySB = new StringBuilder();
            querySB.append("UPDATE Eats ")
                    .append("SET FoodID = ").append(foodID).append(",")
                    .append("AnimalID = ").append(animalID).append(", ")
                    .append("StartFeedingTime = ").append("'").append(startFeedingTime).append("'").append(", ")
                    .append("EndFeedingTime = ").append("'").append(endFeedingTime).append("'").append(",")
                    .append("Amount = ").append(amount)
                    .append(" WHERE FoodID = ").append(foodIDKey)
                    .append(" AND ").append("AnimalID = ").append(animalID)
                    .append(" AND StartFeedingTime = '").append(startFeedingTimeKey).append("'");

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
     * Method whcih has been implemented to delete a food to 
     * animal relation in the database.
     * @param foodID
     * @param animalID
     * @param startFeedingTime
     * @return True if operation successful, else false
     */
    public boolean deleteFoodToAnimal(String foodID, String animalID, String startFeedingTime) {

        String query = "DELETE FROM Eats "
                + "WHERE FoodID = " + foodID
                + " AND AnimalID= " + animalID
                + " AND StartFeedingTime = '" + startFeedingTime + "'";
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * This method searches for FoodToAnimal records in the database.
     * @param columnValueMap
     * @return The corresponding search response depending on the column values
     */
    public LinkedList<FoodToAnimalR> searchFoodToAnimal(LinkedHashMap<String, String> columnValueMap) {

        LinkedList<FoodToAnimalR> records = null;
        String begin = "SELECT Food.Name as FoodName, Food.ID as \n"
                + "FoodID, Eats.AnimalID as AnimalID,Eats.StartFeedingTime,Eats.EndFeedingTime,Eats.Amount\n"
                + "FROM Eats\n"
                + "INNER JOIN Food ON  Food.ID = Eats.FoodID\n"
                + "WHERE ";
        int animalID = Integer.parseInt(columnValueMap.get("AnimalID"));
        String query = generateSearchQuery(columnValueMap, begin);
        if (query != null) {

            ResultSet resultSet = connectionHandler.performQuery(query);
            records = createFoodToAnimal(resultSet, animalID);
        } else return this.getFoodToAnimalRecords(animalID);

        return records;
    }

    /**
     * *
     * Method which has been implemented to create a FoodToAnimalR datastructure from
     * a resultSet which has all requiered attributes.
     * @param resultSet
     * @param animalID
     * @return A LinkedList with all requested FoodToAnimalR objects
     */
    private LinkedList<FoodToAnimalR> createFoodToAnimal(ResultSet resultSet, int animalID) {

        LinkedList<FoodToAnimalR> records = new LinkedList<FoodToAnimalR>();

        try {
            while (resultSet.next()) {

                String foodName = resultSet.getString("foodName");
                int foodID = resultSet.getInt("FoodID");
                String startFeedingTime = resultSet.getString("StartFeedingTime");
                String endFeedingTime = resultSet.getString("EndFeedingTime");
                double amount = resultSet.getDouble("Amount");

                FoodToAnimalR record = new FoodToAnimalR(foodName, foodID, animalID, startFeedingTime, endFeedingTime, amount);
                records.add(record);
            }

        } catch (SQLException e) {
            System.err.println("SQL exception");
            System.out.println(e.getMessage());

        }

        return records;
    }

    /*Methods concerning Food to Animal relation end here*/
 /*Own reused methods*/
    /**
     * https://www.geeksforgeeks.org/mysql-regular-expressions-regexp/ zum
     * Nachgucken 
     * Method which constructs a search query using the parameters
     * and regular expressions.
     *
     * @param columnValueMap
     * @param queryBegin
     * @return The query as String, null if no String can be built
     */
    private String generateSearchQuery(LinkedHashMap<String, String> columnValueMap, String queryBegin) {

        LinkedHashMap<String, String> nonEmptyColumnValueMap = new LinkedHashMap<String, String>();

        try {

            //Remove empty or null textFields
            for (Entry<String, String> entry : columnValueMap.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                if (!value.isEmpty()) {
                    //textFieldMap.remove(key);
                    nonEmptyColumnValueMap.put(key, value);
                }
            }

            StringBuilder querySb = new StringBuilder();
            querySb.append(queryBegin).append(" ");
            Set<Map.Entry<String, String>> entries = nonEmptyColumnValueMap.entrySet();

            //get the iterator for entries
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();

            //Adding first entry
            Entry<String, String> firstEntry = iterator.next();

            String columnName = firstEntry.getKey();
            String value = firstEntry.getValue();
            querySb.append(columnName).append(" REGEXP '").append(value).append("'");

            //Removing first entry
            nonEmptyColumnValueMap.remove(columnName);

            for (Entry<String, String> entry : nonEmptyColumnValueMap.entrySet()) {

                columnName = entry.getKey();
                value = entry.getValue();
                querySb.append(" AND ").append(columnName).append(" REGEXP '").append(value).append("'");
            }

            System.out.println(querySb.toString());
            return querySb.toString();

        } catch (NoSuchElementException noSuchElementException) {

            System.err.println("LinkHashMap value empty or null");
            System.out.println(noSuchElementException.getMessage());
            return null;
        }
    }
}
