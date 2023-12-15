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
public class chucVu {
    protected String id;
    protected String ten_chucvu;
    
    public chucVu(){
        this.id=null;
        this.ten_chucvu=null;
    }
    
    public chucVu(String id, String ten_chucvu) {
        this.id = id;
        this.ten_chucvu = ten_chucvu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_chucvu() {
        return ten_chucvu;
    }

    public void setTen_chucvu(String ten_chucvu) {
        this.ten_chucvu = ten_chucvu;
    }
    
    
}
