/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugaspraktisi;

import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class ExceptionHandlingTugasPraktisi {

    public static void main(String[] args) {
        // Pasien yang datang sejak awal
        Queue<String> namaPasien = new ArrayDeque<>();
        namaPasien.offer("Olfat Faiz");
        namaPasien.offer("Wedanta");
        namaPasien.offer("Andrean");
        
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
                    break run;
                default:
                    break;
            }
        }
    }
    
    static void menu() {
            System.out.println("---[ Menu ]---");
            System.out.println("1) Lihat Antrian");
            System.out.println("2) Tambah Antrian");
            System.out.println("3) Hapus Antrian");
            System.out.println("4) Hentikan Program");
    }
    
    static void print(String n) {
        System.out.println("- " + n);
    }
}
