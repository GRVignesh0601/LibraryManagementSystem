**LIBRARY MANAGEMENT SYSTEM**
---
Here I have created a simple console-based Library Management System.This code focuses on demonstrating the core OOP concepts you mentioned: Arrays/ArrayLists, Strings, OOP, Encapsulation, and Inheritance.
---
**Key Features:**
  * **Book Management:** Add, remove, search, display all books.
  * **Member Management:** Add, remove, search, display all members.
  * **Borrowing/Returning:** Members can borrow and return books.
  * **Basic Encapsulation:** Private fields with public getters/setters.
  * **Inheritance:** (Basic example with `FictionBook` and `NonFictionBook`)
  * **Arrays/ArrayLists:** Used to store collections of `Book` and `Member` objects.
---
Technologies Used:
  **JAVA**: The core programming Language.
    Basic Encapsulation: Private fields with public getters/setters.
    Inheritance: Basic example with `FictionBook` and `NonFictionBook`.
    Arrays/ArrayLists: Used to store collections of `Book` and `Member` objects.
  ---
**Files Created:**
   * Book.java
   * FictionBook.java
   * NonFictionBook.java
   * Library.java
   * Member.java
   * LibraryManagementSystem.java (Main Class)
**How to Compile and Run:**

1.  **Save:** Save each code block into its respective `.java` file (e.g., `Book.java`, `Member.java`, etc.). Make sure all files are in the same directory.
2.  **Compile:** Open your terminal or command prompt, navigate to the directory where you saved the files, and compile them:
    ```bash
    javac Book.java FictionBook.java NonFictionBook.java Member.java Library.java LibraryManagementSystem.java
    ```
    Or simply:
    ```bash
    javac *.java
    ```
3.  **Run:** After successful compilation, run the main class:
    ```bash
    java LibraryManagementSystem
**Concepts Demonstrated:**

  * **OOP:** Clearly defined classes (`Book`, `Member`, `Library`) with properties (attributes) and behaviors (methods).
  * **Encapsulation:** Private fields in `Book` and `Member` accessible only through public getter and setter methods. This protects the internal state of objects.
  * **Inheritance:** `FictionBook` and `NonFictionBook` extend `Book`, inheriting its properties and methods, and adding their own specific attributes (genre, subjectArea).
  * **Arrays/ArrayLists:** `Library` class uses `ArrayList<Book>` and `ArrayList<Member>` to store collections of objects, allowing dynamic resizing. `Member` also uses `ArrayList<Book>` for borrowed books.
  * **Strings:** Heavily used for titles, authors, ISBNs, names, and user input.
  * **`toString()` method:** Overridden in all classes for meaningful object representation when printed.
  * **`equals()` and `hashCode()`:** Overridden in `Book` (by ISBN) and `Member` (by ID) for correct comparison and collection behavior (e.g., `ArrayList.contains()`, `ArrayList.remove()`).
  * **Input Handling:** Using `Scanner` for user input, with basic error handling for `InputMismatchException`.
  * **`Optional`:** Used in `Library`'s `findBookByIsbn`, `findBookByTitle`, and `findMemberById` methods for safer handling of potentially non-existent objects.

## License

This project is licensed under the MIT License.
