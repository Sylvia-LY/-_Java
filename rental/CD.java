public class CD extends Item {
    private String artist;
    private int trackCount;

    public CD(String artist, int trackCount, String title, int releaseYear, int duration, boolean inStore) {
        super(title, releaseYear, duration, inStore);
        this.artist = artist;
        this.trackCount = trackCount;
    }

    public void displayInfo() {
        System.out.println("CD - ");
        super.displayInfo();
        System.out.println("artist: "+artist);
    }
}