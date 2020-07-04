package com.progex.zoomanagementsoftware.main;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.UserManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.admin.AdminHomepageJFrame;
import com.progex.zoomanagementsoftware.datatypes.Admin;
import com.progex.zoomanagementsoftware.datatypes.User;
import com.progex.zoomanagementsoftware.datatypes.Zookeeper;
import com.progex.zoomanagementsoftware.hashing.MD5Hash;
import com.progex.zoomanagementsoftware.zookeeper.ZookeeperModeHomePageJFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class LoginJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginJFrame.
     *
     * @param zooManager The zooManager of the current Programm session which
     * serves as interface
     * @param goBackMainMenuJFrame The frame which will appear when the logout
     * back button is used
     */
    public LoginJFrame(JFrame goBackMainMenuJFrame, ZooManager zooManager) {

        initComponents();
        myInitComponents();
        // Set previous JFrame to make it visible/invisible
        this.mainMenuJFrame = goBackMainMenuJFrame;
        // Set zooManager to call Methods and stuff
        this.zooManager = zooManager;
        this.userManager = zooManager.getUserManager();
        // Set LoginJFrame in middle of screen when opened
        this.setLocationRelativeTo(null);
    }

    private void myInitComponents() {

        //when enter button is pushed
        KeyListener pressEnterListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButtonLogin.doClick();
                }
            }
        };
        jPasswordFieldPassword.addKeyListener(pressEnterListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        username = new javax.swing.JLabel();
        passwort = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        login = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jLabelLoginError = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        username.setText("Benutzername");

        passwort.setText("Passwort");

        login.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        login.setText("Login");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwort)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLoginError, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPasswordFieldPassword)
                                .addGap(1, 1, 1))
                            .addComponent(jTextFieldUsername)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(login)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldPassword)
                    .addComponent(passwort))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLoginError, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        // Get username from input field
        String username = jTextFieldUsername.getText();

        // Get password from input field and hash it
        MD5Hash hasher = new MD5Hash();
        String hashedPw = hasher.hashString(new String(jPasswordFieldPassword.getPassword()));

        // Check if username and password match data in database and if user is zookeeper 
        User user = userManager.login(username, hashedPw);

        if (user instanceof Admin) {

            userManager.setLoggedInUser(user);

            //Open admin window here

            // Open AdminHomePage when Login successful and pass zooManager reference
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminHomepageJFrame(mainMenuJFrame, zooManager).setVisible(true);
                }
            });

            mainMenuJFrame.setVisible(false);
            this.dispose();
        }
        
        if (user instanceof Zookeeper) {

            userManager.setLoggedInUser(user);

            // Open ZookeeperHomePage when Login successful and pass zooManager reference
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new ZookeeperModeHomePageJFrame(mainMenuJFrame, zooManager).setVisible(true);

                }
            });

            //Make main menue invisible
            mainMenuJFrame.setVisible(false);
            this.dispose();
        } else {
            jLabelLoginError.setText("Anmeldedaten nicht korrekt!");
            jLabelLoginError.setForeground(Color.RED);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelLoginError;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JLabel login;
    private javax.swing.JLabel passwort;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    private javax.swing.JFrame mainMenuJFrame;
    private ZooManager zooManager;
    private UserManager userManager;
}
