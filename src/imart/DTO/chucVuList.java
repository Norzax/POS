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
public class chucVuList extends chucVu{
    ArrayList<chucVu> chucvu= new ArrayList<>();

    public chucVuList() {
        super();
        chucvu=null;
    }

    public chucVuList(String id, String ten_chucvu) {
        super(id, ten_chucvu);
    }

    public ArrayList<chucVu> getChucvu() {
        return chucvu;
    }

    public void setChucvu(ArrayList<chucVu> chucvu) {
        this.chucvu = chucvu;
    }
    
    
}
