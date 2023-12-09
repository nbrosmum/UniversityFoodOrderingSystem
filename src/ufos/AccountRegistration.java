/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Walter
 */
public class AccountRegistration extends javax.swing.JFrame {
    GUI ui = new GUI();
    User u = new User();
    DB adminDB = new DB ("Admin");
    DB vendorDB = new DB ("Vendor");
    DB runnerDB = new DB ("Runner");
    DB customerDB = new DB ("Customer");
    private DefaultTableModel adminTableModel;
    private DefaultTableModel vendorTableModel;
    private DefaultTableModel runnerTableModel;
    private DefaultTableModel customerTableModel;
    /**
     * Creates new form Account_Registration
     */
    public AccountRegistration() {
        initComponents();      

       }
    public AccountRegistration(User u) {
        initComponents();      
        adminTableModel = (DefaultTableModel) t_admin.getModel();
        vendorTableModel = (DefaultTableModel) t_vendor.getModel();
        runnerTableModel = (DefaultTableModel) t_runner.getModel();
        customerTableModel = (DefaultTableModel) t_customer.getModel();

        adminDB.loadData(adminTableModel, this::mapRow);
        vendorDB.loadData(vendorTableModel, this::mapRow);
        runnerDB.loadData(runnerTableModel, this::mapRow);
        customerDB.loadData(customerTableModel, this::mapRow);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(java.awt.event.ActionEvent evt) {
           String selectedUserType = (String) jComboBox1.getSelectedItem();
           handleTableMouseClicked(selectedUserType);
       }
   });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_usr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_paswd = new javax.swing.JTextField();
        tf_mail = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tf_pNumber = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        tp_user = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_customer = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_vendor = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_runner = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_admin = new javax.swing.JTable();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Account Registration");

        jLabel2.setText("Username:");

        tf_usr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usrActionPerformed(evt);
            }
        });

        jLabel3.setText("Password:");

        jLabel4.setText("Email:");

        tf_paswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_paswdActionPerformed(evt);
            }
        });

        tf_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_mailActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Vendor", "Runner", "Admin" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Phone Number:");

        tf_pNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pNumberActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        tp_user.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tp_userComponentAdded(evt);
            }
        });

        t_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Email", "Phone Number"
            }
        ));
        t_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_customer);

        tp_user.addTab("Customer", jScrollPane1);

        t_vendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Email", "Phone Number", "Store Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_vendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_vendorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(t_vendor);
        if (t_vendor.getColumnModel().getColumnCount() > 0) {
            t_vendor.getColumnModel().getColumn(0).setResizable(false);
            t_vendor.getColumnModel().getColumn(1).setResizable(false);
            t_vendor.getColumnModel().getColumn(2).setResizable(false);
            t_vendor.getColumnModel().getColumn(3).setResizable(false);
            t_vendor.getColumnModel().getColumn(4).setResizable(false);
        }

        tp_user.addTab("Vendor", jScrollPane3);

        t_runner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Email", "Phone Number"
            }
        ));
        t_runner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_runnerMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(t_runner);

        tp_user.addTab("Runner", jScrollPane4);

        t_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Email", "Phone Number"
            }
        ));
        t_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_adminMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(t_admin);

        tp_user.addTab("Admin", jScrollPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tp_user, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(tf_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_pNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(tf_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(tf_paswd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_usr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_paswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_add)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_pNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_update)
                        .addGap(27, 27, 27)
                        .addComponent(btn_delete)))
                .addGap(30, 30, 30)
                .addComponent(btn_clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addGap(12, 12, 12))
                    .addComponent(tp_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private Object[] mapRow(String line) {
    // Exclude the first column (ID) from the mapping
        String[] columns = line.split(",");
        return Arrays.copyOfRange(columns, 1, columns.length);
    }
    private JTable getSelectedTable(String userType) {
        switch (userType) {
            case "Admin":
                return t_admin;
            case "Vendor":
                return t_vendor;
            case "Runner":
                return t_runner;
            case "Customer":
                return t_customer;
            default:
                return null;
        }
    }
    private int getSelectedRow(String userType) {
        JTable selectedTable = getSelectedTable(userType);
        return selectedTable.getSelectedRow();
    }
    


    private DefaultTableModel getTableModel(String userType) {
        switch (userType) {
            case "Admin":
                return adminTableModel;
            case "Vendor":
                return vendorTableModel;
            case "Runner":
                return runnerTableModel;
            case "Customer":
                return customerTableModel;
            default:
                return null;
        }
    }
    
    private DB getDB(String userType) {
        switch (userType) {
            case "Admin":
                return adminDB;
            case "Vendor":
                return vendorDB;
            case "Runner":
                return runnerDB;
            case "Customer":
                return customerDB;
            default:
                return null;
        }
    }
    private void clearFields() {
        tf_usr.setText("");
        tf_paswd.setText("");
        tf_mail.setText("");
        tf_pNumber.setText("");
    }
    private void handleTableMouseClicked(String userType) {
        int selectedRow = getSelectedRow(userType);

        if (selectedRow != -1) {
            // Set text fields with values from the selected row
            tf_usr.setText(getTableModel(userType).getValueAt(selectedRow, 0).toString());
            tf_paswd.setText(getTableModel(userType).getValueAt(selectedRow, 1).toString());
            tf_mail.setText(getTableModel(userType).getValueAt(selectedRow, 2).toString());
            tf_pNumber.setText(getTableModel(userType).getValueAt(selectedRow, 3).toString());
        }
    }
    private void tf_usrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usrActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String username = tf_usr.getText();
        String password = tf_paswd.getText();
        String email = tf_mail.getText();
        String phoneNumber = tf_pNumber.getText();
        String role = (String) jComboBox1.getSelectedItem();
        try {
            if (getDB(role).emailExists(email)) {
                JOptionPane.showMessageDialog(null, "Email already exists");
            }else if(username.equals("")&& password.equals("") && email.equals("") && phoneNumber.equals("")){
                JOptionPane.showMessageDialog(null, "please fill in the detail");
            }else{
                if(role.equals("Customer")){
                    Customer c = new Customer(username,password,email,phoneNumber);
                    c.register();
                }else if(role.equals("Admin")){
                    Admin a = new Admin(username,password,email,phoneNumber);
                    a.register();
                }else if(role.equals("Vendor")){
                   Vendor v = new Vendor(username,password,email,phoneNumber);
                   v.register();
                }else if(role.equals("Runner")){
                    Runner r = new Runner(username,password,email,phoneNumber);
                    r.register();
                }
                
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error registering user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        String role = (String) jComboBox1.getSelectedItem();
        String username = tf_usr.getText();
        String password = tf_paswd.getText();
        String email = tf_mail.getText();
        String phoneNumber = tf_pNumber.getText();
        DB db = getDB(role);
        List<String> data = db.readFile();
           String id = "";
           String temp = "";
           for (String line : data) {
               String[] parts = line.split(",");
               if (parts[1].equals(username) && parts[2].equals(password) && parts[3].equals(email)&& parts[4].equals(phoneNumber)) {
                   temp = line;
                   id = parts[0];
               }
           }
           // delete the row
           data.remove(temp);
           u.update(id,username, password, email, phoneNumber, role);

            DefaultTableModel tableModel = getTableModel(role);
            tableModel.setRowCount(0);

            db.loadData(tableModel, this::mapRow);

            tableModel.fireTableDataChanged();

    }//GEN-LAST:event_btn_updateActionPerformed

    private void tf_paswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_paswdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_paswdActionPerformed

    private void tf_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_mailActionPerformed

    private void tf_pNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_pNumberActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       String role = (String) jComboBox1.getSelectedItem();
       String username = tf_usr.getText();
        try {
            deleteUser(role, username);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error deleting user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();

    }//GEN-LAST:event_btn_deleteActionPerformed
    private void deleteUser(String role, String username) throws IOException {
        DB db = getDB(role);
        List<String> data = db.readFile();
        String id = "";
        String temp = "";
        for (String line : data) {
            String[] parts = line.split(",");
            if (parts[1].equals(username)) {
                temp = line;
                id = parts[0];
            }
        }
        // delete the row
        data.remove(temp);
        db.writeFile(data);
        u.delete(id, role);
    }
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        ui.callPage("AdminDashboard",u);
        this.dispose();
        
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        tf_usr.setText("");
        tf_paswd.setText("");
        tf_mail.setText("");
        tf_pNumber.setText("");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tp_userComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tp_userComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tp_userComponentAdded

    private void t_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_customerMouseClicked
       handleTableMouseClicked("Customer");
       jComboBox1.setSelectedItem("Customer");
    }//GEN-LAST:event_t_customerMouseClicked

    private void t_vendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_vendorMouseClicked
      handleTableMouseClicked("Vendor"); 
      jComboBox1.setSelectedItem("Vendor");
    }//GEN-LAST:event_t_vendorMouseClicked

    private void t_runnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_runnerMouseClicked
       handleTableMouseClicked("Runner"); 
       jComboBox1.setSelectedItem("Runner");
    }//GEN-LAST:event_t_runnerMouseClicked

    private void t_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_adminMouseClicked
       handleTableMouseClicked("Admin"); 
       jComboBox1.setSelectedItem("Admin");
    }//GEN-LAST:event_t_adminMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable t_admin;
    private javax.swing.JTable t_customer;
    private javax.swing.JTable t_runner;
    private javax.swing.JTable t_vendor;
    private javax.swing.JTextField tf_mail;
    private javax.swing.JTextField tf_pNumber;
    private javax.swing.JTextField tf_paswd;
    private javax.swing.JTextField tf_usr;
    private javax.swing.JTabbedPane tp_user;
    // End of variables declaration//GEN-END:variables
}
