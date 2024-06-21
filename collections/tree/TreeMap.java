class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    Node<K, V> left;
    Node<K, V> right;
    
    public Node(K key, V value) {
       this.key = key;
       this.value = value;
       left = null;
       right = null;
    }
    
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class TreeMap<K extends Comparable<K>, V> {
    private Node<K, V> root;
  
    public TreeMap() {
        root = null;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> root, K key, V value) {
        if (root == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            root.value = value; // Update value if key already exists
        } 
        else if (cmp < 0) {
            root.left = put(root.left, key, value);
        }
        else {
            root.right = put(root.right, key, value);
        }

        return root;
    }

    public V get(K key) {
        Node<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node<K, V> get(Node<K, V> root, K key) {
        while (root != null) {
            int cmp = key.compareTo(root.key);
            if (cmp == 0) {
                return root;
            } else if (cmp < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = remove(root.left, key);
        } 
        else if (cmp > 0) {
            root.right = remove(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node<K, V> minNode = findMin(root.right);
            root.key = minNode.key;
            root.value = minNode.value;
            root.right = remove(root.right, minNode.key);
        }
        return root;
    }

    private Node<K, V> findMin(Node<K, V> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        display(root, sb);
        sb.append("}");
        return sb.toString();
    }
  
    private void display(Node<K, V> root, StringBuilder sb) {
      
        if (root != null) {
            display(root.left, sb);
            sb.append(root.key).append("=").append(root.value).append(" ");
            display(root.right, sb);
            
        }
        
    }

    
    public String toString() {
        return display();
    }
}      

