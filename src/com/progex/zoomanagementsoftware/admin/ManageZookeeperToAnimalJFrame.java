package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZookeeperToAnimalManager;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.User;
import com.progex.zoomanagementsoftware.datatypes.ZookeeperToAnimalR;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ManageZookeeperToAnimalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageZookeeperToAnimalJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public ManageZookeeperToAnimalJFrame(JFrame goBackFrame, ZooManager zooManager) {

        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.zookeeperToAnimalManager = zooManager.getZookeeperToAnimalManager();
        methods = new Methods();

        myInitComponents();
    }

    private void myInitComponents() {

        jTextFieldUserID.setEnabled(false);
        jLabelZookeeperID.setEnabled(false);
        jTextFieldAnimalID.setEnabled(false);
        jLabelAnimalID.setEnabled(false);
        updateButtonsAndLabels();
        methods.showTimeAndDate(jLabelShowDateTime);
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");

        AutoCompleteDecorator.decorate(jComboBoxAnimalName);

        ArrayList<String> animalNames = zooManager.getAnimalManager().loadAnimalNames();

        jComboBoxAnimalName.setModel(new DefaultComboBoxModel<>(animalNames.toArray(new String[0])));
    }

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
        jButtonAddTakesCare = new javax.swing.JButton();
        jButtonDeleteTakesCare = new javax.swing.JButton();
        jLabelZookeeperID = new javax.swing.JLabel();
        jTextFieldUserID = new javax.swing.JTextField();
        jButtonHelp = new javax.swing.JButton();
        jLabelAnimalID = new javax.swing.JLabel();
        jTextFieldAnimalID = new javax.swing.JTextField();
        jComboBoxAnimalName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tierpfleger/-in zu Tier Zuweisung verwalten");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        jButtonSearchZookeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchZookeeperActionPerformed(evt);
            }
        });

        jLabelSelectZookeeper.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSelectZookeeper.setText("Bitte Tierpfleger/-in auswählen");

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
        jTableTakesCareData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTakesCareDataMouseClicked(evt);
            }
        });
        jScrollTakesCareTable.setViewportView(jTableTakesCareData);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSearch.setText("Suche Anhand nicht leerer Felder");

        jButtonSearch.setText("Suche");
        jButtonSearch.setToolTipText("Suche anhand des Tiernamen bzw seiner ID. Ein/e Tierpfleger-/in muss angeklickt sein !");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jScrollZookeeperTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableZookeeperData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Benutzer ID", "Anrede", "Vorname", "Nachname", "Benutzername"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableZookeeperData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableZookeeperData.getTableHeader().setReorderingAllowed(false);
        jTableZookeeperData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableZookeeperDataMouseClicked(evt);
            }
        });
        jScrollZookeeperTable.setViewportView(jTableZookeeperData);
        if (jTableZookeeperData.getColumnModel().getColumnCount() > 0) {
            jTableZookeeperData.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        jLabelAskAnimalName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAskAnimalName.setText("Bitte Tiernamen eingeben");

        jButtonAddTakesCare.setText("Hinzufügen");
        jButtonAddTakesCare.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddTakesCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTakesCareActionPerformed(evt);
            }
        });

        jButtonDeleteTakesCare.setText("Löschen");
        jButtonDeleteTakesCare.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonDeleteTakesCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteTakesCareActionPerformed(evt);
            }
        });

        jLabelZookeeperID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZookeeperID.setText("BenutzerID");

        jButtonHelp.setText("Hilfe");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        jLabelAnimalID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAnimalID.setText("TierID");

        jTextFieldAnimalID.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(108, Short.MAX_VALUE)
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
                                .addComponent(jComboBoxAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAddTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelOperation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonHelp))
                            .addComponent(jRadioButtonAdd)
                            .addComponent(jButtonDeleteTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGoBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelShowDateTime)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelZookeeperID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabelAnimalID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollTakesCareTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSearch, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addContainerGap(81, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelShowDateTime)
                    .addComponent(jButtonGoBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelOperation)
                            .addComponent(jButtonHelp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDelete)
                        .addGap(18, 18, 18)
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
                            .addComponent(jComboBoxAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelZookeeperID)
                            .addComponent(jTextFieldUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAnimalID)
                            .addComponent(jTextFieldAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollTakesCareTable, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed

        goBackFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void viewRelationTable() {

        methods.clearTable(jTableTakesCareData);

        fillRelationTable((DefaultTableModel) jTableTakesCareData.getModel());
    }

    private void fillRelationTable(DefaultTableModel model) {

        model = (DefaultTableModel) jTableTakesCareData.getModel();

        Object[] row = new Object[5];

        for (ZookeeperToAnimalR record : records) {

            row[0] = record.getUserId();
            row[1] = record.getFirstname();
            row[2] = record.getLastname();
            row[3] = record.getAnimalId();
            row[4] = record.getAnimalName();
            model.addRow(row);
        }
    }

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        try {
            //Wird benutzt für eine numberFormatException
            int exceptionUserId;
            String userId;
            if (!jTextFieldUserID.getText().isBlank()) {
                exceptionUserId = Integer.parseInt(jTextFieldUserID.getText());
                userId = jTextFieldUserID.getText().trim();
            } else {
                userId = "";
            }

            String firstname = jTextFieldZookeepeFirstName.getText().trim();
            String lastname = jTextFieldZookeeperLastName.getText().trim();
            String animalName = jComboBoxAnimalName.getSelectedItem().toString();

            lastSearchMap = new LinkedHashMap<String, String>();
            lastSearchMap.put("UserID", userId);
            lastSearchMap.put("firstname", firstname);
            lastSearchMap.put("lastname", lastname);
            lastSearchMap.put("animalName", animalName);

            records = zookeeperToAnimalManager.searchZookeeperToAnimal(lastSearchMap);

            if (records.isEmpty()) {
                methods.clearTable(jTableTakesCareData);
                JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
            } else {
                viewRelationTable();
            }

        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in SearchZookeeperToAnimal button");
            System.out.println(numberFormatException.getMessage());
            methods.clearTable(jTableTakesCareData);
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonDeleteTakesCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteTakesCareActionPerformed

        try {

            JTextField textFields[] = {jTextFieldUserID};

            //Ob BenutzerId fehlt
            if (jTextFieldUserID.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "BenutzerID fehlt!", "Textfeld ohne Inhalt", JOptionPane.CANCEL_OPTION);
            } else {
                //Wenn BenutzerID und Tiername nicht fehlen
                if (methods.verifyTextFields(textFields)) {

                    int zookeeperID = Integer.parseInt(jTextFieldUserID.getText());
                    String animalName = jComboBoxAnimalName.getSelectedItem().toString();;

                    int decision = JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (decision == 0) {

                        //Ob die Zuweisung existiert, wenn ja wird gelöscht, wenn nicht fehlermeldung
                        if (zookeeperToAnimalManager.checkZookeeperToAnimalExists(animalName, zookeeperID)) {
                            //Löschen erfolgreich
                            if (zookeeperToAnimalManager.deleteZookeeperToAnimal(zookeeperToAnimalManager.getAnimalIds(animalName), zookeeperID)) {
                                if (lastSearchMap != null) {
                                    records = zookeeperToAnimalManager.searchZookeeperToAnimal(lastSearchMap);
                                    viewRelationTable(); // um die Tabelle zu aktualiseren
                                }
                                JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                                jTextFieldAnimalID.setText("");
                                jTextFieldUserID.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        } else { //Fehlermeldung wenn die Zuweisung nicht existiert
                            JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung konnte nicht gefunden werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }

                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in DeleteZookeeperToAnimal button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonDeleteTakesCareActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        updateButtonsAndLabels();
        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Daten eingeben und auf Hinzufügen klicken!", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;

            case delete:
                JOptionPane.showMessageDialog(null, "Bitte einen Datensatz in der rechten Tabelle anklicken um zu löschen!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jButtonAddTakesCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTakesCareActionPerformed

        JTextField textFields[] = {jTextFieldZookeepeFirstName, jTextFieldZookeeperLastName};

        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        try {
            if (textFieldsVerified) {
                String animalName = jComboBoxAnimalName.getSelectedItem().toString();

                if (selectedZookeeperID == null) {
                    JOptionPane.showMessageDialog(null, "Bitte Tierpfleger/-in auswählen in der Tabelle!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }

                if (zookeeperToAnimalManager.checkZookeeperToAnimalExists(animalName, Integer.parseInt(selectedZookeeperID))) {
                    JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung existiert bereits!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                } else {
                    LinkedList<Integer> animalIds = zookeeperToAnimalManager.getAnimalIds(animalName);

                    if (zookeeperToAnimalManager.addZookeeperToAnimal(animalIds, selectedZookeeperID)) {
                        if (lastSearchMap != null) {
                            records = zookeeperToAnimalManager.searchZookeeperToAnimal(lastSearchMap);
                            viewRelationTable(); // Um die Tabelle zu aktualiseren
                        }
                        JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tierpfleger/-innen zu Tiere Zuweisung konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {
            
            System.err.println("NumberFormatException in AddZookeeperToAnimal button");
            System.out.println(numberFormatException.getMessage());
        }
    }//GEN-LAST:event_jButtonAddTakesCareActionPerformed

    private void fillZookeeperTable(DefaultTableModel model) {

        model = (DefaultTableModel) jTableZookeeperData.getModel();

        Object[] row = new Object[5];

        for (User zookeeper : zookeepers) {

            row[0] = zookeeper.getId();
            row[1] = methods.salutationToString(zookeeper.getSalutation());
            row[2] = zookeeper.getFirstname();
            row[3] = zookeeper.getLastname();
            row[4] = zookeeper.getUsername();
            model.addRow(row);
        }
    }

    private void viewZookeepers() {

        methods.clearTable(jTableZookeeperData);

        fillZookeeperTable((DefaultTableModel) jTableZookeeperData.getModel());
    }

    private void jButtonSearchZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchZookeeperActionPerformed

        try {

            JTextField textFields[] = {jTextFieldZookeepeFirstName, jTextFieldZookeeperLastName};

            String firstname = jTextFieldZookeepeFirstName.getText().trim();;
            String lastname = jTextFieldZookeeperLastName.getText().trim();

            lastSearchMap = new LinkedHashMap<String, String>();
            lastSearchMap.put("firstName", firstname);
            lastSearchMap.put("lastName", lastname);
            lastSearchMap.put("type", "Zookeeper");

            zookeepers = zooManager.getUserManager().searchUsers(lastSearchMap);

            if (zookeepers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
            } else {
                viewZookeepers();
            }

        } catch (NumberFormatException numberFormatException) {
            
            System.err.println("NumberFormatException in SearchZookeeper button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonSearchZookeeperActionPerformed

    private void jTableZookeeperDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableZookeeperDataMouseClicked

        jTextFieldUserID.setText("");
        jTextFieldAnimalID.setText("");
        int zookeeperRowIndex = jTableZookeeperData.getSelectedRow();
        TableModel zookeeperModel = jTableZookeeperData.getModel();

        selectedZookeeperID = zookeeperModel.getValueAt(zookeeperRowIndex, 0).toString();

        String firstName = zookeeperModel.getValueAt(zookeeperRowIndex, 2).toString();
        String lastName = zookeeperModel.getValueAt(zookeeperRowIndex, 3).toString();
        jTextFieldZookeepeFirstName.setText(firstName);
        jTextFieldZookeeperLastName.setText(lastName);

        lastSearchMap = new LinkedHashMap<>();
        lastSearchMap.put("UserID", selectedZookeeperID);
        lastSearchMap.put("firstname", firstName);
        lastSearchMap.put("lastname", lastName);

        records = zookeeperToAnimalManager.searchZookeeperToAnimal(lastSearchMap);

        if (!records.isEmpty()) {
            viewRelationTable();
        }

        if (mode == Mode.delete) {
            jTextFieldUserID.setText(selectedZookeeperID);
        }
    }//GEN-LAST:event_jTableZookeeperDataMouseClicked

    private void jTableTakesCareDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTakesCareDataMouseClicked

        int takesCareRowIndex = jTableTakesCareData.getSelectedRow();
        TableModel takesCareModel = jTableTakesCareData.getModel();

        selectedZookeeperID = takesCareModel.getValueAt(takesCareRowIndex, 0).toString();
        jTextFieldUserID.setText(selectedZookeeperID);
        String animalName = takesCareModel.getValueAt(takesCareRowIndex, 4).toString();
        jComboBoxAnimalName.setSelectedItem(animalName);
        String foodId = takesCareModel.getValueAt(takesCareRowIndex, 3).toString();
        jTextFieldAnimalID.setText(foodId);

        if (mode != Mode.add)
            jTextFieldUserID.setText(selectedZookeeperID);
    }//GEN-LAST:event_jTableTakesCareDataMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();
    }//GEN-LAST:event_formWindowClosing

    private void updateButtonsAndLabels() {

        if (jRadioButtonAdd.isSelected()) {

            System.out.println("    Add mode");
            jButtonAddTakesCare.setEnabled(true);
            jButtonDeleteTakesCare.setEnabled(false);
            jTextFieldUserID.setText("");
            jTextFieldAnimalID.setText("");
            jLabelSearch.setEnabled(false);
            jButtonSearch.setEnabled(false);
            mode = Mode.add;

        } else if (jRadioButtonDelete.isSelected()) {

            System.out.println("    Delete mode");

            jButtonAddTakesCare.setEnabled(false);
            jButtonDeleteTakesCare.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            mode = Mode.delete;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddTakesCare;
    private javax.swing.JButton jButtonDeleteTakesCare;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearchZookeeper;
    private javax.swing.JComboBox<String> jComboBoxAnimalName;
    private javax.swing.JLabel jLabelAnimalID;
    private javax.swing.JLabel jLabelAskAnimalName;
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
    private javax.swing.JTextField jTextFieldAnimalID;
    private javax.swing.JTextField jTextFieldUserID;
    private javax.swing.JTextField jTextFieldZookeepeFirstName;
    private javax.swing.JTextField jTextFieldZookeeperLastName;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private Methods methods;
    private LinkedList<User> zookeepers;
    private String selectedZookeeperID;
    private Mode mode;
    private LinkedList<ZookeeperToAnimalR> records;
    private LinkedHashMap<String, String> lastSearchMap;
    private ZookeeperToAnimalManager zookeeperToAnimalManager;
}