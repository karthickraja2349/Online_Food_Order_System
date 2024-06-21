public class DequeDemo{
   public static void main(String[]args){
      Deque d = new Deque();
      d.add(3);
      d.add(5);
      d.add(18);
      d.add(32);d.add(34);
      System.out.println(d);
      d.pollLast();
      System.out.println(d);
      d.pollFirst();
      System.out.println(d);
      
      
   }
}      
