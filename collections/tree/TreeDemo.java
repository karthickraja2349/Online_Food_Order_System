import java.util.*;
public class TreeDemo{
   public static void main(String[]args){
      TreeSet t = new TreeSet(80);
      t.add(40);
      t.add(50);
      t.add(100);
      t.add(98);
      t.add(500);
      t.add(0);
      t.add(0);
      t.add(120);
      t.add(30);
      
      System.out.println(t);
      System.out.println(t.search(500));
      System.out.println(t.search(50));
      System.out.println(t.search(0));
      
      t.remove(500);
     
      System.out.println(t);
   }
}      
