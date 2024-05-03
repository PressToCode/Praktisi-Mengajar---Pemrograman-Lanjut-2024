/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pertemuankedua;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author PREDATOR
 */
public class TugasRumahSakit {
   public static void main(String[] args)  {
       // FIFO
       Queue<String> namaPasien = new ArrayDeque<>();
       
       // Implementasi scanner untuk user-input
       Scanner input = new Scanner(System.in);
       while(true) {
           System.out.print("Input nama pasien: ");
           namaPasien.offer(input.nextLine());
           
           System.out.println();
           System.out.println("Berhenti input? (Y to stop)");
           if(input.nextLine().equalsIgnoreCase("Y")) {
               break;
           }
       }
       
       // Pasien yang datang setelahnya
       namaPasien.offer("Olfat Faiz");
       namaPasien.offer("Wedanta");
       namaPasien.offer("Andrean");
       
       // Output Nama Pasien
       System.out.println("Nama Pasien dalam antrian:");
       int i = 1;
       for(String next = namaPasien.poll(); next != null; next = namaPasien.poll()) {
           System.out.print(i + ") "); 
           System.out.println(next);
           i++;
       }
   }
}
