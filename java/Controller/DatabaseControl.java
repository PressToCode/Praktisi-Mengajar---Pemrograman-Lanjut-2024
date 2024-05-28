/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mycompany.tourandtravel.DatabasePage;
import com.mycompany.tourandtravel.HalamanUtama;
import static com.mycompany.tourandtravel.HalamanUtama.isConnected;
import com.mycompany.tourandtravel.KaryawanPage;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author PREDATOR
 */
public class DatabaseControl {
    private static Timer timer = new Timer();
    
    public boolean connectDatabase(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url, username, password).close();
            HalamanUtama.infoDatabase(url, username, password);
            return true;
        } catch(ClassNotFoundException | SQLException e) {}
        HalamanUtama.infoDatabase("", "", "");
        HalamanUtama.isConnected = false;
        return false;
    }
    
    public static void cekSqlTimer() {
        try {
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(!isConnected) {
                    DatabasePage.statusLabel.setText("Disconnected");
                    DatabasePage.statusLabel.setForeground(Color.red);
                    this.cancel();
                }
                }
            }, 10*1000, 10*1000); // Cek status SQL setiap 10 detik
        } catch(IllegalStateException e) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(!isConnected) {
                    DatabasePage.statusLabel.setText("Disconnected");
                    DatabasePage.statusLabel.setForeground(Color.red);
                    this.cancel();
                }
                }
            }, 5*1000, 5*1000); // Cek status SQL setiap 5 detik
        }
        
    }
}
