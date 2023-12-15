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
public class hoaDon {
    protected String id, ma_nv, ma_kh, ngaylap, ghichu;
    protected double tongtien;

    public hoaDon() {
        this.id = null;
        this.ma_nv = null;
        this.ma_kh = null;
        this.ngaylap = null;
        this.tongtien = 0;
        this.ghichu= null;
    }
    
    public hoaDon(String id, String ma_nv, String ma_kh, String ngaylap, double tongtien, String ghichu) {
        this.id = id;
        this.ma_nv = ma_nv;
        this.ma_kh = ma_kh;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
        this.ghichu= ghichu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getMa_kh() {
        return ma_kh;
    }

    public void setMa_kh(String ma_kh) {
        this.ma_kh = ma_kh;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
