public class Item {
    private String title;
    private int releaseYear;
    private int duration;
    private boolean inStore;

    public Item(String title, int releaseYear, int duration, boolean inStore) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.inStore = inStore;
    }

    public void displayInfo() {
        System.out.println("title: "+title);
        System.out.println("in store: "+(inStore ? "yes": "no"));
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", inStore=" + inStore +
                '}';
    }
}