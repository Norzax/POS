/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bao Luan
 */
public class caNhanFrame extends JFrame{
    private JPanel pn1;
    
    public caNhanFrame(){
        initComponents();
    }
   
    public void initComponents(){
        this.setSize(1000, 650);
        this.setTitle("Thông tin cá nhân");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
        new caNhanFrame().setVisible(true);
    }
}
