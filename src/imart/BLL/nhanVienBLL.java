/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DTO.nhanVien;
import imart.DAO.connect;
import imart.DAO.nhanVienDAO;
import imart.DTO.nhanVienList;
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
public class nhanVienBLL{
    connect conn= new connect();
    private String[] header={"ID","Họ","Tên","Ngày sinh","Địa chỉ","Điện thoại","Ngày vào làm","Giới tính","Mã chức vụ"};
    private String field[] ={"id","ho","ten","ngaysinh","dienthoai","ngayvaolam","gioitinh","diachi","ma_chucvu"};
    nhanVienList list = new nhanVienList();
    nhanVienDAO nvdao= new nhanVienDAO();
    hoaDonBLL hdbll= new hoaDonBLL();
    chucVuBLL cvbll= new chucVuBLL();
    
    public nhanVienBLL(){
        super();
        list.setNhanvien(getNhanVienList());
    }
    
//    public ArrayList<nhanVien> getNhanVienList(String condition, String OderBy){
//        return getNhanVienList(condition, OderBy);
//    }
    
    public ArrayList<nhanVien> getNhanVienList(){
        conn.connectSQL();
        ResultSet rs = nvdao.getDBNhanVien();
        ArrayList<nhanVien> ar= new ArrayList();
        try {
            while(rs.next()){
                nhanVien nv= new nhanVien();
                nv.setId(rs.getString("id"));
                nv.setHo(rs.getString("ho"));
                nv.setTen(rs.getString("ten"));
                nv.setNgaysinh(rs.getString("ngaysinh"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setDienthoai(rs.getString("dienthoai"));
                nv.setNgayvaolam(rs.getString("ngayvaolam"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setMa_chucvu(rs.getString("ma_chucvu"));
                ar.add(nv);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getNhanVienList (line 39)");
        }
        return null;
    }
    
    public void changeGenderToText(){
        for(int i=0;i<list.getNhanvien().size();i++){
            if(list.getNhanvien().get(i).getGioitinh().equalsIgnoreCase("1")){
                list.getNhanvien().get(i).setGioitinh("Nam");
            } else {
                list.getNhanvien().get(i).setGioitinh("Nu");
            }
        }
    }
    
    public String changeGenderToText2(String num){
        if("1".equalsIgnoreCase(num))
            return "Nam";
        else if("2".equalsIgnoreCase(num))
            return "Nu";
        return null;
    }
    
    public String changeGenderToNum(String gender){
        if("nam".equalsIgnoreCase(gender))
            return "1";
        else if("nu".equalsIgnoreCase(gender))
            return "2";
        else {
            JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ\nGiới tính là (nam / nu)", "Thông báo", 2);
            return null;
        }
    }
    
    public ArrayList<nhanVien> findNV(String ma){
//        Cach 1:
        ArrayList<nhanVien> result = new ArrayList<>();
        list.getNhanvien().stream().filter((nv) -> (nv.getId().contains(ma))).forEachOrdered((nv) -> {
            result.add(nv);
        });
//       Cach 2:
//        for(nhanVien nv: list.getNhanvien()) {
//            if(nv.getId().indexOf(ma)>=0){
//                result.add(nv);
//            }
//        }
        return result;
    }
    
    public String[] getTenNhanVien(){
        String[] listten= new String[list.getNhanvien().size()+1];
        listten[0]= "--Nhân viên--";
        for(int i=0;i<list.getNhanvien().size();i++){
            listten[i+1]= list.getNhanvien().get(i).getHo()+" "+list.getNhanvien().get(i).getTen();
        }
        return listten;
    }
    
    
    // lấy hết thông tin của nhân viên đang login
    /*
    *   0:   Mã nhân viên                       1:   Họ                 2:   Tên                3:   Ngày sinh          4:   Địa chỉ
    *   5:   Điện thoại                         6:   Ngày vào làm       7:   Giới tinh          8:   Mã chức vụ         9:   Tên chức vụ
    *   10:  Username                           11:  Password           12:  Quyền bán hàng     13:  Quyền nhập hàng
    *   14:  Quyền quản lý nhân viên            15:  Quyền sửa danh sách nhân viên (bỏ)         15:  Quyền quản lý nhà cung cấp
    *   16:  Quyền sửa thông tin cá nhân        17:  Quyền thống kê                             18:  Quyền tính lương
    *   19:  Quyền phân quyền
    */
    public String[] getAllInfo(String us, String pw){
        taiKhoanBLL tkbll= new taiKhoanBLL();
        quyenHanBLL qhbll= new quyenHanBLL();
        chucVuBLL cvbll = new chucVuBLL();
        nhanVien nv= new nhanVien();
        for(int i=0;i<this.list.getNhanvien().size();i++){
            if(this.list.getNhanvien().get(i).getId().equals(tkbll.getTaiKhoanLogin(us, pw).getMa_nv())){
                nv.setId(this.list.getNhanvien().get(i).getId());
                nv.setHo(this.list.getNhanvien().get(i).getHo());
                nv.setTen(this.list.getNhanvien().get(i).getTen());
                nv.setNgaysinh(this.list.getNhanvien().get(i).getNgaysinh());
                nv.setDiachi(this.list.getNhanvien().get(i).getDiachi());
                nv.setDienthoai(this.list.getNhanvien().get(i).getDienthoai());
                nv.setNgayvaolam(this.list.getNhanvien().get(i).getNgayvaolam());
                nv.setGioitinh(this.list.getNhanvien().get(i).getGioitinh());
                nv.setMa_chucvu(this.list.getNhanvien().get(i).getMa_chucvu());
            }
        }
        String fullInfo[] = {nv.getId(),nv.getHo(),nv.getTen(),nv.getNgaysinh(),nv.getDiachi(),nv.getDienthoai(),nv.getNgayvaolam(),nv.getGioitinh(),
                             nv.getMa_chucvu(), cvbll.getChucVuLogin(nv.getMa_chucvu()).getTen_chucvu(), tkbll.getTaiKhoanLogin(us, pw).getUsername(), tkbll.getTaiKhoanLogin(us, pw).getPassword(),
                             qhbll.getQuyenHanLogin(nv.getId()).getBanhang(),qhbll.getQuyenHanLogin(nv.getId()).getNhaphang(),qhbll.getQuyenHanLogin(nv.getId()).getQl_nv(), 
                             qhbll.getQuyenHanLogin(nv.getId()).getQly_ncc(),qhbll.getQuyenHanLogin(nv.getId()).getQly_hd(),
                             qhbll.getQuyenHanLogin(nv.getId()).getThongke(),qhbll.getQuyenHanLogin(nv.getId()).getTinhluong(),qhbll.getQuyenHanLogin(nv.getId()).getPhanquyen()};
        return fullInfo;
    }
    
    public String getMaFromName(String name){
        if("--Nhân viên--".equals(name)){
            JOptionPane.showMessageDialog(null,"Hãy chọn nhân viên bán","Thông báo",2);
        }
        else {
            String id= null;
            for(int i=0;i<this.list.getNhanvien().size();i++){
                if((this.list.getNhanvien().get(i).getHo().trim()+" "+this.list.getNhanvien().get(i).getTen().trim()).equalsIgnoreCase(name)) {
                    id= this.list.getNhanvien().get(i).getId();
                }
            }
            return id;
        }
        return null;
    }
    
    public String getNameFromID(String id){
        String name=null;
        for(int i=0;i<this.list.getNhanvien().size();i++){
            if(this.list.getNhanvien().get(i).getId().equals(id)) {
                name= this.list.getNhanvien().get(i).getHo().trim()+" "+this.list.getNhanvien().get(i).getTen().trim();
            }
        }
        return name;
    }
    
    public String getChucVuFromIDNV(String id){
        String chucvu=null;
        for(int i=0;i<this.list.getNhanvien().size();i++){
            if(this.list.getNhanvien().get(i).getId().equals(id)) {
                chucvu= cvbll.getNameFromID(this.list.getNhanvien().get(i).getMa_chucvu());
            }
        }
        return chucvu;
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
        taiKhoanBLL tkbll= new taiKhoanBLL();
        this.list.setNhanvien(getNhanVienList());
        changeGenderToText();
        for(int i=0; i< this.list.getNhanvien().size(); i++){
            for(int a=0;a<tkbll.getList().getTaikhoan().size();a++) {
                if(tkbll.getList().getTaikhoan().get(a).getMa_nv().equalsIgnoreCase(this.list.getNhanvien().get(i).getId())) {
                    if(tkbll.getList().getTaikhoan().get(a).getStatus().equalsIgnoreCase("on") || tkbll.getList().getTaikhoan().get(a).getStatus().equalsIgnoreCase("block")) {
                        String manv= list.getNhanvien().get(i).getId();
                        String honv= list.getNhanvien().get(i).getHo();
                        String tennv= list.getNhanvien().get(i).getTen();
                        String ngaysinhnv= list.getNhanvien().get(i).getNgaysinh();
                        String diachinv= list.getNhanvien().get(i).getDiachi();
                        String dienthoainv= list.getNhanvien().get(i).getDienthoai();
                        String ngaylamnv= list.getNhanvien().get(i).getNgayvaolam();
                        String gioitinhnv= list.getNhanvien().get(i).getGioitinh();
                        String machucvunv= list.getNhanvien().get(i).getMa_chucvu();
                        Object[] rows={manv,honv,tennv,ngaysinhnv,diachinv,dienthoainv,ngaylamnv,gioitinhnv, machucvunv};
                        model.addRow(rows);
                    }
                }
            }
        }
        
        table.setModel(model);
        return table;
    }
    
    public JTable getTable2(){
        JTable table= new JTable();
        table.setRowHeight(20);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        taiKhoanBLL tkbll= new taiKhoanBLL();
        changeGenderToText();
        for(int i=0; i< this.list.getNhanvien().size(); i++){
            for(int a=0;a<tkbll.getList().getTaikhoan().size();a++) {
                if(tkbll.getList().getTaikhoan().get(a).getMa_nv().equalsIgnoreCase(this.list.getNhanvien().get(i).getId())) {
                    if(tkbll.getList().getTaikhoan().get(a).getStatus().equalsIgnoreCase("on") || tkbll.getList().getTaikhoan().get(a).getStatus().equalsIgnoreCase("block")) {
                        String manv= list.getNhanvien().get(i).getId();
                        String honv= list.getNhanvien().get(i).getHo();
                        String tennv= list.getNhanvien().get(i).getTen();
                        String ngaysinhnv= list.getNhanvien().get(i).getNgaysinh();
                        String diachinv= list.getNhanvien().get(i).getDiachi();
                        String dienthoainv= list.getNhanvien().get(i).getDienthoai();
                        String ngaylamnv= list.getNhanvien().get(i).getNgayvaolam();
                        String gioitinhnv= list.getNhanvien().get(i).getGioitinh();
                        String machucvunv= list.getNhanvien().get(i).getMa_chucvu();
                        Object[] rows={manv,honv,tennv,ngaysinhnv,diachinv,dienthoainv,ngaylamnv,gioitinhnv, machucvunv};
                        model.addRow(rows);
                    }
                }
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
    
    //hiển thị bảng khách hàng theo mã, tên, số điện thoại
    public JTable showData(String find){
        JTable table= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            };
        };
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        taiKhoanBLL tkbll= new taiKhoanBLL();
        for(int i=0; i< this.list.getNhanvien().size() ; i++){
            if((this.list.getNhanvien().get(i).getId().equalsIgnoreCase(find) || 
                (this.list.getNhanvien().get(i).getHo()+" "+this.list.getNhanvien().get(i).getTen()).equalsIgnoreCase(find) ||
                 this.list.getNhanvien().get(i).getDienthoai().equalsIgnoreCase(find))){
                for(int a=0;a<tkbll.getList().getTaikhoan().size();a++) {
                    if(this.list.getNhanvien().get(i).getId().equals(tkbll.getList().getTaikhoan().get(a).getMa_nv())){
                        if(tkbll.getList().getTaikhoan().get(a).getStatus().equals("on")||tkbll.getList().getTaikhoan().get(a).getStatus().equals("block")){
                            String manv= list.getNhanvien().get(i).getId();
                            String honv= list.getNhanvien().get(i).getHo();
                            String tennv= list.getNhanvien().get(i).getTen();
                            String ngaysinhnv= list.getNhanvien().get(i).getNgaysinh();
                            String diachinv= list.getNhanvien().get(i).getDiachi();
                            String dienthoainv= list.getNhanvien().get(i).getDienthoai();
                            String ngaylamnv= list.getNhanvien().get(i).getNgayvaolam();
                            String gioitinhnv= list.getNhanvien().get(i).getGioitinh();
                            String machucvunv= list.getNhanvien().get(i).getMa_chucvu();
                            Object[] rows={manv,honv,tennv,ngaysinhnv,diachinv,dienthoainv,ngaylamnv,gioitinhnv, machucvunv};
                            model.addRow(rows);
                        }
                    }
                }
            }
        }
        table.setModel(model);
        return table;
    }
    
    
    //hiển thị bảng nv theo mã hóa đơn
    public JTable showDataByHDID(String find){
        JTable table= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            };
        };
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(header);
        System.out.println(hdbll.getList().getHoadon().size());
        for(int i=0; i< hdbll.getList().getHoadon().size() ; i++){
            if(hdbll.getList().getHoadon().get(i).getId().equalsIgnoreCase(find)){
                for(int a=0;a<this.list.getNhanvien().size();a++){
                    if(this.list.getNhanvien().get(a).getId().equals(hdbll.getList().getHoadon().get(i).getMa_nv())) {
                        String manv= list.getNhanvien().get(a).getId();
                        String honv= list.getNhanvien().get(a).getHo();
                        String tennv= list.getNhanvien().get(a).getTen();
                        String ngaysinhnv= list.getNhanvien().get(a).getNgaysinh();
                        String diachinv= list.getNhanvien().get(a).getDiachi();
                        String dienthoainv= list.getNhanvien().get(a).getDienthoai();
                        String ngaylamnv= list.getNhanvien().get(a).getNgayvaolam();
                        String gioitinhnv= list.getNhanvien().get(a).getGioitinh();
                        String machucvunv= list.getNhanvien().get(a).getMa_chucvu();
                        Object[] rows={manv,honv,tennv,ngaysinhnv,diachinv,dienthoainv,ngaylamnv,gioitinhnv, machucvunv};
                        model.addRow(rows);
                    }
                }
            }
        }
        table.setModel(model);
        return table;
    }

    public nhanVienList getList() {
        return list;
    }

    public void setList(nhanVienList list) {
        this.list = list;
    }
    
    public boolean checkTonTaiSDT(String dienthoai, String id){
        for(int i=0;i<this.list.getNhanvien().size();i++){
            if(this.list.getNhanvien().get(i).getDienthoai().trim().equals(dienthoai) && !this.list.getNhanvien().get(i).getId().trim().equals(id)){
                JOptionPane.showMessageDialog(null,"Không hợp lệ, số điện thoại đã tồn tại!!" ,"Thông báo",2);
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
    
}
