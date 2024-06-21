import java.util.*;

 class Book {
    int bookId;
    String title;
    String author;
    int availability;

    public Book(int bookId, String title, String author, int availability) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Availability: " + availability;
    }
}

class Member {
    int memberId;
    String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

class Library {
    HashMap<Integer, Book> books;
    HashMap<Integer, Member> members;
    ArrayList<Transaction> transactions;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void addBook(int bookId, String title, String author, int availability) {
        Book book = new Book(bookId, title, author, availability);
        books.put(bookId, book);
    }

    public void addMember(int memberId, String name) {
        Member member = new Member(memberId, name);
        members.put(memberId, member);
    }

    public void borrowBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        if (book != null && book.availability > 0) {
            book.availability--;
            transactions.add(new Transaction(bookId, memberId, true));
            System.out.println("Book with ID " + bookId + " borrowed successfully by member with ID " + memberId);
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(int bookId) {
        Book book = books.get(bookId);
        if (book != null && book.availability < 10) {
            book.availability++;
            Transaction transaction = findTransaction(bookId);
            if (transaction != null) {
                transaction.borrowed = false;
                System.out.println("Book with ID " + bookId + " returned successfully.");
            }
        } else {
            System.out.println("Book not borrowed or not available.");
        }
    }

    public Transaction findTransaction(int bookId) {
        for (Transaction transaction : transactions) {
            if (transaction.bookId == bookId && transaction.borrowed) {
                return transaction;
            }
        }
        return null;
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.availability > 0) {
                System.out.println(book);
            }
        }
    }

    public void listBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Transaction transaction : transactions) {
            if (transaction.borrowed) {
                System.out.println("Book: " + books.get(transaction.bookId) + ", Borrower: " + members.get(transaction.memberId));
            }
        }
    }
}

class Transaction {
    int bookId;
    int memberId;
    Date date;
    boolean borrowed;

    public Transaction(int bookId, int memberId, boolean borrowed) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.date = new Date();
        this.borrowed = borrowed;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Member ID: " + memberId + ", Date: " + date + ", Borrowed: " + borrowed;
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(1, "Book 1", "Author 1", 10);
        library.addBook(2, "Book 2", "Author 2", 10);

        library.addMember(101, "Member 1");
        library.addMember(102, "Member 2");

        library.borrowBook(1, 101);
        library.borrowBook(2, 102);

        library.listAvailableBooks();
        library.listBorrowedBooks();
    }
}
