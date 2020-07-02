package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.Food;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class which handles foods in our program.
 */
public class FoodManager {

    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;

    /**
     * Creates a FoodManager with corresponding reference to connection and main
     * interface handlers.
     *
     * @param connectionHandler
     * @param zooManager
     */
    public FoodManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }
    
    
    
    
    
    
    /**
     * Method which is used to load a List of food names from the database. 
     * @return The ordered list if successfull, else an empty arraylist
     */
    public ArrayList<String> loadFoodNames(){
        
        ArrayList <String> foodNames = new ArrayList<String>(); 
    
        String query = "Select Name from Food Order by Name";
        
        ResultSet resultSet = connectionHandler.performQuery(query);
        
         try {
            String foodName; 
            while (resultSet.next()) {
                foodName = resultSet.getString("Name");
                foodNames.add(foodName);
            }
         }catch (SQLException sqlException) {
            System.err.println("SQL Exception in loadFoodNames()");
            System.out.print(sqlException.getMessage());
        }

         return foodNames;
    }
    
    
    
    

    private LinkedList<Food> createFoods(ResultSet resultSet) {
        LinkedList<Food> foods = new LinkedList<Food>();
        if (resultSet != null) {

            try {
                while (resultSet.next()) {
                    int tempID = resultSet.getInt("ID");
                    String tempStorageRoomNumber = resultSet.getString("StorageRoomNumber");
                    double tempStock = resultSet.getDouble("Stock");
                    String tempName = resultSet.getString("Name");

                    Food tempFood = new Food(tempID, tempName, tempStock, tempStorageRoomNumber);
                    foods.add(tempFood);
                }

            } catch (SQLException sqlException) {
                System.err.println("SQL Exception in createFoods()");
                System.out.println(sqlException.getMessage());
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

        String query = zooManager.generateSearchQuery(columnValueMap, "SELECT id, storageRoomNumber, stock, name FROM food WHERE ","id");
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
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in checkFoodExists()");
            System.out.print(sqlException.getMessage());
        }

        return false;
    }

    /**
     * This method is used to add food to the database.
     *
     * @param storageRoomNumber
     * @param stock
     * @param name
     * @return If the operation was successfull true, else false
     */
    public boolean addFood(String storageRoomNumber, double stock, String name) {

        String query = "INSERT INTO Food(StorageRoomNumber,Stock,Name) VALUES('" + storageRoomNumber + "'," + stock + ",'" + name + "');";
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
     * @return If the operation was successfull true, else false
     */
    public boolean updateFood(String storageRoomNumber, double stock, String name, int id) {

        String queryOldName = "SELECT Name FROM Food WHERE Id = " + id;

        String oldName = " ";
        ResultSet resultSet = connectionHandler.performQuery(queryOldName);
        if (resultSet != null) {

            try {
                if (resultSet.next()) {
                    oldName = resultSet.getString("Name");
                }
            } catch (SQLException sqlException) {
                System.err.println("SQL Exception in updateFood()");
                System.out.print(sqlException.getMessage());
            }
        }

        if (!oldName.equals(name)) {
            if (this.checkFoodExists(name, -1)) {
                return false;
            }
        }

        String query = "UPDATE food SET storageRoomNumber = '" + storageRoomNumber + "', stock = " + stock
                + ", name = '" + name + "' WHERE id = " + id;

        System.out.println(query);

        boolean retVal = connectionHandler.manipulateDB(query);

        return retVal;
    }

    /**
     * This method is used to delete food from the database.
     *
     * @param id
     * @return If the operation was successfull true, else false
     */
    public boolean deleteFood(int id) {

        String query = "DELETE FROM food WHERE id = " + id + ";";
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }
}