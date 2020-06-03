/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.admin;

/**
 *
 * @author Ouchen
 */
public class ManageUserJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManageUserJFrame
     */
    
    
    public ManageUserJFrame() {
        initComponents();
        updateButtons();

        // myInitComponents();
    
    }
    
    
    
    /*
    public void myInitComponents()
    }*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupUserType = new javax.swing.ButtonGroup();
        buttonGroupOperation = new javax.swing.ButtonGroup();
        jLabelSalutation = new javax.swing.JLabel();
        jLabelFirstname = new javax.swing.JLabel();
        jLabelLastname = new javax.swing.JLabel();
        jLabelStreet = new javax.swing.JLabel();
        jLabelCity = new javax.swing.JLabel();
        jLabelZIP = new javax.swing.JLabel();
        jLabelCountry = new javax.swing.JLabel();
        jLabelPhoneNumber = new javax.swing.JLabel();
        jComboBoxSalutation = new javax.swing.JComboBox<>();
        jTextFieldFirstname = new javax.swing.JTextField();
        jTextFieldLastname = new javax.swing.JTextField();
        jTextFieldZIP = new javax.swing.JTextField();
        jTextFieldCity = new javax.swing.JTextField();
        jTextFieldStreet = new javax.swing.JTextField();
        jTextFieldCountry = new javax.swing.JTextField();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jLabelBirthday = new javax.swing.JLabel();
        jLabelShift = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelEMail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        jTextFieldBirthday = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jTextFieldEMail = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jComboBoxShift = new javax.swing.JComboBox<>();
        jTextFieldConfirmPassword = new javax.swing.JTextField();
        jButtonAddUser = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButtonGoBack = new javax.swing.JButton();
        jPanelUserType = new javax.swing.JPanel();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jRadioButtonZookeeper = new javax.swing.JRadioButton();
        jLabelUserType = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelOperation = new javax.swing.JLabel();
        jRadioButtonAdd = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelSalutation.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelSalutation.setText("Anrede");

        jLabelFirstname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelFirstname.setText("Vorname");

        jLabelLastname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelLastname.setText("Nachname");

        jLabelStreet.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelStreet.setText("Straße");

        jLabelCity.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCity.setText("Stadt");

        jLabelZIP.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelZIP.setText("PLZ");

        jLabelCountry.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelCountry.setText("Land");

        jLabelPhoneNumber.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelPhoneNumber.setText("Telefonnummer");

        jComboBoxSalutation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Herr", "Frau", "Divers" }));
        jComboBoxSalutation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSalutationActionPerformed(evt);
            }
        });

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
        jComboBoxShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxShiftActionPerformed(evt);
            }
        });

        jButtonAddUser.setText("Hinzufügen");
        jButtonAddUser.setPreferredSize(new java.awt.Dimension(73, 23));
        jButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUserActionPerformed(evt);
            }
        });

        jButtonUpdateUser.setText("Updaten");

        jButtonDeleteUser.setText("Löschen");
        jButtonDeleteUser.setMaximumSize(new java.awt.Dimension(87, 23));
        jButtonDeleteUser.setMinimumSize(new java.awt.Dimension(87, 23));

        jLabelID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelID.setText("ID");

        jButtonGoBack.setText("Zurück");
        jButtonGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoBackActionPerformed(evt);
            }
        });

        buttonGroupUserType.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButtonAdmin.setSelected(true);
        jRadioButtonAdmin.setText("Admin");
        jRadioButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAdminActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanelUserTypeLayout = new javax.swing.GroupLayout(jPanelUserType);
        jPanelUserType.setLayout(jPanelUserTypeLayout);
        jPanelUserTypeLayout.setHorizontalGroup(
            jPanelUserTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUserTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonZookeeper)
                    .addComponent(jRadioButtonAdmin)
                    .addComponent(jLabelUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanelUserTypeLayout.setVerticalGroup(
            jPanelUserTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonZookeeper)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonDelete)
                    .addComponent(jRadioButtonUpdate)
                    .addComponent(jLabelOperation)
                    .addComponent(jRadioButtonAdd))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableUserData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Anrede", "Benutzername", "Vorname", "Nachname", "Telefonnummer", "Geburtstag", "E-Mail", "Plz", "Straße", "Stadt", "Land", "Shift"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUserData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableUserData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableUserData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSalutation)
                            .addComponent(jLabelFirstname)
                            .addComponent(jLabelLastname)
                            .addComponent(jLabelStreet)
                            .addComponent(jLabelZIP)
                            .addComponent(jLabelCity)
                            .addComponent(jLabelCountry)
                            .addComponent(jLabelPhoneNumber))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldZIP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSalutation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBirthday)
                                    .addComponent(jLabelShift)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelPassword)
                                            .addComponent(jLabelEMail)
                                            .addComponent(jLabelUsername)
                                            .addComponent(jLabelConfirmPassword))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxShift, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextFieldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jTextFieldEMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jTextFieldConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jTextFieldUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jButtonAddUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                .addComponent(jTextFieldBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))))
                            .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGoBack)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelUserType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelID)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSalutation)
                            .addComponent(jComboBoxSalutation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBirthday)
                            .addComponent(jTextFieldBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelFirstname)
                                .addComponent(jLabelShift)
                                .addComponent(jComboBoxShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLastname)
                    .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStreet)
                    .addComponent(jTextFieldStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEMail)
                    .addComponent(jTextFieldEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelZIP)
                    .addComponent(jTextFieldZIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword)
                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCity)
                    .addComponent(jTextFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConfirmPassword)
                    .addComponent(jTextFieldConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCountry)
                            .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPhoneNumber))
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSalutationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSalutationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSalutationActionPerformed

    private void jComboBoxShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxShiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxShiftActionPerformed

    private void jButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddUserActionPerformed

    private void jButtonGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoBackActionPerformed
        // TODO GO BACK TO MAIN MENU OF ADMIN
    }//GEN-LAST:event_jButtonGoBackActionPerformed

    private void jRadioButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAddActionPerformed
        
     
        updateButtons();
    }//GEN-LAST:event_jRadioButtonAddActionPerformed

    private void jRadioButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateActionPerformed
        
     
        updateButtons();
    }//GEN-LAST:event_jRadioButtonUpdateActionPerformed

    
    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed
        
    
        updateButtons();
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed

    private void jRadioButtonZookeeperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonZookeeperActionPerformed

        updateButtons();
    }//GEN-LAST:event_jRadioButtonZookeeperActionPerformed

    private void jRadioButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAdminActionPerformed

        updateButtons();
    }//GEN-LAST:event_jRadioButtonAdminActionPerformed

    
    /**
     * Method to disable/enable buttons depending user/zookeeper mode
     * and operation selection.
     */
    private void updateButtons(){
        
        
        if (jRadioButtonAdmin.isSelected()){
            System.out.println("Admin Mode");
             jComboBoxShift.setEnabled(false);
             jLabelShift.setEnabled(false);
            if (jRadioButtonAdd.isSelected()){
                System.out.println("    Add mode");
                
                jButtonAddUser.setEnabled(true);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(false);
                jLabelID.setEnabled(false);
                //TODO DISABLE SEARCH
               
            } else if (jRadioButtonUpdate.isSelected()){
                System.out.println("    Update mode");
               
                //TODO ENABLE SEARCH
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(true);
                jButtonDeleteUser.setEnabled(false);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
               
                
            } else if (jRadioButtonDelete.isSelected()){
                System.out.println("    Delete mode");
                
                //TODO ENABLE SEARCH
                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(false);
                jButtonDeleteUser.setEnabled(true);
                jTextFieldID.setEnabled(true);
                jLabelID.setEnabled(true);
                
            }
        } 
        
        else{
            
            //TODO DASSELBE WIE OBEN FÜR ZOOKEEPER
            System.out.println("Zookeeper Mode");
            if (jRadioButtonAdd.isSelected()){
                System.out.println("    Add mode");
            } else if (jRadioButtonUpdate.isSelected()){
                System.out.println("    Update mode");
            } else if (jRadioButtonDelete.isSelected()){
                System.out.println("    Delete mode");
            }
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
                new ManageUserJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOperation;
    private javax.swing.ButtonGroup buttonGroupUserType;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonGoBack;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxSalutation;
    private javax.swing.JComboBox<String> jComboBoxShift;
    private javax.swing.JLabel jLabelBirthday;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelCountry;
    private javax.swing.JLabel jLabelEMail;
    private javax.swing.JLabel jLabelFirstname;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLastname;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPhoneNumber;
    private javax.swing.JLabel jLabelSalutation;
    private javax.swing.JLabel jLabelShift;
    private javax.swing.JLabel jLabelStreet;
    private javax.swing.JLabel jLabelUserType;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelZIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelUserType;
    private javax.swing.JRadioButton jRadioButtonAdd;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JRadioButton jRadioButtonZookeeper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUserData;
    private javax.swing.JTextField jTextFieldBirthday;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldConfirmPassword;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldEMail;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLastname;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldStreet;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JTextField jTextFieldZIP;
    // End of variables declaration//GEN-END:variables
}
