public class Bus extends Vehicle {
     String busNumber;

    public Bus(String colour, String type, String busNumber) {
        super(colour, type);
        this.busNumber = busNumber;
    }

    public String getBusNumber() {
        return "Bus Number is " + busNumber;
    }

    
    public String toString() {
        return "Bus Colour: " + Colour + ", Bus Type: " + Type + ", Bus Number: " + busNumber;
    }
}
