package com.progex.zoomanagementsoftware.datatypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * This class shall general provide methods for the Implementation If they
 * cannot be assigned to a concrete Class
 */
public class Methods {

    public Methods() {

    }

    /**
     * This method is used to remove all data from a table.
     * @param table
     */
    public void clearTable(DefaultTableModel table)
    {     
        while (table.getRowCount() > 0) {
            table.removeRow(0);
        }
    }
    
    
    /**
     * Method which changes time every 60 seconds
     *
     * @param jLabelShowTime The label in which current time and date shall be
     * shown
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

    /*Method to verify that the user input fields (withoud ID) are not empty*/
    public boolean verifyTextFields(JTextField[] textFields) {
        
        try {
            //Remove trailing and leading Textfields and check if Field is empty
            for (JTextField textField : textFields) {
                textField.setText(textField.getText().trim());
                if (textField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Bitte alle notwendigen Werte eintragen!", "Textfeld ohne Inhalt", JOptionPane.CANCEL_OPTION);
                    return false;
                }
            }
        } catch(NullPointerException e)
        {
            e.getMessage();
        }

        return true;
    }
    
    /**
     * Method to get the corresponding description enum of an Animal
     *
     * @param descriptionStr
     * @return The correspondig enum to the description String
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
     * Method to convert a description enum to its corresponding "german" value.
     *
     * @param description
     * @return The description as String
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
     * Method which has been implemented to convert a salutation String 
     * to an enum type
     * @param salutationStr
     * @return The corresponding salutation
     */
    public Salutation stringToSalutation(String salutationStr){
    
        switch (salutationStr) {
            case "Frau":
                return Salutation.mrs;
            case "Herr":
                return Salutation.mr;
            default:
                return Salutation.diverse;
        }
    
    }
    
    /**
     * Method which has been implemented to convert a Salutation enum
     * to a String
     * @param salutation
     * @return The corresponding salutation if mapping is possible, else an empty String
     */
    public String salutationToString(Salutation salutation){
       
        if (null == salutation) return "";
        else switch (salutation) {
            case mr:
                return "Herr";
            case mrs:
                return "Frau";
            case diverse:
                return "divers";
            default:
                return "";
        }
    }
    
    /**
     * Method which has been implemented to convert a shift String 
     * to an enum type -> Vielleicht besser wenn wir es in der Datenbank auf deutsch haben ???
     * @param shiftStr
     * @return The corresponding shift,null if it does not exist
     */
    public Shift stringToShift(String shiftStr){
    
        switch (shiftStr) {
            case "None":
                return Shift.none;
            case "Night":
                return Shift.night;
            case "Afternoon":
                return Shift.afternoon;
            case "Morning":
                return Shift.morning;
        }
    
        return null;
    }
    
    
    
    
    
    /**
     * Method which has been implemented to convert a Shift enum
     * to a String
     * @param shift
     * @return The corresponding shift as String if mapping is possible, else an empty String
     */
    public String shiftToString(Shift shift){
       
        
        if (null == shift) return "";
        else switch (shift) {
            case none:
                return "KEINE";
            case night:
                return "Spät";
            case afternoon:
                return "Nachmittag";
            case morning:
                return "Früh";
            default:
                return "";
        }
    }

    public void fullscreen() {

    }
}
