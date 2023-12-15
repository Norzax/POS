/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import imart.BLL.sanPhamBLL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Luan
 */
public class sanPhamDAO {
    connect conn= new connect();
    public sanPhamDAO(){
    }
    
    public ResultSet getDBSanPham(){
        conn.connectSQL();
        String statement="select * from san_pham";
        return connect.dataSQL(statement);
    }
    
    public void updateDBSanPham(String id, int soluong){
        conn.connectSQL();
        conn.setDataSQL("update san_pham set soluong='"+soluong+"' where id='"+id.trim()+"'");
        conn.closeSQL();
    }
    
    public void insertToDBSanPham(String id, String tensp, String nsx, String hsd, String dongia, String soluong, String maloai){
        sanPhamBLL spbll = new sanPhamBLL();
        if(tensp.equals("") || nsx.equals("") || hsd.equals("") || dongia.equals("") || soluong.equals("") || nsx.equals("") || hsd.equals("") || maloai.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin sản phẩm không được để trống!!","Thông báo",2);
        } else if(spbll.kiemTraSPTonTai(tensp)==false){
                JOptionPane.showMessageDialog(null,"Sản phẩm đã tồn tại\nVui lòng kiểm tra lại","Thông báo",2);
        } else {
            conn.connectSQL();
            conn.setDataSQL("insert into san_pham values ('"+id.trim()+"','"+tensp.trim()+"','"+nsx.trim()+"','"+hsd.trim()+"','"+dongia.trim()
                            +"','"+soluong.trim()+"','"+maloai.trim()+"','on')");
            conn.closeSQL();
        }
    }
    
    public void deleteDBSanPham(String id, int soluong){
        if(soluong>0){
            JOptionPane.showMessageDialog(null,"Sản phẩm hiện vẫn còn số lượng\nKhông thể xóa!","Thông báo",2);
        } else {
            conn.connectSQL();
            conn.setDataSQL("update san_pham set status='deleted' where id='"+id.trim()+"'");
            conn.closeSQL();
        }
    }
    
    public void updateDBSanPham2(String id, String name, String nsx, String hsd, Double dongia, String maloai){
        conn.connectSQL();
        conn.setDataSQL("update san_pham set tensp='"+name+"',nsx='"+nsx+"',hsd='"+hsd+"',dongia='"+dongia+"',ma_loai='"+maloai+"' where id='"+id.trim()+"'");
        conn.closeSQL();
    }
    
}
