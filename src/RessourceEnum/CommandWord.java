package RessourceEnum;
import Launch.Game;


public enum CommandWord {
    GO (Game.messages.getString("go")),
    QUIT(Game.messages.getString("quit")),
    HELP(Game.messages.getString("help")),
    LOOK(Game.messages.getString("look")),
    INVENTORY(Game.messages.getString("inventory")),
    UNKNOWN(Game.messages.getString("unknown")),
    TAKE(Game.messages.getString("take")),
    UNLOCK(Game.messages.getString("unlock")),
    CODE(Game.messages.getString("code")),
    OFF(Game.messages.getString("off")),
    ON(Game.messages.getString("on"));

    private String mot ="";

    CommandWord(String mot){
        this.mot = mot;
    }

    /**
     * Getter to have the word associate to an enum word
     * @return a word
     */
    public String toString(){
        return mot;
    }

}
