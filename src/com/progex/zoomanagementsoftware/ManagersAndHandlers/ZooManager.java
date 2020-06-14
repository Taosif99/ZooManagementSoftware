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
import java.sql.Statement;

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

    /*Methods concerning Compound*/
    /**
     *
     * @return A LinkedList of of Compound objects
     */
    public LinkedList<Compound> getCompounds() {

        LinkedList<Compound> compounds = new LinkedList<Compound>();
        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);

        if (resultSet != null) {

            /*TODO CALCULATE CURRENT CAPPACITY,currently set to 0*/
            try {
                while (resultSet.next()) {

                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    double area = resultSet.getDouble("Area");
                    int year = resultSet.getInt("ConstructionYear");
                    int maxCapacity = resultSet.getInt("MaxCapacity");

                    Compound newCompound = new Compound(ID, area, new Date(year, 0, 0), maxCapacity, 0, name);
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }

        }

        return compounds;
    }

    //Methods concerning Food
    public LinkedList<Food> getFoods(int id, int storageRoomNumber, double stock, String name) {

        LinkedList<Food> foods = new LinkedList<Food>();
        Food tempFood;
        String query = "SELECT id, storageRoomNumber, stock, name FROM food WHERE ";
        boolean and = false;

        if (id != 0) {
            query = query + "id = " + id;
            and = true;
        }

        if (and == true && storageRoomNumber != -1) {

            query = query + " AND storageRoomNumber = " + storageRoomNumber;
            and = true;
        } else if (and != true && storageRoomNumber != -1) {

            query = query + "storageRoomNumber = " + storageRoomNumber;
            and = true;
        }

        if (and == true && stock != -1.0) {
            query = query + " AND stock = " + stock;
            and = true;
        } else if (and != true && stock != -1) {
            query = query + "stock = " + stock;
            and = true;
        }

        if (and == true && name != null) {
            query = query + " AND name = '" + name + "'";
            and = true;
        } else if (and != true && name != null) {
            query = query + "name = '" + name + "'";
            and = true;
        }

        if (and == false) {
            query = "SELECT id, storageRoomNumber, stock, name FROM food";
        }

        System.out.println(query);

        ResultSet resultSet = connectionHandler.performQuery(query);

        if (resultSet != null) {

            try {
                while (resultSet.next()) {

                    int tempID = resultSet.getInt("ID");
                    int tempStorageRoomNumber = resultSet.getInt("StorageRoomNumber");
                    double tempStock = resultSet.getDouble("Stock");
                    String tempName = resultSet.getString("Name");

                    tempFood = new Food(tempID, tempName, tempStock, tempStorageRoomNumber);
                    foods.add(tempFood);
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        return foods;
    }

    public boolean checkFoodExists(String name) {

        try {
            String query = "SELECT name FROM food WHERE name = '" + name + "'";
            System.out.println(query);
            ResultSet resultSet = connectionHandler.performQuery(query);
            if (resultSet != null) {
                while (resultSet.next()) {
                    String temp = resultSet.getString("Name");
                    System.out.println(temp);
                    if(temp != null)
                        return true;    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addFood(int storageRoomNumber, double stock, String name) {

        String query = "INSERT INTO Food(StorageRoomNumber,Stock,Name) VALUES(" + storageRoomNumber + "," + stock + ",'" + name + "');";
        System.out.println(query);
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    public boolean updateFood(int storageRoomNumber, double stock, String name, int id) {

        String query = "UPDATE food SET storageRoomNumber = " + storageRoomNumber + ", stock = " + stock
                + ", name = '" + name + "' WHERE id = " + id;

        System.out.println(query);

        boolean retVal = connectionHandler.manipulateDB(query);

        return retVal;
    }

    public boolean deleteFood(int id) {

        String query = "DELETE FROM food WHERE id = " + id + ";";
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

}
