class village{
   int ward_number;
   String street_name;
   
   public String toString(){
      return ward_number +  " " + street_name;
   }
   
   public village(int ward_number, String street_name){
       this.ward_number = ward_number;
       this.street_name = street_name;
    }
    
    
    public static void main(String[]args){
        village v1 = new village(12,"vinayagar kovil street");
        village v2 = new village(2,"murugan kovil street");
        
        LinkedHashMap l = new LinkedHashMap();
        l.put(1,v1);
        l.put(2,v2);
        System.out.println(l);
        
        System.out.println(l.keySet());
        
        System.out.println(l.values());
        
        System.out.println(l.get(2));
        
     }
     
 }             
