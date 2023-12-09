package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Vendor extends User{
    private String storeName;
    DB db = new DB("Menu");
        
    
    public Vendor(){
      
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

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
           
 }


