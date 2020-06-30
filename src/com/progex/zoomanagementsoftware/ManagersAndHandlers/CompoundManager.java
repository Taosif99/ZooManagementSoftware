package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.Compound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which handles the compounds in our program.
 */
public class CompoundManager {

    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;

    /**
     * Creates a Compound manager with corresponding 
     * reference to connection and main interface handlers.
     * @param connectionHandler
     * @param zooManager 
     */
    public CompoundManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }

    /**
     * Method which access the compounds which are stored in the database.
     *
     * @return A LinkedList of Compound objects
     */
    public LinkedList<Compound> getCompounds() {

        String query = "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound";
        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Compound> compounds = createCompounds(resultSet);
        return compounds;
    }

    /**
     * Method to add a compound to the database.
     *
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successfull, else false
     */
    public boolean addCompound(String name, double area, int constructionYear, int maxCapacity) {

        String query = "INSERT INTO Compound(Name,Area,ConstructionYear,MaxCapacity) VALUES('" + name + "'," + area + "," + constructionYear + "," + maxCapacity + ")";

        boolean retVal = connectionHandler.manipulateDB(query);

        return retVal;
    }

    /**
     * Method to update the values of a compound.
     *
     * @param ID
     * @param name
     * @param area
     * @param constructionYear
     * @param maxCapacity
     * @return true if successful, else false
     */
    public boolean updateCompound(int ID, String name, double area, int constructionYear, int maxCapacity) {

        //Get the old name of the current compound
        String queryOldName = "SELECT Name FROM Compound WHERE ID =" + ID;

        String oldName = " ";
        ResultSet resultSet = connectionHandler.performQuery(queryOldName);
        if (resultSet != null) {

            try {
                if (resultSet.next()) {
                    oldName = resultSet.getString("Name");
                }

            } catch (SQLException ex) {
                System.err.println("SQL Exception in updateCompound()");
                System.out.println(ex.getMessage());
            }
        }

        if (!oldName.equals(name)) {
            if (this.compoundExists(name)) {
                return false;
            }
        }

        StringBuilder querySB = new StringBuilder();
        querySB.append("UPDATE Compound")
                .append(" SET Name = ").append("'").append(name).append("',")
                .append("Area = ").append(area).append(", ")
                .append("ConstructionYear = ").append(constructionYear).append(", ")
                .append("MaxCapacity = ").append(maxCapacity)
                .append(" WHERE ID = ").append(ID);

        String query = querySB.toString();
        System.out.println(query);
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to delete a compound from the database.
     *
     * @param ID
     * @return true if successful, else false
     */
    public boolean deleteCompound(int ID) {

        String query = "DELETE FROM Compound WHERE ID = " + ID;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to search for compounds in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * values
     * @return A LinkedList which contains the searched compounds
     */
    public LinkedList<Compound> searchCompounds(LinkedHashMap<String, String> columnValueMap) {

        String query = zooManager.generateSearchQuery(columnValueMap, "SELECT ID,Name,Area,ConstructionYear,MaxCapacity FROM compound WHERE ");
        LinkedList<Compound> compounds = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            compounds = createCompounds(resultSet);
        } else {
            return this.getCompounds(); //Case if we have no attributes
        }
        return compounds;
    }

    /**
     * Method which has been implemented to create a compound data structure from
     * a resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all compounds depending on the result
     * set
     */
    private LinkedList<Compound> createCompounds(ResultSet resultSet) {

        LinkedList<Compound> compounds = new LinkedList<Compound>();

        if (resultSet != null) {

            try {
                while (resultSet.next()) {

                    int ID = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    double area = resultSet.getDouble("Area");
                    int year = resultSet.getInt("ConstructionYear");
                    int maxCapacity = resultSet.getInt("MaxCapacity");

                    //Know get the current cappacity of an compound
                    String compoundID = Integer.toString(ID);
                    String queryToGetCurrentCapacity = "SELECT COUNT(CompoundID) as CurrentCapacity FROM Animal WHERE CompoundID = " + compoundID;

                    ResultSet currentCapacityResult = connectionHandler.performQuery(queryToGetCurrentCapacity);
                    currentCapacityResult.next();
                    int currentCapacity = currentCapacityResult.getInt("CurrentCapacity");

                    Compound newCompound = new Compound(ID, area, year, maxCapacity, currentCapacity, name);
                    compounds.add(newCompound);
                }
            } catch (SQLException e) {
                System.err.println("SQL Exception in createCompounds()");
                System.out.println(e.getMessage());
            }
        }
        return compounds;
    }

    /**
     * Method to check if a compound with the given name already exists.
     *
     * @param compoundName
     * @return true if compound with this name is found, else false
     */
    public boolean compoundExists(String compoundName) {

        try {
            String query = "SELECT Name FROM Compound WHERE Name = '" + compoundName + "'";
            ResultSet resultSet = connectionHandler.performQuery(query);

            if (resultSet == null) {
                return false;
            }

            if (resultSet.next()) {
              
                return true;

            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.err.println("SQL Exception in compoundExists()");
            System.out.println(ex.getMessage());

        }
        return false;
    }
    
    
    /**
     * Method to check if animals live in a compound or not.
     * @param CompoundId
     * @return true if atleast one animal lives in the compound, else false
     */
    public boolean isEmpty(int CompoundId){
    
    
           String compoundID = Integer.toString(CompoundId);
           String queryToGetCurrentCapacity = "SELECT COUNT(CompoundID) as CurrentCapacity FROM Animal WHERE CompoundID = " + compoundID;
           ResultSet currentCapacityResult = connectionHandler.performQuery(queryToGetCurrentCapacity);
           
        try {
            currentCapacityResult.next();
            int currentCapacity = currentCapacityResult.getInt("CurrentCapacity");
            if(currentCapacity>0) return false;
            
        } catch (SQLException ex) {
            System.err.println("SQL Exception in isEmpty()");
            System.out.println(ex.getMessage());

        }
     return true;
    }
    
}