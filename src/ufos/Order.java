package ufos;


import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Order {
     private List<String[]> items;
     private double price;
     private int quantity;

    public Order() {
       
    }

    public Order(List<String[]> items) {
        this.items = items;
    }
    
    
    public double calculateTotalPrice() {
      double total = 0;
      for(String[] item : items) {
          price = Double.parseDouble(item[2]); // Assume the price is at index 2
          quantity = Integer.parseInt(item[1]); // Assume the quantity is at index 1
          total += price * quantity;
      }
      return total;
    }   
}
