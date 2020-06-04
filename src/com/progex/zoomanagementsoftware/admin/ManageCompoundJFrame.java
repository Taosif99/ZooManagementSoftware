/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.datatypes.Methods;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ouchen
 */
public class ManageCompoundJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserJFrame
     * @param goBackFrame The frame which will appear when the go back button is used
     */
    public ManageCompoundJFrame(JFrame goBackFrame) {
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
        jLabelCompoundName = new javax.swing.JLabel();
        jLabelContructionYear = new javax.swing.JLabel();
        jLabelDateOfBirth = new javax.swing.JLabel();
        jLabelArea = new javax.swing.JLabel();
        jTextFieldCompoundName = new javax.swing.JTextField();
        jTextFieldConstructionYear = new javax.swing.JTextField();
        jTextArea = new javax.swing.JTextField();
        jTextFieldDateOfBirth = new javax.swing.JTextField();
        jButtonAddCompound = new javax.swing.JButton();
        jButtonUpdateCompound = new javax.swing.JButton();
        jButtonDeleteCompound = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonGoBack = new javax.swing.JButton();
        jPanelOperation = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jScrollPaneCompoundTable = new javax.swing.JScrollPane();
        jTableCompoundData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabelUpdateDelete = new javax.swing.JLabel();
        jLabelAreaUnit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gehege verwalten");

        jLabelCompoundName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCompoundName.setText("Name");

        jLabelContructionYear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelContructionYear.setText("Konstruktionsjahr");

        jLabelDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelDateOfBirth.setText("Max. Kapazität");

        jLabelArea.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelArea.setText("Fläche");

        jButtonAddCompound.setText("Hinzufügen");
        jButtonAddCompound.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCompoundActionPerformed(evt);
            }
        });

        jButtonUpdateCompound.setText("Updaten");
        jButtonUpdateCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateCompoundActionPerformed(evt);
            }
        });

        jButtonDeleteCompound.setText("Löschen");
        jButtonDeleteCompound.setMaximumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteCompound.setMinimumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCompoundActionPerformed(evt);
            }
        });

        jLabelID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelID.setText("ID");

        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        jLabelOperation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelOperation.setText("Bitte geben Sie die gewünschte Operation an");

        buttonGroupOperation.add(jRadioButtonAdd);
        jRadioButtonAdd.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonAdd.setSelected(true);
        jRadioButtonAdd.setText("Hinzufügen");
        jRadioButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAddActionPerformed(evt);
            }
        });

        buttonGroupOperation.add(jRadioButtonUpdate);
        jRadioButtonUpdate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonUpdate.setText("Updaten");
        jRadioButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUpdateActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelOperationLayout = new javax.swing.GroupLayout(jPanelOperation);
        jPanelOperation.setLayout(jPanelOperationLayout);
        jPanelOperationLayout.setHorizontalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonDelete)
                    .addComponent(jRadioButtonUpdate)
                    .addComponent(jLabelOperation)
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanelOperationLayout.setVerticalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOperation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDelete)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jScrollPaneCompoundTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableCompoundData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tiername", "Geschlecht", "Geburtsdatum", "Spezies", "Gehege"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCompoundData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCompoundData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneCompoundTable.setViewportView(jTableCompoundData);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jButtonSearch.setText("Suche");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSearch.setText("Suche Anhand nicht leerer Felder");

        jLabelUpdateDelete.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelUpdateDelete.setText("UpdateAndDeleteText");

        jLabelAreaUnit.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAreaUnit.setText("m²");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompoundName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelContructionYear)
                                            .addComponent(jLabelDateOfBirth))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldConstructionYear, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldCompoundName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonDeleteCompound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAddCompound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUpdateCompound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelArea))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAreaUnit)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelShowDateTime)
                                    .addComponent(jLabelUpdateDelete)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabelID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneCompoundTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelSearch))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(944, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBack)
                    .addComponent(jLabelShowDateTime))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCompoundName)
                            .addComponent(jTextFieldCompoundName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelContructionYear)
                            .addComponent(jTextFieldConstructionYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDateOfBirth)
                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelArea)
                            .addComponent(jTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAreaUnit))
                        .addGap(59, 59, 59)
                        .addComponent(jButtonAddCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUpdateDelete)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelID))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneCompoundTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompoundActionPerformed
        // TODO 
        
        
         //Falls Fehler beim Einfügen
         JOptionPane.showMessageDialog(null, "Gehege konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Einfügen erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Gehege konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
         
    }//GEN-LAST:event_jButtonAddCompoundActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        
        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed
        
     
        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateActionPerformed
        
     
        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonUpdateActionPerformed

    
    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed
        
    
        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonUpdateCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCompoundActionPerformed
        // TODO
         //Falls Fehler beim Updaten
         JOptionPane.showMessageDialog(null, "Gehege konnte nicht geupdated werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Updaten erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Gehege wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonUpdateCompoundActionPerformed

    private void jButtonDeleteCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCompoundActionPerformed
          
            
           //Nachfragen ob er sich sicher ist, hier if Abfrage mache
       
          //TODO Cancel auf deutsch
         int decision = JOptionPane.showConfirmDialog(null,
                "Sind Sie sicher", "Löschbestätigung",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
          //OK = 0, cancel =2
     System.out.println(decision);


          //Falls Fehler beim Löschen
         JOptionPane.showMessageDialog(null, "Gehege konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Löschen erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Gehege wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                                                       
    }//GEN-LAST:event_jButtonDeleteCompoundActionPerformed

    
    /**
     * Method to disable/enable buttons/labels depending on
     *  operation selection.
     */
    private void updateButtonsAndLabels(){
        
        
       
            System.out.println("Compound Mode");
           
             
            if (jRadioButtonAdd.isSelected()){
                System.out.println("    Add mode");
                jLabelUpdateDelete.setText("");
                jButtonAddCompound.setEnabled(true);
                jButtonUpdateCompound.setEnabled(false);
                jButtonDeleteCompound.setEnabled(false);
                jTextFieldID.setEnabled(false);
                jLabelID.setEnabled(false);
                jLabelSearch.setEnabled(false);
                jButtonSearch.setEnabled(false);
          
                
                
               
            } else if (jRadioButtonUpdate.isSelected()){
                System.out.println("    Update mode");
               
                jLabelUpdateDelete.setText("Bitte die Daten des zu updatenden Geheges ausfüllen \n"
                        + "oder den Datensatz in der Tabelle anklicken und bearbeiten! ");
                jButtonAddCompound.setEnabled(false);
                jButtonUpdateCompound.setEnabled(true);
                jButtonDeleteCompound.setEnabled(false);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);
           
                
                
            } else if (jRadioButtonDelete.isSelected()){
                System.out.println("    Delete mode");
                
                jLabelUpdateDelete.setText("Bitte die ID des zu löschenden Geheges ausfüllen "
                        + "oder den Datensatz in der Tabelle anklicken! ");
                jButtonAddCompound.setEnabled(false);
                jButtonUpdateCompound.setEnabled(false);
                jButtonDeleteCompound.setEnabled(true);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ManageUserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUserJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCompoundJFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddCompound;
    private javax.swing.JButton jButtonDeleteCompound;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateCompound;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelAreaUnit;
    private javax.swing.JLabel jLabelCompoundName;
    private javax.swing.JLabel jLabelContructionYear;
    private javax.swing.JLabel jLabelDateOfBirth;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelUpdateDelete;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneCompoundTable;
    private javax.swing.JTable jTableCompoundData;
    private javax.swing.JTextField jTextArea;
    private javax.swing.JTextField jTextFieldCompoundName;
    private javax.swing.JTextField jTextFieldConstructionYear;
    private javax.swing.JTextField jTextFieldDateOfBirth;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
}
