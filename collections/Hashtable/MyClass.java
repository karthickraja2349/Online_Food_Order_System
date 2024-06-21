public class MyClass{
   public static void main(String[]args){
      HashTable h = new HashTable();
      System.out.println(h.size());
      System.out.println(h.isEmpty());
      
      h.put(1,"mani");
      System.out.println(h.size());
      System.out.println(h.isEmpty());
      
      h.put(18,"hariharasudhan");
      System.out.println(h.size());
      System.out.println(h.isEmpty());
      
      System.out.println("value of 1 is :" + h.get(1));
      System.out.println("value of 18 is :" + h.get(18));
      System.out.println("value of 12 is :" + h.get(2));
      
      h.put(2,null);
      System.out.println(h.remove(2));
      
      h.put(3,"aryan");
      h.put(51,"hello");
      h.put(47,"desk");
      h.put(95,"bench");
      h.put(6,"table");
      h.put(79,"chair");
      h.put(-1,"jsajs");
      h.put(2,"jjss");
      h.put(-2,"mine");
      h.put(2,"starc");
      h.put(250,"atman");
      
      h.put(565,"hello");
      h.put(0,"jfhhfhfhfhfhfhfhfhhf");
      h.put(null,6666666666666l);
      h.put(null,"ppppppppppppppppppppppppppppppppppp");
      h.replace(79,"smith");
      h.replace(null,"lollipop");
     // h.remove(null);
      System.out.println(h.keySet());
      
      System.out.println(h.values());
      System.out.println(h.size());
      
      
      
      System.out.println(h);
      
    //  h.clear();
      System.out.println(h.size());
      System.out.println(h.isEmpty());
      
      System.out.println(h.containsKey(3));
      System.out.println(h.containsKey(234567890));
      System.out.println(h.containsValue("lollipop"));
      
      
      
   }
  } 
  
           
