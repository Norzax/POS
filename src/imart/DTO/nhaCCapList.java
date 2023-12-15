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
public class nhaCCapList extends nhaCCap{
    ArrayList<nhaCCap> ncc= new ArrayList<>();
    public nhaCCapList(){
        super();
        this.ncc=null;
    }

    public nhaCCapList(String id, String ten_ncc, String diachi, String dienthoai, String status, ArrayList<nhaCCap> ncc) {
        super(id, ten_ncc, diachi, dienthoai,status);
        this.ncc= ncc;
    }

    public ArrayList<nhaCCap> getNcc() {
        return ncc;
    }

    public void setNcc(ArrayList<nhaCCap> ncc) {
        this.ncc = ncc;
    }
}
