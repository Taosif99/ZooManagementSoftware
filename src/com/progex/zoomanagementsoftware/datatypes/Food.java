package com.progex.zoomanagementsoftware.datatypes;

/**
 * Class which is used to model the food inventory of the zoo in our 
 * zoo management software.
 */
public class Food {

    private int id;

    private String name;

    private double stock;

    private String storageRoomNumber;

    /**
     * Standard constructor to model a food dataset.
     * @param id
     * @param name
     * @param stock
     * @param storageRoomNumber 
     */
    public Food(int id, String name, double stock, String storageRoomNumber) {

        this.id = id;
        this.name = name;
        this.stock = stock;
        this.storageRoomNumber = storageRoomNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getStorageRoomNumber() {
        return storageRoomNumber;
    }

    public void setStorageRoomNumber(String storageRoomNumber) {
        this.storageRoomNumber = storageRoomNumber;
    }
}