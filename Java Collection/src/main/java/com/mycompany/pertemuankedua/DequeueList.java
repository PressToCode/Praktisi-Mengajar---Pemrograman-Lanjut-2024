/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pertemuankedua;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author PREDATOR
 */
public class DequeueList {
    public static void main(String[] args) {
        Deque<String> names = new LinkedList<>();
        
        names.offerLast("Olfat");
        names.offerLast("Faiz");
        names.offerLast("Wedanta");
        
        for(String next = names.pollLast(); next != null; next = names.pollLast()) {
            System.out.println(next);
        }
    }
}
