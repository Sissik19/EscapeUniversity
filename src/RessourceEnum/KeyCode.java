package RessourceEnum;
import Launch.Game;

public enum KeyCode {
    CODE1(alea()),
    CODE2(alea()),
    CODE3(alea()),
    CODE4(alea()),
    CODE5(alea()),
    CODE6(alea()),
    GREEN(Game.messages.getString("green")),
    BROWN(Game.messages.getString("brown")),
    ORANGE(Game.messages.getString("orange")),
    PINK(Game.messages.getString("pink")),
    RED(Game.messages.getString("red")),
    BLUE(Game.messages.getString("blue")),
    GREY(Game.messages.getString("grey")),
    BLACK(Game.messages.getString("black")),
    YELLOW(Game.messages.getString("yellow")),
    WHITE(Game.messages.getString("white")),
    VIOLET(Game.messages.getString("violet")),
    SQUARE(Game.messages.getString("square")),
    CORAL(Game.messages.getString("coral"));


    private String mot ="";

    KeyCode(String mot){
        this.mot = mot;
    }

    public String toString(){
        return mot;
    }

    private static String alea(){
        String x = String.valueOf((int)(Math.random()*9999));
        return x;
    }
}
