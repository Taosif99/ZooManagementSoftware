/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import javax.swing.JFrame;


/**
 *
 * @author taosi
 */
public class ManageZookeeperToAnimalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZookeeperToAnimalJFrame
     * @param goBackFrame The frame which will appear when the go back button is used
     */
    public ManageZookeeperToAnimalJFrame(JFrame goBackFrame) {
        
        initComponents();
        this.goBackFrame = goBackFrame;
        myInitComponents();
    }
    
    public void myInitComponents(){
        
        updateButtonsAndLabels();
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

        buttonGroupOperation = new javax.swing.ButtonGroup();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jLabelOperation = new javax.swing.JLabel();
        jButtonGoBack = new javax.swing.JButton();
        jLabelZookeeperFirstName = new javax.swing.JLabel();
        jTextFieldZookeepeFirstName = new javax.swing.JTextField();
        jLabelZookeeperLastName = new javax.swing.JLabel();
        jTextFieldZookeeperLastName = new javax.swing.JTextField();
        jButtonSearchZookeeper = new javax.swing.JButton();
        jLabelSelectZookeeper = new javax.swing.JLabel();
        jScrollTakesCareTable = new javax.swing.JScrollPane();
        jTableTakesCareData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jScrollZookeeperTable = new javax.swing.JScrollPane();
        jTableZookeeperData = new javax.swing.JTable();
        jLabelAskAnimalName = new javax.swing.JLabel();
        jTextFieldAnimalName = new javax.swing.JTextField();
        jButtonAddFood = new javax.swing.JButton();
        jButtonDeleteFood = new javax.swing.JButton();
        jLabelZookeeperID = new javax.swing.JLabel();
        jTextFieldUserID = new javax.swing.JTextField();
        jLabelDelete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tierpfleger/-in zu Tier Zuweisung hinzufügen");

        buttonGroupOperation.add(jRadioButtonAdd);
        jRadioButtonAdd.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonAdd.setSelected(true);
        jRadioButtonAdd.setText("Hinzufügen");
        jRadioButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAddActionPerformed(evt);
            }
        });

        buttonGroupOperation.add(jRadioButtonDelete);
        jRadioButtonDelete.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonDelete.setText("Löschen");
        jRadioButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeleteActionPerformed(evt);
            }
        });

        jLabelOperation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelOperation.setText("Bitte geben Sie die gewünschte Operation an");

        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        jLabelZookeeperFirstName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZookeeperFirstName.setText("Tierpfleger/-in Vorname");

        jLabelZookeeperLastName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZookeeperLastName.setText("Tierpfleger/-in Nachname");

        jButtonSearchZookeeper.setText("Tierpfleger/-in suchen");

        jLabelSelectZookeeper.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSelectZookeeper.setText("Bitte Tierpfleger/-in auswählen");

        jScrollTakesCareTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollTakesCareTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableTakesCareData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Benutzer ID", "Vorname", "Nachname", "Tier ID", "Tiername"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTakesCareData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTakesCareData.getTableHeader().setReorderingAllowed(false);
        jScrollTakesCareTable.setViewportView(jTableTakesCareData);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSearch.setText("Suche Anhand nicht leerer Felder");

        jButtonSearch.setText("Suche");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jScrollZookeeperTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollZookeeperTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableZookeeperData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Benutzer ID", "Vorname", "Nachname", "Tier ID", "Tiername"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableZookeeperData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableZookeeperData.getTableHeader().setReorderingAllowed(false);
        jScrollZookeeperTable.setViewportView(jTableZookeeperData);

        jLabelAskAnimalName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAskAnimalName.setText("Bitte Tiernamen eingeben");

        jButtonAddFood.setText("Hinzufügen");

        jButtonDeleteFood.setText("Löschen");
        jButtonDeleteFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteFoodActionPerformed(evt);
            }
        });

        jLabelZookeeperID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZookeeperID.setText("BenutzerID");

        jLabelDelete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelDelete.setText("DeleteText");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGoBack)
                        .addGap(443, 443, 443)
                        .addComponent(jLabelShowDateTime)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonSearchZookeeper)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelZookeeperLastName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldZookeeperLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelZookeeperFirstName)
                                        .addGap(33, 33, 33)
                                        .addComponent(jTextFieldZookeepeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jRadioButtonDelete)
                            .addComponent(jLabelSelectZookeeper)
                            .addComponent(jScrollZookeeperTable, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAskAnimalName)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddFood, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteFood, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelOperation)
                            .addComponent(jRadioButtonAdd))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelZookeeperID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollTakesCareTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabelDelete))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBack)
                    .addComponent(jLabelShowDateTime))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelOperation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDelete)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelZookeeperFirstName)
                            .addComponent(jTextFieldZookeepeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelZookeeperLastName)
                            .addComponent(jTextFieldZookeeperLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearchZookeeper)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelSelectZookeeper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollZookeeperTable, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAskAnimalName)
                            .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddFood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteFood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelZookeeperID)
                            .addComponent(jTextFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollTakesCareTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        
        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonDeleteFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteFoodActionPerformed
    
    /**
     * Method to disable/enable buttons and labels depending on
     * operation selection.
     */
    private void updateButtonsAndLabels(){
        
        //\n bei den update texten funktioniert nicht, dadurch verschiebt sich
        //das Fenster
            System.out.println("Manage TakesCare");
   
            if (jRadioButtonAdd.isSelected()){
                System.out.println("    Add mode");
                jLabelDelete.setText("");
                jButtonAddFood.setEnabled(true);
                jButtonDeleteFood.setEnabled(false);
                jTextFieldUserID.setEnabled(false);
                jLabelZookeeperID.setEnabled(false);
                jLabelSearch.setEnabled(false);
                jButtonSearch.setEnabled(false);
           
            } else if (jRadioButtonDelete.isSelected()){
                
                System.out.println("    Delete mode");
                
                jLabelDelete.setText("Bitte die ID des Benutzers und den Tiernamen ausfüllen"
                        + "oder den\nDatensatz in der Tabelle anklicken! ");
                //jLabelUpdateDelete.setText("");
                jButtonAddFood.setEnabled(false);
                jButtonDeleteFood.setEnabled(true);
                jTextFieldUserID.setEnabled(true);
                jLabelZookeeperID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);
            }
    }
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
            java.util.logging.Logger.getLogger(ManageZookeeperToAnimalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageZookeeperToAnimalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageZookeeperToAnimalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageZookeeperToAnimalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddFood;
    private javax.swing.JButton jButtonDeleteFood;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearchZookeeper;
    private javax.swing.JLabel jLabelAskAnimalName;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSelectZookeeper;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelZookeeperFirstName;
    private javax.swing.JLabel jLabelZookeeperID;
    private javax.swing.JLabel jLabelZookeeperLastName;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JScrollPane jScrollTakesCareTable;
    private javax.swing.JScrollPane jScrollZookeeperTable;
    private javax.swing.JTable jTableTakesCareData;
    private javax.swing.JTable jTableZookeeperData;
    private javax.swing.JTextField jTextFieldAnimalName;
    private javax.swing.JTextField jTextFieldUserID;
    private javax.swing.JTextField jTextFieldZookeepeFirstName;
    private javax.swing.JTextField jTextFieldZookeeperLastName;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
}