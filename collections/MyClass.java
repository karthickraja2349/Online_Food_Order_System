public class MyClass extends BikeManager{
    public static void main(String[] args) {
        BusManager busManager = new BusManager();

        Bus bus1 = new Bus("Black", "Diesel Engine", "TN76 G 8172");
        Bus bus2 = new Bus("Green", "Diesel Engine", "Tn67 A 8897");

        busList.add(bus1);
        busList.add(bus2);
        System.out.println(busList);
     //    busManager.displayBuses();
        
        BikeManager bikeManager = new BikeManager();
        
        Bike bike1 = new Bike("Yellow","Petrol Engine", "TN67 GG 1234");
        Bike bike2 = new Bike("Black", "Electric Vehicle", "TN69 RR 2345");
        Bike bike3 = new Bike("white", "petrol Vehicle", "TN69 RR 2345");
        
       // bikeManager.addBike(bike1);
        bikeList.add(bike2);  
        bikeList.add(bike3);
        
        bikeList.remove(bike2);
        
        bikeList.add(bus1);
        bikeList.add(bus2);
        
        System.out.println(bikeList);
        
        //bikeManager.add(bike3); 
            

     //   busManager.displayBuses();
        
        System.out.println("---------------------------------------------");
        
     //   bikeManager.displayBikes();
        
        System.out.println("---------------------------------------------");
         
         bikeManager.removeBike(bike1);
      //   bikeManager.displayBikes();
         
      //   System.out.println(bikeManager.contains(bike2));
         
         
         
         
    }
}

