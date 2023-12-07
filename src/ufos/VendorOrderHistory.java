package ufos;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;

public class VendorOrderHistory extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"OrderID", "Date", "DeliveryMethod", "TotalPrice"};
    Vendor vt = new Vendor();
    String vendorId = vt.getVendorId();
    DB od = new DB("Order");
    DB fr = new DB("FoodReview"); 
    GUI ui = new GUI();

    public VendorOrderHistory() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        Vendor vt = new Vendor();
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FoodMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        OrderPage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderHistory = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReviewText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RatingNo = new javax.swing.JTextField();
        Choices = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FoodMenu.setText("Food Menu");
        FoodMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodMenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Vendor Dashboard");

        OrderPage.setText("OrderPage");
        OrderPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageActionPerformed(evt);
            }
        });

        OrderHistory.setModel(model);
        OrderHistory.getTableHeader().setReorderingAllowed(false);
        OrderHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OrderHistoryMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(OrderHistory);

        ReviewText.setEditable(false);
        ReviewText.setColumns(20);
        ReviewText.setLineWrap(true);
        ReviewText.setRows(5);
        ReviewText.setWrapStyleWord(true);
        jScrollPane3.setViewportView(ReviewText);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Revenue");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Order History");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Rating : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Comment : ");

        RatingNo.setEditable(false);

        Choices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Daily", "Monthly", "Quarterly" }));
        Choices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(FoodMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)
                        .addGap(216, 216, 216)
                        .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RatingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Choices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)))
                        .addComponent(jLabel2)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodMenu)
                    .addComponent(OrderPage)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Choices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(RatingNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FoodMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodMenuActionPerformed
        ui.callPage("FoodMenu");
        this.dispose();
    }//GEN-LAST:event_FoodMenuActionPerformed

    private void OrderPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageActionPerformed
        ui.callPage("OrderPage");
        this.dispose();
    }//GEN-LAST:event_OrderPageActionPerformed

    private void OrderHistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderHistoryMouseReleased
// Get the orderId of the chosen row in the model
        int row = OrderHistory.getSelectedRow();
        String orderId = String.valueOf(model.getValueAt(row, 0));

// Read the Order.txt file line by line
//        List<String> order = od.readFile();
        List<String> review = fr.readFile();
        List<String> sameIDd = new ArrayList<>();
        for (String line : review) {
            String[] parts = line.split(",");
            String currentOrderId = parts[1];

// If the currentOrderId is the same as the orderId of the chosen row in the model and the status is pending, add the line to the list
            if (currentOrderId.equals(orderId)) {
                sameIDd.add(line);
            }
            
        }
        
        for (String line : sameIDd) {
            String[] parts = line.split(",");
            String sameIDdValue = parts[5];
            String Rating = parts[4];
            ReviewText.setText(sameIDdValue);
            RatingNo.setText(Rating);
        }
  
        fr.closeResources();         
        
    }//GEN-LAST:event_OrderHistoryMouseReleased

    private void ChoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoicesActionPerformed
               
        String selectedOption = (String) Choices.getSelectedItem();
        model.setRowCount(0);
        List<String> lines = od.readFile();       
        LocalDate now = LocalDate.now();
        Set<String> orderIds = new HashSet<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            LocalDate date = LocalDate.parse(parts[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String orderId = parts[0];
            String totalprice = parts[7];
            String DM = parts[8];
            
            if (!orderIds.add(orderId)) {
                continue;
            }

            if (selectedOption.equals("Daily")) {
                if (date.isEqual(now)) {
                    model.addRow(new Object[]{orderId, date, DM, totalprice});
                }
            } else if (selectedOption.equals("Monthly")) {
                if (date.getMonth() == now.getMonth() && date.getYear() == now.getYear()) {
                    model.addRow(new Object[]{orderId, date, DM, totalprice});
                }
            } else if (selectedOption.equals("Quarterly")) {
                if (date.getMonthValue() >= now.getMonthValue() - 3 && date.getMonthValue() <= now.getMonthValue() && date.getYear() == now.getYear()) {
                    model.addRow(new Object[]{orderId, date, DM, totalprice});
                }
            } else{
                model.addRow(new Object[]{orderId, date, DM, totalprice});
            }
        }
        od.closeResources();
    }//GEN-LAST:event_ChoicesActionPerformed

    private void load() {  
// OrderID = 0 | FoodID = 1 | Food Name = 2 | Portion = 3 | Price = 4 | Status = 5 | Date = 5 | TotalPrice = 6 | DeliMethod = 7 | vendorID = 8 | CustomerID = 9 |
        ArrayList<String> lines = od.readFile();
        model.setRowCount(0);
        Set<String> orderIds = new HashSet<>(); // Set to store orderIds
        for (String line : lines) {
            String[] parts = line.split(",");
            String orderId = parts[0];
            String status = parts[5];
            String dt = parts[6];
            String totalprice = parts[7];
            String DM = parts[8];
            
            // If orderId is already in the set, skip this line
            if (!orderIds.add(orderId)) {
                continue;
            }
            if (status.equals("Cancelled")) {
                continue;
            }
            
            model.addRow(new Object[]{orderId,dt,DM,totalprice});
        }
        od.closeResources();
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
            java.util.logging.Logger.getLogger(VendorOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorOrderHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Choices;
    private javax.swing.JButton FoodMenu;
    private javax.swing.JTable OrderHistory;
    private javax.swing.JButton OrderPage;
    private javax.swing.JTextField RatingNo;
    private javax.swing.JTextArea ReviewText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
