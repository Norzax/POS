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
public class ctPhieuNhapList extends ctPhieuNhap{
    ArrayList<ctPhieuNhap> ctphieunhap= new ArrayList<>();

    public ctPhieuNhapList() {
        super();
        this.ctphieunhap=null;
    }

    public ctPhieuNhapList(String ma_pn, String ma_sp, double dongia, int soluong, double thanhtien) {
        super(ma_pn, ma_sp, dongia, soluong, thanhtien);
    }

    public ArrayList<ctPhieuNhap> getCtphieunhap() {
        return ctphieunhap;
    }

    public void setCtphieunhap(ArrayList<ctPhieuNhap> ctphieunhap) {
        this.ctphieunhap = ctphieunhap;
    }
    
}
