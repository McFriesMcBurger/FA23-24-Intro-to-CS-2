import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Create a Book class with attributes and getters/setters
class Book {
    private int bookId;
    private String title;
    private String author;
    private int numberofPages;

    // Constructor for Book class
    public Book(int bookId, String title, String author, int numberOfPages) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.numberofPages = numberOfPages;
    }

    // Setter and Getter methods for each variable
    // Note: All Setter methods are not in use as there is no editing functionality
    // in the LibraryApp
    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberofPages() {
        return this.numberofPages;
    }

    public void setNumberofPages(int numberofPages) {
        this.numberofPages = numberofPages;
    }

    // Note: Additional method I added to print the details of each book
    public void printDetails(int index) {
        System.out.println("\nBook #" + (index + 1) + ":");
        System.out.print("Book ID - " + getBookId());
        System.out.print(" | Title - " + getTitle());
        System.out.print(" | Author - " + getAuthor());
        System.out.println(" | Number of Pages - " + getNumberofPages());
    }
}

// Create a Library class to manage books
class Library {
    // Initialize an ArrayList, which is an Array which takes the dynamic size of
    // Lists
    private ArrayList<Book> library;

    // Constructor for Library class
    public Library(ArrayList<Book> library) {
        this.library = library;
    }

    Scanner scanner = new Scanner(System.in);

    // Method to add a book to the library
    public void addBook() {
        // Initialize variables and prompt user to enter the amount of books to add
        try {
            System.out.print("\nEnter the number of books to add: ");

            int bookstoAdd = scanner.nextInt();
            int bookId;
            String title;
            String author;
            int numberofPages;

            // Iterates through the user's given integer to add that many books to the
            // Library ArrayList, with each book's details
            for (int i = 1; i <= bookstoAdd; i++) {
                try {
                    System.out.println("\nEnter details for Book #" + i + ":");

                    System.out.print("Book ID: ");
                    bookId = scanner.nextInt();

                    System.out.print("Title: ");
                    title = scanner.next();

                    System.out.print("Author: ");
                    author = scanner.next();

                    System.out.print("Number of Pages: ");
                    numberofPages = scanner.nextInt();
                    // This exception block has the added feature of repeating the iteration
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid entry. Please try again.");
                    scanner.nextLine();
                    i--;
                    continue;
                }

                // Create a Book object with user-provided details and add it to the ArrayList
                Book book = new Book(bookId, title, author, numberofPages);
                library.add(book);
            }
            // Catches an exception if the user inputs any variable type other than an
            // integer
            // This try-catch is present in multiple parts of the code
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid entry. Please try again.");
            scanner.nextLine(); // This line ensures that the input that caused the exception is removed
        }
    }

    // Method to display all books in the library
    public void displayBooks() {
        // Simply loops through the Library ArrayList and calls the printDetails method
        // per Book object
        if (!checkEmpty()) {
            for (int i = 0; i < library.size(); i++) {
                (library.get(i)).printDetails(i);
            }
        }
    }

    // Method to search for a book by title
    public void searchBook() {
        // Loops through the Library ArrayList and finds the first Book object with an
        // identical title, then prints its details and breaks the loop
        // LIMITATIONS: The title input by the user and the title of the book must be an
        // EXACT match; additionally, if there is more than one book with an identical
        // title, the first in order will be chosen
        if (!checkEmpty()) {
            System.out.print("\nEnter the title of the book: ");
            String title = scanner.next();

            boolean found = false;
            for (int i = 0; i < library.size(); i++) {
                if (title.equals((library.get(i)).getTitle())) {
                    System.out.println("\nMatch found!");
                    (library.get(i)).printDetails(i);
                    found = true;
                    break;
                }
            }

            // If there are no Book objects found with an identical title, the user is told
            // that a match is not found
            if (!found) {
                System.out.println("\nMatch not found.");
            }
        }

    }

    // Method to remove a book from the library by bookId
    public void removeBook() {
        // Loops through the Library ArrayList and finds the first Book object with an
        // identical ID, then removes it from the ArrayList and breaks the loop
        // LIMITATIONS: If there is more than one book with the same ID, only the book
        // that is first in order will be removed, though logically there should not be
        // more than one book with the same ID in practice anyway
        if (!checkEmpty()) {
            try {
                System.out.print("\nEnter the ID of the book: ");
                int bookId = scanner.nextInt();
                boolean found = false;
                for (int i = 0; i < library.size(); i++) {
                    if (bookId == (library.get(i)).getBookId()) {
                        System.out.println("\nBook " + (i + 1) + " with ID " + bookId + " has been removed.");
                        library.remove(i);
                        found = true;
                        break;
                    }
                }
                // If no Book object has a matching ID, the user is told that the book ID is not
                // found
                if (!found) {
                    System.out.println("\nBook ID not found.");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid entry. Please try again.");
                scanner.nextLine();
            }
        }
    }

    // Note: Additional method I added to check if the Library ArrayList contains
    // any elements before executing the methods above
    public boolean checkEmpty() {
        if (library.isEmpty()) {
            System.out.println("\nLibrary is empty.");
            return true;
        } else {
            return false;
        }
    }
}

// Create a LibraryApp class with the main method
public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);
        int selection;

        System.out.println("Welcome to the CUD Library Management Software!");
        System.out.println("Please enter the number corresponding to the command:");

        // Infinite while loop which can be terminated by the user that allows them to
        // perform multiple commands on the Library object
        // To select a command, the user must enter the corresponding number, and any
        // exceptions via incorrect inputs are handled
        try {
            while (true) {
                System.out.println(
                        "\n1 - Add Book | 2 - Display Books | 3 - Search Book | 4 - Remove Book | 0 - Terminate Program");

                // Check if the next input is an integer
                if (scanner.hasNextInt()) {
                    selection = scanner.nextInt();

                    switch (selection) {
                        case 1:
                            library.addBook();
                            break;
                        case 2:
                            library.displayBooks();
                            break;
                        case 3:
                            library.searchBook();
                            break;
                        case 4:
                            library.removeBook();
                            break;
                        case 0:
                            return; // Terminates the program
                        default:
                            System.out.println("\nInvalid entry. Please try again.");
                            scanner.nextLine(); // Consumes the invalid input
                            break;
                    }
                } else {
                    // Handles a non-integer input
                    System.out.println("\nInvalid entry. Please enter a valid integer.");
                    scanner.next(); // Consume the invalid input
                }
            }
        } finally {
            // Closes the scanner and displays a termination message
            System.out.print("\nProgram terminated.");
            scanner.close();
        }
    }
}
// Submission by Ralph Bernard P. Sengco - 20220001667
