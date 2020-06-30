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
import javax.swing.table.DefaultTableModel;

//For email checking
import java.util.regex.Pattern; 
import javax.swing.JTable;

/**
 *
 * This class shall general provide methods for the Implementation If they
 * cannot be assigned to a concrete Class.
 */
public class Methods {

    public Methods() {

    }

    //Mustapha start
    
    /**
     * Method which changes time every second.
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
        
        //Each Second get current Time (1000ms) 
        new Timer(1000, new ActionListener() {

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
     * Method to verify that the user inputs are not empty.
     *
     * @param textFields
     * @return true if trimmed textfields not blank, else false
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
     * Method to get the corresponding description enum of an Animal.
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
     * @return The description as String, null no matches found.
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
     * @return The corresponding salutation,diverse if it is not mr or mrs.
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
     * to a String.
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
                return "Divers";
            default:
                return "";
        }
    }
    
    
    /**TODO
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
     * to a String.
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
    

    
       
    /**
     * Method to check if a given date has the format ""yyyy-MM-dd".
     * @param dateString
     * @return true if pattern is valid, else false
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
     * with the format: YYYY-MM-DD HH:MI:SS.
     * @param dateString
     * @return The formated String with YYYY-MM-DD HH:MI
     */
   public String removeSeconds(String dateString){
       
        return dateString.substring(0,16);
   }
   
   
   /**
    * Method to check if a feeding time string representation corresponds to the
    * value format of the database.
    * @param feedingTime
    * @return True if format is yyyy-MM-dd HH:mm:ss, else false
    */
   public boolean isValidFeedingTime(String feedingTime){
   
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        if (feedingTime.length()> pattern.length()) return false;
        try {
            new SimpleDateFormat(pattern).parse(feedingTime);
            return true;
        } catch (ParseException e) {
            return false;
        }
   }
   
   
   
   /**
    * Method to check if end feeding time comes after starts feeding time.
    * @param startFeedingTime
    * @param endFeedingTime
    * @return true if end feeding time is greater than start, else false
    */
   public boolean isFeedingTimesGreater(String startFeedingTime, String endFeedingTime){
   
       String pattern = "yyyy-MM-dd HH:mm:ss";
        try {
            Date start = new SimpleDateFormat(pattern).parse(startFeedingTime);
             Date end = new SimpleDateFormat(pattern).parse(endFeedingTime);
        
           return end.after(start);
        
        } catch (ParseException ex) {
            
            
            System.err.println("Parsing Exception");
            System.out.println(ex.getMessage());
            
            
        }
       
        return false;
        
        
     }
   
   
     /**
      * Method to check if a Email has a valid pattern.
      * Regular expression from: https://owasp.org/www-community/OWASP_Validation_Regex_Repository
      * @param email
      * @return true if pattern is right, else false
      */
     public boolean isValidEmail(String email) 
    { 
        String emailRegularExpression = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pattern = Pattern.compile(emailRegularExpression); 
        if (email == null) 
            return false; 
        return pattern.matcher(email).matches(); 
    } 
   
     /**
      * Method to remove ".0" from a number.
      * @param doubleStr
      * @return The string without .0 ,else the unchanged string
      */
     public String removeComma(String doubleStr){
         
         
         if(doubleStr.endsWith(".0")){
             String returnStr = doubleStr.substring(0, doubleStr.length()-2);    
             return returnStr;
         }
         return doubleStr;
     }
     

      /**
     * This method is used to remove all data from a Jtable.
     * @param table
     */
    public void clearTable(JTable table)
    {  
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }
    }
   

    /**
     * TODO
     * @param time
     * @return 
     */
    public String cutTimeNextFeeding(String time){
        
        String formattedTime = time.substring(10, 16);        
        return formattedTime;
        
    }
    
}
