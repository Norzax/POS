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
public class ctHoaDon {
    protected String ma_hd,ma_sp;
    protected int soluong;
    protected double dongia,thanhtien;
    
    public ctHoaDon(){
        this.ma_hd = null;
        this.ma_sp = null;
        this.soluong = 0;
        this.dongia = 0.0;
        this.thanhtien = 0.0;
    }
    
    public ctHoaDon(String ma_hd, String ma_sp, int soluong, double dongia, double thanhtien) {
        this.ma_hd = ma_hd;
        this.ma_sp = ma_sp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getMa_hd() {
        return ma_hd;
    }

    public void setMa_hd(String ma_hd) {
        this.ma_hd = ma_hd;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
