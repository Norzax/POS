/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import com.toedter.calendar.JDateChooser;
import imart.BLL.loaiHangBLL;
import imart.BLL.nhaCCapBLL;
import imart.BLL.nhanVienBLL;
import imart.BLL.phieuNhapBLL;
import imart.BLL.sanPhamBLL;
import imart.BLL.taiKhoanBLL;
import imart.DAO.ctPhieuNhapDAO;
import imart.DAO.phieuNhapDAO;
import imart.DAO.sanPhamDAO;
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
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bao Luan
 */
public class phieuNhapPanel {
    private JPanel pncontent_left, pncontent_right, pncont1, pncont13 , pncont131, pncont132, pncont1321, pncont1322 ,pncont11, pncont12, pncont2, pncont_left1, pncont_left2, 
                   pnTotal, pnKhachTra, pnTienDu, pncont121;
    private JLabel[] lbctsp;
    private JTextField[] txctsp;
    private JLabel lbcreatedate, lbbillid, lbnhanvien, lbsdtnhacungcap, lbtimncc, lbnhacungcap ,lbdiachincc, lblaygia,lbghichu, lbTotal, lbKhachTra, lbTienDu, lbaddkh1, lbaddkh2, lbxoa;
    private JComboBox cbproducts, cbnhanvien, cbnhacungcap, cblaygia;
    private JTextField txFindItem, txcreatedate, txbillid, txtimncc, txdiachincc, txsdtnhacungcap, txghichu, txTotal, txKhachTra, txTienDu, txnhanvien;
    private JButton get, reset, newHoaDon, viewPhieuNhapList, buy;
    private static JTable tablehd = new JTable();
    private static DefaultTableModel modelhd= new DefaultTableModel();
    private static JScrollPane scroll= new JScrollPane();
    JDateChooser dc= new JDateChooser();
    sanPhamBLL spbll= new sanPhamBLL();
    taiKhoanBLL tkbll = new taiKhoanBLL();
    
    public phieuNhapPanel(){
        //this.control = new JLabel("Bán hàng");
        modelhd=new DefaultTableModel();
        initCompornent();
    }
    
    public void initCompornent(){
        LocalDate date= LocalDate.now();
        dc.setDate(Date.valueOf(date));
        
        // con trái của pncontent 
        pncontent_left= new JPanel();
        pncontent_left.setBackground(Color.white);
        pncontent_left.setPreferredSize(new Dimension(380, 890));
        pncontent_left.setLayout(new FlowLayout(1, 10, 30));

        // con phải của pncontent 
        pncontent_right= new JPanel();
        pncontent_right.setPreferredSize(new Dimension(1494, 890));
        pncontent_right.setLayout(new BorderLayout(10,0));
        pncontent_right.setBackground(Color.white);
        
        // panel con của content_right 
        pncont1= new JPanel();
        pncont1.setPreferredSize(new Dimension(1494, 60));
        pncont1.setLayout(new FlowLayout(0, 0, 15));
        
        // panel con của pncont1 
        pncont11= new JPanel();
        pncont11.setPreferredSize(new Dimension(1494, 150));
        pncont11.setBackground(Color.white);
        pncont11.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.darkGray),BorderFactory.createEmptyBorder(10,0,10,100)));
        
        // panel con của pncont1 
        pncont12= new JPanel();
        pncont12.setPreferredSize(new Dimension(1494, 485));
        pncont12.setBackground(Color.white);
        pncont12.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        pncont12.setLayout(new BorderLayout());
        
        pncont121= new JPanel();
        pncont121.setBackground(Color.white);
        pncont121.setPreferredSize(new Dimension(0, 50));
        pncont121.setLayout(new BorderLayout());
        pncont121.setBorder(BorderFactory. createEmptyBorder(5,0,5,10));
        
        lbxoa= new JLabel("Xóa");
        lbxoa.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbxoa.setPreferredSize(new Dimension(70,0));
        lbxoa.setHorizontalAlignment(0);
        lbxoa.setBackground(new Color(240,0,0));
        lbxoa.setForeground(new Color(254, 246, 255));
        lbxoa.setOpaque(true);
        
        pncont121.add(lbxoa, BorderLayout.EAST);
        pncont12.add(pncont121, BorderLayout.NORTH);
        
        // panel con của pncont1 
        pncont13= new JPanel();
        pncont13.setPreferredSize(new Dimension(1494, 150));
        pncont13.setBackground(Color.white);
        pncont13.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        pncont13.setLayout(new GridLayout(2,1,0,20));
        
        
        tablehd= new JTable(modelhd){
            @Override
            public boolean isCellEditable(int row, int column) {                
                switch (column) {
                    case 6:
                        return true;
                    default:
                        return false;
                 }              
            };
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                case 6:
                    return Boolean.class;
                default:
                    return String.class;
                }
            }
        };
        
        pncont131= new JPanel();
        pncont131.setLayout(new GridLayout(1, 3, 20, 0));
        pncont131.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        pncont131.setBackground(Color.white);
        
        pncont132= new JPanel();
        pncont132.setLayout(new GridLayout(1, 2, 20, 0));
        pncont132.setBackground(Color.white);
        
        pncont1321= new JPanel();
        pncont1321.setLayout(new GridLayout(1, 1));
        pncont1321.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 450));
        pncont1321.setBackground(Color.white);
        
        pncont1322= new JPanel();
        pncont1322.setLayout(new GridLayout(1, 2, 20, 0));
        pncont1322.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        pncont1322.setBackground(Color.white);
        
        //add vào pncon1 
        pncont1.add(pncont11);
        pncont1.add(pncont12);
        pncont1.add(pncont13);
        
        pncont2= new JPanel();
        pncont2.setLayout(new BorderLayout());
        pncont2.setPreferredSize(new Dimension(350,200));
        
        loaiHangBLL lhbll= new loaiHangBLL();
        cbproducts= new JComboBox(lhbll.getTenLoai());
        cbproducts.setPreferredSize(new Dimension(160, 30));
        cbproducts.setBackground(Color.white);
        
        //phần trên
        pncont_left1= new JPanel();
        pncont_left1.setPreferredSize(new Dimension(380, 300));
        pncont_left1.setBackground(Color.white);
        
        //phần dưới
        pncont_left2= new JPanel();
        pncont_left2.setPreferredSize(new Dimension(380, 440));
        pncont_left2.setBackground(Color.white);
        
        pnTotal= new JPanel();
        pnTotal.setLayout(new FlowLayout(0, 20, 0));
        pnTotal.setBackground(Color.white);
        lbTotal= new JLabel("Tổng cộng");
        txTotal= new JTextField();
        txTotal.setEditable(false);
        txTotal.setPreferredSize(new Dimension(160, 30));
        pnTotal.add(lbTotal);
        pnTotal.add(txTotal);
                    
        pnKhachTra= new JPanel();
        pnKhachTra.setLayout(new FlowLayout(0, 20, 0));
        pnKhachTra.setBackground(Color.white);
        lbKhachTra= new JLabel("Khách trả");
        txKhachTra= new JTextField();
        txKhachTra.setPreferredSize(new Dimension(160, 30));
//        pnKhachTra.add(lbKhachTra);
//        pnKhachTra.add(txKhachTra);
        
        pnTienDu= new JPanel();
        pnTienDu.setLayout(new FlowLayout(0, 20, 0));
        pnTienDu.setBackground(Color.white);
        lbTienDu= new JLabel("Tiền dư");
        txTienDu= new JTextField();
        txTienDu.setPreferredSize(new Dimension(160, 30));
//        pnTienDu.add(lbTienDu);
//        pnTienDu.add(txTienDu);
       
        newHoaDon= new JButton("Tạo phiếu nhập mới");
        viewPhieuNhapList= new JButton("Xem danh sách phiếu nhập");
        buy= new JButton("Nhập hàng");
        
        get= new JButton("Chọn");
        get.setPreferredSize(new Dimension(160, 40));
        reset= new JButton("Làm mới");
        reset.setPreferredSize(new Dimension(160, 40));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
        
    public void getPhieuNhapPanel(JPanel panel, JPanel pntitle, JLabel lbtitle, String us, String pw){
        panel.removeAll();
        panel.setLayout(new BorderLayout(15, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        
        pncont_left1.removeAll();
        pncont_left2.removeAll();
        
        pncont_left1.setBorder(BorderFactory.createTitledBorder(null,"Sản phẩm",1,0, new Font("Tahoma",Font.BOLD,20)));
        pncont_left1.setLayout(new FlowLayout(0, 10, 15));
        
        pncont_left2.setBorder(BorderFactory.createTitledBorder(null,"Chi Tiết Sản phẩm",1,0, new Font("Tahoma",Font.BOLD,20)));
        pncont_left2.setLayout(new FlowLayout(0, 10, 25));
        
        txFindItem= new JTextField();
        txFindItem.setPreferredSize(new Dimension(180,30));
        
        txFindItem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String find = txFindItem.getText().trim();
                cbproducts.setSelectedIndex(0);
                txFindItem.removeAll();
                pncont2.removeAll();
                JTable table= new JTable();
                JScrollPane scroll= new JScrollPane();
                table= spbll.showData(find);
                table.getColumnModel().getColumn(0).setMinWidth(0); 
                table.getColumnModel().getColumn(0).setMaxWidth(0); 
                table.getColumnModel().getColumn(2).setMinWidth(0); 
                table.getColumnModel().getColumn(2).setMaxWidth(0); 
                table.getColumnModel().getColumn(3).setMinWidth(0); 
                table.getColumnModel().getColumn(3).setMaxWidth(0); 
                scroll.setViewportView(table);
                pncont2.add(scroll,BorderLayout.CENTER);
                setText(table);
                txFindItem.validate();
                pncontent_left.repaint();
                pncontent_left.validate();
            }
        });
        
        addFullTable();
        
        cbproducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaiHangBLL lhbll = new loaiHangBLL();
                if(cbproducts.getSelectedIndex()==0){
                    pncont2.removeAll();
                    addFullTable();
                } else if (cbproducts.getSelectedIndex() > 0 && cbproducts.getSelectedIndex() < lhbll.slLoaiHang()) {
                    pncont2.removeAll();
                    txFindItem.setText("");
                    JTable table= new JTable();
                    JScrollPane scroll= new JScrollPane();
                    table= spbll.showDataByMaLoai(String.valueOf(cbproducts.getSelectedIndex()));
                    table.getColumnModel().getColumn(0).setMinWidth(0); 
                    table.getColumnModel().getColumn(0).setMaxWidth(0); 
                    table.getColumnModel().getColumn(2).setMinWidth(0); 
                    table.getColumnModel().getColumn(2).setMaxWidth(0); 
                    table.getColumnModel().getColumn(3).setMinWidth(0); 
                    table.getColumnModel().getColumn(3).setMaxWidth(0); 
                    scroll.setViewportView(table);
                    pncont2.add(scroll,BorderLayout.CENTER);
                    setText(table);
                    pncontent_left.repaint();
                    pncontent_left.validate();
                }
            }
        });
        
        String header[]={"STT","Mã sản phẩm","Tên sản phẩm","Số lượng","Đơn giá ","Thành tiền (giá nhập)", "Chọn xóa"};
        this.modelhd.setColumnIdentifiers(header);
        tablehd.setModel(modelhd);
        tablehd.getColumnModel().getColumn(6).setMinWidth(0);
        tablehd.getColumnModel().getColumn(6).setMaxWidth(0);
        scroll.setViewportView(tablehd);
        pncont12.add(scroll,BorderLayout.CENTER);
        
        get.addActionListener((ActionEvent e) -> {
            try {
                tablehd.getColumnModel().getColumn(6).setMinWidth(100);
                tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
                tablehd.validate();
                newHoaDonNhap(txctsp[0].getText(), txctsp[1].getText(), Integer.parseInt(txctsp[5].getText()), Double.parseDouble(txctsp[4].getText()), 
                        (Integer.parseInt(txctsp[5].getText()) * Double.parseDouble(txctsp[4].getText()))- 
                        ((Integer.parseInt(txctsp[5].getText()) * Double.parseDouble(txctsp[4].getText())) * 20)/100);
                double Tong=0;
                for(int i=0;i<modelhd.getRowCount();i++){
                    Tong+= Double.parseDouble(String.valueOf(modelhd.getValueAt(i, 5)));
                    txTotal.setText(String.valueOf(Tong));
                }
                txFindItem.setText("");
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null,"Hãy nhập số lượng sản phẩm","Thông báo",2);
                txctsp[5].requestFocus();
            }
        });
        
        deleteFromBill(tablehd);
        
        txKhachTra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    if (Double.parseDouble(txKhachTra.getText()) <= Double.parseDouble(txTotal.getText())) {
                        txTienDu.setText("0.0 VND");
                    } else {
                        txTienDu.setText(String.valueOf(Double.parseDouble(txKhachTra.getText()) - Double.parseDouble(txTotal.getText())));
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Error at line298 HoaDonPanel");
                }
            }
        });
        
        billInfo(us,pw);
        
        lbctsp= new JLabel[spbll.getHeader().length];
        txctsp= new JTextField[spbll.getHeader().length];
        for(int i=0;i<spbll.getHeader().length;i++){
            lbctsp[i]= new JLabel(spbll.getHeader()[i]);
            txctsp[i]= new JTextField();
            lbctsp[i].setPreferredSize(new Dimension(160,30));
            txctsp[i].setPreferredSize(new Dimension(180,30));
            txctsp[i].setEditable(false);
            pncont_left2.add(lbctsp[i]);
            pncont_left2.add(txctsp[i]);
        }
        txctsp[5].setEditable(true);
        
        viewPhieuNhapList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phieuNhapBLL pnbll= new phieuNhapBLL();
                JFrame jf= new JFrame("Danh sách hóa đơn nhập");
                jf.setSize(700,300);
                jf.setLayout(new GridLayout());
                jf.add(pnbll.showData());
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
        
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phieuNhapDAO pndao= new phieuNhapDAO();
                ctPhieuNhapDAO ctpndao= new ctPhieuNhapDAO();
                nhaCCapBLL nccbll= new nhaCCapBLL();
                sanPhamDAO spdao= new sanPhamDAO();
                sanPhamBLL spbll= new sanPhamBLL();
                nhanVienBLL nvbll = new nhanVienBLL();
                
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd"); 
                String ghichu=null;
                
                if(txghichu.getText().equals("")){
                    ghichu= "Không";
                } else{
                    ghichu=txghichu.getText();
                }
                
                pndao.insertToDBPhieuNhap(txbillid.getText(), nvbll.getMaFromName(txnhanvien.getText()), 
                                        nccbll.getMaFromName(cbnhacungcap.getSelectedItem().toString()), Date_Format.format(dc.getDate()) , Double.parseDouble(txTotal.getText()) , ghichu);
                
                // đưa sản phẩm vào chi tiết phiếu nhập và update lại số lượng sản phẩm 
                if(modelhd.getRowCount()>0){
                    for(int i=0;i<modelhd.getRowCount();i++){
                        // đưa sản phẩm vào hóa đơn
                        ctpndao.insertToDBctPhieuNhap(txbillid.getText(), modelhd.getValueAt(i, 1).toString(), Integer.parseInt(String.valueOf(modelhd.getValueAt(i, 3))),
                                                   Double.parseDouble(modelhd.getValueAt(i, 4).toString()), Double.parseDouble(modelhd.getValueAt(i, 5).toString()));
                        // update lại số lượng sản phẩm
                        for(int a=0;a<spbll.getList().getSanpham().size();a++){
                            // nếu sản phẩm trong list có mã bằng mã sản phẩm trong hóa đơn thì cập nhật lại số lượng mới 
                            if(spbll.getList().getSanpham().get(a).getId().equals(modelhd.getValueAt(i, 1).toString())){
                                // số lượng mới bằng tổng cộng số lượng sản phẩm trong phiếu nhâp
                                spdao.updateDBSanPham(modelhd.getValueAt(i, 1).toString(), 
                                                      spbll.getList().getSanpham().get(a).getSoluong()+Integer.parseInt(String.valueOf(modelhd.getValueAt(i, 3))));
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,"Thành công");
                panel.removeAll();
                phieuNhapPanel pnpn= new phieuNhapPanel();
                pnpn.getPhieuNhapPanel(panel, pntitle, lbtitle, us, pw);
                panel.validate();
            }
        });
        
        pncont131.add(pnTotal);
        pncont131.add(pnKhachTra);
        pncont131.add(pnTienDu);
        
        pncont1321.add(newHoaDon);
        pncont1322.add(viewPhieuNhapList);
        pncont1322.add(buy);
        pncont132.add(pncont1321);
        pncont132.add(pncont1322);
        
        pncont13.add(pncont131);
        pncont13.add(pncont132);
        
        pncontent_left.add(pncont_left1);
        pncontent_left.add(pncont_left2);
        pncontent_left.add(get);
        pncontent_left.add(reset);
        pncont_left1.add(cbproducts);
        pncont_left1.add(txFindItem);
        pncont_left1.add(pncont2);
        
        //pncontent_right.add(spbll.showData(),BorderLayout.CENTER);

        //changeTabMenu(0);
        pncontent_right.removeAll();
        lbtitle.removeAll();
        lbtitle.setText("Nhập hàng");
        lbtitle.repaint();
        lbtitle.validate();

        pncontent_right.add(pncont1,BorderLayout.CENTER);
        pncontent_right.add(pntitle,BorderLayout.NORTH);
        pncont_left1.repaint();
        pncont_left1.validate();
        pncont_left2.repaint();
        pncont_left2.validate();
        pncontent_left.repaint();
        pncontent_left.validate();
        pncontent_right.repaint();
        pncontent_right.validate();
        
        panel.add(pncontent_left, BorderLayout.WEST);
        panel.add(pncontent_right, BorderLayout.CENTER);
        panel.repaint();
        panel.validate();
        panel.getRootPane().setDefaultButton(get);
    }
    
    public void setText(JTable tb){
        tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i=tb.getSelectedRow();
                for(int a=0;a<spbll.getHeader().length;a++){
                    if(a == 5){
                        txctsp[a].setText("");
                        txctsp[a].requestFocus();
                    } else {
                        txctsp[a].setText(tb.getModel().getValueAt(i,a).toString());
                    }
                }
            }
        });
    }
    
    
    // table tìm kiếm 
    public void addFullTable(){
        JTable table= new JTable();
        JScrollPane scroll= new JScrollPane();
        table= spbll.showDataByMaLoai0();
        table.getColumnModel().getColumn(0).setMinWidth(0); 
        table.getColumnModel().getColumn(0).setMaxWidth(0); 
        table.getColumnModel().getColumn(2).setMinWidth(0); 
        table.getColumnModel().getColumn(2).setMaxWidth(0); 
        table.getColumnModel().getColumn(3).setMinWidth(0); 
        table.getColumnModel().getColumn(3).setMaxWidth(0); 
        scroll.setViewportView(table);
        pncont2.add(scroll,BorderLayout.CENTER);
        setText(table);
        pncontent_left.repaint();
        pncontent_left.validate();
    }
    
    public void billInfo(String us, String pw){
        pncont11.removeAll();
        pncont11.repaint();
        pncont11.validate();
        phieuNhapBLL pnbll= new phieuNhapBLL();
        nhaCCapBLL nccbll= new nhaCCapBLL();
        nhanVienBLL nvbll= new nhanVienBLL();
        Font font = new Font("Tahoma",Font.PLAIN,20);
             
        lbcreatedate= new JLabel();
        lbcreatedate.setText("Ngày lập");
        lbcreatedate.setPreferredSize(new Dimension(50, 150));
        lbcreatedate.setFont(font);
        lbcreatedate.setHorizontalAlignment(JLabel.RIGHT);
        
        lbbillid= new JLabel();
        lbbillid.setText("Số hóa đơn");
        lbbillid.setPreferredSize(new Dimension(50, 150));
        lbbillid.setFont(font);
        lbbillid.setHorizontalAlignment(JLabel.RIGHT);
        
        lbnhanvien= new JLabel();
        lbnhanvien.setText("Thu ngân");
        lbnhanvien.setPreferredSize(new Dimension(50, 150));
        lbnhanvien.setFont(font);
        lbnhanvien.setHorizontalAlignment(JLabel.RIGHT);
        
        lbtimncc= new JLabel();
        lbtimncc.setText("Tìm nhà cung cấp");
        lbtimncc.setPreferredSize(new Dimension(50, 30));
        lbtimncc.setFont(font);
        lbtimncc.setHorizontalAlignment(JLabel.RIGHT);
        
        lbnhacungcap= new JLabel();
        lbnhacungcap.setText("Nhà cung cấp");
        lbnhacungcap.setPreferredSize(new Dimension(50, 30));
        lbnhacungcap.setFont(font);
        lbnhacungcap.setHorizontalAlignment(JLabel.RIGHT);
        
        lbdiachincc= new JLabel();
        lbdiachincc.setText("Địa chỉ");
        lbdiachincc.setPreferredSize(new Dimension(50, 30));
        lbdiachincc.setFont(font);
        lbdiachincc.setHorizontalAlignment(JLabel.RIGHT);
        
        lbsdtnhacungcap= new JLabel();
        lbsdtnhacungcap.setText("Số điện thoại");
        lbsdtnhacungcap.setPreferredSize(new Dimension(50, 30));
        lbsdtnhacungcap.setFont(font);
        lbsdtnhacungcap.setHorizontalAlignment(JLabel.RIGHT);
        
        lbghichu= new JLabel();
        lbghichu.setText("Ghi chú");
        lbghichu.setPreferredSize(new Dimension(50, 30));
        lbghichu.setFont(font);
        lbghichu.setHorizontalAlignment(JLabel.RIGHT);
        
        txnhanvien= new JTextField();
        String info[]= nvbll.getAllInfo(us, pw);
        txnhanvien.setText(info[1]+" "+info[2]);
        txnhanvien.setPreferredSize(new Dimension(10, 30));
        txnhanvien.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        txnhanvien.setEditable(false);
        txnhanvien.setBackground(Color.white);
//        
//        cbnhanvien= new JComboBox(nvbll.getTenNhanVien());
//        cbnhanvien.setBackground(Color.white);
//        cbnhanvien.setPreferredSize(new Dimension(100, 30));
//        
//        for(int a=0;a < cbnhanvien.getItemCount();a++){
//            if(cbnhanvien.getItemAt(a).toString().equals(nvbll.getAllInfo(us, pw)[1]+" "+nvbll.getAllInfo(us, pw)[2])){
//                cbnhanvien.setSelectedIndex(a);
//            }
//        }
        
        cbnhacungcap= new JComboBox(nccbll.getTenNhaCungCap());
        cbnhacungcap.setBackground(Color.white);
        cbnhacungcap.setPreferredSize(new Dimension(100, 30));
        cbnhacungcap.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        cblaygia= new JComboBox();
        cblaygia.setPreferredSize(new Dimension(100, 30));
        
        txcreatedate= new JTextField();
        txcreatedate.setText(String.valueOf(java.time.LocalDate.now()));
        txcreatedate.setPreferredSize(new Dimension(100, 30));
        
        txbillid= new JTextField();
        txbillid.setText(pnbll.getNewPhieuNhap());
        txbillid.setPreferredSize(new Dimension(100, 30));
        txbillid.setEditable(false);
        txbillid.setBackground(Color.white);
        txbillid.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txtimncc= new JTextField();
        txtimncc.setPreferredSize(new Dimension(100, 30));
        txtimncc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txdiachincc= new JTextField();
        txdiachincc.setPreferredSize(new Dimension(10, 30));
        txdiachincc.setEditable(false);
        txdiachincc.setBackground(Color.white);
        txdiachincc.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
        txsdtnhacungcap= new JTextField();
        txsdtnhacungcap.setPreferredSize(new Dimension(10, 30));
        txsdtnhacungcap.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        txsdtnhacungcap.setEditable(false);
        txsdtnhacungcap.setBackground(Color.white);
        
        txghichu= new JTextField();
        txghichu.setPreferredSize(new Dimension(10, 30));
        txghichu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        
//        java.time.LocalDateTime now=  java.time.LocalDateTime.now();
//        datemodel.setDate(now.getYear(), now.getMonthValue()+1, now.getDayOfMonth());
        txsdtnhacungcap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String phone= txsdtnhacungcap.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    txdiachincc.setText("");
                    txtimncc.setText("");
                    setKhachHangComboBox("Nha cung cap so 1");
                } else {
                    txdiachincc.setText(nccbll.getDiaChiByPhone(phone));
                    txtimncc.setText(nccbll.getNameByPhone(phone));
                    setKhachHangComboBox(nccbll.getNameByPhone(phone));
                }
            }
        });
        
        txtimncc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String name= txtimncc.getText().trim();
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    txdiachincc.setText(" ");
                    txsdtnhacungcap.setText(" ");
                    setKhachHangComboBox("Nha cung cap so 1");
                } else {
                    txsdtnhacungcap.setText(nccbll.getPhoneByPhone(name));
                    txdiachincc.setText(nccbll.getDiaChiByPhone(name));
                    setKhachHangComboBox(name);
                }
            }
        });
        
        pncont11.setLayout(new GridLayout(3, 3,50,15));
        pncont11.add(lbcreatedate);
        pncont11.add(dc);
        pncont11.add(lbbillid);
        pncont11.add(txbillid);
        pncont11.add(lbtimncc);
        pncont11.add(txtimncc);
        pncont11.add(lbnhacungcap);
        pncont11.add(cbnhacungcap);
        pncont11.add(lbsdtnhacungcap);
        pncont11.add(txsdtnhacungcap);
        //pncont11.add(lblaygia);
        //pncont11.add(cblaygia);
        pncont11.add(lbdiachincc);
        pncont11.add(txdiachincc);
        pncont11.add(lbnhanvien);
        pncont11.add(txnhanvien);
        pncont11.add(lbghichu);
        pncont11.add(txghichu);
    }
    
    public void setKhachHangComboBox(String name){
        for(int i=0;i<cbnhacungcap.getItemCount()-1;i++){
            if(cbnhacungcap.getItemAt(i).toString().trim().equalsIgnoreCase(name)){
                cbnhacungcap.setSelectedIndex(i);
            }
        }
    }
    
    // kiểm tra sản phẩm đã tồn tại trong hóa đơn tạm tính hay chưa
    public void newHoaDonNhap(String id, String tensp, int soluong, double dongia, double thanhtien){
        // nếu hóa đơn chưa có sản phẩm nào thì tạo mới
        if(tablehd.getModel().getRowCount()==0){
            pncont12.removeAll();
            pncont12.add(pncont121,BorderLayout.NORTH);
            pncont2.removeAll();
            spbll.importGoods(id, soluong);
            tablehd.getColumnModel().getColumn(6).setMinWidth(100);
            tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
            addFullTable();
            tablehd.setRowHeight(30);
            Object[]obj ={this.tablehd.getRowCount()+1,id,tensp,soluong,dongia,thanhtien, false};
            this.modelhd.addRow(obj);
            this.tablehd.setModel(this.modelhd);
            scroll.setViewportView(this.tablehd);
            pncont12.add(scroll,BorderLayout.CENTER);
            pncont2.repaint();
            pncont2.validate();
            pncont12.repaint();
            pncont12.validate();
        } else { // sản phẩm vừa chọn có trong hóa đơn tạm
            if(kTTonTaiTrongHD(id, soluong)==true){
                for(int i=0;i<tablehd.getRowCount();i++){
                    if(modelhd.getValueAt(i, 1).equals(id)) {
                        pncont12.removeAll();
                        pncont12.add(pncont121,BorderLayout.NORTH);
                        pncont2.removeAll();
                        spbll.importGoods(id, soluong);
                        modelhd.setValueAt(Integer.parseInt(modelhd.getValueAt(i,3).toString()) + soluong ,i, 3);
                        modelhd.setValueAt(Integer.parseInt(modelhd.getValueAt(i,3).toString()) * Double.parseDouble(modelhd.getValueAt(i,4).toString()) ,i, 5);
                        addFullTable();
                        tablehd.setModel(modelhd);
                        scroll.setViewportView(this.tablehd);
                        pncont12.add(scroll,BorderLayout.CENTER);
                        pncont2.repaint();
                        pncont2.validate();
                        pncont12.repaint();
                        pncont12.validate();
                    }
                }
            } else { // sản phẩm vừa chọn không có trong hóa đơn tạm 
                pncont12.removeAll();
                pncont12.add(pncont121,BorderLayout.NORTH);
                pncont2.removeAll();
                spbll.importGoods(id, soluong);
                addFullTable();
                tablehd.setRowHeight(30);
                tablehd.getColumnModel().getColumn(6).setMinWidth(100);
                tablehd.getColumnModel().getColumn(6).setMaxWidth(120);
                Object[]obj ={this.tablehd.getRowCount()+1,id,tensp,soluong,dongia,thanhtien, false};
                this.modelhd.addRow(obj);
                this.tablehd.setModel(this.modelhd);
                scroll.setViewportView(this.tablehd);
                pncont12.add(scroll,BorderLayout.CENTER);
                pncont2.repaint();
                pncont2.validate();
                pncont12.repaint();
                pncont12.validate();
            }
        }
    }
    
    
    public boolean kTTonTaiTrongHD(String id, int soluong){
        for(int i=0;i<tablehd.getRowCount();i++){
            if(tablehd.getValueAt(i, 1).toString().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public void deleteFromBill(JTable tb){
        lbxoa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for(int a=0;a<spbll.getHeader().length;a++){
                        txctsp[a].setText("");
                }
                int dem=0;
                for(int i=0;i<tb.getRowCount();i++){
                    if(tb.getValueAt(i, 6).equals(true)){
                        dem++;
                    }
                }
                if(dem!=0) {
                    for(int i=0;i<tb.getRowCount();){
                        if(tb.getValueAt(i, 6).equals(true)){
                            pncont12.removeAll();
                            pncont12.add(pncont121,BorderLayout.NORTH);
                            //tb.setValueAt(Integer.parseInt(tb.getValueAt(i, 1).toString())-1,i+1, 0);
                            pncont2.removeAll();
                            tb.setRowHeight(30);
                            spbll.removeGoods(tb.getValueAt(i, 1).toString(), Integer.parseInt(tb.getValueAt(i, 3).toString()));
                            addFullTable();
                            ((DefaultTableModel)tb.getModel()).removeRow(i);
                            double Tong=0;
                            txTotal.setText(String.valueOf(Tong));
                            for(int a=0;a<tb.getRowCount();a++){
                                Tong+= Double.parseDouble(String.valueOf(modelhd.getValueAt(a, 5)));
                                txTotal.setText(String.valueOf(Tong));
                                tb.setValueAt(a+1,a, 0);
                                tb.validate();
                            }
                            pncont12.add(scroll,BorderLayout.CENTER);
                            pncont2.repaint();
                            pncont2.validate();
                            tb.repaint();
                            tb.validate();
                            pncont12.repaint();
                            pncont12.validate();
                        } else {
                            i++;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn ít nhất 1 sản phẩm để xóa", "Thông báo", 2);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbxoa.setBackground(Color.red);
                lbxoa.setForeground(Color.white);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbxoa.setBackground(new Color(240,0,0));
                lbxoa.setForeground(new Color(254, 246, 255));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbxoa.setBackground(Color.red);
                lbxoa.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbxoa.setBackground(new Color(240,0,0));
                lbxoa.setForeground(new Color(254, 246, 255));
            }
        });
    }
    
    public static void main(String[] args) {
        
    }
}
