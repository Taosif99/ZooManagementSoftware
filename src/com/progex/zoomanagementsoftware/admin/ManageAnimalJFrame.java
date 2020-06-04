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
public class ManageAnimalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserJFrame
     */
    
    
    public ManageAnimalJFrame() {
        initComponents();
        myInitComponents();
    }
    
    
    
    
    public void myInitComponents(){
        updateButtonsAndLabels();
        Methods methods = new Methods();    
        methods.showTimeAndDate(jLabelShowDateTime);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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
        jLabelAnimalName = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        jLabelDateOfBirth = new javax.swing.JLabel();
        jLabelCompound = new javax.swing.JLabel();
        jLabelSpecies = new javax.swing.JLabel();
        jTextFieldAnimalName = new javax.swing.JTextField();
        jTextFieldSex = new javax.swing.JTextField();
        jTextCompound = new javax.swing.JTextField();
        jTextFieldDateOfBirth = new javax.swing.JTextField();
        jComboBoxSpecies = new javax.swing.JComboBox<>();
        jButtonAddAnimal = new javax.swing.JButton();
        jButtonUpdateAnimal = new javax.swing.JButton();
        jButtonDeleteAnimal = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonGoBack = new javax.swing.JButton();
        jPanelOperation = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jScrollPaneAnimalTable = new javax.swing.JScrollPane();
        jTableAnimalData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jButtonAssignFeedingTimes = new javax.swing.JButton();
        jButtonAssignZookeeper = new javax.swing.JButton();
        jLabelUpdateDelete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tier verwalten");

        jLabelAnimalName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAnimalName.setText("Tiername");

        jLabelSex.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSex.setText("Geschlecht");

        jLabelDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelDateOfBirth.setText("Geburtsdatum");

        jLabelCompound.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCompound.setText("Gehege");

        jLabelSpecies.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSpecies.setText("Spezies");

        jComboBoxSpecies.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Säugetier", "Fisch", "Vogel", "Amphibie", "Reptil", "Insekt", "Spinnentier", "Wirbellos. " }));
        jComboBoxSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSpeciesActionPerformed(evt);
            }
        });

        jButtonAddAnimal.setText("Hinzufügen");
        jButtonAddAnimal.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAnimalActionPerformed(evt);
            }
        });

        jButtonUpdateAnimal.setText("Updaten");
        jButtonUpdateAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateAnimalActionPerformed(evt);
            }
        });

        jButtonDeleteAnimal.setText("Löschen");
        jButtonDeleteAnimal.setMaximumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteAnimal.setMinimumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAnimalActionPerformed(evt);
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

        jScrollPaneAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableAnimalData.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAnimalData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableAnimalData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAnimalTable.setViewportView(jTableAnimalData);

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

        jButtonAssignFeedingTimes.setText("Fütterungszeiten bearbeiten");
        jButtonAssignFeedingTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignFeedingTimesActionPerformed(evt);
            }
        });

        jButtonAssignZookeeper.setText("Tierpfleger/in zuweisen");
        jButtonAssignZookeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignZookeeperActionPerformed(evt);
            }
        });

        jLabelUpdateDelete.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelUpdateDelete.setText("UpdateAndDeleteText");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAnimalName)
                                .addGap(66, 66, 66)
                                .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSex)
                                            .addComponent(jLabelDateOfBirth)
                                            .addComponent(jLabelSpecies)
                                            .addComponent(jLabelCompound))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldSex, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonDeleteAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAddAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUpdateAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonAssignFeedingTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)))
                            .addComponent(jButtonAssignZookeeper, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowDateTime)
                            .addComponent(jLabelUpdateDelete)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabelID)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelSearch)))))
                    .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBack)
                    .addComponent(jLabelShowDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUpdateDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAnimalName)
                            .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSex)
                            .addComponent(jTextFieldSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDateOfBirth)
                            .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSpecies)
                            .addComponent(jComboBoxSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCompound)
                            .addComponent(jTextCompound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAssignFeedingTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAssignZookeeper, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSpeciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSpeciesActionPerformed

    private void jButtonAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAnimalActionPerformed
        // TODO 
        
        
         //Falls Fehler beim Einfügen
         JOptionPane.showMessageDialog(null, "Tier konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Einfügen erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Tier konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
         
    }//GEN-LAST:event_jButtonAddAnimalActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        // TODO GO BACK TO MAIN MENU OF ADMIN
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

    private void jButtonAssignFeedingTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignFeedingTimesActionPerformed
        // TODO GO TO FeedingTime FORM
    }//GEN-LAST:event_jButtonAssignFeedingTimesActionPerformed

    private void jButtonAssignZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignZookeeperActionPerformed
        // TODO GOTO Relationship between Animal and Zookeeper FORM
    }//GEN-LAST:event_jButtonAssignZookeeperActionPerformed

    private void jButtonUpdateAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateAnimalActionPerformed
        // TODO
         //Falls Fehler beim Updaten
         JOptionPane.showMessageDialog(null, "Tier konnte nicht geupdated werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Updaten erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Tier wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonUpdateAnimalActionPerformed

    private void jButtonDeleteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAnimalActionPerformed
          
            
           //Nachfragen ob er sich sicher ist, hier if Abfrage mache
       
          //TODO Cancel auf deutsch
         int decision = JOptionPane.showConfirmDialog(null,
                "Sind Sie sicher", "Löschbestätigung",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
          //OK = 0, cancel =2
     System.out.println(decision);


          //Falls Fehler beim Löschen
         JOptionPane.showMessageDialog(null, "Tier konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        
         //Falls Löschen erfolgreich, pfeil wäre besser
         JOptionPane.showMessageDialog(null, "Tier wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                                                       
    }//GEN-LAST:event_jButtonDeleteAnimalActionPerformed

    
     /**
     * Method to disable/enable buttons and labels depending on
     *  operation selection.
     */
    private void updateButtonsAndLabels(){
        
        
       
            System.out.println("Animal Mode");
           
             
            if (jRadioButtonAdd.isSelected()){
                System.out.println("    Add mode");
                jLabelUpdateDelete.setText("");
                jButtonAddAnimal.setEnabled(true);
                jButtonUpdateAnimal.setEnabled(false);
                jButtonDeleteAnimal.setEnabled(false);
                jTextFieldID.setEnabled(false);
                jLabelID.setEnabled(false);
                jLabelSearch.setEnabled(false);
                jButtonSearch.setEnabled(false);
                jButtonAssignFeedingTimes.setEnabled(true);
                jButtonAssignZookeeper.setEnabled(true);
                
                
               
            } else if (jRadioButtonUpdate.isSelected()){
                System.out.println("    Update mode");
               
                jLabelUpdateDelete.setText("Bitte die Daten des zu updatenden Tieres ausfüllen \n"
                        + "oder den Datensatz in der Tabelle anklicken und bearbeiten! ");
                jButtonAddAnimal.setEnabled(false);
                jButtonUpdateAnimal.setEnabled(true);
                jButtonDeleteAnimal.setEnabled(false);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);
                jButtonAssignFeedingTimes.setEnabled(true);
                jButtonAssignZookeeper.setEnabled(true);
                
                
            } else if (jRadioButtonDelete.isSelected()){
                System.out.println("    Delete mode");
                
                jLabelUpdateDelete.setText("Bitte die ID des zu löschenden Tieres ausfüllen \n"
                        + "oder den Datensatz in der Tabelle anklicken! ");
                jButtonAddAnimal.setEnabled(false);
                jButtonUpdateAnimal.setEnabled(false);
                jButtonDeleteAnimal.setEnabled(true);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);
                jButtonAssignFeedingTimes.setEnabled(false);
                jButtonAssignZookeeper.setEnabled(false);
                
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
                new ManageAnimalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddAnimal;
    private javax.swing.JButton jButtonAssignFeedingTimes;
    private javax.swing.JButton jButtonAssignZookeeper;
    private javax.swing.JButton jButtonDeleteAnimal;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateAnimal;
    private javax.swing.JComboBox<String> jComboBoxSpecies;
    private javax.swing.JLabel jLabelAnimalName;
    private javax.swing.JLabel jLabelCompound;
    private javax.swing.JLabel jLabelDateOfBirth;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelSpecies;
    private javax.swing.JLabel jLabelUpdateDelete;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneAnimalTable;
    private javax.swing.JTable jTableAnimalData;
    private javax.swing.JTextField jTextCompound;
    private javax.swing.JTextField jTextFieldAnimalName;
    private javax.swing.JTextField jTextFieldDateOfBirth;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldSex;
    // End of variables declaration//GEN-END:variables
}