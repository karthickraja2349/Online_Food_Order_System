public class LinkedDemo{
   public static void main(String[]args){
      LinkedList l = new LinkedList();
      l.insertAtBeginning(0);
      l.insertAtBeginning(1);
      l.insertAtBeginning(2);
      l.insertAtBeginning(3);
      l.insertAtBeginning(4);
      l.insertAtBeginning(null);
      
      l.display();
      
      l.insertAtPos(2,98);
      l.insertAtPos(3,87);
      
      System.out.println();
      l.display();
      
      l.deleteAtBeginning();
      l.deleteAtBeginning();
      
      System.out.println();
      l.display();
      
      
      l.deleteAtPos(3);
      l.deleteAtPos(1);
      
      System.out.println();
      l.display();
      
      l.deleteAtEnd();
     
      System.out.println();
      l.display();
      
      l.add(4);
      l.add(78);
      l.add(566666);
      l.add(566666);
      l.add(76);
      l.add(34);
      l.add(null);
      l.add(null);
      System.out.println();
      l.display();
      
      
      System.out.println("\n" +l.search(78));
      System.out.println(l.search(1234));
      
      l.update(1,123456);
      
     System.out.println();
     l.display();
     
     
     l.removeVal(78);
     System.out.println();
     l.display();
     
     l.removeVal(4);
     System.out.println();
     l.display();
     
     l.deleteAtPos(1);
     System.out.println();
     l.display();
     
     l.removeVal(566666);
     System.out.println();
     l.display();
     
     
     
     
     
      
   }
}    
