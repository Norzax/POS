/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.taiKhoanDAO;
import imart.DTO.taiKhoan;
import imart.DTO.taiKhoanList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class taiKhoanBLL {
    connect conn= new connect();
    private String[] header={"username","password","authority","Mã nhân viên"};
    private String field[] ={"username","password","authority","ma_nv"};
    taiKhoanList list= new taiKhoanList();
    taiKhoanDAO tkdao= new taiKhoanDAO();
    public taiKhoanBLL(){
        super();
        list.setTaikhoan(getTaiKhoanList());
    }
    
    public ArrayList<taiKhoan> getTaiKhoanList(){
        this.conn.connectSQL();
        ResultSet rs = tkdao.getDBTaiKhoan();
        ArrayList<taiKhoan> ar= new ArrayList();
        try {
            while(rs.next()){
                taiKhoan tk= new taiKhoan();
                tk.setUsername(rs.getString("username"));
                tk.setPassword(rs.getString("password"));
                tk.setMa_nv(rs.getString("ma_nv"));
                tk.setStatus(rs.getString("status"));
                ar.add(tk);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getTaiKhoanList (line 36)");
        }
        return null;
    }
    
    public JTable getTable(){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setTaikhoan(getTaiKhoanList());
        for(int i=0; i< this.list.getTaikhoan().size() ; i++){
            String username= list.getTaikhoan().get(i).getUsername();
            String password= list.getTaikhoan().get(i).getPassword();
            String ma_nv= list.getTaikhoan().get(i).getMa_nv();
            Object[] rows={username,password,ma_nv};
            model.addRow(rows);
        }
        table.setModel(model);
        return table;
    }
    
    // lấy tài khoản của nhân viên đang login
    public taiKhoan getTaiKhoanLogin(String us, String pw){
        taiKhoan tk= new taiKhoan();
        for(int i=0;i<this.list.getTaikhoan().size();i++){
            if(this.list.getTaikhoan().get(i).getUsername().equals(us) && this.list.getTaikhoan().get(i).getPassword().equals(pw)) { 
                tk.setMa_nv(this.list.getTaikhoan().get(i).getMa_nv());
                tk.setUsername(us);
                tk.setPassword(pw);
            }
        }
        return tk;
    }

    public taiKhoanList getList() {
        return list;
    }

    public void setList(taiKhoanList list) {
        this.list = list;
    }
    
    public static void main(String[] args) {
        taiKhoanBLL tkBLL= new taiKhoanBLL();
        System.out.println(tkBLL.getTaiKhoanLogin("baoluan", "0512").getPassword());
    }
}
