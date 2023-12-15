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
public class sanPhamList extends sanPham{
    private ArrayList<sanPham> sanpham= new ArrayList<>();
    
    public sanPhamList() {
        super();
        this.sanpham= null;
    }

    public sanPhamList(String id, String tensp, String nsx, String hsd, double dongia, int soluong, String ma_loai, String status, ArrayList<sanPham> sanpham) {
        super(id, tensp, nsx, hsd, dongia, soluong, ma_loai, status);
        this.sanpham= sanpham;
    }

    public ArrayList<sanPham> getSanpham() {
        return sanpham;
    }

    public void setSanpham(ArrayList<sanPham> sanpham) {
        this.sanpham = sanpham;
    }
}
