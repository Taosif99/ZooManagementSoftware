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

public class ManageCompoundJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current programm session which
     * serves as interface
     */
    public ManageCompoundJFrame(JFrame goBackFrame, ZooManager zooManager) {
        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.compoundManager = zooManager.getCompoundManager();
        methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        myInitComponents();

    }

    private void myInitComponents() {
        updateButtonsAndLabels();
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");
    }

    private void cleanFields() {
        jTextFieldID.setText("");
        jTextFieldCompoundName.setText("");
        jTextFieldConstructionYear.setText("");
        jTextFieldMaxCapacity.setText("");
        jTextFieldArea.setText("");
    }

    private void viewCompounds(LinkedList<Compound> compounds) {

        methods.clearTable(jTableCompoundData);
        DefaultTableModel model = (DefaultTableModel) jTableCompoundData.getModel();
        Object[] row = new Object[6]; // Spalten

        for (Compound compound : compounds) {
            row[0] = compound.getId();
            row[1] = compound.getName();
            double area = compound.getArea();
            row[2] = Math.round(area * 100.0) / 100.0;
            row[3] = compound.getConstructionYear();
            row[4] = compound.getMaxCapacity();
            row[5] = compound.getCurrentCapacity();
            model.addRow(row);
        }

    }

    private boolean checkGreaterZero(int constructionYear, int maxCapacity, double area) {

        return (constructionYear < 0 || maxCapacity < 0 || area < 0);
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
        jTextFieldArea = new javax.swing.JTextField();
        jTextFieldMaxCapacity = new javax.swing.JTextField();
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
        jButtonHelp = new javax.swing.JButton();
        jScrollPaneCompoundTable = new javax.swing.JScrollPane();
        jTableCompoundData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabelAreaUnit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gehege verwalten");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelCompoundName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCompoundName.setText("Name");

        jLabelContructionYear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelContructionYear.setText("Konstruktionsjahr");

        jLabelDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelDateOfBirth.setText("Max. Kapazität");

        jLabelArea.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelArea.setText("Fläche");

        jTextFieldConstructionYear.setToolTipText("Format: yyyy");

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
                .addContainerGap(18, Short.MAX_VALUE))
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

        jScrollPaneCompoundTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableCompoundData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Gehegename", "Fläche in m²", "Baujahr", "MaximaleKapazität", "AktuelleKapazität"
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
        jTableCompoundData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCompoundDataMouseClicked(evt);
            }
        });
        jScrollPaneCompoundTable.setViewportView(jTableCompoundData);
        if (jTableCompoundData.getColumnModel().getColumnCount() > 0) {
            jTableCompoundData.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTableCompoundData.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableCompoundData.getColumnModel().getColumn(4).setPreferredWidth(170);
            jTableCompoundData.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

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

        jLabelAreaUnit.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAreaUnit.setText("m²");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jTextFieldMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldCompoundName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButtonDeleteCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAddCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonUpdateCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelArea))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAreaUnit))
                            .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSearch, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabelShowDateTime)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPaneCompoundTable)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jTextFieldMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelArea)
                            .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAreaUnit))
                        .addGap(59, 59, 59)
                        .addComponent(jButtonAddCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelShowDateTime)
                                    .addComponent(jButtonGoBack))
                                .addGap(59, 59, 59))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneCompoundTable, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonAddCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCompoundActionPerformed

        jTextFieldID.setText("");
        try {

            JTextField textFields[] = {jTextFieldArea, jTextFieldCompoundName,
                jTextFieldConstructionYear, jTextFieldMaxCapacity};

            boolean textFieldsVerified = methods.verifyTextFields(textFields);

            String compoundName = jTextFieldCompoundName.getText();
            int constructionYear = Integer.parseInt(jTextFieldConstructionYear.getText());
            int maxCapacity = Integer.parseInt(jTextFieldMaxCapacity.getText());
            Double area = Double.parseDouble(jTextFieldArea.getText());
            boolean compoundNameExists = compoundManager.compoundExists(compoundName);

            if (textFieldsVerified) {

                if (!compoundNameExists) {

                    if (checkGreaterZero(constructionYear, maxCapacity, area)) {
                        throw new IllegalArgumentException("Negative values not allowed");
                    }

                    if (compoundManager.addCompound(compoundName, area, constructionYear, maxCapacity)) {

                        JOptionPane.showMessageDialog(null, "Gehege konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                        cleanFields();

                    } else {
                        JOptionPane.showMessageDialog(null, "Gehege konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Gehegename schon vorhanden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);

                }
            }

        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in addCompound Button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Zahlenfeld wurde falsch ausgefüllt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);

        } catch (IllegalArgumentException illegalArgumentEcxeption) {

            System.err.println("IllegalArgumentException in addCompound Button");
            System.out.println(illegalArgumentEcxeption.getMessage());
            JOptionPane.showMessageDialog(null, "Werte kleiner 0 nicht erlaubt!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);

        }

    }//GEN-LAST:event_jButtonAddCompoundActionPerformed

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

        String name = jTextFieldCompoundName.getText().trim();
        String constructionYear = jTextFieldConstructionYear.getText().trim();
        String maxCapacity = jTextFieldMaxCapacity.getText().trim();
        String area = methods.removeComma(jTextFieldArea.getText().trim());
        String ID = jTextFieldID.getText().trim();

        LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
        columnNameToValue.put("ID", ID);
        columnNameToValue.put("Name", name);
        columnNameToValue.put("Area", area);
        columnNameToValue.put("ConstructionYear", constructionYear);
        columnNameToValue.put("MaxCapacity", maxCapacity);
        lastSearchMap = columnNameToValue;

        LinkedList<Compound> compounds = compoundManager.searchCompounds(columnNameToValue);
        if (compounds.isEmpty()) {
            methods.clearTable(jTableCompoundData);
            JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
        } else
            viewCompounds(compounds);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonUpdateCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCompoundActionPerformed

        try {

            JTextField textFields[] = {
                jTextFieldArea,
                jTextFieldCompoundName,
                jTextFieldConstructionYear,
                jTextFieldMaxCapacity,
                jTextFieldID};

            boolean textFieldsVerified = methods.verifyTextFields(textFields);

            String compoundName = jTextFieldCompoundName.getText();
            int constructionYear = Integer.parseInt(jTextFieldConstructionYear.getText());
            int maxCapacity = Integer.parseInt(jTextFieldMaxCapacity.getText());
            Double area = Double.parseDouble(jTextFieldArea.getText());
            int ID = Integer.parseInt(jTextFieldID.getText());

            if (textFieldsVerified) {

                if (checkGreaterZero(constructionYear, maxCapacity, area)) {
                    throw new IllegalArgumentException("Negative values not allowed");
                }
                int decision = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie den Datensatz wirklich ändern?", "Bestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (decision == 0) {

                    if (compoundManager.updateCompound(ID, compoundName, area, constructionYear, maxCapacity)) {

                        JOptionPane.showMessageDialog(null, "Gehege wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                        cleanFields();
                        //Update table if old search exist
                        if (lastSearchMap != null) {
                            lastSearchedCompounds = compoundManager.searchCompounds(lastSearchMap);
                            viewCompounds(lastSearchedCompounds);
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Gehege konnte nicht geupdatet werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {
            System.err.println("NumberFormatException in UpdateCompound Button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "Gehege konnte nicht geupdatet werden!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);

        } catch (IllegalArgumentException illegalArgumentEcxeption) {

            System.err.println("IllegalArgumentException in UpdateCompound Button");
            System.out.println(illegalArgumentEcxeption.getMessage());
            JOptionPane.showMessageDialog(null, "Werte kleiner 0 nicht erlaubt!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);

        }
    }//GEN-LAST:event_jButtonUpdateCompoundActionPerformed

    private void jButtonDeleteCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCompoundActionPerformed

        JTextField textFields[] = {jTextFieldID};
        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        try {
            int ID = Integer.parseInt(jTextFieldID.getText());

            if (textFieldsVerified) {

                int decision = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (compoundManager.isEmpty(ID)) {
                    if (decision == 0) {
                        if (compoundManager.deleteCompound(ID)) {

                            JOptionPane.showMessageDialog(null, "Gehege wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                            cleanFields();

                            //Update table if old search exist
                            if (lastSearchMap != null) {
                                lastSearchedCompounds = compoundManager.searchCompounds(lastSearchMap);
                                viewCompounds(lastSearchedCompounds);
                            }
                        } else {

                            JOptionPane.showMessageDialog(null, "Gehege konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Gehege in dem Tiere leben kann nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);

                }
            }
        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in DeleteCompound Button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "ID Feld falsch ausgefüllt!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonDeleteCompoundActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Daten eingeben und auf Hinzufügen klicken!", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;

            case update:
                JOptionPane.showMessageDialog(null, "Bitte die Daten des zu updatenden Geheges ausfüllen oder den Datensatz in der Tabelle anklicken und bearbeiten!", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                break;
            case delete:
                JOptionPane.showMessageDialog(null, "Bitte die ID des zu löschenden Geheges ausfüllen oder den Datensatz in der Tabelle anklicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed


    private void jTableCompoundDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompoundDataMouseClicked

        if (!mode.equals("add")) {
            int rowIndex = jTableCompoundData.getSelectedRow();
            TableModel model = jTableCompoundData.getModel();
            jTextFieldID.setText(model.getValueAt(rowIndex, 0).toString());
            jTextFieldCompoundName.setText(model.getValueAt(rowIndex, 1).toString());
            jTextFieldConstructionYear.setText(model.getValueAt(rowIndex, 3).toString());
            jTextFieldMaxCapacity.setText(model.getValueAt(rowIndex, 4).toString());
            jTextFieldArea.setText(model.getValueAt(rowIndex, 2).toString());

        }
    }//GEN-LAST:event_jTableCompoundDataMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();

    }//GEN-LAST:event_formWindowClosing

    /**
     * Method to disable/enable buttons/labels depending on operation selection.
     */
    private void updateButtonsAndLabels() {

        System.out.println("Compound Mode");

        if (jRadioButtonAdd.isSelected()) {
            System.out.println("    Add mode");
            jButtonAddCompound.setEnabled(true);
            jButtonUpdateCompound.setEnabled(false);
            jButtonDeleteCompound.setEnabled(false);
            jTextFieldID.setEnabled(false);
            jLabelID.setEnabled(false);
            jLabelSearch.setEnabled(false);
            jButtonSearch.setEnabled(false);

            mode = Mode.add;
            methods.clearTable(jTableCompoundData);
        } else if (jRadioButtonUpdate.isSelected()) {
            System.out.println("    Update mode");
            jButtonAddCompound.setEnabled(false);
            jButtonUpdateCompound.setEnabled(true);
            jButtonDeleteCompound.setEnabled(false);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            mode = Mode.update;
        } else if (jRadioButtonDelete.isSelected()) {
            System.out.println("    Delete mode");
            jButtonAddCompound.setEnabled(false);
            jButtonUpdateCompound.setEnabled(false);
            jButtonDeleteCompound.setEnabled(true);
            jTextFieldID.setEnabled(true);
            jLabelID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            mode = Mode.delete;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.JButton jButtonAddCompound;
    private javax.swing.JButton jButtonDeleteCompound;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
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
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneCompoundTable;
    private javax.swing.JTable jTableCompoundData;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldCompoundName;
    private javax.swing.JTextField jTextFieldConstructionYear;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldMaxCapacity;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private CompoundManager compoundManager;
    private Mode mode;
    private Methods methods;
    private LinkedList<Compound> lastSearchedCompounds;
    private LinkedHashMap<String, String> lastSearchMap;

}
