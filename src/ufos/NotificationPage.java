/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ufos;

import java.awt.CardLayout;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author leech
 */
public class NotificationPage extends javax.swing.JFrame {
    GUI ui = new GUI();
    User u = new User();    
    DB nt = new DB("Notification");
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Notification", "Status"};

    public NotificationPage() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        load();
    }

    public NotificationPage(User id) {
        initComponents();     
        u = id;
        model.setColumnIdentifiers(columnName);
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Notif = new javax.swing.JTable();
        Filter = new javax.swing.JComboBox<>();
        Read = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Notif.setModel(model);
        jScrollPane1.setViewportView(Notif);

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unread", "Read", "All"}));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        Read.setText("Read");
        Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Notification");

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Filter, 0, 125, Short.MAX_VALUE)
                            .addComponent(Read, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(116, 116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Read)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        //NotificationID | Notification Context | SenderID | ReceiverID | Status |
        String selectedOption = (String) Filter.getSelectedItem();
        model.setRowCount(0);

        String ID = u.getId();
        ArrayList<String> lines = nt.readFile();        
        model.setRowCount(0);
        for (String line : lines) {
            String[] parts = line.split(",");
            String Context = parts[1];
            String SendId = parts[2];
            String Receive = parts[3];
            String Status = parts[4];
       
            
            if (selectedOption.equals("Unread")){
                if (ID.equals(Receive) && Status.equals("Unread")){
                    model.addRow(new Object[]{Context,Status});
                }
            } else if (selectedOption.equals("Read")){
                if (ID.equals(Receive) && Status.equals("Read")){
                    model.addRow(new Object[]{Context,Status});
                }
            } else {
                if (ID.equals(Receive)) {
                    model.addRow(new Object[]{Context,Status});               
                }
            }           
        }
        nt.closeResources();
        
    }//GEN-LAST:event_FilterActionPerformed

    private void ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadActionPerformed
     
        // Get the orderId of the chosen row in the model
        int row = Notif.getSelectedRow();
        if (row != -1){
            String Context = model.getValueAt(row, 0).toString();
            String Status = model.getValueAt(row, 1).toString();
            model.setRowCount(0); 

            ArrayList<String> lines = nt.readFile();
            List<String> sameIDd = new ArrayList<>();
            String lineToRemove = "";
            String id = "";

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[1].equals(Context) && parts[4].equals(Status)) {
                    lineToRemove = line;
                    id = parts[0];
                    sameIDd.add(lineToRemove);

                }
            }

            lines.remove(lineToRemove);
            nt.overWriteFile();
            for (String line : lines) {
                try {
                    nt.bw.write(line);
                    nt.bw.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
                }
            }         
            nt.closeResources();

            nt.writeFile();          
            for (String line : sameIDd) {
                String[] parts = line.split(",");
                String nid = parts[0];
                String status = parts[4];
                    if (status.equals("Unread") && nid.equals(id)) {
                    try {
                        String[] updatedParts = Arrays.copyOf(parts, parts.length);
                        updatedParts[4] = "Read";
                        line = String.join(",", updatedParts);
                        nt.bw.write(line);
                        nt.bw.newLine();
                    } catch (IOException ex) {
                        Logger.getLogger(NotificationPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    } 
            }
            nt.closeResources();
            JOptionPane.showMessageDialog(null, "Marked As Read","Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "There's no data","Fail", JOptionPane.INFORMATION_MESSAGE);
        }
        
        load();

    }//GEN-LAST:event_ReadActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        String ID = u.getId();
        char firstCharacter = ID.charAt(0);
        if (firstCharacter == 'V'){
            ui.callPage("VendorOrderHistory", u);
            this.dispose();
        } else if (firstCharacter == 'C') {
            ui.callPage("CustomerProfilePage", u);
            this.dispose();
        } else if (firstCharacter == 'R') {
            ui.callPage("RunnerFrame", u);
            this.dispose();           
        } else {
            JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_BackActionPerformed

    public void load(){
        String ID = u.getId();
        ArrayList<String> lines = nt.readFile();
        model.setRowCount(0);
        for (String line : lines) {
            String[] parts = line.split(",");
            String Context = parts[1];
            String Receive = parts[3];
            String Status = parts[4];;
            // If orderId is already in the set, skip this line
            if (ID.equals(Receive) && Status.equals("Unread")) {
                model.addRow(new Object[]{Context,Status});
            }
            
        }
        nt.closeResources();
    }
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
            java.util.logging.Logger.getLogger(NotificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JTable Notif;
    private javax.swing.JButton Read;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
