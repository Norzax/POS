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
public class ctHoaDonList extends ctHoaDon{
    ArrayList<ctHoaDon> cthoadon= new ArrayList<>();

    public ctHoaDonList() {
        super();
        this.cthoadon=null;
    }

    public ctHoaDonList(String ma_hd, String ma_sp, int soluong, double dongia, double thanhtien) {
        super(ma_hd, ma_sp, soluong, dongia, thanhtien);
    }

    public ArrayList<ctHoaDon> getCthoadon() {
        return cthoadon;
    }

    public void setCthoadon(ArrayList<ctHoaDon> cthoadon) {
        this.cthoadon = cthoadon;
    }
    
    
}
