
package com.progex.zoomanagementsoftware.datatypes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JLabel;

/**
 *
 *This class shall general provide methods for the Implementation
 * If they cannot be assigned to a concrete Class
 */

public class Methods {
    
           
     public Methods(){
     
     }
      
      
      
 /**
 *  Method which changes time every 60 seconds
 * @param jLabelShowTime The label in which current time and date shall be shown
 */
        public void showTimeAndDate(JLabel jLabelShowTime) {
       
            
            Date date = new Date();        
            SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String dateAndTime = s.format(date);
            String dateString = dateAndTime.substring(0,10);
            String dateTime = dateAndTime.substring(11,16);
            //System.out.println(dateAndTime); //Debug
            jLabelShowTime.setText("Zeit: "+ dateTime +" Datum: " +dateString);  
           
           //Each Minute get current Time 60000 
           new Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();        
                SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String dateAndTime = s.format(date);
                String dateString = dateAndTime.substring(0,10);
                String dateTime = dateAndTime.substring(11,16);
                //System.out.println(dateAndTime); //Debug
                jLabelShowTime.setText("Zeit: "+ dateTime +" Datum: " +dateString);                 
            }
        }).start();
    }
}
