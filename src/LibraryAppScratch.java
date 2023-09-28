import java.util.ArrayList;
import java.util.Scanner;

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

    public String getBookDetails(int index) {
        return String.format("\nBook #%d:\nBook ID - %d | Title - %s | Author - %s | Number of Pages - %d",
                index + 1, bookId, title, author, numberofPages);
    }
}

class Library {
    // Initialize an ArrayList, which is an Array which takes the dynamic size of
    // Lists
    private ArrayList<Book> library;

    // Constructor for Library class
    public Library(ArrayList<Book> library) {
        this.library = library;
    }

    Scanner scanner = new Scanner(System.in);

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void addBook() {
        int bookId = getIntInput("\nEnter the book ID: ");
        String title = getStringInput("Enter the title: ");
        String author = getStringInput("Enter the author: ");
        int numberOfPages = getIntInput("Enter the number of pages: ");

        Book book = new Book(bookId, title, author, numberOfPages);
        library.add(book);
    }

    public void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("\nLibrary is empty.");
        } else {
            for (int i = 0; i < library.size(); i++) {
                System.out.println(library.get(i).getBookDetails(i));
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
                    (library.get(i)).getBookDetails(i);
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

public class LibraryAppScratch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        Library library = new Library(bookList);

        System.out.println("Welcome to the CUD Library Management Software!");
        System.out.println("Please enter the number corresponding to the command:");

        try {
            while (true) {
                System.out.println(
                        "\n1 - Add Book | 2 - Display Books | 3 - Search Book | 4 - Remove Book | 0 - Terminate Program");
                int selection = library.getIntInput("Enter your choice: ");

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
                        System.out.println("\nProgram terminated.");
                        return;
                    default:
                        System.out.println("\nInvalid entry. Please try again.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
