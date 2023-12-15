/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.nhaCCapDAO;
import imart.DTO.nhaCCap;
import imart.DTO.nhaCCapList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class nhaCCapBLL {
    connect conn= new connect();
    private String[] header={"ID","Tên nhà cung cấp","Địa chỉ","Điện thoại"};
    private String field[] ={"id","ten_ncc","diachi","dienthoai"};
    nhaCCapList list= new nhaCCapList();
    nhaCCapDAO nccdao= new nhaCCapDAO();
    public nhaCCapBLL(){
        super();
        list.setNcc(getNhaCCapList());
    }
    
    public ArrayList<nhaCCap> getNhaCCapList(){
        this.conn.connectSQL();
        ResultSet rs = nccdao.getDBNhaCungCap();
        ArrayList<nhaCCap> ar= new ArrayList();
        try {
            while(rs.next()){
                nhaCCap ncc= new nhaCCap();
                ncc.setId(rs.getString("id"));
                ncc.setTen_ncc(rs.getString("ten_ncc"));
                ncc.setDiachi(rs.getString("diachi"));
                ncc.setDienthoai(rs.getString("dienthoai"));
                ncc.setStatus(rs.getString("status"));
                ar.add(ncc);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getNhaCCapList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setNcc(getNhaCCapList());
        for(int i=0; i< this.list.getNcc().size() ; i++){
            String id= list.getNcc().get(i).getId();
            String ten_ncc= list.getNcc().get(i).getTen_ncc();
            String diachi= list.getNcc().get(i).getDiachi();
            String dienthoai= list.getNcc().get(i).getDienthoai();
            Object[] rows={id,ten_ncc,diachi,dienthoai};
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
            };
        };
        table.setRowHeight(20);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        list.setNcc(getNhaCCapList());
        for(int i=0; i< this.list.getNcc().size(); i++){
            if(this.list.getNcc().get(i).getStatus().equalsIgnoreCase("on")) {
                String id= list.getNcc().get(i).getId();
                String ten_ncc= list.getNcc().get(i).getTen_ncc();
                String diachi= list.getNcc().get(i).getDiachi();
                String dienthoai= list.getNcc().get(i).getDienthoai();
                Object[] rows={id,ten_ncc,diachi,dienthoai};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }
    
    //hiển thị bảng nhà cung cấp theo mã, tên, số điện thoại
    public JTable showData(String find){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< this.list.getNcc().size() ; i++){
            if((this.list.getNcc().get(i).getId().equalsIgnoreCase(find) || 
                this.list.getNcc().get(i).getTen_ncc().toLowerCase().contains(find.toLowerCase()) ||
                 this.list.getNcc().get(i).getDienthoai().equalsIgnoreCase(find))
                && !this.list.getNcc().get(i).getStatus().equalsIgnoreCase("deleted")){
                String mancc= list.getNcc().get(i).getId();
                String tenncc= list.getNcc().get(i).getTen_ncc();
                String diachincc= list.getNcc().get(i).getDiachi();
                String dienthoaincc= list.getNcc().get(i).getDienthoai();
                Object[] rows={mancc,tenncc,diachincc,dienthoaincc};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    //hiển thị bảng nhà cung cấp theo mã phiếu nhập
    public JTable showDataByPNID(String find){
        phieuNhapBLL pnbll= new phieuNhapBLL();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< pnbll.getList().getPhieunhap().size() ; i++){
            if(pnbll.getList().getPhieunhap().get(i).getId().equalsIgnoreCase(find)){
                for(int a=0;a<this.list.getNcc().size();a++){
                    if(this.list.getNcc().get(a).getId().equals(pnbll.getList().getPhieunhap().get(i).getMa_ncc())
                        && !this.list.getNcc().get(a).getStatus().equalsIgnoreCase("deleted")) {
                        String mancc= this.list.getNcc().get(a).getId();
                        String tenncc= this.list.getNcc().get(a).getTen_ncc();
                        String diachincc= this.list.getNcc().get(a).getDiachi();
                        String dienthoaincc= this.list.getNcc().get(a).getDienthoai();
                        Object[] rows={mancc, tenncc, diachincc,dienthoaincc};
                        model.addRow(rows);
                    }
                }
            }
        }
        table.setModel(model);
        return table;
    }
    
    public int nccLeng(){
        int a=0;
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getStatus().equals("on")){
                a++;
            }
        }
        return a;
    }
    
    public String[] getTenNhaCungCap(){
        String[] listtenncc= new String[nccLeng()];
        for(int a=0;a<nccLeng();){
            for(int i=0;i<list.getNcc().size();i++){
                if(this.list.getNcc().get(i).getStatus().equals("on")){
                    listtenncc[a]= list.getNcc().get(i).getTen_ncc();
                    a++;
                }
            }
        }
        return listtenncc;
    }
    
    public String getMaFromName(String name){
        String id= null;
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getTen_ncc().trim().equalsIgnoreCase(name)) {
                id= this.list.getNcc().get(i).getId();
            }
        }
        return id;
    }
    
    public String getNameByPhone(String phone){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getDienthoai().equals(phone)){
                return this.list.getNcc().get(i).getTen_ncc();
            }
        }
        return "Không tồn tại";
    }
    
    public String getNameByID(String id){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getId().equals(id)){
                return this.list.getNcc().get(i).getTen_ncc();
            }
        }
        return null;
    }
    
    public String getPhoneByPhone(String phone){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getDienthoai().equals(phone)){
                return this.list.getNcc().get(i).getDienthoai();
            }
        }
        return null;
    }
    
    public String getDiaChiByPhone(String phone){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getDienthoai().equals(phone)){
                return this.list.getNcc().get(i).getDiachi();
            }
        }
        return null;
    }
    
    public String getSDTByName(String name){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getTen_ncc().equalsIgnoreCase(name)){
                return this.list.getNcc().get(i).getDienthoai();
            }
        }
        return "Không tồn tại";
    }
    
    public String getDiaChiByName(String name){
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getTen_ncc().equalsIgnoreCase(name)){
                return this.list.getNcc().get(i).getDiachi();
            }
        }
        return "Không tồn tại";
    }

    public boolean checkTonTaiSDT(String dienthoai, String id){
        int dem=0;
        for(int i=0;i<this.list.getNcc().size();i++){
            if(this.list.getNcc().get(i).getDienthoai().trim().equals(dienthoai) && !this.list.getNcc().get(i).getId().trim().equals(id)){
                dem++;
            }
        }
        if(dem==0){
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Không hợp lệ, số điện thoại đã tồn tại!!" ,"Thông báo",2);
            return false;
        }
    }
    
    public nhaCCapList getList() {
        return list;
    }

    public void setList(nhaCCapList list) {
        this.list = list;
    }
    
    public static void main(String[] args) {
        nhaCCapBLL b= new nhaCCapBLL();
        System.out.println(b.nccLeng());
    }
}
