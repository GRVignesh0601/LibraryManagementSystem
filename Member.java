import java.util.ArrayList;
import java.util.List;
import java.util.Objects; // For equals and hashCode

public class Member {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks; // Use List to hold multiple borrowed books

    private static int nextMemberId = 1001; // To generate unique IDs

    public Member(String name) {
        this.name = name;
        this.memberId = nextMemberId++; // Assign and increment
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods to manage borrowed books
    public void borrowBook(Book book) {
        if (book != null && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false); // Mark book as unavailable
            System.out.println(book.getTitle() + " has been borrowed by " + name);
        } else if (book != null) {
            System.out.println(book.getTitle() + " is currently not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) { // Remove returns true if element was found and removed
            book.setAvailable(true); // Mark book as available
            System.out.println(book.getTitle() + " has been returned by " + name);
        } else {
            System.out.println(name + " did not borrow " + book.getTitle() + ".");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Member ID: ").append(memberId)
          .append(", Name: '").append(name).append('\'')
          .append(", Borrowed Books: [");
        if (borrowedBooks.isEmpty()) {
            sb.append("None");
        } else {
            for (int i = 0; i < borrowedBooks.size(); i++) {
                sb.append(borrowedBooks.get(i).getTitle());
                if (i < borrowedBooks.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Override equals and hashCode based on memberId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
