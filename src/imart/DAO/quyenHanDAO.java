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
public class quyenHanDAO {
    connect conn= new connect();
    public quyenHanDAO(){
        
    }
    
    public ResultSet getDBQuyenHan(){
        conn.connectSQL();
        String statement="select * from quyen_han";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBquyenHan(String id){
        conn.connectSQL();
        conn.setDataSQL("insert into quyen_han values ('"+id.trim()+"','0','1','0','0','1','1','1','1')");
        conn.closeSQL();
    }
    
    public void updateDBQuyenHan(String id, String ql_nv, String tinhluong, String ql_ncc, String phanquyen, String qly_hd, String nhaphang, String banhang, String thongke){
        conn.connectSQL();
        conn.setDataSQL("update quyen_han set ql_nv='"+ql_nv.trim()+"', qly_pn='"+tinhluong.trim()+"',qly_ncc='"+ql_ncc.trim()+"', phanquyen='"+phanquyen.trim() +"', "
                        + " qly_hd='"+qly_hd.trim() +"', nhaphang='"+nhaphang.trim()+"',banhang='"+banhang.trim()+"',thongke='"+thongke.trim()+"' where ma_nhanvien='"+id.trim()+"'");
        conn.closeSQL();
    }
    
    public static void main(String[] args) {
        quyenHanDAO q= new quyenHanDAO();
        q.updateDBQuyenHan("NV03", "1", "1", "1", "1", "1", "1", "1", "0");
    }
}
