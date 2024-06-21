public class stackDemo{
    public static void main(String[]args){
        stack s1 = new stack();
        s1.push(5);
        s1.push(9);
        s1.push(23);
        s1.push(2);
        s1.push(11);
        s1.push(12);
        s1.push(13);
        s1.push(14);
        s1.push(15);
        s1.push(16);
        s1.push(12);
        s1.push(18);
        
        s1.pop();
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        
        System.out.println(s1.isEmpty());
        
        System.out.println(s1.size());
        
        System.out.println(s1.peek());
        
        s1.Search(9);
        s1.Search(11);
        s1.Search(2323);
        s1.Search(23456753);
        s1.Search(18);
        
    }
}
