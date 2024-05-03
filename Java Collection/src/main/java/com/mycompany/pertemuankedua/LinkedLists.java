/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pertemuankedua;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PREDATOR
 */
public class LinkedLists {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        
        names.add("Olfat");
        names.add("Faiz");
        
        for(var name: names) {
            System.out.println(name);
        }
    }
}
