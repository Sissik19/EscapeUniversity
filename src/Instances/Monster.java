package Instances;

import java.util.ArrayList;
import java.util.TimerTask;

public class Monster extends TimerTask{
    Room position;
    public Monster (Room room){
        position = room;
    }

    public void run(){
        ArrayList<Door> exist = position.getAllExist();
        int nbrAlea = 0 + (int)(Math.random() * (exist.size() - 0));
        position = exist.get(nbrAlea).getRoom();
    }

    public Room getPosition(){
        return position;
    }
}
