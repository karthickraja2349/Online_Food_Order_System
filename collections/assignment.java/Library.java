import java.util.*;
class Library extends Members{
   
   
 public static void main(String[]args){
    Library lib = new Library();
    Scanner input = new Scanner(System.in);
    
     lib.books();
    while(true){
       System.out.println("\n -------- List Menu -----------\n");
       System.out.println("1.Available Books");
       System.out.println("2.Member list");
       System.out.println("3.Borrow ");
       System.out.println("4.Exit");
       
       System.out.println("----------");
       System.out.println("Enter your choice");
       int choice = input.nextInt();
       switch(choice){
         case 1:
            System.out.println("The available books are");
           
            lib.display();
            break;
         case 2:
            System.out.println("The Subscribed members are");
            lib.members();
            break;
         case 3:
              System.out.println("Enter the book id do you want");  
              int id = input.nextInt();
              
              lib.borrow(id);
              break;
         case 4:
           System.out.println("Thanks for your learning");
            System.exit(0);   
        }
    }             
       
     
     /*lib.books();
     lib.members();*/
   
      
   }
    
    
  
    
   
    
} 
