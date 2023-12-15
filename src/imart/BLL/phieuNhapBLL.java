/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.phieuNhapDAO;
import imart.DTO.phieuNhap;
import imart.DTO.phieuNhapList;
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
public class phieuNhapBLL {
    connect conn= new connect();
    private String[] header={"ID","Nhân viên","Nhà cung cấp","Ngày lập","Tổng tiền"};
    private String field[] ={"id","ma_nv"," ma_ncc","ngaylap","tongtien"};
    phieuNhapList list= new phieuNhapList();
    phieuNhapDAO pndao= new phieuNhapDAO();
    public phieuNhapBLL(){
        super();
        list.setPhieunhap(getPhieuNhapList());
    }
    
    public ArrayList<phieuNhap> getPhieuNhapList(){
        this.conn.connectSQL();
        ResultSet rs = pndao.getDBPhieuNhap();
        ArrayList<phieuNhap> ar= new ArrayList();
        try {
            while(rs.next()){
                phieuNhap pn= new phieuNhap();
                pn.setId(rs.getString("id"));
                pn.setMa_nv(rs.getString("ma_nv"));
                pn.setMa_ncc(rs.getString("ma_ncc"));
                pn.setNgaylap(rs.getString("ngaylap"));
                pn.setTongtien(rs.getDouble("tongtien"));
                pn.setGhichu(rs.getString("ghichu"));
                ar.add(pn);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getPhieuNhapList (line 36)");
        }
        return null;
    }
    
    public JTable showLichSuNhapHang(String ma_ncc){
        JTable tablels= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            };
        };
        tablels.setRowHeight(20);
        DefaultTableModel modells= new DefaultTableModel();
        nhaCCapBLL nccbll= new nhaCCapBLL();
        String []hdnhap= {"Thời gian","Tổng tiền", "Mã phiếu nhập","Nhà cung cấp"};
        modells.setColumnIdentifiers(hdnhap);
        for(int i=0;i<this.list.getPhieunhap().size();i++){
            if(this.list.getPhieunhap().get(i).getMa_ncc().equals(ma_ncc)){
                String ngaytao= this.list.getPhieunhap().get(i).getNgaylap();
                int tongtien=(int) this.list.getPhieunhap().get(i).getTongtien();
                String mapn= this.list.getPhieunhap().get(i).getId();
                String tenncc= nccbll.getNameByID(this.list.getPhieunhap().get(i).getMa_ncc());
                Object[] rows={ngaytao,tongtien,mapn,tenncc};
                modells.addRow(rows);
            }
        }
        tablels.setModel(modells);
        return tablels;
    } 
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setPhieunhap(getPhieuNhapList());
        for(int i=0; i< this.list.getPhieunhap().size() ; i++){
            String id= list.getPhieunhap().get(i).getId();
            String ma_nv= list.getPhieunhap().get(i).getMa_nv();
            String ma_ncc= list.getPhieunhap().get(i).getMa_ncc();
            String ngaylap= list.getPhieunhap().get(i).getNgaylap();
            double tongtien= list.getPhieunhap().get(i).getTongtien();
            Object[] rows={id,ma_nv,ma_ncc,ngaylap,tongtien};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
    
    public JTable getTable(){
        JTable table= new JTable(){
                @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        nhaCCapBLL nccbll= new nhaCCapBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        table.setRowHeight(20);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setPhieunhap(getPhieuNhapList());
        for(int i=0; i< this.list.getPhieunhap().size(); i++){
            String mahd= list.getPhieunhap().get(i).getId();
            String manv= nvbll.getNameFromID(list.getPhieunhap().get(i).getMa_nv());
            String mancc= nccbll.getNameByID(list.getPhieunhap().get(i).getMa_ncc());
            String ngaylaphd= list.getPhieunhap().get(i).getNgaylap();
            int tonghd=(int) list.getPhieunhap().get(i).getTongtien();
            String ghichu= list.getPhieunhap().get(i).getGhichu();
            Object[] rows={mahd, manv, mancc, ngaylaphd,tonghd, ghichu};
            model.addRow(rows);
        }
        table.setModel(model);
        return table;
    }

    public phieuNhapList getList() {
        return list;
    }

    public void setList(phieuNhapList list) {
        this.list = list;
    }
    
    public String getNewPhieuNhap(){
        String id = "PN00"+String.valueOf(this.list.getPhieunhap().size() + 1);
        return id;
    }
    
    public JTable showData(String find){
        nhaCCapBLL nccbll= new nhaCCapBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        JTable table= new JTable(){
                @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< this.list.getPhieunhap().size() ; i++){
            if(this.list.getPhieunhap().get(i).getId().equalsIgnoreCase(find) || 
               this.list.getPhieunhap().get(i).getMa_ncc().equalsIgnoreCase(find) ||
               this.list.getPhieunhap().get(i).getMa_nv().equalsIgnoreCase(find)){
                String mahd= list.getPhieunhap().get(i).getId();
                String ma_nv= nvbll.getNameFromID(list.getPhieunhap().get(i).getMa_nv());
                String ma_ncc= nccbll.getNameByID(list.getPhieunhap().get(i).getMa_ncc());
                String ngaylap= list.getPhieunhap().get(i).getNgaylap();
                int tong= (int) list.getPhieunhap().get(i).getTongtien();
                String ghichu= list.getPhieunhap().get(i).getGhichu();
                Object[] rows={mahd, ma_nv, ma_ncc, ngaylap, tong, ghichu};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
}
