package com.progex.zoomanagementsoftware.main;

;
import com.progex.zoomanagementsoftware.datatypes.Methods;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class ZooMapJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ZooMapJFrame.
     *
     * @param goBackFrame The frame which will appear when the go back button is
     * used
     */
    public ZooMapJFrame(JFrame goBackFrame) {
        initComponents();
        myInitComponents();
        this.goBackFrame = goBackFrame;
        methods = new Methods();
        methods.showTimeAndDate(jLabelShowDateTime);
    }

    private void myInitComponents() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = (int) tk.getScreenSize().getWidth();
        int y = (int) tk.getScreenSize().getHeight();
        setSize(x, y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        InputStream inputStream = ZooMapJFrame.class.getResourceAsStream("ZooMap.jpg");

        BufferedImage img = null;

        int scaledWidth = 1450;
        int scaledHeight = 800;

        try {
            img = ImageIO.read(inputStream);
            BufferedImage outputImage = new BufferedImage(scaledWidth,
                    scaledHeight, img.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();

            g2d.drawImage(img, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            ImageIcon icon = new ImageIcon(outputImage);
            imageLabel.setIcon(icon);
        } catch (IOException ex) {
            System.err.println("IO Exception in myInitComponents()");
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelShowDateTime = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zoo Karte");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jLabelShowDateTime.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelShowDateTime.setText("TIME  and Date");
        jLabelShowDateTime.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButtonBack.setText("Zurück");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Symbolbild: www.freepik.com Designed by rawpixel.com ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(40, 478, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShowDateTime)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack)
                    .addComponent(jLabelShowDateTime))
                .addGap(63, 63, 63)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Method to return to the Main menu.
     *
     * @param evt
     */
    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        goBackFrame.setVisible(true);
        //Close frame
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelShowDateTime;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JFrame goBackFrame;
    private Methods methods;
}
