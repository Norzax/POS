/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bao Luan
 */
public class connect {
    private static Connection conn;
    private static ResultSet rs;
    private static  Statement stmt;
    private static String user,pass,url;
    private PreparedStatement ps;
    
    public connect(){
        rs=null;
        stmt=null;
        ps= null;
        user="root";
        pass="";
        url="jdbc:mysql://localhost:3306/imart";
        connectSQL();
    }
        
    public Connection connectSQL(){
        try {
            try { 
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/imart","root","");
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static ResultSet dataSQL(String statement){
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(statement);
        } catch (SQLException ex) { 
            System.out.println("Error at function dataSQL (line 47)");
            return null;
        }
    }
    
    public void setDataSQL(String statement){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(statement);
        } catch (SQLException ex) { 
            System.out.println("Error at class connect (line 57)");
        }
    }
    
    public ResultSet getSQL(String statement, String us, String pw, String status){
        connectSQL();
        try {
            ps = conn.prepareStatement(statement);
            ps.setString(1, us);
            ps.setString(2, pw);
            ps.setString(3,status);
            return ps.executeQuery();
        } catch (SQLException ex) { 
            System.out.println("Error at function dataSQL (line 64)");
            return null;
        }
    }
    
    public void closeSQL(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error at line 72");
        }
    }
    
    public static void main(String[] args) {
        connect conn= new connect();
        System.out.println((conn.connectSQL() == null) ? "loi": "ok");
        System.out.println(conn.stmt);
    }
}

