import java.util.*;
public class stack {
   private int s[] ;
   private final int initialCapacity =8;
   private int tos;
   private  int capacity ;
   
   public stack(){
      tos=-1;
      s=new int[initialCapacity];
      capacity = initialCapacity;
   }
      
   public void push(int element){
      if(capacity == initialCapacity){
          expandStack();
      }    
      s[++tos]=element;  
   }   
      
    private void expandStack(){
       capacity *=2;
       s=Arrays.copyOf(s,capacity);   
    }   
    
    
    public int pop(){
      if(tos>=0){
        return s[tos--];
     }   
      else{
        System.out.println("Stack is empty");
        return -1;
      }    
    }
    
    public int size(){
      return capacity;
   }   
    public boolean isEmpty(){
        return tos==-1;  
        
    }    
    
    public int peek(){
       return s[tos];
    }
    
    public void Search(int element){
       int count=-1;
       for(int i=0;i<s.length;i++){
          if(s[i]==element){
            count =i;
          }
       }
       System.out.println(count);
     }       
    public void printStack() {
        if (tos == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= tos; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
             
      
 } 
