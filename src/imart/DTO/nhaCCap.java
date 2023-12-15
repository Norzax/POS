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
public class nhaCCap {
    protected String id, ten_ncc, diachi, dienthoai, status;

    public nhaCCap() {
        this.id = null;
        this.ten_ncc = null;
        this.diachi = null;
        this.dienthoai = null;
        this.status=null;
    }
    
    public nhaCCap(String id, String ten_ncc, String diachi, String dienthoai, String status) {
        this.id = id;
        this.ten_ncc = ten_ncc;
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

    public String getTen_ncc() {
        return ten_ncc;
    }

    public void setTen_ncc(String ten_ncc) {
        this.ten_ncc = ten_ncc;
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
}
