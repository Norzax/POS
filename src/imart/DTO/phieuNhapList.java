/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DTO;

import java.util.ArrayList;

/**
 *
 * @author Bao Luan
 */
public class phieuNhapList extends phieuNhap{
    ArrayList<phieuNhap> phieunhap= new ArrayList<>();

    public phieuNhapList() {
        super();
        phieunhap= null;
    }

    public phieuNhapList(String id, String ma_nv, String ma_ncc, String ngaylap, double tongtien,String ghichu, ArrayList<phieuNhap> phieunhap) {
        super(id, ma_nv, ma_ncc, ngaylap, tongtien, ghichu);
        this.phieunhap= phieunhap;
    }

    public ArrayList<phieuNhap> getPhieunhap() {
        return phieunhap;
    }

    public void setPhieunhap(ArrayList<phieuNhap> phieunhap) {
        this.phieunhap = phieunhap;
    }
}
