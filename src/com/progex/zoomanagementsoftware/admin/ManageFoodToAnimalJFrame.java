package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.AnimalManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.FoodManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.FoodToAnimalManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.ArrayList;
import java.util.HashMap;
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

public class ManageFoodToAnimalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageFoodToAnimalJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public ManageFoodToAnimalJFrame(JFrame goBackFrame, ZooManager zooManager) {

        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.animalManager = zooManager.getAnimalManager();
        this.foodToAnimalManager = zooManager.getFoodToAnimalManager();
        methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        myInitComponents();

        AutoCompleteDecorator.decorate(jComboBoxFoodNames);
        ArrayList<String> foodNames = zooManager.getFoodManager().loadFoodNames();
        jComboBoxFoodNames.setModel(new DefaultComboBoxModel<String>(foodNames.toArray(new String[0])));
    }

    private void myInitComponents() {

        updateButtonsAndLabels();
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Ja");
    }

    private void viewAnimals(LinkedList<Animal> animals) {

        /*Clean the table*/
        DefaultTableModel tableModel = (DefaultTableModel) jTableAnimalData.getModel();
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        /*Loading all animals to Table, better in own method*/
        DefaultTableModel model = (DefaultTableModel) jTableAnimalData.getModel();
        Object[] row = new Object[6];

        for (Animal animal : animals) {
            row[0] = animal.getId();
            row[1] = animal.getName();
            row[2] = animal.getBirthday();
            row[3] = animal.getSex();
            //DIE LINE IST NOCH HÄSSLICH
            row[4] = methods.descriptionToString(animal.getSpecies().getDescription());
            row[5] = animal.getCompound().getName();
            model.addRow(row);
        }
    }

    private void viewRelationTable(LinkedList<FoodToAnimalR> records) {

        DefaultTableModel tableRelationModel = (DefaultTableModel) jTableFoodToAnimalData.getModel();

        while (tableRelationModel.getRowCount() > 0) {
            tableRelationModel.removeRow(0);
        }

        Object[] row = new Object[6]; // Spalten
        for (FoodToAnimalR record : records) {
            row[0] = record.getFoodName();
            row[1] = record.getFoodID();
            row[2] = record.getAnimalID();
            row[3] = methods.removeSeconds(record.getStartFeedingTime());
            row[4] = methods.removeSeconds(record.getEndFeedingTime());

            double amount;
            if (jRadioButtonGTable.isSelected()) {
                amount = record.getAmount() * 1000;
            } else {
                amount = record.getAmount();
            }

            //Rounding
            row[5] = Math.round(amount * 100.0) / 100.0;

            tableRelationModel.addRow(row);
        }
    }

    private void cleanFields() {

        jTextFieldStartFeedingTime.setText("");
        jTextFieldEndFeedingTime.setText("");
        jTextFieldAmountFood.setText("");
        jTextFieldAnimalID.setText("");
        jTextFieldFoodID.setText("");
        jTextFieldDateTimeID.setText("");
    }

    private boolean addFoodRelation() {

        if (selectedAnimalID != null) {
            try {
                JTextField textFields[] = {jTextFieldStartFeedingTime,
                    jTextFieldEndFeedingTime, jTextFieldAmountFood};
                boolean textFieldsVerified = methods.verifyTextFields(textFields);
                if (textFieldsVerified) {
                    String foodName = jComboBoxFoodNames.getSelectedItem().toString();
                    String startFeedingTime = jTextFieldStartFeedingTime.getText() + ":00";
                    String endFeedingTime = jTextFieldEndFeedingTime.getText() + ":00";
                    double amount = Double.parseDouble(jTextFieldAmountFood.getText());
                    boolean feedingOrderTimesOk = methods.isFeedingTimesGreater(startFeedingTime, endFeedingTime);
                    FoodManager foodManager = zooManager.getFoodManager();
                    boolean foodExists = foodManager.checkFoodExists(foodName, -1);
                    if (amount < 0) {
                        throw new IllegalArgumentException("Amount must be greater or equal zero");
                    }
                    if (jRadioButtonG.isSelected()) {
                        amount /= 1000;
                    }
                    if (foodExists) {
                        if (methods.isValidFeedingTime(startFeedingTime) && methods.isValidFeedingTime(endFeedingTime)) {
                            if (!feedingOrderTimesOk) {
                                throw new IllegalArgumentException("End feeding time cannot start before start feeding time");
                            }

                            if (!foodToAnimalManager.isEnoughStock(foodName, amount)) {

                                throw new IllegalArgumentException("not enough stock");
                            }

                            if (foodToAnimalManager.addFoodToAnimal(selectedAnimalID, foodName, startFeedingTime, endFeedingTime, amount)) {
                                JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                                int animalID = Integer.parseInt(selectedAnimalID);
                                LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(animalID);
                                lastClickRecords = records;
                                viewRelationTable(records);
                                cleanFields();
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Falsches Format für Fütterungszeiten!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Futter existiert nicht!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println("NumberFormatException in AddFoodToAnimal Button");
                System.out.println(numberFormatException.getMessage());
                JOptionPane.showMessageDialog(null, "Im Menge Textfeld darf nur eine Zahl stehen!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
            } catch (IllegalArgumentException illegalArgumentException) {
                String message = illegalArgumentException.getMessage();
                if (message.equals("End feeding time cannot start before start feeding time")) {
                    System.err.println("Illegal feeding times arguments");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Beginn der Fütterung kann nicht später als das Ende sein!", "Fütterungszeiten unlogisch", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("Amount must be greater zero")) {
                    System.err.println("Illegal amount argument");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Futtermenge kann nicht kleiner oder gleich 0 sein!", "Futtermenge unlogisch", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("not enough stock")) {
                    System.err.println("Illegal amount argument, not enough stock");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Futtermenge übertrifft den Bestand !", "Futtermenge unlogisch", JOptionPane.CANCEL_OPTION);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sie müssen ein Tier in der Tabelle anklicken!", "Kein Tier ausgewählt", JOptionPane.CANCEL_OPTION);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOperation = new javax.swing.ButtonGroup();
        buttonGroupAmountUnit = new javax.swing.ButtonGroup();
        buttonGroupUnitTable = new javax.swing.ButtonGroup();
        jLabelAnimalName = new javax.swing.JLabel();
        jLabelStartFeedingTime = new javax.swing.JLabel();
        jLabelEndFeedingTime = new javax.swing.JLabel();
        jTextFieldAnimalName = new javax.swing.JTextField();
        jTextFieldStartFeedingTime = new javax.swing.JTextField();
        jTextFieldEndFeedingTime = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelFoodID = new javax.swing.JLabel();
        jTextFieldFoodID = new javax.swing.JTextField();
        jButtonGoBack = new javax.swing.JButton();
        jPanelOperation = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jButtonHelp = new javax.swing.JButton();
        jCheckBoxIncreaseStock = new javax.swing.JCheckBox();
        jScrollPaneFoodToAnimalTable = new javax.swing.JScrollPane();
        jTableFoodToAnimalData = new javax.swing.JTable();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabelFood = new javax.swing.JLabel();
        jLabelAmountFood = new javax.swing.JLabel();
        jTextFieldAmountFood = new javax.swing.JTextField();
        jButtonSearchAnimal = new javax.swing.JButton();
        jScrollPaneAnimalTable = new javax.swing.JScrollPane();
        jTableAnimalData = new javax.swing.JTable();
        jLabelAnimalID = new javax.swing.JLabel();
        jTextFieldAnimalID = new javax.swing.JTextField();
        jTextFieldDateTimeID = new javax.swing.JTextField();
        jLabelDateTimeID = new javax.swing.JLabel();
        jPanelAmountUnit = new javax.swing.JPanel();
        jRadioButtonKg = new javax.swing.JRadioButton();
        jRadioButtonG = new javax.swing.JRadioButton();
        jPanelAmountUnitTable = new javax.swing.JPanel();
        jRadioButtonKgTable = new javax.swing.JRadioButton();
        jRadioButtonGTable = new javax.swing.JRadioButton();
        jLabelAmountUnitTable = new javax.swing.JLabel();
        jLabelClickedAnimal = new javax.swing.JLabel();
        jComboBoxFoodNames = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Futter-Tier-Beziehung verwalten");
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelAnimalName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAnimalName.setText("Tiername");

        jLabelStartFeedingTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelStartFeedingTime.setText("Start Fütterungszeit");

        jLabelEndFeedingTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelEndFeedingTime.setText("Ende Fütterungszeit");

        jTextFieldStartFeedingTime.setToolTipText("Format: yyyy-MM-dd HH:mm");

        jTextFieldEndFeedingTime.setToolTipText("Format: yyyy-MM-dd HH:mm");

        jButtonAdd.setText("Hinzufügen");
        jButtonAdd.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Updaten");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Löschen");
        jButtonDelete.setMaximumSize(new java.awt.Dimension(87, 23));
        jButtonDelete.setMinimumSize(new java.awt.Dimension(87, 23));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelFoodID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelFoodID.setText("FutterID");

        jTextFieldFoodID.setEnabled(false);

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

        jCheckBoxIncreaseStock.setText("Bestand wieder freigeben");
        jCheckBoxIncreaseStock.setToolTipText("Falls man möchte, dass die Fütterung zurück genommen wird und der Bestand somit wieder erhört wird.");

        javax.swing.GroupLayout jPanelOperationLayout = new javax.swing.GroupLayout(jPanelOperation);
        jPanelOperation.setLayout(jPanelOperationLayout);
        jPanelOperationLayout.setHorizontalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelOperationLayout.createSequentialGroup()
                        .addComponent(jLabelOperation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHelp))
                    .addGroup(jPanelOperationLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxIncreaseStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jRadioButtonUpdate)
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(38, Short.MAX_VALUE))
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
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDelete)
                    .addComponent(jCheckBoxIncreaseStock))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jScrollPaneFoodToAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableFoodToAnimalData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FutterName", "FutterID", "TierID", "Start Fütterungszeit", "Ende Fütterungszeit", "Menge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFoodToAnimalData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableFoodToAnimalData.getTableHeader().setReorderingAllowed(false);
        jTableFoodToAnimalData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFoodToAnimalDataMouseClicked(evt);
            }
        });
        jScrollPaneFoodToAnimalTable.setViewportView(jTableFoodToAnimalData);
        if (jTableFoodToAnimalData.getColumnModel().getColumnCount() > 0) {
            jTableFoodToAnimalData.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTableFoodToAnimalData.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableFoodToAnimalData.getColumnModel().getColumn(3).setPreferredWidth(300);
            jTableFoodToAnimalData.getColumnModel().getColumn(4).setPreferredWidth(300);
            jTableFoodToAnimalData.getColumnModel().getColumn(5).setPreferredWidth(120);
        }

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jButtonSearch.setText("Suche");
        jButtonSearch.setToolTipText("Suche anhand angegebener regulärer Ausdrücke, falls zum Beispiel Feld A und Feld B ausgefüllt sind, wird das Resultat den Ausdruck von A und B erfüllen. Ein Tier muss angeklickt sein !");
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

        jLabelFood.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelFood.setText("Futter");

        jLabelAmountFood.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAmountFood.setText("Menge");

        jTextFieldAmountFood.setToolTipText("Format: zum Beispiel 9.87");

        jButtonSearchAnimal.setText("Suche Tiere");
        jButtonSearchAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchAnimalActionPerformed(evt);
            }
        });

        jScrollPaneAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableAnimalData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TierID", "Name", "Alter", "Geschlecht"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAnimalData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAnimalDataMouseClicked(evt);
            }
        });
        jScrollPaneAnimalTable.setViewportView(jTableAnimalData);

        jLabelAnimalID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAnimalID.setText("TierID");

        jTextFieldAnimalID.setEnabled(false);

        jTextFieldDateTimeID.setEnabled(false);

        jLabelDateTimeID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelDateTimeID.setText("Start Fütterungzeit");

        buttonGroupAmountUnit.add(jRadioButtonKg);
        jRadioButtonKg.setSelected(true);
        jRadioButtonKg.setText("kg");

        buttonGroupAmountUnit.add(jRadioButtonG);
        jRadioButtonG.setText("g");

        javax.swing.GroupLayout jPanelAmountUnitLayout = new javax.swing.GroupLayout(jPanelAmountUnit);
        jPanelAmountUnit.setLayout(jPanelAmountUnitLayout);
        jPanelAmountUnitLayout.setHorizontalGroup(
            jPanelAmountUnitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmountUnitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonKg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonG))
        );
        jPanelAmountUnitLayout.setVerticalGroup(
            jPanelAmountUnitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmountUnitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAmountUnitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonKg)
                    .addComponent(jRadioButtonG)))
        );

        buttonGroupUnitTable.add(jRadioButtonKgTable);
        jRadioButtonKgTable.setSelected(true);
        jRadioButtonKgTable.setText("kg");
        jRadioButtonKgTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKgTableActionPerformed(evt);
            }
        });

        buttonGroupUnitTable.add(jRadioButtonGTable);
        jRadioButtonGTable.setText("g");
        jRadioButtonGTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGTableActionPerformed(evt);
            }
        });

        jLabelAmountUnitTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAmountUnitTable.setText("Mengeneinheit:");

        javax.swing.GroupLayout jPanelAmountUnitTableLayout = new javax.swing.GroupLayout(jPanelAmountUnitTable);
        jPanelAmountUnitTable.setLayout(jPanelAmountUnitTableLayout);
        jPanelAmountUnitTableLayout.setHorizontalGroup(
            jPanelAmountUnitTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmountUnitTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAmountUnitTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonKgTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonGTable)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanelAmountUnitTableLayout.setVerticalGroup(
            jPanelAmountUnitTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAmountUnitTableLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelAmountUnitTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonKgTable)
                    .addComponent(jRadioButtonGTable)
                    .addComponent(jLabelAmountUnitTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabelClickedAnimal.setText("Kein Tier ausgewählt!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanelOperation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelAnimalName)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(176, 176, 176)
                                                    .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonSearchAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelClickedAnimal, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelEndFeedingTime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldEndFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelAmountFood)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldAmountFood, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelStartFeedingTime)
                                            .addComponent(jLabelFood))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldStartFeedingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(jComboBoxFoodNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelAmountUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(575, 575, 575)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelShowDateTime)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFoodID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelAnimalID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDateTimeID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDateTimeID))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jPanelAmountUnitTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabelSearch))
                                    .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPaneFoodToAnimalTable)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGoBack)
                .addGap(3, 3, 3)
                .addComponent(jLabelClickedAnimal)
                .addGap(18, 18, 18)
                .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnimalName)
                    .addComponent(jTextFieldAnimalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchAnimal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelAmountUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFood)
                            .addComponent(jComboBoxFoodNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldStartFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStartFeedingTime))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEndFeedingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEndFeedingTime))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAmountFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAmountFood))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelShowDateTime)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFoodID)
                    .addComponent(jTextFieldFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnimalID)
                    .addComponent(jTextFieldAnimalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDateTimeID)
                    .addComponent(jTextFieldDateTimeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPaneFoodToAnimalTable, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSearch)
                    .addComponent(jPanelAmountUnitTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getAccessibleContext().setAccessibleName("FutterTier verwalten");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        addFoodRelation();
    }//GEN-LAST:event_jButtonAddActionPerformed

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

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        if (selectedAnimalID != null) {

            String food = jComboBoxFoodNames.getSelectedItem().toString();
            String startFeedingTime = jTextFieldStartFeedingTime.getText().trim();
            String endFeedingTime = jTextFieldEndFeedingTime.getText().trim();
            String amountStr = "";
            double amount = -1;
            try {

                if (!jTextFieldAmountFood.getText().isBlank()) {
                    amount = Double.parseDouble(jTextFieldAmountFood.getText().trim());
                }

                if (amount >= 0) {

                    if (jRadioButtonG.isSelected()) {
                        amount /= 1000;
                    }

                    amountStr = methods.removeComma(String.valueOf(amount));
                }

                LinkedHashMap<String, String> columnValueMap = new LinkedHashMap<String, String>();

                columnValueMap.put("Food.Name", food);
                columnValueMap.put("AnimalID", selectedAnimalID);
                columnValueMap.put("StartFeedingTime", startFeedingTime);
                columnValueMap.put("EndFeedingTime", endFeedingTime);
                columnValueMap.put("Amount", amountStr);

                LinkedList<FoodToAnimalR> records = foodToAnimalManager.searchFoodToAnimal(columnValueMap);
                if (records.isEmpty()) {
                    methods.clearTable(jTableFoodToAnimalData);
                    JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    lastClickRecords = records;
                    viewRelationTable(records);
                }

            } catch (NumberFormatException numberFormatException) {

                System.err.println("NumberFormatException in SearchFoodToAnimal button");
                JOptionPane.showMessageDialog(null, "Bitte eine gültige Menge angeben!", "Suchen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                System.out.println(numberFormatException.getMessage());
                methods.clearTable(jTableFoodToAnimalData);
                if (selectedAnimalID != null) {
                    LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(Integer.valueOf(selectedAnimalID));
                    lastClickRecords = records;
                    viewRelationTable(records);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bitte ein Tier anklicken für die Suche!", "Suchen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed

        if (selectedAnimalID != null) {
            HashMap<String, String> keys = new HashMap<String, String>();
            try {

                int rowIndex = jTableFoodToAnimalData.getSelectedRow();
                TableModel model = jTableFoodToAnimalData.getModel();
                String foodIDKey = model.getValueAt(rowIndex, 1).toString();
                String startFeedingTimeKey = model.getValueAt(rowIndex, 3).toString();
                keys.put("StartFeedingTime", startFeedingTimeKey);
                keys.put("FoodID", foodIDKey);
                String oldFoodName = model.getValueAt(rowIndex, 0).toString();
                double oldAmount = Double.valueOf(model.getValueAt(rowIndex, 5).toString());

                JTextField textFields[] = {jTextFieldStartFeedingTime,
                    jTextFieldEndFeedingTime, jTextFieldAmountFood,};

                boolean textFieldsVerified = methods.verifyTextFields(textFields);
                if (textFieldsVerified) {
                    String foodName = jComboBoxFoodNames.getSelectedItem().toString();
                    String startFeedingTime = jTextFieldStartFeedingTime.getText() + ":00";
                    String endFeedingTime = jTextFieldEndFeedingTime.getText() + ":00";
                    double amount = Double.parseDouble(jTextFieldAmountFood.getText());
                    FoodManager foodManager = zooManager.getFoodManager();
                    boolean foodExists = foodManager.checkFoodExists(foodName, -1);
                    boolean feedingOrderTimesOk = methods.isFeedingTimesGreater(startFeedingTime, endFeedingTime);
                    if (amount < 0) {
                        throw new IllegalArgumentException("Amount must be greater or equal zero");
                    }

                    //Check if gram is selected
                    if (jRadioButtonG.isSelected()) {
                        amount /= 1000;
                    }
                    if (foodExists) {
                        if (methods.isValidFeedingTime(startFeedingTime) && methods.isValidFeedingTime(endFeedingTime)) {

                            if (!feedingOrderTimesOk) {
                                throw new IllegalArgumentException("End feeding time cannot start before start feeding time");
                            }
                            //Check unit of right table
                            if (jRadioButtonGTable.isSelected()) {
                                oldAmount /= 1000;
                            }

                            int decision = JOptionPane.showConfirmDialog(null,
                                    "Wollen Sie den Datensatz wirklich ändern?", "Bestätigung",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (decision == 0) {

                                ///////////////////////////////////////////
                                //Handling case if the foodName is updated
                                //Here we have to delete the existing relation with increasing stock
                                //While adding a new relation and decreasing the stock
                                if (!foodName.equals(oldFoodName)) {

                                    //Trying to add new Relation
                                    boolean addedFoodRelation = addFoodRelation();
                                    boolean deletedOldFoodRelation = false;
                                    if (addedFoodRelation) {
                                        //Delete old relation with increasing stock                  
                                        deletedOldFoodRelation = foodToAnimalManager.deleteFoodToAnimal(foodIDKey, selectedAnimalID, startFeedingTimeKey, oldAmount);
                                    }

                                    if (addedFoodRelation && deletedOldFoodRelation) {

                                        int animalID = Integer.parseInt(selectedAnimalID);
                                        LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(animalID);
                                        lastClickRecords = records;
                                        viewRelationTable(records);
                                        JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);

                                        for (JTextField textField : textFields) {
                                            textField.setText("");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Etwas beim entfernen der alten Beziehung oder einfügen der neuen Beziehung ist schief gegangen!", "Update fehlerhaft", JOptionPane.CANCEL_OPTION);
                                    }
                                    return;
                                }

                                double differenceForStock = oldAmount - amount;

                                //Case difference positive -> stock increases                    
                                //-->No need to check if enough stock
                                //Case difference negative -> stock decreases
                                if (differenceForStock < 0) {

                                    //Check if there is enough for update
                                    double increaseAmount = differenceForStock * (-1);
                                    if (!foodToAnimalManager.isEnoughStock(foodName, increaseAmount)) {
                                        throw new IllegalArgumentException("not enough stock");
                                    }
                                }

                                if (foodToAnimalManager.updateFoodToAnimal(selectedAnimalID, foodName, startFeedingTime, endFeedingTime, amount, keys, differenceForStock)) {
                                    int animalID = Integer.parseInt(selectedAnimalID);
                                    LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(animalID);
                                    lastClickRecords = records;
                                    viewRelationTable(records);
                                    JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung wurde erfolgreich in der Datenbank aktualisiert!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);

                                    for (JTextField textField : textFields) {
                                        textField.setText("");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung konnte nicht geupdatet werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Falsches Format für Fütterungszeiten!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Futter existiert nicht!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            } catch (NumberFormatException numberFormatException) {

                System.err.println("NumberFormatException in UpdateFoodToAnimal button");
                System.out.println(numberFormatException.getMessage());
                JOptionPane.showMessageDialog(null, "Im Menge Textfeld darf nur eine Zahl stehen!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
                
            } catch (IllegalArgumentException illegalArgumentException) {
                String message = illegalArgumentException.getMessage();
                if (message.equals("End feeding time cannot start before start feeding time")) {
                    System.err.println("Illegal feeding times arguments");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Beginn der Fütterung kann nicht später als das Ende sein!", "Fütterungszeiten unlogisch", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("Amount must be greater zero")) {
                    System.err.println("Illegal amount argument");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Futtermnege kann nicht kleiner oder gleich 0 sein!", "Futtermenge unlogisch", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("not enough stock")) {
                    System.err.println("Illegal amount argument, not enough stock");
                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Neue Futtermenge übertrifft den Bestand!", "Futtermenge unlogisch", JOptionPane.CANCEL_OPTION);
                }
            } catch (ArrayIndexOutOfBoundsException arrOutOfBounds) {
                System.err.println("No food relation selected");
                System.out.println(arrOutOfBounds.getMessage());
                JOptionPane.showMessageDialog(null, "Bitte Datensatz in der rechten Tabelle auswählen!", "Kein Datensatz ausgewählt", JOptionPane.CANCEL_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sie müssen ein Tier in der Tabelle anklicken!", "Kein Tier ausgewählt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed

        try {

            int rowIndex = jTableFoodToAnimalData.getSelectedRow();
            TableModel model = jTableFoodToAnimalData.getModel();
            String foodIDKey = model.getValueAt(rowIndex, 1).toString();
            String startFeedingTimeKey = model.getValueAt(rowIndex, 3).toString();

            double updateStockVal = 0;

            if (jCheckBoxIncreaseStock.isSelected()) {

                //get the old value from table
                updateStockVal = Double.valueOf(model.getValueAt(rowIndex, 5).toString());

                //Check unit of right table
                if (jRadioButtonGTable.isSelected()) {
                    updateStockVal /= 1000;
                }
            }

            int decision = JOptionPane.showConfirmDialog(null,
                    "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (decision == 0) {

                if (foodToAnimalManager.deleteFoodToAnimal(foodIDKey, selectedAnimalID, startFeedingTimeKey, updateStockVal)) {
                    JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                    int animalID = Integer.parseInt(selectedAnimalID);
                    LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(animalID);
                    lastClickRecords = records;
                    viewRelationTable(records);
                    jTextFieldStartFeedingTime.setText("");
                    jTextFieldEndFeedingTime.setText("");
                    jTextFieldAmountFood.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Futter-Tier-Beziehung konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrOutOfBounds) {
            
            System.err.println("No food relation selected");
            System.out.println(arrOutOfBounds.getMessage());
            JOptionPane.showMessageDialog(null, "Bitte Datensatz in der rechten Tabelle auswählen!", "Kein Datensatz ausgewählt", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Tier anklicken, Daten eingeben und auf Hinzufügen klicken", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;

            case update:
                JOptionPane.showMessageDialog(null, "Den Datensatz in der Tabelle anklicken, bearbeiten und auf Updaten klicken ", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case delete:
                JOptionPane.showMessageDialog(null, "Den Datensatz in der rechten Tabelle anklicken und Löschen klicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jTableAnimalDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAnimalDataMouseClicked

        int animalRowIndex = jTableAnimalData.getSelectedRow();
        TableModel animalModel = jTableAnimalData.getModel();
        //Update the animalId when selected
        selectedAnimalID = animalModel.getValueAt(animalRowIndex, 0).toString();

        //Display selectedAnimalD
        jLabelClickedAnimal.setText("Ausgewählte TierID: " + selectedAnimalID);
        jTextFieldAnimalName.setText(animalModel.getValueAt(animalRowIndex, 1).toString());

        int animalID = Integer.parseInt(selectedAnimalID);
        LinkedList<FoodToAnimalR> records = foodToAnimalManager.getFoodToAnimalRecords(animalID);
        lastClickRecords = records;
        viewRelationTable(records);

        jTextFieldDateTimeID.setText("");
        jTextFieldFoodID.setText("");
        jTextFieldAnimalID.setText("");
    }//GEN-LAST:event_jTableAnimalDataMouseClicked

    private void jTableFoodToAnimalDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFoodToAnimalDataMouseClicked

        /*Updating the textfields correspondingly*/
        int rowIndex = jTableFoodToAnimalData.getSelectedRow();
        TableModel model = jTableFoodToAnimalData.getModel();

        String foodName = model.getValueAt(rowIndex, 0).toString();
        jComboBoxFoodNames.setSelectedItem(foodName);
        jTextFieldFoodID.setText(model.getValueAt(rowIndex, 1).toString());
        jTextFieldAnimalID.setText(model.getValueAt(rowIndex, 2).toString());
        String startFeedingTime = model.getValueAt(rowIndex, 3).toString();
        String endFeedingTime = model.getValueAt(rowIndex, 4).toString();
        jTextFieldStartFeedingTime.setText(startFeedingTime);
        jTextFieldDateTimeID.setText(startFeedingTime);
        jTextFieldEndFeedingTime.setText(endFeedingTime);

        //4 Cases
        //1 and 2, if animalTable is g and relation Table is g
        //or if both tables are kg
        if ((jRadioButtonG.isSelected() && jRadioButtonGTable.isSelected())
                || jRadioButtonKg.isSelected() && jRadioButtonKgTable.isSelected()) {
            jTextFieldAmountFood.setText(model.getValueAt(rowIndex, 5).toString());
        } //3 case if textField is Kg and Table is g
        else if (jRadioButtonG.isSelected() && jRadioButtonKgTable.isSelected()) {

            double value = (double) model.getValueAt(rowIndex, 5);
            value *= 1000;
            jTextFieldAmountFood.setText(String.valueOf(value));
        } //4 case if textField is g and Table is Kg
        else if (jRadioButtonKg.isSelected() && jRadioButtonGTable.isSelected()) {
            double value = (double) model.getValueAt(rowIndex, 5);
            value /= 1000;
            jTextFieldAmountFood.setText(String.valueOf(value));
        }
    }//GEN-LAST:event_jTableFoodToAnimalDataMouseClicked

    private void jButtonSearchAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchAnimalActionPerformed
        
        cleanFields();
        selectedAnimalID = null;
        jLabelClickedAnimal.setText("Kein Tier ausgewählt!");
        jTextFieldAnimalName.setText(jTextFieldAnimalName.getText().trim());
        methods.clearTable(jTableFoodToAnimalData);
        LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
        String animalName = jTextFieldAnimalName.getText();

        columnNameToValue.put("AnimalName", animalName);
        LinkedList<Animal> animals = animalManager.searchAnimals(columnNameToValue);
        viewAnimals(animals);
    }//GEN-LAST:event_jButtonSearchAnimalActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();
    }//GEN-LAST:event_formWindowClosing

    private void jRadioButtonKgTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKgTableActionPerformed
       
        if (lastClickRecords != null && (!lastClickRecords.isEmpty())) {
            viewRelationTable(lastClickRecords);
        }
    }//GEN-LAST:event_jRadioButtonKgTableActionPerformed

    private void jRadioButtonGTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGTableActionPerformed
        
        if (lastClickRecords != null && (!lastClickRecords.isEmpty())) {
            viewRelationTable(lastClickRecords);
        }
    }//GEN-LAST:event_jRadioButtonGTableActionPerformed

    private void updateButtonsAndLabels() {

        System.out.println("FoodToAnimal Mode");

        if (jRadioButtonAdd.isSelected()) {
            System.out.println("    Add mode");
            jButtonAdd.setEnabled(true);
            jButtonUpdate.setEnabled(false);
            jButtonDelete.setEnabled(false);
            jLabelSearch.setEnabled(false);
            jButtonSearch.setEnabled(false);

            jTextFieldFoodID.setText("");
            jTextFieldAnimalID.setText("");
            jTextFieldDateTimeID.setText("");
            jCheckBoxIncreaseStock.setEnabled(false);
            mode = Mode.add;

        } else if (jRadioButtonUpdate.isSelected()) {
            System.out.println("    Update mode");
            jButtonAdd.setEnabled(false);
            jButtonUpdate.setEnabled(true);
            jButtonDelete.setEnabled(false);
            jLabelFoodID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jLabelAnimalID.setEnabled(true);
            jLabelDateTimeID.setEnabled(true);
            jCheckBoxIncreaseStock.setEnabled(false);
            mode = Mode.update;

        } else if (jRadioButtonDelete.isSelected()) {
            System.out.println("    Delete mode");
            jButtonAdd.setEnabled(false);
            jButtonUpdate.setEnabled(false);
            jButtonDelete.setEnabled(true);
            jLabelFoodID.setEnabled(true);
            jLabelSearch.setEnabled(true);
            jButtonSearch.setEnabled(true);
            jLabelAnimalID.setEnabled(true);
            jLabelDateTimeID.setEnabled(true);
            jCheckBoxIncreaseStock.setEnabled(true);
            mode = Mode.delete;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAmountUnit;
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.ButtonGroup buttonGroupUnitTable;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearchAnimal;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JCheckBox jCheckBoxIncreaseStock;
    private javax.swing.JComboBox<String> jComboBoxFoodNames;
    private javax.swing.JLabel jLabelAmountFood;
    private javax.swing.JLabel jLabelAmountUnitTable;
    private javax.swing.JLabel jLabelAnimalID;
    private javax.swing.JLabel jLabelAnimalName;
    private javax.swing.JLabel jLabelClickedAnimal;
    private javax.swing.JLabel jLabelDateTimeID;
    private javax.swing.JLabel jLabelEndFeedingTime;
    private javax.swing.JLabel jLabelFood;
    private javax.swing.JLabel jLabelFoodID;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelStartFeedingTime;
    private javax.swing.JPanel jPanelAmountUnit;
    private javax.swing.JPanel jPanelAmountUnitTable;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonG;
    private javax.swing.JRadioButton jRadioButtonGTable;
    private javax.swing.JRadioButton jRadioButtonKg;
    private javax.swing.JRadioButton jRadioButtonKgTable;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JScrollPane jScrollPaneAnimalTable;
    private javax.swing.JScrollPane jScrollPaneFoodToAnimalTable;
    private javax.swing.JTable jTableAnimalData;
    private javax.swing.JTable jTableFoodToAnimalData;
    private javax.swing.JTextField jTextFieldAmountFood;
    private javax.swing.JTextField jTextFieldAnimalID;
    private javax.swing.JTextField jTextFieldAnimalName;
    private javax.swing.JTextField jTextFieldDateTimeID;
    private javax.swing.JTextField jTextFieldEndFeedingTime;
    private javax.swing.JTextField jTextFieldFoodID;
    private javax.swing.JTextField jTextFieldStartFeedingTime;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame goBackFrame;
    private Mode mode;
    private ZooManager zooManager;
    private AnimalManager animalManager;
    private FoodToAnimalManager foodToAnimalManager;
    private Methods methods;
    private String selectedAnimalID;
    private LinkedList<FoodToAnimalR> lastClickRecords;
}