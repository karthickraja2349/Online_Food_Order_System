import java.util.*;
public class DynamicArray{
   private int arr[];
   private final int initialcapacity = 8;
   private int capacity;
   private int size;
   
   public DynamicArray(){
      arr=new int[initialcapacity];
      size =0;
      capacity = initialcapacity;
  }
  
  public void add(int val){
     if(size == capacity)
       expandArray();
     arr[size++]=val;
  }
  
  private  void expandArray(){
     capacity*=2;
     arr=Arrays.copyOf(arr,capacity);
  }
  
  public void display(){
    System.out.println("The elements are");
    for(int i=0;i<size;i++){
       System.out.print( + arr[i] + " " );
    }
  }     
   
  public void insertAtIndex(int pos , int val){
     if(size==capacity){
        expandArray();
     }
     for(int i=size-1;i>=pos;i--){
        arr[i+1]=arr[i];
     }
     arr[pos]=val;
     size++;
  }
  
  public void deleteAtIndex(int pos){
     for(int i=pos+1;i<size;i++){
       arr[i-1]=arr[i];
     }
     size--;   
     
     if(capacity > initialcapacity && capacity >3*size){
       shrinkArray(); 
    }
  }
    private void shrinkArray(){
        capacity/=2;
        arr=Arrays.copyOf(arr,capacity);
    }   
    
    public void deleteAtEnd(){
      int pos=size-1;
       for(int i= pos+1;i<size;i++){
         arr[i-1]=arr[i];
       }
       size--;
   }  
   
   public void deleteAtBeginning(){
     int pos=0;
     for(int i=pos+1;i<size;i++){
       arr[i-1]=arr[i];
     }
     size--;
   }
   
   public void getIndex(int index){
     try{
      System.out.print(arr[index]);
     } 
     catch(ArrayIndexOutOfBoundsException e){
       System.out.println("please enter the correct value , your index is out of range");
     }    
   }
   
   public void update(int pos,int val){
     try{
       arr[pos]=val;
     }
     catch(Exception e){
       System.out.println("There is no such position in the list, if you need , you need to create explicitly");
     }       
   }
   
   public void search(int val){
    boolean found = false;
    for(int i = 0; i < size; i++){
        if(arr[i] == val){
            System.out.println("Yes, the element is present at index " + i);
            found = true;
            break; 
        }
    }
    if (!found) {
        System.out.println("No, the element is not present");
    }
 }
       
       
   public void clear(){
     size=0;
     for(int i=0;i<=size;i++){
        System.out.println(arr[i]);    
     }
   }                
} 
        
      

