package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Vendor extends User{
    private String storeName;
    DB db = new DB("Menu");
    DB vdb = new DB("Vendor");
        
    public Vendor() {
       
    }
    public Vendor(String id,String username, String password, String email, String phoneNumber) {
        super(id,username, password, email, phoneNumber);
    }
    public Vendor( String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }

    public String getStoreName() {
        return storeName;
    }
    public String getStoreName(String VendorID) {
        // Read the food file
        ArrayList<String> Data = vdb.readFile();
        // Find the foodID for the given foodName
        for (String line : Data) {
            String[] parts = line.split(",");
            if (parts[0].equals(VendorID)) {
                return parts[5];     
            }
        }
        return null;  
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public void register() throws IOException{
        storeName = JOptionPane.showInputDialog("Enter Store Name:");
                if (storeName != null) {
                    setStoreName(storeName);
                }
        vdb.writeFile();
        vdb.bw.write(vdb.id + "," + this.getUsername()+ "," + this.getPassword()+ "," + this.getEmail() + "," + this.getPhoneNumber() + "," + this.getStoreName());
        vdb.bw.newLine();
        vdb.closeResources();
    }
           
 }


