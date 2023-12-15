/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.DAO;

import java.sql.ResultSet;

/**
 *
 * @author Bao Luan
 */
public class chucVuDAO {
    connect conn= new connect();
    public void chucVuDAO(){
        
    }
    
     public ResultSet getDBChucVu(){
        conn.connectSQL();
        String statement="select * from chuc_vu";
        return connect.dataSQL(statement);
    }
}
