public class queueDemo{
   public static void main(String[]args){
       queue q1 = new queue();
       
       q1.enQueue(18);
       q1.enQueue(23);
       q1.enQueue(24);
       q1.enQueue(25);
       q1.enQueue(26);
       q1.enQueue(27);
       q1.enQueue(28);
       q1.enQueue(29);
       q1.enQueue(23);
       q1.enQueue(33);
       q1.enQueue(243);
       q1.enQueue(2213);
       
       
       System.out.println(q1.deQueue());
       
       System.out.println(q1.deQueue());
       
       System.out.println(q1.peek());
       
       System.out.println(q1.isEmpty());
       
    }
 }      
