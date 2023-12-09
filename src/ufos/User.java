/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Walter
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private List<User> users;
  
    public User(){
        
    }
    
    public User(String id,String username, String password, String email, String phoneNumber){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        
    }
    public User(String username, String password, String email, String phoneNumber){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber; 
    }
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public void register(String username, String password, String email, String phoneNumber, String role) throws IOException{
        User newUser;
        DB db;
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        switch (role) {
           case "Customer":
               newUser = new Customer(username, password, email, phoneNumber);
               db = new DB(role);
               break;
           case "Admin":
               newUser = new Admin( username, password, email, phoneNumber);
               db = new DB(role);
               break;
           case "Vendor":
               newUser = new Vendor(username, password, email, phoneNumber);
               db = new DB(role);
                String storeName = JOptionPane.showInputDialog("Enter Store Name:");
                if (storeName != null) {
                    ((Vendor) newUser).setStoreName(storeName);
                }
               break;
           case "Runner":
               newUser = new Runner(username, password, email, phoneNumber);
               db = new DB(role);
               break;
           default:
               throw new IllegalArgumentException("Invalid role");
       }
        this.users.add(newUser);
        double balance = 0.0;
        String balanceStr = String.valueOf(balance);
        
        db.writeFile();
        if(role.equals("Customer")){
           db.bw.write(db.id + "," + username + "," + password + "," + email + "," + phoneNumber + "," + balanceStr); 
           db.bw.newLine();
        }else if(role.equals("Vendor")){
            db.bw.write(db.id + "," + username + "," + password + "," + email + "," + phoneNumber + "," + ((Vendor) newUser).getStoreName());
            db.bw.newLine();
        }else{
           db.bw.write(db.id + "," + username + "," + password + "," + email + "," + phoneNumber);
           db.bw.newLine();
        }
        db.closeResources();
    }
    
    public boolean login(String Email, String Password,String role){
        DB db = new DB(role);
        ArrayList<String> data = db.readFile();
        for(String line : data){
            String[] value = line.split(",");
            if(value[3].equals(Email) && value[2].equals(Password)){
                this.id = value[0];
                System.out.println(id);
                this.username = value[1];
                this.email = value[3];
                return true;
            }
        }
        return false;
    }
    
    public void update(String id,String username, String password, String email, String phoneNumber, String role) {

        DB db = new DB(role);
        ArrayList<String> data = db.readFile();
        List<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] value = line.split(",");
            if (value.length >= 6 && value[0].trim().equals(id.trim())) {
                System.out.println("Updating line: " + line);
                if (role.equals("Customer") || role.equals("Vendor")) {
                    updatedData.add(id + "," + username + "," + password + "," + email + "," + phoneNumber + "," + value[5]);
                } else {
                    updatedData.add(id + "," + username + "," + password + "," + email + "," + phoneNumber);
                }
            } else {
                System.out.println("Line not updated: " + line);
                updatedData.add(line);
            }
        }

        try {
            db.writeFile(updatedData);
            db.closeResources();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
     }
    
    
    public void delete(String id, String role) throws IOException{
        DB db = new DB(role);
        ArrayList<String> data = db.readFile();
        List<String> updatedData = new ArrayList<>();
        for (String line : data) {
            String[] value = line.split(",");
            if (!value[0].equals(id)) {
                updatedData.add(line);
            }
        }
        db.writeFile(updatedData);
        db.closeResources();
        }
    
 }

