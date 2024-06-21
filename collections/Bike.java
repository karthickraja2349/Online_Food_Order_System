class Bike extends Vehicle {
   String BikeNumber;
   
   public Bike(String Colour,String Type,String BikeNumber){
       super(Colour,Type);
       this.BikeNumber = BikeNumber;
  }                 
  
  public String getBikeNumber(){
    return "Bike Number is " + BikeNumber;
  }  
  
  public String toString(){
     return "Bike Colour is " + Colour+ "-" + "Bike Type is " + Type+ "-"+ "Bike Number is " +BikeNumber;
  }   
       
}  
