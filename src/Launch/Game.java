package Launch;


import Commands.*;
import RessourceEnum.*;
import Instances.*;

import java.util.*;

public class Game {

    /**
     *  This class is the main class, text based adventure game.  Users
     *  can walk around some scenery. That's all. It should really be extended
     *  to make it more interesting!
     *
     *  To play this adventure game, create an instance of this class and call the "play"
     *  method.
     *
     *  This main class creates and initialises all the others: it creates all
     *  rooms, creates the parser and starts the game.  It also evaluates and
     *  executes the commands that the parser returns.
     *
     */
    private static Game jeu;
    private Parser parser;
    private Parser parser2;
    private Room currentRoom;
    private Inventory inventory;
    private String north = Direction.NORTH.toString();
    private String south = Direction.SOUTH.toString();
    private String west = Direction.WEST.toString();
    private String east = Direction.EAST.toString();
    private String up = Direction.UP.toString();
    private String down = Direction.DOWN.toString();
    private String close = StateDoor.CLOSE.toString();
    private String open = StateDoor.OPEN.toString();
    private String dclose = StateDoor.DCLOSE.toString();
    private String hide = StateDoor.HIDE.toString();
    private String code = StateDoor.CODE.toString();
    private Key orange, pink, red, blue, grey, black, yellow,code1,code2, code3, code4, code5, code6, green, brown,white, violet, coral, square;
    public Room hall1,corridor1,corridor2,corridor3,corridor4,corridor5,corridor6,corridor7,corridor8,corridor9,hall2,
            garden,veranda1, veranda2, botanicClass, pubReserve, theaterClass, bookshelf, direcBookshelf, meeting1, meeting2,
            restaurant, kitchen, hall3, hall4, elecBay, directLab, amphi, printer, professor, upGarden,goAttic, stock1,
            stock2, stock3, corridor10, corridor11, class1, class2, class3, class4, class5,
            theater, backTheater, musicClass, pub, computingLab, balcony, secretariat, directory, attic,
            secretRoom, outside;
    private static String language;
    private static String country;
    private static Locale currentLocale;
    public static ResourceBundle messages;
    public Monster monster;
    /**
     * Create the game and initialise its internal map.
     */
    public Game()  {
        createKey();
        createInventory();
        createRooms();
        monster = new Monster(restaurant);
        parser = new Parser();
        parser2 = new Parser();
    }

    private void createKey(){
        orange = new Key(KeyCode.ORANGE.toString());
        pink = new Key(KeyCode.PINK.toString());
        red = new Key(KeyCode.RED.toString());
        blue = new Key(KeyCode.BLUE.toString());
        grey = new Key(KeyCode.GREY.toString());
        black = new Key(KeyCode.BLACK.toString());
        yellow = new Key(KeyCode.YELLOW.toString());
        code1 = new Key(KeyCode.CODE1.toString());
        code2 = new Key(KeyCode.CODE2.toString());
        code3 = new Key(KeyCode.CODE3.toString());
        code4 = new Key(KeyCode.CODE4.toString());
        code5 = new Key(KeyCode.CODE5.toString());
        code6 = new Key(KeyCode.CODE6.toString());
        white = new Key(KeyCode.WHITE.toString());
        violet = new Key(KeyCode.VIOLET.toString());
        green = new Key(KeyCode.GREEN.toString());
        brown = new Key(KeyCode.BROWN.toString());
        coral = new Key(KeyCode.CORAL.toString());
        square = new Key(KeyCode.SQUARE.toString());


    }
    private void createInventory(){
        inventory = new Inventory();
    }
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {


        // create the rooms
        outside = new Room(DescriptionRoom.OUTSIDE.toString());
        hall1 = new Room(DescriptionRoom.HALL.toString());
        hall2 = new Room(DescriptionRoom.HALL.toString());
        corridor1 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor2 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor3 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor4 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor5 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor6 = new Room(DescriptionRoom.CORRIDOR.toString());
        theater = new Room(DescriptionRoom.THEATER.toString());
        backTheater = new Room(DescriptionRoom.BACKTHEATER.toString(), violet);
        pub = new Room(DescriptionRoom.PUB.toString(), square);
        pubReserve = new Room(DescriptionRoom.PUBRESERVE.toString(), orange);
        botanicClass = new Room(DescriptionRoom.BOTANICCLASS.toString(), yellow);
        veranda1 = new Room(DescriptionRoom.VERANDA.toString());
        veranda2 = new Room(DescriptionRoom.VERANDA.toString(), code4);
        theaterClass = new Room(DescriptionRoom.THEATERCLASS.toString(), blue);
        bookshelf = new Room(DescriptionRoom.BOOKSHELF.toString());
        direcBookshelf = new Room(DescriptionRoom.DIRECBOOKSHELF.toString(), code1);
        restaurant = new Room(DescriptionRoom.RESTAURANT.toString());
        kitchen = new Room(DescriptionRoom.KITCHEN.toString(), code3);
        meeting1 = new Room(DescriptionRoom.MEETING.toString(), white);
        meeting2 = new Room(DescriptionRoom.MEETING.toString());
        garden = new Room(DescriptionRoom.GARDEN.toString());
        musicClass = new Room(DescriptionRoom.MUSICCLASS.toString(), brown);
        class1 = new Room(DescriptionRoom.CLASS.toString());

        balcony = new Room(DescriptionRoom.BALCONY.toString());
        secretariat = new Room(DescriptionRoom.SECRETARIAT.toString());
        directory = new Room(DescriptionRoom.DIRECTORY.toString(),green);
        corridor7 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor8 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor9 = new Room(DescriptionRoom.CORRIDOR.toString());
        hall3 = new Room(DescriptionRoom.HALL.toString());
        hall4 = new Room(DescriptionRoom.HALL.toString());
        directLab = new Room(DescriptionRoom.DIRECLAB.toString(), code2);
        upGarden = new Room(DescriptionRoom.UPGARDEN.toString());
        elecBay = new Room(DescriptionRoom.ELECBAY.toString());
        amphi = new Room(DescriptionRoom.AMPHI.toString(), coral);
        printer = new Room(DescriptionRoom.PRINTER.toString(), grey);
        professor = new Room(DescriptionRoom.PROFESSOR.toString(), code5);
        computingLab = new Room(DescriptionRoom.COMPUTINGLAB.toString());
        goAttic = new Room(DescriptionRoom.ATTICUP.toString());
        class2 = new Room(DescriptionRoom.CLASS.toString(), black);
        class3 = new Room(DescriptionRoom.CLASS.toString());
        class4 = new Room(DescriptionRoom.CLASS.toString());
        class5 = new Room(DescriptionRoom.CLASS.toString());


        attic = new Room(DescriptionRoom.ATTIC.toString(), null);
        secretRoom = new Room(DescriptionRoom.SECRETROOM.toString(), red);
        corridor10 = new Room(DescriptionRoom.CORRIDOR.toString());
        corridor11 = new Room(DescriptionRoom.CORRIDOR.toString());
        stock1 = new Room(DescriptionRoom.STOCK.toString(), pink);
        stock2 = new Room(DescriptionRoom.STOCK.toString());
        stock3 = new Room(DescriptionRoom.STOCKSC.toString());



        // initialise room exits
        hall1.setExit(north,outside, dclose, green, red);
        hall1.setExit(south,corridor1);
        hall1.setExit(west,pub);
        hall1.setExit(east,corridor6);
        hall1.setExit(up,hall3);

        corridor1.setExit(north, hall1);
        corridor1.setExit(south, corridor2);
        corridor1.setExit(west, restaurant);
        corridor1.setExit(east, corridor3);

        corridor2.setExit(north, corridor1);
        corridor2.setExit(south, meeting2);
        corridor2.setExit(west, meeting1, close, black);
        corridor2.setExit(east, corridor3);

        corridor3.setExit(north, garden);
        corridor3.setExit(south, musicClass, close, square);
        corridor3.setExit(west, corridor2);
        corridor3.setExit(east, hall2);

        corridor4.setExit(north, corridor5);
        corridor4.setExit(south, hall2);
        corridor4.setExit(west, garden);

        corridor5.setExit(north, veranda1);
        corridor5.setExit(south, corridor4);
        corridor5.setExit(west, corridor6);
        corridor5.setExit(east, theater);

        corridor6.setExit(south, garden);
        corridor6.setExit(west, hall1);
        corridor6.setExit(east, corridor5);

        corridor7.setExit(north, hall3);
        corridor7.setExit(south, corridor8);
        corridor7.setExit(west, amphi, code, code5);
        corridor7.setExit(east, upGarden);

        corridor8.setExit(north, corridor7);
        corridor8.setExit(south, class2);
        corridor8.setExit(west, secretariat);
        corridor8.setExit(east, corridor9);

        corridor9.setExit(north, upGarden);
        corridor9.setExit(south, class3);
        corridor9.setExit(west, corridor8);
        corridor9.setExit(east, hall4);

        hall2.setExit(north, corridor4);
        hall2.setExit(south, class1);
        hall2.setExit(west, corridor3);
        hall2.setExit(east, bookshelf);
        hall2.setExit(up, hall4);

        garden.setExit(north, corridor6);
        garden.setExit(south, corridor3);
        garden.setExit(west, corridor1);
        garden.setExit(east, corridor4);
        garden.setExit(up, upGarden);

        veranda1.setExit(south, corridor3);
        veranda1.setExit(east, veranda2, close, yellow);
        veranda1.setExit(west, botanicClass, close, blue);

        veranda2.setExit(west, veranda1);

        botanicClass.setExit(east, veranda1);

        pubReserve.setExit(east, pub);

        theaterClass.setExit(north, theater);

        bookshelf.setExit(west, hall2);
        bookshelf.setExit(south, direcBookshelf, close, grey);

        meeting1.setExit(east, corridor2);

        meeting2.setExit(north, corridor2);

        restaurant.setExit(west, kitchen, code, code4);
        restaurant.setExit(east, corridor1);

        kitchen.setExit(east, restaurant);

        hall3.setExit(west, goAttic);
        hall3.setExit(east, class5);
        hall3.setExit(south, corridor7);
        hall3.setExit(down, hall2);

        hall4.setExit(north, computingLab);
        hall4.setExit(south, printer, code, code2);
        hall4.setExit(west, corridor9);
        hall4.setExit(east, class4);
        hall4.setExit(down, hall2);

        elecBay.setExit(west, computingLab);

        directLab.setExit(south, computingLab);

        amphi.setExit(east, corridor7);

        printer.setExit(north, hall4);

        professor.setExit(east, printer);

        upGarden.setExit(down, garden);
        upGarden.setExit(south, corridor9);
        upGarden.setExit(west, corridor7);

        goAttic.setExit(east, hall3);
        goAttic.setExit(up, attic);

        stock1.setExit(north, corridor10);

        stock2.setExit(north, corridor11);

        stock3.setExit(west, corridor11);
        stock3.setExit(south, secretRoom, hide, pink);

        corridor10.setExit(south, stock1, close, violet);
        corridor10.setExit(west, attic);
        corridor10.setExit(east, corridor11);

        corridor11.setExit(south, stock2);
        corridor11.setExit(west, corridor10);
        corridor11.setExit(east, stock3);

        class1.setExit(north, hall2);

        class2.setExit(north, corridor8);

        class3.setExit(north, corridor9);

        class4.setExit(west, hall4);

        class5.setExit(west, hall3);

        theater.setExit(west, corridor5);
        theater.setExit(east, backTheater, code, code1);
        theater.setExit(south, theaterClass, close, coral);
        theater.setExit(up, balcony);

        backTheater.setExit(west, theater);

        musicClass.setExit(north, corridor3);

        pub.setExit(east, hall1);
        pub.setExit(west, pubReserve, code , code3);

        computingLab.setExit(north, directLab, close, white);
        computingLab.setExit(south, hall4);
        computingLab.setExit(east, elecBay);

        balcony.setExit(down, theater);

        secretariat.setExit(east, corridor8);
        secretariat.setExit(south, directory, dclose, brown, orange);

        directory.setExit(north, secretariat);

        attic.setExit(down, goAttic);
        attic.setExit(east, corridor10);

        secretRoom.setExit(north, stock3, close, pink);

        outside.setExit(south, hall1);

        currentRoom = garden;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    private void play()  {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            if (currentRoom.equals(outside)){
                finished = processCommand(new Command(CommandWord.QUIT.toString(), null));
            }
        }
        System.out.println(Text.GOODBYE.toString());
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println(Text.WELCOME.toString());
        printHelp();
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        String sWord = command.getCommandWord();
        CommandWord commandWords = new CommandWords().getCommandWords(sWord);
        if(CommandWord.UNKNOWN.equals(commandWords)) {
            System.out.println(Text.IDK.toString());
            return false;
        }
        else if (CommandWord.HELP.equals(commandWords))
            printHelp();
        else if (CommandWord.GO.equals(commandWords))
            goRoom(command);
        else if (CommandWord.QUIT.equals(commandWords))
            wantToQuit = quit(command);
        else if(CommandWord.LOOK.equals(commandWords))
            look();
        else if(CommandWord.INVENTORY.equals(commandWords))
            inventory();
        else if(CommandWord.TAKE.equals(commandWords))
            take();
        else if(CommandWord.UNLOCK.equals(commandWords))
            unlock(command);
        else if(CommandWord.CODE.equals(commandWords))
            code(command);
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        CommandWords commandWords = new CommandWords();
        System.out.println(Text.HELP.toString());
        System.out.println(commandWords.allCommand());
    }

    private void unlock(Command command){
        if(!command.hasSecondWord()){
            System.out.println(Text.UNLOCKWHAT.toString());
            return;
        }

        String direction = command.getSecondWord();
        Room lockRoom = null;

        if(direction.equals(north)) {
            lockRoom = currentRoom.getExist(north);
        }
        if(direction.equals(east)) {
            lockRoom = currentRoom.getExist(east);
        }
        if(direction.equals(south)) {
            lockRoom = currentRoom.getExist(south);
        }
        if(direction.equals(west)) {
            lockRoom = currentRoom.getExist(west);
        }
        if(direction.equals(up)) {
            lockRoom = currentRoom.getExist(up);
        }
        if(direction.equals(down)) {
            lockRoom = currentRoom.getExist(down);
        }

        if (lockRoom == null) {
            System.out.println(Text.NODOOR.toString());
        }
        else {
            Door door = currentRoom.getDoor(direction);
            if(door.getOpen().equals(StateDoor.CLOSE.toString()) || door.getOpen().equals(StateDoor.HIDE.toString())){
                if(inventory.existKey(door.getKey1().getCouleur())) {
                    door.setOpen(open);
                    System.out.println(Text.UNLOCKDOOR.toString()+direction);
                    inventory.removeKey(door.getKey1());
                }
                else{
                    System.out.println(Text.NOKEY.toString());
                }

            }
            else if(door.getOpen().equals(StateDoor.DCLOSE.toString())){
                if(inventory.existKey(door.getKey1().getCouleur()) && inventory.existKey(door.getKey2().getCouleur())) {
                    door.setOpen(open);
                    inventory.removeKey(door.getKey1());
                    inventory.removeKey(door.getKey2());
                    System.out.println(Text.UNLOCKDOOR.toString()+direction);
                }
                else if(inventory.existKey(door.getKey1().getCouleur())){
                    currentRoom.removeExit(direction);
                    currentRoom.setExit(direction,lockRoom,close, door.getKey2());
                    inventory.removeKey(door.getKey1());
                    System.out.println(Text.UNLOCK1.toString());
                    System.out.println(Text.NOKEY2.toString());
                }
                else if(inventory.existKey(door.getKey2().getCouleur())){
                    currentRoom.removeExit(direction);
                    currentRoom.setExit(direction,lockRoom, close,door.getKey1());
                    inventory.removeKey(door.getKey2());
                    System.out.println(Text.UNLOCK2.toString());
                    System.out.println(Text.NOKEY1.toString());
                }
                else{
                    System.out.println(Text.NOKEYS.toString());
                }
            }
            else{
                System.out.println(Text.ROOMOPEN.toString());
            }
        }
    }

    private void code(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println(Text.UNLOCKWHAT.toString());
            return;
        }

        String direction = command.getSecondWord();
        Room lockRoom = null;

        if (direction.equals(north)) {
            lockRoom = currentRoom.getExist(north);
        }
        if (direction.equals(east)) {
            lockRoom = currentRoom.getExist(east);
        }
        if (direction.equals(south)) {
            lockRoom = currentRoom.getExist(south);
        }
        if (direction.equals(west)) {
            lockRoom = currentRoom.getExist(west);
        }
        if (direction.equals(up)) {
            lockRoom = currentRoom.getExist(up);
        }
        if (direction.equals(down)) {
            lockRoom = currentRoom.getExist(down);
        }

        if (lockRoom == null) {
            System.out.println(Text.NODOOR.toString());
        } else {
            Door door = currentRoom.getDoor(direction);
            if (door.getOpen().equals(StateDoor.CODE.toString())) {
                System.out.println(Text.CODENUMBER.toString());
                Command command2 = parser2.getCommand();
                String s = command2.getCommandWord();
                if (Command.isNumeric(s)){
                        if (command2.getCommandWord().equals(door.getKey1().getCouleur())){
                            door.setOpen(StateDoor.OPEN.toString());
                            System.out.println(Text.UNLOCKDOOR.toString()+direction);
                        }
                        else{
                            System.out.println(Text.ERRROR.toString());
                        }
                    }
                    else{
                        System.out.println(Text.ERRROR.toString());
                    }
                }
            }
        }
    //}


    /**
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command)  {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println(Text.GOWHERE.toString());
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals(north)) {
            nextRoom = currentRoom.getExist(north);
        }
        if(direction.equals(east)) {
            nextRoom = currentRoom.getExist(east);
        }
        if(direction.equals(south)) {
            nextRoom = currentRoom.getExist(south);
        }
        if(direction.equals(west)) {
            nextRoom = currentRoom.getExist(west);
        }
        if(direction.equals(up)) {
            nextRoom = currentRoom.getExist(up);
        }
        if(direction.equals(down)) {
            nextRoom = currentRoom.getExist(down);
        }

        if (nextRoom == null) {
            System.out.println(Text.NODOOR.toString());
        }
        else {
            Door door = currentRoom.getDoor(direction);
            if(door.getOpen().equals(StateDoor.OPEN.toString())) {
                currentRoom = nextRoom;
                monster.move();
                printLocationInfo();
            }
            else{
                System.out.println(Text.NODOOR.toString());
            }
        }
    }

    /**
     * Permit to have the long description of the room (exits and description)
     */
    private void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command)   {
        if(command.hasSecondWord()) {
            System.out.println(Text.QUITWHAT.toString());
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * "Look" was entered. Print the location info for the room
     */
    private void look (){
        printLocationInfo();
    }

    private void inventory(){
        System.out.println(inventory.seeBag());
    }

    private void take(){
        if(currentRoom.getKey()!=null){
            inventory.addKey(currentRoom.getKey());System.out.println(Text.YOUTAKE.toString()+currentRoom.getKey().getKeyName());
            currentRoom.setKey();
        }
        else{
            System.out.println(Text.NOTHINGTAKE.toString());
        }

    }

    private static void setLanguage(){
        int i = 1;
        Scanner sc = new Scanner(System.in);
        while (i == 1) {
            System.out.println("Choose language : fr or en \nChoississez une langue : fr ou en");
            System.out.print(">");
            String str = sc.nextLine();
            if (str.equals("fr")) {
                language = "fr";
                country = "FR";
                i = 0;
            } else if (str.equals("en")) {
                language = "en";
                country = "US";
                i=0;
            } else {
                System.out.println("Language don't exist / Cette langue n'existe pas");
            }
        }
        currentLocale = new Locale(language,country);
        messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
    }



    public static void main(String[] args) {
        setLanguage();
        jeu = new Game();
        jeu.play();
    }

}
