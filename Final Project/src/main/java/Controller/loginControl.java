/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mycompany.tourandtravel.LoginPage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class loginControl {    
    public loginControl() {
        loginInfo.put("admin", "123");
        loginInfo.put("olfat", "faiz");
        loginInfo.put("test", "test");
    }
    
    // User admin - Tanpa database atau cek save file
    Map<String, String> loginInfo = new HashMap<>();
    
    // Untuk database { localhost MySQL (10.4.32 MariaDB) menggunakan XAMPP v3.3.0 }
    private final String dbUrl = "jdbc:mysql://localhost:3306/tourtravel";
    private final String dbUsername = "root";
    private final String dbPassword = "";
    
    public boolean checkConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(dbUrl, dbUsername, dbPassword).close();
            return true;
        } catch(ClassNotFoundException | SQLException e) {}
        return false;
    }
    
    public boolean checkLogin(String user, char[] password) throws SQLException {
        if(loginInfo.containsKey(user)) {
            String seePass = loginInfo.get(user);
            if(seePass.equals(String.valueOf(password))) {
                return true;
            }
            return false;
        } else if(checkConnection()) {
            String typedPass = String.valueOf(password); // Security loopholes
            // Check Database { JDBC or Connector/J to MySQL adden in pom.xml }
            try {
                // Membuat koneksi
                Connection koneksi = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                
                // placeholder perintah
                Statement perintah = koneksi.createStatement();
                
                // Menjalankan query { Mengambil semua data dari tabel "user" }
                ResultSet hasilQuery = perintah.executeQuery("SELECT * FROM user where userName='" + user + "' and userPassword='" + typedPass + "'");
                
                // Cek apakah data yang diinput sesuai dengan isi database
                while(hasilQuery.next()) {
                    if(hasilQuery.getString("userName").equals(user) && hasilQuery.getString("userPassword").equals(typedPass)) {
                        return true;
                    }
                }
                        
                // Tutup koneksi
                hasilQuery.close();
                perintah.close();
                koneksi.close();
            } catch(SQLException e) {}
            
            return false; 
        } else {
            return false;
        }
    }
    
    // Fungsi Simpan Remember Me
    File rememberFile = new File("rememberMeLogin.txt");
    public boolean loginRemember(String username, String password) {
        if(!rememberFile.exists()) {
            try {
                rememberFile.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }

        try {
            PrintWriter writer = new PrintWriter(rememberFile);
            writer.println("Remember Me Login Credential: ");
            writer.println("- " + username);
            writer.println("- " + password);
            writer.close();
        } catch (FileNotFoundException ex) {
            return false;
        }
        
        return true;
    }
    
    // Fungsi Baca Remember Me
    public void readRemember() {
        if(rememberFile.exists()) {
            try {
                FileReader reader = new FileReader(rememberFile);
                BufferedReader read = new BufferedReader(reader);
                String x = read.readLine();
                int count = 1;
                while(x != null) {
                    if(x.contains("-")) {
                        if(count == 1) {
                            LoginPage.usernameField.setText(x.substring(2, x.length()));
                            count++;
                        } else if(count == 2) {
                            LoginPage.passwordField.setText(x.substring(2, x.length()));
                        }
                    }
                    x = read.readLine();
                }
                read.close();
                reader.close();
            } catch(IOException e) { }
            LoginPage.rememberMe.setSelected(true);
        }
    }
    
    // Cek koneksi secara berkala
    Timer timer = new Timer();
    public void cekSqlTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(checkConnection()) {
                    LoginPage.sqlStatusLabel.setText("Online");
                    LoginPage.sqlStatusLabel.setForeground(new java.awt.Color(51,255,51));
                } else {
                    LoginPage.sqlStatusLabel.setText("Offline");
                    LoginPage.sqlStatusLabel.setForeground(new java.awt.Color(255,0,0));
                }
            }
        }, 5*1000, 5*1000); // Cek status SQL setiap 5 detik
    }
    
    // Cek Username dan Password
    public boolean checkEntry() {
        if(LoginPage.usernameField.getText() != null && !LoginPage.usernameField.getText().isEmpty() && LoginPage.passwordField.getPassword() != null) {          
            try {
                // Fungsi Remember Me untuk login selanjutnya
                if(LoginPage.remember) {
                    if(!loginRemember(LoginPage.usernameField.getText(), new String(LoginPage.passwordField.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Error: 'Remember Me' function failed", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }

                if(checkLogin(LoginPage.usernameField.getText(), LoginPage.passwordField.getPassword())) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login gagal!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: Terjadi error dalam database!");
            }            
        } else {
            JOptionPane.showMessageDialog(null, "Login gagal!");
        }
        
        return false;
    }
}
