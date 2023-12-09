/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author User
 */
public class Customer extends User {

    private double balance;
    NotifDB nt = new NotifDB();

    DB db = new DB("Order");
    DB cdb = new DB("Customer");
    
    
    public Customer() {
    }

    public Customer( String id,String username, String password, String email,String phoneNumber) {
         super( id,username, password, email,phoneNumber);
     }
    public Customer( String username, String password, String email,String phoneNumber) {
         super( username, password, email,phoneNumber);
     }

    public double getBalance() {
        return balance;

    }
    public double getBalance(String Userid) {
        ArrayList<String> Data = cdb.readFile();
        for (String line : Data) {
            String[] parts = line.split(",");
            if (parts[0].equals(Userid)) {
                balance = Double.parseDouble(parts[5]);
            }
        }
        return balance;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void OrderFood(String orderID, String foodID, String foodName, int portion, double price, String status, String date, double totalPrice, String deliveryMethod,String VendorID,String CustomerID,String RunnerID ) throws IOException{
        db.writeFile();
        String quantity = String.valueOf(portion);
        String priceString = String.valueOf(price);
        String TotalPriceString = String.valueOf(totalPrice);
        String orderDetails = orderID + "," + foodID+ "," + foodName+ "," + quantity+ "," + priceString + "," + status +"," + date + "," + TotalPriceString+ "," + deliveryMethod+ ","+ VendorID+ "," + CustomerID + "," +RunnerID;//vendorID
        db.bw.write(orderDetails);
        db.bw.newLine();
        db.closeResources();

        nt.Customer(CustomerID);

    }
    public void reorder(String orderId) throws IOException {
        ArrayList<String> lines = db.readFile();
        String newOrderId = db.generateId();
        String Date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for (String line : lines) {
            String[] parts = line.split(",");
            String currentOrderId = parts[0];
            String CustomerID = parts[10];
            if (currentOrderId.equals(orderId)) {
                String newLine = newOrderId + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + Date + "," + parts[7] + "," + parts[8] + "," + parts[9] + "," + parts[10] + "," + parts[11];
                try {
                    db.writeFile();
                    db.bw.write(newLine);
                    db.bw.newLine();
                    db.closeResources();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Re-order Fail");
                    e.printStackTrace();
                }
            }
            nt.Customer(CustomerID);
        }
        
    }
    
    public void register() throws IOException{
        balance = 0.0;
        String balanceStr = String.valueOf(balance);
        cdb.writeFile();
        cdb.bw.write(cdb.id + "," + this.getUsername()+ "," + this.getPassword()+ "," + this.getEmail() + "," + this.getPhoneNumber() + "," + balanceStr);
        cdb.bw.newLine();
        cdb.closeResources();
    }
    
  

}
