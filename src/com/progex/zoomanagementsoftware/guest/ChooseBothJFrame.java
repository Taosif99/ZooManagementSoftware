package com.progex.zoomanagementsoftware.guest;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.GuestModeManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import com.progex.zoomanagementsoftware.datatypes.Methods;
//import com.progex.zoomanagementsoftware.main.ZooMapJFrame;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;

public class ChooseBothJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChooseBothJFrame
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current programm session which
     * serves as interface
     * @param animalName
     * @param feedingTime
     */
    public ChooseBothJFrame(JFrame goBackFrame, ZooManager zooManager, String animalName, String feedingTime) {

        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.guestModeManager = zooManager.getGuestModeManager();
        this.animalName = animalName;
        this.feedingTime = feedingTime;

        initComponents();
        myInitComponents();
    }

    private void myInitComponents() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc)
        if (x == 1920 && y == 1080) {

            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18));
        }
        if (x == 1280 && y == 720) {

            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 16));
        }

        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Labels get values
        jLabelAnimal.setText(animalName + ": ");
        jLabelTime.setText(feedingTime + " Uhr");

        //Load all relevant Data in Label: compound and food
        viewAnimalTime();
    }

    /*Load all relevant Data in Label: compound and food*/
    private void viewAnimalTime() {

        String tmp = feedingTime.concat(":00");
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        String str = dateformat.format(new Date());
        String day = str.substring(0, 2);
        String month = str.substring(3, 5);
        String year = str.substring(6, 10);
        String last = (year + "-" + month + "-" + day + " ").concat(tmp);

        LinkedList<FeedingInfo> feedingInfos = guestModeManager.getAnimalTimeFeedingInfo(last, animalName);
        if (!feedingInfos.isEmpty()) {

            String com = feedingInfos.getFirst().getCompundName();
            LinkedList<String> foods = new LinkedList<String>();

            for (FeedingInfo feedingInfo : feedingInfos) {

                foods.add(feedingInfo.getFoodName());
            }

            jLabelCompound.setText(com);

            String foodNames = foods.toString();
            jLabelFeed.setText(foodNames);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBack = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelFeedStatic = new javax.swing.JLabel();
        jLabelFeed = new javax.swing.JLabel();
        jLabelAnimal = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jLabelCompoundStatic = new javax.swing.JLabel();
        jLabelCompound = new javax.swing.JLabel();

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

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelFeedStatic.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelFeedStatic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFeedStatic.setText("Futter:");
        jLabelFeedStatic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelFeed.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelFeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFeed.setText("xxx Futter");

        jLabelAnimal.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelAnimal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAnimal.setText("Tiername :");
        jLabelAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelTime.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("Zeit XX:XX -XX:XX");
        jLabelTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelCompoundStatic.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelCompoundStatic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompoundStatic.setText("Gehege:");
        jLabelCompoundStatic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 60)); // NOI18N
        jLabelCompound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompound.setText("xxx Gehege");
        jLabelCompound.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAnimal)
                            .addComponent(jLabelCompoundStatic, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFeedStatic, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTime)
                            .addComponent(jLabelCompound)
                            .addComponent(jLabelFeed))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowDateTime)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnimal)
                    .addComponent(jLabelTime))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCompoundStatic)
                    .addComponent(jLabelCompound))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFeedStatic)
                    .addComponent(jLabelFeed))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseBothJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseBothJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseBothJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseBothJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";

        ZooManager zooManager = new ZooManager(url, dbName, username, password);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseBothJFrame(null, zooManager, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelCompound;
    private javax.swing.JLabel jLabelCompoundStatic;
    private javax.swing.JLabel jLabelFeed;
    private javax.swing.JLabel jLabelFeedStatic;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private GuestModeManager guestModeManager;
    private String feedingTime;
    private String animalName;
    //private javax.swing.JFrame mapFrame;
}
