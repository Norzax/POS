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
public class nhanVien {
    protected String id, ho, ten, ngaysinh, dienthoai, ngayvaolam, gioitinh, diachi, ma_chucvu;
    public nhanVien(){
        this.id=null;
        this.ho=null;
        this.ten=null;
        this.ngaysinh=null;
        this.dienthoai=null;
        this.ngayvaolam=null;
        this.gioitinh=null;
        this.diachi=null;
        this.ma_chucvu= null;
    }

    public nhanVien(String id, String ho, String ten, String ngaysinh, String dienthoai, String ngayvaolam, String gioitinh, String diachi, String ma_chucvu) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.dienthoai = dienthoai;
        this.ngayvaolam = ngayvaolam;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ma_chucvu= ma_chucvu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(String ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMa_chucvu() {
        return ma_chucvu;
    }

    public void setMa_chucvu(String ma_chucvu) {
        this.ma_chucvu = ma_chucvu;
    }
}
