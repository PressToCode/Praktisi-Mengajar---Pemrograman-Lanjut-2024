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
public class QueueList {
    public static void main(String[] args) {
        Queue<String> names = new ArrayDeque<>();
        
        names.offer("Olfat");
        names.offer("Wedanta");
        
        for(String next = names.poll(); next != null; next = names.poll()) {
            System.out.println(next);
        }
        
        System.out.println(names.size());
    }
}
