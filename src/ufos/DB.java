/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;
import java.io.*;
import javax.swing.*;

public class DB {
    File f;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    
    public DB(String type){
        closeResources();
        if(type.equals("Admin")){
            f = new File ("DB\\Acount\\Admin.txt");
        }else if(type.equals("Customer")){
            f = new File ("DB\\Acount\\Customer.txt");
        }else if(type.equals("Vendor")){
            f = new File ("DB\\Acount\\Vendor.txt");
        }else if (type.equals("Runner")){
            f = new File ("DB\\Acount\\Runner.txt");
        }else if (type.equals("Menu")){
            f = new File("DB\\Acount\\Menu.txt");
        }else if (type.equals("Order")){
            f = new File ("DB\\Acount\\Order.txt");
        }else if (type.equals("Payment")){
            f = new File("DB\\Acount\\Transaction.txt");
        }
            CreateFile(f);      
    }
    
    private void CreateFile(File FilePath){
        try{
            fw = new FileWriter(FilePath,true);
            bw = new BufferedWriter(fw);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "error");
            e.printStackTrace();
        }
    }
    
    public void writeFile(){
        try{
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Invalid File !");
            e.printStackTrace();
        }
    }
    public void readFile(){
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Invalid File !");
            ex.printStackTrace();
        }
    }    
    
    public void closeResources() {
       try {
           if (bw != null) bw.close();
           if (fw != null) fw.close();
           if (br != null) br.close();
           if (fr != null) fr.close();
       } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"error!");
           e.printStackTrace();
       }
   }
    

    
}
