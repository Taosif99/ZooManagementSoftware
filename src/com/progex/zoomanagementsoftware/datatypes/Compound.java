package com.progex.zoomanagementsoftware.datatypes;



/**
 * Class which is used to model a compound in our zoo management software.
 */
public class Compound {

    private int id;

    private double area;

    private int constructionYear;

    private int maxCapacity;

    private int currentCapacity;

    private String name;

    /**
     * Standard constructor to model a compound dataset.
     * @param id
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @param currentCapacity
     * @param name 
     */
    public Compound(int id, double area, int constructionYear, int maxCapacity, int currentCapacity, String name) {
        this.id = id;
        this.area = area;
        this.constructionYear = constructionYear;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.name = name;
    }

    
    /**
     * Constructor to model a compound which will be added to the database.
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @param name 
     */
    public Compound(double area, int constructionYear,int maxCapacity,String name){
    
        this.area = area;
        this.constructionYear = constructionYear;
        this.maxCapacity = maxCapacity;
        this.name = name;
    
    
    }
    
    
    /**
     * Construtctor, which has the requiered values for an update operation.
     * @param id
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @param name 
     */
      public Compound(int id,double area, int constructionYear,int maxCapacity,String name){
    
        this.id = id;
        this.area = area;
        this.constructionYear = constructionYear;
        this.maxCapacity = maxCapacity;
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

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
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
