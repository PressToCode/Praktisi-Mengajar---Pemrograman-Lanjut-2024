/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mycompany.tourandtravel.HalamanUtama;
import static com.mycompany.tourandtravel.HalamanUtama.isConnected;
import com.mycompany.tourandtravel.KaryawanPage;
import static com.mycompany.tourandtravel.KaryawanPage.karyawanTable;
import static com.mycompany.tourandtravel.KaryawanPage.model;
import static com.mycompany.tourandtravel.KaryawanPage.loadDbButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author PREDATOR
 */
public class KaryawanControl {
    private static Timer timer = new Timer();
    private int row;
    private int column;
    
    public void cekSqlTimer() {
        try {
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(isConnected) {
                    KaryawanPage.saveToDatabase.setEnabled(true);
                    loadDbButton.setEnabled(true);
                } else {
                    KaryawanPage.saveToDatabase.setEnabled(false);
                    loadDbButton.setEnabled(false);
                    KaryawanPage.saveChoice = false;
                    KaryawanPage.saveToFile.setSelected(true);
                    this.cancel();
                }
                }
            }, 10*1000, 10*1000); // Cek status SQL setiap 10 detik
        } catch(IllegalStateException e) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(isConnected) {
                    KaryawanPage.saveToDatabase.setEnabled(true);
                    loadDbButton.setEnabled(true);
                } else {
                    KaryawanPage.saveToDatabase.setEnabled(false);
                    loadDbButton.setEnabled(false);
                    KaryawanPage.saveChoice = false;
                    KaryawanPage.saveToFile.setSelected(true);
                    this.cancel();
                }
                }
            }, 5*1000, 5*1000); // Cek status SQL setiap 5 detik
        }
    }
    
    public boolean checkField(String nama, String alamat, String telfon, String kelamin, String kategori, String status) {
        try {
           if   (
                    telfon == null
                    || alamat == null
                    || nama == null
                    || nama.isBlank()
                    || alamat.isBlank()
                    || telfon.isBlank()
                    || kelamin.isBlank()
                    || kategori.isBlank()
                    || status.isBlank()
                ) {
               return false;
           } else {
               return true;
           }
        } catch(NullPointerException e) {
            return false;
        }
    }
    
    public void saveToDatabase() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Perintah delete table + insert new data to table (overwrite), lanjutkan?", "Overwrite save", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection koneksi = DriverManager.getConnection(HalamanUtama.url, HalamanUtama.username, HalamanUtama.password);
                PreparedStatement deleteTable = koneksi.prepareStatement("delete from karyawan");
                deleteTable.executeUpdate();
                deleteTable.close();
                PreparedStatement perintah = koneksi.prepareStatement("insert into karyawan value (?, ?, ?, ?, ?, ?)");            
                int count = 1;
                row = karyawanTable.getRowCount();
                column = karyawanTable.getColumnCount();
                for (int j = 0; j  < row; j++) {
                    for (int i = 0; i  < column; i++) {
                        switch(count) {
                            case 7:
                                perintah.executeUpdate();
                                count = 1;

                            default:
                                perintah.setString(count, String.valueOf(karyawanTable.getValueAt(j, i)));
                                count++;
                                break;
                        }
                    }
                }

                // Eksekusi Terakhir
                perintah.executeUpdate();
                perintah.close();
                koneksi.close();
                javax.swing.JOptionPane.showMessageDialog(null, "Berhasil input ke database");
            } catch (ClassNotFoundException | SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal menyimpan ke database" + e);
            }
        }   
    }
    
    public void loadDatabase() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "reset modal table + select from table (overwrite), lanjutkan?", "Overwrite table", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection koneksi = DriverManager.getConnection(HalamanUtama.url, HalamanUtama.username, HalamanUtama.password);
                model.setRowCount(0);
                PreparedStatement perintah = koneksi.prepareStatement("select * from karyawan");
                ResultSet hasil = perintah.executeQuery();
                while(hasil.next()) {
                    String[] kirim = {hasil.getString(1), hasil.getString(2), hasil.getString(3), hasil.getString(4), hasil.getString(5), hasil.getString(6)};
                    model.addRow(kirim);
                }

                // Eksekusi Terakhir
                hasil.close();
                perintah.close();
                koneksi.close();
                javax.swing.JOptionPane.showMessageDialog(null, "Berhasil load dari database");
            } catch (ClassNotFoundException | SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal load dari database");
            }
        }
    }
    
//    public void deleteFromDatabase(int rowSelected) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection koneksi = DriverManager.getConnection(HalamanUtama.url, HalamanUtama.username, HalamanUtama.password);
//            PreparedStatement perintah = koneksi.prepareStatement("delete from karyawan where nama = ?");            
//            perintah.setString(1, String.valueOf(karyawanTable.getValueAt(rowSelected, 0)));
//            
//            // Eksekusi Terakhir
//            perintah.executeUpdate();
//            perintah.close();
//            koneksi.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal menghapus di database");
//        }
//    }
    
    File tableFile = new File("tableSave.txt");
    public void saveToFile() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Ini akan menimpa save yang ada! lanjutkan?", "Overwrite save", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            if(!tableFile.exists()) {
                try {
                    tableFile.createNewFile();
                } catch (IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal membuat file save");
                }
            }
            
            try {
                PrintWriter writer = new PrintWriter(tableFile);
                row = karyawanTable.getRowCount();
                column = karyawanTable.getColumnCount();
                int count = 1;
                for (int j = 0; j  < row; j++) {
                    for (int i = 0; i  < column; i++) {
                        switch(count) {
                            case 7:
                                writer.println();
                                count = 1;

                            default:
                                writer.append(String.valueOf(karyawanTable.getValueAt(j, i)));
                                writer.append(",");
                                writer.flush();
                                count++;
                                break;
                        }
                    }
                }
                writer.close();
            } catch (FileNotFoundException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal menyimpan");
            }
        }
    }
    
    public void loadFile() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Ini akan menimpa save yang ada! lanjutkan?", "Overwrite save", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            if(tableFile.exists()) {
                try {
                    model.setRowCount(0);
                    FileReader reader = new FileReader(tableFile);
                    BufferedReader read = new BufferedReader(reader);
                    String x = read.readLine();
                    while(x != null) {
                        String[] Splitter = x.split(",");
                        model.addRow(Splitter);
                        x = read.readLine();
                    }
                    read.close();
                    reader.close();
                } catch(IOException e) { 
                    javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal load");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: File save tidak ditemukan");
            }
        }
    }
}
