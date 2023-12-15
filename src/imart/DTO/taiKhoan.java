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
public class taiKhoan {
    protected String username, password, ma_nv,status;

    public taiKhoan() {
        this.username = null;
        this.password = null;
        this.ma_nv = null;
        this.status=null;
    }
    
    public taiKhoan(String username, String password, String ma_nv, String status) {
        this.username = username;
        this.password = password;
        this.ma_nv = ma_nv;
        this.status= status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public void setMa_nv(String ma_nv) {
        this.ma_nv = ma_nv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
