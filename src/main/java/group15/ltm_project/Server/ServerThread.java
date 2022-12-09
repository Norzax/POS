package group15.ltm_project.Server;

import group15.ltm_project.Client.Client;
import group15.ltm_project.DTO.MovieDetail;
import group15.ltm_project.DTO.MovieResponse;
import group15.ltm_project.DTO.MovieServices;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baoluan
 */
public class ServerThread implements Runnable{
    private final Socket socket;
    private String request;
    private final int clientPort;
    private static ObjectOutputStream outToClient = null;
    private static ObjectInputStream sentFromClient = null;
    private boolean isClosed;

    public static ObjectOutputStream getOutToClient() {
        return outToClient;
    }

    public static void setOutToClient(ObjectOutputStream outToClient) {
        ServerThread.outToClient = outToClient;
    }

    public static ObjectInputStream getSentFromClient() {
        return sentFromClient;
    }

    public static void setSentFromClient(ObjectInputStream sentFromClient) {
        ServerThread.sentFromClient = sentFromClient;
    }

    public int getClientPort() {
        return clientPort;
    }
    
    public ServerThread(Socket socket, int clientPort, String request){
        this.socket = socket;
        this.request = request;
        this.clientPort = clientPort;
        System.out.println("Server thread client " + clientPort + " Started");
        isClosed = false;
        
    }
    
    public static String getRequest(String request){
        return request;
    }
    
    @Override
    public void run(){
        System.out.println("Client " + socket.toString() + " accepted!");
        
        try{
            System.out.println("Start new thread success, Port: " + clientPort);
            while (true) {
                if(request.equals("a")){
                    ArrayList<MovieResponse> result = MovieServices.getAllMovie();
                    try {
                        outToClient = new ObjectOutputStream(socket.getOutputStream());
                        outToClient.writeObject(result);
                        outToClient.reset();
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }//else if(request.equals("b")){
//                    ArrayList<MovieDetail> result = MovieServices.getMovieDetail("14227");
//                    try {
//                        outToClient = new ObjectOutputStream(socket.getOutputStream());
//                        outToClient.writeObject(result);
//                        outToClient.reset();
//
//                    } catch (IOException ex) {
//                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
        } catch (IOException e) {
//            isClosed = true;
//            Server.serverThreadBus.remove(clientPort);
            System.out.println("Client with port "+clientPort+" is out!");
            
        }
    }
}
