/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DTO.loaiHang;
import imart.DTO.loaiHangList;
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
public class loaiHangBLL {
    connect conn= new connect();
    private String[] header={"ID","Tên loại"};
    private String field[] ={"id","ten_loai"};
    public loaiHangList list= new loaiHangList();
    public loaiHangBLL(){
        super();
        list.setLoaiHang(getLoaiHangList("select * from loai_hang"));
    }
    
    public ArrayList<loaiHang> getLoaiHangList(String statement){
        this.conn.connectSQL();
        ResultSet rs = this.conn.dataSQL(statement);
        ArrayList<loaiHang> ar= new ArrayList();
        try {
            while(rs.next()){
                loaiHang lh= new loaiHang();
                lh.setId(rs.getInt("id"));
                lh.setTen_loai(rs.getString("ten_loai"));
                ar.add(lh);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getLoaiHangList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setLoaiHang(getLoaiHangList("select * from loai_hang"));
        for(int i=0; i< this.list.getLoaiHang().size() ; i++){
            int id= list.getLoaiHang().get(i).getId();
            String ten_loai= list.getLoaiHang().get(i).getTen_loai();
            Object[] rows={id,ten_loai};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
    
    public String getNameByID(String id){
        for(int i=0;i<this.list.getLoaiHang().size();i++){
            if(String.valueOf(this.list.getLoaiHang().get(i).getId()).equals(id)){
                return this.list.getLoaiHang().get(i).getTen_loai();
            }
        }
        return null;
    }
    
    public String getMaFromName(String name){
        String id= null;
        for(int i=0;i<this.list.getLoaiHang().size();i++){
            if(this.list.getLoaiHang().get(i).getTen_loai().trim().equals(name)) {
                id= String.valueOf(this.list.getLoaiHang().get(i).getId());
            }
        }
        return id;
    }
    
    public String[] getTenLoai(){
        String[] listtenloai= new String[list.getLoaiHang().size()+1];
        listtenloai[0]= "--Tất cả--";
        for(int i=0;i<list.getLoaiHang().size();i++){
            listtenloai[i+1]= list.getLoaiHang().get(i).getTen_loai();
        }
        return listtenloai;
    }
    
    public int slLoaiHang(){
        return this.list.getLoaiHang().size()+1;
    }
}
