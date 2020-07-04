package com.progex.zoomanagementsoftware.admin;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.*;
import com.progex.zoomanagementsoftware.datatypes.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminHomepageJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomePageFramne.
     *
     * @param mainMenuJFrame The frame which will appear when the logout back
     * button is used
     * @param zooManager The zooManager of the current program session which
     * serves as interface
     */
    public AdminHomepageJFrame(JFrame mainMenuJFrame, ZooManager zooManager) {

        this.zooManager = zooManager;
        this.userManager = zooManager.getUserManager();
        this.mainMenuJFrame = mainMenuJFrame;
        this.methods = new Methods();
        initComponents();
        myInitComponents();
    }

    private void myInitComponents() {

        methods.showTimeAndDate(jLabelShowDateTime);
        User loggedInUser = userManager.getLoggedInUser();
        jLabelWelcomeAdmin.setText("Hallo " + loggedInUser.getFirstname());
    }

    private void fillTable(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        LinkedHashMap<String, String> columnNameToValue = new LinkedHashMap<String, String>();
        columnNameToValue.put("type", "Admin");

        String limit = jTextFieldAmountAdmins.getText().trim();

        LinkedList<User> users = zooManager.getUserManager().searchUsers(columnNameToValue, limit);

        model = (DefaultTableModel) jTableLastLoginAdminsData.getModel();

        Object[] row = new Object[5];

        for (User admin : users) {
            row[0] = admin.getId();
            row[1] = methods.removeSeconds(admin.getLastLogDate().toString());
            if (admin.getSalutation().equals(Salutation.mr)) {
                row[2] = "Herr";
            } else if (admin.getSalutation().equals(Salutation.mrs)) {
                row[2] = "Frau";
            } else {
                row[2] = "Divers";
            }
            row[3] = admin.getFirstname();
            row[4] = admin.getLastname();

            model.addRow(row);
        }
    }

    private void viewAdmins() {

        methods.clearTable(jTableLastLoginAdminsData);
        fillTable(jTableLastLoginAdminsData);
    }

    private boolean checkInput() {
        
        try {
            int amountAdmins = Integer.parseInt(jTextFieldAmountAdmins.getText());

            if (amountAdmins >= 1) {
                return true;
            }
        } catch (NumberFormatException numberFormatException) {

            System.err.println("NumberFormatException in viewAdmins() of AdminHomePageJFrame");
            System.out.println(numberFormatException.getMessage());
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelWelcomeAdmin = new javax.swing.JLabel();
        jLabelQuestion = new javax.swing.JLabel();
        jButtonManageUser = new javax.swing.JButton();
        jButtonManageAnimals = new javax.swing.JButton();
        jButtonManageFood = new javax.swing.JButton();
        jButtonManageCompound = new javax.swing.JButton();
        jButtonManageTakesCare = new javax.swing.JButton();
        jButtonManageEats = new javax.swing.JButton();
        jLabelAmountAdmins = new javax.swing.JLabel();
        jTextFieldAmountAdmins = new javax.swing.JTextField();
        jButtonLogout = new javax.swing.JButton();
        jLabelLastLogins = new javax.swing.JLabel();
        jScrollPaneLastLoginAdminsTable = new javax.swing.JScrollPane();
        jTableLastLoginAdminsData = new javax.swing.JTable();
        jButtonShowAdmins = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Mode");
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelWelcomeAdmin.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelWelcomeAdmin.setText("Hallo X");

        jLabelQuestion.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelQuestion.setText("Was möchten Sie verwalten?");

        jButtonManageUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageUser.setText("Tierpfleger/-innen oder Admins");
        jButtonManageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageUserActionPerformed(evt);
            }
        });

        jButtonManageAnimals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageAnimals.setText("Tiere");
        jButtonManageAnimals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageAnimalsActionPerformed(evt);
            }
        });

        jButtonManageFood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageFood.setText("Futter");
        jButtonManageFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageFoodActionPerformed(evt);
            }
        });

        jButtonManageCompound.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageCompound.setText("Gehege");
        jButtonManageCompound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageCompoundActionPerformed(evt);
            }
        });

        jButtonManageTakesCare.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageTakesCare.setText("Tierpfleger/-innen zu Tiere Zuweisung");
        jButtonManageTakesCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageTakesCareActionPerformed(evt);
            }
        });

        jButtonManageEats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonManageEats.setText("Futter zu Tiere Zuweisung");
        jButtonManageEats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageEatsActionPerformed(evt);
            }
        });

        jLabelAmountAdmins.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelAmountAdmins.setText("Anzahl auszugebende Admins");

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabelLastLogins.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelLastLogins.setText("Letzte Zugriffe:");

        jScrollPaneLastLoginAdminsTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableLastLoginAdminsData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Letzter Zugriff", "Anrede", "Vorname", "Nachname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLastLoginAdminsData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLastLoginAdminsData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneLastLoginAdminsTable.setViewportView(jTableLastLoginAdminsData);
        if (jTableLastLoginAdminsData.getColumnModel().getColumnCount() > 0) {
            jTableLastLoginAdminsData.getColumnModel().getColumn(1).setPreferredWidth(140);
        }

        jButtonShowAdmins.setText("Ausgeben");
        jButtonShowAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowAdminsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(197, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonManageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageAnimals, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageCompound, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageTakesCare, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageFood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonManageEats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelQuestion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabelWelcomeAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLastLogins)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAmountAdmins)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonShowAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(259, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelShowDateTime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jButtonLogout)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLogout)
                            .addComponent(jLabelShowDateTime))
                        .addGap(49, 49, 49)
                        .addComponent(jLabelAmountAdmins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAmountAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonShowAdmins))
                        .addGap(12, 12, 12)
                        .addComponent(jLabelLastLogins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneLastLoginAdminsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(jLabelWelcomeAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageAnimals, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageFood, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageCompound, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageTakesCare, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonManageEats, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonManageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageUserActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame MangeUser*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUserJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageUserActionPerformed

    private void jButtonManageAnimalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageAnimalsActionPerformed

        //Set Main Menue to not visible
        this.setVisible(false);

        JFrame thisFrame = this;
        /* Create and display the JFrame ManageAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageAnimalsActionPerformed

    private void jButtonManageFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageFoodActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame ManageFood*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageFoodActionPerformed

    private void jButtonManageCompoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageCompoundActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame ManageCompound*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCompoundJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageCompoundActionPerformed

    private void jButtonManageTakesCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageTakesCareActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame MangeZookeeperToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageZookeeperToAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageTakesCareActionPerformed

    private void jButtonShowAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowAdminsActionPerformed

        boolean validInput = checkInput();

        if (validInput) {
            viewAdmins();
        } else
            JOptionPane.showMessageDialog(null, "Anzahl der auszugebenden Admins ungültig!", "Zahlenfeld falsch ausgefüllt", JOptionPane.CANCEL_OPTION);
    }//GEN-LAST:event_jButtonShowAdminsActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed

        userManager.logout();
        this.dispose();
        mainMenuJFrame.setVisible(true);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        System.out.println("LOGOUT");
        userManager.logout();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonManageEatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageEatsActionPerformed

        this.setVisible(false);
        JFrame thisFrame = this;
        /* Create and display the JFrame ManageFoodToAnimal*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageFoodToAnimalJFrame(thisFrame, zooManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButtonManageEatsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonManageAnimals;
    private javax.swing.JButton jButtonManageCompound;
    private javax.swing.JButton jButtonManageEats;
    private javax.swing.JButton jButtonManageFood;
    private javax.swing.JButton jButtonManageTakesCare;
    private javax.swing.JButton jButtonManageUser;
    private javax.swing.JButton jButtonShowAdmins;
    private javax.swing.JLabel jLabelAmountAdmins;
    private javax.swing.JLabel jLabelLastLogins;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelWelcomeAdmin;
    private javax.swing.JScrollPane jScrollPaneLastLoginAdminsTable;
    private javax.swing.JTable jTableLastLoginAdminsData;
    private javax.swing.JTextField jTextFieldAmountAdmins;
    // End of variables declaration//GEN-END:variables

    private ZooManager zooManager;
    private UserManager userManager;
    private JFrame mainMenuJFrame;
    private Methods methods;
}