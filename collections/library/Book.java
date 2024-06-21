class Book {
    int BookId;
    String title;
    String author;
    int availability;

    public Book(int BookId, String title, String author, int availability) {
        this.BookId = BookId;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    public String toString() {
        return "Book ID: " + BookId + ", Title: " + title + ", Author: " + author + ", Availability: " + availability;
    }
}
