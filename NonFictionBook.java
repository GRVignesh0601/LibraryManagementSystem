public class NonFictionBook extends Book {
    private String subjectArea;

    public NonFictionBook(String title, String author, String isbn, String subjectArea) {
        super(title, author, isbn); // Call the parent constructor
        this.subjectArea = subjectArea;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    @Override
    public String toString() {
        return "Non-Fiction Book - " + super.toString() + ", Subject: '" + subjectArea + '\'';
    }
}