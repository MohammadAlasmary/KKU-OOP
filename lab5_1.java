import java.util.*;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private String[] genres;
    private List<Book> allBooks;
    private Set<Integer> issuedBookIds;
    private Map<Integer, Book> bookMap;

    public Library(String[] genres) {
        this.genres = genres;
        this.allBooks = new ArrayList<>();
        this.issuedBookIds = new HashSet<>();
        this.bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        if (!bookMap.containsKey(book.getBookId())) {
            allBooks.add(book);
            bookMap.put(book.getBookId(), book);
            System.out.println("Book with ID " + book.getBookId() + " added successfully.");
        } else {
            System.out.println("Book with ID " + book.getBookId() + " already exists.");
        }
    }

    public void issueBook(int bookId) {
        if (bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            if (book.isAvailable() && !issuedBookIds.contains(bookId)) {
                book.setAvailable(false);
                issuedBookIds.add(bookId);
                System.out.println("Book with ID " + bookId + " (" + book.getTitle() + ") issued successfully.");
            } else if (!book.isAvailable()) {
                System.out.println("Book with ID " + bookId + " (" + book.getTitle() + ") is currently unavailable.");
            } else {
                System.out.println("Book with ID " + bookId + " is already issued.");
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found in the library.");
        }
    }

    public void returnBook(int bookId) {
        if (bookMap.containsKey(bookId)) {
            Book book = bookMap.get(bookId);
            if (issuedBookIds.contains(bookId)) {
                book.setAvailable(true);
                issuedBookIds.remove(bookId);
                System.out.println("Book with ID " + bookId + " (" + book.getTitle() + ") returned successfully.");
            } else if (book.isAvailable()) {
                System.out.println("Book with ID " + bookId + " (" + book.getTitle() + ") was not issued from this system.");
            } else {
                System.out.println("Book with ID " + bookId + " (" + book.getTitle() + ") is already marked as available.");
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found in the library.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        if (allBooks.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        boolean found = false;
        for (Book book : allBooks) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books currently available.");
        }
    }

    public void displayGenres() {
        System.out.println("\n--- Available Genres ---");
        if (genres.length == 0) {
            System.out.println("No genres defined.");
        } else {
            for (String genre : genres) {
                System.out.println("- " + genre);
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        String[] genres = {"Fiction", "Science", "History", "Mystery"};
        Library library = new Library(genres);

        library.addBook(new Book(101, "The Lord of the Rings", "J.R.R. Tolkien"));
        library.addBook(new Book(102, "Cosmos", "Carl Sagan"));
        library.addBook(new Book(103, "Sapiens", "Yuval Noah Harari"));
        library.addBook(101, "The Hobbit", "J.R.R. Tolkien");

        library.displayAvailableBooks();

        library.issueBook(101);
        library.issueBook(103);
        library.issueBook(103);
        library.issueBook(104);

        library.displayAvailableBooks();

        library.returnBook(101);
        library.returnBook(101);
        library.returnBook(102);
        library.returnBook(105);

        library.displayAvailableBooks();

        library.displayGenres();
    }
}
