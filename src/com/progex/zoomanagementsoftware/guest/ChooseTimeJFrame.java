
package com.progex.zoomanagementsoftware.guest;

import com.progex.zoomanagementsoftware.ManagersAndHandlers.GuestModeManager;
import com.progex.zoomanagementsoftware.ManagersAndHandlers.ZooManager;
import com.progex.zoomanagementsoftware.datatypes.FeedingInfo;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class ChooseTimeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZeitjFrame
     * @param goBackFrame
     * @param zooManager
     * @param time
     */
    public ChooseTimeJFrame(JFrame goBackFrame, ZooManager zooManager, String time) {

        this.goBackFrame = goBackFrame;
        this.zooManager = zooManager;
        this.guestModeManager = zooManager.getGuestModeManager();
        this.time = time;

        initComponents();
        myInitComponents();
        viewTimes();
    }

    private void myInitComponents() {

        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        
        if (x == 1920 && y == 1080) {
            
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 32));
        }
        if (x == 1280 && y == 720) {
            jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 28));
        }

        JTableHeader tableHeader = jTableTimeData.getTableHeader();
        Font headerFont = new Font("Calibri", 0, 22);
        tableHeader.setFont(headerFont);

        
        jLabelTime.setText("Fütterungen um " +time + " Uhr");
        
        jTableTimeData.setRowHeight(40);

        Methods methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /*Fulfill all relevant Data in Table */
    private void viewTimes() {

        //Time String in Date String 
        String tmp = time.concat(":00");
        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
        String str = dateformat.format(new Date());
        String day = str.substring(0, 2);
        String month = str.substring(3, 5);
        String year = str.substring(6, 10);
        String last = (year + "-" + month + "-" + day + " ").concat(tmp);

        LinkedList<FeedingInfo> feedingInfos = guestModeManager.getTimeFeedingInfo(last);

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableTimeData.getModel();

        //manipulate table 
        Object[] row = new Object[3];

        for (FeedingInfo feedingInfo : feedingInfos) {
            
            row[0] = feedingInfo.getAnimalName();
            System.out.println(row[0]);
            row[1] = feedingInfo.getCompundName();
            System.out.println(row[1]);
            row[2] = feedingInfo.getFoodName();
            System.out.println(row[2]);
            defaultTableModel.addRow(row);

        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBack = new javax.swing.JButton();
        jLabelShowDateTime = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jScrollPaneAnimalTable = new javax.swing.JScrollPane();
        jTableTimeData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jButtonBack.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButtonBack.setText("Zurück");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelShowDateTime.setText("TIME");

        jLabelTime.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelTime.setText("Uhr");

        jScrollPaneAnimalTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableTimeData.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTableTimeData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiername", "Gehegename", "Futter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTimeData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTimeData.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAnimalTable.setViewportView(jTableTimeData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelShowDateTime))
                    .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTime)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTime)
                .addGap(25, 25, 25)
                .addComponent(jScrollPaneAnimalTable, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseTimeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        String url = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "0000";
        String dbName = "zoo";

        ZooManager zooManager = new ZooManager(url, dbName, username, password);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseTimeJFrame(null, zooManager, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelShowDateTime;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JScrollPane jScrollPaneAnimalTable;
    private javax.swing.JTable jTableTimeData;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private ZooManager zooManager;
    private GuestModeManager guestModeManager;
    private String time;

}
