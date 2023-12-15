/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import imart.BLL.ctHoaDonBLL;
import imart.BLL.hoaDonBLL;
import imart.BLL.khachHangBLL;
import imart.BLL.sanPhamBLL;
import imart.DAO.khachHangDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class khachHangPanel {
    private JPanel pncontent1, pntab11, pntab12, pntab121, pntab1221,pntab12211, pntab12212,pntab122121, pntab122122,pntab12213, pntab1222,pntab1222chitiet, pntab1222dshoadon, 
                    pnmainfind,pnidhd,pntheott, pntheongay, pntheonv;
    private JLabel lbmainfind, lbidhd, lblammoi, lbthem, lbsua, lbxoa, lbngaytao, lbmanvtao;
    private JPanel pnttkh[];
    private JTextField txmainfind, txidhd, txngaytao, txmanvtao;
    private JTextField txttkh[];
    private JLabel lbttkh[];
    private String thongtin[]={"Mã khách hàng","Họ","Tên","Địa chỉ","Số điện thoại"};
    private JTabbedPane tab= new JTabbedPane();
    private JTabbedPane tab122;
    private static JTable tablekh = new JTable();
    private static DefaultTableModel modelkh= new DefaultTableModel();
    private static JScrollPane scroll= new JScrollPane();
    khachHangBLL khbll= new khachHangBLL();
    hoaDonBLL hdbll= new hoaDonBLL();
    ctHoaDonBLL cthdbll= new ctHoaDonBLL();
    sanPhamBLL spbll= new sanPhamBLL();
    khachHangDAO khdao= new khachHangDAO();
    
    public khachHangPanel(){
        initComponents();
    }
    
    public void initComponents(){
        //trái 
        pncontent1= new JPanel();
        pncontent1.setLayout(new BorderLayout(10,0));
        pncontent1.setLayout(new BorderLayout(15, 10));
        
        //Panel trái của tab content1
        pntab11= new JPanel();
        pntab11.setBackground(Color.white);
        pntab11.setPreferredSize(new Dimension(350,0));
        pntab11.setLayout(new FlowLayout(0, 0, 15));
        pntab11.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Tìm kiếm", 0, 0, new Font("Tahoma",Font.PLAIN,20)),
                          BorderFactory.createEmptyBorder(10,0,10,0)));
        
        //Panel phải của tab content1
        pntab12= new JPanel();
        pntab12.setLayout(new BorderLayout(0, 15));
        
        //Panel trên của panel pntab12
        pntab121= new JPanel();
        pntab121.setLayout(new GridLayout());
        pntab121.setPreferredSize(new Dimension(100,200));
        
//        modelkh.setColumnIdentifiers(khbll.getHeader());
//        tablekh.setModel(modelkh);
//        scroll.setViewportView(tablekh);
//        pntab121.add(scroll);
        
        //Tab dưới của panel pntab12
        tab122= new JTabbedPane();
        //tab thứ nhất của tab122
        pntab1221= new JPanel();
        pntab1221.setLayout(new BorderLayout(10, 10));
        //tab thứ hai của tab122
        pntab1222= new JPanel();
        pntab1222.setLayout(new GridLayout(2,1));
        
        pntab1222dshoadon= new JPanel();
        pntab1222dshoadon.setBorder(BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", 0, 0, new Font("Tahoma",Font.PLAIN, 20), Color.black));
        pntab1222dshoadon.setLayout(new GridLayout());
        
        JTable tablels= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        tablels.setRowHeight(20);
        DefaultTableModel modells= new DefaultTableModel();
        JScrollPane scrollls= new JScrollPane();
        String []lsmua= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên bán"};
        modells.setColumnIdentifiers(lsmua);
        tablels.setModel(modells);
        scrollls.setViewportView(tablels);
        pntab1222dshoadon.add(scrollls);
        
        pntab1222chitiet= new JPanel();
        pntab1222chitiet.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết", 0, 0, new Font("Tahoma",Font.PLAIN, 20), Color.black));
        pntab1222chitiet.setLayout(new GridLayout());
        
        JTable tablectls= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            };
        };
        tablectls.setRowHeight(20);
        DefaultTableModel modelctls= new DefaultTableModel();
        JScrollPane scrollctls= new JScrollPane();
        String []ctlsmua= {"STT","Mã sản phẩm", "Tên sản phẩm","Đơn giá","Số lượng","Tổng tiền"};
        modelctls.setColumnIdentifiers(ctlsmua);
        tablectls.setModel(modelctls);
        scrollctls.setViewportView(tablectls);
        pntab1222chitiet.add(scrollctls);
        
        pntab1222.add(pntab1222dshoadon);
        pntab1222.add(pntab1222chitiet);
        
        
        tab122.addTab("Thông tin",pntab1221);
        tab122.addTab("Lịch sử mua hàng",pntab1222);
        tab122.setBackground(Color.lightGray);
        tab122.setForeground(Color.white);
        tab122.setFont(new Font("Tahoma", Font.PLAIN,20));
        
        //panel 1 của tab thứ nhất pntab1221
        pntab12211= new JPanel();
        pntab12211.setBackground(Color.white);
        pntab12211.setPreferredSize(new Dimension(350, 0));
        //panel 2 của tab thứ nhất pntab1221
        pntab12212= new JPanel();
        pntab12212.setLayout(new BorderLayout(0,10));
        //panel 3 của tab thứ nhất pntab1221
        pntab12213= new JPanel();
        pntab12213.setBackground(Color.green);
        pntab12213.setPreferredSize(new Dimension(0, 100));
        
        //panel 1 của pntab12212
        pntab122121= new JPanel();
        pntab122121.setBackground(Color.white);
        pntab122121.setPreferredSize(new Dimension(0,350));
        pntab122121.setLayout(new GridLayout(3,2,10,10));
        pntab122121.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Chỉnh sửa, thêm mới khách hàng", 0, 0, new Font("Tahoma", Font.PLAIN, 20)),
                                BorderFactory.createEmptyBorder(35, 0, 35, 180)));
        
        //panel 2 của pntab12212
        pntab122122= new JPanel();
        pntab122122.setBackground(Color.white);
        pntab122122.setPreferredSize(new Dimension(0,120));
        pntab122122.setLayout(new GridLayout(1,3,100,0));
        pntab122122.setBorder(BorderFactory.createEmptyBorder(60, 200, 60, 200));
        
        pntab12212.add(pntab122121, BorderLayout.NORTH);
        pntab12212.add(pntab122122, BorderLayout.CENTER);
        
        //pntab1221.add(pntab12211, BorderLayout.WEST);
        pntab1221.add(pntab12212, BorderLayout.CENTER);
        //pntab1221.add(pntab12213, BorderLayout.SOUTH);
        
        pntab12.add(pntab121,BorderLayout.NORTH);
        pntab12.add(tab122,BorderLayout.CENTER);
                
        pncontent1.add(pntab11, BorderLayout.WEST);
        pncontent1.add(pntab12, BorderLayout.CENTER);
        
        lblammoi= new JLabel("Làm mới");
        lblammoi.setBackground(Color.black);
        lblammoi.setForeground(Color.white);
        lblammoi.setOpaque(true);
        lblammoi.setHorizontalAlignment(0);
        lblammoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lbthem= new JLabel("Thêm khách hàng");
        lbthem.setBackground(Color.black);
        lbthem.setForeground(Color.white);
        lbthem.setOpaque(true);
        lbthem.setHorizontalAlignment(0);
        lbthem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lbsua= new JLabel("Cập nhật");
        lbsua.setBackground(Color.black);
        lbsua.setForeground(Color.white);
        lbsua.setOpaque(true);
        lbsua.setHorizontalAlignment(0);
        lbsua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lbxoa= new JLabel("Xóa khách hàng");
        lbxoa.setBackground(Color.black);
        lbxoa.setForeground(Color.white);
        lbxoa.setOpaque(true);
        lbxoa.setHorizontalAlignment(0);
        lbxoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        pntab122122.add(lblammoi);
        pntab122122.add(lbthem);
        pntab122122.add(lbsua);
        pntab122122.add(lbxoa);
        
        pntheott= new JPanel();
        pntheott.setLayout(new GridLayout(2, 1, 0, 15));
        pntheott.setPreferredSize(new Dimension(340, 230));
        pntheott.setBackground(Color.white);
        pntheott.setBorder(BorderFactory.createTitledBorder(null, "Theo thông tin khách hàng", 0, 0, new Font("Tahoma",Font.PLAIN,15)));
        
        pnmainfind= new JPanel();
        pnmainfind.setLayout(new GridLayout(1, 1,20,0));
        pnmainfind.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        pnmainfind.setBackground(Color.white);
        
        lbmainfind= new JLabel("Mã KH, tên, điện thoại");
        txmainfind= new JTextField();
        
        pnmainfind.add(lbmainfind);
        pnmainfind.add(txmainfind);
        
        pnidhd= new JPanel();
        pnidhd.setLayout(new GridLayout(1, 1,20,0));
        pnidhd.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        pnidhd.setBackground(Color.white);
        
        lbidhd= new JLabel("Mã hóa đơn");
        txidhd= new JTextField();
        
        pnidhd.add(lbidhd);
        pnidhd.add(txidhd);
        
        pntheott.add(pnmainfind);
        pntheott.add(pnidhd);
        
        pntheonv= new JPanel();
        pntheonv.setLayout(new GridLayout(1, 2, 0, 15));
        pntheonv.setPreferredSize(new Dimension(340, 100));
        pntheonv.setBackground(Color.white);
        pntheonv.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Theo người tạo hóa đơn", 0, 0, new Font("Tahoma",Font.PLAIN,15)),
                            BorderFactory.createEmptyBorder(20,10,20,10)));
        
        lbmanvtao = new JLabel("Mã nhân viên");
        txmanvtao = new JTextField();
        
        pntheonv.add(lbmanvtao);
        pntheonv.add(txmanvtao);
        
        pntheongay= new JPanel();
        pntheongay.setLayout(new GridLayout(1, 2, 0, 15));
        pntheongay.setPreferredSize(new Dimension(340, 100));
        pntheongay.setBackground(Color.white);
        pntheongay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Theo thời gian", 0, 0, new Font("Tahoma",Font.PLAIN,15)),
                            BorderFactory.createEmptyBorder(20,10,20,10)));
        
        lbngaytao = new JLabel("Thời gian");
        txngaytao = new JTextField();
        
        pntheongay.add(lbngaytao);
        pntheongay.add(txngaytao);
        
        pntab11.add(pntheott);
        pntab11.add(pntheonv);
        //pntab11.add(pntheongay);
        
        UIManager.put("TabbedPane.selected", Color.darkGray);
        tab = new JTabbedPane();
        
        pnttkh= new JPanel[thongtin.length];
        txttkh= new JTextField[thongtin.length];
        lbttkh= new JLabel[thongtin.length];
        for(int i=0;i<thongtin.length;i++){
            lbttkh[i]= new JLabel(thongtin[i]);
            lbttkh[i].setHorizontalAlignment(4);
            lbttkh[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            txttkh[i]= new JTextField();
            txttkh[i].setPreferredSize(new Dimension(150,30));
            txttkh[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            txttkh[i].setBackground(Color.white);
            pnttkh[i]= new JPanel();
            pnttkh[i].setBackground(Color.white);
            pnttkh[i].setLayout(new GridLayout(1, 1, 20,0));
            pnttkh[i].setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
            pnttkh[i].add(lbttkh[i]);
            pnttkh[i].add(txttkh[i]);
            pntab122121.add(pnttkh[i]);
        }
        txttkh[0].setEditable(false);
    }
    
    public void getKhachHangPanel(JPanel panel, JPanel pntitle, JLabel lbtitle){
        panel.removeAll();
        panel.setLayout(new BorderLayout(0,15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        lbtitle.removeAll();
        lbtitle.setText("Khách hàng");
        lbtitle.repaint();
        lbtitle.validate();       
        
        addFullTable();
        
        txmainfind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String mainfind= txmainfind.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    pntab121.removeAll();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    pntab121.removeAll();
                    txidhd.setText("");
                    txmanvtao.setText("");
                    JTable table= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                    //table
                    table.setRowHeight(20);
                    JScrollPane scroll= new JScrollPane();
                    table= khbll.showData(mainfind);
                    scroll.setViewportView(table);
                    pntab121.add(scroll,BorderLayout.CENTER);
                    setText2(table);
                    pntab121.repaint();
                    pntab121.validate();
                }
            }
        });
        
        txidhd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    pntab121.removeAll();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    String mahd= txidhd.getText().trim();
                    pntab121.removeAll();
                    txmainfind.setText("");
                    txmanvtao.setText("");
                    JTable table= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                    table.setRowHeight(20);
                    JScrollPane scroll= new JScrollPane();
                    table= khbll.showDataByHDID(mahd);
                    scroll.setViewportView(table);
                    pntab121.add(scroll,BorderLayout.CENTER);
                    setText2(table);
                    pntab121.repaint();
                    pntab121.validate();
                }
            }
        });
        
        txmanvtao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    pntab121.removeAll();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    String manv= txmanvtao.getText().trim();
                    pntab121.removeAll();
                    txmainfind.setText("");
                    txidhd.setText("");
                    JTable table= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                    table.setRowHeight(20);
                    table= khbll.showDataByNVBillCreator(manv);
                    scroll.setViewportView(table);
                    pntab121.add(scroll,BorderLayout.CENTER);
                    setText(table);
                    pntab121.repaint();
                    pntab121.validate();
                }
            }
        });
        
        lblammoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(int i=0;i<thongtin.length;i++){
                    txttkh[i].setText("");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lblammoi.setBackground(Color.white);
                lblammoi.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lblammoi.setBackground(Color.black);
                lblammoi.setForeground(Color.white);
            }
        });
        
        lbthem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pntab121.removeAll();
                String newid= String.valueOf(khbll.getList().getKhachhang().size());
                khdao.insertToDBKhachHang("KH0"+ newid, txttkh[1].getText(), txttkh[2].getText(), txttkh[3].getText(), txttkh[4].getText());
                addFullTable();
                pntab1222dshoadon.removeAll();
                JTable tablels= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                tablels.setRowHeight(20);
                DefaultTableModel modells= new DefaultTableModel();
                JScrollPane scrollls= new JScrollPane();
                String []lsmua= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên bán"};
                modells.setColumnIdentifiers(lsmua);
                tablels.setModel(modells);
                scrollls.setViewportView(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab121.repaint();
                pntab121.validate();
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbthem.setBackground(Color.white);
                lbthem.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbthem.setBackground(Color.black);
                lbthem.setForeground(Color.white);
            }
        });
        
        lbsua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pntab121.removeAll();
                khdao.updateDBKhachHang(txttkh[0].getText(), txttkh[1].getText(), txttkh[2].getText(), txttkh[3].getText(), txttkh[4].getText());
                addFullTable();
                pntab1222dshoadon.removeAll();
                JTable tablels= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                tablels.setRowHeight(20);
                DefaultTableModel modells= new DefaultTableModel();
                JScrollPane scrollls= new JScrollPane();
                String []lsmua= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên bán"};
                modells.setColumnIdentifiers(lsmua);
                tablels.setModel(modells);
                scrollls.setViewportView(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab121.repaint();
                pntab121.validate();
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbsua.setBackground(Color.white);
                lbsua.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbsua.setBackground(Color.black);
                lbsua.setForeground(Color.white);
            }
        });
        
        lbxoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Options[]={"Xóa","Hủy"};
                int choice= JOptionPane.showOptionDialog(null, "Bạn có muốn xóa khách hàng này ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                         null, Options,Options[0]);
                if(choice==0){
                    pntab121.removeAll();
                    khdao.deleteInDBKhachHang(txttkh[0].getText(),khbll.getStatusFromID(txttkh[0].getText()));
                    addFullTable();
                    pntab1222dshoadon.removeAll();
                    JTable tablels= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                    tablels.setRowHeight(20);
                    DefaultTableModel modells= new DefaultTableModel();
                    JScrollPane scrollls= new JScrollPane();
                    String []lsmua= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên bán"};
                    modells.setColumnIdentifiers(lsmua);
                    tablels.setModel(modells);
                    scrollls.setViewportView(tablels);
                    pntab1222dshoadon.add(scrollls);
                    for(int i=0;i<thongtin.length;i++){
                        txttkh[i].setText("");
                    }
                    pntab121.repaint();
                    pntab121.validate();
                    pntab1222dshoadon.repaint();
                    pntab1222dshoadon.validate();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbxoa.setBackground(Color.white);
                lbxoa.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbxoa.setBackground(Color.black);
                lbxoa.setForeground(Color.white);
            }
        });
        
        tab.addTab("Danh sách khách hàng", pncontent1);
        //tab.addTab("Chỉnh sửa thông tin", pncontent2);
        tab.setBackground(Color.lightGray);
        tab.setForeground(Color.white);
        tab.setFont(new Font("Tahoma", Font.PLAIN,25));
        
        panel.add(pntitle, BorderLayout.NORTH);
        panel.add(tab,BorderLayout.CENTER);
        panel.repaint();
        panel.validate();
    }
    
    public void addFullTable(){
        JTable table= new JTable();
        table.setRowHeight(20);
        JScrollPane scroll= new JScrollPane();
        table= khbll.getTable2();
        scroll.setViewportView(table);
        pntab121.add(scroll,BorderLayout.CENTER);
        setText(table);
    }
    
    public void setText(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=tb.getSelectedRow();
                for(int a=0;a<khbll.getHeader().length;a++){
                    txttkh[a].setText(khbll.getTable2().getValueAt(i, a).toString());
                }
                pntab1222dshoadon.removeAll();
                JScrollPane scrollls= new JScrollPane();
                JTable tablels= new JTable(){
                    @Override
                    public boolean isCellEditable(int row, int column) {                
                        switch (column) {
                            default:
                                return false;
                         }              
                    };
                };
                tablels.setRowHeight(20);
                tablels=hdbll.showLichSuMuaHang(khbll.getTable2().getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTLSMua(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }
        });
    }
    
    public int getCurrentRow(String idnv){
        JTable table= new JTable();
        table= khbll.getTable();
        for(int i=0;i<table.getRowCount();i++){
            if(table.getValueAt(i, 0).toString().trim().equals(idnv)){
                return i;
            }
        }
        return 0;
    }
    
    
    public void setText2(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable table2= new JTable();
                table2= khbll.getTable();
                int u= tb.getSelectedRow();
                int i=0;
                for(int r=0;r<tb.getRowCount();r++){
                    if(u == r) {
                        i= getCurrentRow(tb.getValueAt(r, 0).toString());
                        System.out.println(i);
                    }
                }
                
                for(int a=0;a<khbll.getHeader().length;a++){
                    txttkh[a].setText(tb.getValueAt(i, a).toString());
                }
                
                pntab1222dshoadon.removeAll();
                JScrollPane scrollls= new JScrollPane();
                JTable tablels= new JTable(){
                    @Override
                    public boolean isCellEditable(int row, int column) {                
                        switch (column) {
                            default:
                                return false;
                         }              
                    };
                };
                tablels.setRowHeight(20);
                tablels=hdbll.showLichSuMuaHang(tb.getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTLSMua(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }
        });
    }
    
    public void setCTLSMua(JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i= table.getSelectedRow();
                int stt=0;
                pntab1222chitiet.removeAll();
                pntab1222.remove(pntab1222chitiet);
                JTable tablectls= new JTable(){
                        @Override
                        public boolean isCellEditable(int row, int column) {                
                            switch (column) {
                                default:
                                    return false;
                             }              
                        };
                    };
                tablectls.setRowHeight(20);
                DefaultTableModel modelctls= new DefaultTableModel();
                String []ctlsmua= {"STT","Mã sản phẩm", "Tên sản phẩm","Đơn giá","Số lượng","Tổng tiền"};
                modelctls.setColumnIdentifiers(ctlsmua);
                JScrollPane scrollctls= new JScrollPane();
                for(int a= 0;a<cthdbll.getList().getCthoadon().size();a++){
                    if(cthdbll.getList().getCthoadon().get(a).getMa_hd().equals(table.getValueAt(i, 2).toString())){
                        int STT= stt+1;
                        String masp= cthdbll.getList().getCthoadon().get(a).getMa_sp();
                        String tensp= spbll.getSPNameByID(cthdbll.getList().getCthoadon().get(a).getMa_sp());
                        int gia= (int)cthdbll.getList().getCthoadon().get(a).getDongia();
                        int soluong= cthdbll.getList().getCthoadon().get(a).getSoluong();
                        int tong= (int)cthdbll.getList().getCthoadon().get(a).getThanhtien();
                        stt++;
                        Object[] rows= {STT,masp,tensp,gia,soluong,tong};
                        modelctls.addRow(rows);
                    }
                }
                tablectls.setModel(modelctls);
                scrollctls.setViewportView(tablectls);
                pntab1222chitiet.add(scrollctls);
                pntab1222.add(pntab1222chitiet);
                pntab1222.repaint();
                pntab1222.validate();
                pntab1222chitiet.repaint();
                pntab1222chitiet.validate();
            }
        });
    }
}
