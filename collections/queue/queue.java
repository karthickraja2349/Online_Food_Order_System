class Node{
   int data;
   Node next;
   
   public Node(int val){
      data = val;
      next = null;
   }
   
}      
public class queue{

   Node front;
   Node rear;
   
   public queue(){
      front = null;
      rear = null;
   }
   
   public void enQueue(int val){
      Node newNode = new Node(val); 
      if(front == null)
         front = newNode;
      else   
        rear.next = newNode;
      rear = newNode;
       
   }
   
   public int deQueue(){
       if(front==null){
         System.out.println("Queue is Empty");
         return -1;
       }  
       int temp = front.data;
       front = front.next;
       if(front == null)
          rear = null;
       return temp;  
   }
   public int peak(){
      if(front == null){
         System.out.println("queue is empty");
         return -1;
      }
      return front.data;
   }
   
   public boolean isEmpty(){
      return front == null;
   }
   
}
