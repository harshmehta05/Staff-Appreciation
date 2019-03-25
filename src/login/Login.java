/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
STEP 1: LOAD THE DRIVER(loads the mysql driver) -> lines(31-38)

STEP 2: ESTABLISH THE CONNECTION -> lines()
*/
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akshay mehta
 */
public class Login {
    
    Connection con;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //END OF STEP 2
        Login pro = new Login();
        pro.createConnection();
        //pro.createTable();
        pro.addBatch();
        
    }
    
    //BATCH OPERATIONS (A GROUP OF MYSQL OPERATIONS (ADDING FIVE VALUES AT A TIME))
    void addBatch()
    {
        try {
            Statement stmt = con.createStatement();
            
            //String Query_String = "INSERT INTO tablename(field1,field2) VALUES ('"+Text1+"','"+Text2+"')"
            stmt.addBatch("INSERT INTO EMPLOYEETABLE(name,age) VALUES('USER1',25)");
            stmt.addBatch("INSERT INTO EMPLOYEETABLE(name,age) VALUES('USER2',26)");
            stmt.addBatch("INSERT INTO EMPLOYEETABLE(name,age) VALUES('USER3',27)");
            stmt.addBatch("INSERT INTO EMPLOYEETABLE(name,age) VALUES('USER4',28)");
            stmt.addBatch("INSERT INTO EMPLOYEETABLE(name,age) VALUES('USER5',29)");
            int []ar = stmt.executeBatch();
            
            for(int i : ar)
            {
               System.out.println(i);
            }
            stmt.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    //CREATE A TABLE IN THE DATABASE
    void createTable()
    {
        try {
            String q = "CREATE TABLE DB1("
                    + "name varchar(100),"
                    + "age int,"
                    + "salary float"
                    + ");";
            
            Statement stmt = con.createStatement();
            
            stmt.execute(q);
            
            System.out.println("SUCCESSFULLY CREATED THE TABLE");
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void createConnection()
    {
        try {
             //STEP 1 : LOAD THE DRIVER
            Class.forName("com.mysql.jdbc.Driver");   
            
            //STEP 2: ESTABLISH THE CONNECTION
            //  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","user","password");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","harshmehta99");
       
            
                       
            //STEP 3:CREATE A STATEMENT FOR DETCHING DATA
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employeetable");
            /*To get the names starting from A
            ResultSet rs = stmt.executeQuery("SELECT * FROM employeetable WHERE name like 'A%'");
            */
            while(rs.next())
            {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println(name + " AGE = "+age);
            }
            
            System.out.println("CONNECTED TO DATABASE SUCCESSFULLY");
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
