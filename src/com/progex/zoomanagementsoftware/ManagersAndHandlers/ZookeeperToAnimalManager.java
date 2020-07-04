package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.ZookeeperToAnimalR;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Class which handles the the zookeeper to animal relation in our program.
 */
public class ZookeeperToAnimalManager {

    private ConnectionHandler connectionHandler;
    private ZooManager zooManager;

    /**
     * Creates an ZookeeperToAnimalManager with corresponding reference to
     * connection and main interface handlers.
     *
     * @param connectionHandler
     * @param zooManager
     */
    public ZookeeperToAnimalManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }

    /**
     * This method is used to get all animal ids with the same animal name.
     *
     * @param animalName
     * @return A LinkedList of animal ids
     */
    public LinkedList<Integer> getAnimalIds(String animalName) {

        LinkedList<Integer> animalIds = new LinkedList<>();

        try {

            String query = "SELECT id FROM animal WHERE animalName = '" + animalName + "'";

            System.out.println(query);
            ResultSet resultSet = connectionHandler.performQuery(query);
            if (resultSet != null) {
                while (resultSet.next()) {
                    animalIds.add(resultSet.getInt("id"));
                }
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in getAnimalIds()");
            System.out.print(sqlException.getMessage());
        }
        return animalIds;
    }

    /**
     * This method is used to add a takes care relation.
     *
     * @param animalIds
     * @param zookeeperId
     * @return If true the operation was successfull, else false
     */
    public boolean addZookeeperToAnimal(LinkedList<Integer> animalIds, String zookeeperId) {
        String query;
        for (Integer animalId : animalIds) {
            query = "INSERT INTO takesCare(UserID,AnimalID) VALUES(" + zookeeperId + "," + animalId + ")";
            if (!connectionHandler.manipulateDB(query)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to delete a takes care relation.
     *
     * @param animalIds
     * @param zookeeperId
     * @return If true the operation was successfull, else false
     */
    public boolean deleteZookeeperToAnimal(LinkedList<Integer> animalIds, int zookeeperId) {

        boolean retVal = false;
        String query;
        for (Integer animalId : animalIds) {
            query = "DELETE FROM takesCare WHERE userId = " + zookeeperId + " AND animalId = " + animalId;
            retVal = connectionHandler.manipulateDB(query);
        }
        return retVal;
    }

    private LinkedList<ZookeeperToAnimalR> createZookeeperToAnimal(ResultSet resultSet) {

        LinkedList<ZookeeperToAnimalR> records = new LinkedList<>();
        try {
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                int animalId = resultSet.getInt("animalId");
                String animalName = resultSet.getString("animalName");
                ZookeeperToAnimalR record = new ZookeeperToAnimalR(userId, firstname, lastname, animalId, animalName);
                records.add(record);
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception in createZookeeperToAnimal()");
            System.out.print(sqlException.getMessage());
        }
        return records;
    }

    /**
     * This method is used to search for takes care relations in the database.
     *
     * @param columnValueMap
     * @return A LinkedList which contains the searched takes care relations.
     */
    public LinkedList<ZookeeperToAnimalR> searchZookeeperToAnimal(LinkedHashMap<String, String> columnValueMap) {

        String begin = "SELECT takescare.UserID, user.firstname, user.lastname, takescare.AnimalID, animal.AnimalName\n"
                + "FROM takescare\n"
                + "INNER JOIN user ON takescare.UserID = user.id\n"
                + "INNER JOIN animal ON takescare.AnimalID = animal.ID WHERE ";

        String query = zooManager.generateSearchQuery(columnValueMap, begin, "animal.ID");
        System.out.println(query);
        LinkedList<ZookeeperToAnimalR> records;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            records = createZookeeperToAnimal(resultSet);
        } else {
            return this.getZookeeperToAnimalR();
        }
        return records;
    }

    /**
     * Method which has been implemented to get all requiered information for
     * the zookeeper to animal relation.
     *
     * @return The corresponding records saved in a LinkedList
     */
    public LinkedList<ZookeeperToAnimalR> getZookeeperToAnimalR() {

        String query = "SELECT takescare.UserID, user.firstname, user.lastname, takescare.AnimalID, animal.AnimalName\n"
                + "FROM takescare\n"
                + "INNER JOIN user ON takescare.UserID = user.id\n"
                + "INNER JOIN animal ON takescare.AnimalID = animal.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<ZookeeperToAnimalR> records = createZookeeperToAnimal(resultSet);
        return records;
    }

    /**
     * This method is used to check if the takes care relation exists.
     *
     * @param animalName
     * @param zookeeperId
     * @return True if the relation exists and false if the relation does not
     * exist
     */
    public boolean checkZookeeperToAnimalExists(String animalName, int zookeeperId) {

        LinkedList<Integer> animalIds = getAnimalIds(animalName);
        String query;

        try {
            ResultSet resultSet;

            for (Integer animalId : animalIds) {
                query = "SELECT * FROM takesCare WHERE userId = " + zookeeperId + " AND animalId = " + animalId;
                resultSet = connectionHandler.performQuery(query);

                if (resultSet != null) {
                    if (resultSet.next()) {
                        return true;
                    }
                }
            }
        } catch (SQLException sqlException) {

            System.err.println("SQL Exception in checkZookeeperToAnimalExists()");
            System.out.print(sqlException.getMessage());
        }
        return false;
    }
}