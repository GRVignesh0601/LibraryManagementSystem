import java.util.Objects; // For equals and hashCode

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // By default, a new book is available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters (for availability, title/author/isbn are usually immutable after creation)
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Override toString for easy printing of Book details
    @Override
    public String toString() {
        return "Title: '" + title + '\'' +
               ", Author: '" + author + '\'' +
               ", ISBN: '" + isbn + '\'' +
               ", Available: " + (isAvailable ? "Yes" : "No");
    }

    // Override equals and hashCode for proper comparison, especially useful for searching/removing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn); // ISBN is a good unique identifier
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}