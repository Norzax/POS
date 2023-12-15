/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DTO;

/**
 *
 * @author Bao Luan
 */
public class quyenHan {
    protected String ql_nv, tinhluong, qly_ncc, phanquyen, ma_nhanvien, qly_hd,nhaphang,banhang, thongke;
    
    public quyenHan(){
        this.ql_nv = null;
        this.tinhluong = null;
        this.qly_ncc = null;
        this.phanquyen = null;
        this.ma_nhanvien = null;
        this.qly_hd = null;
        this.nhaphang = null;
        this.banhang = null;
        this.thongke = null;
    }

    public quyenHan(String ql_nv, String tinhluong, String qly_ncc, String phanquyen, String ma_nhanvien, String qly_hd, String nhaphang, String banhang, String thongke) {
        this.ql_nv = ql_nv;
        this.tinhluong = tinhluong;
        this.qly_ncc = qly_ncc;
        this.phanquyen = phanquyen;
        this.ma_nhanvien = ma_nhanvien;
        this.qly_hd = qly_hd;
        this.nhaphang = nhaphang;
        this.banhang = banhang;
        this.thongke = thongke;
    }
    
    

    public String getQl_nv() {
        return ql_nv;
    }

    public void setQl_nv(String ql_nv) {
        this.ql_nv = ql_nv;
    }

    public String getTinhluong() {
        return tinhluong;
    }

    public void setTinhluong(String tinhluong) {
        this.tinhluong = tinhluong;
    }

    public String getQly_ncc() {
        return qly_ncc;
    }

    public void setQly_ncc(String qly_ncc) {
        this.qly_ncc = qly_ncc;
    }

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }

    public String getMa_nhanvien() {
        return ma_nhanvien;
    }

    public void setMa_nhanvien(String ma_nhanvien) {
        this.ma_nhanvien = ma_nhanvien;
    }

    public String getQly_hd() {
        return qly_hd;
    }

    public void setQly_hd(String qly_hd) {
        this.qly_hd = qly_hd;
    }

    public String getNhaphang() {
        return nhaphang;
    }

    public void setNhaphang(String nhaphang) {
        this.nhaphang = nhaphang;
    }

    public String getBanhang() {
        return banhang;
    }

    public void setBanhang(String banhang) {
        this.banhang = banhang;
    }

    public String getThongke() {
        return thongke;
    }

    public void setThongke(String thongke) {
        this.thongke = thongke;
    }
}
