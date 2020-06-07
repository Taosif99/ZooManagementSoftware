package com.progex.zoomanagementsoftware.datatypes;

/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    public UserManager(User loggedInUser, ConnectionHandler connectionHandler) {
        this.loggedInUser = loggedInUser;
        this.connectionHandler = connectionHandler;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setConnectionHandler(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }
    

    public void addAdmin(Admin admin) {

    }

    public void addZookeeper(Zookeeper zookeeper) {

    }

    public void deleteUser(int id) {

    }

    public void performQuery(String query, String message) {

    }

    public boolean loginAdmin(String userName, String password) {
        return false;
    }

    public boolean loginZookeeper(String userName, String password) {
        return false;
    }

    public void logout() {

    }

    public ZookeeperInfo createZookeeperInfo() {
        return null;
    }

}
