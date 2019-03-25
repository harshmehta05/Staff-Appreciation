/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static login.MainPage.userid;

/**
 *
 * @author Akshay mehta
 */
public class AdminRateTask extends javax.swing.JFrame {
    Connection con;
    ArrayList<Employee> ratingList= new ArrayList<Employee>();
    DefaultTableModel tableModel1 ;
    String ratingMsg = "";

    /** Creates new form AdminRateTask */
    public AdminRateTask() {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        createList();
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
    
    
    void createList()
    {
        tableModel1 = (DefaultTableModel) taskTable.getModel();
        tableModel1.setRowCount(0);
        try
        {    
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasktable");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("task");
                String desc = rs.getString("description");   
                
                    String selectSql = "Select * from employeetable where id=?";
                    PreparedStatement pst = con.prepareStatement(selectSql);
                    pst.setInt(1,id);
                    ResultSet rs1 = pst.executeQuery();
                    while(rs1.next())
                    {
                        String name = rs1.getString("name");
                        tableModel1.addRow(new Object[]{id,name,title,desc,0});
                    }
                    
                    
                
            }
            
            System.out.println("CONNECTED TO DATABASE SUCCESSFULLY");
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void retrieveData()           
    {
        try {
            int userPoints=0;
            for(int count=0;count<tableModel1.getRowCount();count++)
            {
                String mId =  (tableModel1.getValueAt(count, 0)).toString();
                String mRating = (tableModel1.getValueAt(count, 4)).toString();
                if(count == 0)
                {
                    ratingMsg = ratingMsg + "Employee ID = " +mId + " has received "+ mRating + " Points\n";
                }
                else
                {
                    ratingMsg = ratingMsg +"\t" + "Employee ID = " +mId + " has received "+ mRating + " Points\n";
                }
                System.out.println(mId +"  "+mRating);
                ratingList.add(new Employee(mId,mRating));
            }
            for(int i=0;i<ratingList.size();i++)
            {
                Employee employee = ratingList.get(i);
                try {
                    // TODO add your handling code here:
                    
                    String selectSql = "Select * from employeetable where id=?";
                    PreparedStatement pst = con.prepareStatement(selectSql);
                    pst.setInt(1,Integer.parseInt(employee.getId()));
                    ResultSet rs = pst.executeQuery();
                    while(rs.next())
                    {
                        userPoints = rs.getInt("meritpoints");
                        userPoints = userPoints + Integer.parseInt(employee.getRating());
                        System.out.println(employee.getId() + " "+employee.getRating());
                        PreparedStatement stmt = con.prepareStatement("UPDATE employeetable SET meritpoints = ? WHERE id = ?");
                        stmt.setInt(1,userPoints);
                        stmt.setInt(2,Integer.parseInt(employee.getId()));
                        stmt.executeUpdate();
                        System.out.println("UPDATED SUCCESSFULLY");
                        //stmt.close();
                    }
                    
                    
                    //displayTable.doClick();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginData.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            Statement stmt = con.createStatement();
            //Use TRUNCATE
            String sql = "TRUNCATE tasktable";
            // Execute deletion
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdminRateTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        uploadRatingButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                " Id", "Name", "Task Title", "Description", "Rating"
            }
        ));
        jScrollPane1.setViewportView(taskTable);

        uploadRatingButton.setBackground(new java.awt.Color(0, 153, 153));
        uploadRatingButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uploadRatingButton.setForeground(new java.awt.Color(255, 255, 255));
        uploadRatingButton.setText("Upload Rating");
        uploadRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadRatingButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("x");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RATE TASK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(uploadRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadRatingButtonActionPerformed
        // TODO add your handling code here:
        retrieveData();
        this.dispose();
        String id[] = new String[1];
        id[0]=ratingMsg;
        AdminChatRoom.main(id);
        
    }//GEN-LAST:event_uploadRatingButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminMainPage().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminRateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRateTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taskTable;
    private javax.swing.JButton uploadRatingButton;
    // End of variables declaration//GEN-END:variables

}
