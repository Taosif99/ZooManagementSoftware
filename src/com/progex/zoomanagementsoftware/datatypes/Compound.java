package com.progex.zoomanagementsoftware.datatypes;

import java.sql.Date;

/**
 * @(#) Compound.java
 */
public class Compound {

    private int id;

    private double area;

    private Date constructionYear;

    private int maxCapacity;

    private int currentCapacity;

    private String name;

    public Compound(int id, double area, Date constructionYear, int maxCapacity, int currentCapacity, String name) {
        this.id = id;
        this.area = area;
        this.constructionYear = constructionYear;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Date getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Date constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
