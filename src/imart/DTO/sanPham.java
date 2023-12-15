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
public class sanPham {
    protected String id, tensp, nsx, hsd, ma_loai, status;
    protected int soluong;
    protected double dongia;

    public sanPham() {
        this.id = null;
        this.tensp = null;
        this.nsx = null;
        this.hsd = null;
        this.dongia = 0;
        this.soluong = 0;
        this.ma_loai = null;
        this.status=null;
    }
    
    public sanPham(String id, String tensp, String nsx, String hsd, double dongia, int soluong, String ma_loai, String status) {
        this.id = id;
        this.tensp = tensp;
        this.nsx = nsx;
        this.hsd = hsd;
        this.dongia = dongia;
        this.soluong = soluong;
        this.ma_loai = ma_loai;
        this.status= status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getHsd() {
        return hsd;
    }

    public void setHsd(String hsd) {
        this.hsd = hsd;
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

    public String getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(String ma_loai) {
        this.ma_loai = ma_loai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
