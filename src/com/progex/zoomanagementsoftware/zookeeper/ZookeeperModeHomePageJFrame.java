package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.User;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ZookeeperModeHomePageJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZookeeperModeHomePageJFrame
     *
     * @param goBackMainMenuJFrame
     * @param zooManager The zooManager of the current Programm session which
     * serves as interface
     */
    public ZookeeperModeHomePageJFrame(JFrame goBackMainMenuJFrame, ZooManager zooManager) {
        initComponents();

        // resolution settings init
        myInitComponents();

        // init references and paramteres
        this.zooManager = zooManager;
        this.userManager = zooManager.getUserManager();
        this.setLocationRelativeTo(null);
        mainMenuJFrame = goBackMainMenuJFrame;

        // set welcome user label
        setNameLabel();
        // set lastlogdate from user
        setLastLogDate();

        // display date properly
        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelDate);

        // Display next feeding time
        setNextFeedingTimeInfo();
    }

    private void setNextFeedingTimeInfo() {

        if (userManager.getNextFeedingInfo() != null) {
            String formattedTime = userManager.getNextFeedingInfoInProperFormat();
            if (userManager.getNextFeedingInfo().getFeedingTime() != null && !userManager.getNextFeedingInfo().isIsMultipleFeeding()) {
                jLabelNextFeedingTime.setText("Nächste Fütterung in (HH:MM) : " + formattedTime);
            }
            if (userManager.getNextFeedingInfo().getFeedingTime() != null && userManager.getNextFeedingInfo().isIsMultipleFeeding()) {

                jLabelNextFeedingTime.setText("Nächste Fütterung in (HH:MM) : " + formattedTime);
                jLabelAttention.setText("<html><font color=red>Achtung! Es finden mehrere Fütterungen gleichzeitig statt!</font></html>");
            }
        } else {
            jLabelNextFeedingTime.setText("Keine Fütterung mehr heute!");
        }
    }

    private void setNameLabel() {

        jLabelZookeeperNameAndHallo.setText("Hallo " + userManager.getLoggedInUser().getFirstname() + "!");
    }

    private void setLastLogDate() {

        User loggedInUser = userManager.getLoggedInUser();
        Methods methods = new Methods();
        String lastLogDate = loggedInUser.getLastLogDate().toString();

        jLabelLastLoginTime.setText(methods.removeSeconds(lastLogDate));
        System.out.println("--------- HOMEPAGE GET LASTLOGDATE---------" + userManager.getLoggedInUser().getLastLogDate());

    }

    private void myInitComponents() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLastLogDate = new javax.swing.JLabel();
        jLabelLastLoginTime = new javax.swing.JLabel();
        jLabelNextFeedingTime = new javax.swing.JLabel();
        jLabeDate = new javax.swing.JLabel();
        jButtonAllFeedingTime = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jLabelZookeeperNameAndHallo = new javax.swing.JLabel();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jLabelAttention = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tierpfleger HomePage");
        setUndecorated(true);
        setResizable(false);

        jLabelLastLogDate.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelLastLogDate.setText("Letze Anmeldung: ");

        jLabelLastLoginTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jLabelNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelNextFeedingTime.setText("Nächste Fütterung in: ");

        jLabeDate.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jButtonAllFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonAllFeedingTime.setText("Alle Fütterungen anzeigen");
        jButtonAllFeedingTime.setMaximumSize(new java.awt.Dimension(171, 23));
        jButtonAllFeedingTime.setMinimumSize(new java.awt.Dimension(171, 23));
        jButtonAllFeedingTime.setPreferredSize(new java.awt.Dimension(171, 23));
        jButtonAllFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllFeedingTimeActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabelZookeeperNameAndHallo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelZookeeperNameAndHallo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelZookeeperNameAndHallo.setText("Hallo");

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonNextFeedingTime.setText("Nächste Fütterung anzeigen");
        jButtonNextFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFeedingTimeActionPerformed(evt);
            }
        });

        jLabelAttention.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabelDate.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelZookeeperNameAndHallo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLastLogDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLastLoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAttention, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAllFeedingTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNextFeedingTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLastLogDate)
                            .addComponent(jLabelLastLoginTime)
                            .addComponent(jLabelDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogout)))
                .addGap(25, 25, 25)
                .addComponent(jLabelZookeeperNameAndHallo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNextFeedingTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAttention)
                .addGap(10, 10, 10)
                .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAllFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed

        JFrame thisFrame = this;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new NextFeedingTimeJFrame(mainMenuJFrame, thisFrame, null, zooManager).setVisible(true);
            }
        });

        this.setVisible(false);
    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

    private void jButtonAllFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllFeedingTimeActionPerformed

        JFrame thisFrame = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllFeedingTimesJFrame(mainMenuJFrame, thisFrame, null, zooManager).setVisible(true);
            }
        });
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAllFeedingTimeActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed

        userManager.logout();
        mainMenuJFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(ZookeeperModeHomePageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZookeeperModeHomePageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZookeeperModeHomePageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZookeeperModeHomePageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ZookeeperModeHomePageJFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAllFeedingTime;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabeDate;
    private javax.swing.JLabel jLabelAttention;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelLastLogDate;
    private javax.swing.JLabel jLabelLastLoginTime;
    private javax.swing.JLabel jLabelNextFeedingTime;
    private javax.swing.JLabel jLabelZookeeperNameAndHallo;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame mainMenuJFrame;
    private ZooManager zooManager;
    private UserManager userManager;
}
