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
            System.out.println("\nTerjadi eksepsi: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch ArtihmeticException");
        }
        
        // ArrayIndexOutOfBoundsException
        try{
            int []arr = new int[1];
            System.out.println(arr[1]);
            System.out.println("Baris ini tidak pernah dieksekusi");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nTerjadi eksepsi: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch ArrayIndexOutOfBoundsException");
        }
        
        // ClassNotFoundException
        try{
            Class.forName("Class1");
        } catch(ClassNotFoundException e){
            System.out.println("\nTerjadi eksepsi: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch ClassNotFoundException");
        }
        
        // NullPointerException
        try { 
            String A = null; //null
            System.out.println(A.charAt(0)); 
        } catch(NullPointerException e) { 
            System.out.println("\nTerjadi eksepsi: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch NullPointerException");
        }
        
        // StringIndexOutOfBoundsException
        try { 
            String B = "Hello";
            char c = B.charAt(25);
            System.out.println(c); 
        } 
        catch(StringIndexOutOfBoundsException e) { 
            System.out.println("\nTerjadi eksepsi: " + e);
        } finally {
            System.out.println("\nAkhir dari try-catch StringIndexOutOfBoundsException");
        }
    } 
}
