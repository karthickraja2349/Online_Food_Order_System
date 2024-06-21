import java.util.*;
public class Book{
      int bookId;
      String author_name;
      String title;
      int availability;
      
      HashMap<Integer, Book> booklist;
      public Book(int bookId,String author_name,String title,int availability){
          this.bookId = bookId;
          this.author_name=author_name;
          this.title = title;
          this.availability = availability;
     }
     
     
     public Book(){
     }
     
     public String toString(){
        return "Book id is " + bookId+ " "  + "Author name is "+author_name+" " + "Title is" + " " +title+" " + "Availablity is " +availability + "\n";
     }   
     
     public void books(){
     
         Book book1 = new Book(101,"Manikandan","wake up",10);
         Book book2 = new Book(102,"Aryan","nothing but well",10);
         Book book3 = new Book(103,"karthick","anything happens at anytime",10);
         
         booklist = new HashMap();
     
     //booklist.put(1,books);
        booklist.put(book1.bookId,book1);
        booklist.put(book2.bookId,book2);
        booklist.put(book3.bookId,book3);
     
        //System.out.println(booklist);
     
   }      
   
   public void display(){
        System.out.println(booklist);
   }
   
   public void borrow(int bookId) {
        Book book = booklist.get(bookId);
        if (book != null && book.availability > 0) {
            book.availability--;
             System.out.println(booklist);
            System.out.println("Book borrowed successfully");
        } 
        else {
       
            System.out.println("Book not available ");
        }
    }
        
      
}  


//import java.util.*;
       
     
          
