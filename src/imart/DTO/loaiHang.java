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
public class loaiHang {
    protected String ten_loai;
    protected  int id;
    
    public loaiHang(){
        this.id=0;
        this.ten_loai=null;
    }
    
    public loaiHang(int id, String ten_loai) {
        this.id = id;
        this.ten_loai = ten_loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
    
}
