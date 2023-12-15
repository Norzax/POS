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
public class phieuNhapDAO {
    connect conn= new connect();
    public phieuNhapDAO(){
        
    }
    
    public ResultSet getDBPhieuNhap(){
        conn.connectSQL();
        String statement="select * from phieu_nhap";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBPhieuNhap(String id, String ma_nv, String ma_ncc, String ngaylap, Double tongtien, String ghichu){
        conn.connectSQL();
        conn.setDataSQL("insert into phieu_nhap values ('"+id.trim()+"','"+ma_nv.trim()+"','"+ma_ncc.trim()+"','"+ngaylap.trim()+"','"+tongtien+"','"+ghichu.trim()+"')");
        conn.closeSQL();
    }
    
    public void updateDBNhaCungCap(String id, String ten_ncc, String diachi, String dienthoai){
        conn.connectSQL();
        conn.setDataSQL("update ncc set ten_ncc='"+ten_ncc.trim()+"', diachi='"+diachi.trim()+"',dienthoai='"+dienthoai.trim()+"' where id='"+id.trim()+"'");
        conn.closeSQL();
    }
    
    public void deleteInDBNhaCungCap(String id){
        conn.setDataSQL("delete from ncc where id='"+id.trim()+"'");
    }
}
