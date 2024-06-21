import java.util.*;

class Library {
    HashMap<Integer, Book> books;
    HashMap<Integer, Member> members;
    List<Transaction> transactions;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void addBook(int bookId, String title, String author, int availability) {
        Book book = new Book(bookId, title, author, availability);
        books.put(bookId, book);
    }

    public void addMember(int MemberId, String MemberName) {
        Member member = new Member(MemberId, MemberName);
        members.put(MemberId, member);
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.availability > 0) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(int BookId, int MemberId) {
        Book book = books.get(BookId);
        if (book != null && book.availability > 0) {
            book.availability--;
            transactions.add(new Transaction(BookId, MemberId, true));
            System.out.println("Book with ID " + BookId + " borrowed successfully by member with ID " + MemberId);
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(int BookId) {
        Book book = books.get(BookId);
        if (book != null && book.availability < 10) {
            book.availability++;
            Transaction transaction = findTransaction(BookId);
            if (transaction != null) {
                transaction.borrowed = false;
                System.out.println("Book with ID " + BookId + " returned successfully.");
            }
        } else {
            System.out.println("Book not borrowed or not available.");
        }
    }

    public Transaction findTransaction(int BookId) {
        for (Transaction transaction : transactions) {
            if (transaction.BookId == BookId && transaction.borrowed) {
                return transaction;
            }
        }
        return null;
    }
}






