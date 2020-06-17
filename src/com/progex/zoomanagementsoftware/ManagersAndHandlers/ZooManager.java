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
    private CompoundManager compoundManager;
    private AnimalManager animalManager;
    private FoodToAnimalManager foodToAnimalManager;
   
    
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
        guestModeManager = new GuestModeManager(connectionHandler);
        userManager = new UserManager(connectionHandler, this);
        compoundManager = new CompoundManager(connectionHandler, this);
        animalManager = new AnimalManager(connectionHandler,this);
        foodToAnimalManager = new FoodToAnimalManager(connectionHandler, this);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public GuestModeManager getGuestModeManager() {
        return guestModeManager;
    }

    public CompoundManager getCompoundManager() {
        return compoundManager;
    }

       public AnimalManager getAnimalManager() {
        return animalManager;
    }

    public FoodToAnimalManager getFoodToAnimalManager() {
        return foodToAnimalManager;
    }

       
       
       
    //Mustapha start
    
    /*Methods concerning Food to Animal relation end here*/
 /*Own reused methods*/
    /**
     * https://www.geeksforgeeks.org/mysql-regular-expressions-regexp/ zum
     * Nachgucken Method which constructs a search query using the parameters
     * and regular expressions.
     *
     * @param columnValueMap
     * @param queryBegin
     * @return The query as String, null if no String can be built
     */
    public String generateSearchQuery(LinkedHashMap<String, String> columnValueMap, String queryBegin) {

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

            System.err.println("LinkedHashMap value empty or null");
            System.out.println(noSuchElementException.getMessage());
            return null;
        }
    }
    //Mustapha end

    //Taosif start
    //Methods concerning Food
    private LinkedList<Food> createFoods(ResultSet resultSet) {
        LinkedList<Food> foods = new LinkedList<Food>();
        if (resultSet != null) {

            try {
                while (resultSet.next()) {
                    int tempID = resultSet.getInt("ID");
                    int tempStorageRoomNumber = resultSet.getInt("StorageRoomNumber");
                    double tempStock = resultSet.getDouble("Stock");
                    String tempName = resultSet.getString("Name");

                    Food tempFood = new Food(tempID, tempName, tempStock, tempStorageRoomNumber);
                    foods.add(tempFood);
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        return foods;
    }

    /**
     * This method searches for food in the database.
     *
     * @param columnValueMap
     * @return The corresponding search response depending on the column values
     */
    public LinkedList<Food> searchFoods(LinkedHashMap<String, String> columnValueMap) {

        String query = generateSearchQuery(columnValueMap, "SELECT id, storageRoomNumber, stock, name FROM food WHERE ");
        LinkedList<Food> foods = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            foods = createFoods(resultSet);
        } else {
            return this.getFoods();
        }
        return foods;
    }

    /**
     * Method to get all foods from the database.
     *
     * @return A LinkedList of Food objects which contains all foods which are
     * stored in the database
     */
    public LinkedList<Food> getFoods() {

        String query = "SELECT id, storageRoomNumber, stock, name FROM food";
        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Food> foods = createFoods(resultSet);
        return foods;
    }

    /**
     * This method is used to check if a food exists in the database. If the the
     * food name is unknowm then name must be null. If the food id is unknown
     * then id must be -1.
     *
     * @param name
     * @param id
     * @return True if the food exists and false if the food doesnt exist
     */
    public boolean checkFoodExists(String name, int id) {

        try {
            ResultSet resultSet;
            String query;
            if (name == null) {
                query = "SELECT id FROM food WHERE id = " + id;
                System.out.println(query);
                resultSet = connectionHandler.performQuery(query);

                if (resultSet != null) {
                    if (resultSet.next()) {
                        System.out.println("True");
                        return true;
                    }
                }
            } else {
                query = "SELECT name FROM food WHERE name = '" + name + "'";
                System.out.println(query);
                resultSet = connectionHandler.performQuery(query);
                if (resultSet != null) {
                    if (resultSet.next()) {
                        System.out.println("True");
                        return true;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL Exception");
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(
                "false");

        return false;
    }

    /**
     * This method is used to add food to the database.
     *
     * @param storageRoomNumber
     * @param stock
     * @param name
     * @return If the operation was successfull
     */
    public boolean addFood(int storageRoomNumber, double stock, String name) {

        String query = "INSERT INTO Food(StorageRoomNumber,Stock,Name) VALUES(" + storageRoomNumber + "," + stock + ",'" + name + "');";
        System.out.println(query);
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * This method is used to update food in the database.
     *
     * @param storageRoomNumber
     * @param stock
     * @param name
     * @param id
     * @return If the operation was successfull
     */
    public boolean updateFood(int storageRoomNumber, double stock, String name, int id) {

        String query = "UPDATE food SET storageRoomNumber = " + storageRoomNumber + ", stock = " + stock
                + ", name = '" + name + "' WHERE id = " + id;

        System.out.println(query);

        boolean retVal = connectionHandler.manipulateDB(query);

        return retVal;
    }

    /**
     * This method is used to delete food from the database.
     *
     * @param id
     * @return If the operation was successfull
     */
    public boolean deleteFood(int id) {

        String query = "DELETE FROM food WHERE id = " + id + ";";
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    //TakesCare
    /**
     * This method is used to get all animal ids with the same animal name.
     *
     * @param animalName
     * @return A LinkedList of animal ids
     */
    public LinkedList<Integer> getAnimalIds(String animalName) {

        LinkedList<Integer> animalIds = new LinkedList<Integer>();

        try {

            String query = "SELECT id FROM animal WHERE animalName = '" + animalName + "'";

            System.out.println(query);
            ResultSet resultSet = connectionHandler.performQuery(query);
            if (resultSet != null) {
                while (resultSet.next()) {
                    animalIds.add(resultSet.getInt("id"));
                    //System.out.println(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception");
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return animalIds;
    }

    /**
     * This method is used to add a takes care relation.
     *
     * @param animalIds
     * @param zookeeperId
     * @return If the operation was successfull
     */
    public boolean addZookeeperToAnimal(LinkedList<Integer> animalIds, String zookeeperId) {
        String query;
        System.out.println("add zookeeperId  : " + zookeeperId);
        for (Integer animalId : animalIds) {
            query = "INSERT INTO takesCare(UserID,AnimalID) VALUES(" + zookeeperId + "," + animalId + ")";
            System.out.println("In add: " + animalId);
            if (!connectionHandler.manipulateDB(query)) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method is used to delete a takes care relation
     * 
     * @param animalIds
     * @param zookeeperId
     * @return If the operation was successfull
     */
    public boolean deleteZookeeperToAnimal(LinkedList<Integer> animalIds, int zookeeperId) {

        boolean retVal = false;
        String query;
        System.out.println("delete zookeeperId  : " + zookeeperId);
        for (Integer animalId : animalIds) {
            query = "DELETE FROM takesCare WHERE userId = " + zookeeperId + " AND animalId = " + animalId;
            System.out.println("In delete: " + animalId);
            retVal = connectionHandler.manipulateDB(query);
        }
        return retVal;
    }

    private LinkedList<ZookeeperToAnimalR> createZookeeperToAnimal(ResultSet resultSet) {
        LinkedList<ZookeeperToAnimalR> records = new LinkedList<ZookeeperToAnimalR>();
        try {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int animalId = resultSet.getInt("animalId");
                String animalName = resultSet.getString("animalName");
                ZookeeperToAnimalR record = new ZookeeperToAnimalR(userId, firstname, lastname, animalId, animalName);
                records.add(record);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception");
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return records;
    }

    /**
     * This method is used to search for takes care relations in the database.
     * 
     * @param columnValueMap
     * @return A LinkedList which contains the searched takes care relations.
     */
    public LinkedList<ZookeeperToAnimalR> searchZookeeperToAnimal(LinkedHashMap<String, String> columnValueMap) {

        String begin = "SELECT takescare.UserID, user.firstname, user.lastname, takescare.AnimalID, animal.AnimalName\n"
                + "FROM takescare\n"
                + "INNER JOIN user ON takescare.UserID = user.id\n"
                + "INNER JOIN animal ON takescare.AnimalID = animal.ID WHERE ";

        String query = generateSearchQuery(columnValueMap, begin);
        System.out.println(query);
        LinkedList<ZookeeperToAnimalR> records;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            records = createZookeeperToAnimal(resultSet);
        } else {
            return this.getZookeeperToAnimalR();
        }
        return records;
    }

    /**
     * Method which has been implemented to get all requiered information for
     * the zookeeper to animal relation.
     * 
     * @return The corresponding records saved in a LinkedList
     */
    public LinkedList<ZookeeperToAnimalR> getZookeeperToAnimalR() {

        String query = "SELECT takescare.UserID, user.firstname, user.lastname, takescare.AnimalID, animal.AnimalName\n"
                + "FROM takescare\n"
                + "INNER JOIN user ON takescare.UserID = user.id\n"
                + "INNER JOIN animal ON takescare.AnimalID = animal.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<ZookeeperToAnimalR> records = createZookeeperToAnimal(resultSet);
        return records;
    }

    /**
     * This method is used to check if the takes care relation exists.
     * 
     * @param animalName
     * @param zookeeperId
     * @return True if the relation exists and false if the relation doesnt exist
     */
    public boolean checkZookeeperToAnimalExists(String animalName, int zookeeperId) {

        LinkedList<Integer> animalIds = getAnimalIds(animalName);
        System.out.println("check:   " + zookeeperId);
        String query;

        try {
            ResultSet resultSet;

            for (Integer animalId : animalIds) {
                query = "SELECT * FROM takesCare WHERE userId = " + zookeeperId + " AND animalId = " + animalId;
                resultSet = connectionHandler.performQuery(query);

                if (resultSet != null) {
                    if (resultSet.next()) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {

            System.err.println("SQL Exception");
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    //Taosif end

}
