/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugaspraktisi.Latihan;

import java.io.File;

/**
 *
 * @author PREDATOR
 */
public class Latihan {
    public static void main(String[] args) {
        File file1 = new File("Contoh.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists()); // True jika file sudah dibuat sebelumnya
    }
}
