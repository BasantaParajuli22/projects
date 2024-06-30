//library management system 
//custom exception if book not available
import java.util.Scanner;
class bookNotAvailable extends Exception{
    bookNotAvailable(String exceptionMessage){
        super(exceptionMessage);
    }
}


class Library{
    // library ma list of books hunxa
    public Book[] booksArr;
    public int size;  
    public int capacity;

    public Library(int capacity) {
        this.booksArr = new Book[capacity];
        this.size = 0;
        this.capacity = capacity;
        }
        //returns capacity
    public int capacity(){
       return capacity;
    }
     public void DisplayCapacity(){
       System.out.println("Total space = "+ capacity);
    }

    public void addBook(Book bookToAdd){
        if(size < capacity){
            booksArr[size] = bookToAdd;
            size++;
        }else{
            System.out.println(":::Reached the Add limitation So:::");
        }
    }
    

   public void borrowBook(Book bookToRemove, User userVar) throws bookNotAvailable {
    boolean bookFound = false;
    String userName = userVar.getName();

    if (userVar.getBorrowCount() >= 2) {
        System.out.println("Borrow limit reached for user: " + userName);
        return;
    }
    for (int i = 0; i < size; i++) {
        if (booksArr[i].equals(bookToRemove)) {
            if (!booksArr[i].isAvailable()) {
                throw new bookNotAvailable("Book not available to borrow");
            } else {
                System.out.println("Borrow Success");
                booksArr[i].displayBook();
                booksArr[i].setAvailabilty(false);
                userVar.borrowBook(booksArr[i]);
            }
            bookFound = true;
            break;
        }
    }

    if (!bookFound) {
        throw new bookNotAvailable("Book not Found");
    }
}

public void returnBook(User user, String bookTitle) {
    boolean bookFound = false;
    for (int i = 0; i < user.borrowCount; i++) {
        if (user.borrowedArr[i].getTitle().equals(bookTitle)) {
            user.borrowedArr[i].setAvailabilty(true);
            System.out.println(user.getName() + " returned the book: " + bookTitle);
            // Shift the remaining books in the borrowed array
            for (int j = i; j < user.borrowCount - 1; j++) {
                user.borrowedArr[j] = user.borrowedArr[j + 1];
            }
            user.borrowedArr[user.borrowCount - 1] = null;
            user.borrowCount--;
            bookFound = true;
            break;
        }
    }

    if (!bookFound) {
        System.out.println("ERROR!! Book Not Registered: " + bookTitle);
    }
}


    public void displayBooks(){
        System.out.println(":::Inside library::");
        for(Book bookVar: booksArr){
            if(bookVar!= null){
                bookVar.displayBook();
            }
        }
    }
}
class Book{
    String title;
    String author;
    public boolean available = true;
    
    public Book(String title, String author ){
        this.title = title;
        this.author = author;
       
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }   
    public boolean isAvailable(){
        return available;
    }

    
    
    //methods
    public void setAvailabilty(boolean available){
        this.available = available;
    }
    public void displayBook(){
         System.out.println( "book title = " + title +" , author = "+ author);
    } 

}


class User{
    String name;
    int id;
    int borrowCount = 0;
    //assuming the user borrow limit of 2
     Book[] borrowedArr = new Book[2];

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    void displayUsernameId(){
        System.out.println( "userName = "+ name +" id = "+id );
    }

    public int getBorrowCount(){    
        return borrowCount;
    }
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
                borrowedArr[i].setAvailabilty(true); // Mark the book as available
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
public class LibrarySystem{
    public static void main(String[] args){

        Library libObject = new Library(5);
      
        Book math = new Book("math","PeterMathing");
        Book java = new Book("java","robert");
        Book stats = new Book("stats","robert");
        Book dsa = new Book("dsa","robert");
        Book english = new Book("english","robert");
        
        //hlobook is not added to library so if u try to access it throws an exception
        // Book hlobook = new Book("science", "Author");

        // adding to library
        libObject.addBook(math);
        libObject.addBook(java);
        libObject.addBook(stats);
        libObject.addBook(dsa);
        libObject.addBook(english);


        User user1 = new User("Basanta",12); 

        
        // user1.displayUsernameId();

        //borrowing 3 books from same useer
        try{
            libObject.borrowBook(math,user1);
            // libObject.borrowBook(java,user1);
            //   libObject.borrowBook(stats,user1);
        }catch(bookNotAvailable eg){
           System.out.println(eg);
        }

        try{
            //libObject.borrowBook(math,user1);
             libObject.borrowBook(java,user1);
            //   libObject.borrowBook(stats,user1);
        }catch(bookNotAvailable eg){
           System.out.println(eg);
        }

        try{
            //libObject.borrowBook(math,user1);
             //libObject.borrowBook(java,user1);
               libObject.borrowBook(stats,user1);
        }catch(bookNotAvailable eg){
           System.out.println(eg);
        }

        // // adding more books than array makes 
        // Book book3 = new Book("javajptsd","robert");
        // libObject.addBook(book3);

        libObject.displayBooks();

        // libObject.DisplayCapacity();

    }
}

