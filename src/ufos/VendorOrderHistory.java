package ufos;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;

public class VendorOrderHistory extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"OrderID", "Date", "DeliveryMethod", "TotalPrice"};
    Vendor vt = new Vendor();
    User u = new User();
    DB od = new DB("Order");
    DB fr = new DB("FoodReview"); 
    GUI ui = new GUI();
    DB.OrderRowMapper mapper = od.new OrderRowMapper();
    DB.ReviewRowMapper review = fr.new ReviewRowMapper();

    public VendorOrderHistory() {
        initComponents();    
    }
    public VendorOrderHistory(User id) {
        initComponents();
        model.setColumnIdentifiers(columnName);
        u = id;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RatingNo = new javax.swing.JTextField();
        Choices = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TotalPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Order History");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Rating : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Comment : ");

        RatingNo.setEditable(false);

        Choices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Daily", "Monthly", "Quarterly" }));
        Choices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoicesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Total Revenue : ");

        TotalPrice.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Periods : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FoodMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addGap(216, 216, 216)
                        .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RatingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Choices, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FoodMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(Choices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RatingNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FoodMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodMenuActionPerformed
        VendorFoodMenu wp = new VendorFoodMenu(u);
        wp.setVisible(true);
        wp.pack();
        wp.setLocationRelativeTo(null);
        wp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
//        
//        ui.callPage("VendorFoodMenu",u);
//        this.dispose();
    }//GEN-LAST:event_FoodMenuActionPerformed

    private void OrderPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageActionPerformed
        ui.callPage("VendorOrderPage",u);
        this.dispose();
    }//GEN-LAST:event_OrderPageActionPerformed

    private void OrderHistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderHistoryMouseReleased
// Get the orderId of the chosen row in the model
        int row = OrderHistory.getSelectedRow();
        String orderId = String.valueOf(model.getValueAt(row, 0));


        List<Object[]> rows = fr.readData(review);
// Read the Order.txt file line by line
        for (Object[] rowData : rows){
            String currentOrderId = (String) rowData[1];
            String sameIDdValue = (String) rowData[5];
            String Rating = (String) rowData[4];
            if (currentOrderId.equals(orderId)) {
                ReviewText.setText(sameIDdValue);
                RatingNo.setText(Rating);
            }    
        }
  
        fr.closeResources();         
        
    }//GEN-LAST:event_OrderHistoryMouseReleased

    private void ChoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoicesActionPerformed
        TotalPrice.setText("");
        String vId = u.getId();
        String selectedOption = (String) Choices.getSelectedItem();
        List<Object[]> rows = od.readData(mapper);
        model.setRowCount(0);      
        LocalDate now = LocalDate.now();
        Set<String> orderIds = new HashSet<>();
        double totalRevenue = 0.0; // Declare totalRevenue
        
        for (Object[] rowData : rows){
            String orderId = (String) rowData[0];
            LocalDate dt = LocalDate.parse((String) rowData[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            double totalprice = Double.parseDouble((String) rowData[7]);
            String DM = (String) rowData[8];
            String vendorID = (String) rowData[9];
            
            if (vendorID.equals(vId)) {
                if (!orderIds.add(orderId)) {
                    continue;
                }
                        
                if (selectedOption.equals("Daily")) {
                    if (dt.isEqual(now)) {
                        model.addRow(new Object[]{orderId, dt, DM, totalprice});
                        totalRevenue += totalprice;
                    }
                } else if (selectedOption.equals("Monthly")) {
                    if (dt.getMonth() == now.getMonth() && dt.getYear() == now.getYear()) {
                        model.addRow(new Object[]{orderId, dt, DM, totalprice});
                        totalRevenue += totalprice;
                    }
                } else if (selectedOption.equals("Quarterly")) {
                    if (dt.getMonthValue() >= now.getMonthValue() - 3 && dt.getMonthValue() <= now.getMonthValue() && dt.getYear() == now.getYear()) {
                        model.addRow(new Object[]{orderId, dt, DM, totalprice});
                        totalRevenue += totalprice;
                    }
                } else{
                    model.addRow(new Object[]{orderId, dt, DM, totalprice});
                    totalRevenue += totalprice;
                }
            }
        }
//        System.out.println(totalRevenue);
        TotalPrice.setText(String.valueOf(totalRevenue));
        od.closeResources();
    }//GEN-LAST:event_ChoicesActionPerformed

    
    
    private void load() {
       // Use DB class to read data
       String vId = u.getId();
       List<Object[]> rows = od.readData(mapper);
       double totalRevenue = 0.0;


       model.setRowCount(0);
       Set<String> orderIds = new HashSet<>(); // Set to store orderIds

       for (Object[] rowData : rows) {
           String orderId = (String) rowData[0];
           String dt = (String) rowData[6];
           double totalprice = Double.parseDouble((String) rowData[7]);
           String DM = (String) rowData[8];
           String vendorID = (String) rowData[9];

           // If orderId is already in the set, skip this line
            if (vendorID.equals(vId)) {
                if (!orderIds.add(orderId)) {
                    continue;
                }
                model.addRow(new Object[]{orderId,dt,DM,totalprice});
                totalRevenue += totalprice;
            } 
       }
       TotalPrice.setText(String.valueOf(totalRevenue));
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
    private javax.swing.JTextField TotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
