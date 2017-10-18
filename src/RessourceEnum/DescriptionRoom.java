package RessourceEnum;
import Launch.Game;

public enum DescriptionRoom {
    OUTSIDE(Game.messages.getString("outside")),
    CORRIDOR(Game.messages.getString("corridor")),
    HALL(Game.messages.getString("hall")),
    THEATER(Game.messages.getString("theater")),
    BACKTHEATER(Game.messages.getString("backtheater")),
    MUSICCLASS(Game.messages.getString("musicclass")),
    PUB(Game.messages.getString("pub")),
    COMPUTINGLAB(Game.messages.getString("computinglab")),
    BALCONY(Game.messages.getString("balcony")),
    SECRETARIAT(Game.messages.getString("secretariat")),
    DIRECTORY(Game.messages.getString("directory")),
    ATTIC(Game.messages.getString("attic")),
    SECRETROOM(Game.messages.getString("secretroom")),
    PUBRESERVE(Game.messages.getString("pubReserve")),
    BOTANICCLASS(Game.messages.getString("botanicClass")),
    THEATERCLASS(Game.messages.getString("theaterClass")),
    VERANDA(Game.messages.getString("veranda")),
    BOOKSHELF(Game.messages.getString("bookshelf")),
    DIRECBOOKSHELF(Game.messages.getString("direcBookshelf")),
    RESTAURANT(Game.messages.getString("restaurant")),
    KITCHEN(Game.messages.getString("kitchen")),
    MEETING(Game.messages.getString("meeting")),
    GARDEN(Game.messages.getString("garden")),
    DIRECLAB(Game.messages.getString("direcLab")),
    ELECBAY(Game.messages.getString("elecBay")),
    AMPHI(Game.messages.getString("amphi")),
    PRINTER(Game.messages.getString("printer")),
    PROFESSOR(Game.messages.getString("professor")),
    STOCK(Game.messages.getString("stock")),
    STOCKSC(Game.messages.getString("stockSC")),
    ATTICUP(Game.messages.getString("atticUp")),
    UPGARDEN(Game.messages.getString("upGarden")),
    CLASS(Game.messages.getString("class"));


    private String mot ="";

    DescriptionRoom(String mot){
        this.mot = mot;
    }

    public String toString(){
        return mot;
    }
}
