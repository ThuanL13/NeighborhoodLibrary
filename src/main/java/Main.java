import java.util.Scanner; // Importing scanner
public class Main {
    static Scanner read = new Scanner(System.in);
    // Making inventory of books
    public static Book[] createInventory() {
        return new Book[] {
                new Book(1, "9780684801223", "The Old Man and the Sea"),
                new Book(2, "9780811232432", "No Longer Human"),
                new Book(3, "9780811224253", "The Setting Sun"),
                new Book(4, "9780061120084", "To Kill a Mockingbird"),
                new Book(5, "9780451524935", "1984"),
                new Book(6, "9780743273565", "The Great Gatsby"),
                new Book(7, "9780141439518", "Pride and Prejudice"),
                new Book(8, "9780316769488", "The Catcher in the Rye"),
                new Book(9, "9780399501487", "Lord of the Flies"),
                new Book(10, "9780451526342", "Animal Farm"),
                new Book(11, "9781451673319", "Fahrenheit 451"),
                new Book(12, "9780547928227", "The Hobbit"),
                new Book(13, "9780062315007", "The Alchemist"),
                new Book(14, "9780439023481", "The Hunger Games"),
                new Book(15, "9780590353427", "Harry Potter and the Sorcerer's Stone"),
                new Book(16, "9780142424179", "The Fault in Our Stars"),
                new Book(17, "9780307474278", "The Da Vinci Code"),
                new Book(18, "9781594631931", "The Kite Runner"),
                new Book(19, "9780375842207", "The Book Thief"),
                new Book(20, "9780060850524", "Brave New World")
        };
    }
    public static void main(String[] args) {
        //Creating Inventory
        Book[] books = createInventory();
        boolean running = true;
        // Display home screen menu
        do {
            System.out.println("\n===== Library Menu ======");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");
            System.out.print("Choose an option: ");
            int choice = read.nextInt();
            read.nextLine();

            // User choices
            switch (choice) {
                case 1 -> showAvailableBooks(books);
                case 2 -> showCheckedOutBooks(books);
                case 3 -> {
                    System.out.println("Goodbye");
                    running = false;
                }
                default -> System.out.println("Invalid Choice");
            }
        } while (running);
        read.close(); // Closing reader in main
    }
    // Displaying available books
    public static void showAvailableBooks(Book[] books) {
        System.out.println("\n===== Available Books =====");
        // For each loop for books
        for (Book book : books) {
            // Showing only available books
            if (!book.isCheckedOut()) {
                System.out.printf(
                        "ID: %d | ISBN: %s | Title: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle());
            }
        }
        // Prompting for user choice
        System.out.print("\nEnter Book ID to check out (0 to return): ");
        int id = read.nextInt();
        read.nextLine();

        // Returning to menu
        if (id == 0) {
            return;
        }
        // Asking for name
        System.out.print("Enter your name: ");
        String name = read.nextLine();

        // Searching array for book selected
        for (Book book : books) {
            if (book.getId() == id && !book.isCheckedOut()) { // & Book is not checked out
                // Check out
                book.checkOut(name);

                // Confirming
                System.out.println("You've checked out: " + book.getTitle());
                return;
            }
        }
        // Book not found
        System.out.println("Book not found");
    }
    // Checked out books
    public static void showCheckedOutBooks(Book[] books) {
        System.out.println("\n ====== Checked Out Books =====");
        // For each loop
        for (Book book : books) {
            // Showing only checked out books
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked out by: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(),
                        book.getCheckedOutTo());
            }
        }
        // Menu Options
        System.out.println("\nC - Check In");
        System.out.println("X - Return To Home");
        String choice = read.nextLine();
        // Switch for choice
        switch (choice.toUpperCase()) {
            case "C" -> checkInBook(books);
            case "X" -> System.out.println("Returning to main menu");
            // Invalid Choice
            default -> System.out.println("Invalid Choice");
        }
    }
    // Check In Method
    public static void checkInBook(Book[] books) {
        // Asking for book ID
        System.out.println("Enter Book ID: ");
        int id = read.nextInt();
        read.nextLine();

        // Searching for books
        for (Book book : books) {
            if (book.getId() == id && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("You've Checked In: " + book.getTitle());
                return;
            }
        }
        // No book found
        System.out.println("Book not found");
    }
}
