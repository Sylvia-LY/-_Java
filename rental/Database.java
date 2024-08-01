import java.util.ArrayList;

public class Database {
    private ArrayList<Item> itemList = new ArrayList<>();

    public void add(Item item) {
        itemList.add(item);
    }

    public void list() {
        for ( Item item: itemList ) {
            item.displayInfo();
            System.out.println("华丽的分割线");
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.add(new CD("Nas", 10, "Illmatic", 1994, 40, false));
        db.add(new CD("Kanye West", 21, "The College Dropout", 2004, 76, true));
        db.add(new DVD("James Wan", "Horror", "The Conjuring", 2013, 112, true));
        db.list();

    }
}