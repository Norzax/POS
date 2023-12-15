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
public class khachHang {
    protected String id, ho,ten,diachi,dienthoai,status;

    public khachHang(){
        this.id = null;
        this.ho = null;
        this.ten = null;
        this.diachi = null;
        this.dienthoai = null;
        this.status=null;
    }
    
    public khachHang(String id, String ho, String ten, String diachi, String dienthoai, String status) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.status= status;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return getId()+"  "+getHo()+"   "+getTen()+"   "+getDiachi()+"   "+getDienthoai();
    }
    
}
