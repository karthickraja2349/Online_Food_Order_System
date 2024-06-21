import java.util.LinkedList;

public class BikeManager extends BusManager{
    public static LinkedList bikeList;

    public BikeManager() {
        this.bikeList = new LinkedList<>();
    }

    public static void addBike(Bike bike) {
        bikeList.add(bike);
    }

   /* public void displayBikes() {
        for (Bike bike : bikeList) {
            System.out.println(bike);
        }
    } */
    
    public boolean removeBike(Bike bike) {
        return bikeList.remove(bike);
    }
    
 /*   public boolean contains(Bike bike) {
    for (Bike b : bikeList) {
        if (b.equals(bike)) {
            return true; 
        }
    }
    return false;
} */   
    public void clear(){}


}

