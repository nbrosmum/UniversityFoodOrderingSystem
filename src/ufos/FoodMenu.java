package ufos;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class FoodMenu extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private String[] columnName = {"Food Name", "Description", "Price"};
    Vendor vt = new Vendor();
    GUI ui = new GUI();
    DB db = new DB("Menu");
    

    public FoodMenu() {
        initComponents();
        model.setColumnIdentifiers(columnName);
        load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        FoodMenu = new javax.swing.JTable();
        OrderPage = new javax.swing.JButton();
        OrderHistory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Name = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        Price = new javax.swing.JLabel();
        PriceText = new javax.swing.JTextField();
        Desciption = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescriptionText = new javax.swing.JTextArea();
        deleteItem = new javax.swing.JButton();
        addItem = new javax.swing.JButton();
        updateItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FoodMenu.setModel(model);
        FoodMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                FoodMenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(FoodMenu);

        OrderPage.setText("Order Page");
        OrderPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageActionPerformed(evt);
            }
        });

        OrderHistory.setText("Order History");
        OrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHistoryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Food Menu");

        Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Name.setText("Name : ");

        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });

        Price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Price.setText("Price : ");

        Desciption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Desciption.setText("Desciption : ");

        DescriptionText.setColumns(20);
        DescriptionText.setRows(5);
        jScrollPane2.setViewportView(DescriptionText);

        deleteItem.setText("Delete");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });

        addItem.setText("Add");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        updateItem.setText("Update");
        updateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OrderHistory)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(OrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Name)
                            .addComponent(Desciption)
                            .addComponent(Price))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(PriceText)
                            .addComponent(NameText)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addItem)
                        .addGap(18, 18, 18)
                        .addComponent(deleteItem)
                        .addGap(18, 18, 18)
                        .addComponent(updateItem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name)
                            .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Price)
                            .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Desciption)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteItem)
                            .addComponent(updateItem)
                            .addComponent(addItem))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(OrderHistory)
                                    .addComponent(OrderPage))
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OrderPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageActionPerformed
        ui.callPage("OrderPage");
        this.dispose();
    }//GEN-LAST:event_OrderPageActionPerformed

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextActionPerformed

    private void OrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHistoryActionPerformed
        ui.callPage("OrderHistory");
        this.dispose();
    }//GEN-LAST:event_OrderHistoryActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        
        // variables      
        String foodName =  NameText.getText();
        double price = Double.parseDouble(PriceText.getText());
        String Description = DescriptionText.getText();
        
        //Add in Text  
        vt.add(foodName,price,Description);

        load();               
        clearTextField();     

    }//GEN-LAST:event_addItemActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed

        int selectedRow = FoodMenu.getSelectedRow();
        if (selectedRow != -1) {
            TableModel model = FoodMenu.getModel();
            String foodName = (String) model.getValueAt(selectedRow, 0);
            String description = (String) model.getValueAt(selectedRow, 1);
            double price = (Double) model.getValueAt(selectedRow, 2);
            
            
            vt.delete(foodName, price, description);
            
        }
        
        load();
        clearTextField();

        
    }//GEN-LAST:event_deleteItemActionPerformed

    private void FoodMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FoodMenuMouseReleased
        int row = FoodMenu.getSelectedRow();
        String name = String.valueOf(model.getValueAt(row,0));
        double price = Double.parseDouble(String.valueOf(model.getValueAt(row,2)));
        String desc = String.valueOf(model.getValueAt(row,1));

        NameText.setText(name);
        PriceText.setText(String.valueOf(price));
        DescriptionText.setText(desc);

    }//GEN-LAST:event_FoodMenuMouseReleased

    private void updateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemActionPerformed

    int selectedRow = FoodMenu.getSelectedRow();
    if (selectedRow != -1) {
        // get modal information
        TableModel model = FoodMenu.getModel();
        String foodName = (String) model.getValueAt(selectedRow, 0);
        String description = (String) model.getValueAt(selectedRow, 1);
        double price = (Double) model.getValueAt(selectedRow, 2);
        

        // get the id of the selected row
            List<String> data = db.readFile();
            String id = "";
            String temp = "";
            for (String line : data) {
                String[] parts = line.split(",");
                if (parts[1].equals(foodName) && parts[2].equals(Double.toString(price)) && parts[3].equals(description)) {
                    temp = line;
                    id = parts[0];
                }
            }
        // delete the row    
            data.remove(temp);

        // get the updated information
            String foodText = NameText.getText();
            double priceText = Double.parseDouble(PriceText.getText());
            String descText = DescriptionText.getText();
        // update the information but keep the original id
            String updatedLine = id + "," + foodText + "," + String.valueOf(priceText) + "," + descText;
            data.add(updatedLine);
        // rewrite it into the file
            db.overWriteFile();
            try {
                for (String line : data) {
                    db.bw.write(line);
                    db.bw.newLine();
                }
            } catch (IOException ex) {
                System.out.println("Something went wrong.");
            }
            db.closeResources();
        }
        load();
        clearTextField();



    }//GEN-LAST:event_updateItemActionPerformed
    private void clearTextField(){
        NameText.setText("");
        PriceText.setText("");
        DescriptionText.setText("");
    }
    
//    private void load() {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("DB/Service/Menu.txt"));
//            String line;
//            model.setRowCount(0);
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                String foodName = parts[1];
//                double price = Double.parseDouble(parts[2]);
//                String description = parts[3];
//                model.addRow(new Object[]{foodName, description, price});
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    
    private void load(){
        db.loadData(model, line -> {
            String[] parts = line.split(",");
            String foodName = parts[1];
            double price = Double.parseDouble(parts[2]);
            String description = parts[3];
            return new Object[]{foodName, description, price};
        });
        
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
            java.util.logging.Logger.getLogger(FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodMenu().setVisible(true);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Desciption;
    private javax.swing.JTextArea DescriptionText;
    private javax.swing.JTable FoodMenu;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton OrderHistory;
    private javax.swing.JButton OrderPage;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField PriceText;
    private javax.swing.JButton addItem;
    private javax.swing.JButton deleteItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton updateItem;
    // End of variables declaration//GEN-END:variables
}
