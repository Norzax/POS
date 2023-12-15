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
public class ctPhieuNhap {
    protected String ma_pn,ma_sp;
    protected double dongia;
    protected int soluong;
    protected double thanhtien;

    public ctPhieuNhap(){
        this.ma_pn = null;
        this.ma_sp = null;
        this.dongia = 0.0;
        this.soluong = 0;
        this.thanhtien = 0.0;
    }
    
    public ctPhieuNhap(String ma_pn, String ma_sp, double dongia, int soluong, double thanhtien) {
        this.ma_pn = ma_pn;
        this.ma_sp = ma_sp;
        this.dongia = dongia;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMa_pn() {
        return ma_pn;
    }

    public void setMa_pn(String ma_pn) {
        this.ma_pn = ma_pn;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
