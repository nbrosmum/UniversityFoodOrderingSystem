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
 
        public class OrderRowMapper implements DB.RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String orderId = parts[0];
            String foodId = parts[1];
            String foodName = parts[2];
            String portion = parts[3];
            String price = parts[4];            
            String status = parts[5];
            String dt = parts[6];
            String totalprice = parts[7];
            String DM = parts[8];
            String vendorId = parts[9];
            String customerId;
            String runnerId;
            if (parts.length > 10) {
                customerId = parts[10];
                runnerId = parts[11];
            } else {
                customerId = null; // or throw an exception
                runnerId = null;
            }

            return new Object[]{orderId,foodId,foodName,portion,price,status,dt,totalprice,DM,vendorId,customerId,runnerId};
        }
    }

    public class ReviewRowMapper implements DB.RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String foodReviewID  = parts[0];
            String orderId  = parts[1];
            String vendorId  = parts[2];
            String dt  = parts[3];
            String rating  = parts[4];            
            String comment  = parts[5];

            return new Object[]{foodReviewID,orderId,vendorId,dt,rating,comment};
        }
    }
    
    public class MenuRowMapper implements DB.RowMapper {      
        @Override
        public Object[] mapRow(String line) {
            String[] parts = line.split(",");
            String foodID  = parts[0];
            String foodName  = parts[1];
            String price  = parts[2];
            String description  = parts[3];
            String vendorId  = parts[4];            

            return new Object[]{foodID,foodName,price,description,vendorId};
        }
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


