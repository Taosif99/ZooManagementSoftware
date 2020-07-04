package com.progex.zoomanagementsoftware.main;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.*;
import com.progex.zoomanagementsoftware.guest.ChooseAnimalAndTimeJFrame;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainMenuJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuJFrame.
     */
    public MainMenuJFrame() {
        initComponents();
        myInitComponents();

        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";
        //Using GSON API to get network parameters from file

        Path fileName = Path.of("NetworkParameters.json");

        try {

            String jsonString = Files.readString(fileName);
            JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();

            url = jsonObject.getAsJsonObject("parameters").get("url").getAsString();
            username = jsonObject.getAsJsonObject("parameters").get("username").getAsString();
            password = jsonObject.getAsJsonObject("parameters").get("password").getAsString();
            dbName = jsonObject.getAsJsonObject("parameters").get("dbName").getAsString();

            JOptionPane.showMessageDialog(null, "Netzwerkkonfiguration erfolgreich geladen!", "Erfolgreiches Laden", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            System.out.println("Using hardcoded standard instead of json file...");
            JOptionPane.showMessageDialog(null, "Nutze Standard-Netzwerkparameter", "Keine NetworkParameters.json gefunden!", JOptionPane.CANCEL_OPTION);

        }
        /*Init the our wrapper class, which will be used in the program, that
        will be passed to the corresponding frames*/
        zooManager = new ZooManager(url, dbName, username, password);
        checkConnection();
    }

    private void myInitComponents() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        currentLoginJFrame = null;
    }

    private void checkConnection() {

        ConnectionHandler connectionHandler = zooManager.getConnectionHandler();
        boolean connected = connectionHandler.connect();

        if (!connected) {

            JOptionPane.showMessageDialog(null, "Es konnte keine Verbindung zur Datenbank aufgebaut werden! "
                    + "Bitte Netzwerkkonfiguration, Netzwerkverbindung überprüfen und Programm neu starten. ",
                    "Keine Verbindung", JOptionPane.ERROR_MESSAGE);

            System.exit(-1); //Abnormal termination

        } else {
            connectionHandler.disconnect();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWelcome = new javax.swing.JLabel();
        jLabelWelcomeStatement = new javax.swing.JLabel();
        jButtonGuestFeedingTime = new javax.swing.JButton();
        jButtonShowMap = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zoo / compund management");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jLabelWelcome.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcome.setText("Willkommen im Zoo!");
        jLabelWelcome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelWelcomeStatement.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelWelcomeStatement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcomeStatement.setText("Finde heraus wann welches Tier gefüttert wird !");
        jLabelWelcomeStatement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonGuestFeedingTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonGuestFeedingTime.setText("Fütterungszeit");
        jButtonGuestFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuestFeedingTimeActionPerformed(evt);
            }
        });

        jButtonShowMap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonShowMap.setText("Karte anzeigen");
        jButtonShowMap.setMaximumSize(new java.awt.Dimension(103, 23));
        jButtonShowMap.setMinimumSize(new java.awt.Dimension(103, 23));
        jButtonShowMap.setPreferredSize(new java.awt.Dimension(103, 23));
        jButtonShowMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowMapActionPerformed(evt);
            }
        });

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuestFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonShowMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelWelcomeStatement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLogin)
                .addGap(18, 18, 18)
                .addComponent(jLabelWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWelcomeStatement, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuestFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonShowMap, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonShowMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowMapActionPerformed

        //Set Main Menue to not visible
        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the form with the Zoo Map */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZooMapJFrame(thisFrame).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonShowMapActionPerformed

    private void jButtonGuestFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuestFeedingTimeActionPerformed

        //Connect to database
        ConnectionHandler connectionHandler = zooManager.getConnectionHandler();
        connectionHandler.connect();

        //Set Main Menue to not visible
        this.setVisible(false);

        JFrame thisFrame = this;
        /* Create and display the form with the Zoo Map */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseAnimalAndTimeJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonGuestFeedingTimeActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        JFrame thisFrame = this;
        if (currentLoginJFrame == null) {
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    currentLoginJFrame = new LoginJFrame(thisFrame, zooManager);
                    currentLoginJFrame.setVisible(true);
                }
            });
        } else {
            currentLoginJFrame.dispose();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    currentLoginJFrame = new LoginJFrame(thisFrame, zooManager);
                    currentLoginJFrame.setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    /**
     * This method is the entry point to our graphical user interface
     * implementation.
     *
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
            java.util.logging.Logger.getLogger(MainMenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuestFeedingTime;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonShowMap;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JLabel jLabelWelcomeStatement;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame currentLoginJFrame;
    private ZooManager zooManager;
}