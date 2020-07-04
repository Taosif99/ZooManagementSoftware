package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.ZookeeperInfo;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class NextFeedingTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NextFeedingTimeJFrame.
     *
     * @param goBackToMainMenuJFrame
     * @param goBackZookeeperModeHomePageJFrame
     * @param goBackAllFeedingTimeJFrame
     * @param zooManager The zooManager of the current programm session which
     * serves as interface
     */
    public NextFeedingTimeJFrame(JFrame goBackToMainMenuJFrame, JFrame goBackZookeeperModeHomePageJFrame, JFrame goBackAllFeedingTimeJFrame, ZooManager zooManager) {
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
     * Method is used to display feedingInfo in gram. Method gets all
     * information from zooManager.
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
                jLabelNextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung in (HH:MM) : " + nextFeedingTimeInMinutes);
                jLabelFood.setText("Futter: " + food);
                jLabelStorageRoomNumber.setText("Abstellraumnummer: " + storageRoom);
                jLabelFoodAmount.setText("Menge in Gramm: " + amount);
                jLabelCompound.setText("Gehege: " + compound);
                jLabelAnimalName.setText("Tier: " + animalName);
                if (zookeeperInfo.isIsMultipleFeeding()) {
                    attentionLabel.setText("Achtung, mehrere Fütterungen gleichzeitig!");
                }
            } // else do not display it, instead display that there are no feedings anymore.
            else {
                setLabelsNoFeeding();
            }
        } else {
            setLabelsNoFeeding();
        }
    }

    /**
     * Method is used to display feedingInfo in kilogram. Method gets all
     * information from zooManager.
     */
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
                jLabelNextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung in (HH:MM) : " + nextFeedingTimeInMinutes);
                jLabelFood.setText("Futter: " + food);
                jLabelStorageRoomNumber.setText("Abstellraumnummer: " + storageRoom);
                jLabelFoodAmount.setText("Menge in Kilogramm: " + amount / 1000);
                jLabelCompound.setText("Gehege: " + compound);
                jLabelAnimalName.setText("Tier: " + animalName);
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

    private void setLabelsNoFeeding() {
        jLabelNextFeedingTimeTakesPlaceIn.setText("Keine Fütterung für heute mehr");
        jLabelFood.setText("");
        jLabelStorageRoomNumber.setText("");
        jLabelFoodAmount.setText("");
        jLabelCompound.setText("");
        jLabelAnimalName.setText("");
    }

    private void myInitComponents() {

        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);

        if (x == 1920 && y == 1080) {
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 32));

            jLabelStorageRoomNumber.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelFood.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelFoodAmount.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 32));
            jLabelAnimalName.setFont(new java.awt.Font("Calibri", 0, 32));

        }
        
        if (x == 1280 && y == 720) {

            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));

            jLabelStorageRoomNumber.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelFood.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelFoodAmount.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 28));
            jLabelAnimalName.setFont(new java.awt.Font("Calibri", 0, 28));
        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // display date properly
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelTime);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonGoBackToMainMenue = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jPanelNextFeedingTimeInfo = new javax.swing.JPanel();
        jLabelFood = new javax.swing.JLabel();
        jLabelStorageRoomNumber = new javax.swing.JLabel();
        jLabelFoodAmount = new javax.swing.JLabel();
        jLabelAnimalName = new javax.swing.JLabel();
        jLabelCompound = new javax.swing.JLabel();
        jLabelNextFeedingTimeTakesPlaceIn = new javax.swing.JLabel();
        attentionLabel = new javax.swing.JLabel();
        jRadioButtonKg = new javax.swing.JRadioButton();
        jRadioButtonGramm = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nächste Fütterung");
        setUndecorated(true);
        setResizable(false);

        jButtonGoBackToMainMenue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonGoBackToMainMenue.setText("Zurück zum Hauptmenü");
        jButtonGoBackToMainMenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackToMainMenueActionPerformed(evt);
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

        jLabelFood.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelFood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFood.setText("Futter:");

        jLabelStorageRoomNumber.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelStorageRoomNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStorageRoomNumber.setText("Abstellraumnummer:");

        jLabelFoodAmount.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelFoodAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoodAmount.setText("Futtermenge:");

        jLabelAnimalName.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelAnimalName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAnimalName.setText("Tiername:");

        jLabelCompound.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelCompound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCompound.setText("Gehege:");

        jLabelNextFeedingTimeTakesPlaceIn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelNextFeedingTimeTakesPlaceIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNextFeedingTimeTakesPlaceIn.setText("Nächste Fütterung findet statt in: ");

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
                    .addComponent(jLabelNextFeedingTimeTakesPlaceIn, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addComponent(jLabelCompound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAnimalName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelStorageRoomNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFoodAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attentionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelNextFeedingTimeInfoLayout.setVerticalGroup(
            jPanelNextFeedingTimeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNextFeedingTimeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNextFeedingTimeTakesPlaceIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attentionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStorageRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFoodAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonGroup1.add(jRadioButtonKg);
        jRadioButtonKg.setSelected(true);
        jRadioButtonKg.setText("Futtermenge in Kilogramm");
        jRadioButtonKg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKgActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonGramm);
        jRadioButtonGramm.setText("Futtermenge in Gramm");
        jRadioButtonGramm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGrammActionPerformed(evt);
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
                        .addComponent(jButtonGoBackToMainMenue)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonKg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonGramm)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBackToMainMenue)
                    .addComponent(jButtonLogout)
                    .addComponent(jLabelTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelNextFeedingTimeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonKg)
                    .addComponent(jRadioButtonGramm))
                .addGap(18, 18, 18)
                .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed

        userManager.logout();
        mainMenuJFrame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonLogoutActionPerformed


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

    private void jButtonGoBackToMainMenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackToMainMenueActionPerformed

        zookeeperModeHomePageFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonGoBackToMainMenueActionPerformed

    private void jRadioButtonKgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKgActionPerformed

        setFeedingInfoInKiloGramm();
    }//GEN-LAST:event_jRadioButtonKgActionPerformed

    private void jRadioButtonGrammActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGrammActionPerformed

        setFeedingInfoInGramm();
    }//GEN-LAST:event_jRadioButtonGrammActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attentionLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonGoBackToMainMenue;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabelAnimalName;
    private javax.swing.JLabel jLabelCompound;
    private javax.swing.JLabel jLabelFood;
    private javax.swing.JLabel jLabelFoodAmount;
    private javax.swing.JLabel jLabelNextFeedingTimeTakesPlaceIn;
    private javax.swing.JLabel jLabelStorageRoomNumber;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanelNextFeedingTimeInfo;
    private javax.swing.JRadioButton jRadioButtonGramm;
    private javax.swing.JRadioButton jRadioButtonKg;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame mainMenuJFrame;
    private javax.swing.JFrame zookeeperModeHomePageFrame;
    private javax.swing.JFrame allFeedingTimeFrame;
    private ZooManager zooManager;
    private UserManager userManager;
}
