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
public class khuyenMai {
    protected String id,ngaybd,ngaykt;

    public khuyenMai(){
        this.id = null;
        this.ngaybd = null;
        this.ngaykt = null;
    }
    
    public khuyenMai(String id, String ngaybd, String ngaykt) {
        this.id = id;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }
    
}
