/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.khachHangDAO;
import imart.DTO.khachHang;
import imart.DTO.khachHangList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class khachHangBLL{
    connect conn= new connect();
    private String[] header={"ID","Họ","Tên","Địa chỉ","Điện thoại"};
    private String field[] ={"id","ho","ten","diachi","dienthoai"};
    khachHangList list= new khachHangList();
    khachHangDAO khdao= new khachHangDAO();
    hoaDonBLL hdbll= new hoaDonBLL();
    
    public khachHangBLL(){
        super();
        list.setKhachhang(getKhachHangList());
    }
    
    public ArrayList<khachHang> getKhachHangList(){
        ResultSet rs = khdao.getDBKhachHang();
        ArrayList<khachHang> ar= new ArrayList();
        try {
            while(rs.next()){
                khachHang kh= new khachHang();
                kh.setId(rs.getString("id"));
                kh.setHo(rs.getString("ho"));
                kh.setTen(rs.getString("ten"));
                kh.setDiachi(rs.getString("diachi"));
                kh.setDienthoai(rs.getString("sodienthoai"));
                kh.setStatus(rs.getString("status"));
                ar.add(kh);
            }
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getKhachHangList (line 33)");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {};
        } 
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setKhachhang(getKhachHangList());
        for(int i=1; i< this.list.getKhachhang().size() ; i++){
            String makh= list.getKhachhang().get(i).getId();
            String hokh= list.getKhachhang().get(i).getHo();
            String tenkh= list.getKhachhang().get(i).getTen();
            String diachikh= list.getKhachhang().get(i).getDiachi();
            String dienthoaikh= list.getKhachhang().get(i).getDienthoai();
            Object[] rows={makh,hokh,tenkh,diachikh,dienthoaikh};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }
    
    //hiển thị bảng khách hàng theo mã, tên, số điện thoại
    public JTable showData(String find){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< this.list.getKhachhang().size() ; i++){
            if((this.list.getKhachhang().get(i).getId().equalsIgnoreCase(find) || 
                (this.list.getKhachhang().get(i).getHo()+" "+this.list.getKhachhang().get(i).getTen()).equalsIgnoreCase(find) ||
                 this.list.getKhachhang().get(i).getDienthoai().equalsIgnoreCase(find)) && 
                 !this.getList().getKhachhang().get(i).getStatus().equalsIgnoreCase("deleted")){
                String makh= this.list.getKhachhang().get(i).getId();
                String hokh= this.list.getKhachhang().get(i).getHo();
                String tenkh= this.list.getKhachhang().get(i).getTen();
                String diachikh= this.list.getKhachhang().get(i).getDiachi();
                String dienthoaikh= this.list.getKhachhang().get(i).getDienthoai();
                Object[] rows={makh, hokh, tenkh,diachikh,dienthoaikh};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    
    //hiển thị bảng khách hàng theo mã hóa đơn
    public JTable showDataByHDID(String find){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< hdbll.getList().getHoadon().size() ; i++){
            if(hdbll.getList().getHoadon().get(i).getId().equalsIgnoreCase(find)){
                for(int a=0;a<this.list.getKhachhang().size();a++){
                    if(this.list.getKhachhang().get(a).getId().equals(hdbll.getList().getHoadon().get(i).getMa_kh())
                       && !this.getList().getKhachhang().get(a).getStatus().equalsIgnoreCase("deleted")) {
                        String makh= this.list.getKhachhang().get(a).getId();
                        String hokh= this.list.getKhachhang().get(a).getHo();
                        String tenkh= this.list.getKhachhang().get(a).getTen();
                        String diachikh= this.list.getKhachhang().get(a).getDiachi();
                        String dienthoaikh= this.list.getKhachhang().get(a).getDienthoai();
                        Object[] rows={makh, hokh, tenkh,diachikh,dienthoaikh};
                        model.addRow(rows);
                    }
                }
            }
        }
        table.setModel(model);
        return table;
    }
    
    //hiển thị bảng khách hàng theo mã nhân viên tạo hóa đơn
    public JTable showDataByNVBillCreator(String find){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        System.out.println(hdbll.getList().getHoadon().size());
        for(int i=0; i< hdbll.getList().getHoadon().size() ; i++){
            if(hdbll.getList().getHoadon().get(i).getMa_nv().equalsIgnoreCase(find)){
                for(int a=0;a<this.list.getKhachhang().size();a++){
                    if(this.list.getKhachhang().get(a).getId().equals(hdbll.getList().getHoadon().get(i).getMa_kh())
                       && !this.getList().getKhachhang().get(a).getStatus().equalsIgnoreCase("deleted")) {
                        String makh= this.list.getKhachhang().get(a).getId();
                        String hokh= this.list.getKhachhang().get(a).getHo();
                        String tenkh= this.list.getKhachhang().get(a).getTen();
                        String diachikh= this.list.getKhachhang().get(a).getDiachi();
                        String dienthoaikh= this.list.getKhachhang().get(a).getDienthoai();
                        Object[] rows={makh, hokh, tenkh,diachikh,dienthoaikh};
                        model.addRow(rows);
                    }
                }
            }
        }
        table.setModel(model);
        return table;
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
        this.list.setKhachhang(getKhachHangList());
        for(int i=1; i< this.list.getKhachhang().size() ; i++){
            if(this.getList().getKhachhang().get(i).getStatus().equalsIgnoreCase("on") || this.getList().getKhachhang().get(i).getStatus().equalsIgnoreCase("unchange")) {
                String makh= list.getKhachhang().get(i).getId();
                String hokh= list.getKhachhang().get(i).getHo();
                String tenkh= list.getKhachhang().get(i).getTen();
                String diachikh= list.getKhachhang().get(i).getDiachi();
                String dienthoaikh= list.getKhachhang().get(i).getDienthoai();
                Object[] rows={makh,hokh,tenkh,diachikh,dienthoaikh};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    public JTable getTable2(){
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
        this.list.setKhachhang(getKhachHangList());
        for(int i=0; i< this.list.getKhachhang().size() ; i++){
            if(this.getList().getKhachhang().get(i).getStatus().equalsIgnoreCase("on") || this.getList().getKhachhang().get(i).getStatus().equalsIgnoreCase("unchange")) {
                String makh= list.getKhachhang().get(i).getId();
                String hokh= list.getKhachhang().get(i).getHo();
                String tenkh= list.getKhachhang().get(i).getTen();
                String diachikh= list.getKhachhang().get(i).getDiachi();
                String dienthoaikh= list.getKhachhang().get(i).getDienthoai();
                Object[] rows={makh,hokh,tenkh,diachikh,dienthoaikh};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    public int khLeng(){
        int a=0;
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getStatus().equals("on") || this.list.getKhachhang().get(i).getStatus().equals("unchange")){
                a++;
            }
        }
        return a;
    }
    
    public String[] getTenKhachHang(){
        String[] listtenkh= new String[khLeng()];
        for(int a=0;a<khLeng();){
            for(int i=0;i<list.getKhachhang().size();i++){
                if(this.list.getKhachhang().get(i).getStatus().equals("on") || this.list.getKhachhang().get(i).getStatus().equals("unchange")){
                    listtenkh[a]= list.getKhachhang().get(i).getHo()+" "+list.getKhachhang().get(i).getTen();
                    a++;
                }
            }
        }
        return listtenkh;
    }
    
    public String getMaFromName(String name){
        String id= null;
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if((this.list.getKhachhang().get(i).getHo().trim()+" "+this.list.getKhachhang().get(i).getTen().trim()).equalsIgnoreCase(name)) {
                id= this.list.getKhachhang().get(i).getId();
            }
        }
        return id;
    }
    
    public String getNameByPhone(String phone){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getDienthoai().equals(phone)){
                return this.list.getKhachhang().get(i).getHo()+" "+this.list.getKhachhang().get(i).getTen();
            }
        }
        return "Không tồn tại";
    }
    
    public String getNameByID(String id){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getId().equals(id)){
                return this.list.getKhachhang().get(i).getHo()+" "+this.list.getKhachhang().get(i).getTen();
            }
        }
        return null;
    }
    
    public String getDiaChiByPhone(String phone){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getDienthoai().equals(phone)){
                return this.list.getKhachhang().get(i).getDiachi();
            }
        }
        return null;
    }
    
    public String getSDTByName(String name){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if((this.list.getKhachhang().get(i).getHo()+" "+this.list.getKhachhang().get(i).getTen()).equalsIgnoreCase(name)){
                return this.list.getKhachhang().get(i).getDienthoai();
            }
        }
        return "Không tồn tại";
    }
    
    public String getDiaChiByName(String name){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if((this.list.getKhachhang().get(i).getHo()+" "+this.list.getKhachhang().get(i).getTen()).equalsIgnoreCase(name)){
                return this.list.getKhachhang().get(i).getDiachi();
            }
        }
        return "Không tồn tại";
    }

    public khachHangList getList() {
        return list;
    }

    public void setList(khachHangList list) {
        this.list = list;
    }
    
//    public boolean checkDinhDangSDT(String dienthoai){
//        String pta= "1234567891";
//        if(dienthoai.trim().matches(pta)){
//            System.out.println("So dt hop ly");
//            return true;
//        } else{
//            System.out.println("so dien thoai khong hop ly");
//            return false;
//        }
//    }
    
    public boolean checkTonTaiSDT(String dienthoai, String id){
        int dem=0;
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getDienthoai().trim().equals(dienthoai) && !this.list.getKhachhang().get(i).getId().trim().equals(id)){
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
    
    public String getStatusFromID(String id){
        for(int i=0;i<this.list.getKhachhang().size();i++){
            if(this.list.getKhachhang().get(i).getId().equalsIgnoreCase(id))
                return this.list.getKhachhang().get(i).getStatus(); 
        }
        return null;
    }
    
    public static void main(String[] args) {
        khachHangBLL l= new khachHangBLL();
        System.out.println(l.khLeng());
    }
}
