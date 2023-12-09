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
    private double balance;
    private double newBalance;
    DB db = new DB ("Customer");
    DB tdb = new DB("Transaction");
    GUI ui = new GUI();
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
    
    public void WriteTransactionFile(String CustomerId, String CustomerName, double topUpAmount) throws IOException {
        Customer c = new Customer();
        tdb.writeFile();
        String Amount = String.valueOf(topUpAmount);
        double CusBalance = c.getBalance(CustomerId);
        String balancetp = String.valueOf(CusBalance);
        String Transaction = tdb.id + "," + CustomerId + "," + CustomerName + ", Top-Up : +" + Amount + "," +balancetp;
        tdb.bw.write(Transaction);
        tdb.bw.newLine();
        tdb.closeResources();
    }

    public void payment(String UserID, String OrderID,double TotalPrice,String DeliMethod ){
        Customer c = new Customer();
        double balance = c.getBalance(UserID);
        String pay = "";
        
        if(DeliMethod.equals("Delivery")){
            double deliveryFee = TotalPrice + 5.0;
            pay = "OrderID " + OrderID + "\nUserID: " + UserID + "\nTotal Price: " + deliveryFee + " ($5.00 Delivery Fee) " + "\nWallet Balance: " + (balance - deliveryFee);
            int choice = JOptionPane.showConfirmDialog(null, pay, "Confirm Payment", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
               logTransaction(UserID, OrderID, "Payment ", deliveryFee, (balance - deliveryFee)); 
               //c.updateBalance(UserID, balance - deliveryFee);
               JOptionPane.showMessageDialog(null, "Payment successful!\n" + pay);
            }else{
               JOptionPane.showMessageDialog(null, "Payment canceled.");
            }
        }else if(DeliMethod.equals("Take Away")){
            double contianerfee = TotalPrice + 2.0;
            pay = "OrderID " + OrderID + "\nUserID: " + UserID + "\nTotal Price: " + contianerfee +  "($2.00 Delivery Fee)" + "\nWallet Balance: " + (balance - contianerfee);
            int choice = JOptionPane.showConfirmDialog(null, pay, "Confirm Payment", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
               logTransaction(UserID, OrderID, "Payment ", contianerfee, (balance - contianerfee)); 
               //c.updateBalance(UserID, balance - contianerfee);
               JOptionPane.showMessageDialog(null, "Payment successful!\n" + pay);
            }else{
               JOptionPane.showMessageDialog(null, "Payment canceled.");
            }
        }else{
            pay = "OrderID " + OrderID + "\nUserID: " + UserID + "\nTotal Price: " + TotalPrice + "\nWallet Balance: " + (balance - TotalPrice);
            int choice = JOptionPane.showConfirmDialog(null, pay, "Confirm Payment", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
               logTransaction(UserID, OrderID, "Payment ", TotalPrice, (balance - TotalPrice )); 
               //c.updateBalance(UserID, balance - TotalPrice);
               JOptionPane.showMessageDialog(null, "Payment successful!\n" + pay);
            }else{
               JOptionPane.showMessageDialog(null, "Payment canceled.");
            }
        }
    }
    
    private void logTransaction(String userID, String orderID, String transactionType, double amount, double newBalance) {
        // Assuming tdb is an instance of a transaction database class
        try {
            tdb.writeFile();
            tdb.bw.write(tdb.id + "," + userID + "," + orderID + ", " + transactionType + ": -" + amount + "," + newBalance);
            tdb.bw.newLine();
            tdb.closeResources();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public double getBalancebyTransaction(String Userid) {
        ArrayList<String> Data = tdb.readFile();
        for (String line : Data) {
            String[] parts = line.split(",");
            if (parts[0].equals(Userid)) {
                balance = Double.parseDouble(parts[6]);
            }
        }
        return balance;

    }
         
}
