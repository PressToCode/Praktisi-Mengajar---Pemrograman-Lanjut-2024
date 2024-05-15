/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugaspraktisi.Latihan;

/**
 *
 * @author PREDATOR
 */
public class Latihan1 {
    public static void main(String[] args) {
        try{
            int []arr = new int[1];
            System.out.println(arr[1]);
            System.out.println("Baris ini tidak pernah dieksekusi");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Terjadi eksepsi karena index melebihi kapasitas");
        }

        System.out.println("Setelah blok try-catch");
    }
}
