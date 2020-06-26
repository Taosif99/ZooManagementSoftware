
package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.Food;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class which handles foods in our program.
 */
public class FoodManager {

    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;

    public FoodManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }
    
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

        String query = zooManager.generateSearchQuery(columnValueMap, "SELECT id, storageRoomNumber, stock, name FROM food WHERE ");
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

        String queryOldName = "SELECT Name FROM Food WHERE Id = " + id;
        
        String oldName = " ";
        ResultSet resultSet = connectionHandler.performQuery(queryOldName);
        if (resultSet != null) {

            try {
                if (resultSet.next()) {
                    oldName = resultSet.getString("Name");
                }

            } catch (SQLException ex) {
                System.err.println("SQL Exception");
                System.out.println(ex.getMessage());
            }
        }
        
        if (!oldName.equals(name)) {
            if (this.checkFoodExists(name,-1)) {
                return false;
            }
        }

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
}
