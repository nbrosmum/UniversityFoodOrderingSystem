/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufos;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class GUI {
    public void OpenPage(JFrame frame) {
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void callPage(String pageName){
        // page name just same as the class name
        JFrame page = null;
    
        switch (pageName) {
            case "EWallet":
                page = new EWallet();
                break;
            case "CustomerFoodMenu":
                page = new CustomerFoodMenu();
                break;
            case "CustomerProfile":
                page = new CustomerProfile();
                break;
            case "CustomerProfilePage":
                page = new CustomerProfilePage();
                break;
            case "CustomerTransactionHistory":
                page = new CustomerTransactionHistory();
                break;
            case "CustomerOrderHistory":
                page = new CustomerOrderHistory();
                break;
            case "CustomerOrderStatus":
                page = new CustomerOrderStatus();
                break;
            case "CustomerFoodReview":
                page = new CustomerFoodReview();
                break;
            case "VendorOrderHistory":
                page = new VendorOrderHistory();
                break;
            case "VendorOrderPage":
                page = new VendorOrderPage();
                break;
            case "VendorFoodMenu":
                page = new VendorFoodMenu();
                break;
            case "AccountRegistration":
                page = new AccountRegistration();
                break;
            case "AdminDashboard":
                page = new AdminDashboard();
                break;
            case "RunnerFrame":
                page = new RunnerFrame();
                break;
            case "RunnerHistory":
                page = new RunnerHistory();
                break;
            default:
                throw new IllegalArgumentException("Invalid page: " + pageName);
        }

        if (page != null) {
            OpenPage(page);
        }
    }
}
