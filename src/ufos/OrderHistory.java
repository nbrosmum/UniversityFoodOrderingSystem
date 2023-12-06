package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class OrderHistory extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private String[] columnName = {"OrderID", "Date", "Status", "TotalPrice"};
    Vendor vt = new Vendor();
    String vendorId = vt.getVendorId();
    DB db = new DB("Order");
    GUI ui = new GUI();
    
    public OrderHistory() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        Vendor vt = new Vendor();
        load();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        History1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        History = new javax.swing.JTable();
        FoodMenu = new javax.swing.JButton();
        OrderPage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReviewText = new javax.swing.JTextArea();

        History1.setModel(model);
        History1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(History1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        History.setModel(model);
        History.getTableHeader().setReorderingAllowed(false);
        History.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HistoryMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(History);

        FoodMenu.setText("Food Menu");
        FoodMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodMenuActionPerformed(evt);
            }
        });

        OrderPage.setText("OrderPage");
        OrderPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Order History");

        ReviewText.setColumns(20);
        ReviewText.setLineWrap(true);
        ReviewText.setRows(5);
        ReviewText.setWrapStyleWord(true);
        jScrollPane3.setViewportView(ReviewText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FoodMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(FoodMenu)
                    .addComponent(OrderPage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
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

    private void HistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoryMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryMouseReleased

    private void load() {
        
        ArrayList<String> lines = db.readFile();
        ArrayList<Object[]> data = new ArrayList<>();
        model.setRowCount(0);
        for (String line : lines) {
            String[] parts = line.split(",");
            String foodName = parts[1];
            double price = Double.parseDouble(parts[2]);
            String description = parts[3];
            String vdId = parts[4];
            
            // If orderId is already in the set, skip this line
            if (vdId.equals(vendorId)) {
                data.add(new Object[]{foodName, description, price});
            }
//            model.addRow(new Object[]{foodName, description, price});
        }
   
    //Set the model's data to the new list
            for (Object[] row : data) {
                model.addRow(row);
            }
            
                    
        db.closeResources();

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FoodMenu;
    private javax.swing.JTable History;
    private javax.swing.JTable History1;
    private javax.swing.JButton OrderPage;
    private javax.swing.JTextArea ReviewText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
