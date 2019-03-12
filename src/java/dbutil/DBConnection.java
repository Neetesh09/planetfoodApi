/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-9JKDGQ1/XE","planet","food");
            
        }
        catch(ClassNotFoundException ex)
        {
             JOptionPane.showMessageDialog(null, "Error Loading Driver Class "+ex,"Error!",JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB error"+ex,"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static Connection getConnection()
        {
            return conn;
        }
    public static void closeConnection()
    {
        try
        {
           conn.close(); 
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Error in closing"+ex,"Error",JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
    }
}
