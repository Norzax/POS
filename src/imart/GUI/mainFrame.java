/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import imart.BLL.nhanVienBLL;
import imart.BLL.sanPhamBLL;
import imart.BLL.taiKhoanBLL;
import imart.DAO.connect;
import imart.DAO.nhanVienDAO;
import imart.DAO.taiKhoanDAO;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.LineBorder;

/**
 *
 * @author Bao Luan
 */
public class mainFrame extends JFrame {

    private String[] menu = {"Bán hàng", "Sản phẩm", "Giao dịch", "Đối tác", "Báo cáo", "Cá nhân", "Đăng xuất"};
    private JPanel pnhead, pnlogo, pnmenu, pncontent, pntitle, pntool, pnicon, pnStart;
    private JProgressBar pb;
    private String username;
    private JLabel lbtitle, lbicon, close, minimize, lblogoname, logout, profile, resume;
    private String password;
    private JMenuBar menuBar;
    private JMenu menuBanHang, menuQuanLyKho, menuDanhMuc, menuQuanTri;
    private JMenuItem jmiHoaDon, jmiThongKe, jmiThongtinKH, jmiQuanLyKho, jmiNhapHang, jmiNCC, jmiQLyHoaDon, jmiQLyNhanVien, jmiPhanQuyen, jmiLuongNhanVien;
    private LineBorder line;
    sanPhamBLL spbll = new sanPhamBLL();
    taiKhoanBLL tkbll = new taiKhoanBLL();
    connect conn= new connect();
    
    public mainFrame(String us, String pw) {
        initComponents(us, pw);
        checkQuyen();
    }
    
    public void initComponents(String us, String pw) {
        setUsername(us);
        setPassword(pw);
        // tạo layout cho main
        this.setLayout(new BorderLayout(15, 15));
        
        pntool= new JPanel();
        pntool.setLayout(new GridLayout(1,2,5,0));
        pntool.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 5));
        pntool.setBackground(Color.white);
        
        line= new LineBorder(Color.red,10,true);
        
        close = new JLabel("X");
        //close.setFont(new Font("Tahoma", Font.BOLD,20));
        close.setBackground(Color.red);
        close.setPreferredSize(new Dimension(60,60));
        close.setHorizontalAlignment(0);
        close.setOpaque(true);
        close.setForeground(Color.white);
        close.setBorder(line);
        
        ImageIcon imageLogOut = new ImageIcon(new ImageIcon("logout.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        ImageIcon imageProfile = new ImageIcon(new ImageIcon("myinfo.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon imageResume = new ImageIcon(new ImageIcon("resume.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        
        logout = new JLabel();
        logout.setIcon(imageLogOut);
        logout.setFont(new Font("Tahoma", Font.BOLD,20));
        logout.setBackground(Color.red);
        logout.setPreferredSize(new Dimension(60,60));
        logout.setHorizontalAlignment(0);
        logout.setOpaque(true);
        logout.setForeground(Color.white);
        logout.setBorder(line);
        logout.setVisible(false);
        
        profile = new JLabel();
        profile.setIcon(imageProfile);
        profile.setFont(new Font("Tahoma", Font.BOLD,20));
        profile.setBackground(Color.red);
        profile.setPreferredSize(new Dimension(60,60));
        profile.setHorizontalAlignment(0);
        profile.setOpaque(true);
        profile.setForeground(Color.white);
        profile.setBorder(line);
        
        resume = new JLabel();
        resume.setIcon(imageResume);
        resume.setFont(new Font("Tahoma", Font.BOLD,20));
        resume.setBackground(Color.red);
        resume.setPreferredSize(new Dimension(60,60));
        resume.setHorizontalAlignment(0);
        resume.setOpaque(true);
        resume.setForeground(Color.white);
        resume.setBorder(line);
        resume.setVisible(false);
        
        minimize= new JLabel("-");
        minimize.setFont(new Font("Tahoma", Font.BOLD,20));
        minimize.setBackground(Color.red);
        minimize.setPreferredSize(new Dimension(60,60));
        minimize.setHorizontalAlignment(0);
        minimize.setOpaque(true);
        minimize.setForeground(Color.white);
        minimize.setBorder(line);

        pntool.add(resume);
        pntool.add(logout);
        pntool.add(profile);
        pntool.add(minimize);
        pntool.add(close);
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        lbicon= new JLabel(imageIcon);
        lblogoname= new JLabel("I Mart");
        lblogoname.setFont(new Font("Serif", Font.BOLD, 30));
        
        pnicon= new JPanel();
        pnicon.setLayout(new FlowLayout(0,15,0));
        pnicon.add(lbicon);
        pnicon.add(lblogoname);
        
        // panel này chứa menu với logo 
        pnhead = new JPanel();
        pnhead.setBackground(Color.white);
        pnhead.setPreferredSize(new Dimension(1000, 140));
        pnhead.setLayout(new GridLayout(2,1));

        // panel logo 
        pnlogo = new JPanel();
        pnlogo.setBackground(Color.white);
        pnlogo.setPreferredSize(new Dimension(0, 10));
        pnlogo.setLayout(new BorderLayout());
        pnlogo.setBorder(BorderFactory.createEmptyBorder(0, 50,0,0));

        // panel chứa các control 
        pnmenu = new JPanel();
        pnmenu.setBackground(Color.black);
        pnmenu.setPreferredSize(new Dimension(0, 0));
        pnmenu.setLayout(new GridLayout(1, menu.length));
        
        pntitle = new JPanel();
        pntitle.setPreferredSize(new Dimension(1510, 60));
        pntitle.setBackground(Color.white);
        pntitle.setLayout(null);
        
        lbtitle = new JLabel();
        lbtitle.setBounds(20, 15, 300, 30);
        lbtitle.setBackground(Color.white);
        lbtitle.setOpaque(true);
        lbtitle.setFont(new Font("San-serif", Font.PLAIN, 20));
        lbtitle.setHorizontalAlignment(2);
        pntitle.add(lbtitle);
        pntitle.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        
        ImageIcon imageIconCart = new ImageIcon(new ImageIcon("cart.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon imageIconProduct = new ImageIcon(new ImageIcon("product.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon imageIconManager = new ImageIcon(new ImageIcon("manager.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon imageIconCategory = new ImageIcon(new ImageIcon("categories.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        ImageIcon imageIconManagementEmployee = new ImageIcon(new ImageIcon("managementemployee.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconPayroll = new ImageIcon(new ImageIcon("payroll.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconSupplier = new ImageIcon(new ImageIcon("supplier.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconDecentralization = new ImageIcon(new ImageIcon("decentralization.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconBill = new ImageIcon(new ImageIcon("bill.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconWarehouse = new ImageIcon(new ImageIcon("warehouse.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconImportGoods = new ImageIcon(new ImageIcon("importgoods.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconStatistical = new ImageIcon(new ImageIcon("statistical.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconManagementCustomer = new ImageIcon(new ImageIcon("managementcustomer.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        ImageIcon imageIconInvoice = new ImageIcon(new ImageIcon("invoice.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                
        Font jmiFont = new Font("Tahoma", Font.PLAIN, 15);
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.black);
        menuBar.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));
        
        menuBanHang = new JMenu("Bán hàng");
        menuBanHang.setPreferredSize(new Dimension(180, 50));
        menuBanHang.setIcon(imageIconCart);
        menuBanHang.setForeground(Color.white);
        menuBanHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jmiHoaDon = new JMenuItem("Hóa đơn mới");
        jmiHoaDon.setIcon(imageIconInvoice);
        jmiHoaDon.setPreferredSize(new Dimension(200, 50));
        jmiHoaDon.setFont(jmiFont);
        jmiThongtinKH = new JMenuItem("Thông tin khách hàng");
        jmiThongtinKH.setIcon(imageIconManagementCustomer);
        jmiThongtinKH.setPreferredSize(new Dimension(200, 50));
        jmiThongtinKH.setFont(jmiFont);
        jmiThongKe = new JMenuItem("Thống kê");
        jmiThongKe.setIcon(imageIconStatistical);
        jmiThongKe.setPreferredSize(new Dimension(200, 50));
        jmiThongKe.setFont(jmiFont);
        menuBanHang.add(jmiHoaDon);
        menuBanHang.add(jmiThongtinKH);
        menuBanHang.add(jmiThongKe);
        
        menuQuanLyKho = new JMenu("Sản phẩm");
        menuQuanLyKho.setPreferredSize(new Dimension(180, 50));
        menuQuanLyKho.setIcon(imageIconProduct);
        menuQuanLyKho.setForeground(Color.white);
        menuQuanLyKho.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jmiQuanLyKho = new JMenuItem("Quản Lý Kho");
        jmiQuanLyKho.setIcon(imageIconWarehouse);
        jmiQuanLyKho.setPreferredSize(new Dimension(200, 50));
        jmiQuanLyKho.setFont(jmiFont);
        jmiNhapHang = new JMenuItem("Nhập hàng");
        jmiNhapHang.setIcon(imageIconImportGoods);
        jmiNhapHang.setPreferredSize(new Dimension(200, 50));
        jmiNhapHang.setFont(jmiFont);
        menuQuanLyKho.add(jmiNhapHang);
        menuQuanLyKho.add(jmiQuanLyKho);
        
        menuDanhMuc = new JMenu("Danh mục");
        menuDanhMuc.setPreferredSize(new Dimension(180, 50));
        menuDanhMuc.setIcon(imageIconCategory);
        menuDanhMuc.setForeground(Color.white);
        menuDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jmiQLyHoaDon = new JMenuItem("Danh sách hóa đơn");
        jmiQLyHoaDon.setIcon(imageIconBill);
        jmiQLyHoaDon.setPreferredSize(new Dimension(200, 50));
        jmiQLyHoaDon.setFont(jmiFont);
        jmiLuongNhanVien = new JMenuItem("Danh sách phiếu nhập");
        jmiLuongNhanVien.setIcon(imageIconPayroll);
        jmiLuongNhanVien.setPreferredSize(new Dimension(200, 50));
        jmiLuongNhanVien.setFont(jmiFont);
        menuDanhMuc.add(jmiQLyHoaDon);
        menuDanhMuc.add(jmiLuongNhanVien);
        
        menuQuanTri = new JMenu("Quản lý");
        menuQuanTri.setPreferredSize(new Dimension(180, 50));
        menuQuanTri.setIcon(imageIconManager);
        menuQuanTri.setForeground(Color.white);
        menuQuanTri.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jmiQLyNhanVien = new JMenuItem("Quản lý nhân viên");
        jmiQLyNhanVien.setIcon(imageIconManagementEmployee);
        jmiQLyNhanVien.setPreferredSize(new Dimension(200, 50));
        jmiQLyNhanVien.setFont(jmiFont);
        jmiNCC = new JMenuItem("Nhà cung cấp");
        jmiNCC.setIcon(imageIconSupplier);
        jmiNCC.setPreferredSize(new Dimension(200, 50));
        jmiNCC.setFont(jmiFont);
        jmiPhanQuyen = new JMenuItem("Phân quyền");
        jmiPhanQuyen.setIcon(imageIconDecentralization);
        jmiPhanQuyen.setPreferredSize(new Dimension(200, 50));
        jmiPhanQuyen.setFont(jmiFont);
        menuQuanTri.add(jmiQLyNhanVien);
        menuQuanTri.add(jmiNCC);
        menuQuanTri.add(jmiPhanQuyen);
        
        menuBar.add(menuBanHang);
        menuBar.add(menuQuanLyKho);
        menuBar.add(menuDanhMuc);
        menuBar.add(menuQuanTri);
        
        pnmenu.add(menuBar);

        // panel nằm ngay center của main (gồm 2 phầm left và right)
        pncontent = new JPanel();
        pncontent.setPreferredSize(getMaximumSize());
        
        pnStart= new JPanel();
        LayoutManager overlay = new OverlayLayout(pnStart);
        pnStart.setLayout(overlay);

        JLabel label1 = new JLabel("I Mart");
        label1.setFont(new Font("Serif",Font.ITALIC,250));
        label1.setForeground(Color.black);
        label1.setAlignmentX(0.3f);
        label1.setAlignmentY(0.3f);
        pnStart.add(label1);

        JLabel label2 = new JLabel(new ImageIcon("background.png"));
        label2.setPreferredSize(new Dimension(0, 500));
        label2.setAlignmentX(0.3f);
        label2.setAlignmentY(0.3f);
        pnStart.add(label2);
        pncontent.setLayout(new GridLayout());
        pncontent.add(pnStart);

        // gắn vào pnhead 
        pnlogo.add(pnicon, BorderLayout.WEST);
        pnlogo.add(pntool, BorderLayout.EAST);
        close.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                close.setBackground(Color.white);
                close.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                close.setBackground(Color.red);
                close.setForeground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                close.setBackground(Color.white);
                close.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                close.setBackground(Color.red);
                close.setForeground(Color.white);
            }
        });
        
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hide();
                new loginFrame().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                logout.setBackground(Color.white);
                logout.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                logout.setBackground(Color.red);
                logout.setForeground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logout.setBackground(Color.white);
                logout.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logout.setBackground(Color.red);
                logout.setForeground(Color.white);
            }
        });
        
        resume.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame j= new JFrame("Nhập mật khẩu");
                j.setSize(500,200);
                j.setLayout(new BorderLayout(0, 10));
                JPanel pn= new JPanel();
                pn.setLayout(new GridLayout());
                pn.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
                JButton bt= new JButton("Ok");
                bt.setPreferredSize(new Dimension(70, 40));
                JPanel pn2= new JPanel();
                pn2.setLayout(new GridLayout());
                pn2.setBorder(BorderFactory.createEmptyBorder(5, 125, 5, 125));
                pn2.add(bt);
                pn2.setPreferredSize(new Dimension(0, 50));
                JPasswordField pass= new JPasswordField();
                pass.setPreferredSize(new Dimension(150, 50));
                pn.add(pass);
                j.add(pn, BorderLayout.CENTER);
                j.add(pn2,BorderLayout.SOUTH);
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.getRootPane().setDefaultButton(bt);
                String us=username;
                String pw=password;
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pass.getText().equals(password)){
                            profile(us,pw);
                            j.hide();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sai mật khẩu","Thông báo",2);
                        }
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
                resume.setBackground(Color.white);
                resume.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                resume.setBackground(Color.red);
                resume.setForeground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                resume.setBackground(Color.white);
                resume.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resume.setBackground(Color.red);
                resume.setForeground(Color.white);
            }
        });
        
        profile.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(logout.isVisible()==true)
                    logout.setVisible(false);
                else
                    logout.setVisible(true);
                
                if(resume.isVisible()==true)
                    resume.setVisible(false);
                else
                    resume.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                profile.setBackground(Color.white);
                profile.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                profile.setBackground(Color.red);
                profile.setForeground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                profile.setBackground(Color.white);
                profile.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                profile.setBackground(Color.red);
                profile.setForeground(Color.white);
            }
        });
        
        minimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mininize();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                minimize.setBackground(Color.white);
                minimize.setForeground(Color.red);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                minimize.setBackground(Color.red);
                minimize.setForeground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimize.setBackground(Color.white);
                minimize.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimize.setBackground(Color.red);
                minimize.setForeground(Color.white);
            }
        });
        
        pnhead.add(pnlogo);
        pnhead.add(pnmenu);
        
        checkQuyen();
        jmiHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hoaDonPanel hdpn = new hoaDonPanel();
                hdpn.getHoaDonPanel(pncontent, pntitle, lbtitle, username, password);
            }
        });
        
        jmiThongtinKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khachHangPanel khpn = new khachHangPanel();
                khpn.getKhachHangPanel(pncontent, pntitle, lbtitle);
            }
        });
        
        jmiQLyNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j= new JFrame("Nhập mật khẩu");
                j.setSize(500,200);
                j.setLayout(new BorderLayout(0, 10));
                JPanel pn= new JPanel();
                pn.setLayout(new GridLayout());
                pn.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
                JButton bt= new JButton("Ok");
                bt.setPreferredSize(new Dimension(70, 40));
                JPanel pn2= new JPanel();
                pn2.setLayout(new GridLayout());
                pn2.setBorder(BorderFactory.createEmptyBorder(5, 125, 5, 125));
                pn2.add(bt);
                pn2.setPreferredSize(new Dimension(0, 50));
                JPasswordField pass= new JPasswordField();
                pass.setPreferredSize(new Dimension(150, 50));
                pn.add(pass);
                j.add(pn, BorderLayout.CENTER);
                j.add(pn2,BorderLayout.SOUTH);
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.getRootPane().setDefaultButton(bt);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pass.getText().equals(password)){
                            nhanVienPanel nvpn = new nhanVienPanel();
                            nvpn.getNhanVienPanel(pncontent, pntitle, lbtitle);
                            j.hide();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sai mật khẩu","Thông báo",2);
                        }
                    }
                });
            }
        });
        
        jmiNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j= new JFrame("Nhập mật khẩu");
                j.setSize(500,200);
                j.setLayout(new BorderLayout(0, 10));
                JPanel pn= new JPanel();
                pn.setLayout(new GridLayout());
                pn.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
                JButton bt= new JButton("Ok");
                bt.setPreferredSize(new Dimension(70, 40));
                JPanel pn2= new JPanel();
                pn2.setLayout(new GridLayout());
                pn2.setBorder(BorderFactory.createEmptyBorder(5, 125, 5, 125));
                pn2.add(bt);
                pn2.setPreferredSize(new Dimension(0, 50));
                JPasswordField pass= new JPasswordField();
                pass.setPreferredSize(new Dimension(150, 50));
                pn.add(pass);
                j.add(pn, BorderLayout.CENTER);
                j.add(pn2,BorderLayout.SOUTH);
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.getRootPane().setDefaultButton(bt);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pass.getText().equals(password)){
                            nhaCungCapPanel nccpn= new nhaCungCapPanel();
                            nccpn.getNhaCungCapPanel(pncontent, pntitle, lbtitle);
                            j.hide();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sai mật khẩu","Thông báo",2);
                        }
                    }
                });
            }
        });
        
        jmiNhapHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phieuNhapPanel pnpn= new phieuNhapPanel();
                pnpn.getPhieuNhapPanel(pncontent, pntitle, lbtitle, username, password);
            }
        });
        
        jmiThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thongKePanel tkpn= new thongKePanel();
                tkpn.getThongKePanel(pncontent, pntitle, lbtitle);
                tkpn.sp();
                tkpn.nv();
                tkpn.kh();
            }
        });
        
        jmiQuanLyKho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sanPhamPanel sppn= new sanPhamPanel();
                sppn.getSanPhamPanel(pncontent, pntitle, lbtitle);
            }
        });
        
        jmiPhanQuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j= new JFrame("Nhập mật khẩu");
                j.setSize(500,200);
                j.setLayout(new BorderLayout(0, 10));
                JPanel pn= new JPanel();
                pn.setLayout(new GridLayout());
                pn.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
                JButton bt= new JButton("Ok");
                bt.setPreferredSize(new Dimension(70, 40));
                JPanel pn2= new JPanel();
                pn2.setLayout(new GridLayout());
                pn2.setBorder(BorderFactory.createEmptyBorder(5, 125, 5, 125));
                pn2.add(bt);
                pn2.setPreferredSize(new Dimension(0, 50));
                JPasswordField pass= new JPasswordField();
                pass.setPreferredSize(new Dimension(150, 50));
                pn.add(pass);
                j.add(pn, BorderLayout.CENTER);
                j.add(pn2,BorderLayout.SOUTH);
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.getRootPane().setDefaultButton(bt);
                bt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pass.getText().equals(password)){
                            phanQuyenPanel pqpn= new phanQuyenPanel();
                            pqpn.getPhanQuyenPanel(pncontent, pntitle, lbtitle, username, password);
                            j.hide();
                        } else {
                            JOptionPane.showMessageDialog(null, "Sai mật khẩu","Thông báo",2);
                        }
                    }
                });
            }
        });
        
        jmiQLyHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quanLyHoaDonPanel qlhdpn= new quanLyHoaDonPanel();
                qlhdpn.getDSHoaDonPanel(pncontent, pntitle, lbtitle);
            }
        });
        
        jmiLuongNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quanLyPhieuNhapPanel qlpnpn= new quanLyPhieuNhapPanel();
                qlpnpn.getDSHoaDonPanel(pncontent, pntitle, lbtitle);
            }
        });
        
        this.add(pnhead, BorderLayout.NORTH);
        this.add(pncontent, BorderLayout.CENTER);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  // set fullsize cho main  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // dừng chương trình khi exit
        this.setUndecorated(true);                     // ẩn thanh mặc định 
        this.setVisible(true);
    }
    
    
    /*
    *   0:   Mã nhân viên                       1:   Họ                 2:   Tên                3:   Ngày sinh          4:   Địa chỉ
    *   5:   Điện thoại                         6:   Ngày vào làm       7:   Giới tinh          8:   Mã chức vụ         9:   Tên chức vụ
    *   10:  Username                           11:  Password           12:  Quyền bán hàng     13:  Quyền nhập hàng
    *   14:  Quyền quản lý nhân viên            15:  Quyền sửa danh sách nhân viên              16:  Quyền quản lý nhà cung cấp
    *   17:  Quyền sửa thông tin cá nhân        18:  Quyền thống kê                             19:  Quyền tính lương
    *   20:  Quyền phân quyền
    */
    public void profile(String username, String password){
        JFrame jf= new JFrame("Profile");
        jf.setSize(700,600);
        jf.getRootPane().setDefaultButton(null);
        jf.setLayout(new BorderLayout(0, 10));
        nhanVienBLL nvbll= new nhanVienBLL();
        String info[]= nvbll.getAllInfo(username, password);
        String field[]={"Mã nhân viên","Chức vụ","Tên","Ngày sinh","Địa chỉ","Điện thoại","Ngày vào làm","Giới tính","Tài khoản","Mật khẩu"};
        JLabel tt[]= new JLabel[field.length];
        JTextField tx[]= new JTextField[field.length];
        JPanel pn[]= new JPanel[field.length];
        
        JPanel title= new JPanel();
        title.setPreferredSize(new Dimension(0,100));
        title.setLayout(new GridLayout());
        
        JLabel title2 = new JLabel("Xin chào "+info[2]);
        title2.setHorizontalAlignment(JLabel.RIGHT);
        title2.setFont(new Font("Serif",Font.ITALIC,20));
        title2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 50));
        
        JPanel pn1= new JPanel();
        pn1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân",0,0,new Font("Tahoma",Font.BOLD,20)), BorderFactory.createEmptyBorder(60,20,60,20)));
        pn1.setLayout(new GridLayout(5, 2, 10,25));
        
        for(int i=0;i<field.length;i++){
            tt[i]= new JLabel(field[i]);
            tx[i]= new JTextField();
            pn[i]= new JPanel();
            pn[i].setLayout(new GridLayout(1,1,10,0));
            tx[i].setPreferredSize(new Dimension(200, 30));
            tx[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
            pn[i].add(tt[i]);
            pn[i].add(tx[i]);
            pn1.add(pn[i]);
        }
        tx[0].setText(info[0]);
        tx[0].setEditable(false);
        tx[1].setText(info[8]);
        tx[1].setEditable(false);
        tx[2].setText(info[1]+" "+info[2]);
        tx[2].setEditable(false);
        tx[3].setText(info[3]);
        tx[3].setEditable(false);
        tx[4].setText(info[4]);
        tx[5].setText(info[5]);
        tx[6].setText(info[6]);
        tx[6].setEditable(false);
        tx[7].setText(nvbll.changeGenderToText2(info[7]));
        tx[7].setEditable(false);
        tx[8].setText(info[10]);
        tx[9].setText(info[11]);
        
        JButton thongtin= new JButton("Cập nhật");
        thongtin.setPreferredSize(new Dimension(0, 50));
        thongtin.setFont(new Font("Serif",Font.BOLD,20));
        
        thongtin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nhanVienDAO nvdao= new nhanVienDAO();
                taiKhoanDAO tkdao= new taiKhoanDAO();
                nvdao.updateDBNhanVien(tx[0].getText(), info[1], info[2], info[3], tx[4].getText(), tx[5].getText(), info[6], nvbll.changeGenderToNum(tx[7].getText()), info[8]);
                tkdao.updateInDBTaiKhoan(tx[0].getText(), tx[8].getText().trim(), tx[9].getText().trim());
                //JOptionPane.showMessageDialog(null,"Cập nhật thành công","Thông báo",2);
                jf.repaint();
                jf.validate();
            }
        });

        jf.add(title2, BorderLayout.NORTH);
        jf.add(pn1, BorderLayout.CENTER);
        jf.add(thongtin, BorderLayout.SOUTH);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
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
    
    public void mininize(){
        this.setState(1);
//        this.setExtendedState(JFrame.ICONIFIED);
//        this.setExtendedState(JFrame.NORMAL);
    }

    /*
    *   0:   Mã nhân viên                       1:   Họ                 2:   Tên                3:   Ngày sinh          4:   Địa chỉ
    *   5:   Điện thoại                         6:   Ngày vào làm       7:   Giới tinh          8:   Mã chức vụ         9:   Tên chức vụ
    *   10:  Username                           11:  Password           12:  Quyền bán hàng     13:  Quyền nhập hàng
    *   14:  Quyền quản lý nhân viên            15:  Quyền sửa danh sách nhân viên              16:  Quyền quản lý nhà cung cấp
    *   17:  Quyền sửa thông tin cá nhân        18:  Quyền thống kê                             19:  Quyền tính lương
    *   20:  Quyền phân quyền
     */
    public void checkQuyen() {
        nhanVienBLL nvbll = new nhanVienBLL();
        if ("CV01".equals(nvbll.getAllInfo(username, password)[8]) || "CV02".equals(nvbll.getAllInfo(username, password)[8]) || nvbll.getAllInfo(username, password)[8] == null) {
            if ("0".equals(nvbll.getAllInfo(username, password)[12])) {
                jmiHoaDon.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[13])) {
                jmiNhapHang.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[14])) {
                jmiQLyNhanVien.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[15])) {
                jmiNCC.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[16])) {
                jmiQLyHoaDon.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[17])) {
                jmiThongKe.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[18])) {
                jmiLuongNhanVien.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[19])) {
                jmiPhanQuyen.hide();
            }
        } else {
            menuQuanTri.hide();
            if ("0".equals(nvbll.getAllInfo(username, password)[18])) {
                jmiLuongNhanVien.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[12])) {
                jmiHoaDon.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[13])) {
                jmiNhapHang.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[16])) {
                jmiQLyHoaDon.hide();
            }
            if ("0".equals(nvbll.getAllInfo(username, password)[17])) {
                jmiThongKe.hide();
            }
        }
    }
    
    public void hideGUI() {
        this.hide();
        JOptionPane.showMessageDialog(null, "Đăng xuất thành công", "Thông báo", 1);
        new loginFrame().setVisible(true);
    }
    
    public static void main(String[] args) {
//new mainFrame("baoluan","0512").setVisible(true);
        new loginFrame().setVisible(true);
    }
}
