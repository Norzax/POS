/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.BLL;

import imart.DAO.chucVuDAO;
import imart.DAO.connect;
import imart.DTO.chucVu;
import imart.DTO.chucVuList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class chucVuBLL {
    connect conn= new connect();
    private String[] header={"ID","Mã nhân viên","Tên chức vụ"};
    private String field[] ={"id","ma_nv","ten_chucvu"};
    chucVuList list= new chucVuList();
    chucVuDAO cvdao= new chucVuDAO();
    public chucVuBLL(){
        super();
        list.setChucvu(getChucVuList());
    }
    
    public ArrayList<chucVu> getChucVuList(){
        this.conn.connectSQL();
        ResultSet rs = cvdao.getDBChucVu();
        ArrayList<chucVu> ar= new ArrayList();
        try {
            while(rs.next()){
                chucVu cv= new chucVu();
                cv.setId(rs.getString("id"));
                cv.setTen_chucvu(rs.getString("ten_chucvu"));
                ar.add(cv);
            }
            conn.closeSQL();
            return ar;
        } catch (SQLException ex) {
            System.out.println("Error at function getChucVuList (line 36)");
        }
        return null;
    }
    
    // lấy chức vụ của nhân viên đang login
    public chucVu getChucVuLogin(String ma_chucvu){
        chucVu cv= new chucVu();
        for(int i=0;i<this.list.getChucvu().size();i++){
            if(this.list.getChucvu().get(i).getId().equals(ma_chucvu)) { 
                cv.setId(this.list.getChucvu().get(i).getId());
                cv.setTen_chucvu(this.list.getChucvu().get(i).getTen_chucvu());
            }
        }
        return cv;
    }
    
    public String getMaFromName(String name){
        String id= null;
        for(int i=0;i<this.list.getChucvu().size();i++){
            if((this.list.getChucvu().get(i).getTen_chucvu().equalsIgnoreCase(name))) {
                id= this.list.getChucvu().get(i).getId();
            }
        }
        return id;
    }
    
    public String getNameFromID(String id){
        String name= null;
        for(int i=0;i<this.list.getChucvu().size();i++){
            if((this.list.getChucvu().get(i).getId().equalsIgnoreCase(id))) {
                name= this.list.getChucvu().get(i).getTen_chucvu();
            }
        }
        return name;
    }
    
    public String[] getTenChucVu(){
        String[] listten= new String[list.getChucvu().size()];
        for(int i=0;i<list.getChucvu().size();i++){
            listten[i]= list.getChucvu().get(i).getTen_chucvu();
        }
        return listten;
    }
}
