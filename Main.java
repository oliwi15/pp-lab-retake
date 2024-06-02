import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager;

    static {
        List<Book> initialBooks = new ArrayList<>();
        initialBooks.add(new Book("Book 1", "Author 1", "ISBN1", 2006));
        initialBooks.add(new Book("Book 2", "Author 2", "ISBN2", 2018));
        initialBooks.add(new Book("Book 3", "Author 3", "ISBN3", 2025));
        initialBooks.add(new Book("Book 4", "Author 4", "ISBN4", 2010));
        initialBooks.add(new Book("Book 5", "Author 5", "ISBN5", 2005));
        bookManager = new BookManager(initialBooks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Add book");
            System.out.println("[2] Remove book");
            System.out.println("[3] Update book");
            System.out.println("[4] List books");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookManager.removeBook(book);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new year: ");
        int newYear = scanner.nextInt();
        scanner.nextLine();

        Book updatedBook = new Book(newTitle, newAuthor, isbn, newYear);
        bookManager.updateBook(isbn, updatedBook);
        System.out.println("Book updated successfully.");
    }

    private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
