/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.ctHoaDonDAO;
import imart.DTO.ctHoaDon;
import imart.DTO.ctHoaDonList;
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
public class ctHoaDonBLL {
     connect conn= new connect();
    private String[] header={"Mã hóa đơn","Mã sản phẩm","Số lượng","Đơn giá","Thành tiền"};
    private String field[] ={"ma_hd","ma_sp","soluong","dongia","thanhtien"};
    ctHoaDonList list=new ctHoaDonList();
    ctHoaDonDAO cthddao= new ctHoaDonDAO();
    public ctHoaDonBLL(){
        super();
        this.conn.connectSQL();
        list.setCthoadon(getCTHoaDonList());
    }
    
    public ArrayList<ctHoaDon> getCTHoaDonList(){
        ResultSet rs = cthddao.getDBCTHoaDon();
        ArrayList<ctHoaDon> ar= new ArrayList();
        try {
            while(rs.next()){
                ctHoaDon cthd= new ctHoaDon();
                cthd.setMa_hd(rs.getString("ma_hd"));
                cthd.setMa_sp(rs.getString("ma_sp"));
                cthd.setSoluong(rs.getInt("soluong"));
                cthd.setDongia((int) rs.getDouble("dongia"));
                cthd.setThanhtien((int)rs.getDouble("thanhtien"));
                ar.add(cthd);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getCTHoaDonList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setCthoadon(getCTHoaDonList());
        for(int i=0; i< this.list.getCthoadon().size() ; i++){
            String ma_hd= list.getCthoadon().get(i).getMa_hd();
            String ma_sp= list.getCthoadon().get(i).getMa_sp();
//            String soluong= list.getCthoadon().get(i).getSoluong();
//            String dongia= list.getCthoadon().get(i).getDongia();
//            String thanhtien= list.getCthoadon().get(i).getThanhtien();
//            Object[] rows={ma_hd,ma_sp,soluong,dongia,thanhtien};
//            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }

    public ctHoaDonList getList() {
        return list;
    }

    public void setList(ctHoaDonList list) {
        this.list = list;
    }
   
}
