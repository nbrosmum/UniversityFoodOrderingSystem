
package ufos;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Notification extends javax.swing.JFrame {
    User u = new User();
    GUI ui = new GUI();
    DB nt = new DB("Notification");
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Notification", "Status"};


    public Notification() {
        initComponents();
    }
    public Notification(User id) {
        initComponents();     
        u = id;
        model.setColumnIdentifiers(columnName);
        load();
    }
    
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Filter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Notif = new javax.swing.JTable();
        Read = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Notification");


        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unread", "Read", "All"}));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        Notif.setModel(model);
        jScrollPane1.setViewportView(Notif);

        Read.setText("Read");
        Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadActionPerformed(evt);
            }
        });

        Read.setText("Read");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Read, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Read)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        String selectedOption = (String) Filter.getSelectedItem();
        
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
                if (ID.equals(Receive) && Status.equals("Unread")) {
                    model.addRow(new Object[]{Context,Status});
                }

            } else if (selectedOption.equals("Read")){                
                if (ID.equals(Receive) && Status.equals("Read")) {
                    model.addRow(new Object[]{Context,Status});
                }
            } else {
                if (ID.equals(Receive)) {
                    model.addRow(new Object[]{Context,Status});
                }
            }
        }
        nt.closeResources(); 
        load();
    }//GEN-LAST:event_FilterActionPerformed

    private void ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadActionPerformed
//
//        ArrayList<String> lines = nt.readFile();
//        model.setRowCount(0);
//        
//        
//// Get the orderId of the chosen row in the model
//        int row = Notif.getSelectedRow();
//        String orderId = String.valueOf(model.getValueAt(row, 0));
//
//// Read the Order.txt file line by line
//        List<String> data = db.readFile();
//        List<String> sameIDd = new ArrayList<>();
//        for (String line : data) {
//            String[] parts = line.split(",");
//            String currentOrderId = parts[0];
//
//// If the currentOrderId is the same as the orderId of the chosen row in the model and the status is pending, add the line to the list
//            if (currentOrderId.equals(orderId)) {
//                sameIDd.add(line);
//            }
//        }
//        
//        data.removeIf(line -> {
//            String[] parts = line.split(",");
//            String currentOrderId = parts[0];
//            return currentOrderId.equals(orderId);
//         });     
// 
//        db.overWriteFile();
//        try {
//            for (String line : data) {
//                db.bw.write(line);
//                db.bw.newLine();
//            }
//        } catch (IOException ex) {
//            System.out.println("Something went wrong.");
//        }
//        db.closeResources();
//        
//       
//        
//        db.writeFile();
//        for (String line : sameIDd) {
//            String[] parts = line.split(",");
//            String status = parts[5];
//            if (status.equals("Pending")) {
//                String[] updatedParts = Arrays.copyOf(parts, parts.length);
//                updatedParts[5] = "Cancelled";
//                line = String.join(",", updatedParts);                            
//
//                
//            }
//            try {
//                db.bw.write(line);
//                db.bw.newLine();
//                
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "Error","Fail", JOptionPane.ERROR_MESSAGE);
//            }                   
//        db.closeResources();
//        load();
//        }
    }//GEN-LAST:event_ReadActionPerformed

    public void load() {
        model.setRowCount(0);
        ArrayList<String> lines = nt.readFile();
        for (String line : lines) {
            String[] parts = line.split(",");
            String context = parts[1];
            String status = parts[4];

            model.addRow(new Object[]{context, status});
        }
    }
    

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
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JTable Notif;
    private javax.swing.JButton Read;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
