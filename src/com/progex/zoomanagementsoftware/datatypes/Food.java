package com.progex.zoomanagementsoftware.datatypes;
/**
 *  Class which is used to model the food of the zoo in our zoo management software.
 */

public class Food
{
	private int id;
	
	private String name;
	
	private double stock;
	
	private int storageRoomNumber;

    public Food(int id, String name, double stock, int storageRoomNumber) {
        
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

    public int getStorageRoomNumber() {
        return storageRoomNumber;
    }

    public void setStorageRoomNumber(int storageRoomNumber) {
        this.storageRoomNumber = storageRoomNumber;
    }	
}
