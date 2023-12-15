/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import imart.BLL.khachHangBLL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Luan
 */
public class khachHangDAO {
    connect conn= new connect();
    public khachHangDAO(){
        
    }
    
    public void updateDBKhachHang(String id, String ho, String ten, String diachi, String dienthoai){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        if(ho.equals("") || ten.equals("") || diachi.equals("") || dienthoai.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin khách hàng không được để trống!!","Thông báo",2);
        } else if(!dienthoai.trim().matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            khachHangBLL khbll= new khachHangBLL();
            if(khbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                conn.setDataSQL("update khach_hang set ho='"+ho.trim()+"', ten='"+ten.trim()+"',diachi='"+diachi.trim()+"',sodienthoai='"+dienthoai.trim()+"' where id='"+id.trim()+"'");
                conn.closeSQL();
            }
        }
    }
    
    public void insertToDBKhachHang(String id, String ho, String ten, String diachi, String dienthoai){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        if(ho.equals("") || ten.equals("") || diachi.equals("") || dienthoai.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin khách hàng không được để trống!!","Thông báo",2);
        } else if(!dienthoai.matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            khachHangBLL khbll= new khachHangBLL();
            if(khbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                conn.setDataSQL("insert into khach_hang values ('"+id.trim()+"','"+ho.trim()+"','"+ten.trim()+"','"+diachi.trim()+"','"+dienthoai.trim()+"','on')");
                JOptionPane.showMessageDialog(null,"Thêm thành công","Thông báo",2);
                conn.closeSQL();
            }
        }
    }
    
    public void deleteInDBKhachHang(String id, String status){
        if(status.equalsIgnoreCase("unchange")){
            JOptionPane.showMessageDialog(null, "Đây là khách mặc định,\nkhông thể xóa","Thông báo",2);
        } else {
            conn.connectSQL();
            conn.setDataSQL("update khach_hang set status='deleted' where id='"+id.trim()+"'");
            conn.closeSQL();
        }
    }
    
    public ResultSet getDBKhachHang(){
        conn.connectSQL();
        String statement="select * from khach_hang";
        return connect.dataSQL(statement);
    }
}
