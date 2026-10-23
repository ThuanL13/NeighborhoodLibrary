public class Book {
    // Properties
    private int id; // id
    private String isbn; // isbn(Book serial number)
    private String title; // title
    private boolean isCheckedOut; // isCheckedOut
    private String checkedOutTo; // checkedOutTo

    // Constructor for creating new object (overloaded)
    public Book(int id, String isbn, String title) {
        this.id = id; // Assigning parameter to variable
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    // Default Constructor
    public Book() {
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    // Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    // Method used to check out
    public void checkOut(String name) {
        isCheckedOut = false; // Book is checked out
        checkedOutTo = name; // Stores name
    }
    public void checkIn() {
        isCheckedOut = false; // Book is available for checkout
        checkedOutTo = ""; // Removes name that was stored
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }
}
