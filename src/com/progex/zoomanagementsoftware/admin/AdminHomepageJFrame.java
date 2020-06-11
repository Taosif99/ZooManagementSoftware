/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import javax.swing.JFrame;

/**
 *
 * 
 */
public class AdminHomepageJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainPageJFrame
     */
    public AdminHomepageJFrame(ZooManager zooManager) {
    
       initComponents();
       myInitComponents();
       this.zooManager = zooManager;
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
        setTitle("Admin Mode");
        setResizable(false);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelWelcomeAdmin.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelWelcomeAdmin.setText("Hallo X");

        jLabelQuestion.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
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
        jButtonManageEats.setText("Futter zu Tiere Zuweisung");
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
                .addContainerGap()
                .addComponent(jLabelWelcomeAdmin)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonManageAnimals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonManageCompound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonManageTakesCare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonManageFood, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonManageEats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelQuestion))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLastLogins)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAmountAdmins)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonShowAdmins)))))
                        .addContainerGap(259, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelShowDateTime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabelWelcomeAdmin)
                .addGap(496, 496, 496))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogout)
                    .addComponent(jLabelShowDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(jButtonManageEats, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAmountAdmins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonShowAdmins))
                        .addGap(12, 12, 12)
                        .addComponent(jLabelLastLogins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageUserActionPerformed
        
         //Set Main Menue to not visible
        this.setVisible(false);
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUserJFrame(thisFrame).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageUserActionPerformed

    private void jButtonManageAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageAnimalsActionPerformed
        
        //Set Main Menue to not visible
        this.setVisible(false);
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame ManageAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAnimalJFrame(thisFrame,zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageAnimalsActionPerformed

    private void jButtonManageFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageFoodActionPerformed
         
        this.setVisible(false);
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame ManageFood*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodJFrame(thisFrame).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageFoodActionPerformed

    private void jButtonManageCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageCompoundActionPerformed
        
        //this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame ManageCompound*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCompoundJFrame(thisFrame,zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageCompoundActionPerformed

    private void jButtonManageTakesCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageTakesCareActionPerformed
        
        this.setVisible(false);
        JFrame thisFrame = this; 
        /* Create and display the JFrame MangeZookeeperToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame(thisFrame).setVisible(true);
            }
        });  
    }//GEN-LAST:event_jButtonManageTakesCareActionPerformed

    private void jButtonManageEatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageEatsActionPerformed
       
        
        this.setVisible(false);
        
        
        JFrame thisFrame = this; 
        /* Create and display the JFrame FoodToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodToAnimalJFrame(thisFrame).setVisible(true);
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
            java.util.logging.Logger.getLogger(AdminHomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomepageJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        
         String url ="jdbc:mysql://localhost/";
         String username = "root";
         String password = "0000";
         String dbName = "zoo";
        
         ZooManager zooManager = new ZooManager(url,dbName,username,password);
         
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomepageJFrame(zooManager).setVisible(true);
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

    private ZooManager zooManager;

}
