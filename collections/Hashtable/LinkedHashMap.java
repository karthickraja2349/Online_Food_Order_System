import java.util.*;
class HashNode<T> {
    T key;
    T value;
    HashNode<T> next;

    public HashNode(T key, T value) {
        this.key = key;
        this.value = value;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T val) {
        data = val;
        next = null;
    }
}

public class LinkedHashMap<T> {
    private HashNode<T>[] buckets;
    private int noOfBuckets;
    private int size;
    private Node<T> head;

    public LinkedHashMap(int capacity) {
        noOfBuckets = capacity;
        buckets = new HashNode[capacity];
        size = 0;
        head = null;
    }

    public LinkedHashMap() {
        this(10);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(T key) {
        if (key == null)
            return 0;
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % noOfBuckets;
        return index;
    }

    public void put(T key, T value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<T> head = buckets[bucketIndex];
        while (head != null) {
            if (Objects.equals(head.key,key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode<T> newNode = new HashNode<>(key, value);
        newNode.next = head;
        buckets[bucketIndex] = newNode;

        // Linked list to maintain insertion order
        if (this.head == null) {
            this.head = new Node<>(key);
        } 
        else {
            Node<T> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(key);
        }
    }

    public List<T> keySet() {
        List<T> keys = new ArrayList<>();
        Node<T> temp = head;
        while (temp != null) {
            keys.add(temp.data);
            temp = temp.next;
        }
        return keys;
    }

    public T get(T key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<T> head = buckets[bucketIndex];
        while (head != null) {
            if (Objects.equals(head.key,key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public T remove(T key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<T> head = buckets[bucketIndex];
        HashNode<T> previous = null;
        while (head != null) {
            if (Objects.equals(head.key,key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;
        } 
        else {
            buckets[bucketIndex] = head.next;
        }

        // Remove from linked list to maintain insertion order
        Node<T> temp = this.head;
        Node<T> prev = null;
        while (temp != null) {
            if (temp.data.equals(key)) {
                if (prev != null) {
                    prev.next = temp.next;
                } 
                else {
                    this.head = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head.value;
    }

    public List<T> values() {
        List<T> val = new ArrayList<>();
        for (Node<T> node = head; node != null; node = node.next) {
            int bucketIndex = getBucketIndex(node.data);
            HashNode<T> hashNode = buckets[bucketIndex];
            while (hashNode != null) {
                if (Objects.equals(hashNode.key,node.data)) {
                    val.add(hashNode.value);
                    break;
                }
                hashNode = hashNode.next;
            }
        }
        return val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Node<T> temp = head;
        while (temp != null) {
            int bucketIndex = getBucketIndex(temp.data);
            HashNode<T> hashNode = buckets[bucketIndex];
            while (hashNode != null) {
                if (Objects.equals(hashNode.key,temp.data)) {
                    sb.append(hashNode.key).append("=").append(hashNode.value).append(" ");
                    break;
                }
                hashNode = hashNode.next;
            }
            temp = temp.next;
        }
        sb.append("}");
        return sb.toString();
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

    public void clear(){
        size = 0;
        Arrays.fill(buckets, null);
        head = null;
    }

    public void replace(T key, T value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<T> head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
    }
}

