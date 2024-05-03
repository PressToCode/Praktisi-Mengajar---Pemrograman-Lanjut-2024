/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pertemuankedua;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author PREDATOR
 */
public class TugasRumahSakit {
   public static void main(String[] args)  {
       // FIFO
       Queue<String> namaPasien = new ArrayDeque<>();
       
       // Input Nama Pasien
       namaPasien.offer("Olfat Faiz");
       namaPasien.offer("Wedanta");
       namaPasien.offer("Andrean");
       
       // Output Nama Pasien
       System.out.println("Nama Pasien yang terdaftar:");
       int i = 1;
       for(String next = namaPasien.poll(); next != null; next = namaPasien.poll()) {
           System.out.print(i + ") "); 
           System.out.println(next);
           i++;
       }
   }
}
