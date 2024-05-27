/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static com.mycompany.tourandtravel.SchedulePage.dataCollection;
import static com.mycompany.tourandtravel.SchedulePage.textField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;

/**
 *
 * @author PREDATOR
 * @param <T>
 */
public class ScheduleControl<T> {
    int count = 1;
    File ScheduleFile = new File("ScheduleSave.txt");
    
    public void saveToFile(Queue<T> data) {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Ini akan menimpa save yang ada! lanjutkan?", "Overwrite save", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            if(!ScheduleFile.exists()) {
                try {
                    ScheduleFile.createNewFile();
                } catch (IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal membuat file save");
                }

                try {
                    PrintWriter writer = new PrintWriter(ScheduleFile);                    
                    count = 1;                    
                    data.forEach((n) -> {
                        writer.append(count + ") " + n + "\n");
                        writer.flush();
                        count++;
                    });
                    writer.close();
                } catch (FileNotFoundException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error: Gagal menyimpan");
                }
            }
        }
    }
    
    public void loadFile() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Ganti jadwal yang tertera dengan file?", "Overwrite schedule", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            if(ScheduleFile.exists()) {
                try {                    
                    FileReader reader = new FileReader(ScheduleFile);
                    BufferedReader read = new BufferedReader(reader);
                    String x = read.readLine();
                    textField.setText(null);
                    dataCollection.removeAll(dataCollection);
                    while(x != null) {
                        textField.append(x + "\n");
                        dataCollection.add(x.substring(x.lastIndexOf(")")+2, x.length()));
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
