import java.util.*;

class HashNode<T>{
    T key;
    HashNode<T> next;
    
    public HashNode(T val){
       key =val;
       next = null;
    }
    
}
class Node<T>{
     T data ;
     Node<T> next;
     
     public Node(T val){
        data = val;
        next = null;
     }
}        

public class LinkedHashSet<T>{
   private HashNode[] buckets;
   private int numOfBuckets;
   private int size;
   private int head;
   
   public LinkedHashSet(){
      this(10);
   }
   
   public LinkedHashSet(int capacity){
      numOfBuckets = capacity;
      buckets =new HashNode[capacity];
      size =0;
      head = null;
   }
   
   public int size(){
      return size;
   }
   
   public boolean isEmpty(){
      return size ==0;
   }
   
   public int getBucketIndex(T key){
       if(key==null){
          return 0;
       }
       int hashCode = key.hashCode();
       int index = Math.abs(hashCode) % numOfBuckets;
       return index;
   }        
   
   public void add(T key){
      int bucketIndex = getBucketIndex(key);
      HashNode head = buckets[bucketIndex];
      while(head!=null){
         if(Objects.equals(head.key,key)){
            return;
         }
         head = head.next;
     }
     size++;
     head=buckets[bucketIndex];
     HashNode newNode = new HashNode(key);
     newNode.next = head;
     buckets[bucketIndex]=newNode;
     
     //linked list
     
     if(this.head==null){
       this.head = new Node(key);
     }
     else{
       Node<T>temp = head;
       while(temp.next!=null){
          temp = temp.next;
       }
       temp.next =  new Node(key); 
     }      
   }
   
   public boolean containsKey(T key){
              
      int bucketIndex = getBucketIndex(key);
      HashNode head = buckets[bucketIndex];
      while(head!=null){
         if(Objects.equals(head.key,key)){
           return true;
         }
         head = head.next;
      }
      return false;
   }
   
   public boolean containsValue(T value){
       for(HashNode bucket : buckets){
          HashNode head = bucket;
          while(head!=null){
             if(Objects.equals(head.value,value)){
                 return true;
             }
             head = head.next;
          }
       } 
       return false;
   }             
   

   
   public T remove(T key){
      
      int bucketIndex = getBucketIndex(key);
      HashNode<T> head = buckets[bucketIndex];
      HashNode<T> previous = null;
      while(head!=null){
          if(Objects.equals(head.key,key)){
             break;
          }
          previous = head;
          head = head.next;
     }
     if(head == null){
       return null;
     }
     size--;
     if(previous!=null){
        previous.next = head.next;
     }
     else{
       bucket[bucketIndex]=head.next;
     }
     
     //linked list
     Node temp = this.head;
     Node prev = null;
     while(temp!=null){
        if(Objects.key.equals(key)){
            if(prev!=null){
               prev.next = temp.next;
             }
             else{
               this.head = temp.next;
             }  
             break;
        }
        prev = temp;
        temp=temp.next;
     }
     return head.value;
  }     
               
        
         
     
  }
  
  public void clear(){
     size=0;
     Arrays.fill(buckets,null);
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(HashNode bucket : buckets){
      HashNode<T> head = bucket;
      while(head!=null){
        sb.append(head.key).append(" ");
        head = head .next;
       }
    }
    sb.append("]");
    return sb.toString();
   }
   
   public LinkedHashSet clone(){
      LinkedHashSet cloneSet = new LinkedHashSet();
      for(int i=0;i<numOfBuckets;i++){
        HashNode head = buckets[i];
        while(head!=null){
          if(head.key!=null){
             cloneSet.add(head.key);
           }
           head=head.next;
        }
     }
    return cloneSet;
  }
}             
            
  
               
               
             
               
                        

