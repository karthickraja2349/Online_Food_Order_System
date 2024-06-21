class Node<T>{
    T value ;
    Node next;
    
    public Node(T value){
       this.value = value ;
       next = null;
    }
    
}

public class Deque<T>{
   Node head;
   Node tail;
   
   int size;
   
   
   public boolean add(T val){
      Node newNode = new Node(val);
      if(head == null){
         head = newNode;
         tail=newNode;
         size ++;
         return true;
     }
     else if(head!=null){
       Node temp = head;
       while(temp.next!=null){
          temp=temp.next;
       }
       temp.next = newNode;
       size++;
       return true;
     }
     else{
       return false;
     }
   }
   
   public void addFirst(T val){
      Node newNode = new Node(val);
      if(head==null){
         head= newNode;
         tail = newNode;
         size++;
         return;
      }
      else{
        size++;
        newNode.next = head;
        head = newNode;
     }
   }
   
   public T getFirst(){
      return (T)head.value;  
   }
   
   public T getLast(){
     Node temp = head;
     while(temp.next!=null){
       temp = temp.next;
     }
     return (T)temp.value;
  }
  
  public T pollFirst(){
     T tem =(T)head.value;
     size--;
     head = head.next;
     return tem;
  }
  
  public T pollLast(){
   Node temp = head;
   Node previous = null;
   while(temp.next !=null){
     previous = temp;
     temp = temp.next;
   }
   T tem =(T)temp.value;
   previous.next = null;
   size--;
   return tem;
  }
  
      
  
     
  public String toString(){
    Node temp = head;
    while(temp!=null){
      System.out.println(temp.value + " " );
      temp=temp.next;
    }  
     return " ";
   
 }

}
     
        
                         
        
                   
