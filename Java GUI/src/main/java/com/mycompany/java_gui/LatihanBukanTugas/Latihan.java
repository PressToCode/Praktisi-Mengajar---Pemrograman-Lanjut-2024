/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_gui.LatihanBukanTugas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author PREDATOR
 */
public class Latihan {
    public static void main(String[] args) {
        // Membuat frame baru
        JFrame frame = new JFrame("Latihan menggunakan component java swing");
        
        // Membuat JPanel untuk menaruh komponen
        JPanel panel = new JPanel();
        frame.add(panel);

        // JButton
        JButton button = new JButton("Button");
        panel.add(button);

        // JLabel
        JLabel label = new JLabel("Label");
        panel.add(label);

        // JTextField
        JTextField textField = new JTextField("TextField");
        panel.add(textField);

        // JTextArea
        JTextArea textArea = new JTextArea("TextArea");
        panel.add(new JScrollPane(textArea));

        // JPasswordField
        JPasswordField passwordField = new JPasswordField("Password");
        panel.add(passwordField);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("CheckBox");
        panel.add(checkBox);

        // JRadioButton
        JRadioButton radioButton = new JRadioButton("RadioButton");
        panel.add(radioButton);          

        // Display the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Memastikan aplikasi tertutup saat mencet tombol keluar
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
}