/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.zookeeper;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.main.MainMenuJFrame;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author khalid
 */
public class NextFeedingTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NächsteFütterungJFrame
     */
    public NextFeedingTimeJFrame(JFrame goBack, JFrame goBack2, JFrame goBack3 ) {
        initComponents();
        myInitComponents();
        mainMenuJFrame = goBack;
        zookeeperModeHomePageFrame = goBack2;
        allFeedingTimeFrame = goBack3;
        
    }

  
    
        public void myInitComponents(){
        
        
        //setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x =(int)tk.getScreenSize().getWidth();
        int y =(int)tk.getScreenSize().getHeight();
        setSize(x,y);
        
        
        //abfrage welche auflösung dann grösse der komponenten anpassen (text grösse etc)
        if(x == 1920 && y == 1080){
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 32));
            
            abstellraumnummer.setFont(new java.awt.Font("Calibri", 0, 32));
            futter.setFont(new java.awt.Font("Calibri", 0, 32));
            futtermenge.setFont(new java.awt.Font("Calibri", 0, 32));
            gehege.setFont(new java.awt.Font("Calibri", 0, 32));
            tierName.setFont(new java.awt.Font("Calibri", 0, 32));
            
        }
        if(x == 1280 && y == 720){
            
            
            jLabelTime.setFont(new java.awt.Font("Calibri", 0, 28));
            
            abstellraumnummer.setFont(new java.awt.Font("Calibri", 0, 28));
            futter.setFont(new java.awt.Font("Calibri", 0, 28));
            futtermenge.setFont(new java.awt.Font("Calibri", 0, 28));
            gehege.setFont(new java.awt.Font("Calibri", 0, 28));
            tierName.setFont(new java.awt.Font("Calibri", 0, 28));
            
        }
        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
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

        jButtonGoBack = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        jButtonNextFeedingTime = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        futter = new javax.swing.JLabel();
        abstellraumnummer = new javax.swing.JLabel();
        futtermenge = new javax.swing.JLabel();
        tierName = new javax.swing.JLabel();
        gehege = new javax.swing.JLabel();
        nextFeedingTimeTakesPlaceIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nächste Fütterung");
        setUndecorated(true);
        setResizable(false);

        jButtonGoBack.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGoBackMouseClicked(evt);
            }
        });
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        jButtonLogout.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogoutMouseClicked(evt);
            }
        });
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTime.setText("X");

        jButtonNextFeedingTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonNextFeedingTime.setText("Alle Fütterungen anzeigen");
        jButtonNextFeedingTime.setMinimumSize(new java.awt.Dimension(311, 39));
        jButtonNextFeedingTime.setPreferredSize(new java.awt.Dimension(311, 39));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tierName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextFeedingTimeTakesPlaceIn, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addComponent(gehege, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abstellraumnummer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(futtermenge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(futter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nextFeedingTimeTakesPlaceIn)
                .addGap(18, 18, 18)
                .addComponent(futter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abstellraumnummer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(futtermenge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(tierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gehege, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonGoBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogout))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNextFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Button Logout pressed
    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        mainMenuJFrame.setVisible(true);
        
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoutMouseClicked

    private void jButtonGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGoBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGoBackMouseClicked

    private void jButtonNextFeedingTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNextFeedingTimeMouseClicked

    
    // Button show AllFeedingTime pressed
    private void jButtonNextFeedingTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextFeedingTimeActionPerformed
        // TODO add your handling code here:
        
        if(allFeedingTimeFrame != null){
            allFeedingTimeFrame.setVisible(true);
            this.setVisible(false);
        }
        else{
            JFrame thisFrame = this;       
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AllFeedingTimesJFrame(mainMenuJFrame,zookeeperModeHomePageFrame,thisFrame).setVisible(true);
                }
            });           
            this.setVisible(false);            
        }

    }//GEN-LAST:event_jButtonNextFeedingTimeActionPerformed

    
    // Button zurück is pressed
    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        zookeeperModeHomePageFrame.setVisible(true);
        
    }//GEN-LAST:event_jButtonGoBackActionPerformed

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
                new NextFeedingTimeJFrame(null,null,null).setVisible(true);
            }
        });
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abstellraumnummer;
    private javax.swing.JLabel futter;
    private javax.swing.JLabel futtermenge;
    private javax.swing.JLabel gehege;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNextFeedingTime;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nextFeedingTimeTakesPlaceIn;
    private javax.swing.JLabel tierName;
    // End of variables declaration//GEN-END:variables

   private javax.swing.JFrame mainMenuJFrame;
   private javax.swing.JFrame zookeeperModeHomePageFrame;
   private javax.swing.JFrame allFeedingTimeFrame;




}
