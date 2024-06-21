import java.util.*;
class Student{
    private int id;
    private String name;
    
    
    public Student(int id, String name){
        this.id=id;
        this.name=name;
        
    }
    
    public int getId(){
        return id;
    }
    
    public  String getName(){
        return name;
    }
    
     public String toString(){
        return getId() + " " + getName();
    }
    
}

public class hashMap {
     
      int i=1;
      
    public  int  keyGenerator(){
        return i++;
    }
   
    public static void main(String[] args) {
        
        hashMap own = new hashMap();
        
        Student s1 = new Student(1001, "karthick");
        Student s2 = new Student(1002, "atman");
        Student s3 = new Student(1003, "smith");
        Student s4 = new Student(1004, "starc");
        Student s5 = new Student(1005, "gilly");
        Student s6 = new Student(1006, "gillipse");
        Student s7 = new Student(1007, "carey");    
    
        
        HashMap m = new HashMap();
        m.put(own.keyGenerator(),s1);
        m.put(own.keyGenerator(),s2);
        m.put(own.keyGenerator(),s3);
        m.put(own.keyGenerator(),s4);
        m.put(own.keyGenerator(),s5);
        m.put(own.keyGenerator(),s6);
        m.put(own.keyGenerator(),s7);
        
        System.out.println(m);
        
        System.out.println(m.get(5));
        
        Set s = m.keySet();
        System.out.println(s);
        
       Set<Map.Entry> entryset = m.entrySet();
        for(Map.Entry entry:entryset){
            System.out.print(entry.getValue() + " ");
        }
    }
}    
