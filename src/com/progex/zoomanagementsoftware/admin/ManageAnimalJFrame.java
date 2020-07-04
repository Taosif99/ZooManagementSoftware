package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.AnimalManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.CompoundManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Animal;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageAnimalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageAnimalJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public ManageAnimalJFrame(JFrame goBackFrame, ZooManager zooManager) {
        
        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        animalManager = zooManager.getAnimalManager();
        methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        myInitComponents();
        lastSearchedAnimals = null;
        lastSearchMap = null;
    }

    private void myInitComponents() {
        
        updateButtonsAndLabels();
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");
    }

    private void cleanFields() {

        jTextFieldAnimalName.setText("");
        jTextFieldCompound.setText("");
        jTextFieldDateOfBirth.setText("");
        jTextFieldID.setText("");
    }

    private void viewAnimals(LinkedList<Animal> animals) {

        methods.clearTable(jTableAnimalData);
        DefaultTableModel model = (DefaultTableModel) jTableAnimalData.getModel();
        Object[] row = new Object[7]; // Spalten

        for (Animal animal : animals) {
            row[0] = animal.getId();
            row[1] = animal.getName();
            row[2] = animal.getSex();
            row[3] = animal.getBirthday();
            row[4] = methods.descriptionToString(animal.getSpecies().getDescription());
            row[5] = animal.getCompound().getName();
            row[6] = animal.getVisibleForGuest();
            model.addRow(row);
        }
    }

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
        jTextFieldCompound = new javax.swing.JTextField();
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
        jButtonHelp = new javax.swing.JButton();
        jScrollPaneAnimalTable = new javax.swing.JScrollPane();
        jTableAnimalData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jButtonAssignFeedingTimes = new javax.swing.JButton();
        jButtonAssignZookeeper = new javax.swing.JButton();
        jComboBoxSex = new javax.swing.JComboBox<>();
        jLabelVisibleForGuests = new javax.swing.JLabel();
        jComboBoxVisibleForGuests = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tier verwalten");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jTextFieldDateOfBirth.setToolTipText("Format: yyyy-MM-dd");

        jComboBoxSpecies.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Säugetier", "Fisch", "Vogel", "Amphibie", "Reptil", "Insekt", "Spinnentier", "Wirbellos" }));

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHelp))
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOperationLayout.setVerticalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addContainerGap()
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

        jScrollPaneAnimalTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableAnimalData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tiername", "Geschlecht", "Geburtsdatum", "Spezies", "Gehege", "Sichtbar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAnimalData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableAnimalData.getTableHeader().setReorderingAllowed(false);
        jTableAnimalData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAnimalDataMouseClicked(evt);
            }
        });
        jScrollPaneAnimalTable.setViewportView(jTableAnimalData);
        if (jTableAnimalData.getColumnModel().getColumnCount() > 0) {
            jTableAnimalData.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTableAnimalData.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTableAnimalData.getColumnModel().getColumn(3).setPreferredWidth(300);
            jTableAnimalData.getColumnModel().getColumn(4).setPreferredWidth(300);
            jTableAnimalData.getColumnModel().getColumn(5).setPreferredWidth(400);
            jTableAnimalData.getColumnModel().getColumn(6).setPreferredWidth(250);
        }

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jButtonSearch.setText("Suche");
        jButtonSearch.setToolTipText("Suche anhand angegebener regulärer Ausdrücke und Spezies, falls zum Beispiel Feld A und Feld B ausgefüllt sind, wird das Resultat den Ausdruck von A und B erfüllen.");
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

        jButtonAssignZookeeper.setText("Tierpfleger/-in zuweisen");
        jButtonAssignZookeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignZookeeperActionPerformed(evt);
            }
        });

        jComboBoxSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "W", "U" }));
        jComboBoxSex.setToolTipText("W für weiblich, M für männlich, U für undefeniert");

        jLabelVisibleForGuests.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelVisibleForGuests.setText("Sichtbar für Gäste");

        jComboBoxVisibleForGuests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ja", "Nein" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSex)
                            .addComponent(jLabelAnimalName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonDeleteAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAddAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUpdateAnimal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAssignFeedingTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAssignZookeeper, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelVisibleForGuests)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxVisibleForGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDateOfBirth)
                                    .addComponent(jLabelSpecies)
                                    .addComponent(jLabelCompound))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCompound, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSpecies, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSex, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowDateTime))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnimalName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSex)
                    .addComponent(jComboBoxSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDateOfBirth)
                    .addComponent(jTextFieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSpecies)
                    .addComponent(jComboBoxSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCompound)
                    .addComponent(jTextFieldCompound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVisibleForGuests)
                    .addComponent(jComboBoxVisibleForGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAssignFeedingTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAssignZookeeper, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelShowDateTime)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAnimalActionPerformed

        jTextFieldID.setText("");

        JTextField textFields[] = {jTextFieldAnimalName, jTextFieldCompound,
            jTextFieldDateOfBirth};

        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        if (textFieldsVerified) {

            String animalName = jTextFieldAnimalName.getText();
            String compoundName = jTextFieldCompound.getText();
            String date = jTextFieldDateOfBirth.getText();
            String sex = jComboBoxSex.getSelectedItem().toString();
            String species = jComboBoxSpecies.getSelectedItem().toString();
            String visibility = jComboBoxVisibleForGuests.getSelectedItem().toString();

            boolean dateFormatCorrect = methods.isValidDateString(date);
            CompoundManager compoundManager = zooManager.getCompoundManager();

            boolean compoundNameExists = compoundManager.compoundExists(compoundName);

            if (compoundNameExists) {
                if (dateFormatCorrect) {

                    if (animalManager.addAnimal(animalName, compoundName, date, sex, species, visibility)) {
                        JOptionPane.showMessageDialog(null, "Tier konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                        cleanFields();

                    } else {
                        JOptionPane.showMessageDialog(null, "Tier konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Falsches Datumformat!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Gehege existiert nicht!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
            }
        }
    }//GEN-LAST:event_jButtonAddAnimalActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed

        goBackFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed

        jTextFieldID.setText("");
        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonUpdateActionPerformed


    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        String animalName = jTextFieldAnimalName.getText().trim();
        String compoundName = jTextFieldCompound.getText().trim();
        String birthday = jTextFieldDateOfBirth.getText().trim();
        String sex = jComboBoxSex.getSelectedItem().toString();
        String species = jComboBoxSpecies.getSelectedItem().toString();
        String ID = jTextFieldID.getText().trim();
        String visibility = jComboBoxVisibleForGuests.getSelectedItem().toString();

        LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
        columnNameToValue.put("Animal.ID", ID);
        columnNameToValue.put("AnimalName", animalName);
        columnNameToValue.put("Sex", sex);
        columnNameToValue.put("Birthday", birthday);
        columnNameToValue.put("Description", species);
        columnNameToValue.put("Name", compoundName);
        columnNameToValue.put("visibleForGuest", visibility);

        lastSearchMap = columnNameToValue;

        LinkedList<Animal> animals = animalManager.searchAnimals(columnNameToValue);
        if (!animals.isEmpty())
            viewAnimals(animals);
        else {
            JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
            methods.clearTable(jTableAnimalData);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonAssignFeedingTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignFeedingTimesActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame FoodToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodToAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonAssignFeedingTimesActionPerformed

    private void jButtonAssignZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignZookeeperActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonAssignZookeeperActionPerformed

    private void jButtonUpdateAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateAnimalActionPerformed

        JTextField textFields[] = {
            jTextFieldAnimalName,
            jTextFieldCompound,
            jTextFieldDateOfBirth,
            jTextFieldID};

        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        if (textFieldsVerified) {

            String animalName = jTextFieldAnimalName.getText();
            String compoundName = jTextFieldCompound.getText();
            String date = jTextFieldDateOfBirth.getText();
            String sex = jComboBoxSex.getSelectedItem().toString();
            String species = jComboBoxSpecies.getSelectedItem().toString();
            String visibility = jComboBoxVisibleForGuests.getSelectedItem().toString();
            try {
                int ID = Integer.parseInt(jTextFieldID.getText());

                boolean dateFormatCorrect = methods.isValidDateString(date);
                CompoundManager compoundManager = zooManager.getCompoundManager();
                boolean compoundNameExists = compoundManager.compoundExists(compoundName);
                if (compoundNameExists) {
                    if (dateFormatCorrect) {
                        int decision = JOptionPane.showConfirmDialog(null, "Wollen Sie den Datensatz wirklich ändern?", "Bestätigung", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (decision == 0) {
                            if (animalManager.updateAnimal(ID, animalName, compoundName, date, sex, species, visibility)) {
                                JOptionPane.showMessageDialog(null, "Tier wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                                cleanFields();
                                //Update table if old search exist
                                if (lastSearchMap != null) {
                                    lastSearchedAnimals = animalManager.searchAnimals(lastSearchMap);
                                    viewAnimals(lastSearchedAnimals);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Tier konnte nicht geupdatet werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Bitte Geburtstag im Format yyyy-MM-dd eintragen!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Gehege existiert nicht!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            } catch (NumberFormatException numberFormatException) {

                System.err.println("NumberFormatException in UpdateAnimal button");
                System.out.println(numberFormatException.getMessage());
                JOptionPane.showMessageDialog(null, "ID Feld falsch ausgefüllt!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
            }
        }
    }//GEN-LAST:event_jButtonUpdateAnimalActionPerformed

    private void jButtonDeleteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAnimalActionPerformed

        JTextField textFields[] = {jTextFieldID};
        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        try {
            int ID = Integer.parseInt(jTextFieldID.getText());

            if (textFieldsVerified) {

                int decision = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (decision == 0) {
                    if (animalManager.deleteAnimal(ID)) {
                        JOptionPane.showMessageDialog(null, "Tier wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                        cleanFields();

                        //Update table if old search exist
                        if (lastSearchMap != null) {
                            lastSearchedAnimals = animalManager.searchAnimals(lastSearchMap);
                            viewAnimals(lastSearchedAnimals);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tier konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in DeleteAnimal button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "ID Feld falsch ausgefüllt!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);

        }
    }//GEN-LAST:event_jButtonDeleteAnimalActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        //Get the mode
        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Daten eingeben und auf Hinzufügen klicken!", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;

            case update:
                JOptionPane.showMessageDialog(null, "Bitte die Daten des zu updatenden Tieres ausfüllen oder den Datensatz in der Tabelle anklicken und bearbeiten!", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                break;
            case delete:
                JOptionPane.showMessageDialog(null, "Bitte die ID des zu löschenden Tieres ausfüllen oder den Datensatz in der Tabelle anklicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed


    private void jTableAnimalDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAnimalDataMouseClicked

        if (!mode.equals(Mode.add)) {

            int rowIndex = jTableAnimalData.getSelectedRow();
            TableModel model = jTableAnimalData.getModel();
            jTextFieldID.setText(model.getValueAt(rowIndex, 0).toString());
            jTextFieldAnimalName.setText(model.getValueAt(rowIndex, 1).toString());
            String sex = (model.getValueAt(rowIndex, 2).toString());
            jComboBoxSex.setSelectedItem(sex);

            jTextFieldDateOfBirth.setText(model.getValueAt(rowIndex, 3).toString());

            String species = model.getValueAt(rowIndex, 4).toString();
            jComboBoxSpecies.setSelectedItem(species);
            jTextFieldCompound.setText(model.getValueAt(rowIndex, 5).toString());
        }
    }//GEN-LAST:event_jTableAnimalDataMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();
    }//GEN-LAST:event_formWindowClosing

    private void updateButtonsAndLabels() {

        System.out.println("Animal Mode");

        if (jRadioButtonAdd.isSelected()) {
            
            System.out.println("    Add mode");
            jButtonAddAnimal.setEnabled(true);
            jButtonUpdateAnimal.setEnabled(false);
            jButtonDeleteAnimal.setEnabled(false);
            jTextFieldID.setEnabled(false);
            jLabelID.setEnabled(false);
            jLabelSearch.setEnabled(false);
            jButtonSearch.setEnabled(false);
            jButtonAssignFeedingTimes.setEnabled(true);
            jButtonAssignZookeeper.setEnabled(true);
            mode = Mode.add;
            methods.clearTable(jTableAnimalData);

        } else if (jRadioButtonUpdate.isSelected()) {
            
            System.out.println("    Update mode");
            jButtonAddAnimal.setEnabled(false);
            jButtonUpdateAnimal.setEnabled(true);
            jButtonDeleteAnimal.setEnabled(false);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jButtonAssignFeedingTimes.setEnabled(true);
            jButtonAssignZookeeper.setEnabled(true);
            mode = Mode.update;

        } else if (jRadioButtonDelete.isSelected()) {
            
            System.out.println("    Delete mode");
            jButtonAddAnimal.setEnabled(false);
            jButtonUpdateAnimal.setEnabled(false);
            jButtonDeleteAnimal.setEnabled(true);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jButtonAssignFeedingTimes.setEnabled(false);
            jButtonAssignZookeeper.setEnabled(false);
            mode = Mode.delete;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddAnimal;
    private javax.swing.JButton jButtonAssignFeedingTimes;
    private javax.swing.JButton jButtonAssignZookeeper;
    private javax.swing.JButton jButtonDeleteAnimal;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateAnimal;
    private javax.swing.JComboBox<String> jComboBoxSex;
    private javax.swing.JComboBox<String> jComboBoxSpecies;
    private javax.swing.JComboBox<String> jComboBoxVisibleForGuests;
    private javax.swing.JLabel jLabelAnimalName;
    private javax.swing.JLabel jLabelCompound;
    private javax.swing.JLabel jLabelDateOfBirth;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelSpecies;
    private javax.swing.JLabel jLabelVisibleForGuests;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneAnimalTable;
    private javax.swing.JTable jTableAnimalData;
    private javax.swing.JTextField jTextFieldAnimalName;
    private javax.swing.JTextField jTextFieldCompound;
    private javax.swing.JTextField jTextFieldDateOfBirth;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
    private Mode mode;
    private ZooManager zooManager;
    private AnimalManager animalManager;
    private Methods methods;
    private LinkedList<Animal> lastSearchedAnimals;
    private LinkedHashMap<String, String> lastSearchMap;
}