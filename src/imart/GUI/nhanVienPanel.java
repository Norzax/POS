/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import com.toedter.calendar.JDateChooser;
import imart.BLL.chucVuBLL;
import imart.BLL.ctHoaDonBLL;
import imart.BLL.hoaDonBLL;
import imart.BLL.nhanVienBLL;
import imart.BLL.quyenHanBLL;
import imart.BLL.sanPhamBLL;
import imart.DAO.nhanVienDAO;
import imart.DAO.quyenHanDAO;
import imart.DAO.taiKhoanDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
public class nhanVienPanel {
    private JPanel pncontent1, pntab11, pntab12, pntab121, pntab1221,pntab12211, pntab12212,pntab122121, pntab122122,pntab12213, pntab1222, pntab1223, pntab12231, pntab1224,
                    pntab1222chitiet, pntab1222dshoadon, pnmainfind,pnidhd,pntheott, pntheongay, pntheonv, pnchucvu, pncnquyen, pngender;
    private JLabel lbmainfind, lbidhd, lblammoi, lbthem, lbsua, lbxoa, lbngaytao, lbmanvtao, lbchucvu, lbcnquyen;
    private JPanel pnttnv[], pnphanquyen[];
    private JTextField txmainfind, txidhd, txngaytao, txmanvtao;
    private JTextField txttnv[];
    private JComboBox cbchucvu;
    private JCheckBox chbquyenhan[];
    private JLabel lbttnv[], lbphanquyen[];
    JDateChooser ngaysinh= new JDateChooser();
    JDateChooser ngayvaolam= new JDateChooser();
    private String thongtin[]={"Mã nhân viên","Họ","Tên","Ngày sinh","Địa chỉ","Số điện thoại","Ngày vào làm","Giới tính","Mã chức vụ"};
    private JTabbedPane tab= new JTabbedPane();
    private JTabbedPane tab122;
    private static JTable tablekh = new JTable();
    private static DefaultTableModel modelkh= new DefaultTableModel();
    private static JScrollPane scroll= new JScrollPane();
    private JRadioButton rdbmale, rdbfemale;
    hoaDonBLL hdbll= new hoaDonBLL();
    ctHoaDonBLL cthdbll= new ctHoaDonBLL();
    sanPhamBLL spbll= new sanPhamBLL();
    nhanVienDAO nvdao= new nhanVienDAO();
    taiKhoanDAO tkdao= new taiKhoanDAO();
    quyenHanDAO qhdao= new quyenHanDAO();
    nhanVienBLL nvbll= new nhanVienBLL();
    chucVuBLL cvbll= new chucVuBLL();
    quyenHanBLL qhbll= new quyenHanBLL();
    
    public nhanVienPanel(){
        initComponents();
    }
    
    public void initComponents(){
        LocalDate date= LocalDate.now();
        ngayvaolam.setDate(Date.valueOf(date));
        
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
        
        pntab1223= new JPanel();
        pntab1223.setLayout(new BorderLayout(0, 0));
        
        pntab1224= new JPanel();
        //pntab1224.setLayout(new GridLayout(2,1));
        
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
        String []hdban= {"Thời gian","Tổng tiền", "Mã hóa đơn","Khách hàng"};
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
        tab122.addTab("Hóa đơn bán hàng",pntab1222);
        //tab122.addTab("Phân quyền", pntab1223);
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
        pntab122121.setLayout(new GridLayout(5,2,10,0));
        pntab122121.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Chỉnh sửa, thêm mới nhân viên", 0, 0, new Font("Tahoma", Font.PLAIN, 20)),
                                BorderFactory.createEmptyBorder(0, 0, 0, 130)));
        
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
        
        lbthem= new JLabel("Thêm nhân viên");
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
        
        lbxoa= new JLabel("Xóa nhân viên");
        lbxoa.setBackground(Color.black);
        lbxoa.setForeground(Color.white);
        lbxoa.setOpaque(true);
        lbxoa.setHorizontalAlignment(0);
        lbxoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lbchucvu= new JLabel("Chức vụ");
        lbchucvu.setHorizontalAlignment(4);
        lbchucvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cbchucvu= new JComboBox(cvbll.getTenChucVu());
        cbchucvu.setPreferredSize(new Dimension(150,30));
        cbchucvu.setBackground(Color.white);
        
        pntab122122.add(lblammoi);
        pntab122122.add(lbthem);
        pntab122122.add(lbsua);
        pntab122122.add(lbxoa);
        
        pntheott= new JPanel();
        pntheott.setLayout(new GridLayout(2, 1, 0, 15));
        pntheott.setPreferredSize(new Dimension(340, 230));
        pntheott.setBackground(Color.white);
        pntheott.setBorder(BorderFactory.createTitledBorder(null, "Theo thông tin nhân viên", 0, 0, new Font("Tahoma",Font.PLAIN,15)));
        
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
        
        pngender = new JPanel();
        pngender.setLayout(new GridLayout());
        
        rdbmale= new JRadioButton("Nam");
        rdbmale.setBackground(Color.white);
        rdbmale.setSelected(true);
        rdbfemale= new JRadioButton("Nữ");
        rdbfemale.setBackground(Color.white);
        
        rdbmale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdbmale.isSelected())
                    rdbfemale.setSelected(false);
            }
        });

        rdbfemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdbfemale.isSelected())
                    rdbmale.setSelected(false);
            }
        });
        
        pngender.add(rdbmale);
        pngender.add(rdbfemale);

        UIManager.put("TabbedPane.selected", Color.darkGray);
        tab = new JTabbedPane();
        
        pnttnv= new JPanel[thongtin.length];
        txttnv= new JTextField[thongtin.length];
        lbttnv= new JLabel[thongtin.length];
        for(int i=0;i<thongtin.length;i++){
            lbttnv[i]= new JLabel(thongtin[i]);
            lbttnv[i].setHorizontalAlignment(4);
            lbttnv[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            txttnv[i]= new JTextField();
            txttnv[i].setPreferredSize(new Dimension(150,30));
            txttnv[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            txttnv[i].setBackground(Color.white);
            pnttnv[i]= new JPanel();
            pnttnv[i].setBackground(Color.white);
            pnttnv[i].setLayout(new GridLayout(1, 1, 20,0));
            pnttnv[i].setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
            pnttnv[i].add(lbttnv[i]);
            pnttnv[i].add(txttnv[i]);
            pntab122121.add(pnttnv[i]);
        }
        pnttnv[thongtin.length-2].remove(txttnv[thongtin.length-2]);
        pnttnv[thongtin.length-2].add(pngender);
        pnttnv[3].remove(txttnv[3]);
        pnttnv[3].add(ngaysinh);
        pnttnv[6].remove(txttnv[6]);
        pnttnv[6].add(ngayvaolam);
        pntab122121.remove(pnttnv[thongtin.length-1]);
        pnchucvu= new JPanel();
        pnchucvu.setBackground(Color.white);
        pnchucvu.setLayout(new GridLayout(1, 1, 20,0));
        pnchucvu.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
        pnchucvu.add(lbchucvu);
        pnchucvu.add(cbchucvu);
        pntab122121.add(pnchucvu);
        txttnv[8].setEditable(false);
        txttnv[0].setEditable(false);
        
        cbchucvu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chucvu = cbchucvu.getSelectedItem().toString().trim();
                txttnv[8].setText(cvbll.getMaFromName(chucvu));
            }
        });
        
        pntab12231= new JPanel();
        pntab12231.setPreferredSize(new Dimension(0, 250));
        pntab12231.setLayout(new GridLayout(3,3,20,10));
        
        pncnquyen= new JPanel();
        pncnquyen.setLayout(new BorderLayout(0, 0));
        pncnquyen.setPreferredSize(new Dimension(0, 100));
        pncnquyen.setBorder(BorderFactory.createEmptyBorder(10,400,10,400));
        
        lbcnquyen= new JLabel("Cập nhật");
        lbcnquyen.setBackground(Color.black);
        lbcnquyen.setForeground(Color.white);
        lbcnquyen.setOpaque(true);
        lbcnquyen.setHorizontalAlignment(0);
        lbcnquyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pncnquyen.add(lbcnquyen,BorderLayout.CENTER);
        
        pntab1223.add(pntab12231,BorderLayout.CENTER);
        pntab1223.add(pncnquyen,BorderLayout.SOUTH);
        
        lbphanquyen = new JLabel[qhbll.getHeader().length];
        pnphanquyen= new JPanel[qhbll.getHeader().length];
        chbquyenhan= new JCheckBox[qhbll.getHeader().length];
        for(int i=0;i<qhbll.getHeader().length;i++){
            lbphanquyen[i]= new JLabel(qhbll.getHeader()[i]);
            lbphanquyen[i].setPreferredSize(new Dimension(300, 50));
            lbphanquyen[i].setHorizontalAlignment(JLabel.RIGHT);
            lbphanquyen[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
            chbquyenhan[i]= new JCheckBox();
            pnphanquyen[i]=new JPanel();
            pnphanquyen[i].setLayout(new GridLayout(1, 2, 20, 0));
            pnphanquyen[i].setBorder(BorderFactory.createLineBorder(Color.black));
            pnphanquyen[i].add(lbphanquyen[i]);
            pnphanquyen[i].add(chbquyenhan[i]);
            pntab12231.add(pnphanquyen[i]);
        }
    }
    
    public void getNhanVienPanel(JPanel panel, JPanel pntitle, JLabel lbtitle){
        panel.removeAll();
        panel.setLayout(new BorderLayout(0,15));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        lbtitle.removeAll();
        lbtitle.setText("Nhân viên");
        lbtitle.repaint();
        lbtitle.validate();       
        
        addFullTable();
        
        txmainfind.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyReleased(KeyEvent e) {
                String mainfind= txmainfind.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    pntab121.removeAll();
                    addNewCTAndLS();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    addNewCTAndLS();
                    pntab121.removeAll();
                    txidhd.setText("");
                    txmanvtao.setText("");
                    JTable table= new JTable();
                    table.setRowHeight(20);
                    JScrollPane scroll= new JScrollPane();
                    table= nvbll.showData(mainfind);
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
                    addNewCTAndLS();
                    addFullTable();
                    pntab121.repaint();
                    pntab121.validate();
                } else {
                    addNewCTAndLS();
                    String mahd= txidhd.getText().trim();
                    pntab121.removeAll();
                    txmainfind.setText("");
                    txmanvtao.setText("");
                    JTable table= new JTable();
                    table.setRowHeight(20);
                    JScrollPane scroll= new JScrollPane();
                    table= nvbll.showDataByHDID(mahd);
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
                    txttnv[i].setText("");
                }
                LocalDate date= LocalDate.now();
                ngayvaolam.setDate(Date.valueOf(date));
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
                String newid= String.valueOf(nvbll.getList().getNhanvien().size());
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
                nvdao.insertToDBNhanVien("NV0"+ newid ,txttnv[1].getText(), txttnv[2].getText(), Date_Format.format(ngaysinh.getDate()), txttnv[4].getText(), 
                                        txttnv[5].getText(), Date_Format.format(ngayvaolam.getDate()), selectGender(), cvbll.getMaFromName(cbchucvu.getSelectedItem().toString()));
//                tkdao.insertToDBTaiKhoan("NV0"+ newid, "NV0"+ newid, "NV0"+ newid+ newid);
//                qhdao.insertToDBquyenHan("NV0"+ newid);
                addFullTable();
                pntab1222dshoadon.removeAll();
                JTable tablels= new JTable();
                tablels.setRowHeight(20);
                DefaultTableModel modells= new DefaultTableModel();
                JScrollPane scrollls= new JScrollPane();
                String []lsban= {"Thời gian","Tổng tiền", "Mã hóa đơn","Khách hàng"};
                modells.setColumnIdentifiers(lsban);
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
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
                nvdao.updateDBNhanVien(txttnv[0].getText(), txttnv[1].getText(), txttnv[2].getText(), Date_Format.format(ngaysinh.getDate()), txttnv[4].getText(), 
                                        txttnv[5].getText(), Date_Format.format(ngayvaolam.getDate()), selectGender(), 
                                        cvbll.getMaFromName(cbchucvu.getSelectedItem().toString()));
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
                int choice= JOptionPane.showOptionDialog(null, "Bạn có muốn xóa nhân viên này ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                         null, Options,Options[0]);
                if(choice==0){
                    pntab121.removeAll();
                    tkdao.deleteInDBTaiKhoan(txttnv[0].getText());
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
        
        tab.addTab("Danh sách nhân viên", pncontent1);
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
        table= nvbll.getTable();
        scroll.setViewportView(table);
        pntab121.add(scroll,BorderLayout.CENTER);
        setText(table);
    }
    
    public String selectGender(){
        if(rdbmale.isSelected())
            return "1";
        else 
            return "2";
    }
    
    public int getCurrentRow(String idnv){
        JTable table= new JTable();
        table= nvbll.getTable();
        for(int i=0;i<table.getRowCount();i++){
            if(table.getValueAt(i, 0).toString().trim().equals(idnv)){
                return i;
            }
        }
        return 0;
    }
    
    public void setText(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=tb.getSelectedRow();
                for(int a=0;a<nvbll.getHeader().length;a++){
                    txttnv[a].setText(nvbll.getTable().getValueAt(i, a).toString());
                }
                for(int cv=0;cv<cbchucvu.getItemCount();cv++){
                    if(cbchucvu.getItemAt(cv).toString().equals(cvbll.getNameFromID(tb.getValueAt(i, thongtin.length-1).toString()))){
                        cbchucvu.setSelectedItem(cbchucvu.getItemAt(cv));
                    }
                }
                if(tb.getValueAt(i, thongtin.length-2).toString().equalsIgnoreCase("nam")){
                    rdbfemale.setSelected(false);
                    rdbmale.setSelected(true);
                } else {
                    rdbfemale.setSelected(true);
                    rdbmale.setSelected(false);
                }
                
                SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 
                String date = Date_Format.format(Date.valueOf(tb.getValueAt(i, 6).toString()));
                java.util.Date date2;
                try {
                    date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    ngayvaolam.setDate(date2);
                } catch (ParseException ex) {
                    System.out.println("ok");
                }
                
                SimpleDateFormat Date_Format2 = new SimpleDateFormat("dd-MM-yyyy"); 
                String date3 = Date_Format2.format(Date.valueOf(tb.getValueAt(i, 3).toString()));
                java.util.Date date4;
                try {
                    date4 = new SimpleDateFormat("dd-MM-yyyy").parse(date3);
                    ngaysinh.setDate(date4);
                } catch (ParseException ex) {
                    System.out.println("ok");
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
                tablels=hdbll.showLichSuBanHang(nvbll.getTable().getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTHDBan(tablels);
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
                JTable table2= new JTable();
                table2= nvbll.getTable();
                int u= tb.getSelectedRow();
                int i=0;
                for(int r=0;r<tb.getRowCount();r++){
                    if(u == r) {
                        i= getCurrentRow(tb.getValueAt(r, 0).toString());
                    }
                }
                for(int a=0;a<nvbll.getHeader().length;a++){
                    txttnv[a].setText(nvbll.getTable().getValueAt(i, a).toString());
                }
                for(int cv=0;cv<cbchucvu.getItemCount();cv++){
                    if(cbchucvu.getItemAt(cv).toString().equals(cvbll.getNameFromID(table2.getValueAt(i, thongtin.length-1).toString()))){
                        cbchucvu.setSelectedItem(cbchucvu.getItemAt(cv));
                    }
                }
                if(table2.getValueAt(i, thongtin.length-2).toString().equalsIgnoreCase("nam")){
                    rdbfemale.setSelected(false);
                    rdbmale.setSelected(true);
                } else {
                    rdbfemale.setSelected(true);
                    rdbmale.setSelected(false);
                }
                
                SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 
                String date = Date_Format.format(Date.valueOf(table2.getValueAt(i, 6).toString()));
                java.util.Date date2;
                try {
                    date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                    ngayvaolam.setDate(date2);
                } catch (ParseException ex) {
                    System.out.println("ok");
                }
                
                SimpleDateFormat Date_Format2 = new SimpleDateFormat("dd-MM-yyyy"); 
                String date3 = Date_Format2.format(Date.valueOf(table2.getValueAt(i, 3).toString()));
                java.util.Date date4;
                try {
                    date4 = new SimpleDateFormat("dd-MM-yyyy").parse(date3);
                    ngaysinh.setDate(date4);
                } catch (ParseException ex) {
                    System.out.println("ok");
                }
                
                pntab1222dshoadon.removeAll();
                JScrollPane scrollls= new JScrollPane();
                JTable tablels= new JTable();
                tablels.setRowHeight(20);
                tablels=hdbll.showLichSuBanHang(nvbll.getTable().getValueAt(i, 0).toString());
                scrollls.setViewportView(tablels);
                setCTHDBan(tablels);
                pntab1222dshoadon.add(scrollls);
                pntab1222dshoadon.repaint();
                pntab1222dshoadon.validate();
            }
        });
    }
    
    public String dateChange(String date){
        return null;
    }
    
    public void addNewCTAndLS(){
        pntab1222.removeAll();
        pntab1222dshoadon.removeAll();
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
        String []hdban= {"Thời gian","Tổng tiền", "Mã hóa đơn","Khách hàng"};
        modells.setColumnIdentifiers(hdban);
        tablels.setModel(modells);
        scrollls.setViewportView(tablels);
        pntab1222dshoadon.add(scrollls);
        pntab1222dshoadon.repaint();
        pntab1222dshoadon.validate();
        
        pntab1222chitiet.removeAll();
        JTable tablectls= new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    default:
                        return false;
                 }              
            }
        };
        tablectls.setRowHeight(20);
        DefaultTableModel modelctls= new DefaultTableModel();
        JScrollPane scrollctls= new JScrollPane();
        String []cthdban= {"STT","Mã sản phẩm", "Tên sản phẩm","Đơn giá","Số lượng","Tổng tiền"};
        modelctls.setColumnIdentifiers(cthdban);
        tablectls.setModel(modelctls);
        scrollctls.setViewportView(tablectls);
        pntab1222chitiet.add(scrollctls);
        pntab1222chitiet.repaint();
        pntab1222chitiet.validate();
        
        pntab1222dshoadon.add(scrollls);
        pntab1222chitiet.add(scrollctls);
        pntab1222.add(pntab1222dshoadon);
        pntab1222.add(pntab1222chitiet);
        pntab1222.repaint();
        pntab1222.validate();
    }
    
    public void setCTHDBan(JTable table){
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
    public static void main(String[] args) {
        System.out.println(800000*30);
    }
}
