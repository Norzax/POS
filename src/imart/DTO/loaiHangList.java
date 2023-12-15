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
public class loaiHangList extends loaiHang{
    ArrayList<loaiHang> loaiHang= new ArrayList<>();

    public loaiHangList() {
        super();
        this.loaiHang=null;
    }

    public loaiHangList(int id, String ten_loai, ArrayList<loaiHang> loaihang) {
        super(id, ten_loai);
        this.loaiHang= loaihang;
    }

    public ArrayList<loaiHang> getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(ArrayList<loaiHang> loaiHang) {
        this.loaiHang = loaiHang;
    }
    
}
