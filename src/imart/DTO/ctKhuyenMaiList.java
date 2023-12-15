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
public class ctKhuyenMaiList extends ctKhuyenMai{
    ArrayList<ctKhuyenMai> ctkhuyenmai = new ArrayList<>();

    public ctKhuyenMaiList() {
        super();
        ctkhuyenmai= null;
    }

    public ctKhuyenMaiList(String ma_km, String ma_sp, double phantram, ArrayList<ctKhuyenMai> ctkhuyenmai) {
        super(ma_km, ma_sp, phantram);
        this.ctkhuyenmai= ctkhuyenmai;
    }

    public ArrayList<ctKhuyenMai> getCtkhuyenmai() {
        return ctkhuyenmai;
    }

    public void setCtkhuyenmai(ArrayList<ctKhuyenMai> ctkhuyenmai) {
        this.ctkhuyenmai = ctkhuyenmai;
    }
}
