/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


/**
 *
 * @author Monika
 */
public class CategoryDao {
    public static HashMap<String,String> getAllCategoryId()throws SQLException
            {
                Connection conn=DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs=st.executeQuery("select * from categories");
                HashMap<String,String> categories=new HashMap<>();
                while(rs.next())
                {
                    String catName=rs.getString(2);
                    String catId=rs.getString(1);
                    categories.put(catName, catId);
                }
                return categories;
            }
    public static String getNewCatId()throws SQLException
    {
       Connection conn= DBConnection.getConnection();
       Statement st=conn.createStatement();
       int id=101;
       ResultSet rs=st.executeQuery("Select count(*)from categories");
       if(rs.next())
           id=id+rs.getInt(1);
       return "C"+id;
    }
     public static String addCategory(String cat_id,String cat_name)throws SQLException
    {
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps;
        ps=conn.prepareStatement("select * from categories where cat_name=?");
        ps.setString(1,cat_name);
        ResultSet rs =ps.executeQuery();
        if(rs.next())
            return "present";
        ps=conn.prepareStatement("insert into categories values(?,?)");
        ps.setString(1,cat_id);
        ps.setString(2,cat_name);
        int count=ps.executeUpdate();
        if(count==0)
            return "false";
        else
            return "true"; 
    }
    public static boolean editCategory(String catId,String catName)throws SQLException
    {
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update categories set cat_name=? where cat_id=?");
        ps.setString(1, catName);
        ps.setString(2, catId);
        int count=ps.executeUpdate();
        if(count==0)
            return false;
        else
            return true;
    }
    public static String getCatName(String cat_Id)throws SQLException
    {
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select cat_name from categories where cat_id=?");
        ps.setString(1, cat_Id);
        ResultSet rs =ps.executeQuery();
        String cat_Name=null;
        if(rs.next())
        {
            cat_Name=rs.getString(1);
        }
        return cat_Name;
        
    }
}

