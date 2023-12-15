/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import imart.BLL.nhanVienBLL;
import imart.BLL.quyenHanBLL;
import imart.DAO.quyenHanDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Bao Luan
 */
public class phanQuyenPanel {
    private static JTable tableqh;
    private JPanel pnphanquyen, pncnquyen;
    private JLabel lbcnquyen;
    private String us,ps;
    quyenHanBLL qhbll= new quyenHanBLL();
    public phanQuyenPanel(){
        initComponents();
    }
    
    public void initComponents(){
        
    }
    
    public void getPhanQuyenPanel(JPanel panel, JPanel pntitle ,JLabel lbtitle, String us, String ps){
        panel.removeAll();
        panel.setLayout(new BorderLayout(0,15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        lbtitle.removeAll();
        lbtitle.setText("Phân quyền");
        lbtitle.repaint();
        lbtitle.validate();       
        
        pnphanquyen= new JPanel();
        pnphanquyen.setLayout(new GridLayout());
        
        addFullTable();
        
        pncnquyen= new JPanel();
        pncnquyen.setPreferredSize(new Dimension(0, 150));
        pncnquyen.setLayout(new GridLayout());
        pncnquyen.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.gray), BorderFactory.createEmptyBorder(45,700,45,700)));
        
        lbcnquyen= new JLabel("Cập nhật");
        lbcnquyen.setForeground(Color.white);
        lbcnquyen.setBackground(Color.black);
        lbcnquyen.setOpaque(true);
        lbcnquyen.setFont(new Font("Tahoma",Font.PLAIN,30));
        lbcnquyen.setHorizontalAlignment(JLabel.CENTER);
        lbcnquyen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quyenHanDAO qhdao= new  quyenHanDAO();
                nhanVienBLL nvbll= new nhanVienBLL();
                for(int i=0;i<tableqh.getRowCount();i++){
                    qhdao.updateDBQuyenHan(nvbll.getMaFromName(tableqh.getValueAt(i, 0).toString().trim()), 
                                           getNumFromCheckBox(tableqh.getValueAt(i, 2).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 3).toString().trim()), 
                                           getNumFromCheckBox(tableqh.getValueAt(i, 4).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 5).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 6).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 7).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 8).toString().trim()),
                                           getNumFromCheckBox(tableqh.getValueAt(i, 9).toString().trim()));
                }
//                JOptionPane.showMessageDialog(null,"Đã cập nhật quyền","Thông báo",2);
                pnphanquyen.removeAll();
                addFullTable();
                pnphanquyen.repaint();
                pnphanquyen.validate();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbcnquyen.setBackground(Color.white);
                lbcnquyen.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbcnquyen.setBackground(Color.black);
                lbcnquyen.setForeground(Color.white);
            }
        });
        
        pncnquyen.add(lbcnquyen);
        
        panel.add(pntitle, BorderLayout.NORTH);
        panel.add(pnphanquyen, BorderLayout.CENTER);
        panel.add(pncnquyen, BorderLayout.SOUTH);
        panel.repaint();
        panel.validate();
    }
    
    public void addFullTable(){
        JScrollPane scroll= new JScrollPane();
        tableqh= qhbll.getTable();
        scroll.setViewportView(tableqh);
        pnphanquyen.add(scroll,BorderLayout.CENTER);
        //pntab121.add(scroll,BorderLayout.CENTER);
        //setText(table);
    }
    
    public String getNumFromCheckBox(String bool){
        if(bool.equalsIgnoreCase("true")){
            return "1";
        } else {
            return "0";
        }
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
    
    public static void main(String[] args) {
        
    }
}
