/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DTO.khuyenMai;
import imart.DTO.khuyenMaiList;
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
public class khuyenMaiBLL {
    connect conn= new connect();
    private String[] header={"ID","Ngày bắt đầu","Ngày kết thúc"};
    private String field[] ={"id","ngaybd","ngaykt"};
    khuyenMaiList list;
    public khuyenMaiBLL(){
        super();
        list= new khuyenMaiList();
    }
    
    public ArrayList<khuyenMai> getKhuyenMaiList(String statement){
        this.conn.connectSQL();
        ResultSet rs = this.conn.dataSQL(statement);
        ArrayList<khuyenMai> ar= new ArrayList();
        try {
            while(rs.next()){
                khuyenMai km= new khuyenMai();
                km.setId(rs.getString("id"));
                km.setNgaybd(rs.getString("ngaybd"));
                km.setNgaykt(rs.getString("ngaykt"));
                ar.add(km);
            }
            this.conn.connectSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getKhuyenMaiList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setKhuyenMai(getKhuyenMaiList("select * from khuyen_mai"));
        for(int i=0; i< this.list.getKhuyenMai().size() ; i++){
            String id= list.getKhuyenMai().get(i).getId();
            String ngaybd= list.getKhuyenMai().get(i).getNgaybd();
            String ngaykt= list.getKhuyenMai().get(i).getNgaykt();
            Object[] rows={id,ngaybd,ngaykt};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
}
