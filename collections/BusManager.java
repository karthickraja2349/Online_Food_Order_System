import java.util.LinkedList;

public class BusManager {
    static LinkedList busList;

    public BusManager() {
        this.busList = new LinkedList<>();
    }

    public void addBus(Bus bus) {
        busList.add(bus);
    }

   /* public void displayBuses() {
        for (Bus bus : busList) {
            System.out.println(bus);
        }
    }*/
}

