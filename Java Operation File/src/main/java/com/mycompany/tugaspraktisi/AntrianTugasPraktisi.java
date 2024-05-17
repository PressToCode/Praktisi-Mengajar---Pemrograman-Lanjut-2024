/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugaspraktisi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class AntrianTugasPraktisi {
    static int count = 0;

    public static void main(String[] args) {
        // Pasien yang datang sejak awal
        Queue<String> namaPasien = new ArrayDeque<>();
        namaPasien.offer("Olfat Faiz");
        namaPasien.offer("Wedanta");
        namaPasien.offer("Andrean");
        
        // saveFile Object
        File saveFile = new File("savedData.txt");
        
        // Menu
        Scanner input = new Scanner(System.in);
        run: while(true) {
            menu();
            
            int pilihan;
            while(true) {
                System.out.print("Pilihan = ");
                try {
                    pilihan = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Hanya menerima input angka 1-4. Ulangi!");
                }
            }
            
            switch(pilihan) {
                case 1:
                    // Output Nama Pasien
                    if(!namaPasien.isEmpty()) {
                        System.out.println();
                        System.out.println("Nama Pasien dalam antrian:");
                        count = 0;
                        namaPasien.forEach((n) -> print(n));
                        System.out.println();   
                    } else {
                        System.out.println("- Antrian kosong -");
                    }
                    
                    break;
                case 2:
                    // Implementasi scanner untuk user-input
                    menu2: while(true) {
                        System.out.print("Input nama pasien: ");
                        namaPasien.offer(input.nextLine());

                        System.out.println();
                        while(true) {
                            System.out.print("Berhenti input? (0 to stop): ");
                            try {
                                if(input.nextInt() == 0) {
                                    input.nextLine();
                                    break menu2;
                                }
                                input.nextLine();
                                break;
                            } catch(Exception e){
                                System.out.println("Hanya menerima input angka. Ulangi!");
                                input.nextLine();
                            }
                        }
                    }
                    break;
                case 3:
                    try {
                        namaPasien.remove();
                        System.out.println("Berhasil menghapus antrian");
                    } catch(NoSuchElementException e) {
                        System.out.println("List kosong, tidak bisa hapus");
                    }
                    break;
                case 4:
                    // Implementasi io.file
                    if(!saveFile.exists()) {
                        try {
                            saveFile.createNewFile();
                            System.out.println("\nNew save file created in " + saveFile.getAbsolutePath());
                        } catch (IOException e) {
                            System.out.println("Failed to create new save file");
                        }
                    }
                    
                    try {
                        PrintWriter writer = new PrintWriter(saveFile);
                        count = 0;
                        namaPasien.forEach((n) -> 
                        {
                            count++;
                            writer.println("\nNama Pasien dalam antrian:");
                            writer.println(count + ") " + n + " [" + new Date() + "]"); 
                            writer.flush();
                        });
                        System.out.println("Data berhasil disimpan");
                    } catch (FileNotFoundException ex) {
                        System.out.println("Gagal mengisi data, file tidak ditemukan");
                    }
                    break;
                case 5:
                    try {
                        FileReader reader = new FileReader(saveFile);
                        BufferedReader read = new BufferedReader(reader);
                        try {
                            String x = read.readLine();
                            while(x != null) {
                                System.out.println(x);
                                x = read.readLine();
                            }
                        } catch (IOException ex) {
                            System.out.println("Tidak bisa mengambil data dari file");
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("File save tidak ditemukan");
                    }
                    break;
                case 6:
                    break run;
                default:
                    System.out.print("Hanya menerima input angka 1-4. Ulangi!");
                    break;
            }
        }
    }
    
    static void menu() {
            System.out.println("\n---[ Menu ]---");
            System.out.println("1) Lihat Antrian");
            System.out.println("2) Tambah Antrian");
            System.out.println("3) Hapus Antrian");
            System.out.println("4) Simpan Data");
            System.out.println("5) Lihat Data");
            System.out.println("6) Hentikan Program");
    }
    
    static void print(String n) {
        count++;
        System.out.println(count + ") " + n);
    }
}
