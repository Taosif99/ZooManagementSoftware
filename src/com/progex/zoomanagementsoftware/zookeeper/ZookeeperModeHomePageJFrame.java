/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.main.MainMenuJFrame;
import javax.swing.JFrame;

/**
 *
 * @author khali
 */
public class ZookeeperModeHomePageJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZookeeperModeHomePage
     */
    public ZookeeperModeHomePageJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        letzteAnmeldung = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabelLastLoginTime = new javax.swing.JLabel();
        nächsteFütterungIn = new javax.swing.JLabel();
        jLabelNextFeedingTimeIn = new javax.swing.JLabel();
        jLabelZooKeeperHomePageTierpflegerName = new javax.swing.JLabel();
        jLabelZookeeperModeHomePageDatum = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        zookeeperName = new javax.swing.JLabel();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jButtonAllFeedingTime1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        letzteAnmeldung.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        letzteAnmeldung.setText("Letze Anmeldung: ");

        jButtonLogout.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogoutMouseClicked(evt);
            }
        });

        jLabelLastLoginTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelLastLoginTime.setText("X");

        nächsteFütterungIn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        nächsteFütterungIn.setText("Nächste Fütterung in: ");

        jLabelNextFeedingTimeIn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelNextFeedingTimeIn.setText("X");

        jLabelZooKeeperHomePageTierpflegerName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jLabelZookeeperModeHomePageDatum.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        zookeeperName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        zookeeperName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zookeeperName.setText("Hallo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zookeeperName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(zookeeperName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonNextFeedingTime.setText("Nächste Fütterung anzeigen");
        jButtonNextFeedingTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNextFeedingTimeMouseClicked(evt);
            }
        });
        jButtonNextFeedingTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextFeedingTimeActionPerformed(evt);
            }
        });

        jButtonAllFeedingTime1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonAllFeedingTime1.setText("Alle Fütterungen anzeigen");
        jButtonAllFeedingTime1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAllFeedingTime1MouseClicked(evt);
            }
        });
        jButtonAllFeedingTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllFeedingTime1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(letzteAnmeldung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLastLoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelZookeeperModeHomePageDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                .addComponent(jButtonLogout))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAllFeedingTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nächsteFütterungIn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNextFeedingTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(letzteAnmeldung)
                            .addComponent(jLabelLastLoginTime)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelZookeeperModeHomePageDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLogout)))
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nächsteFütterungIn)
                    .addComponent(jLabelNextFeedingTimeIn))
                .addGap(18, 18, 18)
                .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAllFeedingTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogoutMouseClicked
        // TODO add your handling code here:

        this.dispose();        
        new MainMenuJFrame().setVisible(true);

        

    }//GEN-LAST:event_jButtonLogoutMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
      //  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_formWindowClosed

    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

    private void jButtonNextFeedingTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeMouseClicked
        // TODO add your handling code here:
        new NextFeedingTimeJFrame().setVisible(true); 
        this.dispose();
        
    }//GEN-LAST:event_jButtonNextFeedingTimeMouseClicked

    private void jButtonAllFeedingTime1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAllFeedingTime1MouseClicked
        // TODO add your handling code here:
        new AllFeedingTimesJFrame().setVisible(true);
        this.dispose();
        //this.setVisible(false);
   
    }//GEN-LAST:event_jButtonAllFeedingTime1MouseClicked

    private void jButtonAllFeedingTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllFeedingTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAllFeedingTime1ActionPerformed

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
                new ZookeeperModeHomePageJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAllFeedingTime1;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabelLastLoginTime;
    private javax.swing.JLabel jLabelNextFeedingTimeIn;
    private javax.swing.JLabel jLabelZooKeeperHomePageTierpflegerName;
    private javax.swing.JLabel jLabelZookeeperModeHomePageDatum;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel letzteAnmeldung;
    private javax.swing.JLabel nächsteFütterungIn;
    private javax.swing.JLabel zookeeperName;
    // End of variables declaration//GEN-END:variables
}