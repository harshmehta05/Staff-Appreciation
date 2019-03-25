/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//INSERTING DATA INTO THE DATABASE
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akshay mehta
 */
public class LoginData extends javax.swing.JFrame {
    
    Connection con;

    /**
     * Creates new form LoginData
     */
    public LoginData() {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
    }

        void createConnection()
    {
        try {
             //STEP 1 : LOAD THE DRIVER
            Class.forName("com.mysql.jdbc.Driver");   
            
            //STEP 2: ESTABLISH THE CONNECTION
            //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","user","password");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","harshmehta99");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

        nameInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ageInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        displayTable = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        editAge = new javax.swing.JTextField();
        editName = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        openLoginPage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Inset Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "AGE"
            }
        ));
        jScrollPane1.setViewportView(table);

        displayTable.setText("Refresh");
        displayTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayTableActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        openLoginPage.setText("Open Login Page");
        openLoginPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLoginPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(editName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(editAge, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(updateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(displayTable)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(editButton)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(openLoginPage)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayTable)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openLoginPage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            String name = nameInput.getText();
            int age = Integer.parseInt(ageInput.getText());
            PreparedStatement stmt = con.prepareStatement("INSERT INTO employeetable VALUES(?,?)");
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.execute();
            System.out.println("INSERTION COMPLETED");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void displayTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayTableActionPerformed
        // TODO add your handling code here:
        //RETRIEVING DATA FROM DATABASE
        DefaultTableModel tableModel1 = (DefaultTableModel) table.getModel();
        tableModel1.setRowCount(0);
        try
        {    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employeetable");
            while(rs.next())
            {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println(name + " AGE = "+age);
                
                tableModel1.addRow(new Object[]{name,age});
            }
            
            System.out.println("CONNECTED TO DATABASE SUCCESSFULLY");
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_displayTableActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        String name = (String) model.getValueAt(row, 0);
        String age = (model.getValueAt(row,1).toString());
        
        editName.setText(name);
        editAge.setText(age);
        
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            // TODO add your handling code here:

            PreparedStatement stmt = con.prepareStatement("UPDATE employeetable SET AGE = ? WHERE NAME = ?");
            
            stmt.setInt(1,Integer.parseInt(editAge.getText()));
            stmt.setString(2, editName.getText());
            stmt.executeUpdate();
            System.out.println("UPDATED SUCCESSFULLY");
            stmt.close();
            displayTable.doClick();
        } catch (SQLException ex) {
            Logger.getLogger(LoginData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            // TODO add your handling code here:
            
            int row = table.getSelectedRow();
            String name = table.getValueAt(row, 0).toString();
            
            String deleteCommand = "DELETE FROM EMPLOYEETABLE WHERE NAME = ?";
            PreparedStatement stmt = con.prepareStatement(deleteCommand);
            
            stmt.setString(1,name);
            stmt.executeUpdate();
            System.out.println("DELETED SUCCESSFULLY");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginData.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayTable.doClick();
        
                
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void openLoginPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLoginPageActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        new FinalLogin().setVisible(true);
    }//GEN-LAST:event_openLoginPageActionPerformed

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
            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageInput;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton displayTable;
    private javax.swing.JTextField editAge;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField editName;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JButton openLoginPage;
    private javax.swing.JTable table;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}