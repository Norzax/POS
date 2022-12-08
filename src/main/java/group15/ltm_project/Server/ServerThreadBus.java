package group15.ltm_project.Server;

import java.util.ArrayList;

/**
 *
 * @author baoluan
 */
public class ServerThreadBus {
    private final ArrayList<ServerThread> listServerThreads;

    public ArrayList<ServerThread> getListServerThreads() {
        return listServerThreads;
    }

    public ServerThreadBus() {
        listServerThreads = new ArrayList<>();
    }

    public void add(ServerThread serverThread){
        listServerThreads.add(serverThread);
    }
    
    public int getLength(){
        return listServerThreads.size();
    }
    
    public void remove(int id){
        for(int i=0; i<Server.serverThreadBus.getLength(); i++){
            if(Server.serverThreadBus.getListServerThreads().get(i).getClientPort()==id){
                Server.serverThreadBus.listServerThreads.remove(i);
            }
        }
    }
}
