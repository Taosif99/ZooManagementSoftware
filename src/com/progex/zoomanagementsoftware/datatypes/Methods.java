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

                    JOptionPane.showMessageDialog(null, "Bitte alle notwendigen Werte eintragen!", "Textfeld ohne Inhalt.", JOptionPane.CANCEL_OPTION);
                    return false;
                }
            }
        } catch(NullPointerException e)
        {
            e.getMessage();
        }

        return true;
    }

    public void fullscreen() {

    }
}
