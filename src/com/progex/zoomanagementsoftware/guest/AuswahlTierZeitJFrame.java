/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progex.zoomanagementsoftware.guest;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author oLLii
 */
public class AuswahlTierZeitJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AuswahlTierZeitJFrame
     */
    public AuswahlTierZeitJFrame() {
        initComponents();
        myInitComponents();
    }
    
    public void myInitComponents(){
        
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

        jButtonZurueck = new javax.swing.JButton();
        jLabelFindeHeraus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelZeit = new javax.swing.JLabel();
        jComboBoxName = new javax.swing.JComboBox<>();
        jComboZeit = new javax.swing.JComboBox<>();
        jButtonSuchen = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonZurueck.setText("Zurück");

        jLabelFindeHeraus.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelFindeHeraus.setText("Finde heraus wann welches Tier gefüttert wird");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Bitte treffe mindestens eine Auswahl");

        jLabelName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelName.setText("Tiername:");

        jLabelZeit.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabelZeit.setText("Fütterungszeit:");

        jComboBoxName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboZeit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonSuchen.setText("Suchen");
        jButtonSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuchenActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonZurueck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelZeit)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboZeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelName)
                                            .addGap(80, 80, 80)
                                            .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(jButtonSuchen))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabelFindeHeraus)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonZurueck)
                    .addComponent(jLabelShowDateTime))
                .addGap(39, 39, 39)
                .addComponent(jLabelFindeHeraus)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jComboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelZeit)
                    .addComponent(jComboZeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonSuchen)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuchenActionPerformed
        
        //wenn keine Eingabe
        JOptionPane.showMessageDialog(null, "Sie haben keine Fütterungszeit und kein Tier ausgewählt\n\nBitte treffen sie mindestens eine Auswahl","Fehlermeldung", JOptionPane.CANCEL_OPTION);
        //wenn Tier keine Fütterungen mehr hat
        JOptionPane.showMessageDialog(null, "Keine Fütterungen für 'Tier' heute!\n\nVielleicht haben sie an einem anderen Tag mehr Glück :)","Schade", JOptionPane.CANCEL_OPTION);
        //wenn Uhrzeit keine Fütterungen hat 
        JOptionPane.showMessageDialog(null, "Es finden keine Fütterungen um diese Uhrzeit heute statt \n\nVielleicht haben sie an einem anderen Tag mehr Glück :)","Schade", JOptionPane.CANCEL_OPTION); 
        //wenn Tier und Uhrzeit false
        JOptionPane.showMessageDialog(null, "Es finden keine Fütterungen für 'Tier' um  'Uhrzeit' heute statt!\n\nSuchen Sie nur nach dem Tier, um Verfügbare Uhrzeiten angezeigt zu bekommen","Schade", JOptionPane.CANCEL_OPTION);
    }//GEN-LAST:event_jButtonSuchenActionPerformed

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
            java.util.logging.Logger.getLogger(AuswahlTierZeitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuswahlTierZeitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuswahlTierZeitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuswahlTierZeitJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuswahlTierZeitJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSuchen;
    private javax.swing.JButton jButtonZurueck;
    private javax.swing.JComboBox<String> jComboBoxName;
    private javax.swing.JComboBox<String> jComboZeit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFindeHeraus;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelZeit;
    // End of variables declaration//GEN-END:variables
}
