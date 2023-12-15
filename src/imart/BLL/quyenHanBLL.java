/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.connect;
import imart.DAO.quyenHanDAO;
import imart.DTO.quyenHan;
import imart.DTO.quyenHanList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class quyenHanBLL {
    connect conn= new connect();
    private String[] header={"Nhân viên","Chức vụ","Quản lý nhân viên","Xem danh sách phiếu nhập","Quản lý nhà cung cấp","Phân quyền","Xem danh sách hóa đơn","Nhập hàng","Bán hàng","Thống kê"};
    private String field[] ={"ma_nhanvien","ql_nv","qly_pn","qly_ncc","phanquyen","sua_info","nhaphang","banhang","thongke"};
    quyenHanList list= new quyenHanList();
    quyenHanDAO qhdao= new quyenHanDAO();
    nhanVienBLL nvbll= new nhanVienBLL();
    public quyenHanBLL(){
        super();
        list.setQuyenHan(getQuyenHanList());
    }
    
    public ArrayList<quyenHan> getQuyenHanList(){
        this.conn.connectSQL();
        ResultSet rs = qhdao.getDBQuyenHan();
        ArrayList<quyenHan> ar= new ArrayList();
        try {
            while(rs.next()){
                quyenHan qh= new quyenHan();
                qh.setMa_nhanvien(rs.getString("ma_nhanvien"));
                qh.setBanhang(rs.getString("banhang"));
                qh.setNhaphang(rs.getString("nhaphang"));
                qh.setQl_nv(rs.getString("ql_nv"));
                qh.setQly_ncc(rs.getString("qly_ncc"));
                qh.setQly_hd(rs.getString("qly_hd"));
                qh.setThongke(rs.getString("thongke"));
                qh.setTinhluong(rs.getString("qly_pn"));
                qh.setPhanquyen(rs.getString("phanquyen"));
                ar.add(qh);
            }
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getQuyenHanList (line 36)");
        }
        return null;
    }
    
    public JScrollPane showData(){
        JScrollPane scroll = new JScrollPane();
        JTable table= new JTable();
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.list.setQuyenHan(getQuyenHanList());
        for(int i=0; i< this.list.getQuyenHan().size() ; i++){
            String ma_nhanvien= list.getQuyenHan().get(i).getMa_nhanvien();
            String banhang= list.getQuyenHan().get(i).getBanhang();
            String nhaphang= list.getQuyenHan().get(i).getNhaphang();
            String ql_nv= list.getQuyenHan().get(i).getQl_nv();
            String ql_ncc= list.getQuyenHan().get(i).getQly_ncc();
            String phanquyen= list.getQuyenHan().get(i).getPhanquyen();
            String sua_info= list.getQuyenHan().get(i).getQly_hd();
            String thongke= list.getQuyenHan().get(i).getThongke();
            String tinhluong= list.getQuyenHan().get(i).getTinhluong();
            Object[] rows={ma_nhanvien,banhang,nhaphang,ql_nv,ql_ncc,sua_info,thongke,tinhluong,phanquyen};
            model.addRow(rows);
        }
        table.setModel(model);
        scroll.setViewportView(table);
        return scroll;
    }
    
    // lấy quyền của nhân viên đang login
    public quyenHan getQuyenHanLogin(String ma_nhanvien){
        quyenHan qh= new quyenHan();
        for(int i=0;i<this.list.getQuyenHan().size();i++){
            if(this.list.getQuyenHan().get(i).getMa_nhanvien().equals(ma_nhanvien)) { 
                qh.setBanhang(this.list.getQuyenHan().get(i).getBanhang());
                qh.setNhaphang(this.list.getQuyenHan().get(i).getNhaphang());
                qh.setQl_nv(this.list.getQuyenHan().get(i).getQl_nv());
                qh.setQly_ncc(this.list.getQuyenHan().get(i).getQly_ncc());
                qh.setQly_hd(this.list.getQuyenHan().get(i).getQly_hd());
                qh.setThongke(this.list.getQuyenHan().get(i).getThongke());
                qh.setTinhluong(this.list.getQuyenHan().get(i).getTinhluong());
                qh.setPhanquyen(this.list.getQuyenHan().get(i).getPhanquyen());
            }
        }
        return qh;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public quyenHanList getList() {
        return list;
    }

    public void setList(quyenHanList list) {
        this.list = list;
    }
    
    public boolean getQuyenHanCheck (String quyen){
        if(quyen.trim().equals("1")){
            return true;
        } else {
            return false;
        }
    }
    
    public JTable getTable(){
        DefaultTableModel model= new DefaultTableModel();
        JTable table= new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    case 0:
                        return false;
                    case 1:
                        return false;
                    default:
                        return true;
                 }              
            };
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                default:
                    return Boolean.class;
                }
            }
        };
        taiKhoanBLL tkbll= new taiKhoanBLL();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setRowHeight(40);
        model.setColumnIdentifiers(header);
        this.list.setQuyenHan(getQuyenHanList());
        for(int i=0; i< this.list.getQuyenHan().size(); i++){
            for(int a=0;a<tkbll.getList().getTaikhoan().size();a++){
                if(tkbll.getList().getTaikhoan().get(a).getMa_nv().equals(this.list.getQuyenHan().get(i).getMa_nhanvien())){
                    if(tkbll.getList().getTaikhoan().get(a).getStatus().equals("on") || tkbll.getList().getTaikhoan().get(a).getStatus().equals("block")){
                        String manv= list.getQuyenHan().get(i).getMa_nhanvien();
                        String qqlnv= list.getQuyenHan().get(i).getQl_nv();
                        String qtlnv= list.getQuyenHan().get(i).getTinhluong();
                        String qqlncc= list.getQuyenHan().get(i).getQly_ncc();
                        String qpq= list.getQuyenHan().get(i).getPhanquyen();
                        String qsttcn= list.getQuyenHan().get(i).getQly_hd();
                        String qnh= list.getQuyenHan().get(i).getNhaphang();
                        String qbh= list.getQuyenHan().get(i).getBanhang();
                        String qtk= list.getQuyenHan().get(i).getThongke();
                        Object[] rows={nvbll.getNameFromID(manv),nvbll.getChucVuFromIDNV(manv),getQuyenHanCheck(qqlnv), getQuyenHanCheck(qtlnv), getQuyenHanCheck(qqlncc),getQuyenHanCheck(qpq),getQuyenHanCheck(qsttcn),
                                       getQuyenHanCheck(qnh),getQuyenHanCheck(qbh),getQuyenHanCheck(qtk)};
                        model.addRow(rows);
                    }
                }
            }
        }
        table.setModel(model);
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        return table;
    }
}
