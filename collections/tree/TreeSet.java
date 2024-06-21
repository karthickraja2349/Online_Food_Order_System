 class Node{
    Integer key;
    Node left;
    Node right;
    
    public Node(int val){
       key = val;
       left = null;
       right = null;
    }
    public String toString() {
        return String.valueOf(key);
    }
}

public class TreeSet{
   Node root;
   
   public TreeSet(int val){
      root =new Node(val);
   }
   
   
   public TreeSet(){
      root = null;
   }
   
  public Node add(Node root, int val) {
    if (root == null) {
        return new Node(val);
    }
    
    Node current = root;
    Node parent = null;
    
    while (current != null) {
        if (val == current.key) {
           
            return root;
        } 
        else if (val < current.key) {
            parent = current;
            current = current.left;
        } 
        else {
            parent = current;
            current = current.right;
        }
    }
    
    
    Node newNode = new Node(val);
    if (val < parent.key) {
        parent.left = newNode;
    } 
    else {
        parent.right = newNode;
    }
    
    return root;
  }
  
   
   public void add(int val){
       add(root,val);
   }
   
   private String display(Node root){
      if(root!=null){
         display(root.left);
         System.out.print(root.key + " ");
         display(root.right);
      }
      return " ";
   }
    
   public String toString(){
      return display(root);
   }
   
  
  public boolean search(int val){
     return, search(root, val);
  }    

  public boolean search(Node root, int val) {
    Node current = root;
    while (current != null) {
        if (val == current.key) {
            return true; 
        } 
        else if (val < current.key) {
            current = current.left; 
        } 
        else {
            current = current.right; 
        }
    }
    
    return false; 
  }

  public void remove(int val){
       remove(root,val);
  }
  
  public Node remove(Node root,int val){
      if(root == null)
         return null;
      
      if(val<root.key)
        root.left = remove(root.left,val);
      else if(val>root.key)
        root.right = remove(root.right,val);
         
      else {
         if(root.left == null)
           return root.right;
         else if(root.right == null)
            return root.left;
         root.key = min(root.right);
         root.right = remove(root.right,root.key);
      }
      
      
       
      return root;
  }
  
  private int min(Node root){
     int minValue = root.key;
     while(root.left!=null){
        minValue = root.left.key;
        root = root.left;
      }
      return minValue;
   }     
         
 }
               
   
   
