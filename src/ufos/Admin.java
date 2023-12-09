/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;


/**
 *
 * @author Walter
 */
public class Admin extends User{
    
    
    
//    public Admin(){
//        
//    }
  
    public Admin(String id,String username, String password, String email, String phoneNumber) {
        super(id,username, password, email, phoneNumber);
    }
    public Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }
    
}
