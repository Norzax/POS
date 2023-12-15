/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import imart.BLL.nhanVienBLL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Luan
 */
public class nhanVienDAO {
    connect conn;
    
    public nhanVienDAO(){
        conn= new connect();
    }
    
    public void updateDBNhanVien(String id, String ho, String ten, String ngaysinh, String diachi, String dienthoai,String ngayvaolam,String gioitinh, String ma_chucvu){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        nhanVienBLL nvbll= new nhanVienBLL();
        if(ho.equals("") || ten.equals("") || ngaysinh.equals("") || diachi.equals("") || dienthoai.equals("") || ngayvaolam.equals("") || gioitinh.equals("") || ma_chucvu.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin nhân viên không được để trống!!","Thông báo",2);
        }
        else if(!dienthoai.matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            if(nvbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                conn.setDataSQL("update nhan_vien set ho='"+ho.trim()+"', "
                                                   + "ten='"+ten.trim()+"',"
                                                   + "ngaysinh='"+ngaysinh.trim()+"',"
                                                   + "dienthoai='"+dienthoai.trim()+"',"
                                                   + "ngayvaolam='"+ngayvaolam.trim()+"',"
                                                   + "gioitinh='"+gioitinh.trim()+"',"
                                                   + "diachi='"+diachi.trim()+"', "
                                                   + "ma_chucvu='"+ma_chucvu.trim()+"' where id='"+id.trim()+"'");
                conn.closeSQL();
            }
        }
    }
    
    // 0: id, 1: ho, 2:ten , 3: ngaysinh, 4: diachi, 5: dienthoai, 6: ngayvao lam, 7: gioitinh, 8: machucvu GET AND CHANGE
    public void insertToDBNhanVien(String id, String ho, String ten, String ngaysinh, String diachi, String dienthoai, String ngayvaolam, String gioitinh, String ma_chucvu){
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        nhanVienBLL nvbll= new nhanVienBLL();
        if(ho.equals("") || ten.equals("") || ngaysinh.equals("") || diachi.equals("") || dienthoai.equals("") || ngayvaolam.equals("") || gioitinh.equals("") || ma_chucvu.equals("")) {
            JOptionPane.showMessageDialog(null, "Thông tin nhân viên không được để trống!!","Thông báo",2);
        }
        else if(!dienthoai.matches(pt)){
            JOptionPane.showMessageDialog(null, "Định dạng số điện thoại sai!!\nSố điện thoại gồm 10 số và bắt đầu bằng \n 02 ,03, 05, 08, 09","Thông báo",2);
        } else {
            if(nvbll.checkTonTaiSDT(dienthoai.trim(),id.trim())==true) {
                conn.connectSQL();
                taiKhoanDAO tkdao= new taiKhoanDAO();
                quyenHanDAO qhdao= new quyenHanDAO();
                conn.setDataSQL("insert into nhan_vien values ('"+id.trim()+"','"+ho.trim()+"','"+ten.trim()+"','"+ngaysinh.trim()+"','"+dienthoai.trim()
                                +"','"+ngayvaolam.trim()+"','"+gioitinh.trim()+"','"+diachi.trim()+"','"+ma_chucvu.trim()+"')");
                tkdao.insertToDBTaiKhoan(id, id+"1", id);
                qhdao.insertToDBquyenHan(id);
                conn.closeSQL();
            }
        }
    }
    
    public void deleteInDBNhanVien(String id){
        conn.connectSQL();
        conn.setDataSQL("delete from nhan_vien where id='"+id+"'");
        conn.closeSQL();
    }
    
    public ResultSet getDBNhanVien(){
        conn.connectSQL();
        String statement="select * from nhan_vien";
        return connect.dataSQL(statement);
    }
    
    public static void main(String[] args) {
        String pt="[0[2|3|5|8|9]]{2}[0-9]{8}";
        if("09211234567".matches(pt)){
            System.out.println("Dung");
        } else {
            System.out.println("Sai");
        }
    }
}
