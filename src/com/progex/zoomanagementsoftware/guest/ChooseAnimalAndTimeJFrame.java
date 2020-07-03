
package com.progex.zoomanagementsoftware.guest;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ConnectionHandler;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.GuestModeManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ChooseAnimalAndTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChooseAnimalAndTimeJFrame
     * @param goBackFrame
     * @param zooManager
     */
    public ChooseAnimalAndTimeJFrame(JFrame goBackFrame, ZooManager zooManager) {

        initComponents();
        myInitComponents();
        
        
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.guestModeManager = zooManager.getGuestModeManager();

        //Fulfill Comboboxes
        SetComboxAnimals();
        SetComboxTime();

    }

    
    /* Individual initialization*/
    private void myInitComponents() {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        
        if (x == 1920 && y == 1080) {
            
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18));
            

        }
        if (x == 1280 && y == 720) {
            
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 16));

            

        }
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //get Date
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
      
        

        jButtonSearch.setEnabled(false);

    }

    /*Fullfil Combobox with animals*/
    private void SetComboxAnimals() {

        LinkedList<String> animals = guestModeManager.getAnimalNames();

        String[] anames = new String[animals.size() + 1];
        anames[0] = "Tier auswählen";

        for (int i = 0; i < animals.size(); i++) {

            anames[i + 1] = animals.get(i);

        }
        DefaultComboBoxModel defaultTableModel = new DefaultComboBoxModel(anames);
        jComboBoxName.setModel(defaultTableModel);

    }

    /*Fullfil Combobox with available feeding times*/
    private void SetComboxTime() {

        LinkedList<String> times;
     
            times = guestModeManager.getAvailableFeedingTimes();
            

            String[] atimes = new String[times.size() + 1];
            atimes[0] = "Zeit auswählen";

            for (int i = 0; i < times.size(); i++) {

                atimes[i + 1] = times.get(i);

            }
            DefaultComboBoxModel defaultTableModel = new DefaultComboBoxModel(atimes);
            jComboTime.setModel(defaultTableModel);
            
            
                

        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBack = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelFindOut = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jComboTime = new javax.swing.JComboBox<>();
        jLabelChoose = new javax.swing.JLabel();
        jLabelAnimal = new javax.swing.JLabel();
        jComboBoxName = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jButtonBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonBack.setText("Zurück");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelShowDateTime.setText("Time");

        jLabelFindOut.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelFindOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFindOut.setText("Finde heraus wann welches Tier gefüttert wird");
        jLabelFindOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTime.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabelTime.setText("Verfügbare Fütterungszeiten :");
        jLabelTime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jComboTime.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboTime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTimeActionPerformed(evt);
            }
        });

        jLabelChoose.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelChoose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChoose.setText("Bitte treffen Sie mindestens eine Auswahl");
        jLabelChoose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelAnimal.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabelAnimal.setText("Tiername :");

        jComboBoxName.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jComboBoxName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNameActionPerformed(evt);
            }
        });

        jButtonSearch.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButtonSearch.setText("Suchen");
        jButtonSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelFindOut, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime)
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabelChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(211, 211, 211))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTime)
                            .addComponent(jLabelAnimal))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowDateTime))
                .addGap(35, 35, 35)
                .addComponent(jLabelFindOut, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabelTime.getAccessibleContext().setAccessibleName("");
        jComboTime.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNameActionPerformed
        
        //Search button visible or not
        String animal = jComboBoxName.getSelectedItem().toString();
        String feedingTime = jComboTime.getSelectedItem().toString();
        
        if (!feedingTime.equals("Zeit auswählen") || !animal.equals("Tier auswählen")) {
            jButtonSearch.setEnabled(true);
        } else {
            jButtonSearch.setEnabled(false);
        }
        //If Animal choosed, load times only the available times
        if (!animal.equals("Tier auswählen")) {

          
                LinkedList<String> times = guestModeManager.getUniqueFeedingTimes(animal);

                String[] timesArr = new String[times.size()+1];
                timesArr[0] = "Zeit auswählen";
                
                for (int i = 0; i < times.size(); i++) {

                    timesArr[i+1] = times.get(i);
                }

                DefaultComboBoxModel defaultTableModel = new DefaultComboBoxModel(timesArr);
                jComboTime.setModel(defaultTableModel);

         

        } else {

            SetComboxTime();

        }


    }//GEN-LAST:event_jComboBoxNameActionPerformed

    private void jComboTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTimeActionPerformed
        //Search button visible or not
        String animal = jComboBoxName.getSelectedItem().toString();
        String feedingTime = jComboTime.getSelectedItem().toString();
        
        if (!feedingTime.equals("Zeit auswählen") || !animal.equals("Tier auswählen")) {
            jButtonSearch.setEnabled(true);
        } else {
            jButtonSearch.setEnabled(false);
        }
    }//GEN-LAST:event_jComboTimeActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        //Close connection in the main menu
         //Connect to database
        ConnectionHandler connectionHandler = zooManager.getConnectionHandler();
        connectionHandler.disconnect();
        
        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       
                                                  

        String animal = jComboBoxName.getSelectedItem().toString();
        System.out.println(animal);
        String feedingTime = jComboTime.getSelectedItem().toString();
        System.out.println(feedingTime);
        
        //choosed animal
        if (!animal.equals("Tier auswählen")&& feedingTime.equals("Zeit auswählen")) {

        
                
                LinkedList<FeedingInfo> feedingInfos = guestModeManager.getAnimalFeedingInfos(animal);

                if (feedingInfos.isEmpty()) {

                    JOptionPane.showMessageDialog(rootPane, "Keine Fütterungen für " + animal + " heute mehr ", "Schade :(", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    

                    JFrame thisFrame = this;
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new ChooseAnimalJFrame(thisFrame, zooManager, animal, feedingInfos).setVisible(true);
                        }
                    });
                    
                    this.setVisible(false);
                }
             

        }

        ///choosed time   
        if (animal.equals("Tier auswählen") && !feedingTime.equals("Zeit auswählen")) {

           

            JFrame thisFrame = this;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ChooseTimeJFrame(thisFrame, zooManager, (String)jComboTime.getSelectedItem()).setVisible(true);
                }
            });
            
            this.setVisible(false); 
        }
        ///choosed both
        if (!animal.equals("Tier auswählen") && !feedingTime.equals("Zeit auswählen")) {
           

            JFrame thisFrame = this;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ChooseBothJFrame(thisFrame, zooManager, (String) jComboBoxName.getSelectedItem(), (String) jComboTime.getSelectedItem()).setVisible(true);
                }
            });
            
            this.setVisible(false); 
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseAnimalAndTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";

        ZooManager zooManager = new ZooManager(url, dbName, username, password);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseAnimalAndTimeJFrame(null, zooManager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxName;
    private javax.swing.JComboBox<String> jComboTime;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelChoose;
    private javax.swing.JLabel jLabelFindOut;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private GuestModeManager guestModeManager;


}
