/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugaspraktisi.Latihan;

/**
 *
 * @author PREDATOR
 */
public class SemuaException {
    
    public static void main (String[] args) { 
        // ArithmeticException
        int a=5; 
        int b=0; 
        try{ 
            System.out.println(a/b); 
        } catch(ArithmeticException e){ 
            System.out.println("Terjadi Error: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch ArtihmeticException");
        }
        
        // ArrayIndexOutOfBoundsException
        try{
            int []arr = new int[1];
            System.out.println(arr[1]);
            System.out.println("Baris ini tidak pernah dieksekusi");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Terjadi eksepsi karena index melebihi kapasitas");
        } finally {
            System.out.println("\nAkhir dari try-catch ArrayIndexOutOfBoundsException");
        }
        
        
    } 
}
