/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.ctPhieuNhapDAO;
import imart.DTO.ctPhieuNhap;
import imart.DTO.ctPhieuNhapList;
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
public class ctPhieuNhapBLL {
    connect conn= new connect();
    private String[] header={"Mã phiếu nhập","Mã sản phẩm","Đơn giá","Số lượng","Thành tiền"};
    private String field[] ={"ma_pn","ma_sp","dongia","soluong","thanhtien"};
    ctPhieuNhapList list= new ctPhieuNhapList();
    ctPhieuNhapDAO ctpndao= new ctPhieuNhapDAO();
    
    public ctPhieuNhapBLL(){
        super();
        list.setCtphieunhap(getCTPhieuNhapList());
    }
    
    public ArrayList<ctPhieuNhap> getCTPhieuNhapList(){
        this.conn.connectSQL();
        ResultSet rs = ctpndao.getDBCTPhieuNhap();
        ArrayList<ctPhieuNhap> ar = new ArrayList();
        try {
            while(rs.next()){
                ctPhieuNhap ctpn= new ctPhieuNhap();
                ctpn.setMa_pn(rs.getString("ma_pn"));
                ctpn.setMa_sp(rs.getString("ma_sp"));
                ctpn.setDongia((int)rs.getDouble("dongia"));
                ctpn.setSoluong(rs.getInt("soluong"));
                ctpn.setThanhtien((int)rs.getDouble("thanhtien"));
                ar.add(ctpn);
            }
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getctPhieuNhapList (line 33)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setCtphieunhap(getCTPhieuNhapList());
        for(int i=0; i< this.list.getCtphieunhap().size() ; i++){
            String ma_pn= list.getCtphieunhap().get(i).getMa_pn();
            String ma_sp= list.getCtphieunhap().get(i).getMa_sp();
//            String dongia= list.getCtphieunhap().get(i).getDongia();
//            String soluong= list.getCtphieunhap().get(i).getSoluong();
//            String thanhtien= list.getCtphieunhap().get(i).getThanhtien();
//            Object[] rows={ma_pn,ma_sp,dongia,soluong,thanhtien};
//            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }

//    public JTable getTable(){
//        JTable table= new JTable(){
//                @Override
//            public boolean isCellEditable(int row, int column) {                
//                switch (column) {
//                    default:
//                        return false;
//                 }              
//            }
//        };
//        khachHangBLL khbll= new khachHangBLL();
//        nhanVienBLL nvbll= new nhanVienBLL();
//        table.setRowHeight(20);
//        DefaultTableModel model= new DefaultTableModel();
//        model.setColumnIdentifiers(header);
//        this.list.setCtphieunhap(ctphieunhap);
//        for(int i=0; i< this.list.getCtphieunhap().size(); i++){
//            String mahd= list.getHoadon().get(i).getId();
//            String manv= nvbll.getNameFromID(list.getHoadon().get(i).getMa_nv());
//            String makh= khbll.getNameByID(list.getHoadon().get(i).getMa_kh());
//            String ngaylaphd= list.getHoadon().get(i).getNgaylap();
//            int tonghd=(int) list.getHoadon().get(i).getTongtien();
//            String ghichu= list.getHoadon().get(i).getGhichu();
//            Object[] rows={mahd, manv, makh, ngaylaphd,tonghd, ghichu};
//            model.addRow(rows);
//        }
//        table.setModel(model);
//        return table;
//    }
    
    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public ctPhieuNhapList getList() {
        return list;
    }

    public void setList(ctPhieuNhapList list) {
        this.list = list;
    }
}
