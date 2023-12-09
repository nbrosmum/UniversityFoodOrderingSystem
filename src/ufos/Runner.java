/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import java.io.IOException;



/**
 *
 * @author Walter
 */
public class Runner extends User {
    DB db = new DB("Runner");
    public Runner( String id,String username, String password, String email, String phoneNumber) {
        super(id,username, password, email, phoneNumber);
    }
    public Runner( String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }
    

    public void register() throws IOException{
        db.writeFile();
        db.bw.write(db.id + "," + this.getUsername()+ "," + this.getPassword()+ "," + this.getEmail() + "," + this.getPhoneNumber());
        db.bw.newLine();
        db.closeResources();
    }
//    public Runner(){
//        
//    }
//    
 
    
}
