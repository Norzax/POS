/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import imart.BLL.nhaCCapBLL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Luan
 */
public class nhaCCapDAO {
    connect conn= new connect();
    public nhaCCapDAO(){
        conn.connectSQL();
    }
    
    public ResultSet getDBNhaCungCap(){
        String statement="select * from ncc";
        return connect.dataSQL(statement);
    }
    
    public void insertToDBNhaCungCap(String id,String ten_ncc, String diachi, String dienthoai){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        if(ten_ncc.equals("") || diachi.equals("") || dienthoai.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin nhà cung cấp không được để trống!!","Thông báo",2);
        } else if(!dienthoai.matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            nhaCCapBLL nccbll= new nhaCCapBLL();
            if(nccbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                conn.setDataSQL("insert into ncc values ('"+id.trim()+"','"+ten_ncc.trim()+"','"+diachi.trim()+"','"+dienthoai.trim()+"','on')");
                conn.closeSQL();
            }
        }
    }
    
    public void updateDBNhaCungCap(String id, String ten_ncc, String diachi, String dienthoai){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        if(ten_ncc.equals("") || diachi.equals("") || dienthoai.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin nhà cung cấp không được để trống!!","Thông báo",2);
        } else if(!dienthoai.matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            nhaCCapBLL nccbll= new nhaCCapBLL();
            if(nccbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                conn.setDataSQL("update ncc set ten_ncc='"+ten_ncc.trim()+"', diachi='"+diachi.trim()+"',dienthoai='"+dienthoai.trim()+"' where id='"+id+"'");
                conn.closeSQL();
            }
        }
    }
    
    public void deleteInDBNhaCungCap(String id){
        conn.connectSQL();
        conn.setDataSQL("update ncc set status='deleted' where id='"+id.trim()+"'");
        conn.closeSQL();
    }
}
