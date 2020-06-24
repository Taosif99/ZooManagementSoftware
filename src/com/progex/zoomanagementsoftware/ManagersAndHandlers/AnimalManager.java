
package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.Animal;
import com.progex.zoomanagementsoftware.datatypes.Compound;
import com.progex.zoomanagementsoftware.datatypes.Description;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.Species;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 *Class which handles animals in our program.
 * @author Ouchen
 */
public class AnimalManager {
    
    
    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;
    

    public AnimalManager( ConnectionHandler connectionHandler,ZooManager zooManager) {
        
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
        
    }
    
    
    /*Methods concerning Managing Animal start here*/
    /**
     * Method to get the required values of the admin view.
     *
     * @return A LinkedList of Animal objects which contains all animals which
     * are stored in the database
     */
    public LinkedList<Animal> getAnimals() {

        String query = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName\n"
                + "FROM Animal,Compound,Species\n"
                + "WHERE Animal.CompoundID = Compound.ID AND\n"
                + "Animal.SpeciesID = Species.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<Animal> animals = createAnimals(resultSet);

        return animals;
    }

    /**
     * Method to add an Animal to the database.
     *
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @return true if successfull, else false
     */
    public boolean addAnimal(String animalName, String compoundName, String birthday, String sex, String species) {

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
            querySB.append("INSERT INTO Animal(CompoundID,SpeciesID,AnimalName,Birthday,Sex) ")
                    .append("VALUES (").append(compoundID).append(",").append(speciesID)
                    .append(",").append("'").append(animalName).append("'").append(",")
                    .append("'").append(birthday).append("'").append(",").append("'").append(sex).append("'").append(")");
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
     * Method to update an Animal in the database.
     *
     * @param ID
     * @param animalName
     * @param compoundName
     * @param birthday
     * @param sex
     * @param species
     * @return true if update operation successful,else false
     */
    public boolean updateAnimal(int ID, String animalName, String compoundName, String birthday, String sex, String species) {

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
                    .append("Sex = ").append("'").append(sex).append("' ")
                    .append(" WHERE ID = ").append(ID);

            String query = querySB.toString();
            System.out.println(query);
            boolean retVal = connectionHandler.manipulateDB(query);
            return retVal;

        } catch (SQLException ex) {

            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Method which has been implemented to delete an Animal from the database.
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
     * @return A LinkedList which contains the searhed animal objects
     */
    public LinkedList<Animal> searchAnimals(LinkedHashMap<String, String> columnValueMap) {

        LinkedList<Animal> animals = null;

        String begin = "SELECT Animal.ID,Animal.AnimalName,Animal.Sex,Animal.Birthday,Species.Description,Compound.Name as CompoundName\n"
                + "FROM Animal\n"
                + "INNER JOIN  Compound ON Animal.CompoundID = Compound.ID \n"
                + "INNER JOIN Species ON Animal.speciesID = Species.ID WHERE";
        String query = zooManager.generateSearchQuery(columnValueMap, begin);

        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            animals = createAnimals(resultSet);

        } else {
            return this.getAnimals();
        }
        return animals;

    }

    /**
     * *
     * Method which has been implemented to create an Animal datastructure from
     * a resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList of Animal objects depending of the result set
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

                    Methods methods = new Methods();
                    Description description = methods.stringToDescription(descriptionStr);

                    Species species = new Species(-1, description);
                    //Creating corresponding object,-1 used as undefined value
                    Compound compound = new Compound(-1, -1, -1, -1, -1, compoundName);
                    Animal animal = new Animal(animalID, animalName, birthday, sex, compound, species);
                    animals.add(animal);
                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());

            }
        }
        return animals;
    }

    /*Methods concerning animal end here*/
}
