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
public class ctHoaDonDAO {
    connect conn= new connect();
    public ctHoaDonDAO(){
    }
    
    public ResultSet getDBCTHoaDon(){
        conn.connectSQL();
        String statement="select * from ct_hoa_don";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBctHoaDon(String id, String ma_sp, int soluong, Double dongia, Double thanhtien){
        conn.connectSQL();
        conn.setDataSQL("insert into ct_hoa_don values ('"+id.trim()+"','"+ma_sp.trim()+"','"+soluong+"','"+dongia+"','"+thanhtien+"')");
        conn.closeSQL();
    }
}
