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
public class khuyenMaiList extends khuyenMai{
    ArrayList<khuyenMai> khuyenMai= new ArrayList<>();

    public khuyenMaiList() {
        super();
        this.khuyenMai=null;
    }

    public khuyenMaiList(String id, String ngaybd, String ngaykt) {
        super(id, ngaybd, ngaykt);
    }

    public ArrayList<khuyenMai> getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(ArrayList<khuyenMai> khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
        

}
