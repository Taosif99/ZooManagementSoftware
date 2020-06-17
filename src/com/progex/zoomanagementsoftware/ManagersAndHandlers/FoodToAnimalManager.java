/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.FoodToAnimalR;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 *
 * @author Ouchen
 */
public class FoodToAnimalManager {
    
    
      private ConnectionHandler connectionHandler;
      private ZooManager zooManager;

    public FoodToAnimalManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }
    
      
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
     *
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
        }

        return false;
    }

    /**
     * Method whcih has been implemented to delete a food to animal relation in
     * the database.
     *
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
     *
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
        String query = zooManager.generateSearchQuery(columnValueMap, begin);
        if (query != null) {

            ResultSet resultSet = connectionHandler.performQuery(query);
            records = createFoodToAnimal(resultSet, animalID);
        } else {
            return this.getFoodToAnimalRecords(animalID);
        }

        return records;
    }
    
      /**
     * *
     * Method which has been implemented to create a FoodToAnimalR datastructure
     * from a resultSet which has all requiered attributes.
     *
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
      
}
