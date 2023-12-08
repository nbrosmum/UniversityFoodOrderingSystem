/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
  
    public User(){
        
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
    
    public void createUser(DB db) throws IOException {
       try {
            setId(db.generateId());
            
            if (db.emailExists(getEmail())) {
                JOptionPane.showMessageDialog(null, "Email already exists");
                return;
            }

            if (db.bw == null) {
                db.writeFile();
            }
        
            // Open the BufferedWriter here
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(db.f, true))) {
                String userData = String.format("%s,%s,%s,%s,%s",
                        getId(), getUsername(), getPassword(), getEmail(), getPhoneNumber());
                writer.write(userData);
                writer.newLine();
            } // The writer will be closed automatically here

        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace(); // You might want to log the exception or show a user-friendly message
        } finally {
            db.closeResources();
        }
    }
        

    public void updateUser(DB db) throws IOException {
         try {
            ArrayList<String> data = db.readFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(db.f))) {
                for (String line : data) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(getId())) {
                        String updatedUserData = String.format("%s,%s,%s,%s,%s",
                                getId(), getUsername(), getPassword(), getEmail(), getPhoneNumber());
                        writer.write(updatedUserData);
                        writer.newLine();
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception - log or show a user-friendly message
        } finally {
            db.closeResources();
        }
    }

    public void deleteUser(DB db) throws IOException {
        try {
            if (getId() == null || getId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a user to delete.");
                return;
            }

            db.deleteUserById(getId());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception - log or show a user-friendly message
        } finally {
            db.closeResources();
        }
    }   
}
