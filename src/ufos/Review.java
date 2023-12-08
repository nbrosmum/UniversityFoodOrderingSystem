/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;

/**
 *
 * @author User
 */
public class Review {
    DB db = new DB("FoodReview");
    DB Rdb  = new DB("DeliveryReview");
 
   public void Foodview(String OrderID,String vendorID,String date,String Rate,String Review) throws IOException{
       db.writeFile();
       db.bw.write(db.id + "," + OrderID + "," + vendorID + "," + date + "," + Rate + "," + Review);
       db.bw.newLine();
       db.closeResources();
   } 

   public void Runnerview(String OrderID,String RunnerID ,String date ,String Rate,String Review) throws IOException{
       Rdb.writeFile();
       Rdb.bw.write(Rdb.id + "," + OrderID + "," + RunnerID + ","+ date+ "," + Rate + "," + Review);
       Rdb.bw.newLine();
       Rdb.closeResources();
   } 
}
