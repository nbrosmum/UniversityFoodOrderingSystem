/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;
import java.io.*;
import javax.swing.*;
import java.nio.file.*;

public class DB {
    File f;
    File folder;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    
    public DB(String type){
        closeResources();
        
                String directoryPath = "";
        if (type.equals("Admin")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Admin.txt");
        } else if (type.equals("Customer")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Customer.txt");
        } else if (type.equals("Vendor")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Vendor.txt");
        } else if (type.equals("Runner")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Runner.txt");
        } else if (type.equals("Menu")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Menu.txt");
        } else if (type.equals("Order")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Order.txt");
        } else if (type.equals("Payment")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Transaction.txt");
        }

        createDirectory(directoryPath);
        CreateFile(f);
    }
                 
    private void createDirectory(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating directory");
            e.printStackTrace();
        }
    }
    
    private void CreateFile(File FilePath){
        try{
                fw = new FileWriter(FilePath);
                bw = new BufferedWriter(fw);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "error");
            e.printStackTrace();
        }
    }
    
    public void writeFile(String Content){
        try{
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
            
            bw.write(Content);
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
