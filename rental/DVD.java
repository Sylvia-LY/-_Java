public class DVD extends Item {
    private String director;
    private String genre;

    public DVD(String director, String genre, String title, int releaseYear, int duration, boolean inStore) {
        super(title, releaseYear, duration, inStore);
        this.director = director;
        this.genre = genre;
    }

    public void displayInfo() {
        System.out.println("DVD - ");
        super.displayInfo();
        System.out.println("director: "+director);
    }
}
