public class TreeMapDemo{
      public static void main(String[]args){
          TreeMap t = new TreeMap();
          t.put(1,"mani");
          t.put(2,"aryan");
          t.put(3,"karupasamy");
          t.put(4,"maalikaipuram");
          t.put(78,"hello");
          System.out.println(t.get(2));
          //t.put(2,null);
          
          
          System.out.println(t.containsKey(78));
          System.out.println(t.containsKey(3));
          System.out.println(t);
       }
 }         
