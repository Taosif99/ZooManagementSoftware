package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.ZookeeperInfo;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author khalid
 */
public class NextFeedingTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NächsteFütterungJFrame
     */
    public NextFeedingTimeJFrame(JFrame goBackToMainMenuJFrame, JFrame goBackZookeeperModeHomePageJFrame, JFrame goBackAllFeedingTimeJFrame, ZooManager zooManager){
        initComponents();
        
        // init resolution
        myInitComponents();
        
        // init references and paramteters
        mainMenuJFrame = goBackToMainMenuJFrame;
        zookeeperModeHomePageFrame = goBackZookeeperModeHomePageJFrame;
        allFeedingTimeFrame = goBackAllFeedingTimeJFrame;
        this.zooManager = zooManager;
        this.userManager = zooManager.getUserManager();
        
        // display feedingInfo
        setFeedingInfoInKiloGramm();

    }

    
    /**
     * Method is used to display feedingInfo. Method gets all information from zooManager.
     */
    public void setFeedingInfoInGramm() {

        ZookeeperInfo zookeeperInfo = userManager.getNextFeedingInfo();

        if (zookeeperInfo != null) {
            String food = zookeeperInfo.getFoodName();
            String animalName = zookeeperInfo.getAnimalName();
            String storageRoom = zookeeperInfo.getStorageRoomNumber();
            double amount = zookeeperInfo.getAmountFood();
            String compound = zookeeperInfo.getCompoundName();
            String nextFeedingTimeInMinutes = userManager.getNextFeedingInfoInProperFormat();

            // If nextfeedingInfo has valid minute time then display it        
            if (nextFeedingTimeInMinutes != null) {
                nextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung in (HH:MM) : " + nextFeedingTimeInMinutes);
                futter.setText("Futter: " + food);
                abstellraumnummer.setText("Abstellraumnummer: " + storageRoom);
                futtermenge.setText("Menge in Gramm: " + amount);
                gehege.setText("Gehege: " + compound);
                tierName.setText("Tier: " + animalName);
                if (zookeeperInfo.isIsMultipleFeeding()) {
                    attentionLabel.setText("Achtung, mehrere Fütterungen gleichzeitig!");
                }
            } // else dont display it, instead display that there are no feedings anymore.
            else {
                setLabelsNoFeeding();
            }
        } else {
            setLabelsNoFeeding();
        }
    }
    
    
    public void setFeedingInfoInKiloGramm() {

        ZookeeperInfo zookeeperInfo = userManager.getNextFeedingInfo();

        if (zookeeperInfo != null) {
            String food = zookeeperInfo.getFoodName();
            String animalName = zookeeperInfo.getAnimalName();
            String storageRoom = zookeeperInfo.getStorageRoomNumber();
            double amount = zookeeperInfo.getAmountFood();
            String compound = zookeeperInfo.getCompoundName();
            String nextFeedingTimeInMinutes = userManager.getNextFeedingInfoInProperFormat();

            // If nextfeedingInfo has valid minute time then display it        
            if (nextFeedingTimeInMinutes != null) {
                nextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung in (HH:MM) : " + nextFeedingTimeInMinutes);
                futter.setText("Futter: " + food);
                abstellraumnummer.setText("Abstellraumnummer: " + storageRoom);
                futtermenge.setText("Menge in Kilogramm: " + amount/1000);
                gehege.setText("Gehege: " + compound);
                tierName.setText("Tier: " + animalName);
                if (zookeeperInfo.isIsMultipleFeeding()) {
                    attentionLabel.setText("Achtung, mehrere Fütterungen gleichzeitig!");
                }
            } // else dont display it, instead display that there are no feedings anymore.
            else {
                setLabelsNoFeeding();
            }
        } else {
            setLabelsNoFeeding();
        }
    }
    
    
    public void setLabelsNoFeeding() {
        nextFeedingTimeTakesPlaceIn.setText("Keine Fütterung für heute mehr");
        futter.setText("");
        abstellraumnummer.setText("");
        futtermenge.setText("");
        gehege.setText("");
        tierName.setText("");
    }


    
    
    /**
     * resolution settings
     */
    public void myInitComponents() {

        //setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);

        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc).
        if (x == 1920 && y == 1080) {
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 32));

            abstellraumnummer.setFont(new java.awt.Font("Calibri", 0, 32));
            futter.setFont(new java.awt.Font("Calibri", 0, 32));
            futtermenge.setFont(new java.awt.Font("Calibri", 0, 32));
            gehege.setFont(new java.awt.Font("Calibri", 0, 32));
            tierName.setFont(new java.awt.Font("Calibri", 0, 32));

        }
        if (x == 1280 && y == 720) {

            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));

            abstellraumnummer.setFont(new java.awt.Font("Calibri", 0, 28));
            futter.setFont(new java.awt.Font("Calibri", 0, 28));
            futtermenge.setFont(new java.awt.Font("Calibri", 0, 28));
            gehege.setFont(new java.awt.Font("Calibri", 0, 28));
            tierName.setFont(new java.awt.Font("Calibri", 0, 28));

        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // display date properly
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelTime);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonGoBack = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jPanelNextFeedingTimeInfo = new javax.swing.JPanel();
        futter = new javax.swing.JLabel();
        abstellraumnummer = new javax.swing.JLabel();
        futtermenge = new javax.swing.JLabel();
        tierName = new javax.swing.JLabel();
        gehege = new javax.swing.JLabel();
        nextFeedingTimeTakesPlaceIn = new javax.swing.JLabel();
        attentionLabel = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nächste Fütterung");
        setUndecorated(true);
        setResizable(false);

        jButtonGoBack.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        jButtonLogout.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonNextFeedingTime.setText("Alle Fütterungen anzeigen");
        jButtonNextFeedingTime.setMinimumSize(new java.awt.Dimension(311, 39));
        jButtonNextFeedingTime.setPreferredSize(new java.awt.Dimension(311, 39));
        jButtonNextFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFeedingTimeActionPerformed(evt);
            }
        });

        futter.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        futter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        futter.setText("Futter:");

        abstellraumnummer.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        abstellraumnummer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        abstellraumnummer.setText("Abstellraumnummer:");

        futtermenge.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        futtermenge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        futtermenge.setText("Futtermenge:");

        tierName.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        tierName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tierName.setText("Tiername:");

        gehege.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        gehege.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gehege.setText("Gehege:");

        nextFeedingTimeTakesPlaceIn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        nextFeedingTimeTakesPlaceIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung findet statt in: ");

        attentionLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        attentionLabel.setForeground(new java.awt.Color(255, 0, 0));
        attentionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelNextFeedingTimeInfoLayout = new javax.swing.GroupLayout(jPanelNextFeedingTimeInfo);
        jPanelNextFeedingTimeInfo.setLayout(jPanelNextFeedingTimeInfoLayout);
        jPanelNextFeedingTimeInfoLayout.setHorizontalGroup(
            jPanelNextFeedingTimeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNextFeedingTimeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNextFeedingTimeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextFeedingTimeTakesPlaceIn, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addComponent(gehege, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tierName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abstellraumnummer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(futtermenge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(futter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attentionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelNextFeedingTimeInfoLayout.setVerticalGroup(
            jPanelNextFeedingTimeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNextFeedingTimeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nextFeedingTimeTakesPlaceIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attentionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(futter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abstellraumnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(futtermenge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(tierName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gehege)
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Futtermenge in Kilogramm");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Futtermenge in Gramm");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNextFeedingTimeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGoBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBack)
                    .addComponent(jButtonLogout)
                    .addComponent(jLabelTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelNextFeedingTimeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    /**
     * Button "Logout" pressed
     * @param evt 
     */
    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        
        userManager.logout();
        mainMenuJFrame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonLogoutActionPerformed

   
    /**
     * Button show AllFeedingTime pressed
     * @param evt 
     */
    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed
       

        if (allFeedingTimeFrame != null) {
            allFeedingTimeFrame.setVisible(true);
            this.setVisible(false);
        } else {
            JFrame thisFrame = this;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AllFeedingTimesJFrame(mainMenuJFrame, zookeeperModeHomePageFrame, thisFrame, zooManager).setVisible(true);
                }
            });
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

    /**
     * Button "zurück is pressed".
     * @param evt 
     */
    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        
        zookeeperModeHomePageFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       
                
        setFeedingInfoInKiloGramm();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        setFeedingInfoInGramm();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NextFeedingTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NextFeedingTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NextFeedingTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NextFeedingTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new NextFeedingTimeJFrame(null, null, null, null).setVisible(true);
                
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abstellraumnummer;
    private javax.swing.JLabel attentionLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel futter;
    private javax.swing.JLabel futtermenge;
    private javax.swing.JLabel gehege;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanelNextFeedingTimeInfo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel nextFeedingTimeTakesPlaceIn;
    private javax.swing.JLabel tierName;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame mainMenuJFrame;
    private javax.swing.JFrame zookeeperModeHomePageFrame;
    private javax.swing.JFrame allFeedingTimeFrame;
    private ZooManager zooManager;
    private UserManager userManager;

}
