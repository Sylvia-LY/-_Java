import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<>();

    public Game() {
        handlers.put("go", new GoHandler());
        handlers.put("help", new HelpHandler());
        handlers.put("bye", new ByeHandler());

        createRooms();
    }

    private void createRooms() {
        Room courtyard = new Room("城堡外");
        Room lobby = new Room("大堂");
        Room pub = new Room("小酒吧");
        Room study = new Room("书房");
        Room bedroom = new Room("卧室");

        // 设计房间的出口
        courtyard.setExit("south", study);
        courtyard.setExit("west", pub);
        courtyard.setExit("east", lobby);

        lobby.setExit("west", courtyard);

        pub.setExit("east", courtyard);

        study.setExit("north", courtyard);
        study.setExit("east", bedroom);

        bedroom.setExit("west", study);

        // 出生点城堡外
        currentRoom = courtyard;
    }

    public void printWelcome() {
        System.out.println("Welcome to the castle. Explore the castle to discover its secrets");
        System.out.println("Type 'help' if you need assistance");

        showPrompt();
    }

    public void showPrompt() {
        System.out.println();
        System.out.println("you are in "+currentRoom);
        System.out.println("Exits: "+currentRoom.getAllExits());
    }

    public void proceedToNextRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if ( nextRoom==null ) {
            System.out.println("You can't go that way");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You move "+direction+" to "+currentRoom);
            showPrompt();
        }
    }


    public void play() {
        Scanner in = new Scanner(System.in);
        while ( true ) {
            // 命令解析
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String word = "";
            if ( words.length>1 ) {
                word = words[1];
            }

            if ( handler==null ) {
                System.out.println("I don't understand that command");
            }
            else {
                boolean shouldExit = handler.doCmd(word, this);
                if ( shouldExit ) {
                    break;
                }
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();
        System.out.println("Thanks for visiting. Goodbye!");
    }


}
