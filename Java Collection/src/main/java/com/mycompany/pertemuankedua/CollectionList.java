/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pertemuankedua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author PREDATOR
 */
public class CollectionList {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("Olfat");
        names.add("Faiz");
        names.addAll(Arrays.asList("Wedanta", "Andreas"));
        
        names.remove("Wedanta");
        
        for(var name: names) {
            System.out.println(name);
        }
    }
}
