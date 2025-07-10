import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Optional;

public class LibraryManagementSystem {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some initial data
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        library.addBook(new FictionBook("Dune", "Frank Herbert", "978-0441172719", "Science Fiction"));
        library.addBook(new NonFictionBook("Sapiens", "Yuval Noah Harari", "978-0062316097", "History"));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935"));
        library.addBook(new FictionBook("To Kill a Mockingbird", "Harper Lee", "978-0061120084", "Southern Gothic"));

        library.addMember(new Member("Alice Smith"));
        library.addMember(new Member("Bob Johnson"));
        library.addMember(new Member("Charlie Brown"));


        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1: addBook(); break;
                    case 2: removeBook(); break;
                    case 3: searchBook(); break;
                    case 4: library.displayAllBooks(); break;
                    case 5: addMember(); break;
                    case 6: removeMember(); break;
                    case 7: searchMember(); break;
                    case 8: library.displayAllMembers(); break;
                    case 9: borrowBook(); break;
                    case 10: returnBook(); break;
                    case 0: System.out.println("Exiting Library Management System. Goodbye!"); break;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // Set to invalid to continue loop
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                choice = -1;
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user to press Enter
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Library Management System ---");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");
        System.out.println("4. Display All Books");
        System.out.println("---------------------------------");
        System.out.println("5. Add Member");
        System.out.println("6. Remove Member");
        System.out.println("7. Search Member");
        System.out.println("8. Display All Members");
        System.out.println("---------------------------------");
        System.out.println("9. Borrow Book");
        System.out.println("10. Return Book");
        System.out.println("---------------------------------");
        System.out.println("0. Exit");
        System.out.println("---------------------------------");
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Is this a (1) Fiction Book or (2) Non-Fiction Book or (3) General Book? ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book newBook;
        switch (typeChoice) {
            case 1:
                System.out.print("Enter genre: ");
                String genre = scanner.nextLine();
                newBook = new FictionBook(title, author, isbn, genre);
                break;
            case 2:
                System.out.print("Enter subject area: ");
                String subject = scanner.nextLine();
                newBook = new NonFictionBook(title, author, isbn, subject);
                break;
            case 3:
            default: // Default to general book if invalid choice
                newBook = new Book(title, author, isbn);
                System.out.println("Defaulting to a general book type.");
                break;
        }
        library.addBook(newBook);
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
    }

    private static void searchBook() {
        System.out.println("Search by: (1) ISBN or (2) Title? ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Optional<Book> foundBook = Optional.empty();

        if (searchChoice == 1) {
            System.out.print("Enter ISBN to search: ");
            String isbn = scanner.nextLine();
            foundBook = library.findBookByIsbn(isbn);
        } else if (searchChoice == 2) {
            System.out.print("Enter Title to search: ");
            String title = scanner.nextLine();
            foundBook = library.findBookByTitle(title);
        } else {
            System.out.println("Invalid search choice.");
            return;
        }

        if (foundBook.isPresent()) {
            System.out.println("Book Found: " + foundBook.get());
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        library.addMember(new Member(name));
    }

    private static void removeMember() {
        System.out.print("Enter ID of the member to remove: ");
        try {
            int memberId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            library.removeMember(memberId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid member ID (number).");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private static void searchMember() {
        System.out.print("Enter Member ID to search: ");
        try {
            int memberId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Optional<Member> foundMember = library.findMemberById(memberId);
            if (foundMember.isPresent()) {
                System.out.println("Member Found: " + foundMember.get());
            } else {
                System.out.println("Member not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid member ID (number).");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private static void borrowBook() {
        System.out.print("Enter Member ID: ");
        try {
            int memberId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Book ISBN to borrow: ");
            String bookIsbn = scanner.nextLine();
            library.borrowBook(memberId, bookIsbn);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid member ID (number).");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private static void returnBook() {
        System.out.print("Enter Member ID: ");
        try {
            int memberId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Book ISBN to return: ");
            String bookIsbn = scanner.nextLine();
            library.returnBook(memberId, bookIsbn);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid member ID (number).");
            scanner.nextLine(); // Consume invalid input
        }
    }
}

