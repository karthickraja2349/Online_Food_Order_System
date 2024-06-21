import java.util.*;

class Fine extends User{
  public static void main(String[]args){
       Bus bus1 = new Bus("Black","Diesel Engine","TN76 G 8172");
       
       Bus bus2 = new Bus("Green","Diesel Engine","Tn67 A 8897");
       
       LinkedList busList = new LinkedList();
       busList.add(bus1);
       busList.add(bus2);
       
      Bike bike1 = new Bike("Yellow","Petrol Engine","TN67 GG 2324");
       
      Bike bike2 = new Bike("Black" ,"Petrol Engine","TN79 A7 1234");
      
      LinkedList bikeList = new LinkedList();
      bikeList.add(bike1);
      bikeList.add(bike2);
       
       
     LinkedList l = new LinkedList();
     l.add(busList);
     l.add(bikeList);
    
    System.out.println(l);
    //l.add(bus1);
  
 }
}       
      
