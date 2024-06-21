import java.util.*;

class HashNode<T> {
    T key;
    HashNode next;

    public HashNode(T key) {
        this.key = key;
    }
    public final int hashCode() {
            return Objects.hashCode(key) ^ 32%49;
        }
}

public class HashSet<T>{
    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    public HashSet() {
        this(10);
    }

    public HashSet(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(T key) {
      if(key ==null){
         return 0;
       } 
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % numOfBuckets;
        return index;
    }

    public void add(T key) {
      
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode newNode = new HashNode(key);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
    }

    public boolean contains(T key) {
      
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (Objects.equals(head.key,key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    
  


    public boolean remove(T key) {
      
      
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while (head != null) {
            if (Objects.equals(head.key,key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null) {
            return false;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;
        } 
        else {
            buckets[bucketIndex] = head.next;
        }
        return true;
    }
    
   


    

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (HashNode bucket : buckets) {
            HashNode head = bucket;
            
            while (head != null) {
                
                sb.append(head.key).append(" ");
                head = head.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public void clear() {
    size = 0;
    Arrays.fill(buckets, null);
  }
  
  
  public HashSet<T> clone() {
    HashSet<T> clonedSet = new HashSet<>(numOfBuckets);
    for (int i = 0; i < numOfBuckets; i++) {
        HashNode<T> head = buckets[i];
        while (head != null) {
            if (head.key != null) {
                clonedSet.add(head.key); // Add only if the key is not null
            }
            head = head.next;
        }
    }
    return clonedSet;
}

 }
 


