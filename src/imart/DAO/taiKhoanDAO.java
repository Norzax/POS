/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import java.sql.ResultSet;

/**
 *
 * @author Bao Luan
 */
public class taiKhoanDAO {
    connect conn= new connect();
    public taiKhoanDAO(){
    }
    
    public ResultSet getDBTaiKhoan(){
        conn.connectSQL();
        String statement="select * from tai_khoan";
        return connect.dataSQL(statement);
    }
    
    public void deleteInDBTaiKhoan(String id){
        conn.connectSQL();
        conn.setDataSQL("update tai_khoan set status='deleted' where ma_nv='"+id+"'");
        conn.closeSQL();
    }
    
    public void updateInDBTaiKhoan(String id, String us, String pw){
        conn.connectSQL();
        conn.setDataSQL("update tai_khoan set username='"+us+"', password='"+pw+"' where ma_nv='"+id+"'");
        conn.closeSQL();
    }
    
    public void insertToDBTaiKhoan(String username, String pass, String id){
        conn.connectSQL();
        conn.setDataSQL("insert into tai_khoan values ('"+username.trim()+"','"+pass.trim()+"','"+id.trim()+"','on')");
        conn.closeSQL();
    }
    
    public static void main(String[] args) {
        taiKhoanDAO tk= new taiKhoanDAO();
        tk.deleteInDBTaiKhoan("NV01");
    }
}
