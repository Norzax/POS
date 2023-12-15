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
public class nhanVienList extends nhanVien{
    private ArrayList<nhanVien> nhanvien= new ArrayList<>();

    public nhanVienList() {
        super();
        nhanvien= null;
    }

    public nhanVienList(String id, String ho, String ten, String ngaysinh, String dienthoai, String ngayvaolam, String gioitinh, String diachi, String ma_chucvu, ArrayList<nhanVien> nhanvien) {
        super(id, ho, ten, ngaysinh, dienthoai, ngayvaolam, gioitinh, diachi, ma_chucvu);
        this.nhanvien= nhanvien;
    }

    public ArrayList<nhanVien> getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(ArrayList<nhanVien> nhanvien) {
        this.nhanvien = nhanvien;
    }
    
    public static void main(String[] args) {
    }
}
