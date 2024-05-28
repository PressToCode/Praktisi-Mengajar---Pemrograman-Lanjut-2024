/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tourandtravel;

import Controller.HalamanUtamaControl;

/**
 *
 * @author PREDATOR
 */
public class HalamanUtama extends javax.swing.JFrame {
    // digunakan di banyak jInternalframe
    public static String url = "";
    public static String username = "";
    public static String password = "";
    
    // attribute lain
    public static boolean isConnected = false;
    KaryawanPage appKaryawan = new KaryawanPage();
    DatabasePage appDatabase = new DatabasePage();
    SchedulePage appSchedule = new SchedulePage();
    
    // Set Attribute
    public static void infoDatabase(String url, String username, String password) {
        HalamanUtama.url = url;
        HalamanUtama.username = username;
        HalamanUtama.password = password;
        HalamanUtama.isConnected = true;
        HalamanUtamaControl.cekSqlTimer();
    }
    
    /**
     * Creates new form HalamanUtama
     */
    public HalamanUtama() {
        initComponents();
        desktopPaneContain.add(appKaryawan);
        desktopPaneContain.add(appDatabase);
        desktopPaneContain.add(appSchedule);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        desktopPaneContain = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuKaryawan = new javax.swing.JMenuItem();
        menuKendaraan = new javax.swing.JMenuItem();
        menuSchedule = new javax.swing.JMenuItem();
        menuDatabase = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Utama");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(800, 640));
        setSize(new java.awt.Dimension(1000, 640));

        desktopPaneContain.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout desktopPaneContainLayout = new javax.swing.GroupLayout(desktopPaneContain);
        desktopPaneContain.setLayout(desktopPaneContainLayout);
        desktopPaneContainLayout.setHorizontalGroup(
            desktopPaneContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        desktopPaneContainLayout.setVerticalGroup(
            desktopPaneContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu.png"))); // NOI18N
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuKaryawan.setBackground(new java.awt.Color(51, 51, 51));
        menuKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Briefcase.png"))); // NOI18N
        menuKaryawan.setText("Karyawan");
        menuKaryawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKaryawanActionPerformed(evt);
            }
        });
        jMenu1.add(menuKaryawan);

        menuKendaraan.setBackground(new java.awt.Color(51, 51, 51));
        menuKendaraan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Car.png"))); // NOI18N
        menuKendaraan.setText("Kendaraan");
        menuKendaraan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuKendaraan.setEnabled(false);
        menuKendaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKendaraanActionPerformed(evt);
            }
        });
        jMenu1.add(menuKendaraan);

        menuSchedule.setBackground(new java.awt.Color(51, 51, 51));
        menuSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Schedule.png"))); // NOI18N
        menuSchedule.setText("Schedule");
        menuSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuScheduleActionPerformed(evt);
            }
        });
        jMenu1.add(menuSchedule);

        menuDatabase.setBackground(new java.awt.Color(51, 51, 51));
        menuDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cloud Database.png"))); // NOI18N
        menuDatabase.setText("Database");
        menuDatabase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDatabaseActionPerformed(evt);
            }
        });
        jMenu1.add(menuDatabase);

        menuLogout.setBackground(new java.awt.Color(51, 51, 51));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shutdown.png"))); // NOI18N
        menuLogout.setText("Logout");
        menuLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPaneContain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPaneContain, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKaryawanActionPerformed
        if(appKaryawan.isClosed()) {
            appKaryawan = new KaryawanPage();
            desktopPaneContain.add(appKaryawan);
            appKaryawan.setVisible(true);
        } else if(!appKaryawan.isVisible()){
            appKaryawan.setVisible(true);
        }
    }//GEN-LAST:event_menuKaryawanActionPerformed

    private void menuKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuKendaraanActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDatabaseActionPerformed
        if(appDatabase.isClosed()) {
            appDatabase = new DatabasePage();
            desktopPaneContain.add(appDatabase);
            appDatabase.setVisible(true);
        } else if(!appDatabase.isVisible()){
            appDatabase.setVisible(true);
        }
    }//GEN-LAST:event_menuDatabaseActionPerformed

    private void menuScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuScheduleActionPerformed
        if(appSchedule.isClosed()) {
            appSchedule = new SchedulePage();
            desktopPaneContain.add(appSchedule);
            appSchedule.setVisible(true);
        } else if(!appSchedule.isVisible()){
            appSchedule.setVisible(true);
        }
    }//GEN-LAST:event_menuScheduleActionPerformed

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
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPaneContain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuDatabase;
    private javax.swing.JMenuItem menuKaryawan;
    private javax.swing.JMenuItem menuKendaraan;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuSchedule;
    // End of variables declaration//GEN-END:variables
}
