public class HashSetDemo{
    public static void main(String[]args){
        HashSet h = new HashSet();
        h.add(0);
        h.add(1);
        h.add(-6);
        h.add(2636);
        h.add(23);
        h.add(-34);
        h.add(84);
        h.add(76);
        h.add(987);
        h.add(null);
        h.add("thy");
        h.remove(76);
        
        System.out.println(h);
        System.out.println(h.contains(3456));
        System.out.println(h.contains(null));
       // h.clear();
        System.out.println("--------");
        System.out.println(h);
        
        HashSet h1 = h.clone();
        System.out.println("--------");
        System.out.println("--------");
        System.out.println(h1);
        
        h.add("hello");
        System.out.println("h1 is "+ h1);
        System.out.println("h is " +h);
        
        h1.add("welcome");
        System.out.println("h1 is "+ h1);
        System.out.println("h is " +h);
        
        h1.add(h);
        System.out.println(h1);
        
        
        
        
    }
}
