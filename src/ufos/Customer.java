/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author User
 */
public class Customer extends User {
   private String customerID;
   private String name;
   private String Email;
   private double credit;
   DB db = new DB("Order");
    public Customer( ) {
         
    }
    public Customer(String username, String password, String email) {
        super(username, password, email);   
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    public void OrderFood(String orderID, String foodID, String foodName, int portion, double price, String status, String date, double totalPrice, String deliveryMethod,String VendorID ) throws IOException{
        db.writeFile();
        String quantity = String.valueOf(portion);
        String priceString = String.valueOf(price);
        String TotalPriceString = String.valueOf(totalPrice);
        String orderDetails = orderID + "," + foodID+ "," + foodName+ "," + quantity+ "," + priceString + "," + status +"," + date + "," + TotalPriceString+ "," + deliveryMethod+ ","+ VendorID+ "," + this.customerID;//vendorID
        db.bw.write(orderDetails);
        db.bw.newLine();
        db.closeResources();
    }
    public void reorder(String orderId) {
        ArrayList<String> lines = db.readFile();
        String newOrderId = db.generateId();
        String Date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        for (String line : lines) {
            String[] parts = line.split(",");
            String currentOrderId = parts[0];
            if (currentOrderId.equals(orderId)) {
                String newLine = newOrderId + "," + parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5] + "," + Date + "," + parts[7] + "," + parts[8] + "," + parts[9] + "," + parts[10];
                try {
                    db.writeFile();
                    db.bw.write(newLine);
                    db.bw.newLine();
                    db.closeResources();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
  
}
