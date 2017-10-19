package Instances;

public class Person {
    int life;

    public Person(){
        life = 1;
    }

    public void looseLife(){
        life--;
    }

    public int getLife() {
        return life;
    }
}
