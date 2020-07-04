package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.Animal;
import com.progex.zoomanagementsoftware.datatypes.Compound;
import com.progex.zoomanagementsoftware.datatypes.Description;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.Species;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Class which handles animals in our program.
 */
public class AnimalManager {
    
    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;
    
     /**
     * Creates an AnimalManager with corresponding 
     * reference to connection and main interface handlers.
     * @param connectionHandler
     * @param zooManager 
     */
    public AnimalManager( ConnectionHandler connectionHandler,ZooManager zooManager) {
        
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }
    
    /**
     * Method to get the required values of the admin view.
     *
     * @return A LinkedList of Animal objects which contains all animals which
     * are stored in the database
     */
    public LinkedList<Animal> getAnimals() {

        String query = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName, visibleForGuest\n"
                + "FROM Animal,Compound,Species\n"
                + "WHERE Animal.CompoundID = Compound.ID AND\n"
                + "Animal.SpeciesID = Species.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Animal> animals = createAnimals(resultSet);

        return animals;
    }

    /**
     * Method which is used to load a List of animal names from the database.
     * @return The ordered list if successfull, else an empty arraylist
     */
    public ArrayList<String> loadAnimalNames(){
        
        ArrayList <String> animalNames = new ArrayList<String>(); 
    
        String query = "SELECT DISTINCT AnimalName FROM animal ORDER BY AnimalName";
        
        ResultSet resultSet = connectionHandler.performQuery(query);
        
         try {
            String animalName; 
            while (resultSet.next()) {
                animalName = resultSet.getString("AnimalName");
                animalNames.add(animalName);
            }
         }catch (SQLException sqlException) {
            System.err.println("SQL Exception in loadAnimalNames()");
            System.out.print(sqlException.getMessage());
        }

         return animalNames;
    }
   
    /**
     * Method to add an animal to the database.
     *
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @param visibility
     * @return true if successfull, else false
     */
    public boolean addAnimal(String animalName, String compoundName, String birthday, String sex, String species,String visibility) {

        try {
            /*Getting the CompoundID*/
            String compoundIDQuery = "SELECT ID from Compound where name =" + "\"" + compoundName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(compoundIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist
            }
            resultSet.next();
            int compoundID = resultSet.getInt("ID");

            /*Getting the speciesID*/
            String speciesIDQuery = "SELECT ID from Species where Description = " + "\"" + species + "\"";
            resultSet = connectionHandler.performQuery(speciesIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist  
            }
            resultSet.next();
            int speciesID = resultSet.getInt("ID");

            //Know the animal can be added to the database
            StringBuilder querySB = new StringBuilder();
            querySB.append("INSERT INTO Animal(CompoundID,SpeciesID,AnimalName,Birthday,Sex,visibleForGuest) ")
                    .append("VALUES (").append(compoundID).append(",").append(speciesID)
                    .append(",").append("'").append(animalName).append("'").append(",")
                    .append("'").append(birthday).append("'").append(",")
                    .append("'").append(sex).append("' ,")
                    .append(" '").append(visibility).append("')");
            String query = querySB.toString();
            System.out.println(query);

            boolean retVal = connectionHandler.manipulateDB(query);

            return retVal;
        } catch (SQLException ex) {

            System.err.println("SQL Exception in addAnimal()");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    /**
     * Method to update an animal in the database.
     *
     * @param ID
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @param visibility
     * @return true if update operation successful,else false
     */
    public boolean updateAnimal(int ID, String animalName, String compoundName, String birthday, String sex, String species, String visibility) {

        /*Get compoundID and species ID*/
        try {
            /*Getting the CompoundID*/
            String compoundIDQuery = "SELECT ID from Compound where name =" + "\"" + compoundName + "\"";
            ResultSet resultSet = connectionHandler.performQuery(compoundIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist
            }
            resultSet.next();
            int compoundID = resultSet.getInt("ID");

            /*Getting the speciesID*/
            String speciesIDQuery = "SELECT ID from Species where Description = " + "\"" + species + "\"";
            resultSet = connectionHandler.performQuery(speciesIDQuery);
            if (resultSet == null) {
                return false; //case if compound does not exist  
            }
            resultSet.next();
            int speciesID = resultSet.getInt("ID");

            //Know the animal can be updated
            StringBuilder querySB = new StringBuilder();
            querySB.append("UPDATE Animal")
                    .append(" SET CompoundID = ").append(compoundID).append(",")
                    .append("SpeciesID = ").append(speciesID).append(", ")
                    .append("AnimalName = ").append("'").append(animalName).append("'").append(", ")
                    .append("Birthday = ").append("'").append(birthday).append("'").append(",")
                    .append("Sex = ").append("'").append(sex).append("' ,")
                    .append("visibleForGuest = '").append(visibility).append("'")
                    .append(" WHERE ID = ").append(ID);

            String query = querySB.toString();
            System.out.println(query);
            boolean retVal = connectionHandler.manipulateDB(query);
            return retVal;

        } catch (SQLException ex) {

            System.err.println("SQL Exception in updateAnimal()");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    /**
     * Method which has been implemented to delete an animal from the database.
     *
     * @param ID
     * @return true if delete operation is successful, else false
     */
    public boolean deleteAnimal(int ID) {

        String query = "DELETE From Animal WHERE ID =" + ID;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to search for animals in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * values
     * @return A LinkedList which contains the searched animal objects
     */
    public LinkedList<Animal> searchAnimals(LinkedHashMap<String, String> columnValueMap) {

        LinkedList<Animal> animals = null;

        String begin = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name AS CompoundName,visibleForGuest\n"
                + "FROM Animal\n"
                + "INNER JOIN  Compound ON Animal.CompoundID = Compound.ID \n"
                + "INNER JOIN Species ON Animal.speciesID = Species.ID WHERE";
        String query = zooManager.generateSearchQuery(columnValueMap, begin,"Animal.ID");

        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            animals = createAnimals(resultSet);

        } else {
            return this.getAnimals();
        }
        return animals;
    }

    /**
     * Method which has been implemented to create an animal data structure from
     * a resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList of animal objects depending of the result set
     */
    private LinkedList<Animal> createAnimals(ResultSet resultSet) {

        LinkedList<Animal> animals = new LinkedList<Animal>();

        if (resultSet != null) {
            try {
                while (resultSet.next()) {

                    int animalID = resultSet.getInt("ID");
                    String animalName = resultSet.getString("animalName");
                    String sex = resultSet.getString("Sex");
                    Date birthday = resultSet.getDate("Birthday");
                    String descriptionStr = resultSet.getString("Description");
                    String compoundName = resultSet.getString("CompoundName");
                    String visibility = resultSet.getString("visibleForGuest");
                    Methods methods = new Methods();
                    Description description = methods.stringToDescription(descriptionStr);

                    Species species = new Species(-1, description);
                    //Creating corresponding object,-1 used as undefined value
                    Compound compound = new Compound(compoundName);
                    Animal animal = new Animal(animalID, animalName, birthday, sex, compound, species,visibility);
                    animals.add(animal);
                }
            } catch (SQLException e) {
                System.err.println("SQL Exception in createAnimals()");
                System.out.println(e.getMessage());
            }
        }
        return animals;
    }
}