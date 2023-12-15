/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.sanPhamDAO;
import imart.DTO.sanPham;
import imart.DTO.sanPhamList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class sanPhamBLL {
        connect conn= new connect();
        private String[] header={"Mã sản phẩm","Tên sản phẩm","NSX","HSD","Đơn giá","Số lượng","Mã loại"};
        private String field[] ={"id","tensp","nsx","hsd","dongia","soluong","ma_loai"};
        sanPhamList list = new sanPhamList();
        sanPhamDAO spdao= new sanPhamDAO();
    public sanPhamBLL(){
        super();
        list.setSanpham(getSanPhamList());
    }
    
    /**
     * ham nay de load du lieu tu
     * database vao array list
     */
    public ArrayList<sanPham> getSanPhamList(){
        conn.connectSQL();
        ResultSet rs = spdao.getDBSanPham();
        ArrayList<sanPham> ar= new ArrayList();
        try {
            while(rs.next()){
                sanPham sp= new sanPham();
                sp.setId(rs.getString("id"));
                sp.setTensp(rs.getString("tensp"));
                sp.setNsx(rs.getString("nsx"));
                sp.setHsd(rs.getString("hsd"));
                sp.setDongia((int)rs.getDouble("dongia"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setMa_loai(rs.getString("ma_loai"));
                sp.setStatus(rs.getString("status"));
                ar.add(sp);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getKhachHangList (line 35)");
        }
        return null;
    }
    
    public String[] getHeader(){
        return header;
    }

    public sanPhamList getList() {
        return list;
    }

    public void setList() {
        list.setSanpham(getSanPhamList());
    }
    
    /**
     * ham nay add arraylist 
     * vao JTable de hien thi tren GUI
     */
    
    //hiển thị bảng sản phẩm theo mã 
    public JTable showData(String ma){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< findSPByText(ma).size() ; i++){
            String masp= findSPByText(ma).get(i).getId();
            String tensp= findSPByText(ma).get(i).getTensp();
            String nsxsp= findSPByText(ma).get(i).getNsx();
            String hsdsp= findSPByText(ma).get(i).getHsd();
            Double dongiasp= findSPByText(ma).get(i).getDongia();
            int soluongsp= findSPByText(ma).get(i).getSoluong();
            String maloaisp= findSPByText(ma).get(i).getMa_loai();
            Object[] rows={masp,tensp,nsxsp,hsdsp,dongiasp,soluongsp,maloaisp};
            model.addRow(rows);
        }
        table.setModel(model);
        return table;
    }
    
    public JTable showData2(String find){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< this.list.getSanpham().size(); i++){
            if((this.list.getSanpham().get(i).getId().equalsIgnoreCase(find) || this.list.getSanpham().get(i).getTensp().equalsIgnoreCase(find) ||
               this.list.getSanpham().get(i).getMa_loai().equalsIgnoreCase(find)) && this.list.getSanpham().get(i).getStatus().equals("on")){
                String masp= this.list.getSanpham().get(i).getId();
                String tensp= this.list.getSanpham().get(i).getTensp();
                String nsxsp= this.list.getSanpham().get(i).getNsx();
                String hsdsp= this.list.getSanpham().get(i).getHsd();
                Double dongiasp= this.list.getSanpham().get(i).getDongia();
                int soluongsp= this.list.getSanpham().get(i).getSoluong();
                String maloaisp= this.list.getSanpham().get(i).getMa_loai();
                Object[] rows={masp,tensp,nsxsp,hsdsp,dongiasp,soluongsp,maloaisp};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    //hiển thị bảng sản phẩm trong bán hàng (ít dữ liệu hơn)
    public JTable showDataByMaLoai0(){
        DefaultTableModel model= new DefaultTableModel();
        JTable table= new JTable(){
                @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        model.setColumnIdentifiers(header);
        for(int i=0; i< this.list.getSanpham().size() ; i++){
            String masp= list.getSanpham().get(i).getId();
            String tensp= list.getSanpham().get(i).getTensp();
            String nsxsp= list.getSanpham().get(i).getNsx();
            String hsdsp= list.getSanpham().get(i).getHsd();
            double dongiasp= list.getSanpham().get(i).getDongia();
            int soluongsp= list.getSanpham().get(i).getSoluong();
            String maloaisp= list.getSanpham().get(i).getMa_loai();
            Object[] rows={masp,tensp,nsxsp,hsdsp,dongiasp,soluongsp,maloaisp};
            model.addRow(rows);
        }
        table.setModel(model);
        return table;
    }
    
    //tìm sản phẩm bằng tên (nhập tay từng kí tự)
    public ArrayList<sanPham> findSPByText(String findtx){
        ArrayList<sanPham> result = new ArrayList<>();
        for(int i=0;i<list.getSanpham().size();i++) {
            if(list.getSanpham().get(i).getTensp().toLowerCase().contains(findtx)==true){
                result.add(list.getSanpham().get(i));
            }
        }
        return result;
    }
    
    //hiển thị bảng sản phẩm theo mã loại (dùng combobox)
    public JTable showDataByMaLoai(String id_loai){
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        for(int i=0; i< findSPByIDLoai(id_loai).size() ; i++){
            String masp= findSPByIDLoai(id_loai).get(i).getId();
            String tensp= findSPByIDLoai(id_loai).get(i).getTensp();
            String nsxsp= findSPByIDLoai(id_loai).get(i).getNsx();
            String hsdsp= findSPByIDLoai(id_loai).get(i).getHsd();
            double dongiasp= findSPByIDLoai(id_loai).get(i).getDongia();
            int soluongsp= findSPByIDLoai(id_loai).get(i).getSoluong();
            String maloaisp= findSPByIDLoai(id_loai).get(i).getMa_loai();
            Object[] rows={masp, tensp,nsxsp,hsdsp,dongiasp,soluongsp,maloaisp};
            model.addRow(rows);
        }
        table.setModel(model);
        return table;
    }
    
    
    public ArrayList<sanPham> findSP(String ma){
        ArrayList<sanPham> result = new ArrayList<>();
        list.getSanpham().stream().filter((nv) -> (nv.getId().contains(ma))).forEachOrdered((nv) -> {
            result.add(nv);
        });
        return result;
    }
    
    public ArrayList<sanPham> findSPByIDLoai(String findtype){
        ArrayList<sanPham> result = new ArrayList<>();
        for(int i=0;i< list.getSanpham().size();i++) {
            if(list.getSanpham().get(i).getMa_loai().equals(findtype)==true){
                result.add(list.getSanpham().get(i));
            }
        }
        return result;
    }
    
    public void selling(String id, int soluong){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)){
                int newsoluong = this.list.getSanpham().get(i).getSoluong() - soluong;
                this.list.getSanpham().get(i).setSoluong(newsoluong);
            }
        }
    }
    
    public void unSelling(String id, int soluong){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)){
                int newsoluong = this.list.getSanpham().get(i).getSoluong() + soluong;
                this.list.getSanpham().get(i).setSoluong(newsoluong);
            }
        }
    }
    
    public void importGoods(String id, int soluong){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)){
                int newsoluong = this.list.getSanpham().get(i).getSoluong() + soluong;
                this.list.getSanpham().get(i).setSoluong(newsoluong);
            }
        }
    }
    
    public void removeGoods(String id, int soluong){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)){
                int newsoluong = this.list.getSanpham().get(i).getSoluong() - soluong;
                this.list.getSanpham().get(i).setSoluong(newsoluong);
            }
        }
    }
   
    public boolean kTSpTonTai(String id, String dongia, String soluong){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getDongia()==Double.parseDouble(dongia) && this.list.getSanpham().get(i).getSoluong() <= 0 ||  
               this.list.getSanpham().get(i).getDongia()==Double.parseDouble(dongia) && this.list.getSanpham().get(i).getSoluong() < Integer.parseInt(soluong)) {
                JOptionPane.showMessageDialog(null, "Sản phẩm không đủ!","Thông báo",2);
                return false;
            } else if( this.list.getSanpham().get(i).getDongia()== Double.parseDouble(dongia) && Integer.parseInt(soluong) <= 0 ) {
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ!","Thông báo",2);    
                return false;
            } else if(this.list.getSanpham().get(i).getId().equals(id)) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại!","Thông báo",2);
        return false;
    }
    
    public String getSPNameByID(String id){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)){
                return this.list.getSanpham().get(i).getTensp();
            }
        }
        return null;
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
        table.setRowHeight(20);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setSanpham(getSanPhamList());
        for(int i=0; i< this.list.getSanpham().size(); i++){
            if(this.list.getSanpham().get(i).getStatus().equals("on")) {
                String masp= list.getSanpham().get(i).getId();
                String tensp= list.getSanpham().get(i).getTensp();
                String nsx= list.getSanpham().get(i).getNsx();
                String hsd= list.getSanpham().get(i).getHsd();
                double dongiasp= list.getSanpham().get(i).getDongia();
                int soluongsp= list.getSanpham().get(i).getSoluong();
                String maloaisp= list.getSanpham().get(i).getMa_loai();
                Object[] rows={masp, tensp, nsx,hsd, dongiasp, soluongsp, maloaisp};
                model.addRow(rows);
            }
        }
        table.setModel(model);
        return table;
    }
    
    public ArrayList timsp(String sp){
        ArrayList<sanPham> a= new ArrayList<>();
        for(int i=0;i<list.getSanpham().size();i++){
            int k=-1, l=-1;
            k= list.getSanpham().get(i).getId().indexOf(sp);
            l= list.getSanpham().get(i).getTensp().indexOf(sp);
            if(k>=0 || l>=0){
                a.add(list.getSanpham().get(i));
            }
        }
        return a;
    }
    
    public String getNameFromID(String id){
        String name=null;
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getId().equals(id)) {
                name= this.list.getSanpham().get(i).getTensp().trim();
            }
        }
        System.out.println(name);
        return name;
    }
    
    public String[] getThongTinMaLoai(String id){
        String tl=null;
        int ml=1;
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getMa_loai().equals(id)){
                ml++;
                if(this.list.getSanpham().get(i).getMa_loai().equals("12") || this.list.getSanpham().get(i).getMa_loai().equals("2") ||
                   this.list.getSanpham().get(i).getMa_loai().equals("8") || this.list.getSanpham().get(i).getMa_loai().equals("3")){
                    String newid= this.list.getSanpham().get(i).getId();
                    tl= newid.substring(0, 3);
                } else {
                    String newid= this.list.getSanpham().get(i).getId();
                    tl= newid.substring(0, 2);
                }
            }
        }
        String [] a= {tl , String.valueOf(ml)};
        return a;
    }
     
    public boolean kiemTraSPTonTai(String name){
        for(int i=0;i<this.list.getSanpham().size();i++){
            if(this.list.getSanpham().get(i).getTensp().equalsIgnoreCase(name)  && this.list.getSanpham().get(i).getStatus().equals("on")){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String newid= "NV02";
        StringBuilder sb= new StringBuilder(newid);
        System.out.println(newid.substring(0, 2));
    }
}
