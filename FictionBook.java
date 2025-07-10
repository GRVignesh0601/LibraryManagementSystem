public class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, String author, String isbn, String genre) {
        super(title, author, isbn); // Call the parent constructor
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Fiction Book - " + super.toString() + ", Genre: '" + genre + '\'';
    }
}
