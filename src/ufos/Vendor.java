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


