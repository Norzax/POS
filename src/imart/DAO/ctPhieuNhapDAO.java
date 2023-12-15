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
public class ctPhieuNhapDAO {
    connect conn= new connect();
    public ctPhieuNhapDAO(){
        conn.connectSQL();
    }
    
    public ResultSet getDBCTPhieuNhap(){
        String statement="select * from ct_phieu_nhap";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBctPhieuNhap(String id, String ma_sp, int soluong, Double dongia, Double thanhtien){
        conn.connectSQL();
        conn.setDataSQL("insert into ct_phieu_nhap values ('"+id.trim()+"','"+ma_sp.trim()+"','"+dongia+"','"+soluong+"','"+thanhtien+"')");
        conn.closeSQL();
    }
}
