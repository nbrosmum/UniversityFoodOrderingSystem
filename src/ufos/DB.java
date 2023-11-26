/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;
import java.io.*;
import javax.swing.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DB {
    File f;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    String prefixID;
    private static final AtomicInteger count = new AtomicInteger(0);

    
    public DB(String type){
        closeResources();
        
         String directoryPath = "";
        if (type.equals("Admin")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Admin.txt");
            prefixID = "A";
        } else if (type.equals("Customer")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Customer.txt");
            prefixID = "C";
        } else if (type.equals("Vendor")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Vendor.txt");
            prefixID = "V";
        } else if (type.equals("Runner")) {
            directoryPath = "DB\\Account\\";
            f = new File(directoryPath + "Runner.txt");
            prefixID = "R";
        } else if (type.equals("Menu")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Menu.txt");
            prefixID = "F";
        } else if (type.equals("Order")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Order.txt");
            prefixID = "O";
        } else if (type.equals("Payment")) {
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Payment.txt");
            prefixID = "P";
        }else if(type.equals("Transaction")){
            directoryPath = "DB\\Service\\";
            f = new File(directoryPath + "Transaction.txt");
            prefixID = "T";
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
        try {
            if (!FilePath.exists()) {
                FilePath.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(f, true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating file");
            e.printStackTrace();
        }
    }
    
    public static String generateID(String prefix) {
       return prefix + String.format("%03d", count.incrementAndGet());
   }
    
    
    public void writeFile(List<String> contentList) {
        try {
            
            for (String content : contentList) {
                String id = generateID(prefixID);
                bw.write(id + "," + content + System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file");
            e.printStackTrace();
        }
    }
        
    public List<String> readFile() {
        List<String> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
        }
        return data;
    }
    
    public void closeResources() {
       try {
           if (bw != null) bw.close();
           if (fw != null) fw.close();
       } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"error!");
           e.printStackTrace();
       }
   }
 
}
