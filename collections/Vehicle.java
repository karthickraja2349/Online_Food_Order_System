abstract class Vehicle {
     String Colour;
    String Type;
    
    
    public Vehicle(String Colour,String Type){
       this.Colour = Colour;
       this.Type = Type;
    }
    
    public String getColour(){
      return "Bus Colour is " + Colour;
    }
    
    public String getType(){
      return "Bus type is " + Type;
    }    
    
}






