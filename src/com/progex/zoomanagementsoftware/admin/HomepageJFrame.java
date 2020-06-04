/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.main.ZooMapJFrame;
import javax.swing.JFrame;

/**
 *
 * @author taosi
 */
public class HomepageJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainPageJFrame
     */
    public HomepageJFrame() {
    
       initComponents();
       myInitComponents();
    }
    
    
    
    
    public void myInitComponents(){
        
        Methods methods = new Methods();    
        methods.showTimeAndDate(jLabelShowDateTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelWelcomeAdmin = new javax.swing.JLabel();
        jLabelQuestion = new javax.swing.JLabel();
        jButtonManageUser = new javax.swing.JButton();
        jButtonManageAnimals = new javax.swing.JButton();
        jButtonManageFood = new javax.swing.JButton();
        jButtonManageCompound = new javax.swing.JButton();
        jButtonManageTakesCare = new javax.swing.JButton();
        jButtonManageEats = new javax.swing.JButton();
        jLabelAmountAdmins = new javax.swing.JLabel();
        jTextFieldAmountAdmins = new javax.swing.JTextField();
        jButtonShowAdmins = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jLabelLastLogins = new javax.swing.JLabel();
        jScrollPaneLastLoginAdminsTable = new javax.swing.JScrollPane();
        jTableLastLoginAdminsData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelWelcomeAdmin.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelWelcomeAdmin.setText("Hallo X");

        jLabelQuestion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelQuestion.setText("Was möchten Sie verwalten?");

        jButtonManageUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageUser.setText("Tierpfleger/-innen oder Admins");
        jButtonManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageUserActionPerformed(evt);
            }
        });

        jButtonManageAnimals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageAnimals.setText("Tiere");
        jButtonManageAnimals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageAnimalsActionPerformed(evt);
            }
        });

        jButtonManageFood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageFood.setText("Futter");
        jButtonManageFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageFoodActionPerformed(evt);
            }
        });

        jButtonManageCompound.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageCompound.setText("Gehege");
        jButtonManageCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageCompoundActionPerformed(evt);
            }
        });

        jButtonManageTakesCare.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageTakesCare.setText("Tierpfleger/-innen zu Tiere Zuweisung");
        jButtonManageTakesCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageTakesCareActionPerformed(evt);
            }
        });

        jButtonManageEats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageEats.setText("Tiere zu Futter Zuweisung");
        jButtonManageEats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageEatsActionPerformed(evt);
            }
        });

        jLabelAmountAdmins.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAmountAdmins.setText("Anzahl auszugebende Admins");

        jButtonShowAdmins.setText("Ausgeben");

        jButtonLogout.setText("Logout");

        jLabelLastLogins.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelLastLogins.setText("Letzte Zugriffe:");

        jScrollPaneLastLoginAdminsTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneLastLoginAdminsTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableLastLoginAdminsData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Letzter Zugriff", "Anrede", "Vorname", "Nachname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLastLoginAdminsData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLastLoginAdminsData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneLastLoginAdminsTable.setViewportView(jTableLastLoginAdminsData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabelShowDateTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(420, 420, 420)
                                .addComponent(jLabelWelcomeAdmin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelQuestion)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonManageAnimals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonManageCompound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonManageTakesCare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonManageFood, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonManageEats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLastLogins)
                                    .addComponent(jLabelAmountAdmins)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonShowAdmins)))))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelShowDateTime)
                    .addComponent(jButtonLogout))
                .addGap(41, 41, 41)
                .addComponent(jLabelWelcomeAdmin)
                .addGap(37, 37, 37)
                .addComponent(jLabelQuestion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageAnimals, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageFood, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageEats, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(158, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabelAmountAdmins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonShowAdmins))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLastLogins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageUserActionPerformed
        
         //Set Main Menue to not visible
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUserJFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageUserActionPerformed

    private void jButtonManageAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageAnimalsActionPerformed
        
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAnimalJFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageAnimalsActionPerformed

    private void jButtonManageFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageFoodActionPerformed
         
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodJFrame().setVisible(true);
            }
        });    // TODO add your handling code here:
    }//GEN-LAST:event_jButtonManageFoodActionPerformed

    private void jButtonManageCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageCompoundActionPerformed
        
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCompoundJFrame().setVisible(true);
            }
        });       // TODO add your handling code here:
    }//GEN-LAST:event_jButtonManageCompoundActionPerformed

    private void jButtonManageTakesCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageTakesCareActionPerformed
        
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame().setVisible(true);
            }
        });  // TODO add your handling code here:
    }//GEN-LAST:event_jButtonManageTakesCareActionPerformed

    private void jButtonManageEatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageEatsActionPerformed
       
        
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodToAnimalJFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageEatsActionPerformed

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
            java.util.logging.Logger.getLogger(HomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomepageJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonManageAnimals;
    private javax.swing.JButton jButtonManageCompound;
    private javax.swing.JButton jButtonManageEats;
    private javax.swing.JButton jButtonManageFood;
    private javax.swing.JButton jButtonManageTakesCare;
    private javax.swing.JButton jButtonManageUser;
    private javax.swing.JButton jButtonShowAdmins;
    private javax.swing.JLabel jLabelAmountAdmins;
    private javax.swing.JLabel jLabelLastLogins;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelWelcomeAdmin;
    private javax.swing.JScrollPane jScrollPaneLastLoginAdminsTable;
    private javax.swing.JTable jTableLastLoginAdminsData;
    private javax.swing.JTextField jTextFieldAmountAdmins;
    // End of variables declaration//GEN-END:variables
}
