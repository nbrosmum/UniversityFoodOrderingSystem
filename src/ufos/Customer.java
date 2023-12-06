/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;
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
    public void OrderFood(String orderID, String foodID, String foodName, int portion, double price, String status, String date, double totalPrice, String deliveryMethod ) throws IOException{
        db.writeFile();
        String quantity = String.valueOf(portion);
        String priceString = String.valueOf(price);
        String TotalPriceString = String.valueOf(totalPrice);
        String orderDetails = orderID + "," + foodID+ "," + foodName+ "," + quantity+ "," + priceString+ "," + date+ "," + TotalPriceString+ "," + deliveryMethod+ "," + this.customerID;//vendorID
        db.bw.write(orderDetails);
        db.bw.newLine();
        db.closeResources();
    }
  
}
