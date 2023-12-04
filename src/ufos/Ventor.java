/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author leech
 */
public class Ventor {
    DB db = new DB("Menu");
    
    
    public void add (String foodName, double price, String description){
        db.writeFile();
        String priceString = String.valueOf(price);
        String FoodItem = db.id + "," + foodName + "," +  priceString + "," + description;
        try {
            db.bw.write(FoodItem + "\n");
        } catch (IOException ex) {
            System.out.println("Something went wrong.");
        }
        db.closeResources();
    }
    
    public void delete (String foodName, double price, String description){
        
            List<String> data = db.readFile();
            String temp = "";
            String id = "";
            for (String line : data) {
                String[] parts = line.split(",");
                if (parts[1].equals(foodName) && parts[2].equals(Double.toString(price)) && parts[3].equals(description)) {
                    temp = line;
                    id = parts[0];

                }
            } 
            data.remove(temp);
            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
            } catch (IOException ex) {
                System.out.println("Something went wrong.");
            }
            db.closeResources();


    }

    
    

      
}
