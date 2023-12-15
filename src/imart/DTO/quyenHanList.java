/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DTO;

import java.util.ArrayList;

/**
 *
 * @author GIA DUC
 */
public class quyenHanList extends quyenHan{
    ArrayList<quyenHan> quyenHan= new ArrayList<>();

    public quyenHanList() {
        super();
        this.quyenHan=null;
    }

    public quyenHanList(String ql_nv, String tinhluong, String qly_ncc, String phanquyen, String ma_nhanvien, String qly_hd, String nhaphang, String banhang, String thongke) {
        super(ql_nv, tinhluong, qly_ncc, phanquyen, ma_nhanvien, qly_hd, nhaphang, banhang, thongke);
    }

    public ArrayList<quyenHan> getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(ArrayList<quyenHan> quyenHan) {
        this.quyenHan = quyenHan;
    }
    
}
