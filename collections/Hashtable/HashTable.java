import java.util.*;
class HashNode<T>{
    T key;
    T value;
    HashNode next;

    
    public HashNode(T key, T value){
       this.key = key;
       this.value=value;
    }
 }
   
public class HashTable<T>{
     private HashNode[]buckets;
     private int numOfBuckets;
     private int size;
     
     public HashTable(){
       this(10);
     }  
     
     public HashTable(int capacity){
       this.numOfBuckets = capacity;
       buckets = new HashNode[capacity];
     }
     
     
     public int size(){
        return size;
     }
     
     public boolean isEmpty(){
       if(size ==0)
         return true;
      return false;
    }
    
  private int getBucketIndex(T key) {
    if (key == null)
        return 0;
    int hashCode = key.hashCode();
    int index = Math.abs(hashCode) % numOfBuckets;
    return index;
}
    
    public void put(T key, T value) {
    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];
    while (head != null) {
        if (Objects.equals(head.key, key)) {
            head.value = value;
            return;
        }
        head = head.next;
    }
    size++;
    HashNode newNode = new HashNode(key, value);
    newNode.next = buckets[bucketIndex];
    buckets[bucketIndex] = newNode;
}    
    
   public String get(T key){
       
    
      int bucketIndex = getBucketIndex(key);
      HashNode head = buckets[bucketIndex];
      while(head!=null){
         if(head.key.equals(key)){
           return (String)head.value;
         }
         head = head.next;
      }
      return null;
   }
   
   
   public String remove(T key){ 
     
     
      int bucketIndex = getBucketIndex(key);
      HashNode head = buckets[bucketIndex];
      HashNode previous = null;
      while(head!=null){
         if(Objects.equals(head.key,key)){
           break;
         }
         previous = head;
         head = head.next;
      }
      if(head==null){
        return null;
      }
      size--;
      if(previous!=null){
         previous.next = head.next;
       }  
      else{
        buckets[bucketIndex]=head.next;
      }           
      return (String)head.value;        
   }
   
   
    public List keySet() {
        List keys = new ArrayList();
        for (HashNode bucket : buckets) {
            HashNode head = bucket;
            while (head != null) {
                keys.add(head.key);
                head = head.next;
            }
        }
        return keys;
    }
    
    public List values(){
       List val = new ArrayList();                            
       for(HashNode bucket : buckets){
         HashNode head = bucket;
         while(head!=null){
           val.add(head.value);
           head = head.next;
         }
      }
      return val;
   }        
   
   public boolean containsKey(T key){
      int bucketIndex = getBucketIndex(key);
      HashNode<T> head = buckets[bucketIndex];
     
      while(head!=null){
         if(Objects.equals(head.key,key)){
              return true;
         }
         head =head.next;
     }
     return false;
   }  
   
 public boolean containsValue(T value) {
    for (HashNode bucket : buckets) {
        HashNode head = bucket;
        while (head != null) {
            if (Objects.equals(head.value,value)) {
                return true;
            }
            head = head.next;
        }
    }
    return false;
}
         
              
   
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for (HashNode bucket : buckets) {
        HashNode head = bucket;
        while (head != null) {
            sb.append(head.key).append("=").append(head.value).append(" ");
            head = head.next;
            
        }
    }
    sb.append("}");
    return sb.toString();
 }
 
 public void clear(){
    size =0;
    Arrays.fill(buckets,null);
 }   
 
 public void replace(T key,T value){
   
    int bucketIndex = getBucketIndex(key);
    HashNode head = buckets[bucketIndex];
    while(head!=null){
       if(Objects.equals(head.key,key)){
          head.value = value;
          return ;
        }
        head=head.next;
     }
     
     
   }
   
   
       
}

              
              
