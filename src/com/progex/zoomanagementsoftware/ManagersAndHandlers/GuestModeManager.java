package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class which handles feeding information.
 */
public class GuestModeManager {

    private ConnectionHandler connectionHandler;

    /**
     * Creates a GuestModeManager with corresponding reference to connection handler.
     * @param connectionHandler
     */  
    public GuestModeManager(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;

    }

    /*If User choose a animal, this is the function for the table(compound,start/end feedingtime, food.*/

    /**
     * Method to return FeedingInfo for ChooseAnimalJframe.
     *
     * @param animal
     * @return LinkedList FeedingInfos with attributes :
     * compound,startFeedingTime,endFeedingTime,food or null
     * @throws ParseException
     */
    public LinkedList<FeedingInfo> getAnimalFeedingInfos(String animal) throws ParseException {

        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "Select compound.name as Gehege ,eats.StartFeedingTime, eats.EndFeedingTime,food.name as Essen "
                + "FROM animal,eats,food,compound "
                + "WHERE eats.AnimalID = animal.ID AND animal.animalname = '" + animal + "'AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID Order by StartFeedingTime ASC";
        ResultSet resultFeeding = connectionHandler.performQuery(query);

        if (resultFeeding != null) {

            try {
                while (resultFeeding.next()) {

                    //Date von Datenbank in String umwandeln
                    //Date erstellen mit Spalte startfeedingtime von Datenbank
                    java.util.Date datestart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("StartFeedingTime"));
                    //in Timestamp umwandeln
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(datestart.getTime());

                    //als String um Datum zu vergleichen
                    String times = timestampstart.toString();
                    String tmp = times.substring(0, 10);
                    //Datum von heute in compStamp bzw tmpTwo speichern

                    java.sql.Timestamp compStamp = new java.sql.Timestamp(System.currentTimeMillis());
                    String tmpTwo = compStamp.toString().substring(0, 10);

                    //wenn Datum gleich heute dann erst adden
                    if (tmpTwo.equals(tmp)) {

                        String timeStart = times.substring(11, 16);

                        String com = resultFeeding.getString("Gehege");

                        java.util.Date dateend = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("EndFeedingTime"));
                        java.sql.Timestamp timestampend = new java.sql.Timestamp(dateend.getTime());
                        String timee = timestampend.toString();
                        String timeEnd = timee.substring(11, 16);

                        String food = resultFeeding.getString("Essen");

                        FeedingInfo newFeedingInfo = new FeedingInfo(com, timeStart, timeEnd, food);
                        feedingInfos.add(newFeedingInfo);
                    }
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }

        return feedingInfos;

    }

    /*get all animals in db.*/

    /**
     * Method to return all distinct animals in a database.
     *
     * @return LinkedList with animals or null
     */
    public LinkedList<String> getAnimals() {

        LinkedList<String> animals = new LinkedList<String>();
        String query = "Select Distinct animalName from animal";
        ResultSet resultAnimals = connectionHandler.performQuery(query);

        if (resultAnimals != null) {

            try {
                while (resultAnimals.next()) {
                    String animalName = resultAnimals.getString("animalName");
                    animals.add(animalName);

                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }
        return animals;

    }

    /*get all available feedingtimes.*/
    /**
     * Method to return all available times for ChooseAnimalAndTimeJFrame.
     *
     * @return LinkedList with all available times in database from today or null
     *
     */
    public LinkedList<String> getTimes() {
        LinkedList<String> times = new LinkedList<String>();
        String query = "Select distinct startFeedingTime from eats order by startFeedingTime ASC";
        ResultSet resultTimes = connectionHandler.performQuery(query);

        if (resultTimes != null) {

            try {
                while (resultTimes.next()) {

                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultTimes.getString("startFeedingTime"));
                    //in Timestamp umwandeln
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(date.getTime());

                    //als String um Datum zu vergleichen
                    String time = timestampstart.toString();
                    String tmp = time.substring(0, 10);
                    //Datum von heute in compStamp bzw tmpTwo speichern

                    java.sql.Timestamp compStamp = new java.sql.Timestamp(System.currentTimeMillis());
                    String tmpTwo = compStamp.toString().substring(0, 10);

                    if (tmpTwo.equals(tmp)) {
                        String timeStart = time.substring(11, 16);
                        times.add(timeStart);

                    }

                }
            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            } catch (ParseException ex) {
                System.err.println("ParseException");
                System.out.println(ex.getMessage());
            }

        }
        return times;

    }

    /*If User choose a time, this is the function for the table(animalName,compund and food.*/
    /**
     * Method to return TimefeedingInfo for ChooseTimeJFrame.
     *
     * @param feedingTime
     * @return Linked List with FeedingInfos attributes : animal,compound,food or null
     */
    public LinkedList<FeedingInfo> getTimeFeedingInfo(String feedingTime) {

        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();

        String query = "Select distinct animalName, compound.name as gehege,food.name as essen From animal,compound,food,eats WHERE eats.AnimalID = animal.ID AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID AND eats.StartFeedingTime = '" + feedingTime + "'";//TODO
        ResultSet resultFeeding = connectionHandler.performQuery(query);

        if (resultFeeding != null) {
            try {
                while (resultFeeding.next()) {

                    String animal = resultFeeding.getString("animalName");

                    String com = resultFeeding.getString("gehege");

                    String food = resultFeeding.getString("essen");

                    FeedingInfo newFeedingInfo = new FeedingInfo(animal, com, food);
                    feedingInfos.add(newFeedingInfo);
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }

        return feedingInfos;
    }

    /*If User choose a animal and time, this is the function for the labels food and compound.*/
    /**
     * Method to return feedingInfo for ChooseBothJFrame.
     *
     * @param feedingTime
     * @param animalName
     * @return LinkedList feedingInfo with attributes from Class feedingInfo :
     * compound, food or null
     */
    public LinkedList<FeedingInfo> getAnimalTimeFeedingInfo(String feedingTime, String animalName) {

        LinkedList<FeedingInfo> feedingInfos = new LinkedList<FeedingInfo>();
        String query = "Select compound.name as gehege,food.name as essen FROM compound,food,eats,animal WHERE eats.AnimalID = animal.ID AND eats.FoodID = food.ID AND animal.CompoundID = compound.ID AND eats.StartFeedingTime = '" + feedingTime + " 'AND AnimalName = '" + animalName + "'";
        ResultSet resultFeeding = connectionHandler.performQuery(query);

        if (resultFeeding != null) {
            try {
                while (resultFeeding.next()) {

                    String com = resultFeeding.getString("gehege");

                    String food = resultFeeding.getString("essen");

                    FeedingInfo newFeedingInfo = new FeedingInfo(com, food);

                    feedingInfos.add(newFeedingInfo);
                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            }
        }

        return feedingInfos;
    }

    /**
     * Method to return a distinct feedingtime for ChooseAnimalAndTimeJFrame.
     *
     * @param animal
     * @return LinkedList with all unique feeding times or null
     */
    public LinkedList<String> getUniqueFeedingTimes(String animal) {

        LinkedList<String> feedingTimes = new LinkedList<String>();
        String query = "Select distinct eats.StartFeedingTime "
                + "FROM animal,eats,food "
                + "WHERE eats.AnimalID = animal.ID AND animal.animalname = '" + animal + "' AND eats.FoodID = food.ID Order by StartFeedingTime ASC;";
        ResultSet resultFeeding = connectionHandler.performQuery(query);

        if (resultFeeding != null) {

            try {
                while (resultFeeding.next()) {

                    //Date von Datenbank in String umwandeln
                    //Date erstellen mit Spalte startfeedingtime von Datenbank
                    java.util.Date datestart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultFeeding.getString("StartFeedingTime"));
                    //in Timestamp umwandeln
                    java.sql.Timestamp timestampstart = new java.sql.Timestamp(datestart.getTime());

                    //als String um Datum zu vergleichen
                    String times = timestampstart.toString();
                    String tmp = times.substring(0, 10);
                    //Datum von heute in compStamp bzw tmpTwo speichern

                    java.sql.Timestamp compStamp = new java.sql.Timestamp(System.currentTimeMillis());
                    String tmpTwo = compStamp.toString().substring(0, 10);

                    //wenn Datum gleich heute dann erst adden
                    if (tmpTwo.equals(tmp)) {

                        String timeStart = times.substring(11, 16);

                        feedingTimes.add(timeStart);
                    }

                }

            } catch (SQLException e) {
                System.err.println("SQL exception");
                System.out.println(e.getMessage());
            } catch (ParseException ex) {
                System.err.println("ParseException");
                System.out.println(ex.getMessage());
            }

        }

        return feedingTimes;

    }

}
