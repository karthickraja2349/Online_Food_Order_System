public class LinkedDemo {
    public static void main(String[] args) {
        LinkedHashMap h = new LinkedHashMap();
        h.put(1, "Mani");
        h.put(18, "aryan");
        h.put(3, "kkr");
        h.put(23, "gauti");
        h.put(63, "symonds");
        h.put(null,83);

        System.out.println(h.size());
        System.out.println(h.isEmpty());

        System.out.println(h.get(1));
        System.out.println(h);
        
        System.out.println(h.keySet());
        System.out.println(h.values());
        
        System.out.println(h.remove(3));
        
        h.replace(63,"zampa");
        System.out.println(h);
        
        
    }
}

