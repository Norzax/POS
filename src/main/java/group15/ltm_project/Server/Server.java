package group15.ltm_project.Server;

import group15.ltm_project.Client.Client;
import group15.ltm_project.DTO.MovieDetail;
import group15.ltm_project.DTO.MovieServices;
import group15.ltm_project.DTO.MovieResponse;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baoluan
 */
public class Server {
    public static int port = 1312;
    private static ServerSocket movieServer = null;
    private static ObjectOutputStream outToClient = null;
    private static ObjectInputStream sentFromClient = null;
    private static Socket socket = null;
    static ServerThreadBus serverThreadBus = new ServerThreadBus();
    
    public Server() throws IOException, ClassNotFoundException{
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            movieServer = new ServerSocket(port);
            System.out.println("Server binding at port " + port);
            System.out.println("Waiting for client...");
            socket = movieServer.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
            
            //DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            String str = "b";
            System.out.println(str);
            while(true){
                str = inFromClient.readLine();
                System.out.println(str);
                ServerThread serverThread = new ServerThread(socket,socket.getPort(),str);
                serverThreadBus.add(serverThread);
                executor.execute(serverThread);
//                String request = getFromClient();
//                String[] request2 = request.split(" ");
//                System.out.println(request2[1]);
//                if("getDetail".equals(request2[0])){
//                    ArrayList<MovieDetail> result2 = MovieServices.getMovieDetail("14227");
//                    try {
//                        outToClient = new ObjectOutputStream(socket.getOutputStream());
//                        outToClient.writeObject(result2);
//                        outToClient.reset();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally{ 
            if (movieServer != null){
                movieServer.close();
            }
        }
    }
    
    public static void sendToClient(Object object){
        try {
            //outToClient = new ObjectOutputStream(socket.getOutputStream());
            outToClient.writeObject(object);
            outToClient.flush();
            outToClient.reset();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getFromClient() throws IOException, ClassNotFoundException{
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
        
        //DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
        String str = inFromClient.readLine();
        System.out.println(str);
        return str; 
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Server server = new Server();
    }
}
