/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.hoaDonDAO;
import imart.DTO.hoaDon;
import imart.DTO.hoaDonList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class hoaDonBLL {
    connect conn = new connect();
    private String[] header= {"ID","Nhân viên","Khách hàng","Ngày lập","Tổng tiền","Ghi chú"};
    private String[] field={"id","ma_nv","ma_kh","ngaylap","tongtien","ghichu"};
    hoaDonList list = new hoaDonList();
    hoaDonDAO hddao= new hoaDonDAO();
    
    public hoaDonBLL(){
        super();
        list.setHoadon(getHoaDonList());
    }
    
    public ArrayList<hoaDon> getHoaDonList(){
        this.conn.connectSQL();
        ResultSet rs = hddao.getDBHoaDon();
        ArrayList<hoaDon> ar= new ArrayList();
        try {
            while(rs.next()){
                hoaDon hd= new hoaDon();
                hd.setId(rs.getString("id"));
                hd.setMa_nv(rs.getString("ma_nv"));
                hd.setMa_kh(rs.getString("ma_kh"));
                hd.setNgaylap(rs.getString("ngaylap"));
                hd.setTongtien((int)rs.getDouble("tongtien"));
                hd.setGhichu(rs.getString("ghichu"));
                ar.add(hd);
            }
            this.conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getHoaDonList (line 35)");
            return null;
        } 
    }
    
    //hiển thị full bảng hóa đơn
    public JScrollPane showData(){
        khachHangBLL khbll= new khachHangBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable(){
                @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        table.setRowHeight(25);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setHoadon(getHoaDonList());
        for(int i=0; i< this.list.getHoadon().size() ; i++){
            String mahd= list.getHoadon().get(i).getId();
            String ma_nv= nvbll.getNameFromID(list.getHoadon().get(i).getMa_nv());
            String ma_kh= khbll.getNameByID(list.getHoadon().get(i).getMa_kh());
            String ngaylap= list.getHoadon().get(i).getNgaylap();
            int tong= (int) list.getHoadon().get(i).getTongtien();
            String ghichu= list.getHoadon().get(i).getGhichu();
            Object[] rows={mahd, ma_nv, ma_kh, ngaylap, tong, ghichu};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
    
    public JTable showData(String find){
        khachHangBLL khbll= new khachHangBLL();
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
        for(int i=0; i< this.list.getHoadon().size() ; i++){
            if(this.list.getHoadon().get(i).getId().equalsIgnoreCase(find) || 
               this.list.getHoadon().get(i).getMa_kh().equalsIgnoreCase(find) ||
               this.list.getHoadon().get(i).getMa_nv().equalsIgnoreCase(find)){
                String mahd= list.getHoadon().get(i).getId();
                String ma_nv= nvbll.getNameFromID(list.getHoadon().get(i).getMa_nv());
                String ma_kh= khbll.getNameByID(list.getHoadon().get(i).getMa_kh());
                String ngaylap= list.getHoadon().get(i).getNgaylap();
                int tong= (int) list.getHoadon().get(i).getTongtien();
                String ghichu= list.getHoadon().get(i).getGhichu();
                Object[] rows={mahd, ma_nv, ma_kh, ngaylap, tong, ghichu};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    public String getNewHoaDon(){
        String id = "HD00"+String.valueOf(this.list.getHoadon().size() + 1);
        return id;
    }
    
    public hoaDonList addHoaDon(String id,String ma_nv, String ma_kh, double tongtien, String ghichu){
        hoaDon hd= new hoaDon(id, ma_nv, ma_kh, String.valueOf(java.time.LocalDate.now()), tongtien, ghichu);
        this.list.getHoadon().add(hd);
        return this.list;
    }

    public hoaDonList getList() {
        return list;
    }

    public void setList(hoaDonList list) {
        this.list = list;
    }
    
    public JTable showLichSuMuaHang(String ma_kh){
        JTable tablels= new JTable();
        tablels.setRowHeight(20);
        DefaultTableModel modells= new DefaultTableModel();
        String []lsmua= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên bán"};
        modells.setColumnIdentifiers(lsmua);
        for(int i=0;i<this.list.getHoadon().size();i++){
            if(this.list.getHoadon().get(i).getMa_kh().equals(ma_kh)){
                String ngaytao= this.list.getHoadon().get(i).getNgaylap();
                int tongtien=(int) this.list.getHoadon().get(i).getTongtien();
                String mahd= this.list.getHoadon().get(i).getId();
                String manv= this.list.getHoadon().get(i).getMa_nv();
                Object[] rows={ngaytao,tongtien,mahd,manv};
                modells.addRow(rows);
            }
        }
        tablels.setModel(modells);
        return tablels;
    }  
    
    public JTable showLichSuBanHang(String ma_nv){
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
        khachHangBLL khbll= new khachHangBLL();
        String []hdban= {"Thời gian","Tổng tiền", "Mã hóa đơn","Khách hàng"};
        modells.setColumnIdentifiers(hdban);
        for(int i=0;i<this.list.getHoadon().size();i++){
            if(this.list.getHoadon().get(i).getMa_nv().equals(ma_nv)){
                String ngaytao= this.list.getHoadon().get(i).getNgaylap();
                int tongtien=(int) this.list.getHoadon().get(i).getTongtien();
                String mahd= this.list.getHoadon().get(i).getId();
                String tenkh= khbll.getNameByID(this.list.getHoadon().get(i).getMa_kh());
                Object[] rows={ngaytao,tongtien,mahd,tenkh};
                modells.addRow(rows);
            }
        }
        tablels.setModel(modells);
        return tablels;
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
        khachHangBLL khbll= new khachHangBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        table.setRowHeight(20);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setHoadon(getHoaDonList());
        for(int i=0; i< this.list.getHoadon().size(); i++){
            String mahd= list.getHoadon().get(i).getId();
            String manv= nvbll.getNameFromID(list.getHoadon().get(i).getMa_nv());
            String makh= khbll.getNameByID(list.getHoadon().get(i).getMa_kh());
            String ngaylaphd= list.getHoadon().get(i).getNgaylap();
            int tonghd=(int) list.getHoadon().get(i).getTongtien();
            String ghichu= list.getHoadon().get(i).getGhichu();
            Object[] rows={mahd, manv, makh, ngaylaphd,tonghd, ghichu};
            model.addRow(rows);
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
    
    public String newHoaDon(){
        return "HD00"+ String.valueOf(this.list.getHoadon().size()+1);
    }
    
    public boolean CheckKhoangDay(String dateStart,String dateEnd,String date){
         String[] temp1; temp1 = dateStart.split("/");
        String[] temp2; temp2 = dateEnd.split("/");
        int yearS = Integer.parseInt(temp1[2]);
        int monthS = Integer.parseInt(temp1[1]);
        int dayS = Integer.parseInt(temp1[0]);
        int yearE = Integer.parseInt(temp2[2]);
        int monthE = Integer.parseInt(temp2[1]);
        int dayE = Integer.parseInt(temp2[0]);
        String[] bienlai ;
        bienlai= new String[100];
            String[] mang = date.split("-");
            int year = Integer.parseInt(mang[0]);
            int month = Integer.parseInt(mang[1]);
            int day = Integer.parseInt(mang[2]);
            System.out.print(dayS+" "+monthS+" "+yearS);
            System.out.println("------- ");
            System.out.print(dayE+" "+monthE+" "+yearE);
            System.out.println(" =======");
            
            if(yearS==yearE && year==yearS){
                if(month>monthS && month<monthE){
                    System.out.print(day+" "+month+" "+year);
                    System.out.println(" ");
                    return true;
                    
                }
                else{
                    if(month==monthS){
                        if(monthS==monthE){
                            if(day>=dayS && day<=dayE){
                                System.out.print(day+" 1 "+month+" "+year);
            System.out.println(" ");
                                return true;
                            }
                        }
                        else{
                            if(day>=dayS){
                                System.out.print(day+" 2 "+month+" "+year);
            System.out.println(" ");
                                return true;
                            }
                        }
                    }
                    else if(month==monthE){
                        if(monthS==monthE){
                            if(day>=dayS && day<=dayE){
                                System.out.print(day+" 3 "+month+" "+year);
            System.out.println(" ");
                               return true;
                            }
                        }
                        else{
                            if(day<=dayE){
                                System.out.print(day+" 4 "+month+" "+year);
            System.out.println(" ");
                                return true;
                            }
                        }
                    }
                }
            }
            else{
                if(year>yearS && year<yearE){
                    System.out.print(day+" 5 "+month+" "+year);
            System.out.println(" ");
                    return true;
                }
                else{
                    if(year==yearS || year==yearE){
                        if(year==yearS){
                            if(month>=monthS){
                                if(month>monthS){
                                    System.out.print(day+" 6 "+month+" "+year);
            System.out.println(" ");
                                    return true;
                                }
                                else{
                                    if(day>=dayS){
                                        System.out.print(day+" 7 "+month+" "+year);
            System.out.println(" ");
                                       return true;
                                    }
                                }
                            }
                        }
                        else{
                            if(month<=monthE){
                                if(month<monthE){
                                    System.out.print(day+" 8 "+month+" "+year);
            System.out.println(" ");
                                    return true;
                                }
                                else{
                                    if(day<=dayE){
                                        System.out.print(day+" 9 "+month+" "+year);
            System.out.println(" ");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
}
