package onlineFoodOrder.model;;
public class Food {
    private int food_Id;
    private String food_Name;
    private double food_Price;
    private String food_Type;
    private String food_Nature;
    private String quantity;
    
    private static Food food = null;
  

   
    private Food() {
    
    }
    public Food(String food_Name, double food_Price, String food_Type, String food_Nature,String quantity){
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_Type = food_Type;
        this.food_Nature = food_Nature;
        this.quantity = quantity;
    }    
   
    public Food(int food_Id, String food_Name, double food_Price, String food_Type, String food_Nature,String quantity) {
        this.food_Id = food_Id;
        this.food_Name = food_Name;
        this.food_Price = food_Price;
        this.food_Type = food_Type;
        this.food_Nature = food_Nature;
        this.quantity = quantity;
    }
    
   
    public static Food getFoodInstance() {
        if (food == null) {
            food = new Food();
        }
        return food;
    }
    
    
    
    
    public int getFoodId() {
        return food_Id;
    }
        
    public String getFoodName() {
        return food_Name;
    }
    
    public double getFoodPrice() {
        return food_Price;
    }
    
    public String getFoodType() {
        return food_Type;
    }
    
    public String getFoodNature() {
        return food_Nature;
    }
    
    public String getQuantity(){
        return quantity;
    }    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------\n");
        sb.append(String.format("| %-16s : %-20s |\n", "Food Id is", getFoodId()));
        sb.append(String.format("| %-16s : %-20s |\n", "Food Name is", getFoodName()));
        sb.append(String.format("| %-16s : %-20s |\n", "Food Price is", getFoodPrice()));
        sb.append(String.format("| %-16s : %-20s |\n", "Food Type is", getFoodType()));
        sb.append(String.format("| %-16s : %-20s |\n", "Food Nature is", getFoodNature()));
        sb.append(String.format("| %-16s : %-20s |\n", "Quantity is", getQuantity()));
        sb.append("-------------------------------------------\n");
        return sb.toString();
    }
}

