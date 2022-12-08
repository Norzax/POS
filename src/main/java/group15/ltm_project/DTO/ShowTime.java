package group15.ltm_project.DTO;

import java.util.ArrayList;

/**
 *
 * @author baoluan
 */
public class ShowTime {
    private String nameShowtime;
    private ArrayList<String> time;

    public ShowTime(String nameShowtime, ArrayList<String> time) {
        this.nameShowtime = nameShowtime;
        this.time = time;
    }

    public String getNameShowtime() {
        return nameShowtime;
    }

    public void setNameShowtime(String nameShowtime) {
        this.nameShowtime = nameShowtime;
    }

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }
}
