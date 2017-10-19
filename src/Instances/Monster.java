package Instances;

import java.util.ArrayList;

public class Monster {
    Room position;
    public Monster (Room room){
        position = room;
    }

    public void move(){
        ArrayList<Door> exist = position.getAllExist();
        int nbrAlea = 0 + (int)(Math.random() * (exist.size() - 0));
        position = exist.get(nbrAlea).getRoom();
        System.out.println("Monstre : "+position.getDescription());
    }
}