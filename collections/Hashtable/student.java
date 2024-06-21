public class student{
        int age;
        String name;
        
        
        public student(String name,int age){
            this.name= name;
            this.age=age;
        }
        
        public String toString(){
            return name + " " + age;
         }   
        
        
        public static void main(String[]args){
             student s1 = new student("mani",12);
             
             HashTable h = new HashTable();
             h.put(1,s1);
             System.out.println(h);
        }
        
}                  
