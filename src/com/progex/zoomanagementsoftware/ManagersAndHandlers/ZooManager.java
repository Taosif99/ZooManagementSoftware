package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This class serves as main interface to our zoo management software.
 */
public class ZooManager {

    private UserManager userManager;
    private GuestModeManager guestModeManager;
    private ConnectionHandler connectionHandler;
    private CompoundManager compoundManager;
    private AnimalManager animalManager;
    private FoodToAnimalManager foodToAnimalManager;
    private ZookeeperToAnimalManager zookeeperToAnimalManager;
    private FoodManager foodManager;

    /**
     * Method to initalize our ZooManagement Interface, requires the MySql
     * database information for initalizing connection.
     *
     * @param url
     * @param username
     * @param password
     * @param dbName
     */
    public ZooManager(String url, String dbName, String username, String password) {

        connectionHandler = new ConnectionHandler(url, dbName, username, password);
        guestModeManager = new GuestModeManager(connectionHandler);
        userManager = new UserManager(connectionHandler, this);
        compoundManager = new CompoundManager(connectionHandler, this);
        animalManager = new AnimalManager(connectionHandler, this);
        foodToAnimalManager = new FoodToAnimalManager(connectionHandler, this);
        foodManager = new FoodManager(connectionHandler, this);
        zookeeperToAnimalManager = new ZookeeperToAnimalManager(connectionHandler, this);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public GuestModeManager getGuestModeManager() {
        return guestModeManager;
    }

    public CompoundManager getCompoundManager() {
        return compoundManager;
    }

    public AnimalManager getAnimalManager() {
        return animalManager;
    }

    public FoodToAnimalManager getFoodToAnimalManager() {
        return foodToAnimalManager;
    }

    public ZookeeperToAnimalManager getZookeeperToAnimalManager() {
        return zookeeperToAnimalManager;
    }

    public FoodManager getFoodManager() {
        return foodManager;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    /**
     *
     * Method which constructs a search query using the parameters and regular
     * expressions. Please consider side possible side effects!
     *
     * @param columnValueMap
     * @param queryBegin
     * @param orderByValue
     * @return The query as String, null if no String can be built
     */
    public String generateSearchQuery(LinkedHashMap<String, String> columnValueMap, String queryBegin, String orderByValue) {

        LinkedHashMap<String, String> nonEmptyColumnValueMap = new LinkedHashMap<String, String>();

        try {

            //Remove empty or null textFields
            for (Entry<String, String> entry : columnValueMap.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                if (!value.isEmpty()) {
                    nonEmptyColumnValueMap.put(key, value);
                }
            }

            StringBuilder querySb = new StringBuilder();
            querySb.append(queryBegin).append(" ");
            Set<Map.Entry<String, String>> entries = nonEmptyColumnValueMap.entrySet();

            //get the iterator for entries
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();

            //Adding first entry
            Entry<String, String> firstEntry = iterator.next();

            String columnName = firstEntry.getKey();
            String value = firstEntry.getValue();
            querySb.append(columnName).append(" REGEXP '").append(value).append("'");

            //Removing first entry
            nonEmptyColumnValueMap.remove(columnName);

            for (Entry<String, String> entry : nonEmptyColumnValueMap.entrySet()) {

                columnName = entry.getKey();
                value = entry.getValue();
                querySb.append(" AND ").append(columnName).append(" REGEXP '").append(value).append("'");
            }

            if (orderByValue != null) {

                querySb.append(" ORDER BY ").append(orderByValue);
            }

            System.out.println(querySb.toString());
            return querySb.toString();

        } catch (NoSuchElementException noSuchElementException) {

            System.err.println("LinkedHashMap value empty or null, handled Exception in generateSearchQuery()");
            System.out.println(noSuchElementException.getMessage());
            return null;
        }
    }
}