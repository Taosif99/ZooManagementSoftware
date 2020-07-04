package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.*;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageFoodJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageFoodJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public ManageFoodJFrame(JFrame goBackFrame, ZooManager zooManager) {

        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.foodManager = zooManager.getFoodManager();
        methods = new Methods();
        myInitComponents();
    }

    private void myInitComponents() {
        
        updateButtonsAndLabels();
        methods.showTimeAndDate(jLabelShowDateTime);
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupUnitSelection = new javax.swing.ButtonGroup();
        buttonGroupOperation = new javax.swing.ButtonGroup();
        buttonGroupUnitSelectionTable = new javax.swing.ButtonGroup();
        jButtonGoBack = new javax.swing.JButton();
        jLabellFoodName = new javax.swing.JLabel();
        jTextFieldFoodName = new javax.swing.JTextField();
        jPanelOperation = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jButtonHelp = new javax.swing.JButton();
        jLabelStorageRoomNumber = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jButtonAddFood = new javax.swing.JButton();
        jButtonUpdateFood = new javax.swing.JButton();
        jButtonDeleteFood = new javax.swing.JButton();
        jScrollPaneFoodTable = new javax.swing.JScrollPane();
        jTableFoodData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jRadioButtonKg = new javax.swing.JRadioButton();
        jRadioButtonGramm = new javax.swing.JRadioButton();
        jRadioButtonKgTable = new javax.swing.JRadioButton();
        jRadioButtonGrammTable = new javax.swing.JRadioButton();
        jTextFieldStorageRoomNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Futter verwalten");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        jLabellFoodName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabellFoodName.setText("Name");

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

        jButtonHelp.setText("Hilfe");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
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
                    .addGroup(jPanelOperationLayout.createSequentialGroup()
                        .addComponent(jLabelOperation)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonHelp))
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelOperationLayout.setVerticalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperation)
                    .addComponent(jButtonHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDelete)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabelStorageRoomNumber.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelStorageRoomNumber.setText("Lagerraum");

        jLabelStock.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelStock.setText("Menge");

        jTextFieldStock.setToolTipText("Format: zum Beispiel 9.87");

        jButtonAddFood.setText("Hinzufügen");
        jButtonAddFood.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFoodActionPerformed(evt);
            }
        });

        jButtonUpdateFood.setText("Updaten");
        jButtonUpdateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateFoodActionPerformed(evt);
            }
        });

        jButtonDeleteFood.setText("Löschen");
        jButtonDeleteFood.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonDeleteFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteFoodActionPerformed(evt);
            }
        });

        jScrollPaneFoodTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableFoodData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Lagerraum", "Menge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFoodData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableFoodData.getTableHeader().setReorderingAllowed(false);
        jTableFoodData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFoodDataMouseClicked(evt);
            }
        });
        jScrollPaneFoodTable.setViewportView(jTableFoodData);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelID.setText("ID");

        jButtonSearch.setText("Suche");
        jButtonSearch.setToolTipText("Suche anhand angegebener regulärer Ausdrücke, falls zum Beispiel Feld A und Feld B ausgefüllt sind, wird das Resultat den Ausdruck von A und B erfüllen.");
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

        buttonGroupUnitSelection.add(jRadioButtonKg);
        jRadioButtonKg.setSelected(true);
        jRadioButtonKg.setText("kg");

        buttonGroupUnitSelection.add(jRadioButtonGramm);
        jRadioButtonGramm.setText("g");

        buttonGroupUnitSelectionTable.add(jRadioButtonKgTable);
        jRadioButtonKgTable.setSelected(true);
        jRadioButtonKgTable.setText("kg");
        jRadioButtonKgTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKgTableActionPerformed(evt);
            }
        });

        buttonGroupUnitSelectionTable.add(jRadioButtonGrammTable);
        jRadioButtonGrammTable.setText("g");
        jRadioButtonGrammTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGrammTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelStorageRoomNumber)
                                            .addComponent(jLabelStock))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButtonKg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButtonGramm))
                                            .addComponent(jTextFieldStorageRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonAddFood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonUpdateFood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonDeleteFood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabellFoodName)
                                        .addGap(56, 56, 56)
                                        .addComponent(jTextFieldFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGoBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowDateTime)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneFoodTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearch))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButtonKgTable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButtonGrammTable)
                            .addGap(73, 73, 73))))
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGoBack)
                    .addComponent(jLabelShowDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelID)
                            .addComponent(jRadioButtonKgTable)
                            .addComponent(jRadioButtonGrammTable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneFoodTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabellFoodName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStorageRoomNumber)
                            .addComponent(jTextFieldStorageRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStock)
                            .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonKg)
                            .addComponent(jRadioButtonGramm))
                        .addGap(34, 34, 34)
                        .addComponent(jButtonAddFood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteFood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed

        goBackFrame.setVisible(true);
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

    private void jButtonUpdateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateFoodActionPerformed

        try {
            JTextField textFields[] = {jTextFieldStorageRoomNumber, jTextFieldStock, jTextFieldFoodName, jTextFieldID};
            if (methods.verifyTextFields(textFields)) {
                
                String storageRoomNumber = jTextFieldStorageRoomNumber.getText();
                double stock;
                if (jRadioButtonGramm.isSelected()) {
                    stock = Double.parseDouble(jTextFieldStock.getText()) / 1000;
                } else {
                    stock = Double.parseDouble(jTextFieldStock.getText());
                }
                String foodName = jTextFieldFoodName.getText();
                int ID = Integer.parseInt(jTextFieldID.getText());
                int decision = JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich ändern?", "Bestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (decision == 0) {
                    if (!foodManager.checkFoodExists(null, ID)) {
                        JOptionPane.showMessageDialog(null, "ID existiert nicht!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    } else {
                        if (stock >= 0) {
                            if (foodManager.updateFood(storageRoomNumber, stock, foodName, ID)) {
                                JOptionPane.showMessageDialog(null, "Futter wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                                if (lastSearchMap != null) {
                                    if (jRadioButtonKgTable.isSelected()) {
                                        foods = foodManager.searchFoods(lastSearchMap);
                                        viewFoods(1);
                                    } else {
                                        foods = foodManager.searchFoods(lastSearchMap);
                                        viewFoods(1000);
                                    }
                                }
                                clearTextFields();
                            } else {
                                JOptionPane.showMessageDialog(null, "Futter konnte nicht geupdatet werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Futtermenge darf nicht negativ sein!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {
            
            System.err.println("NumberFormatException in UpdateFood button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonUpdateFoodActionPerformed

    private void jButtonDeleteFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteFoodActionPerformed

        try {
            JTextField textFields[] = {jTextFieldID};
            boolean textFieldsVerified = methods.verifyTextFields(textFields);
            int ID = Integer.parseInt(jTextFieldID.getText());
            if (textFieldsVerified) {
                int decision = JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (decision == 0) {
                    if (!foodManager.checkFoodExists(null, ID)) {
                        JOptionPane.showMessageDialog(null, "ID existiert nicht!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    } else {
                        if (foodManager.deleteFood(ID)) {
                            JOptionPane.showMessageDialog(null, "Futter wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                            if (lastSearchMap != null) {
                                if (jRadioButtonKgTable.isSelected()) {
                                    foods = foodManager.searchFoods(lastSearchMap);
                                    viewFoods(1);
                                } else {
                                    foods = foodManager.searchFoods(lastSearchMap);
                                    viewFoods(1000);
                                }
                            }
                            clearTextFields();
                        } else {
                            JOptionPane.showMessageDialog(null, "Futter konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {

            if (!jTextFieldID.getText().isBlank()) {
                System.err.println("NumberFormatException in DeleteFood button");
                System.out.println(numberFormatException.getMessage());
                JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
            }
        }
    }//GEN-LAST:event_jButtonDeleteFoodActionPerformed

    private void fillTable(DefaultTableModel model, int i) {
        
        model = (DefaultTableModel) jTableFoodData.getModel();

        Object[] row = new Object[4];

        for (Food food : foods) {
            row[0] = food.getId();
            row[1] = food.getName();
            row[2] = food.getStorageRoomNumber();
            double stock = food.getStock() * i;
            //rounding
            row[3] = Math.round(stock * 100.0) / 100.0;
            model.addRow(row);
        }
    }

    private void viewFoods(int i) {

        methods.clearTable(jTableFoodData);

        fillTable((DefaultTableModel) jTableFoodData.getModel(), i);
    }

    private LinkedHashMap<String, String> getJTextFieldInput() {

        lastSearchMap = new LinkedHashMap<String, String>();
        try {
            //Brauche ich für NumberFormatException
            int exceptionId;
            String id;
            if (!jTextFieldID.getText().isBlank()) {
                exceptionId = Integer.parseInt(jTextFieldID.getText());
                id = jTextFieldID.getText().trim();
            } else {
                id = "";
            }

            String storageRoomNumber = jTextFieldStorageRoomNumber.getText().trim();

            double exceptionStock;
            String stock;
            if (!jTextFieldStock.getText().isBlank()) {

                exceptionStock = Double.parseDouble(jTextFieldStock.getText().trim());
                
                if (jRadioButtonGramm.isSelected()) {
                    exceptionStock = exceptionStock / 1000;
                    System.out.println(exceptionStock);
                }

                stock = Double.toString(exceptionStock);

                stock = methods.removeComma(stock);
            } else {
                stock = "";
            }

            String foodName = jTextFieldFoodName.getText().trim();

            lastSearchMap.put("ID", id);
            lastSearchMap.put("StorageRoomNumber", storageRoomNumber);
            lastSearchMap.put("Stock", stock);
            lastSearchMap.put("Name", foodName);
            return lastSearchMap;

        } catch (NumberFormatException numberFormatException) {
            
            System.err.println("NumberFormatException in getJTextFieldInput()");
            System.out.println(numberFormatException.getMessage());
            methods.clearTable(jTableFoodData);
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);

        }
        return null; //Wenn Zahlenfeld falsch ausgefüllt wurde
    }

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        LinkedHashMap<String, String> columnToValue = getJTextFieldInput();
        if (columnToValue != null) {
            foods = foodManager.searchFoods(columnToValue);
        }

        try {
            if (foods.isEmpty() || columnToValue == null) {
                methods.clearTable(jTableFoodData);
                if (foods.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (jRadioButtonGrammTable.isSelected()) {
                    viewFoods(1000);
                } else if (jRadioButtonKgTable.isSelected()) {
                    viewFoods(1);
                }
            }
        } catch (NullPointerException nullPointerException) {
            
            //Wenn man Zahlenfeld falsch ausfüllt hat und dadurch columnToValue null ist
            System.err.println("NullPointerException in SearchFood button");
            System.out.println(nullPointerException.getMessage());
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jRadioButtonKgTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKgTableActionPerformed
        viewFoods(1);
    }//GEN-LAST:event_jRadioButtonKgTableActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        updateButtonsAndLabels();
        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Daten eingeben und auf Hinzufügen klicken", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;

            case update:
                JOptionPane.showMessageDialog(null, "Bitte die Daten des zu updatenden Futters ausfüllen oder den Datensatz in der Tabelle anklicken und bearbeiten! ", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                break;

            case delete:
                JOptionPane.showMessageDialog(null, "Bitte die ID des zu löschenden Futters ausfüllen oder den Datensatz in der Tabelle anklicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void clearTextFields() {

        if (mode == Mode.add) {
            JTextField textFields[] = {jTextFieldStorageRoomNumber, jTextFieldStock, jTextFieldFoodName};
            for (JTextField textField : textFields) {
                textField.setText("");
            }
        } else if (mode == Mode.update || mode == Mode.delete) {
            JTextField textFields[] = {jTextFieldStorageRoomNumber, jTextFieldStock, jTextFieldFoodName, jTextFieldID};
            for (JTextField textField : textFields) {
                textField.setText("");
            }
        }
    }

    private void jButtonAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFoodActionPerformed

        try {
            JTextField textFields[] = {jTextFieldStorageRoomNumber, jTextFieldStock, jTextFieldFoodName};

            boolean textFieldsVerified = methods.verifyTextFields(textFields);

            if (textFieldsVerified) {

                String storageRoomNumber = jTextFieldStorageRoomNumber.getText();

                double stock;
                if (jRadioButtonGramm.isSelected()) {
                    stock = Double.parseDouble(jTextFieldStock.getText()) / 1000;
                } else {
                    stock = Double.parseDouble(jTextFieldStock.getText());
                }
                String foodName = jTextFieldFoodName.getText();

                if (!foodManager.checkFoodExists(foodName, -1)) {
                    //Checken ob Futtermenge positiv ist
                    if (stock >= 0) {
                        if (foodManager.addFood(storageRoomNumber, stock, foodName)) {
                            clearTextFields();
                            JOptionPane.showMessageDialog(null, "Futter konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Futter konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Futtermenge darf nicht negativ sein!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Das Futter existiert bereits in der Datenbank!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            }
        } catch (NumberFormatException numberFormatException) {
            
            System.err.println("NumberFormatException in AddFood button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt.", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonAddFoodActionPerformed

    private void jRadioButtonGrammTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGrammTableActionPerformed

        viewFoods(1000);
    }//GEN-LAST:event_jRadioButtonGrammTableActionPerformed

    private void jTableFoodDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFoodDataMouseClicked
        
        int foodRowIndex = jTableFoodData.getSelectedRow();
        TableModel foodModel = jTableFoodData.getModel();

        String foodID = foodModel.getValueAt(foodRowIndex, 0).toString();
        String foodName = foodModel.getValueAt(foodRowIndex, 1).toString();
        String storageRoomNumber = foodModel.getValueAt(foodRowIndex, 2).toString();

        if (mode == Mode.delete || mode == Mode.update) {
            jTextFieldFoodName.setText(foodName);
            jTextFieldID.setText(foodID);
            jTextFieldStorageRoomNumber.setText(storageRoomNumber);
            
            //4 Cases
            //1 and 2, if animalTable is g and relation Table is g
            //or if both tables are kg
            if ((jRadioButtonGramm.isSelected() && jRadioButtonGrammTable.isSelected())
                    || jRadioButtonKg.isSelected() && jRadioButtonKgTable.isSelected()) {
                
                jTextFieldStock.setText(foodModel.getValueAt(foodRowIndex, 3).toString());
            } //3 case if textField is Kg and Table is g
            else if (jRadioButtonGramm.isSelected() && jRadioButtonKgTable.isSelected()) {

                double value = (double) foodModel.getValueAt(foodRowIndex, 3);
                value *= 1000;
                jTextFieldStock.setText(String.valueOf(value));
            } //4 case if textField is g and Table is Kg
            else if (jRadioButtonKg.isSelected() && jRadioButtonGrammTable.isSelected()) {
                
                double value = (double) foodModel.getValueAt(foodRowIndex, 3);
                value /= 1000;
                jTextFieldStock.setText(String.valueOf(value));
            }
        }
    }//GEN-LAST:event_jTableFoodDataMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();
    }//GEN-LAST:event_formWindowClosing

    private void updateButtonsAndLabels() {

        System.out.println("Manage Food");

        if (jRadioButtonAdd.isSelected()) {

            System.out.println("    Add mode");
            methods.clearTable(jTableFoodData);
            jButtonAddFood.setEnabled(true);
            jButtonUpdateFood.setEnabled(false);
            jButtonDeleteFood.setEnabled(false);
            jTextFieldID.setEnabled(false);
            jTextFieldID.setText("");
            jLabelID.setEnabled(false);
            jLabelSearch.setEnabled(false);
            jButtonSearch.setEnabled(false);
            jRadioButtonKgTable.setEnabled(false);
            jRadioButtonGrammTable.setEnabled(false);
            mode = Mode.add;

        } else if (jRadioButtonUpdate.isSelected()) {

            System.out.println("    Update mode");

            jButtonAddFood.setEnabled(false);
            jButtonUpdateFood.setEnabled(true);
            jButtonDeleteFood.setEnabled(false);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jRadioButtonKgTable.setEnabled(true);
            jRadioButtonGrammTable.setEnabled(true);
            mode = Mode.update;

        } else if (jRadioButtonDelete.isSelected()) {

            System.out.println("    Delete mode");

            jButtonAddFood.setEnabled(false);
            jButtonUpdateFood.setEnabled(false);
            jButtonDeleteFood.setEnabled(true);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jRadioButtonKgTable.setEnabled(true);
            jRadioButtonGrammTable.setEnabled(true);
            mode = Mode.delete;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.ButtonGroup buttonGroupUnitSelection;
    private javax.swing.ButtonGroup buttonGroupUnitSelectionTable;
    private javax.swing.JButton jButtonAddFood;
    private javax.swing.JButton jButtonDeleteFood;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateFood;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelStorageRoomNumber;
    private javax.swing.JLabel jLabellFoodName;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonGramm;
    private javax.swing.JRadioButton jRadioButtonGrammTable;
    private javax.swing.JRadioButton jRadioButtonKg;
    private javax.swing.JRadioButton jRadioButtonKgTable;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneFoodTable;
    private javax.swing.JTable jTableFoodData;
    private javax.swing.JTextField jTextFieldFoodName;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JTextField jTextFieldStorageRoomNumber;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private Methods methods;
    private Mode mode;
    private LinkedList<Food> foods;
    private LinkedHashMap<String, String> lastSearchMap;
    private FoodManager foodManager;
}