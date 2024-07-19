//library managemnet system  not completed...


import java.util.Scanner;

// Custom exception if book not available
class BookNotAvailable extends Exception {
    BookNotAvailable(String exceptionMessage) {
        super(exceptionMessage);
    }
}

class Library {
    // Array to store books in the library
    public Book[] booksArr;
    public int size;
    public int capacity;

    // Constructor to initialize the library with a given capacity
    public Library(int capacity) {
        this.booksArr = new Book[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    // Method to add a book to the library
    public void addBook(Book bookToAdd) {
        if (size < capacity) {
            booksArr[size] = bookToAdd;
            size++;
        } else {
            System.out.println(":::Reached the Add limitation So:::");
        }
    }

    // Method to borrow a book from the library
    public void borrowBook(Book bookToRemove, User userVar) throws BookNotAvailable {
        boolean bookFound = false;
        String userName = userVar.getName();

        if (userVar.getBorrowCount() >= 2) {
            System.out.println("Borrow limit reached for user: " + userName);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (booksArr[i].equals(bookToRemove)) {
                if (!booksArr[i].isAvailable()) {
                    throw new BookNotAvailable("Book not available to borrow");
                } else {
                    System.out.println("Borrow Success");
                    booksArr[i].displayBook();
                    booksArr[i].setAvailability(false);
                    userVar.borrowBook(booksArr[i]);
                    // Shift books in the array to fill the gap
                    for (int j = i; j < size - 1; j++) {
                        booksArr[j] = booksArr[j + 1];
                    }
                    booksArr[size - 1] = null;
                    size--;
                }
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            throw new BookNotAvailable("Book not Found");
        }
    }

    // Method to return a book to the library
    public void returnBook(User user, String bookTitle) {
        for (int i = 0; i < size; i++) {
            if (booksArr[i].getTitle().equals(bookTitle)) {
                if (booksArr[i].isAvailable()) {
                    System.out.println("Book already returned: " + bookTitle);
                } else {
                    booksArr[i].setAvailability(true);
                    System.out.println(user.getName() + " returned the book: " + bookTitle);
                }
                return;
            }
        }
        System.out.println("ERROR!! Book Not Registered: " + bookTitle);
    }

    // Method to display all books in the library
    public void displayBooks() {
        System.out.println(":::Inside library::");
        for (Book bookVar : booksArr) {
            if (bookVar != null) {
                bookVar.displayBook();
            }
        }
    }
}

class Book {
    String title;
    String author;
    public boolean available = true;

    // Constructor to initialize a book with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Method to set the availability of the book
    public void setAvailability(boolean available) {
        this.available = available;
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("Book title = " + title + " , author = " + author);
    }
}

class User {
    String name;
    int id;
    int borrowCount = 0;
    Book[] borrowedArr = new Book[2]; // Array to store borrowed books

    // Constructor to initialize a user with name and id
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Method to display user details
    public void displayUsernameId() {
        System.out.println("userName = " + name + " id = " + id);
    }

    // Method to get the number of books borrowed by the user
    public int getBorrowCount() {
        return borrowCount;
    }

    // Method to borrow a book
    public void borrowBook(Book bookVar) {
        if (borrowCount < 2) {
            borrowedArr[borrowCount] = bookVar;
            borrowCount++;
        } else {
            System.out.println("Borrow limit reached for user: " + name);
        }
    }

    // Method to return a book
    public void returnBook(String bookTitle) {
        for (int i = 0; i < borrowCount; i++) {
            if (borrowedArr[i].getTitle().equals(bookTitle)) {
                borrowedArr[i].setAvailability(true); // Mark the book as available
                System.out.println(name + " returned the book: " + bookTitle);
                // Shift remaining books in the borrowed array
                for (int j = i; j < borrowCount - 1; j++) {
                    borrowedArr[j] = borrowedArr[j + 1];
                }
                borrowedArr[borrowCount - 1] = null; // Set the last element to null
                borrowCount--; // Decrement borrow count
                return;
            }
        }
        // If the book to return is not found in the borrowed books array
        System.out.println("ERROR!! Book Not Registered: " + bookTitle);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library libObject = new Library(5);

        // Creating some books
        Book math = new Book("math", "PeterMathing");
        Book java = new Book("java", "robert");
        Book stats = new Book("stats", "robert");
        Book dsa = new Book("dsa", "robert");
        Book english = new Book("english", "robert");

        // Adding books to the library
        libObject.addBook(math);
        libObject.addBook(java);
        libObject.addBook(stats);
        libObject.addBook(dsa);
        libObject.addBook(english);

        // Creating a user
        User user1 = new User("Basanta", 12);

        // Borrowing books
        try {
            libObject.borrowBook(math, user1);
            libObject.borrowBook(java, user1);
            libObject.borrowBook(stats, user1);
        } catch (BookNotAvailable e) {
            System.out.println(e);
        }

        // Displaying borrowed books for the user
        System.out.println("Borrowed books for " + user1.getName() + ":");
        for (int i = 0; i < user1.getBorrowCount(); i++) {
            user1.borrowedArr[i].displayBook();
        }

        // Displaying all books in the library
        libObject.displayBooks();
    }
}
