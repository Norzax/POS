/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DTO.ctKhuyenMai;
import imart.DTO.ctKhuyenMaiList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GIA DUC
 */
public class ctKhuyenMaiBLL {
    connect conn= new connect();
    private String[] header={"ID","Họ","Tên","Địa chỉ","Điện thoại"};
    private String field[] ={"id","ho","ten","diachi","dienthoai"};
    ctKhuyenMaiList list;
    public ctKhuyenMaiBLL(){
        super();
        //this.conn.connectSQL();
        list= new ctKhuyenMaiList();
    }
    
    public ArrayList<ctKhuyenMai> getCTKhuyenMaiList(String statement){
        ResultSet rs = this.conn.dataSQL(statement);
        ArrayList<ctKhuyenMai> ar= new ArrayList();
        try {
            while(rs.next()){
                ctKhuyenMai ctkm= new ctKhuyenMai();
                ctkm.setMa_km(rs.getString("ma_km"));
                ctkm.setMa_sp(rs.getString("ma_sp"));
                ctkm.setPhantram(rs.getDouble("%"));
                ar.add(ctkm);
            }
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getCTKhuyenMaiList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setCtkhuyenmai(getCTKhuyenMaiList("select * from ct_khuyen_mai"));
        for(int i=0; i< this.list.getCtkhuyenmai().size() ; i++){
            String ma_km= list.getCtkhuyenmai().get(i).getMa_km();
            String ma_sp= list.getCtkhuyenmai().get(i).getMa_sp();
            Double phantram= list.getCtkhuyenmai().get(i).getPhantram();
            Object[] rows={ma_km,ma_sp,phantram};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
}
