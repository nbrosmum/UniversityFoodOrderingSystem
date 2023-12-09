/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class Transaction {
    
    private String transactionId;
    private Double balance;
    DB db = new DB ("Customer");
    
    

    
    public Transaction(String transactionId, Double balance){
        this.transactionId = transactionId;
        this.balance= balance;
    }
    
    public Transaction(){
        
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public void topUpCredit(String CustomerId, String CustomerName, Double topUpAmount) {
        ArrayList<String> customerData = db.readFile();
        List<String> updatedCustomerData = new ArrayList<>();

       for (String line : customerData) {
           String[] parts = line.split(",");
           if (parts.length >= 6 && parts[0].trim().equals(CustomerId.trim()) && parts[1].trim().equals(CustomerName.trim())) {
               // Update the balance
               double currentBalance = Double.parseDouble(parts[5].trim());
               double newBalance = currentBalance + topUpAmount;
               parts[5] = String.valueOf(newBalance);
           }
           updatedCustomerData.add(String.join(",", parts));
       }

       try {
           db.writeFile(updatedCustomerData);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           // Close resources if necessary
           db.closeResources();
       }
    }
    
    
    
    
   
}
