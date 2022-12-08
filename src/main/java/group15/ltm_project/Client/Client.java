package group15.ltm_project.Client;

import group15.ltm_project.DTO.MovieDetail;
import group15.ltm_project.DTO.MovieResponse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author baoluan
 */
public class Client extends JFrame{
    public static int destPort = 1312;
    public static String hostname = "localhost";
    private static JPanel leftPanel = null;
    private static JPanel rightPanel = null;
    private static Socket socket;
    private static ObjectOutputStream sendToServer;
    private static ObjectInputStream sentFromServer;
    
    public Client() throws IOException{
        InetAddress ip = InetAddress.getByName(hostname);
        System.out.println(ip);
        socket = new Socket(ip, destPort);
        initComponents();
    }
    
    private void initComponents(){
        this.setTitle("Tra cứu lịch chiếu phim");
        ImageIcon image = new ImageIcon(".../LTM_Project/src/main/java/icon/sgu.png");
        this.setIconImage(image.getImage());
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(266,768));
        leftPanel.setBackground(Color.cyan);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0,4,0,10));
        
        this.add(leftPanel,BorderLayout.WEST);
        this.add(BorderLayout.CENTER, new JScrollPane(rightPanel));
        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    
    public static void startClient(){
        try{
            System.out.println("Client connected");
            while(true){
                sentFromServer = new ObjectInputStream(socket.getInputStream());
                try {
                    Object object = sentFromServer.readObject();
                    ArrayList<MovieResponse> list = (ArrayList<MovieResponse>) object;
                    JPanel[] panel = new JPanel[list.size()];
                    JLabel[] lbimg = new JLabel[list.size()];
                    JLabel[] lbname = new JLabel[list.size()];
                    JLabel[] lbdate = new JLabel[list.size()];
                    for(int i = 0;i<list.size();i++){
                        panel[i] = new JPanel();
                        panel[i].setLayout(new BorderLayout());
                        URL url = new URL(list.get(i).getImgUrl());
                        Image image = ImageIO.read(url);
                        Image imageResize = image.getScaledInstance(230, 300,  java.awt.Image.SCALE_SMOOTH);
                        
                        panel[i].setPreferredSize(new Dimension(260, 400));
                        panel[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                        panel[i].setBorder(new EmptyBorder(10, 10, 30, 10));
                        
                        lbimg[i] = new JLabel();
                        lbimg[i].setSize(new Dimension(260, 30));
                        lbimg[i].setIcon(new ImageIcon(imageResize));
                        
                        String urlDetail = list.get(i).getUrlDetail();
                        String id = list.get(i).getId();
                        while () {
                            lbimg[i].addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    try {
                                        
                                        System.out.println("OK");
                                        String request = "getDetail "+urlDetail+" "+id;
                                        requestToServer(request);
                                        getDetail();
                                    } catch (IOException | ClassNotFoundException ex) {
                                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
                        }
                        
                        lbname[i] = new JLabel();
                        lbname[i].setText(list.get(i).getMovieName());
                        lbname[i].setSize(260,10);
                        
                        lbdate[i] = new JLabel();
                        lbdate[i].setText(list.get(i).getDateRelease());
                        lbdate[i].setSize(260,10);
                        
                        panel[i].add(lbimg[i],BorderLayout.NORTH);
                        panel[i].add(lbname[i],BorderLayout.CENTER);
                        panel[i].add(lbdate[i],BorderLayout.SOUTH);
                        rightPanel.add(panel[i]);
                    }
                    rightPanel.revalidate();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static void getDetail() throws IOException, ClassNotFoundException{
        Object object = getFromServer();
        ArrayList<MovieDetail> list = (ArrayList<MovieDetail>) object;
        String test = list.get(1).getProductor();
        String[] test2 = test.split(" ");
        //JFrame detail = new JFrame("Chi tiet");
        //detail.setSize(new Dimension(1000));
        
    }
    
    public static void requestToServer(String request){
        try {
            DataOutputStream sendServer = new DataOutputStream(socket.getOutputStream());
            sendServer.writeChars(request);
            sendServer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Object getFromServer() throws IOException, ClassNotFoundException{
        
        Object object = sentFromServer.readObject();
        return object;
    }
    
    public static void main(String [] Argvs) throws IOException, ClassNotFoundException{
        Client a= new Client();
        a.startClient();
    }
}
