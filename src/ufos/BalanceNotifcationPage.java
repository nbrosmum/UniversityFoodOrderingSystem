/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter
 */
public class BalanceNotifcationPage extends javax.swing.JFrame {
    
    GUI ui = new GUI();
    User u = new User();
    DB customerDB = new DB("Customer");
    DB balanceNotificationDB = new DB("BalanceNotification");
   
    DB.BalanceNotificationRowMapper mapper = balanceNotificationDB.new BalanceNotificationRowMapper();
    /**
     * Creates new form BalanceNotifcationPage
     */
    public BalanceNotifcationPage() {
        initComponents();
        loadBalanceNotificationData();
    }
    
     public BalanceNotifcationPage(User u) {
        initComponents();     
        this.u = u;
        loadBalanceNotificationData();
        
           
    }
     
    public void loadBalanceNotificationData() {     
      DefaultTableModel model  = (DefaultTableModel)t_bNotification.getModel();
      List<Object[]> rows = balanceNotificationDB.readData(mapper);
      model.setRowCount(0);
      for(Object[] rowData : rows){
         String CustomerID =(String) rowData[0];
         String Name =(String) rowData[1];
         String balance=(String) rowData[2]; 
         String Status =(String) rowData[3]; 
         model.addRow(new Object[]{CustomerID,Name,balance,Status});
      }
      balanceNotificationDB.closeResources();
      
    }
    
     private void updateBalanceNotification(String customerId, String status ) {
        // Read all customer data
        try {
            // Read all customer data
            List<String> BNotificationLines = balanceNotificationDB.readFile();
            List<String> updatedBNotificationData = new ArrayList<>();

            for (String line : BNotificationLines) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[0].trim().equals(customerId.trim())) {
                    // Update the status
                    parts[4] = status;
                }
                updatedBNotificationData.add(String.join(",", parts));
            }

            // Write the updated data back to the balance notification file
            balanceNotificationDB.writeFile(updatedBNotificationData);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating balance notification data");
        } finally {
            balanceNotificationDB.closeResources();
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_bNotification = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_done = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Balance Notification");

        t_bNotification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "TopUpAmount", "Status"
            }
        ));
        t_bNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_bNotificationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_bNotification);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_done.setText("Done");
        btn_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_done)
                        .addGap(186, 186, 186)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_done))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
         this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doneActionPerformed
      int selectedRow = t_bNotification.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) t_bNotification.getModel();
            model.setValueAt("Completed", selectedRow, 3); // Assuming the status column is at index 3

            String customerId = (String) model.getValueAt(selectedRow, 0);

            // Update the status to "Completed" in the BalanceNotification.txt file
            updateBalanceNotification(customerId, "Completed");
        }
    }//GEN-LAST:event_btn_doneActionPerformed

    private void t_bNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_bNotificationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bNotificationMouseClicked

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
            java.util.logging.Logger.getLogger(BalanceNotifcationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BalanceNotifcationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BalanceNotifcationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BalanceNotifcationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BalanceNotifcationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_bNotification;
    // End of variables declaration//GEN-END:variables
}
