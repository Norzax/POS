/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import imart.BLL.ctPhieuNhapBLL;
import imart.BLL.nhaCCapBLL;
import imart.BLL.phieuNhapBLL;
import imart.BLL.sanPhamBLL;
import imart.DAO.nhaCCapDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Bao Luan
 */
public class nhaCungCapPanel {
    private JPanel pncontent1, pntab11, pntab12, pntab121, pntab1221,pntab12211, pntab12212,pntab122121, pntab122122,pntab12213, pntab1222, 
                    pntab1222chitiet, pntab1222dshoadon, pnmainfind,pnidhd,pntheott, pntheongay, pntheonv;
    private JLabel lbmainfind, lbidhd, lblammoi, lbthem, lbsua, lbxoa, lbngaytao, lbmanvtao;
    private JPanel pnttncc[];
    private JTextField txmainfind, txidhd, txngaytao, txmanvtao;
    private JTextField txttncc[];
    private JLabel lbttncc[];
    private String thongtin[]={"Mã nhà cung cấp","Tên nhà cung cấp","Địa chỉ","Số điện thoại"};
    private JTabbedPane tab= new JTabbedPane();
    private JTabbedPane tab122;
    private static JTable tablencc = new JTable();
    private static DefaultTableModel modelncc= new DefaultTableModel();
    private static JScrollPane scroll= new JScrollPane();
    nhaCCapBLL nccbll= new nhaCCapBLL();
    phieuNhapBLL pnbll= new phieuNhapBLL();
    ctPhieuNhapBLL ctpnbll= new ctPhieuNhapBLL();
    sanPhamBLL spbll= new sanPhamBLL();
    nhaCCapDAO nccdao= new nhaCCapDAO();
    
    public nhaCungCapPanel(){
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
            };
        };
        tablels.setRowHeight(20);
        DefaultTableModel modells= new DefaultTableModel();
        JScrollPane scrollls= new JScrollPane();
        String []hdban= {"Thời gian","Tổng tiền", "Mã hóa đơn","Nhân viên"};
        modells.setColumnIdentifiers(hdban);
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
        String []cthdban= {"STT","Mã sản phẩm", "Tên sản phẩm","Đơn giá","Số lượng","Tổng tiền"};
        modelctls.setColumnIdentifiers(cthdban);
        tablectls.setModel(modelctls);
        scrollctls.setViewportView(tablectls);
        pntab1222chitiet.add(scrollctls);
        
        pntab1222.add(pntab1222dshoadon);
        pntab1222.add(pntab1222chitiet);
        
        
        tab122.addTab("Thông tin",pntab1221);
        tab122.addTab("Phiếu nhâp hàng",pntab1222);
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
        pntab122121.setLayout(new GridLayout(4,1));
        pntab122121.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Chỉnh sửa, thêm mới nhà cung cấp", 0, 0, new Font("Tahoma", Font.PLAIN, 20)),
                                BorderFactory.createEmptyBorder(0, 100, 0, 300)));
        
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
        
        lbthem= new JLabel("Thêm nhà cung cấp");
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
        
        lbxoa= new JLabel("Xóa nhà cung cấp");
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
        pntheott.setBorder(BorderFactory.createTitledBorder(null, "Theo thông tin nhà cung cấp", 0, 0, new Font("Tahoma",Font.PLAIN,15)));
        
        pnmainfind= new JPanel();
        pnmainfind.setLayout(new GridLayout(1, 1,20,0));
        pnmainfind.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        pnmainfind.setBackground(Color.white);
        
        lbmainfind= new JLabel("Mã NV, tên, điện thoại");
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
//        pntab11.add(pntheonv);
//        pntab11.add(pntheongay);
        
        UIManager.put("TabbedPane.selected", Color.darkGray);
        tab = new JTabbedPane();
        
        pnttncc= new JPanel[thongtin.length];
        txttncc= new JTextField[thongtin.length];
        lbttncc= new JLabel[thongtin.length];
        for(int i=0;i<thongtin.length;i++){
            lbttncc[i]= new JLabel(thongtin[i]);
            lbttncc[i].setHorizontalAlignment(JLabel.RIGHT);
            lbttncc[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            lbttncc[i].setPreferredSize(new Dimension(300, 50));
            txttncc[i]= new JTextField();
            txttncc[i].setPreferredSize(new Dimension(700,30));
            txttncc[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            txttncc[i].setBackground(Color.white);
            pnttncc[i]= new JPanel();
            pnttncc[i].setBackground(Color.white);
            pnttncc[i].setLayout(new FlowLayout(0, 20, 0));
            pnttncc[i].setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
            pnttncc[i].add(lbttncc[i]);
            pnttncc[i].add(txttncc[i]);
            pntab122121.add(pnttncc[i]);
        }
        txttncc[0].setEditable(false);
    }
    
    public void getNhaCungCapPanel(JPanel panel, JPanel pntitle, JLabel lbtitle){
        panel.removeAll();
        panel.setLayout(new BorderLayout(0,15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        lbtitle.removeAll();
        lbtitle.setText("Nhà cung cấp");
        lbtitle.repaint();
        lbtitle.validate();       
        
        addFullTable();
        
        txmainfind.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    pntab121.removeAll();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    String mainfind= txmainfind.getText().trim();
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
                    table.setRowHeight(20);
                    JScrollPane scroll= new JScrollPane();
                    table= nccbll.showData(mainfind);
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
                    String mapn= txidhd.getText().trim();
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
                    table= nccbll.showDataByPNID(mapn);
                    scroll.setViewportView(table);
                    pntab121.add(scroll,BorderLayout.CENTER);
                    setText2(table);
                    pntab121.repaint();
                    pntab121.validate();
                }
            }
        });
        
        lblammoi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(int i=0;i<thongtin.length;i++){
                    txttncc[i].setText("");
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
                                // 0: id, 1: ho, 2:ten , 3: ngaysinh, 4: dienthoai, 5: ngayvaolam, 6: gioitinh, 7: diachi, 8: machucvu  DB
                                // 0: id, 1: ho, 2:ten , 3: ngaysinh, 4: diachi, 5: dienthoai, 6: ngayvao lam, 7: gioitinh, 8: machucvu GET AND CHANGE
        lbthem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pntab121.removeAll();
                String newid= String.valueOf(nccbll.getList().getNcc().size()+1);
                nccdao.insertToDBNhaCungCap("NCC0"+newid, txttncc[1].getText(), txttncc[2].getText(), txttncc[3].getText());
                addFullTable();
                
                pntab121.repaint();
                pntab121.validate();
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
                nccdao.updateDBNhaCungCap(txttncc[0].getText(), txttncc[1].getText(), txttncc[2].getText(), txttncc[3].getText());
                addFullTable();
                
                pntab121.repaint();
                pntab121.validate();
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
                int choice= JOptionPane.showOptionDialog(null, "Bạn có muốn xóa nhà cung cấp này ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                         null, Options,Options[0]);
                if(choice==0){
                    pntab121.removeAll();
                    nccdao.deleteInDBNhaCungCap(txttncc[0].getText());
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
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
        
        tab.addTab("Danh sách nhà cung cấp", pncontent1);
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
        table= nccbll.getTable();
        scroll.setViewportView(table);
        pntab121.add(scroll,BorderLayout.CENTER);
        setText(table);
    }
    
    public void setText(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=tb.getSelectedRow();
                for(int a=0;a<nccbll.getHeader().length;a++){
                    txttncc[a].setText(nccbll.getTable().getValueAt(i, a).toString());
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
                tablels=pnbll.showLichSuNhapHang(nccbll.getTable().getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTPNhap(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }
        });
    }
    
    public void setText2(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int u= tb.getSelectedRow();
                int i=0;
                for(int r=0;r<tb.getRowCount();r++){
                    if(u == r) {
                        i= getCurrentRow(tb.getValueAt(r, 0).toString());
                        System.out.println(i);
                    }
                }
                
                for(int a=0;a<nccbll.getHeader().length;a++){
                    txttncc[a].setText(nccbll.getTable().getValueAt(i, a).toString());
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
                tablels=pnbll.showLichSuNhapHang(nccbll.getTable().getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTPNhap(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }
        });
    }
    
    public int getCurrentRow(String idnv){
        JTable table= new JTable();
        table= nccbll.getTable();
        for(int i=0;i<table.getRowCount();i++){
            if(table.getValueAt(i, 0).toString().trim().equals(idnv)){
                return i;
            }
        }
        return 0;
    }
    
    public void setCTPNhap(JTable table){
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
                String []cthdban= {"STT","Mã sản phẩm", "Tên sản phẩm","Đơn giá","Số lượng","Tổng tiền"};
                modelctls.setColumnIdentifiers(cthdban);
                JScrollPane scrollctls= new JScrollPane();
                for(int a= 0;a<ctpnbll.getList().getCtphieunhap().size();a++){
                    if(ctpnbll.getList().getCtphieunhap().get(a).getMa_pn().equals(table.getValueAt(i, 2).toString())){
                        int STT= stt+1;
                        String masp= ctpnbll.getList().getCtphieunhap().get(a).getMa_sp();
                        String tensp= spbll.getSPNameByID(ctpnbll.getList().getCtphieunhap().get(a).getMa_sp());
                        int gia= (int)ctpnbll.getList().getCtphieunhap().get(a).getDongia();
                        int soluong= ctpnbll.getList().getCtphieunhap().get(a).getSoluong();
                        int tong= (int)ctpnbll.getList().getCtphieunhap().get(a).getThanhtien();
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
