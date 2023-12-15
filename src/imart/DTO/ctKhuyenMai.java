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
public class ctKhuyenMai {
    protected String ma_km, ma_sp;
    protected double phantram;

    public ctKhuyenMai() {
        this.ma_km = null;
        this.ma_sp = null;
        this.phantram = 0;
    }
    
    public ctKhuyenMai(String ma_km, String ma_sp, double phantram) {
        this.ma_km = ma_km;
        this.ma_sp = ma_sp;
        this.phantram = phantram;
    }

    public String getMa_km() {
        return ma_km;
    }

    public void setMa_km(String ma_km) {
        this.ma_km = ma_km;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(String ma_sp) {
        this.ma_sp = ma_sp;
    }

    public double getPhantram() {
        return phantram;
    }

    public void setPhantram(double phantram) {
        this.phantram = phantram;
    }
}
