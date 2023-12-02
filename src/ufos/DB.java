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
    private File f;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    private String prefixID;
    private static final AtomicInteger count = new AtomicInteger(0);

    
    public DB(String type){
        setFilePath(type);
        createDirectory();
        CreateFile();
    }
    
    private void setFilePath(String type){
                
        String directoryPath = "";
        if (type.equals("Admin")) {
            directoryPath = "DB\\Account\\";
            prefixID = "A";
        } else if (type.equals("Customer")) {
            directoryPath = "DB\\Account\\";
            prefixID = "C";
        } else if (type.equals("Vendor")) {
            directoryPath = "DB\\Account\\";
            prefixID = "V";
        } else if (type.equals("Runner")) {
            directoryPath = "DB\\Account\\";
            prefixID = "R";
        } else if (type.equals("Menu")) {
            directoryPath = "DB\\Service\\";
            prefixID = "F";
        } else if (type.equals("Order")) {
            directoryPath = "DB\\Service\\";
            prefixID = "O";
        } else if (type.equals("Payment")) {
            directoryPath = "DB\\Service\\";
            prefixID = "P";
        }else if(type.equals("Transaction")){
            directoryPath = "DB\\Service\\";
            prefixID = "T";
        }
        f = new File(directoryPath + type + ".txt");
    }            
    private void createDirectory() {
        try {
            Path path = Paths.get(f.getParent());
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating directory");
            e.printStackTrace();
        }
    }
    
    private void CreateFile(){
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(f, true));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error creating file");
            e.printStackTrace();
        }
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
   
    public static String generateID(String prefix) {
       return prefix + String.format("%03d", count.incrementAndGet());
    }
}
