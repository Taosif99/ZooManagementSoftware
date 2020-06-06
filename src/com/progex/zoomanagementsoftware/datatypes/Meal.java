package com.progex.zoomanagementsoftware.datatypes;
import java.sql.Date;

/**
 * @(#) Meal.java
 */

public class Meal
{
	private double amount;
	
	private Date time;
	
	private Food food;

    public Meal(double amount, Date time, Food food) {
        this.amount = amount;
        this.time = time;
        this.food = food;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }	
}
