class Transaction {
    int BookId;
    int MemberId;
    Date date;
    boolean borrowed;

    public Transaction(int BookId, int MemberId, boolean borrowed) {
        this.BookId = BookId;
        this.MemberId = MemberId;
        this.date = new Date();
        this.borrowed = borrowed;
    }

    public String toString() {
        return "Book ID: " + BookId + ", Member ID: " + MemberId + ", Date: " + date + ", Borrowed: " + borrowed;
    }
}
