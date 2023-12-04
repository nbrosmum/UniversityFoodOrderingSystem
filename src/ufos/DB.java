/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;
import java.io.*;
import javax.swing.*;
import java.nio.file.*;
import java.util.*;

public class DB {
    private File f;
    public BufferedWriter bw;
    public BufferedReader br;
    private String prefixID;
    public String id;
    
    public DB(String type){
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
        createDirectory();
        try{
           if(!f.exists()){
             f.createNewFile();   
           }
        }catch(IOException e){
            e.printStackTrace();
        }  
        
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
    
    public void overWriteFile(){
        try{
            bw = new BufferedWriter(new FileWriter(f));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error OverWrite file");
            e.printStackTrace();
        }
    
    }
    public void writeFile(){
        try{
            getID(generateId());
            bw = new BufferedWriter(new FileWriter(f,true));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Write file");
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> readFile() {
        ArrayList<String> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file");
            e.printStackTrace();
            
        }
        
        return data;
    }
    
    public int readLastId() {
        try {
            br = new BufferedReader(new FileReader(f));
            String line;
            List<String> ids = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String idStr = line.split(",")[0];
                ids.add(idStr.substring(1));
            }
            br.close();
            Collections.sort(ids);
            if (!ids.isEmpty()) {
                return Integer.parseInt(ids.get(ids.size() - 1));
            } else {
                return 0;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        return 0;
    }
   
    public String generateId() {
        int newId = readLastId() + 1;
        String id = String.format("%s%03d", prefixID, newId);
        return id;
    }
   
    public void getID(String id){
        this.id = id;
    }
    
    public void closeResources() {
       try {
           if (bw != null) bw.close();
       } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"error!");
           e.printStackTrace();
       }
    }

}
