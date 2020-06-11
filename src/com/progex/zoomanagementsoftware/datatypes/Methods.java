package com.progex.zoomanagementsoftware.datatypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * This class shall general provide methods for the Implementation If they
 * cannot be assigned to a concrete Class
 */
public class Methods {

    public Methods() {

    }

    /**
     * Method which changes time every 60 seconds
     *
     * @param jLabelShowDateTime The label in which current time and date shall
     * be shown
     */
    public void showTimeAndDate(JLabel jLabelShowDateTime) {

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateAndTime = s.format(date);
        String dateString = dateAndTime.substring(0, 10);
        String dateTime = dateAndTime.substring(11, 16);
        //System.out.println(dateAndTime); //Debug
        jLabelShowDateTime.setText("Zeit: " + dateTime + " Datum: " + dateString);

        //Each Minute get current Time 60000 
        new Timer(60000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String dateAndTime = s.format(date);
                String dateString = dateAndTime.substring(0, 10);
                String dateTime = dateAndTime.substring(11, 16);
                //System.out.println(dateAndTime); //Debug
                jLabelShowDateTime.setText("Zeit: " + dateTime + " Datum: " + dateString);
            }
        }).start();
    }

    /**
     * Method to verify that the user inputs are not empty
     *
     * @param textFields
     * @return
     */
    public boolean verifyTextFields(JTextField[] textFields) {

        //Remove trailing and leading Textfields and check if Field is empty
        for (JTextField textField : textFields) {
            textField.setText(textField.getText().trim());
            if (textField.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Bitte alle notwendigen Werte eintragen !", "Textfeld ohne Inhalt", JOptionPane.CANCEL_OPTION);
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the corresponding description enum of an Animal
     *
     * @param descriptionStr
     * @return
     */
    public Description stringToDescription(String descriptionStr) {

        Description description = null;
        switch (descriptionStr) {

            case "Säugetier":
                description = Description.mammal;
                break;
            case "Fisch":
                description = Description.fish;
                break;
            case "Vogel":
                description = Description.bird;
                break;
            case "Amphibie":
                description = Description.amphibian;
                break;
            case "Reptil":
                description = Description.reptile;
                break;
            case "Insekt":
                description = Description.insect;
                break;
            case "Spinnentier":
                description = Description.arachnid;
                break;
            case "Wirbellos":
                description = Description.invertebrate;
                break;
        }

        return description;
    }

    /**
     * Method to convert a description enum to its corresponding "german" value
     *
     * @param description
     * @return
     */
    public String descriptionToString(Description description) {

        String descriptionStr = null;

        switch (description) {

            case fish:
                descriptionStr = "Fisch";
                break;
            case bird:
                descriptionStr = "Vogel";
                break;
            case mammal:
                descriptionStr = "Säugetier";
                break;
            case amphibian:
                descriptionStr = "Amphibie";
                break;
            case reptile:
                descriptionStr = "Reptil";
                break;
            case insect:
                descriptionStr = "Insekt";
                break;
            case arachnid:
                descriptionStr = "Spinnentier";
                break;
            case invertebrate:
                descriptionStr = "Wirbellos";
                break;
        }

        return descriptionStr;

    }

    /**
     * Method to check if a given date has the format ""yyyy-MM-dd
     * @param dateString
     * @return 
     */
    public boolean isValidDateString(String dateString) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            new SimpleDateFormat(pattern).parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

   
    /**
     * Method to remove the seconds From da String 
     * with the format: YYYY-MM-DD HH:MI:SS
     * @param dateString
     * @return 
     */
   public String removeSeconds(String dateString){
   
        return dateString.substring(0,16);
   }
    
}
