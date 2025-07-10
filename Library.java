import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // For cleaner search results

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // --- Book Management ---
    public void addBook(Book book) {
        if (!books.contains(book)) { // Prevent adding duplicate books (based on ISBN)
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book with ISBN " + book.getIsbn() + " already exists.");
        }
    }

    public void removeBook(String isbn) {
        Optional<Book> bookToRemove = books.stream()
                                          .filter(b -> b.getIsbn().equals(isbn))
                                          .findFirst();
        if (bookToRemove.isPresent()) {
            if (bookToRemove.get().isAvailable()) { // Only remove if not borrowed
                books.remove(bookToRemove.get());
                System.out.println("Book removed: " + bookToRemove.get().getTitle());
            } else {
                System.out.println("Cannot remove " + bookToRemove.get().getTitle() + ". It is currently borrowed.");
            }
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                    .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                    .findFirst();
    }

    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .findFirst();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- All Books in Library ---");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("----------------------------");
    }

    // --- Member Management ---
    public void addMember(Member member) {
        if (!members.contains(member)) { // Prevent adding duplicate members (based on ID)
            members.add(member);
            System.out.println("Member added: " + member.getName() + " (ID: " + member.getMemberId() + ")");
        } else {
            System.out.println("Member with ID " + member.getMemberId() + " already exists.");
        }
    }

    public void removeMember(int memberId) {
        Optional<Member> memberToRemove = members.stream()
                                                .filter(m -> m.getMemberId() == memberId)
                                                .findFirst();
        if (memberToRemove.isPresent()) {
            if (memberToRemove.get().getBorrowedBooks().isEmpty()) { // Only remove if no borrowed books
                members.remove(memberToRemove.get());
                System.out.println("Member removed: " + memberToRemove.get().getName());
            } else {
                System.out.println("Cannot remove " + memberToRemove.get().getName() + ". They have borrowed books.");
            }
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }

    public Optional<Member> findMemberById(int memberId) {
        return members.stream()
                      .filter(member -> member.getMemberId() == memberId)
                      .findFirst();
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("\n--- All Library Members ---");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("---------------------------");
    }

    // --- Borrow/Return Operations ---
    public void borrowBook(int memberId, String bookIsbn) {
        Optional<Member> memberOpt = findMemberById(memberId);
        Optional<Book> bookOpt = findBookByIsbn(bookIsbn);

        if (memberOpt.isPresent() && bookOpt.isPresent()) {
            memberOpt.get().borrowBook(bookOpt.get());
        } else {
            System.out.println("Error: Member or Book not found for borrowing operation.");
        }
    }

    public void returnBook(int memberId, String bookIsbn) {
        Optional<Member> memberOpt = findMemberById(memberId);
        Optional<Book> bookOpt = findBookByIsbn(bookIsbn);

        if (memberOpt.isPresent() && bookOpt.isPresent()) {
            memberOpt.get().returnBook(bookOpt.get());
        } else {
            System.out.println("Error: Member or Book not found for returning operation.");
        }
    }
}

