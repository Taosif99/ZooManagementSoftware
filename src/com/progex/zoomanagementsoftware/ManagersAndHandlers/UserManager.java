package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.datatypes.Admin;
import com.progex.zoomanagementsoftware.datatypes.User;
import com.progex.zoomanagementsoftware.datatypes.Zookeeper;
import com.progex.zoomanagementsoftware.datatypes.ZookeeperInfo;

/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    /*Removed loggedInUser TODO DIAGRAM*/
    public UserManager(ConnectionHandler connectionHandler) {
        this.loggedInUser = null;
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
