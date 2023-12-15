/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import imart.BLL.taiKhoanBLL;
import imart.DAO.connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Bao Luan
 */
public class loginFrame extends JFrame{
    private JPanel pn1,pn2,pn21,pn22,pn23;
    private JLabel lb11, lb21, lb232;
    private JTextField tx221;
    private JPasswordField tx222;
    private JButton btn231;
    private ImageIcon icon111;
    private JProgressBar pb;
    private String username;
    private String password;
    
    public loginFrame(){
        initComponents();
    }
    
    public void initComponents(){
        this.setSize(1000,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        pb= new JProgressBar(0,100);
        this.pb.setStringPainted(true);
        //progress();
        
        pn1= new JPanel();
        pn1.setBackground(Color.white);
        pn1.setPreferredSize(new Dimension(600, 0));
        pn1.setLayout(null);
        
        lb11= new JLabel();
        icon111= new ImageIcon("user.png");
        lb11.setIcon(icon111);
        lb11.setBounds(80,25,400,450);
        
        pn1.add(lb11);
        
        pn2= new JPanel();
        pn2.setPreferredSize(new Dimension(400, 0));
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.Y_AXIS));
        
        pn21= new JPanel();
        pn21.setBackground(Color.white);
        pn21.setPreferredSize(new Dimension(0,100));
        pn21.setLayout(null);
        
        pn22= new JPanel();   
        pn22.setBackground(Color.white);
        pn22.setPreferredSize(new Dimension(0,250));
        pn22.setLayout(null);
       
        pn23= new JPanel();
        pn23.setBackground(Color.white);
        pn23.setPreferredSize(new Dimension(0,150));
        pn23.setLayout(null);
        
        lb21= new JLabel("User Login");
        lb21.setFont(new Font("Arial", Font.PLAIN, 30));
        lb21.setBounds(130, 50, 200, 40);
        pn21.add(lb21);
        
        pn2.add(pn21);
        pn2.add(pn22);
        pn2.add(pn23);
        
        tx221= new JTextField("Username");
        tx221.setBorder(BorderFactory.createCompoundBorder(tx221.getBorder(), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        tx221.setBounds(50, 40, 300, 60);
        tx221.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx221FocusGained(evt);
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                tx221FocusLost(evt);
            }
        });
        
        tx222= new JPasswordField("Password");
        tx222.setBorder(BorderFactory.createCompoundBorder(tx222.getBorder(), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        tx222.setBounds(50, 120, 300, 60);
        tx222.addFocusListener(new java.awt.event.FocusAdapter () {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx222FocusGained(evt);
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                tx222FocusLost(evt);
            }
        });
        
        pn22.add(tx221);
        pn22.add(tx222);
        pn22.setFocusable(true);
        
        btn231= new JButton("Login");
        btn231.setBounds(50, 0, 300, 60);
        btn231.setBackground(Color.cyan);
        btn231.setFont(new Font("Arial", Font.PLAIN,25));
        btn231.setBorder(null);
        btn231.setCursor(new Cursor(HAND_CURSOR));
        
        tx221.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String username = tx221.getText();
                setUsername(username);
            }
        });
        
        tx222.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String password = tx222.getText();
                setPassword(password);
            }
        });
        
        btn231.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tx222.getText().equals("Password") && tx221.getText().equals("Username") || tx222.getText().equals("") && tx221.getText().equals("") ||
                   tx222.getText().equals("Password") && tx221.getText().equals("") || tx221.getText().equals("Username") && tx222.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Username và Password Trống", "Thông báo",2);
                } else if(tx222.getText().equals("Password") || tx222.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Hãy nhập Password", "Thông báo",2);
                } else if(tx221.getText().equals("Username") || tx221.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Hãy nhập Username", "Thông báo",2);
                } else {
                    taiKhoanBLL tkbll= new taiKhoanBLL();
                    int dem=0;
                    for(int i=0;i<tkbll.getList().getTaikhoan().size();i++){
                        if(tkbll.getList().getTaikhoan().get(i).getUsername().equals(tx221.getText()) && tkbll.getList().getTaikhoan().get(i).getPassword().equals(tx222.getText())
                                && tkbll.getList().getTaikhoan().get(i).getStatus().equals("on")){
                            JOptionPane.showMessageDialog(null,"Đăng nhập thành công!","Thông báo",2);
                            new mainFrame(tx221.getText(),tx222.getText()).setVisible(true);
                            hideLog();
                            dem++;
                        }
                    }
                    if(dem==0){
                        JOptionPane.showMessageDialog(null,"Đăng nhập thất bại\nTài khoản không tồn tại hoặc đã bị khóa!!","Thông báo",2);
                    }
                }
            }
        });
        
        lb232= new JLabel("Forgot Username / Password?");
        lb232.setBounds(50, 65, 300, 20);
        lb232.setHorizontalAlignment(0);
        
        pn23.add(btn231);
        pn23.add(lb232);
       
        this.add(pn1,BorderLayout.WEST);
        this.add(pn2,BorderLayout.CENTER);
        this.getRootPane().setDefaultButton(btn231);
        this.setVisible(true);
        //this.setUndecorated(true);
        //this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void tx221FocusGained(java.awt.event.FocusEvent evt) {
        if(tx221.getText().equals("Username")){
            tx221.setText("");
        }
    }
    
    private void tx221FocusLost(java.awt.event.FocusEvent evt) {
        if(tx221.getText().equals("")){
            tx221.setText("Username");
        }
    }
    
    private void tx222FocusGained(java.awt.event.FocusEvent evt) {
        if(tx222.getText().equals("Password")){
            tx222.setText("");
        }
    }
    
    private void tx222FocusLost(java.awt.event.FocusEvent evt) {
        if(tx222.getText().equals("")){
            tx222.setText("Password");
        }
    }
    
    public void hideLog(){
        this.hide();
    }

    public void getLog(String username, String password){
        setUsername(username);
        setPassword(password);
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

    public JTextField getTx221() {
        return tx221;
    }

    public void setTx221(JTextField tx221) {
        this.tx221 = tx221;
    }

    public JPasswordField getTx222() {
        return tx222;
    }

    public void setTx222(JPasswordField tx222) {
        this.tx222 = tx222;
    }
    
    public void progress(){
//        pn2.add(this.pb);
//        int i=0;
//        try {
//            while(i<=100){
//                this.pb.setValue(i);
//                Thread.sleep(10);
//                i++;
//            }
//        } catch (InterruptedException ex) {
//            System.out.println("Error at line 218");
//        }
    }
    
    public static void main(String[] args) {
       new loginFrame().setVisible(true);
    }
}
