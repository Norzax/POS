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
public class taiKhoanList extends taiKhoan{
    ArrayList<taiKhoan> taikhoan= new ArrayList<>();

    public taiKhoanList() {
    }

    public taiKhoanList(String username, String password, String ma_nv, String status, ArrayList<taiKhoan> taikhoan) {
        super(username, password, ma_nv, status);
        this.taikhoan= taikhoan;
    }

    public ArrayList<taiKhoan> getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(ArrayList<taiKhoan> taikhoan) {
        this.taikhoan = taikhoan;
    }
}
