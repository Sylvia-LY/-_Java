import java.util.HashMap;

public class Room {
    private String name;
    private HashMap<String, Room> exits = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public String getAllExits() {
        StringBuffer ret = new StringBuffer();
        for ( String direction: exits.keySet() ) {
            ret.append(direction);
            ret.append(" ");
        }
        return ret.toString().trim();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
