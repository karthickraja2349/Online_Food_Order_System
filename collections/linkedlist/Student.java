class Student{
   int age;
   String name;
   
   public Student(int age){
      this.age=age;
   }
   
   public Student(String name){
      this.name=name;
   }
   
   public String toString(){
       return name;
  }     
   
   public static void main(String[]args){
      Student s1 = new Student(4);
      Student s2 = new Student("mani");
      Student s3 = new Student(9);
      Student s4 =new Student("pardeep");
      
      
      LinkedList l = new LinkedList() ;
      l.insertAtBeginning(s1);
      l.add(s2);
      l.add(s3);
      l.add(s4);
      
      System.out.println(l);
  } 
}
