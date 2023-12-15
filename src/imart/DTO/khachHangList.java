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
public class khachHangList extends khachHang{
    ArrayList<khachHang> khachhang= new ArrayList<>();
    public khachHangList(){
        super();
        khachhang=null;
    }
    
    public khachHangList(String id, String ho, String ten, String diachi, String dienthoai, String status, ArrayList<khachHang> khachhang) {
        super(id, ho, ten, diachi, dienthoai, status);
        this.khachhang= khachhang;
    }

    public ArrayList<khachHang> getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(ArrayList<khachHang> khachhang) {
        this.khachhang = khachhang;
    }
}
