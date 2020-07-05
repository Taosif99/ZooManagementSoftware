package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.Address;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import com.progex.zoomanagementsoftware.datatypes.Salutation;
import com.progex.zoomanagementsoftware.datatypes.Shift;
import com.progex.zoomanagementsoftware.datatypes.User;
import com.progex.zoomanagementsoftware.datatypes.Zookeeper;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ManageUserJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public ManageUserJFrame(JFrame goBackFrame, ZooManager zooManager) {
        
        initComponents();
        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        userManager = zooManager.getUserManager();
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
        AutoCompleteDecorator.decorate(jComboBoxCountryCode);

        ArrayList<String> countryCodes = userManager.loadCountryCodes();
        jComboBoxCountryCode.setModel(new DefaultComboBoxModel<>(countryCodes.toArray(new String[0])));
        jComboBoxCountryCode.setSelectedItem("DE");
    }

    private void viewUsers(LinkedList<User> users) {

        methods.clearTable(jTableUserData);
        DefaultTableModel model = (DefaultTableModel) jTableUserData.getModel();
        Object[] row = new Object[13]; //Spalten

        for (User user : users) {

            row[0] = user.getId();
            if (user instanceof Zookeeper) {
                Shift shift = ((Zookeeper) user).getShift();
                row[1] = methods.shiftToString(shift);
            } else {
                row[1] = "Keine";
            }
            row[2] = methods.salutationToString(user.getSalutation());
            row[3] = user.getUsername();
            row[4] = user.getFirstname();
            row[5] = user.getLastname();
            row[6] = user.getPhoneNumber();
            row[7] = user.getBirthday();
            row[8] = user.getEmail();

            Address address = user.getAddress();
            row[9] = address.getZip();
            row[10] = address.getStreet();
            row[11] = address.getCity();
            int countryId = address.getCountryID();
            row[12] = userManager.getCountryCode(countryId);

            model.addRow(row);
        }
    }

    private void cleanFields() {

        jTextFieldFirstname.setText("");
        jTextFieldLastname.setText("");
        jTextFieldStreet.setText("");
        jTextFieldZIP.setText("");
        jTextFieldCity.setText("");
        jTextFieldPhoneNumber.setText("");
        jTextFieldBirthday.setText("");
        jTextFieldUsername.setText("");
        jTextFieldEMail.setText("");
        jTextFieldID.setText("");
        jPasswordFieldConfirm.setText("");
        jPasswordFieldEnteredPW.setText("");
    }

    //Diese MEthode existiert bereits in methods
    private String getGermanShiftString() {

        if (userType.equals(Mode.zookeeper)) {
            String shiftStr = jComboBoxShift.getSelectedItem().toString();

            switch (shiftStr) {

                case "Früh":
                    return "Morning";

                case "Nachmittag":
                    return "Afternoon";

                case "Spät":
                    return "Night";
            }
        }
        return "None";
    }

    private boolean containsOnlyNumbers(String phoneNumber) {
        return phoneNumber.matches("[0-9]+");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupUserType = new javax.swing.ButtonGroup();
        buttonGroupOperation = new javax.swing.ButtonGroup();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonGoBack = new javax.swing.JButton();
        jScrollPaneUserData = new javax.swing.JScrollPane();
        jTableUserData = new javax.swing.JTable();
        jRadioButtonZookeeper = new javax.swing.JRadioButton();
        jLabelUserType = new javax.swing.JLabel();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jPanelOperation = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jButtonHelp = new javax.swing.JButton();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jLabelSalutation = new javax.swing.JLabel();
        jComboBoxSalutation = new javax.swing.JComboBox<>();
        jLabelFirstname = new javax.swing.JLabel();
        jTextFieldFirstname = new javax.swing.JTextField();
        jLabelLastname = new javax.swing.JLabel();
        jTextFieldLastname = new javax.swing.JTextField();
        jLabelStreet = new javax.swing.JLabel();
        jTextFieldStreet = new javax.swing.JTextField();
        jLabelZIP = new javax.swing.JLabel();
        jTextFieldZIP = new javax.swing.JTextField();
        jLabelCity = new javax.swing.JLabel();
        jTextFieldCity = new javax.swing.JTextField();
        jLabelCountryCode = new javax.swing.JLabel();
        jLabelPhoneNumber = new javax.swing.JLabel();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jLabelBirthday = new javax.swing.JLabel();
        jLabelShift = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelEMail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        jTextFieldEMail = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jComboBoxShift = new javax.swing.JComboBox<>();
        jTextFieldBirthday = new javax.swing.JTextField();
        jButtonAddUser = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonAnimalsToZookeeper = new javax.swing.JButton();
        jPasswordFieldEnteredPW = new javax.swing.JPasswordField();
        jPasswordFieldConfirm = new javax.swing.JPasswordField();
        jButtonClear = new javax.swing.JButton();
        jComboBoxCountryCode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Benutzer verwalten");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        jScrollPaneUserData.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneUserData.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableUserData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Schicht", "Anrede", "Benutzername", "Vorname", "Nachname", "Telefonnummer", "Geburtstag", "E-Mail", "Plz", "Straße", "Stadt", "Land Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUserData.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableUserData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableUserData.getTableHeader().setReorderingAllowed(false);
        jTableUserData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserDataMouseClicked(evt);
            }
        });
        jScrollPaneUserData.setViewportView(jTableUserData);
        if (jTableUserData.getColumnModel().getColumnCount() > 0) {
            jTableUserData.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTableUserData.getColumnModel().getColumn(6).setPreferredWidth(180);
            jTableUserData.getColumnModel().getColumn(8).setPreferredWidth(180);
            jTableUserData.getColumnModel().getColumn(10).setPreferredWidth(180);
            jTableUserData.getColumnModel().getColumn(11).setPreferredWidth(180);
        }

        buttonGroupUserType.add(jRadioButtonZookeeper);
        jRadioButtonZookeeper.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonZookeeper.setText("Tierpfleger/ -in");
        jRadioButtonZookeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonZookeeperActionPerformed(evt);
            }
        });

        jLabelUserType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelUserType.setText("Bitte geben Sie den Usertype an");

        buttonGroupUserType.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonAdmin.setSelected(true);
        jRadioButtonAdmin.setText("Admin");
        jRadioButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdminActionPerformed(evt);
            }
        });

        jLabelOperation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelOperation.setText("Bitte geben Sie die gewünschte Operation an");

        jButtonHelp.setText("Hilfe");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
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
                    .addGroup(jPanelOperationLayout.createSequentialGroup()
                        .addComponent(jLabelOperation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHelp))
                    .addComponent(jRadioButtonDelete)
                    .addComponent(jRadioButtonUpdate)
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOperationLayout.setVerticalGroup(
            jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperation)
                    .addComponent(jButtonHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDelete)
                .addContainerGap())
        );

        jLabelSalutation.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSalutation.setText("Anrede");

        jComboBoxSalutation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Herr", "Frau", "Divers" }));

        jLabelFirstname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelFirstname.setText("Vorname");

        jLabelLastname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelLastname.setText("Nachname");

        jLabelStreet.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelStreet.setText("Straße");

        jTextFieldStreet.setToolTipText("Straße und Hausnummer eintragen");

        jLabelZIP.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZIP.setText("PLZ");

        jLabelCity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCity.setText("Stadt");

        jLabelCountryCode.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCountryCode.setText("Länder Code");
        jLabelCountryCode.setToolTipText("DE für Deutschland");

        jLabelPhoneNumber.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelPhoneNumber.setText("Telefonnummer");

        jTextFieldPhoneNumber.setToolTipText("Bitte Telefonnumer ohne Sonderzeichen eingeben z.B. 014576123");

        jLabelBirthday.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelBirthday.setText("Geburtstag");

        jLabelShift.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShift.setText("Schicht");

        jLabelUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelUsername.setText("Benutzername");

        jLabelEMail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelEMail.setText("E-Mail");

        jLabelPassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelPassword.setText("Passwort");

        jLabelConfirmPassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelConfirmPassword.setText("Passwort bestätigen");

        jComboBoxShift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Früh", "Nachmittag", "Spät" }));

        jTextFieldBirthday.setToolTipText("Format: yyyy-MM-dd");

        jButtonAddUser.setText("Hinzufügen");
        jButtonAddUser.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUserActionPerformed(evt);
            }
        });

        jButtonUpdateUser.setText("Updaten");
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setText("Löschen");
        jButtonDeleteUser.setMaximumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteUser.setMinimumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jLabelSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSearch.setText("Suche Anhand nicht leerer Felder");

        jButtonSearch.setText("Suche");
        jButtonSearch.setToolTipText("Suche anhand angegebener regulärer Ausdrücke, Anrede , Schicht und Benutzertyp, falls zum Beispiel Feld A und Feld B ausgefüllt sind, wird das Resultat den Ausdruck von A und B erfüllen.Passwortfelder werden nicht berücksichtigt ! ");
        jButtonSearch.setMaximumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setMinimumSize(new java.awt.Dimension(73, 23));
        jButtonSearch.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jButtonAnimalsToZookeeper.setText("Tierart um die sich gekümmert werden soll ?");
        jButtonAnimalsToZookeeper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnimalsToZookeeperActionPerformed(evt);
            }
        });

        jButtonClear.setText("Alle Felder leeren");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jComboBoxCountryCode.setToolTipText("DE für Deutschland");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLastname)
                                    .addComponent(jLabelStreet)
                                    .addComponent(jLabelZIP)
                                    .addComponent(jLabelCity)
                                    .addComponent(jLabelCountryCode)
                                    .addComponent(jLabelPhoneNumber)
                                    .addComponent(jLabelSalutation)
                                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxSalutation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextFieldZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabelEMail)
                                                            .addComponent(jLabelUsername)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelShift))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelBirthday))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBoxCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabelConfirmPassword)
                                                            .addComponent(jLabelPassword))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButtonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPasswordFieldConfirm)
                                                        .addComponent(jTextFieldBirthday)
                                                        .addComponent(jTextFieldUsername)
                                                        .addComponent(jTextFieldEMail)
                                                        .addComponent(jPasswordFieldEnteredPW, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                        .addComponent(jComboBoxShift, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonZookeeper)
                                            .addComponent(jRadioButtonAdmin)
                                            .addComponent(jLabelUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAnimalsToZookeeper)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addGap(30, 30, 30)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPaneUserData, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowDateTime))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGoBack)
                    .addComponent(jLabelShowDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneUserData, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAnimalsToZookeeper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonZookeeper)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSalutation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalutation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelBirthday)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelFirstname)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShift)
                            .addComponent(jLabelLastname)
                            .addComponent(jComboBoxShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelUsername)
                                .addComponent(jLabelStreet)
                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelZIP)
                            .addComponent(jTextFieldZIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEMail)
                            .addComponent(jTextFieldEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCity)
                            .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword)
                            .addComponent(jPasswordFieldEnteredPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCountryCode)
                            .addComponent(jLabelConfirmPassword)
                            .addComponent(jComboBoxCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhoneNumber)
                            .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClear)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed

        goBackFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonGoBackActionPerformed


    private void jRadioButtonZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonZookeeperActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonZookeeperActionPerformed

    private void jRadioButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdminActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAdminActionPerformed

    private void jButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUserActionPerformed

        jTextFieldID.setText("");
        JTextField textFields[] = {jTextFieldFirstname, jTextFieldLastname,
            jTextFieldStreet, jTextFieldZIP,
            jTextFieldCity,
            jTextFieldPhoneNumber, jTextFieldBirthday,
            jTextFieldUsername, jTextFieldEMail};

        boolean textFieldsVerified = methods.verifyTextFields(textFields);

        if (textFieldsVerified) {

            String salutationStr = jComboBoxSalutation.getSelectedItem().toString();
            String password = jPasswordFieldEnteredPW.getText();
            String confirmedPassword = jPasswordFieldConfirm.getText();
            String shiftStr = "None";
            Salutation salutation;

            //No only white spaces and no empty password
            if (!password.isBlank() && password.equals(confirmedPassword)) {

                String firstname = jTextFieldFirstname.getText();
                String lastname = jTextFieldLastname.getText();
                String street = jTextFieldStreet.getText();
                String zip = jTextFieldZIP.getText();
                String city = jTextFieldCity.getText();
                String countryCode = jComboBoxCountryCode.getSelectedItem().toString(); //Die Sachen aus der Combobox laden
                String phoneNumber = jTextFieldPhoneNumber.getText();
                String birthdayStr = jTextFieldBirthday.getText();
                String username = jTextFieldUsername.getText();
                String email = jTextFieldEMail.getText();
                int countryId = userManager.getCountryId(countryCode);

                boolean validEmail = methods.isValidEmail(email);

                if (validEmail) {

                    if (!(password.length() < 8)) {
                        try {
                            if (!methods.isValidDateString(birthdayStr)) {
                                throw new IllegalArgumentException("invalidDate");
                            }

                            if (!containsOnlyNumbers(phoneNumber)) {
                                throw new IllegalArgumentException("invalidPhoneNumber");
                            }

                            String userTypeStr;
                            if (userType == Mode.zookeeper) {
                                userTypeStr = "Zookeeper";
                            } else {
                                userTypeStr = "Admin";
                            }
                            if (userTypeStr.equals("Zookeeper")) {
                                shiftStr = getGermanShiftString();
                            }
                            if (!userManager.usernameExists(username)) {

                                if (userManager.searchAddressId(zip, street, city, countryId) == -1) {
                                    JOptionPane.showConfirmDialog(null, "Wollen Sie die Adresse wirklich einfügen?\n"
                                            + "Straße: " + street + "\n"
                                            + "PLZ: " + zip + "\n"
                                            + "Stadt: " + city + "\n"
                                            + "Länder Code: " + countryCode, "Adresse nicht in der Datenbank vorhanden", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                                }
                                salutation = methods.stringToSalutation(salutationStr);
                                Address tempAddress = new Address(street, countryId, zip, city);
                                Date birthday = Date.valueOf(birthdayStr);

                                User tempUser = new User(username, firstname, lastname, email, phoneNumber, salutation, birthday, password, tempAddress);

                                if (userManager.addUser(tempUser, shiftStr, userTypeStr)) {
                                    JOptionPane.showMessageDialog(null, "Nutzer/-in konnte erfolgreich eingefügt werden!", "Einfügen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                                    cleanFields();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Nutzer/-in konnte nicht eingefügt werden!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Benutzername bereits vergeben!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        } catch (IllegalArgumentException illegalArgumentException) {

                            String message = illegalArgumentException.getMessage();
                            System.err.println("Illegal Argument in AddUser button");

                            if (message.equals("invalidDate")) {
                                System.out.println(message);
                                JOptionPane.showMessageDialog(null, "Falsches Datumformat!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }

                            if (message.equals("invalidPhoneNumber")) {
                                System.out.println(message);
                                JOptionPane.showMessageDialog(null, "Keine Sonderzeichen in der Telefonnummer erlaubt!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwort muss mindestens 8 Zeichen haben!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Email an!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Passwörter sind nicht identisch!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
            }
        }
    }//GEN-LAST:event_jButtonAddUserActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed

        String firstname = jTextFieldFirstname.getText().trim();
        String lastname = jTextFieldLastname.getText().trim();
        String street = jTextFieldStreet.getText().trim();
        String zip = jTextFieldZIP.getText().trim();
        String city = jTextFieldCity.getText().trim();
        String countryCode = jComboBoxCountryCode.getSelectedItem().toString();
        String phonenumber = jTextFieldPhoneNumber.getText().trim();
        String birthday = jTextFieldBirthday.getText().trim();
        String username = jTextFieldUsername.getText().trim();
        String email = jTextFieldEMail.getText().trim();
        String salutationStr = jComboBoxSalutation.getSelectedItem().toString();
        String userID = jTextFieldID.getText().trim();
        int countryId = userManager.getCountryId(countryCode);

        String shiftStr = getGermanShiftString();

        int addressIdInt = userManager.searchAddressId(zip, street, city, countryId);
        String addressId = "";
        if (addressIdInt != -1) {
            addressId = String.valueOf(addressIdInt);
        }

        LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
        columnNameToValue.put("Address.ID", addressId);
        columnNameToValue.put("FirstName", firstname);
        columnNameToValue.put("LastName", lastname);
        //Wird benötigt, wenn country code nicht existiert und somit country Id 0 ist
        if (countryId != 0) {
            columnNameToValue.put("CountryId", String.valueOf(countryId));
        }

        columnNameToValue.put("PhoneNumber", phonenumber);
        columnNameToValue.put("Birthday", birthday);
        columnNameToValue.put("UserName", username);
        columnNameToValue.put("Email", email);
        columnNameToValue.put("Salutation", salutationStr);
        columnNameToValue.put("User.ID", userID);
        columnNameToValue.put("Zip", zip);
        columnNameToValue.put("Street", street);
        columnNameToValue.put("Shift", shiftStr);
        String tempUserType;

        if (jRadioButtonAdmin.isSelected()) {
            tempUserType = "Admin";
        } else {
            tempUserType = "Zookeeper";
        }
        columnNameToValue.put("Type", tempUserType);
        lastSearchMap = columnNameToValue;
        LinkedList<User> users = userManager.searchUsers(columnNameToValue);
        if (users.isEmpty() || users == null) {
            methods.clearTable(jTableUserData);
            JOptionPane.showMessageDialog(null, "Es wurden keine Einträge gefunden!", "Keine Ergebnisse", JOptionPane.INFORMATION_MESSAGE);
        } else {
            viewUsers(users);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed

        //Get the mode
        switch (mode) {

            case add:
                JOptionPane.showMessageDialog(null, "Daten eingeben und auf Hinzufügen klicken!", "Hinzufügen", JOptionPane.INFORMATION_MESSAGE);
                break;
            case update:

                switch (userType) {

                    case admin:
                        JOptionPane.showMessageDialog(null, "Bitte die Daten des zu updatenden Admins ausfüllen oder den Datensatz in der Tabelle anklicken und bearbeiten!", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case zookeeper:

                        JOptionPane.showMessageDialog(null, "Bitte die Daten des zu updatenden Tierpfleger/-in ausfüllen oder den Datensatz in der Tabelle anklicken und bearbeiten!", "Updaten", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
                break;
                
            case delete:

                switch (userType) {

                    case admin:
                        JOptionPane.showMessageDialog(null, "Bitte die ID des zu löschenden Admins ausfüllen oder den Datensatz in der Tabelle anklicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case zookeeper:
                        JOptionPane.showMessageDialog(null, "Bitte die ID des zu löschenden Tierpfleger/-in ausfüllen oder den Datensatz in der Tabelle anklicken!", "Löschen", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

                break;
        }
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonUpdateActionPerformed

    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed

        updateButtonsAndLabels();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed

        try {
            int ID = Integer.parseInt(jTextFieldID.getText());

            int decision = JOptionPane.showConfirmDialog(null,
                    "Wollen Sie den Datensatz wirklich löschen?", "Löschbestätigung",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (decision == 0) {
                LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
                columnNameToValue.put("User.ID", String.valueOf(ID));
                //Überpüfen ob die ID existiert
                if (userManager.searchUsers(columnNameToValue).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nutzer/-in existiert nicht!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                } else {
                    if (userManager.deleteUser(ID)) {

                        JOptionPane.showMessageDialog(null, "Nutzer/-in wurde erfolgreich aus der Datenbank entfernt!", "Bestätigung", JOptionPane.INFORMATION_MESSAGE);
                        if (lastSearchMap != null) {
                            lastSearchedUsers = userManager.searchUsers(lastSearchMap);
                            viewUsers(lastSearchedUsers);
                        }
                        cleanFields();
                    } else {

                        JOptionPane.showMessageDialog(null, "Nutzer/-in konnte nicht gelöscht werden!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            }
        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in UserDelete button");
            System.out.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, "ID Feld falsch ausgefüllt!", "Löschen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
        }
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed

        JTextField textFields[] = {jTextFieldFirstname, jTextFieldLastname,
            jTextFieldStreet, jTextFieldZIP,
            jTextFieldCity,
            jTextFieldPhoneNumber, jTextFieldBirthday,
            jTextFieldUsername, jTextFieldEMail};

        boolean textFieldsVerified = methods.verifyTextFields(textFields);
        Salutation salutation;
        if (textFieldsVerified) {

            String salutationStr = jComboBoxSalutation.getSelectedItem().toString();

            String password = jPasswordFieldEnteredPW.getText();
            String confirmedPassword = jPasswordFieldConfirm.getText();

            boolean changePassword = false;

            if (!password.isBlank() && !confirmedPassword.isBlank()) {

                int passwordDescision = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie wirklich das Passwort ändern?", "Bestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (passwordDescision == 0) {
                    changePassword = true;

                    //CHECK IF PASSWORD AND CONFIRMED PASSWORD ARE THE SAME
                    if (!password.equals(confirmedPassword)) {
                        throw new IllegalArgumentException("passwords not identical");
                    }
                }
            }
            String shiftStr = "None";
            try {
                int id = Integer.parseInt(jTextFieldID.getText());
                int decision = JOptionPane.showConfirmDialog(null,
                        "Wollen Sie den Datensatz wirklich ändern?", "Bestätigung",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (decision == 0) {

                    String firstname = jTextFieldFirstname.getText();
                    String lastname = jTextFieldLastname.getText();
                    String street = jTextFieldStreet.getText();
                    String zip = jTextFieldZIP.getText();
                    String city = jTextFieldCity.getText();
                    String countryCode = jComboBoxCountryCode.getSelectedItem().toString();
                    String phoneNumber = jTextFieldPhoneNumber.getText();
                    String birthdayStr = jTextFieldBirthday.getText();
                    String username = jTextFieldUsername.getText();
                    String email = jTextFieldEMail.getText();
                    int countryId = userManager.getCountryId(countryCode);

                    boolean validEmail = methods.isValidEmail(email);
                    if (validEmail) {

                        if (!methods.isValidDateString(birthdayStr)) {
                            throw new IllegalArgumentException("invalidDate");
                        }

                        if (!containsOnlyNumbers(phoneNumber)) {
                            throw new IllegalArgumentException("invalidPhoneNumber");
                        }

                        String userTypeStr;
                        if (userType == Mode.zookeeper) {

                            userTypeStr = "Zookeeper";

                        } else {
                            userTypeStr = "Admin";
                        }

                        //If user is a zookeeper
                        if (userTypeStr.equals("Zookeeper")) {
                            shiftStr = getGermanShiftString();
                        }
                        if ((!changePassword || (password.length() >= 8))) {

                            if (userManager.searchAddressId(zip, street, city, countryId) == -1) {
                                JOptionPane.showConfirmDialog(null, "Wollen Sie die Adresse wirklich einfügen?\n"
                                        + "Straße: " + street + "\n"
                                        + "PLZ: " + zip + "\n"
                                        + "Stadt: " + city + "\n"
                                        + "Länder Code: " + countryCode, "Adresse nicht in der Datenbank vorhanden", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            }

                            salutation = methods.stringToSalutation(salutationStr);
                            Address tempAddress = new Address(street, countryId, zip, city);
                            Date birthday = Date.valueOf(birthdayStr);
                            User tempUser = new User(username, firstname, lastname, email, phoneNumber, salutation, birthday, password, tempAddress);

                            if (userManager.updateUser(id, tempUser, shiftStr, userTypeStr, changePassword)) {
                                JOptionPane.showMessageDialog(null, "Nutzer/-in konnte erfolgreich geupdatet werden!", "Updaten erfolgreich", JOptionPane.INFORMATION_MESSAGE);
                                cleanFields();

                                if (lastSearchMap != null) {
                                    lastSearchedUsers = userManager.searchUsers(lastSearchMap);
                                    viewUsers(lastSearchedUsers);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Nutzer/-in konnte nicht geupdatet werden!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Passwort muss mindestens 8 Zeichen haben!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Bitte geben Sie eine gültige Email an!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                    }
                }
            } catch (NumberFormatException numberFormatException) {

                System.err.println("NumberFormatException in UpdateUser button");
                System.out.println(numberFormatException.getMessage());
                JOptionPane.showMessageDialog(null, "ID Feld falsch ausgefüllt!", "Zahlenfeld wurde falsch ausgefüllt", JOptionPane.CANCEL_OPTION);

            } catch (IllegalArgumentException illegalArgumentException) {

                String message = illegalArgumentException.getMessage();

                System.err.println("Illegal Argument in UpdateUser button");
                System.out.println(message);

                if (message.equals("passwords not identical")) {
                    
                    JOptionPane.showMessageDialog(null, "Passwörter sind nicht identisch!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("invalidDate")) {
                    
                    JOptionPane.showMessageDialog(null, "Bitte Geburtstag im Format yyyy-MM-dd eintragen!", "Updaten fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                } else if (message.equals("invalidPhoneNumber")) {

                    System.out.println(message);
                    JOptionPane.showMessageDialog(null, "Keine Sonderzeichen in der Telefonnummer erlaubt!", "Einfügen fehlgeschlagen", JOptionPane.CANCEL_OPTION);
                }
            }
        }
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private void jButtonAnimalsToZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnimalsToZookeeperActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame MangeZookeeperToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonAnimalsToZookeeperActionPerformed

    private void jTableUserDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserDataMouseClicked

        int rowIndex = jTableUserData.getSelectedRow();
        TableModel model = jTableUserData.getModel();

        jTextFieldID.setText(model.getValueAt(rowIndex, 0).toString());
        String salutation = model.getValueAt(rowIndex, 2).toString();
        jComboBoxSalutation.setSelectedItem(salutation);
        jTextFieldFirstname.setText(model.getValueAt(rowIndex, 4).toString());
        jTextFieldLastname.setText(model.getValueAt(rowIndex, 5).toString());
        jTextFieldStreet.setText(model.getValueAt(rowIndex, 10).toString());
        jTextFieldZIP.setText(model.getValueAt(rowIndex, 9).toString());
        jTextFieldCity.setText(model.getValueAt(rowIndex, 11).toString());
        String countryCode = model.getValueAt(rowIndex, 12).toString();
        jComboBoxCountryCode.setSelectedItem(countryCode);
        jTextFieldPhoneNumber.setText(model.getValueAt(rowIndex, 6).toString());
        jTextFieldBirthday.setText(model.getValueAt(rowIndex, 7).toString());
        String shift = model.getValueAt(rowIndex, 1).toString();
        jComboBoxShift.setSelectedItem(shift);
        jTextFieldUsername.setText(model.getValueAt(rowIndex, 3).toString());
        jTextFieldEMail.setText(model.getValueAt(rowIndex, 8).toString());
    }//GEN-LAST:event_jTableUserDataMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.append("LOGOUT");
        zooManager.getUserManager().logout();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        cleanFields();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void updateButtonsAndLabels() {

        if (jRadioButtonAdmin.isSelected()) {
            System.out.println("Admin Mode");

            userType = Mode.admin;
            jComboBoxShift.setEnabled(false);
            jLabelShift.setEnabled(false);
            jButtonAnimalsToZookeeper.setEnabled(false);
            if (jRadioButtonAdd.isSelected()) {
                
                System.out.println("    Add mode");
                mode = Mode.add;
                methods.clearTable(jTableUserData);
                jButtonAddUser.setEnabled(true);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(false);
                jLabelID.setEnabled(false);
                jLabelSearch.setEnabled(false);
                jButtonSearch.setEnabled(false);
                jTextFieldID.setText("");

            } else if (jRadioButtonUpdate.isSelected()) {
                
                System.out.println("    Update mode");
                mode = Mode.update;
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(true);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);

            } else if (jRadioButtonDelete.isSelected()) {

                System.out.println("    Delete mode");
                mode = Mode.delete;
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(true);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);

            }
        } else {

            System.out.println("Zookeeper Mode");
            jComboBoxShift.setEnabled(true);
            jLabelShift.setEnabled(true);
            userType = Mode.zookeeper;
            
            if (jRadioButtonAdd.isSelected()) {
                
                System.out.println("    Add mode");
                methods.clearTable(jTableUserData);
                jButtonAnimalsToZookeeper.setEnabled(true);
                jButtonAddUser.setEnabled(true);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(false);
                jLabelID.setEnabled(false);
                jLabelSearch.setEnabled(false);
                jButtonSearch.setEnabled(false);
                jTextFieldID.setText("");
                mode = Mode.add;
                
            } else if (jRadioButtonUpdate.isSelected()) {
                
                System.out.println("    Update mode");
                mode = Mode.update;
                jButtonAnimalsToZookeeper.setEnabled(true);
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(true);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);

            } else if (jRadioButtonDelete.isSelected()) {
                mode = Mode.delete;
                System.out.println("    Delete mode");
                jButtonAnimalsToZookeeper.setEnabled(false);
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(true);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                jLabelSearch.setEnabled(true);
                jButtonSearch.setEnabled(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.ButtonGroup buttonGroupUserType;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonAnimalsToZookeeper;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxCountryCode;
    private javax.swing.JComboBox<String> jComboBoxSalutation;
    private javax.swing.JComboBox<String> jComboBoxShift;
    private javax.swing.JLabel jLabelBirthday;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelCountryCode;
    private javax.swing.JLabel jLabelEMail;
    private javax.swing.JLabel jLabelFirstname;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLastname;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPhoneNumber;
    private javax.swing.JLabel jLabelSalutation;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelShift;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JLabel jLabelUserType;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelZIP;
    private javax.swing.JPanel jPanelOperation;
    private javax.swing.JPasswordField jPasswordFieldConfirm;
    private javax.swing.JPasswordField jPasswordFieldEnteredPW;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JRadioButton jRadioButtonZookeeper;
    private javax.swing.JScrollPane jScrollPaneUserData;
    private javax.swing.JTable jTableUserData;
    private javax.swing.JTextField jTextFieldBirthday;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldEMail;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLastname;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JTextField jTextFieldZIP;
    // End of variables declaration//GEN-END:variables
    
    private javax.swing.JFrame goBackFrame;
    private Methods methods;
    private Mode mode;
    private Mode userType;
    private ZooManager zooManager;
    private UserManager userManager;
    private LinkedList<User> lastSearchedUsers;
    private LinkedHashMap<String, String> lastSearchMap;
}