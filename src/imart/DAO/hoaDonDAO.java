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
public class hoaDonDAO {
    connect conn= new connect();
    public hoaDonDAO(){
        
    }
    
    public ResultSet getDBHoaDon(){
        conn.connectSQL();
        String statement="select * from hoa_don order by ngaylap";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBHoaDon(String id, String ma_nv, String ma_kh, String ngaylap, Double tongtien, String ghichu){
        conn.connectSQL();
        conn.setDataSQL("insert into hoa_don values ('"+id.trim()+"','"+ma_nv.trim()+"','"+ma_kh.trim()+"','"+ngaylap.trim()+"','"+tongtien+"','"+ghichu+"')");
        conn.closeSQL();
    }
}
