package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Vendor extends User{
    private String vendorId;
    DB db = new DB("Menu");
   
    
     public Vendor(String username, String password, String email, String phoneNumber){
        super(username, password, email, phoneNumber);
        
     }
     
      

    
    
   
    
    public Vendor(){
      
    }
    
    
    public void add (String foodName, double price, String description){
//        db.writeFile();
//        String priceString = String.valueOf(price);
//        String FoodItem = db.id + "," + foodName + "," +  priceString + "," + description;
//        try {
//            db.bw.write(FoodItem + "\n");
//        } catch (IOException ex) {
//            System.out.println("Something went wrong.");
//        }
//        db.closeResources();
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

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
 
    
    
    
    
    

//    
//    public void createVendor(DB vendorDB) {
//        
//        user.createUser(vendorDB);
//
//        String vendorInfo = String.format("%s,%s,%s,%s,%s,%s",
//                vendorDB.id, getUsername(), getPassword(), getEmail(), getPhoneNumber(), getStoreName());
//        try {
//            vendorDB.writeFIle(); 
//            vendorDB.bw.write(vendorInfo + "\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            vendorDB.closeResources();
//        }
//    }
//    
     
 }


