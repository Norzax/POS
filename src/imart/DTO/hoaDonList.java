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
public class hoaDonList extends hoaDon{
    ArrayList<hoaDon> hoadon= new ArrayList<>();

    public hoaDonList() {
        super();
        this.hoadon= null;
    }
    
    public hoaDonList(String id, String ma_nv, String ma_kh, String ngaylap, double tongtien, String ghichu, ArrayList<hoaDon> hoadon) {
        super(id, ma_nv, ma_kh, ngaylap, tongtien, ghichu);
        this.hoadon= hoadon;
    }

    public ArrayList<hoaDon> getHoadon() {
        return hoadon;
    }

    public void setHoadon(ArrayList<hoaDon> hoadon) {
        this.hoadon = hoadon;
    }
    
}
