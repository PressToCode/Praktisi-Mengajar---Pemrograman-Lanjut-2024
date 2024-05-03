/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pertemuankedua;

import java.util.List;
import java.util.Iterator;

/**
 *
 * @author PREDATOR
 */
public class IterableList {

    public static void main(String[] args) {
        Iterable<String> names = List.of("Olfat", "Faiz");
        
        // Iterator untuk versi dibawah Java 5
        Iterator<String> iterator = names.iterator();
        
        // Untuk Java 5 Keatas
        for(var name: names) {
            System.out.println(name);
        }
        
        // Untuk Java dibawah versi Java 5
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
