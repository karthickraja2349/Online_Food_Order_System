import java.util.*;
public class Employee{
     private String name;
     private int id;
      
     public Employee(String name , int id){
       this.name = name;
       this.id = id;
     }
     
     public static void main(String []args){
        Employee e1 = new Employee("karthick" , 8094);
        Employee e2 = new Employee("karthick" , 8094);
        
        Set Company = new HashSet();
        Company.add(e1);
        Company.add(e2);
        System.out.println(Company);
        
       
     }
     
     
     
     public String toString(){
       return "name is " + name + "-" + "id is " + id;
     // String s = Integer.toString(id);
     //String s = (String)name;
     // return s;
     }
     
     
     
    public int hashCode(){
       final int prime = 31;
       int result =1;
      // result = prime * result + ((name ==null) ? 0 : name.hashCode());
       result = prime*result + id;
       return result;
    }   
    
    public boolean equals(Object obj){
      if(this==obj)
        return true;
      if(obj==null)
        return false;
      if(getClass() != obj.getClass())
        return false;
      
      Employee next = (Employee)obj;
    /*  if(id != next.id)
       return false;
       
       
      if(name == null){
        if(next.name != null)
          return false;
      }   
      else if(!name.equals(next.name))
        return false;
      
     return true;     
    
  }   */   
  
}        
           
      
